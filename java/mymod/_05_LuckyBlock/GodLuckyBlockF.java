package mymod._05_LuckyBlock;


import java.util.Random;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import mymod.Main;
import mymod.CodakidFiles.Codakid;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GodLuckyBlockF extends BlockFalling {
	
	public GodLuckyBlockF() {
		super(Material.BARRIER);
		
		this.setResistance(1024f);
		this.setLightLevel(1f);
	}
	
	@Override
	public void onEndFalling(World worldIn, BlockPos pos, IBlockState p_176502_3_, IBlockState p_176502_4_)
    {
		worldIn.setBlockState(pos,Main.godLuckyBlock.getDefaultState());
    }
	@Override
	public void onBroken(World world, BlockPos pos) {
		Codakid.spawnBlock(world, pos, Main.godLuckyBlock, 1);
	}
//	public void 

}
