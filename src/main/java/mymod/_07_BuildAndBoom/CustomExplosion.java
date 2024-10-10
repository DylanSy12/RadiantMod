package mymod._07_BuildAndBoom;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class CustomExplosion extends Item {
	private int power;
	public CustomExplosion(int power) {
//		this.setCreativeTab(CreativeTabs.COMBAT);
		this.power=power;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn){
		
		if(!worldIn.isRemote) {
			EntityCustomExplosion explosion = new EntityCustomExplosion(worldIn, playerIn,this.power);
			explosion.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, playerIn.getEyeHeight(), 0.9f, 0);
			worldIn.spawnEntity(explosion);
			playerIn.getHeldItem(handIn).shrink(1);
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
		
	}

}
