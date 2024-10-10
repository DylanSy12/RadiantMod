package mymod._05_LuckyBlock;


import java.util.Random;

import javax.annotation.Nullable;

import io.netty.handler.codec.http2.Http2FrameLogger.Direction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Rotation;
import net.minecraft.util.datafix.fixes.ItemIntIDToString;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.boss.dragon.phase.PhaseList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Rotations;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.client.gui.recipebook.*;
import net.minecraft.network.datasync.*;
import net.minecraft.item.crafting.*;
import net.minecraft.nbt.*;
import net.minecraft.util.registry.*;
import net.minecraftforge.common.crafting.*;
import net.minecraftforge.common.command.*;
import net.minecraft.command.*;
import net.minecraft.client.resources.data.*;
import net.minecraft.command.server.*;
import net.minecraftforge.fml.common.registry.*;
import net.minecraftforge.registries.*;
import scala.tools.nsc.symtab.classfile.ICodeReader;
import net.minecraftforge.fml.client.registry.*;
import mymod.Main;
import mymod.CodakidFiles.Codakid;
import mymod._01_ForgeYourSword.RadiantLord;
import mymod._04_CreateACreature.GodLord;
import mymod._04_CreateACreature.MysticalLord;
import mymod._07_BuildAndBoom.EntityBuildGrenade;
import mymod._07_BuildAndBoom.EntityClusterGrenade;
import mymod._07_BuildAndBoom.EntityEraserGrenade;
import mymod._07_BuildAndBoom.EntityGrenade;
import mymod._07_BuildAndBoom.EntityRecursiveClusterGrenade;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAppleGold;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemFirework;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LuckyBlock extends Block {
	
	public LuckyBlock() {
		super(Material.BARRIER);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setResistance(1024f);
		this.setLightLevel(0.75f);
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        if (worldIn.isBlockPowered(pos))
        {
           worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
        }
    }
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
		if (worldIn.isBlockPowered(pos))
        {
           worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
        }
    }
	
	
	@Override
	
	public void breakBlock(World world, BlockPos pos, IBlockState state)
	{
		Random rand = new Random();
		int number = rand.nextInt(277) + 1;
//		System.out.println(number);
//		number=60;
//		number=273;
		
		//10% chance for 64 diamonds
		if(number <= 2)
		{
			Codakid.spawnItem(world, pos, Items.DIAMOND, 64);
		}
		else if(number <= 8)
		{
			world.setBlockState(pos, Blocks.DIAMOND_BLOCK.getDefaultState());
		}
		else if(number <= 10)
		{
			Codakid.spawnEntity(world, pos, new EntityBuildGrenade(world));
		}
		else if(number <= 16)
		{
			world.setBlockState(pos, Blocks.EMERALD_BLOCK.getDefaultState());
		}
		else if(number <= 18)
		{
			Codakid.spawnEntity(world, pos, new EntityGrenade(world));
		}
		else if(number <= 19)
		{
			Codakid.spawnItem(world, pos, Main.myBoots, 1);
			Codakid.spawnItem(world, pos, Main.mySword, 1);
			Codakid.spawnItem(world, pos, Main.myChestplate, 1);
			Codakid.spawnItem(world, pos, Main.myHelmet, 1);
			Codakid.spawnItem(world, pos, Main.myLeggings, 1);
			Codakid.spawnItem(world, pos, Main.myIngot, 1);
			Codakid.spawnItem(world, pos, Main.myPickaxe, 1);
			Codakid.spawnBlock(world, pos, Main.myOre, 1);
			Codakid.spawnBlock(world, pos, Main.luckyBlock, 1);
			Codakid.spawnItem(world, pos, Main.myHammer, 1);
			Codakid.spawnItem(world, pos, Main.lavaLauncher, 1);
			Codakid.spawnItem(world, pos, Main.cowGun, 1);
			Codakid.spawnItem(world, pos, Main.myCustomGrenade, 1);
			Codakid.spawnItem(world, pos, Main.myClusterGrenade, 1);
			Codakid.spawnItem(world, pos, Main.myNuke, 1);
			Codakid.spawnItem(world, pos, Main.myBuildGrenade, 1);
			Codakid.spawnBlock(world, pos, Main.radiantBlock, 1);
			Codakid.spawnItem(world, pos, Main.myAxe, 1);
			Codakid.spawnItem(world, pos, Main.myShovel,1);
			Codakid.spawnItem(world, pos, Main.myHoe,1);
		}
		else if(number <= 23)
		{
			Codakid.spawnEntity(world, pos, new EntityEraserGrenade(world));
		}
		else if(number <= 25)
		{
			world.setBlockState(pos, Blocks.IRON_BLOCK.getDefaultState());

		}
		else if(number <= 27)
		{
			Codakid.spawnEntity(world, pos, new EntityRecursiveClusterGrenade(world));
		}
		else if(number <= 29)
		{
			for(int i = 0; i < 30; i++)
			{
				Codakid.spawnEntity(world, pos, new EntityTNTPrimed(world));
			}
		}
		else if(number <= 33)
		{
			world.setBlockState(pos.add(0,35,0), Main.mysticalLuckyBlockF.getDefaultState());
		}
		else if(number <= 37)
		{
			world.setBlockState(pos.add(0,35,0), Main.godLuckyBlockF.getDefaultState());
		}
		else if(number <= 40)
		{
			world.setBlockState(pos.add(0,35,0), Main.luckyBlockF.getDefaultState());
		}
		else if(number <= 43)
		{
			world.setBlockState(pos, Main.myOre.getDefaultState());
		}
		else if(number <= 47)
		{
			world.setBlockState(pos, Main.mysticalOre.getDefaultState());
		}
		else if(number <= 50)
		{
			world.setBlockState(pos, Main.godOre.getDefaultState());
		}
		else if(number <= 51)
		{
			world.setBlockState(pos, Blocks.BARRIER.getDefaultState());
		}
		//15% chance of spawning 7 barriers
		else if(number <= 56)
		{
			Codakid.spawnBlock(world, pos, Blocks.BARRIER, rand.nextInt(16)+1);
		}
		else if(number <= 60)
		{
			Codakid.spawnItem(world, pos, Items.DIAMOND, rand.nextInt(9)+8);
			Codakid.spawnItem(world, pos, Items.GOLD_INGOT, rand.nextInt(3)+7);
			Codakid.spawnItem(world, pos, Items.EMERALD, rand.nextInt(9)+6);
			Codakid.spawnItem(world, pos, Items.IRON_INGOT, rand.nextInt(6)+7);
			Codakid.spawnItem(world, pos, Items.COAL, rand.nextInt(6)+3);
			Codakid.spawnItem(world, pos, Items.QUARTZ, rand.nextInt(5)+4);
			Codakid.spawnItem(world, pos, Items.REDSTONE, rand.nextInt(5)+7);
			ItemStack lapis1=new ItemStack(Items.DYE,rand.nextInt(6)+6);
			lapis1.setItemDamage(4);
			world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), lapis1));
