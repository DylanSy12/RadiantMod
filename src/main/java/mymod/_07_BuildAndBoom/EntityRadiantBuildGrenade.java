package mymod._07_BuildAndBoom;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityRadiantBuildGrenade extends EntityThrowable {

	public EntityRadiantBuildGrenade(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}

	public EntityRadiantBuildGrenade(World worldIn) {
		super(worldIn);
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		if (!this.world.isRemote) {
			if(result.entityHit == null) {
				int cube_size = 4;
				for(int z = 0; z < cube_size; z++) {
					for(int y = 0; y < cube_size; y++) {
						for(int x = 0; x < cube_size; x++) {
							world.setBlockState(new BlockPos(
									result.getBlockPos().getX() + x,
									result.getBlockPos().getY() + y,
									result.getBlockPos().getZ() + z), 
									Blocks.TNT.getDefaultState());
							world.setBlockState(new BlockPos(
									result.getBlockPos().getX() - x,
									result.getBlockPos().getY() - y,
									result.getBlockPos().getZ() - z), 
									Blocks.TNT.getDefaultState());
							world.setBlockState(new BlockPos(
									result.getBlockPos().getX() - x,
									result.getBlockPos().getY() + y,
									result.getBlockPos().getZ() - z), 
									Blocks.TNT.getDefaultState());
							world.setBlockState(new BlockPos(
									result.getBlockPos().getX() + x,
									result.getBlockPos().getY() - y,
									result.getBlockPos().getZ() + z), 
									Blocks.TNT.getDefaultState());
							world.setBlockState(new BlockPos(
									result.getBlockPos().getX() - x,
									result.getBlockPos().getY() + y,
									result.getBlockPos().getZ() + z), 
									Blocks.TNT.getDefaultState());
							world.setBlockState(new BlockPos(
									result.getBlockPos().getX() + x,
									result.getBlockPos().getY() + y,
									result.getBlockPos().getZ() - z), 
									Blocks.TNT.getDefaultState());
							world.setBlockState(new BlockPos(
									result.getBlockPos().getX() + x,
									result.getBlockPos().getY() - y,
									result.getBlockPos().getZ() - z), 
									Blocks.TNT.getDefaultState());
							world.setBlockState(new BlockPos(
									result.getBlockPos().getX() - x,
									result.getBlockPos().getY() - y,
									result.getBlockPos().getZ() + z), 
									Blocks.TNT.getDefaultState());
							world.setBlockState(new BlockPos(
									result.getBlockPos().getX(),
									result.getBlockPos().getY(),
									result.getBlockPos().getZ()), 
									Blocks.FIRE.getDefaultState());
						}
					}
				}
			}
			else {
				world.createExplosion(this, result.entityHit.posX, result.entityHit.posY, result.entityHit.posZ, 10, true);
			}
			this.setDead();
		}
	}
}
