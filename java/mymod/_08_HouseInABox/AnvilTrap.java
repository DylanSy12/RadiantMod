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

public class AnvilTrap extends Block {
	public AnvilTrap() {
		super(Material.ROCK);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		for (int x=-2;x<=2;x++) {
			for (int z=-2;z<=2;z++) {
				world.setBlockState(pos.add(x,-2,z), Blocks.BARRIER.getDefaultState());
				world.setBlockState(pos.add(x,2,z), Blocks.BARRIER.getDefaultState());
				for (int y=-1;y<=1;y++) {
					if (x!=0 || z!=0) {
						world.setBlockState(pos.add(x,y,z), Blocks.BARRIER.getDefaultState());
					}
					else world.setBlockState(pos.add(x,y,z), Blocks.AIR.getDefaultState());
				}
			}
		}
		
		
		
	}
	
	
	
	
}