//			Codakid.spawnItem(world, pos, Items.DYE, 10);
//			NonNullList<ItemStack> stack1=OreDictionary.getOres("gemLapis");
//			Codakid.spawnItem(world, pos,stack1.get(4).getItem(),10);
//			Codakid.spawnItem(world, pos, Items.GOLD_NUGGET, 6);
//			Codakid.spawnItem(world, pos, Items.IRON_NUGGET, 6);
			Codakid.spawnItem(world, pos, Main.myIngot, rand.nextInt(5)+1);
			Codakid.spawnItem(world, pos, Main.mysticalIngot, rand.nextInt(4)+2);
			Codakid.spawnItem(world, pos, Main.godIngot, rand.nextInt(4));
			ItemStack stack = new ItemStack(new ItemFirework());
			for (int a=0;a<=(int) Math.random()*3+5;a++)
			{
				Codakid.spawnEntity(world, pos.add(Math.random()*3-1.5, 0, Math.random()*3-1.5), new EntityFireworkRocket(world, pos.getX()+Math.random()*4-2, pos.getY(), pos.getX()+Math.random()*4-2, stack));
			}
		}
		else if(number <= 63)
		{
			Codakid.spawnItem(world, pos, Items.GOLDEN_HORSE_ARMOR, 1);
			Codakid.spawnItem(world, pos, Items.GOLDEN_HELMET, 1);
			Codakid.spawnItem(world, pos, Items.GOLDEN_BOOTS, 1);
			Codakid.spawnItem(world, pos, Items.GOLDEN_LEGGINGS, 1);
			Codakid.spawnItem(world, pos, Items.GOLDEN_CHESTPLATE, 1);
			Codakid.spawnItem(world, pos, Items.GOLDEN_SWORD, 1);
		}
		else if(number <= 66)
		{
			Codakid.spawnItem(world, pos, Items.IRON_PICKAXE, 1);
			Codakid.spawnItem(world, pos, Items.IRON_AXE, 1);
			Codakid.spawnItem(world, pos, Items.IRON_SHOVEL, 1);
			Codakid.spawnItem(world, pos, Items.IRON_HOE, 1);
			Codakid.spawnItem(world, pos, Items.IRON_SWORD, 1);
		}
		else if(number <= 69)
		{
			Codakid.spawnItem(world, pos, Items.IRON_HORSE_ARMOR, 1);
			Codakid.spawnItem(world, pos, Items.GOLDEN_HORSE_ARMOR, 1);
			Codakid.spawnItem(world, pos, Items.DIAMOND_HORSE_ARMOR, 1);
		}
		else if(number <= 73)
		{
			Codakid.spawnBlock(world, pos, Blocks.SPONGE, rand.nextInt(6)+2);
		}
		else if(number <= 75)
		{
			Codakid.spawnBlock(world, pos, Blocks.ENDER_CHEST, rand.nextInt(3)+1);
		}
		else if(number <= 77)
		{
			Codakid.spawnBlock(world, pos, Blocks.TNT, rand.nextInt(8)+4);
		}
		
		//20% chance of spawning 20 eggs and diamonds
		else if(number <= 79)
		{
			for(int i = 0; i < rand.nextInt(20)+10; i++)
			{
				EntityEgg egg=new EntityEgg(world);
				egg.setVelocity(rand.nextInt(11)-5, rand.nextInt(11), rand.nextInt(10)-5);
				Codakid.spawnEntity(world, pos, egg);
				Codakid.spawnItem(world, pos, Items.DIAMOND, 1);
			}
		}
		
		else if(number <= 80)
		{
			world.setBlockState(pos, Blocks.DIAMOND_BLOCK.getDefaultState());
			for(int i = 0; i < 60; i++)
			{
				Codakid.spawnEntity(world, pos, new EntityTNTPrimed(world));
			}
		}
		else if(number <= 83)
		{
			Codakid.spawnBlock(world, pos, Blocks.END_PORTAL_FRAME, rand.nextInt(4)+2);
		}
		else if(number <= 86)
		{
			Codakid.spawnBlock(world, pos, Blocks.CAKE, rand.nextInt(3)+1);
		}
		else if(number <= 91)
		{
			for (int i=0;i<=rand.nextInt(100)+1;i++) {
				Codakid.spawnEntity(world, pos, new EntityCreeper(world));
			}
		}
		else if(number <= 94)
		{
			Codakid.spawnEntity(world, pos, new EntityWitch(world));
			Codakid.spawnEntity(world, pos, new EntityWitch(world));
			Codakid.spawnEntity(world, pos, new EntityWitch(world));
			Codakid.spawnEntity(world, pos, new EntityWitch(world));
		}
		
		//19% transform into obsidian
		else if(number <= 99)
		{
			world.setBlockState(pos, Blocks.OBSIDIAN.getDefaultState());
		}
		
		//1% chance spawn 7 lucky blocks
		else if(number <= 100)
		{
			Codakid.spawnBlock(world, pos, Main.godLuckyBlock, 7);
		}
		else if(number <= 103)
		{
			world.setBlockState(pos, Blocks.GOLD_BLOCK.getDefaultState());
		}
		else if(number <= 104)
		{
			EntityDragon dragon = new EntityDragon(world);
			dragon.getPhaseManager().setPhase(PhaseList.TAKEOFF);
			Codakid.spawnEntity(world, pos, dragon);
		}
		else if(number <= 105)
		{
			Codakid.spawnEntity(world, pos, new EntityWither(world));
		}
		else if(number <= 106)
		{
			Codakid.spawnBlock(world, pos, Blocks.BEACON, 1);
			Codakid.spawnBlock(world, pos, Blocks.DRAGON_EGG, 1);
			Codakid.spawnItem(world, pos, Items.NETHER_STAR, 1);
		}
		else if(number <= 108)
		{
			Codakid.spawnBlock(world, pos, Blocks.BEACON, 1);
		}
		else if(number <= 111)
		{
			Codakid.spawnBlock(world, pos, Blocks.DRAGON_EGG, 1);
		}
		else if(number <= 115)
		{
			Codakid.spawnItem(world, pos, Items.NETHER_STAR, 1);
		}
		else if(number <= 118)
		{
			Codakid.spawnItem(world, pos, Items.GUNPOWDER, 5);
			Codakid.spawnBlock(world, pos, Blocks.TNT, 12);
			Codakid.spawnItem(world, pos, Main.myIngot, 67);
			Codakid.spawnItem(world, pos, Items.DIAMOND, 31);
			Codakid.spawnItem(world, pos, Items.NETHER_STAR, 18);
			Codakid.spawnItem(world, pos, Items.BLAZE_ROD, 12);
			Codakid.spawnItem(world, pos, Items.LAVA_BUCKET, 3);
			Codakid.spawnBlock(world, pos, Blocks.DROPPER, 1);
		}
		else if(number <= 120)
		{
//			Codakid.spawnEntity(world, pos, new EntityNuke(world));
		}
		else if(number <= 125)
		{
			for(int i = 0; i < rand.nextInt(65)+1; i++) 
			{
				Codakid.spawnBlock(world, pos, Blocks.BLACK_GLAZED_TERRACOTTA, 1);
				Codakid.spawnBlock(world, pos, Blocks.BLUE_GLAZED_TERRACOTTA, 1);
				Codakid.spawnBlock(world, pos, Blocks.BROWN_GLAZED_TERRACOTTA, 1);
				Codakid.spawnBlock(world, pos, Blocks.YELLOW_GLAZED_TERRACOTTA, 1);
				Codakid.spawnBlock(world, pos, Blocks.RED_GLAZED_TERRACOTTA, 1);
				Codakid.spawnBlock(world, pos, Blocks.ORANGE_GLAZED_TERRACOTTA, 1);
				Codakid.spawnBlock(world, pos, Blocks.CYAN_GLAZED_TERRACOTTA, 1);
				Codakid.spawnBlock(world, pos, Blocks.GRAY_GLAZED_TERRACOTTA, 1);
				Codakid.spawnBlock(world, pos, Blocks.GREEN_GLAZED_TERRACOTTA, 1);
				Codakid.spawnBlock(world, pos, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, 1);
				Codakid.spawnBlock(world, pos, Blocks.LIME_GLAZED_TERRACOTTA, 1);
				Codakid.spawnBlock(world, pos, Blocks.MAGENTA_GLAZED_TERRACOTTA, 1);
				Codakid.spawnBlock(world, pos, Blocks.PINK_GLAZED_TERRACOTTA, 1);
				Codakid.spawnBlock(world, pos, Blocks.PURPLE_GLAZED_TERRACOTTA, 1);
				Codakid.spawnBlock(world, pos, Blocks.SILVER_GLAZED_TERRACOTTA, 1);
				Codakid.spawnBlock(world, pos, Blocks.WHITE_GLAZED_TERRACOTTA, 1);
			}
		}
		else if(number <= 130)
		{
			Codakid.spawnBlock(world, pos, Blocks.BRICK_BLOCK, rand.nextInt(16)+1);
		}
		else if(number <= 135)
		{
			Codakid.spawnBlock(world, pos, Blocks.DIAMOND_BLOCK, rand.nextInt(16)+1);
		}
		else if(number <= 140)
		{
			Codakid.spawnBlock(world, pos, Blocks.EMERALD_BLOCK, rand.nextInt(16)+1);
		}
		else if(number <= 145)
		{
			Codakid.spawnBlock(world, pos, Blocks.ICE, rand.nextInt(32)+1);
		}
		else if(number <= 150)
		{
			world.setBlockState(pos, Blocks.CHEST.getDefaultState());
		}
		else if(number <= 155)
		{
			Codakid.spawnBlock(world, pos, Blocks.BEDROCK, rand.nextInt(16)+1);
		}
		else if(number <= 160)
		{
			world.setBlockState(pos, Blocks.COAL_BLOCK.getDefaultState());
		}
		else if(number <= 165)
		{
			Codakid.spawnBlock(world, pos, Blocks.HAY_BLOCK, rand.nextInt(32)+1);
		}
		else if(number <= 170)
		{
			world.setBlockState(pos, Blocks.LAPIS_BLOCK.getDefaultState());
		}
		else if(number <= 175)
		{
			world.setBlockState(pos, Blocks.REDSTONE_BLOCK.getDefaultState());
		}
		else if(number <= 180)
		{
			for(int i = 0; i < 50; i++) 
			{
				Codakid.spawnEntity(world, pos, new EntityExpBottle(world));
			}
		}
		else if(number <= 185)
		{
			for(int i = 0; i < rand.nextInt(65)+1; i++) 
			{
				Codakid.spawnBlock(world, pos, Blocks.QUARTZ_ORE, 1);
				Codakid.spawnBlock(world, pos, Blocks.QUARTZ_BLOCK, 1);
				Codakid.spawnBlock(world, pos, Blocks.QUARTZ_STAIRS, 1);
				Codakid.spawnItem(world, pos, Items.QUARTZ, 1);
			}
		}
		else if(number <= 190)
		{
			Codakid.spawnBlock(world, pos, Main.luckyBlock, 64);
		}
		else if(number <= 195)
		{
			Codakid.spawnItem(world, pos, Items.APPLE, 1);
			Codakid.spawnBlock(world, pos, Blocks.GOLD_BLOCK, 8);
			Codakid.spawnItem(world, pos, Items.GOLDEN_APPLE, rand.nextInt(10)+1);
//			Codakid.spawnItem(world, pos, ItemAppleGold.getByNameOrId("minecraft:golden_apple"), 1);
//			Codakid.spawnItem(world, pos, ItemAppleGold.getByNameOrId("minecraft:enchanted_golden_apple"), 1);
//			Codakid.spawnItem(world, pos, ItemAppleGold.getByNameOrId("322:1"), 1);
//			Codakid.spawnItem(world, pos, ItemAppleGold.getItemById(1), 1);
			
		}
		else if(number <= 200)
		{
			Codakid.spawnItem(world, pos, Items.ENDER_PEARL, 16);
			Codakid.spawnItem(world, pos, Items.ENDER_EYE, 64);
		}
		else if(number <= 205)
		{
			Codakid.spawnBlock(world, pos, Blocks.ANVIL, 1);
			Codakid.spawnBlock(world, pos, Blocks.BREWING_STAND, 1);
			Codakid.spawnBlock(world, pos, Blocks.BOOKSHELF, 15);
			Codakid.spawnBlock(world, pos, Blocks.COMMAND_BLOCK, 1);
			Codakid.spawnBlock(world, pos, Blocks.CRAFTING_TABLE, 1);
			Codakid.spawnBlock(world, pos, Blocks.BED, 1);
			Codakid.spawnBlock(world, pos, Blocks.ENCHANTING_TABLE, 1);
			Codakid.spawnBlock(world, pos, Blocks.ENDER_CHEST, 1);
			Codakid.spawnBlock(world, pos, Blocks.CHAIN_COMMAND_BLOCK, 1);
			Codakid.spawnBlock(world, pos, Blocks.CHEST, 1);
			Codakid.spawnBlock(world, pos, Blocks.FURNACE, 1);
			Codakid.spawnBlock(world, pos, Blocks.STRUCTURE_BLOCK, 1);
			Codakid.spawnBlock(world, pos, Blocks.YELLOW_SHULKER_BOX, 1);
			Codakid.spawnBlock(world, pos, Blocks.CAULDRON, 1);
			Codakid.spawnBlock(world, pos, Blocks.REPEATING_COMMAND_BLOCK, 1);
		}
		else if(number <= 210)
		{
			for(int i = 0; i < rand.nextInt(64)+1; i++)
			{
				Codakid.spawnBlock(world, pos, Blocks.REDSTONE_BLOCK, 1);
				Codakid.spawnBlock(world, pos, Blocks.REDSTONE_LAMP, 1);
				Codakid.spawnBlock(world, pos, Blocks.REDSTONE_ORE, 1);
				Codakid.spawnBlock(world, pos, Blocks.REDSTONE_TORCH, 1);
				Codakid.spawnItem(world, pos, Items.REDSTONE, 1);
				Codakid.spawnBlock(world, pos, Blocks.ACTIVATOR_RAIL, 1);
				Codakid.spawnBlock(world, pos, Blocks.RAIL, 1);
				Codakid.spawnBlock(world, pos, Blocks.DETECTOR_RAIL, 1);
				Codakid.spawnBlock(world, pos, Blocks.GOLDEN_RAIL, 1);
				Codakid.spawnBlock(world, pos, Blocks.COMMAND_BLOCK, 1);
				Codakid.spawnBlock(world, pos, Blocks.CHAIN_COMMAND_BLOCK, 1);
				Codakid.spawnBlock(world, pos, Blocks.REPEATING_COMMAND_BLOCK, 1);
				Codakid.spawnBlock(world, pos, Blocks.DISPENSER, 1);
				Codakid.spawnBlock(world, pos, Blocks.DROPPER, 1);
				Codakid.spawnBlock(world, pos, Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, 1);
				Codakid.spawnBlock(world, pos, Blocks.IRON_TRAPDOOR, 1);
				Codakid.spawnBlock(world, pos, Blocks.IRON_DOOR, 1);
				Codakid.spawnBlock(world, pos, Blocks.LEVER, 1);
				Codakid.spawnBlock(world, pos, Blocks.NOTEBLOCK, 1);
				Codakid.spawnBlock(world, pos, Blocks.OBSERVER, 1);
				Codakid.spawnBlock(world, pos, Blocks.TNT, 1);
				Codakid.spawnBlock(world, pos, Blocks.WOODEN_BUTTON, 1);
				Codakid.spawnBlock(world, pos, Blocks.STONE_BUTTON, 1);
				Codakid.spawnBlock(world, pos, Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE, 1);
				Codakid.spawnBlock(world, pos, Blocks.STONE_PRESSURE_PLATE, 1);
				Codakid.spawnBlock(world, pos, Blocks.WOODEN_PRESSURE_PLATE, 1);
				Codakid.spawnBlock(world, pos, Blocks.DAYLIGHT_DETECTOR, 1);
				Codakid.spawnBlock(world, pos, Blocks.HOPPER, 1);
				Codakid.spawnBlock(world, pos, Blocks.PISTON, 1);
				Codakid.spawnBlock(world, pos, Blocks.STICKY_PISTON, 1);
				Codakid.spawnBlock(world, pos, Blocks.TRIPWIRE_HOOK, 1);
				Codakid.spawnItem(world, pos, Items.REPEATER, 1);
				Codakid.spawnItem(world, pos, Items.COMPARATOR, 1);
			}
		}
		else if(number <= 215)
		{
			Codakid.spawnBlock(world, pos, Blocks.COMMAND_BLOCK, 1);
			Codakid.spawnBlock(world, pos, Blocks.CHAIN_COMMAND_BLOCK, 1);
			Codakid.spawnBlock(world, pos, Blocks.STRUCTURE_BLOCK, 1);
			Codakid.spawnBlock(world, pos, Blocks.REPEATING_COMMAND_BLOCK, 1);
			Codakid.spawnBlock(world, pos, Blocks.MOB_SPAWNER, 1);
			Codakid.spawnBlock(world, pos, Blocks.BARRIER, 1);
			Codakid.spawnBlock(world, pos, Blocks.STRUCTURE_VOID, 1);
		}
		else if(number <= 220)
		{
			for(int i = 0; i < 16; i++)
			{
				Codakid.spawnBlock(world, pos, Blocks.BREWING_STAND, 1);
				Codakid.spawnBlock(world, pos, Blocks.CAULDRON, 1);
				Codakid.spawnItem(world, pos, Items.BUCKET, 1);
				Codakid.spawnItem(world, pos, Items.GLASS_BOTTLE, 1);
				Codakid.spawnItem(world, pos, Items.NETHER_WART, 1);
				Codakid.spawnItem(world, pos, Items.BLAZE_POWDER, 1);
				Codakid.spawnItem(world, pos, Items.SPECKLED_MELON, 1);
				Codakid.spawnItem(world, pos, Items.SUGAR, 1);
				Codakid.spawnItem(world, pos, Items.GOLDEN_CARROT, 1);
				Codakid.spawnItem(world, pos, Items.FERMENTED_SPIDER_EYE, 1);
				Codakid.spawnItem(world, pos, Items.GHAST_TEAR, 1);
				Codakid.spawnItem(world, pos, Items.SPIDER_EYE, 1);
				Codakid.spawnItem(world, pos, Items.REDSTONE, 1);
				Codakid.spawnItem(world, pos, Items.DRAGON_BREATH, 1);
				Codakid.spawnItem(world, pos, Items.GLOWSTONE_DUST, 1);
				Codakid.spawnItem(world, pos, Items.MAGMA_CREAM, 1);
//				Codakid.spawnItem(world, pos, ItemFishFood.getByNameOrId("minecraft:pufferfish"), 1);
//				Codakid.spawnItem(world, pos, ItemFishFood.getByNameOrId("minecraft:fish"), 1);
//				Codakid.spawnItem(world, pos, ItemFishFood.getByNameOrId("349:3"), 1);
//				Codakid.spawnItem(world, pos, ItemFishFood.getItemById(3), 1);
//				Codakid.spawnItem(world, pos, ItemFishFood.getIdFromItem(Items.FISH.getByNameOrId("minecraft:pufferfish")), 1);
				Codakid.spawnItem(world, pos, Items.GUNPOWDER, 1);
				Codakid.spawnItem(world, pos, Items.RABBIT_FOOT, 1);
			}
		}
		else if(number <= 225)
		{
			for(int i = 0; i < rand.nextInt(32)+1; i++)
			{
//				Codakid.spawnItem(world, pos, Items.FISH.getItemById(349), 1);
//				Codakid.spawnItem(world, pos, Items.FISH.getItemById(349), 1);
//				Codakid.spawnItem(world, pos, ItemFishFood.getByNameOrId("minecraft:pufferfish"), 1);
//				Codakid.spawnItem(world, pos, ItemFishFood.getByNameOrId("minecraft:fish"), 1);
//				Codakid.spawnItem(world, pos, ItemFishFood.getByNameOrId("349:3"), 1);
				Codakid.spawnItem(world, pos, Items.FISH, 1);
			}
		}
		else if(number <= 230)
		{
			for(int i = 0; i < rand.nextInt(16)+1; i++)
			{
//				Codakid.spawnBlock(world, pos, Blocks.RED_FLOWER.getBlockById(38), 1);
//				Codakid.spawnBlock(world, pos, Blocks.RED_FLOWER.getBlockById(38), 1);
//				Codakid.spawnBlock(world, pos, Blocks.RED_FLOWER.getBlockById(38), 1);
//				Codakid.spawnBlock(world, pos, Blocks.RED_FLOWER.getBlockById(38), 1);
//				Codakid.spawnBlock(world, pos, Blocks.RED_FLOWER.getBlockById(38), 1);
//				Codakid.spawnBlock(world, pos, Blocks.RED_FLOWER.getBlockById(38), 1);
//				Codakid.spawnBlock(world, pos, Blocks.RED_FLOWER.getBlockById(38), 1);
//				Codakid.spawnBlock(world, pos, Blocks.RED_FLOWER.getBlockFromName("minecraft:blue_orchid"), 1);
				Codakid.spawnBlock(world, pos, Blocks.RED_FLOWER, 1);
				Codakid.spawnBlock(world, pos, Blocks.YELLOW_FLOWER, 1);
			}
		}
		else if(number <= 235)
		{
			Codakid.spawnItem(world, pos, Items.SADDLE, rand.nextInt(3)+1);
		}
		
		else if(number <= 240)
		{
			world.setBlockState(pos, Main.mysticalSmallStructure.getDefaultState());
		}
		else if(number <= 245)
		{
			world.setBlockState(pos, Main.myStructure.getDefaultState());
		}
		else if(number <= 250)
		{
			world.setBlockState(pos, Main.godSmallStructure.getDefaultState());
		}
		else if(number <= 255)
		{
			Codakid.spawnEntity(world, pos, new GodLord(world));
			Codakid.spawnEntity(world, pos, new RadiantLord(world));
			Codakid.spawnEntity(world, pos, new MysticalLord(world));
		}
		else if(number <= 260)
		{
			Codakid.spawnEntity(world, pos, new RadiantLord(world));
		}
		else if(number <= 265)
		{
			Codakid.spawnEntity(world, pos, new MysticalLord(world));
		}
		else if(number <= 270)
		{
			Codakid.spawnEntity(world, pos, new GodLord(world));
		}
		else if(number <=274)
		{
			if (world.isAnyPlayerWithinRangeAt(pos.getX(), pos.getY(), pos.getZ(), 15)) {
				float p=world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 15, false).rotationYaw;
				if (p>135 || p<-135) {
					world.setBlockState(pos, Blocks.TRAPPED_CHEST.getDefaultState().withRotation(Rotation.CLOCKWISE_180));
				}
				else if (p>45 && p<135) {
					world.setBlockState(pos, Blocks.TRAPPED_CHEST.getDefaultState().withRotation(Rotation.CLOCKWISE_90));
				}
				else if (p>-45 && p<45) {
					world.setBlockState(pos, Blocks.TRAPPED_CHEST.getDefaultState());
				}
				else if (p>-135 && p<-45) {
					world.setBlockState(pos, Blocks.TRAPPED_CHEST.getDefaultState().withRotation(Rotation.COUNTERCLOCKWISE_90));
				}
				else return;
				world.setBlockState(pos.add(0,-2,0), Blocks.TNT.getDefaultState());
			}
		}
		
		
	}
}