package mymod._07_BuildAndBoom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityCustomExplosion extends EntityThrowable {
	private int power;
	public EntityCustomExplosion(World worldIn, EntityLivingBase throwerIn, int power) {
		super(worldIn, throwerIn);
		this.power=power;
	}

	public EntityCustomExplosion(World worldIn, int power) {
		super(worldIn);
		this.power=power;
	}
	
	public EntityCustomExplosion(World worldIn) {
		super(worldIn);
		this.power=5;
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		if (!this.world.isRemote) {
			if(result.entityHit == null) {
				world.createExplosion(this, result.getBlockPos().getX(), result.getBlockPos().getY(), result.getBlockPos().getZ(),  this.power, true);
			}
			else {
				world.createExplosion(this, result.entityHit.posX, result.entityHit.posY, result.entityHit.posZ, this.power, true);
			}
			this.setDead();
		}
	}
}
