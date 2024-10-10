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

public class EntityGodEraserGrenade extends EntityThrowable {

	public EntityGodEraserGrenade(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}

	public EntityGodEraserGrenade(World worldIn) {
		super(worldIn);
	}
	
	public EntityGodEraserGrenade(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		if (!this.world.isRemote) {
			if(result.entityHit == null) {
				int cube_size = 25;
				BlockPos pos=new BlockPos(result.getBlockPos().getX(),result.getBlockPos().getY(),result.getBlockPos().getZ());
				for(int z = -cube_size; z <= cube_size; z++) {
					for(int y = cube_size; y >= -cube_size; y--) {
						for(int x = -cube_size; x <= cube_size; x++) {
							if (!(result.getBlockPos().getY()+y<0 || result.getBlockPos().getY()+y>255)) pos=new BlockPos(result.getBlockPos().getX()+x,result.getBlockPos().getY()+y,result.getBlockPos().getZ()+z);
							else if (result.getBlockPos().getY()+y<0) pos=new BlockPos(result.getBlockPos().getX()+x,0,result.getBlockPos().getZ()+z);
							else pos=new BlockPos(result.getBlockPos().getX()+x,255,result.getBlockPos().getZ()+z);
//							world.destroyBlock(pos, false);
//							world.setBlockState(pos, Blocks.AIR.getDefaultState());
//							world.notifyBlockUpdate(pos, world.getBlockState(pos), Blocks.AIR.getDefaultState(), 1 | 2 | 4);
//							world.tickUpdates(true);
							world.setBlockToAir(pos);
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
