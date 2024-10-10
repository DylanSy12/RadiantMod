package mymod._05_LuckyBlock;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

import mymod.CustomEvents;
import mymod._07_BuildAndBoom.SphereExplosion;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class EntityNuke extends EntityThrowable {
	
	public EntityNuke(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}

	public EntityNuke(World worldIn) {
		super(worldIn);
	}
	
	public EntityNuke(World worldIn, double xVelocity, double yVelocity, double zVelocity) {
		super(worldIn);
		this.setVelocity(xVelocity, yVelocity, zVelocity);
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		if (!this.world.isRemote) {
			if(result.entityHit == null) {
//				world.createExplosion(this, result.getBlockPos().getX(), result.getBlockPos().getY(), result.getBlockPos().getZ(), 127, true);
				BlockPos pos = new BlockPos(result.getBlockPos().getX(),result.getBlockPos().getY(),result.getBlockPos().getZ());
				int radius = 20;
				Explosion explosion = new Explosion(world, null, pos.getX(), pos.getY(), pos.getZ(), radius, false, true);
				SphereExplosion sphereExplosion = new SphereExplosion(pos, radius, explosion);
				CustomEvents.sphereExplosionList.add(sphereExplosion);
			}
			else {
				world.createExplosion(this, result.entityHit.posX, result.entityHit.posY, result.entityHit.posZ, 127, true);
			}
			this.setDead();
		}
	}

}
