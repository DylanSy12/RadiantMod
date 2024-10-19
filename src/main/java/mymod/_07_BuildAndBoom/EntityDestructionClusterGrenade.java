package mymod._07_BuildAndBoom;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityDestructionClusterGrenade extends EntityThrowable 
{
	int recursions = 0;
	public EntityDestructionClusterGrenade(World worldIn, double x, double y, double z, 
		double motX, double motY, double motZ, int recursions) 
	{
		super(worldIn, x, y, z);
		this.setVelocity(motX, motY, motZ);
		this.recursions = recursions;
	}
	
	public EntityDestructionClusterGrenade(World worldIn, EntityLivingBase throwerIn) 
	{
		super(worldIn, throwerIn);
	}

	public EntityDestructionClusterGrenade(World worldIn) 
	{
		super(worldIn);
	}

	@Override
	protected void onImpact(RayTraceResult result) 
	{
		if (!this.world.isRemote) 
		{
			Random rand = new Random();
			if(result.entityHit == null) 
			{
				world.createExplosion(this, result.getBlockPos().getX(), result.getBlockPos().getY(), result.getBlockPos().getZ(), 127, true);
				if (this.recursions <= 3) 
				{
					int number = 0;
					while(number < 4) 
					{
						world.spawnEntity(
							new EntityDestructionClusterGrenade(
								world, this.posX, this.posY, this.posZ, 
								rand.nextFloat()-0.5, this.motionY*-1, rand.nextFloat()-0.5, 
								this.recursions+1
							)
						);
						number += 1;
					}
				}
				else
				{
					int number = 0;
					while(number < 3) 
					{
						world.spawnEntity(
							new EntityGodClusterGrenade(
								world, this.posX, this.posY, this.posZ, 
								rand.nextFloat()-0.5, this.motionY*-1, rand.nextFloat()-0.5
							)
						);
						number += 1;
					}
				}
			}
			else {
				world.createExplosion(this, result.entityHit.posX, result.entityHit.posY, result.entityHit.posZ, 127, true);
				if (this.recursions <= 3) 
				{
					int number = 0;
					while(number < 4) 
					{
						world.spawnEntity(
							new EntityDestructionClusterGrenade(
								world, this.posX, this.posY, this.posZ, 
								rand.nextFloat()-0.5, this.motionY*-1, rand.nextFloat()-0.5, 
								this.recursions+1
							)
						);
						number += 1;
					}
				}
				else
				{
					int number = 0;
					while(number < 3) 
					{
						world.spawnEntity(
							new EntityGodClusterGrenade(
								world, this.posX, this.posY, this.posZ, 
								rand.nextFloat()-0.5, this.motionY*-1, rand.nextFloat()-0.5
							)
						);
						number += 1;
					}
				}
			}
			this.setDead();
		}
	}

}
