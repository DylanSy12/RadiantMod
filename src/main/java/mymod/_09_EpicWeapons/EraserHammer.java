package mymod._09_EpicWeapons;

import mymod.Main;
import mymod.CodakidFiles.Codakid;
import mymod._07_BuildAndBoom.EntityGodEraserGrenade;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EraserHammer extends ItemSword {
	
	public EraserHammer() {
		super(Main.myToolMaterial9);
		this.setCreativeTab(CreativeTabs.COMBAT);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand handIn){
		
		
		Vec3d blockHit = player.rayTrace(200, 1f).hitVec;
//		world.spawnEntity(new EntityGodEraserGrenade(world, player.posX = blockHit.x, player.posY = blockHit.y, player.posZ = blockHit.z));
//		Codakid.spawnEntity(world, blockHit.x, blockHit.y, blockHit.z, new EntityGodEraserGrenade(world));
		worldIn.spawnEntity(new EntityGodEraserGrenade(worldIn, blockHit.x, blockHit.y, blockHit.z));
		return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(handIn));
		
	}

}
