package mymod._09_EpicWeapons;

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

public class LuckyBlockLauncher extends Item {
	
	public LuckyBlockLauncher() {
		this.setCreativeTab(CreativeTabs.COMBAT);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand handIn){
		
		
		if(!worldIn.isRemote) {
			EntityLuckyBlockTrail lavaTrail = new EntityLuckyBlockTrail(worldIn, player);
			lavaTrail.shoot(player, player.rotationPitch, player.rotationYaw, player.getEyeHeight(), 2f, 0);
			worldIn.spawnEntity(lavaTrail);
		}
		return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(handIn));
		
	}

}
