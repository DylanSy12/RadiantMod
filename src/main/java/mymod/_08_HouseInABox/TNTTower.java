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

public class TNTTower extends Block {
	
	IBlockState L = Main.radiantLuckyBlock.getDefaultState();
	IBlockState O = Main.radiantOre.getDefaultState();
	IBlockState R = Main.radiantBlock.getDefaultState();
	IBlockState C = Blocks.CHEST.getDefaultState();
	IBlockState A = Blocks.AIR.getDefaultState();
	IBlockState S = Blocks.RED_SANDSTONE.getDefaultState();
	IBlockState Y = Blocks.TNT.getDefaultState();
	
	ArrayList<IBlockState> blueprint = new ArrayList();
	
	public TNTTower() {
		super(Material.ROCK);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		blueprint.add(Y);

		
		
		
		
		
	}
	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		for(int y = -255; y < 255; y++)
		{
			world.setBlockState(pos.add(0, y, 0), Y);
		}
		
		
	}
	
	
	
	
}
