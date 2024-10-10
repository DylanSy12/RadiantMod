package mymod._07_BuildAndBoom;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import mymod.CustomEvents;
import mymod.Main;
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

public class EntityEraserGrenade extends EntityThrowable {

	public EntityEraserGrenade(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}

	public EntityEraserGrenade(World worldIn) {
		super(worldIn);
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		Random rand = new Random();
		if (!this.world.isRemote) {
			if(result.entityHit == null) {
				int cube_size = 15;
				BlockPos pos = new BlockPos(result.getBlockPos().getX(),result.getBlockPos().getY(),result.getBlockPos().getZ());
				for(int z = -cube_size; z <= cube_size; z++) {
					for(int y = cube_size; y >= -cube_size; y--) {
						for(int x = -cube_size; x <= cube_size; x++) {
							if (!(result.getBlockPos().getY()+y<0 || result.getBlockPos().getY()+y>255)) pos=new BlockPos(result.getBlockPos().getX()+x,result.getBlockPos().getY()+y,result.getBlockPos().getZ()+z);
							else if (result.getBlockPos().getY()+y<0) pos=new BlockPos(result.getBlockPos().getX()+x,0,result.getBlockPos().getZ()+z);
							else pos=new BlockPos(result.getBlockPos().getX()+x,255,result.getBlockPos().getZ()+z);
//							world.setBlockState(pos, Blocks.AIR.getDefaultState());
//							world.notifyBlockUpdate(pos, world.getBlockState(pos), Blocks.AIR.getDefaultState(), 1 | 2 | 4);
//							world.tickUpdates(true);
							IBlockState block=world.getBlockState(pos);
							if (block!=Main.godLuckyBlock.getDefaultState() && block!=Main.luckyBlock.getDefaultState() && block!=Main.mysticalLuckyBlock.getDefaultState()) {
								world.setBlockToAir(pos);
							}
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
