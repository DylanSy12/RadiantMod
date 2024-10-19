package mymod._09_EpicWeapons;

import mymod.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class RadiantLightningSword extends ItemSword {
	
	public RadiantLightningSword() {
		super(Main.radiantLightningSwordMaterial);
		this.setCreativeTab(CreativeTabs.COMBAT);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand handIn){
		
		
		Vec3d blockHit = player.rayTrace(200, 1f).hitVec;
		worldIn.spawnEntity(new EntityLightningBolt(worldIn, blockHit.x, blockHit.y, blockHit.z, false));
		worldIn.spawnEntity(new EntityLightningBolt(worldIn, blockHit.x, blockHit.y, blockHit.z, false));
		worldIn.spawnEntity(new EntityLightningBolt(worldIn, blockHit.x, blockHit.y, blockHit.z, false));
		worldIn.createExplosion(player, blockHit.x , blockHit.y, blockHit.z, 5f, false);
		return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(handIn));
		
	}

}
