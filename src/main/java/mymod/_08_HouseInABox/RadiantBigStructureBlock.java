package mymod._08_HouseInABox;

import java.util.ArrayList;

import mymod.Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing.AxisDirection;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockDirectional;

public class RadiantBigStructureBlock extends Block {
	
	IBlockState L = Main.luckyBlock.getDefaultState();
	IBlockState O = Main.myOre.getDefaultState();
	IBlockState R = Main.radiantBlock.getDefaultState();
	IBlockState C = Blocks.CHEST.getDefaultState();
	IBlockState A = Blocks.AIR.getDefaultState();
	IBlockState S = Blocks.RED_SANDSTONE.getDefaultState();
	
	ArrayList<IBlockState> blueprint = new ArrayList();
	
	public RadiantBigStructureBlock() {
		super(Material.ROCK);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		blueprint.add(L);
		blueprint.add(A);
		blueprint.add(O);
		blueprint.add(A);
		blueprint.add(R);
		blueprint.add(A);
		blueprint.add(C);
		
		
		
		
		
	}
	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
//		for(int y = 0; y < blueprint.size(); y++)
//		{
//			world.setBlockState(pos.add(0, y, 0), blueprint.get(y));
//		}
		world.setBlockState(pos, Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(0, 0, 1), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(1, 0, 1), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(1, 0, 0), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(1, 0, -1), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(0, 0, -1), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(-1, 0, -1), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(-1, 0, 0), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(-1, 0, 1), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(0, 0, 2), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(2, 0, 2), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(2, 0, 0), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(2, 0, -2), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(0, 0, -2), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(-2, 0, -2), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(-2, 0, 0), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(-2, 0, 2), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(-2, 0, 1), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(2, 0, 1), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(2, 0, -1), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(-2, 0, -1), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(1, 0, 2), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(-1, 0, 2), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(1, 0, -2), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(-1, 0, -2), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(-3, 0, -3), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(3, 0, -3), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(3, 0, 3), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(-3, 0, 3), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(-3, 0, 0), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(3, 0, 0), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(0, 0, -3), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(0, 0, 3), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(-3, 0, 2), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(-3, 0, 1), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(-3, 0, -2), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(-3, 0, -1), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(3, 0, 2), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(3, 0, 1), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(3, 0, -2), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(3, 0, -1), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(2, 0, -3), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(1, 0, -3), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(-2, 0, -3), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(-1, 0, -3), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(2, 0, 3), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(1, 0, 3), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(-2, 0, 3), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(-1, 0, 3), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(-3, 1, -3), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(3, 1, -3), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(3, 1, 3), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(-3, 1, 3), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(-3, 2, -3), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(3, 2, -3), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(3, 2, 3), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(-3, 2, 3), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(-3, 3, -3), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(3, 3, -3), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(3, 3, 3), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(-3, 3, 3), Blocks.RED_SANDSTONE.getDefaultState());
		world.setBlockState(pos.add(-3, 4, -3), Main.radiantBlock.getDefaultState());
		world.setBlockState(pos.add(3, 4, -3), Main.radiantBlock.getDefaultState());
		world.setBlockState(pos.add(3, 4, 3), Main.radiantBlock.getDefaultState());
		world.setBlockState(pos.add(-3, 4, 3), Main.radiantBlock.getDefaultState());
		world.setBlockState(pos.add(0, 4, 0), Main.radiantBlock.getDefaultState());
		world.setBlockState(pos.add(2, 1, -2), Main.luckyBlock.getDefaultState());
		world.setBlockState(pos.add(2, 1, 2), Main.luckyBlock.getDefaultState());
		world.setBlockState(pos.add(-2, 1, 2), Main.luckyBlock.getDefaultState());
		world.setBlockState(pos.add(-2, 1, -2), Main.luckyBlock.getDefaultState());
		world.setBlockState(pos.add(0, 1, -2), Main.luckyBlock.getDefaultState());
		world.setBlockState(pos.add(0, 1, 2), Main.luckyBlock.getDefaultState());
		world.setBlockState(pos.add(-2, 1, 0), Main.luckyBlock.getDefaultState());
		world.setBlockState(pos.add(2, 1, 0), Main.luckyBlock.getDefaultState());
		world.setBlockState(pos.add(-3, 1, 2), Blocks.RED_SANDSTONE_STAIRS.getDefaultState());
		world.setBlockState(pos.add(-3, 1, 1), Blocks.RED_SANDSTONE_STAIRS.getDefaultState());
		world.setBlockState(pos.add(-3, 1, -2), Blocks.RED_SANDSTONE_STAIRS.getDefaultState());
		world.setBlockState(pos.add(-3, 1, -1), Blocks.RED_SANDSTONE_STAIRS.getDefaultState());
		world.setBlockState(pos.add(3, 1, 2), Blocks.RED_SANDSTONE_STAIRS.getDefaultState());
		world.setBlockState(pos.add(3, 1, 1), Blocks.RED_SANDSTONE_STAIRS.getDefaultState());
		world.setBlockState(pos.add(3, 1, -2), Blocks.RED_SANDSTONE_STAIRS.getDefaultState());
		world.setBlockState(pos.add(3, 1, -1), Blocks.RED_SANDSTONE_STAIRS.getDefaultState());
		world.setBlockState(pos.add(2, 1, -3), Blocks.RED_SANDSTONE_STAIRS.getDefaultState());
		world.setBlockState(pos.add(1, 1, -3), Blocks.RED_SANDSTONE_STAIRS.getDefaultState());
		world.setBlockState(pos.add(-2, 1, -3), Blocks.RED_SANDSTONE_STAIRS.getDefaultState());
		world.setBlockState(pos.add(-1, 1, -3), Blocks.RED_SANDSTONE_STAIRS.getDefaultState());
		world.setBlockState(pos.add(2, 1, 3), Blocks.RED_SANDSTONE_STAIRS.getDefaultState());
		world.setBlockState(pos.add(1, 1, 3), Blocks.RED_SANDSTONE_STAIRS.getDefaultState());
		world.setBlockState(pos.add(-2, 1, 3), Blocks.RED_SANDSTONE_STAIRS.getDefaultState());
		world.setBlockState(pos.add(-1, 1, 3), Blocks.RED_SANDSTONE_STAIRS.getDefaultState());
	}
	
	
	
	
}
