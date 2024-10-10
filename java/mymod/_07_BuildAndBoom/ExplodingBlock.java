package mymod._07_BuildAndBoom;


import java.util.Random;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
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
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ExplodingBlock extends Block {
	private float explosionPower;
	public ExplodingBlock(float explosionPower) {
		super(Material.TNT);
//		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setResistance(1f);
		this.setLightLevel(0f);
		this.explosionPower = explosionPower;
	}
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
//		worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
		Explosion explosion = worldIn.newExplosion(null, pos.getX(), pos.getY(), pos.getZ(), this.explosionPower, true, true);
		worldIn.setBlockToAir(pos);
		System.out.println(this.explosionPower);
		System.out.println(state);
		System.out.println(explosion);
		System.out.println(pos);
    }
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) 
	{
		Explosion explosion = worldIn.newExplosion(null, pos.getX(), pos.getY(), pos.getZ(), this.explosionPower, true, true);
		worldIn.setBlockToAir(pos);
		System.out.println(this.explosionPower);
		System.out.println(state);
		System.out.println(explosion);
		System.out.println(pos);
	}
	@Override
	public boolean requiresUpdates()
    {
        return true;
    }

    @Override
    public boolean canDropFromExplosion(Explosion explosionIn)
    {
        return false;
    }
    @Override
    public int tickRate(World worldIn)
    {
        return 1;
    }
}