package mymod._08_HouseInABox;

import java.util.ArrayList;

import mymod.Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MysticalSmallStructureBlock extends Block {
	
	IBlockState L = Main.mysticalLuckyBlock.getDefaultState();
	IBlockState O = Main.mysticalOre.getDefaultState();
	IBlockState M = Main.mysticalBlock.getDefaultState();
	IBlockState C = Blocks.CHEST.getDefaultState();
	IBlockState A = Blocks.AIR.getDefaultState();
	IBlockState P = Blocks.PURPUR_BLOCK.getDefaultState();
	
	ArrayList<IBlockState> blueprint = new ArrayList();
	
	public MysticalSmallStructureBlock() {
		super(Material.ROCK);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		blueprint.add(P);
		blueprint.add(L);
		blueprint.add(A);
		blueprint.add(O);
		blueprint.add(A);
		blueprint.add(M);
		blueprint.add(A);
		blueprint.add(C);
		
		
		
		
		
	}
	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
//		for(int y = 0; y < blueprint.size(); y++)
//		{
//			world.setBlockState(pos.add(0, y, 0), blueprint.get(y));
//		}
		for (int x=-2;x<=2;x++) {
			for (int z=-2;z<=2;z++) {
				for (int y=0;y<=2;y++) {
					IBlockState block=world.getBlockState(pos.add(x, y, z));
					if (block!=Main.godLuckyBlock.getDefaultState() && block!=Main.radiantLuckyBlock.getDefaultState() && block!=Main.mysticalLuckyBlock.getDefaultState()) {
						world.setBlockState(pos.add(x, y, z), Blocks.PURPUR_BLOCK.getDefaultState());
						if (y!=0) {
							if (x>-2 && x<2 && z>-2 && z<2) {
								world.setBlockState(pos.add(x, y, z), Blocks.AIR.getDefaultState());
								if (x!=0 && z!=0 && y==1) {
									world.setBlockState(pos.add(x, y, z), Main.mysticalLuckyBlock.getDefaultState());
								}
							}
						}
					}
				}
				if((x==-2 || x==2) && (z==-2 || z==2)) {
					world.setBlockState(pos.add(x, 3, z), Main.mysticalBlock.getDefaultState());
				}
			}
		}
	}
	
	
	
	
}
