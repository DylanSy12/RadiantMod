package mymod._09_EpicWeapons;

import java.util.Random;

import mymod._05_LuckyBlock.EntityNuke;
import mymod._07_BuildAndBoom.EntityBuildGrenade;
import mymod._07_BuildAndBoom.EntityClusterGrenade;
import mymod._07_BuildAndBoom.EntityEraserGrenade;
import mymod._07_BuildAndBoom.EntityGodBuildGrenade;
import mymod._07_BuildAndBoom.EntityGodEraserGrenade;
import mymod._07_BuildAndBoom.EntityGrenade;
import mymod._07_BuildAndBoom.EntityRecursiveClusterGrenade;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class BoomGun extends Item {
	
	public BoomGun() {
		this.setCreativeTab(CreativeTabs.COMBAT);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand handIn){
		
		
		Random rand = new Random();
		if(!worldIn.isRemote) {
			
			EntityNuke newCow = new EntityNuke(worldIn);
			newCow.setPosition(player.posX + 1, player.posY, player.posZ);
			newCow.motionX = player.getLookVec().x * 8 + rand.nextInt(3) - 1;
			newCow.motionY = player.getLookVec().y * 3 + rand.nextInt(3) - 1;
			newCow.motionZ = player.getLookVec().z * 8 + rand.nextInt(3) - 1;
			worldIn.spawnEntity(newCow);
			EntityGodBuildGrenade newGrenade = new EntityGodBuildGrenade(worldIn);
			newGrenade.setPosition(player.posX + 1, player.posY, player.posZ + 1);
			newGrenade.motionX = player.getLookVec().x * 8 + rand.nextInt(3) - 1;
			newGrenade.motionY = player.getLookVec().y * 3 + rand.nextInt(3) - 1;
			newGrenade.motionZ = player.getLookVec().z * 8 + rand.nextInt(3) - 1;
			worldIn.spawnEntity(newGrenade);
			EntityClusterGrenade newBoom = new EntityClusterGrenade(worldIn);
			newBoom.setPosition(player.posX, player.posY, player.posZ + 1);
			newBoom.motionX = player.getLookVec().x * 8 + rand.nextInt(3) - 1;
			newBoom.motionY = player.getLookVec().y * 3 + rand.nextInt(3) - 1;
			newBoom.motionZ = player.getLookVec().z * 8 + rand.nextInt(3) - 1;
			worldIn.spawnEntity(newBoom);
			EntityGrenade newDoom = new EntityGrenade(worldIn);
			newDoom.setPosition(player.posX - 1, player.posY, player.posZ + 1);
			newDoom.motionX = player.getLookVec().x * 8 + rand.nextInt(3) - 1;
			newDoom.motionY = player.getLookVec().y * 3 + rand.nextInt(3) - 1;
			newDoom.motionZ = player.getLookVec().z * 8 + rand.nextInt(3) - 1;
			worldIn.spawnEntity(newDoom);
			EntityBuildGrenade newBang = new EntityBuildGrenade(worldIn);
			newBang.setPosition(player.posX - 1, player.posY, player.posZ);
			newBang.motionX = player.getLookVec().x * 8 + rand.nextInt(3) - 1;
			newBang.motionY = player.getLookVec().y * 3 + rand.nextInt(3) - 1;
			newBang.motionZ = player.getLookVec().z * 8 + rand.nextInt(3) - 1;
			worldIn.spawnEntity(newBang);
			EntityGodEraserGrenade newPoof = new EntityGodEraserGrenade(worldIn);
			newPoof.setPosition(player.posX - 1, player.posY, player.posZ - 1);
			newPoof.motionX = player.getLookVec().x * 8 + rand.nextInt(3) - 1;
			newPoof.motionY = player.getLookVec().y * 3 + rand.nextInt(3) - 1;
			newPoof.motionZ = player.getLookVec().z * 8 + rand.nextInt(3) - 1;
			worldIn.spawnEntity(newPoof);
			EntityEraserGrenade newBam = new EntityEraserGrenade(worldIn);
			newBam.setPosition(player.posX, player.posY, player.posZ - 1);
			newBam.motionX = player.getLookVec().x * 8 + rand.nextInt(3) - 1;
			newBam.motionY = player.getLookVec().y * 3 + rand.nextInt(3) - 1;
			newBam.motionZ = player.getLookVec().z * 8 + rand.nextInt(3) - 1;
			worldIn.spawnEntity(newBam);
			EntityRecursiveClusterGrenade newSplit = new EntityRecursiveClusterGrenade(worldIn);
			newSplit.setPosition(player.posX, player.posY, player.posZ - 1);
			newSplit.motionX = player.getLookVec().x * 8 + rand.nextInt(3) - 1;
			newSplit.motionY = player.getLookVec().y * 3 + rand.nextInt(3) - 1;
			newSplit.motionZ = player.getLookVec().z * 8 + rand.nextInt(3) - 1;
			worldIn.spawnEntity(newSplit);
		}
		return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(handIn));
		
	}

}
