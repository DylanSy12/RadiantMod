package mymod._07_BuildAndBoom;

import mymod.CodakidFiles.Codakid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityDestructionEraserGrenade extends EntityThrowable {

	public EntityDestructionEraserGrenade(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}

	public EntityDestructionEraserGrenade(World worldIn) {
		super(worldIn);
	}
	
	public EntityDestructionEraserGrenade(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		if (!this.world.isRemote) {
			if(result.entityHit == null) {
				
				world.setBlockState(new BlockPos(
						result.getBlockPos().getX() + 2,
						result.getBlockPos().getY() + 2,
						result.getBlockPos().getZ() + 2), 
						Blocks.DIRT.getDefaultState());
				for(int i = 0; i < 150; i++)
				{
				world.spawnEntity(new EntityTNTPrimed(world, result.getBlockPos().getX()+2, result.getBlockPos().getY()+2, result.getBlockPos().getZ()+2, thrower));
				world.spawnEntity(new EntityTNTPrimed(world, result.getBlockPos().getX()+2, result.getBlockPos().getY()+2, result.getBlockPos().getZ()+2, thrower));
			
				}
				world.setBlockState(new BlockPos(
						result.getBlockPos().getX() - 2,
						result.getBlockPos().getY() - 2,
						result.getBlockPos().getZ() - 2), 
						Blocks.DIRT.getDefaultState());
				for(int i = 0; i < 150; i++)
				{
				world.spawnEntity(new EntityTNTPrimed(world, result.getBlockPos().getX()-2, result.getBlockPos().getY()-2, result.getBlockPos().getZ()-2, thrower));
				world.spawnEntity(new EntityTNTPrimed(world, result.getBlockPos().getX()-2, result.getBlockPos().getY()-2, result.getBlockPos().getZ()-2, thrower));
			
				}
				world.setBlockState(new BlockPos(
						result.getBlockPos().getX() - 2,
						result.getBlockPos().getY() + 2,
						result.getBlockPos().getZ() - 2), 
						Blocks.DIRT.getDefaultState());
				for(int i = 0; i < 150; i++)
				{
				world.spawnEntity(new EntityTNTPrimed(world, result.getBlockPos().getX()-2, result.getBlockPos().getY()+2, result.getBlockPos().getZ()-2, thrower));
				world.spawnEntity(new EntityTNTPrimed(world, result.getBlockPos().getX()-2, result.getBlockPos().getY()+2, result.getBlockPos().getZ()-2, thrower));
			
				}
				world.setBlockState(new BlockPos(
						result.getBlockPos().getX() + 2,
						result.getBlockPos().getY() - 2,
						result.getBlockPos().getZ() + 2), 
						Blocks.DIRT.getDefaultState());
				for(int i = 0; i < 150; i++)
				{
				world.spawnEntity(new EntityTNTPrimed(world, result.getBlockPos().getX()+2, result.getBlockPos().getY()-2, result.getBlockPos().getZ()+2, thrower));
				world.spawnEntity(new EntityTNTPrimed(world, result.getBlockPos().getX()+2, result.getBlockPos().getY()-2, result.getBlockPos().getZ()+2, thrower));
			
				}
				world.setBlockState(new BlockPos(
						result.getBlockPos().getX() - 2,
						result.getBlockPos().getY() + 2,
						result.getBlockPos().getZ() + 2), 
						Blocks.DIRT.getDefaultState());
				for(int i = 0; i < 150; i++)
				{
				world.spawnEntity(new EntityTNTPrimed(world, result.getBlockPos().getX()-2, result.getBlockPos().getY()+2, result.getBlockPos().getZ()+2, thrower));
				world.spawnEntity(new EntityTNTPrimed(world, result.getBlockPos().getX()-2, result.getBlockPos().getY()+2, result.getBlockPos().getZ()+2, thrower));
			
				}
				world.setBlockState(new BlockPos(
						result.getBlockPos().getX() + 2,
						result.getBlockPos().getY() + 2,
						result.getBlockPos().getZ() - 2), 
						Blocks.DIRT.getDefaultState());
				for(int i = 0; i < 150; i++)
				{
				world.spawnEntity(new EntityTNTPrimed(world, result.getBlockPos().getX()+2, result.getBlockPos().getY()+2, result.getBlockPos().getZ()-2, thrower));
				world.spawnEntity(new EntityTNTPrimed(world, result.getBlockPos().getX()+2, result.getBlockPos().getY()+2, result.getBlockPos().getZ()-2, thrower));
			
				}
				world.setBlockState(new BlockPos(
						result.getBlockPos().getX() + 2,
						result.getBlockPos().getY() - 2,
						result.getBlockPos().getZ() - 2), 
						Blocks.DIRT.getDefaultState());
				for(int i = 0; i < 150; i++)
				{
				world.spawnEntity(new EntityTNTPrimed(world, result.getBlockPos().getX()+2, result.getBlockPos().getY()-2, result.getBlockPos().getZ()-2, thrower));
				world.spawnEntity(new EntityTNTPrimed(world, result.getBlockPos().getX()+2, result.getBlockPos().getY()-2, result.getBlockPos().getZ()-2, thrower));
			
				}
				world.setBlockState(new BlockPos(
						result.getBlockPos().getX() - 2,
						result.getBlockPos().getY() - 2,
						result.getBlockPos().getZ() + 2), 
						Blocks.DIRT.getDefaultState());
				for(int i = 0; i < 150; i++)
				{
				world.spawnEntity(new EntityTNTPrimed(world, result.getBlockPos().getX()-2, result.getBlockPos().getY()-2, result.getBlockPos().getZ()+2, thrower));
				world.spawnEntity(new EntityTNTPrimed(world, result.getBlockPos().getX()-2, result.getBlockPos().getY()-2, result.getBlockPos().getZ()+2, thrower));
			
				}
				for(int i = 0; i < 100; i++)
//				for(int i = 0; i <1000000; i++)
				{
					world.spawnEntity(new EntityTNTPrimed(world, result.getBlockPos().getX(), result.getBlockPos().getY(), result.getBlockPos().getZ(), thrower));
					world.spawnEntity(new EntityTNTPrimed(world, result.getBlockPos().getX(), result.getBlockPos().getY(), result.getBlockPos().getZ(), thrower));
			
				}
			}	
			else {
				world.createExplosion(this, result.entityHit.posX, result.entityHit.posY, result.entityHit.posZ, 100, true);
				//world.spawnEntity(new EntityTNTPrimed())
			}
			this.setDead();
		}
	}

//	private BlockPos pos(int x, int y, int z) {
		// TODO Auto-generated method stub
//		return null;
//	}
}
