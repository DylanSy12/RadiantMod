package mymod._05_LuckyBlock;

import mymod.Main;
import mymod.CodakidFiles.Codakid;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CustomFalling extends BlockFalling{
	private Block block;
	public CustomFalling(Block block) {
		super(Material.IRON);
		this.block=block;
//		this.extends block;
	}
	@Override
	public void onEndFalling(World worldIn, BlockPos pos, IBlockState p_176502_3_, IBlockState p_176502_4_)
    {
		worldIn.setBlockState(pos,this.block.getDefaultState());
//		worldIn.spawnParticle(particleType, pos.getX(), pos.getY(), pos.getZ(), 3, 3, 3, parameters);
    }
	@Override
	public void onBroken(World world, BlockPos pos) {
		Codakid.spawnBlock(world, pos, this.block, 1);
	}
}
