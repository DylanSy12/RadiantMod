package mymod._09_EpicWeapons;

import java.util.Random;

import mymod._05_LuckyBlock.EntityNuke;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityDragonFireball;
import net.minecraft.entity.projectile.EntityShulkerBullet;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class LevitationGun extends Item {
	
	public LevitationGun() {
		this.setCreativeTab(CreativeTabs.COMBAT);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand handIn){
		
		
		Random rand = new Random();
		if(!worldIn.isRemote) {
			for(int number = 0; number < 10; number++) {
				EntityShulkerBullet newCow = new EntityShulkerBullet(worldIn);
				newCow.setPosition(player.posX, player.posY, player.posZ);
				newCow.motionX = player.getLookVec().x * 8 + rand.nextInt(3) - 1;
				newCow.motionY = player.getLookVec().y * 3 + rand.nextInt(3) - 1;
				newCow.motionZ = player.getLookVec().z * 8 + rand.nextInt(3) - 1;
				worldIn.spawnEntity(newCow);
			}
		}
		return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(handIn));
		
	}

}
