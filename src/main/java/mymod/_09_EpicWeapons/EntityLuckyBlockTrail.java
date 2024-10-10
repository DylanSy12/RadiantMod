package mymod._09_EpicWeapons;

import mymod.Main;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityLuckyBlockTrail extends EntityThrowable {

	public EntityLuckyBlockTrail(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		world.setBlockState(new BlockPos(this.lastTickPosX, this.lastTickPosY, this.lastTickPosZ), Main.luckyBlock.getDefaultState());
		world.setBlockState(new BlockPos(this.lastTickPosX, this.lastTickPosY - 1, this.lastTickPosZ), Main.mysticalLuckyBlock.getDefaultState());
		world.setBlockState(new BlockPos(this.lastTickPosX, this.lastTickPosY + 1, this.lastTickPosZ), Main.godLuckyBlock.getDefaultState());
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		this.setDead();
	}

}
