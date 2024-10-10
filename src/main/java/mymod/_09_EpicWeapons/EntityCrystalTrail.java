package mymod._09_EpicWeapons;

import mymod.CodakidFiles.Codakid;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityCrystalTrail extends EntityThrowable {

	public EntityCrystalTrail(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		Codakid.spawnEntity(world, new BlockPos(this.lastTickPosX, this.lastTickPosY, this.lastTickPosZ), new EntityEnderCrystal(world));
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		this.setDead();
	}

}
