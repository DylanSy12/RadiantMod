package mymod._09_EpicWeapons;

import java.util.Random;

import mymod._05_LuckyBlock.EntityNuke;
import mymod._07_BuildAndBoom.EntityRadiantBuildGrenade;
import mymod._07_BuildAndBoom.EntityRadiantClusterGrenade;
import mymod._07_BuildAndBoom.EntityMysticalEraserGrenade;
import mymod._07_BuildAndBoom.EntityGodBuildGrenade;
import mymod._07_BuildAndBoom.EntityGodEraserGrenade;
import mymod._07_BuildAndBoom.EntityRadiantGrenade;
import mymod._07_BuildAndBoom.EntityGodClusterGrenade;
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

public class GodGrenadeGun extends Item {
	
	public GodGrenadeGun() {
		this.setCreativeTab(CreativeTabs.COMBAT);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand handIn){
		
		
		Random rand = new Random();
		if(!worldIn.isRemote) {
			
			EntityNuke newNuke = new EntityNuke(worldIn);
			newNuke.setPosition(player.posX + 1, player.posY, player.posZ);
			newNuke.motionX = player.getLookVec().x * 8 + rand.nextInt(3) - 1;
			newNuke.motionY = player.getLookVec().y * 3 + rand.nextInt(3) - 1;
			newNuke.motionZ = player.getLookVec().z * 8 + rand.nextInt(3) - 1;
			worldIn.spawnEntity(newNuke);
			EntityGodBuildGrenade newGodBuildGrenade = new EntityGodBuildGrenade(worldIn);
			newGodBuildGrenade.setPosition(player.posX + 1, player.posY, player.posZ + 1);
			newGodBuildGrenade.motionX = player.getLookVec().x * 8 + rand.nextInt(3) - 1;
			newGodBuildGrenade.motionY = player.getLookVec().y * 3 + rand.nextInt(3) - 1;
			newGodBuildGrenade.motionZ = player.getLookVec().z * 8 + rand.nextInt(3) - 1;
			worldIn.spawnEntity(newGodBuildGrenade);
			EntityRadiantClusterGrenade newRadiantClusterGrenade = new EntityRadiantClusterGrenade(worldIn);
			newRadiantClusterGrenade.setPosition(player.posX, player.posY, player.posZ + 1);
			newRadiantClusterGrenade.motionX = player.getLookVec().x * 8 + rand.nextInt(3) - 1;
			newRadiantClusterGrenade.motionY = player.getLookVec().y * 3 + rand.nextInt(3) - 1;
			newRadiantClusterGrenade.motionZ = player.getLookVec().z * 8 + rand.nextInt(3) - 1;
			worldIn.spawnEntity(newRadiantClusterGrenade);
			EntityRadiantGrenade newRadiantGrenade = new EntityRadiantGrenade(worldIn);
			newRadiantGrenade.setPosition(player.posX - 1, player.posY, player.posZ + 1);
			newRadiantGrenade.motionX = player.getLookVec().x * 8 + rand.nextInt(3) - 1;
			newRadiantGrenade.motionY = player.getLookVec().y * 3 + rand.nextInt(3) - 1;
			newRadiantGrenade.motionZ = player.getLookVec().z * 8 + rand.nextInt(3) - 1;
			worldIn.spawnEntity(newRadiantGrenade);
			EntityRadiantBuildGrenade newRadiantBuildGrenade = new EntityRadiantBuildGrenade(worldIn);
			newRadiantBuildGrenade.setPosition(player.posX - 1, player.posY, player.posZ);
			newRadiantBuildGrenade.motionX = player.getLookVec().x * 8 + rand.nextInt(3) - 1;
			newRadiantBuildGrenade.motionY = player.getLookVec().y * 3 + rand.nextInt(3) - 1;
			newRadiantBuildGrenade.motionZ = player.getLookVec().z * 8 + rand.nextInt(3) - 1;
			worldIn.spawnEntity(newRadiantBuildGrenade);
			EntityGodEraserGrenade newGodEraserGrenade = new EntityGodEraserGrenade(worldIn);
			newGodEraserGrenade.setPosition(player.posX - 1, player.posY, player.posZ - 1);
			newGodEraserGrenade.motionX = player.getLookVec().x * 8 + rand.nextInt(3) - 1;
			newGodEraserGrenade.motionY = player.getLookVec().y * 3 + rand.nextInt(3) - 1;
			newGodEraserGrenade.motionZ = player.getLookVec().z * 8 + rand.nextInt(3) - 1;
			worldIn.spawnEntity(newGodEraserGrenade);
			EntityMysticalEraserGrenade newMysticalEraserGrenade = new EntityMysticalEraserGrenade(worldIn);
			newMysticalEraserGrenade.setPosition(player.posX, player.posY, player.posZ - 1);
			newMysticalEraserGrenade.motionX = player.getLookVec().x * 8 + rand.nextInt(3) - 1;
			newMysticalEraserGrenade.motionY = player.getLookVec().y * 3 + rand.nextInt(3) - 1;
			newMysticalEraserGrenade.motionZ = player.getLookVec().z * 8 + rand.nextInt(3) - 1;
			worldIn.spawnEntity(newMysticalEraserGrenade);
			EntityGodClusterGrenade newGodClusterGrenade = new EntityGodClusterGrenade(worldIn);
			newGodClusterGrenade.setPosition(player.posX, player.posY, player.posZ - 1);
			newGodClusterGrenade.motionX = player.getLookVec().x * 8 + rand.nextInt(3) - 1;
			newGodClusterGrenade.motionY = player.getLookVec().y * 3 + rand.nextInt(3) - 1;
			newGodClusterGrenade.motionZ = player.getLookVec().z * 8 + rand.nextInt(3) - 1;
			worldIn.spawnEntity(newGodClusterGrenade);
		}
		return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(handIn));
		
	}

}
