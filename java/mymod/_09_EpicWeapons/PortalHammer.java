package mymod._09_EpicWeapons;

import java.util.ArrayList;
import java.util.List;

import mymod.Main;
import mymod._07_BuildAndBoom.EntityGodEraserGrenade;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class PortalHammer extends ItemSword {
	
	public PortalHammer() {
		super(Main.myToolMaterial8);
		this.setCreativeTab(CreativeTabs.COMBAT);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand handIn){
		
		double d = 50;
		Vec3d blockHit = player.rayTrace(d, 1f).hitVec;
		while (
			worldIn.getBlockState(new BlockPos(blockHit.x,blockHit.y,blockHit.z)) != Blocks.AIR.getDefaultState() && 
			worldIn.getBlockState(new BlockPos(blockHit.x,blockHit.y,blockHit.z)) != Blocks.WATER.getDefaultState() &&
			worldIn.getBlockState(new BlockPos(blockHit.x,blockHit.y,blockHit.z)) != Blocks.FLOWING_WATER.getDefaultState() && 
			worldIn.getBlockState(new BlockPos(blockHit.x,blockHit.y,blockHit.z)) != Blocks.LAVA.getDefaultState() &&
			worldIn.getBlockState(new BlockPos(blockHit.x,blockHit.y,blockHit.z)) != Blocks.FLOWING_LAVA.getDefaultState() && 
			d > 0
		) {
			d--;
			if (d == 0) {
				return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(handIn));
			}
			blockHit = player.rayTrace(d, 1f).hitVec;
		}
		player.setPosition(blockHit.x, blockHit.y, blockHit.z);
//		player.attemptTeleport(blockHit.x, blockHit.y, blockHit.z);
//		if (blockHit.y>254){
//			BlockPos pos = new BlockPos(blockHit.x,252,blockHit.z);
//			IBlockState block = worldIn.getBlockState(pos);
//			if (block==Blocks.AIR.getDefaultState()) {
//				worldIn.setBlockState(pos,Blocks.DIRT.getDefaultState());
//			}
//			player.attemptTeleport(blockHit.x, 254, blockHit.z);
//			if (block==Blocks.AIR.getDefaultState()) {
//				worldIn.setBlockState(pos,block);
//			}
//		}
//		else {
//			BlockPos pos = new BlockPos(blockHit.x,blockHit.y-2,blockHit.z);
//			IBlockState block = worldIn.getBlockState(pos);
//			if (block==Blocks.AIR.getDefaultState()) {
//				worldIn.setBlockState(pos,Blocks.DIRT.getDefaultState());
//			}
//			player.attemptTeleport(blockHit.x, blockHit.y, blockHit.z);
//			if (block==Blocks.AIR.getDefaultState()) {
//				worldIn.setBlockState(pos,block);
//			}
//		}
		
		return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(handIn));
		
		
	}

}
