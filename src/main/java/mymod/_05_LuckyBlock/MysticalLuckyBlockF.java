package mymod._05_LuckyBlock;


import java.util.Random;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import mymod.Main;
import mymod.CodakidFiles.Codakid;
import mymod._01_ForgeYourSword.RadiantLord;
import mymod._04_CreateACreature.GodLord;
import mymod._04_CreateACreature.MysticalLord;
import mymod._07_BuildAndBoom.EntityBuildGrenade;
import mymod._07_BuildAndBoom.EntityClusterGrenade;
import mymod._07_BuildAndBoom.EntityEraserGrenade;
import mymod._07_BuildAndBoom.EntityGrenade;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.BlockObsidian;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MysticalLuckyBlockF extends BlockFalling {
	
	public MysticalLuckyBlockF() {
		super(Material.BARRIER);
		
		this.setResistance(1024f);
		this.setLightLevel(0.5f);
	}
	
	
	
//	@Override
//	public void breakBlock(World world, BlockPos pos, IBlockState state)
//	{
//		Random rand = new Random();
//		int number = rand.nextInt(245) + 1;
//		System.out.println(number);
//		
//		//10% chance for 64 diamonds
//		if(number <= 4)
//		{
//			Codakid.spawnItem(world, pos, Items.DIAMOND, 64);
//		}
//		else if(number <= 8)
//		{
//			world.setBlockState(pos, Blocks.DIAMOND_BLOCK.getDefaultState());
//		}
//		else if(number <= 10)
//		{
//			Codakid.spawnEntity(world, pos, new EntityBuildGrenade(world));
//		}
//		else if(number <= 12)
//		{
//			world.setBlockState(pos, Blocks.EMERALD_BLOCK.getDefaultState());
//		}
//		else if(number <= 16)
//		{
//			Codakid.spawnEntity(world, pos, new EntityGrenade(world));
//		}
//		else if(number <= 24)
//		{
//			Codakid.spawnItem(world, pos, Main.mysticalBoots, 1);
//			Codakid.spawnItem(world, pos, Main.mysticalSword, 1);
//			Codakid.spawnItem(world, pos, Main.mysticalChestplate, 1);
//			Codakid.spawnItem(world, pos, Main.mysticalHelmet, 1);
//			Codakid.spawnItem(world, pos, Main.mysticalLeggings, 1);
//			Codakid.spawnItem(world, pos, Main.mysticalIngot, 1);
//			Codakid.spawnItem(world, pos, Main.mysticalPickaxe, 1);
//			Codakid.spawnBlock(world, pos, Main.mysticalOre, 1);
//			Codakid.spawnBlock(world, pos, Main.mysticalLuckyBlock, 1);
//			Codakid.spawnItem(world, pos, Main.portalHammer, 1);
//			Codakid.spawnItem(world, pos, Main.crystalLauncher, 1);
//			Codakid.spawnItem(world, pos, Main.nukeGun, 1);
//			Codakid.spawnItem(world, pos, Main.eraserGrenade, 1);
//			Codakid.spawnBlock(world, pos, Main.mysticalBlock, 1);
//		}
//		else if(number <= 33)
//		{
//			Codakid.spawnEntity(world, pos, new EntityEraserGrenade(world));
//		}
//		else if(number <= 35)
//		{
//			for(int i = 0; i < 25; i++)
//			{
//				Codakid.spawnEntity(world, pos, new EntityTNTPrimed(world));
//			}
//		}
//		else if(number <= 38)
//		{
//			world.setBlockState(pos.add(0,35,0), Main.mysticalLuckyBlockF.getDefaultState());
//		}
//		else if(number <= 40)
//		{
//			world.setBlockState(pos.add(0,35,0), Main.luckyBlockF.getDefaultState());
//		}
//		else if(number <= 44)
//		{
//			world.setBlockState(pos, Main.mysticalOre.getDefaultState());
//		}
//		else if(number <= 48)
//		{
//			world.setBlockState(pos, Blocks.BARRIER.getDefaultState());
//		}
//		//15% chance of spawning 7 barriers
//		else if(number <= 50)
//		{
//			Codakid.spawnBlock(world, pos, Blocks.BARRIER, 7);
//		}
//		else if(number <= 55)
//		{
//			for(int i = 0; i < 8; i++)
//			{
//				Codakid.spawnBlock(world, pos, Blocks.BLACK_GLAZED_TERRACOTTA, 1);
//				Codakid.spawnBlock(world, pos, Blocks.BLUE_GLAZED_TERRACOTTA, 1);
//				Codakid.spawnBlock(world, pos, Blocks.BROWN_GLAZED_TERRACOTTA, 1);
//				Codakid.spawnBlock(world, pos, Blocks.YELLOW_GLAZED_TERRACOTTA, 1);
//				Codakid.spawnBlock(world, pos, Blocks.RED_GLAZED_TERRACOTTA, 1);
//				Codakid.spawnBlock(world, pos, Blocks.ORANGE_GLAZED_TERRACOTTA, 1);
//				Codakid.spawnBlock(world, pos, Blocks.CYAN_GLAZED_TERRACOTTA, 1);
//				Codakid.spawnBlock(world, pos, Blocks.GRAY_GLAZED_TERRACOTTA, 1);
//				Codakid.spawnBlock(world, pos, Blocks.GREEN_GLAZED_TERRACOTTA, 1);
//				Codakid.spawnBlock(world, pos, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, 1);
//				Codakid.spawnBlock(world, pos, Blocks.LIME_GLAZED_TERRACOTTA, 1);
//				Codakid.spawnBlock(world, pos, Blocks.MAGENTA_GLAZED_TERRACOTTA, 1);
//				Codakid.spawnBlock(world, pos, Blocks.PINK_GLAZED_TERRACOTTA, 1);
//				Codakid.spawnBlock(world, pos, Blocks.PURPLE_GLAZED_TERRACOTTA, 1);
//				Codakid.spawnBlock(world, pos, Blocks.SILVER_GLAZED_TERRACOTTA, 1);
//				Codakid.spawnBlock(world, pos, Blocks.WHITE_GLAZED_TERRACOTTA, 1);
//			}
//		}
//		else if(number <= 60)
//		{
//			for(int i = 0; i < 5; i++)
//			{
//				Codakid.spawnBlock(world, pos, Blocks.BRICK_BLOCK, 1);
//			}
//		}
//		else if(number <= 61)
//		{
//			for(int i = 0; i < 1; i++)
//			{
//				Codakid.spawnBlock(world, pos, Blocks.DIAMOND_BLOCK, 1);
//			}
//		}
//		else if(number <= 62)
//		{
//			for(int i = 0; i < 1; i++)
//			{
//				Codakid.spawnBlock(world, pos, Blocks.EMERALD_BLOCK, 1);
//			}
//		}
//		else if(number <= 65)
//		{
//			for(int i = 0; i < 7; i++)
//			{
//				Codakid.spawnBlock(world, pos, Blocks.ICE, 1);
//			}
//		}
//		else if(number <= 68)
//		{
//			for(int i = 0; i < 1; i++)
//			{
//				world.setBlockState(pos, Blocks.CHEST.getDefaultState());
//			}
//		}
//		//20% chance of spawning 20 eggs and diamonds
//		else if(number <= 70)
//		{
//			for(int i = 0; i < 20; i++)
//			{
//				Codakid.spawnEntity(world, pos, new EntityEgg(world));
//				Codakid.spawnItem(world, pos, Items.DIAMOND, 1);
//			}
//		}
//		else if(number <= 80)
//		{
//			for(int i = 0; i < 1; i++)
//			{
//				Codakid.spawnBlock(world, pos, Blocks.BEDROCK, 1);
//			}
//		}
//		else if(number <= 83)
//		{
//			world.setBlockState(pos, Blocks.IRON_BLOCK.getDefaultState());
//		}
//		else if(number <= 85)
//		{
//			world.setBlockState(pos, Blocks.DIAMOND_BLOCK.getDefaultState());
//			for(int i = 0; i < 60; i++)
//			{
//				Codakid.spawnEntity(world, pos, new EntityTNTPrimed(world));
//			}
//		}
//		else if(number <= 90)
//		{
//			for(int i = 0; i < 8; i++)
//			{
//				Codakid.spawnBlock(world, pos, Blocks.HAY_BLOCK, 1);
//			}
//		}
//		else if(number <= 95)
//		{
//			for(int i = 0; i < 8; i++)
//			{
//				Codakid.spawnBlock(world, pos, Blocks.GLASS, 1);
//			}
//		}
//		//19% transform into obsidian
//		else if(number <= 99)
//		{
//			world.setBlockState(pos, Blocks.OBSIDIAN.getDefaultState());
//		}
//		
//		//1% chance spawn 7 lucky blocks
//		else if(number <= 100)
//		{
//			Codakid.spawnBlock(world, pos, Main.mysticalLuckyBlock, 7);
//		}
//		else if(number <= 103)
//		{
//			world.setBlockState(pos, Blocks.GOLD_BLOCK.getDefaultState());
//		}
//		else if(number <= 104)
//		{
//			Codakid.spawnEntity(world, pos, new EntityDragon(world));
//		}
//		else if(number <= 105)
//		{
//			Codakid.spawnEntity(world, pos, new EntityWither(world));
//		}
//		else if(number <= 106)
//		{
//			Codakid.spawnBlock(world, pos, Blocks.BEACON, 1);
//			Codakid.spawnBlock(world, pos, Blocks.DRAGON_EGG, 1);
//			Codakid.spawnItem(world, pos, Items.NETHER_STAR, 1);
//		}
//		else if(number <= 108)
//		{
//			Codakid.spawnBlock(world, pos, Blocks.BEACON, 1);
//		}
//		else if(number <= 111)
//		{
//			Codakid.spawnBlock(world, pos, Blocks.DRAGON_EGG, 1);
//		}
//		else if(number <= 115)
//		{
//			Codakid.spawnItem(world, pos, Items.NETHER_STAR, 1);
//		}
//		else if(number <= 118)
//		{
//			Codakid.spawnBlock(world, pos, Blocks.TNT, 1);
//			Codakid.spawnItem(world, pos, Main.mysticalIngot, 57);
//			Codakid.spawnItem(world, pos, Main.myIngot, 4);
//			Codakid.spawnItem(world, pos, Items.DIAMOND, 14);
//			Codakid.spawnBlock(world, pos, Blocks.OBSIDIAN, 12);
//			Codakid.spawnItem(world, pos, Items.DYE, 25);
//			Codakid.spawnItem(world, pos, Items.ENDER_PEARL, 2);
//			Codakid.spawnItem(world, pos, Items.END_CRYSTAL, 3);
//			Codakid.spawnItem(world, pos, Items.SHULKER_SHELL, 2);
//			Codakid.spawnBlock(world, pos, Blocks.DROPPER, 1);
//		}
//		else if(number <= 120)
//		{
////			worldIn.createExplosion(world, pos, pos, pos, 127f, false);
////			world.createExplosion(world, pos, pos, pos, 127, true);
//			Codakid.spawnEntity(world, pos, new EntityNuke(world));
//			
//		}
//		else if(number <= 125)
//		{
//			world.setBlockState(pos, Blocks.LAPIS_BLOCK.getDefaultState());
//		}
//		else if(number <= 130)
//		{
//			world.setBlockState(pos, Blocks.REDSTONE_BLOCK.getDefaultState());
//		}
//		else if(number <= 135)
//		{
//			for(int i = 0; i < 100; i++) 
//			{
//				Codakid.spawnEntity(world, pos, new EntityExpBottle(world));
//			}
//		}
//		else if(number <= 140)
//		{
//			for(int i = 0; i < 16; i++) 
//			{
//				Codakid.spawnBlock(world, pos, Blocks.QUARTZ_ORE, 1);
//				Codakid.spawnBlock(world, pos, Blocks.QUARTZ_BLOCK, 1);
//				Codakid.spawnBlock(world, pos, Blocks.QUARTZ_STAIRS, 1);
//				Codakid.spawnItem(world, pos, Items.QUARTZ, 1);
//			}
//		}
//		else if(number <= 145)
//		{
//			world.setBlockState(pos, Blocks.COAL_BLOCK.getDefaultState());
//		}
//		else if(number <= 150)
//		{
//			for(int i = 0; i < 64; i++) 
//			{
//				Codakid.spawnBlock(world, pos, Main.mysticalLuckyBlock, 1);
//			}
//		}
//		else if(number <= 155)
//		{
//			Codakid.spawnItem(world, pos, Items.APPLE, 1);
//			Codakid.spawnBlock(world, pos, Blocks.GOLD_BLOCK, 8);
//			Codakid.spawnItem(world, pos, Items.GOLDEN_APPLE, 6);
//		}
//		else if(number <= 160)
//		{
//			Codakid.spawnBlock(world, pos, Blocks.COMMAND_BLOCK, 1);
//			Codakid.spawnBlock(world, pos, Blocks.CHAIN_COMMAND_BLOCK, 1);
//			Codakid.spawnBlock(world, pos, Blocks.STRUCTURE_BLOCK, 1);
//			Codakid.spawnBlock(world, pos, Blocks.REPEATING_COMMAND_BLOCK, 1);
//			Codakid.spawnBlock(world, pos, Blocks.MOB_SPAWNER, 1);
//			Codakid.spawnBlock(world, pos, Blocks.BARRIER, 1);
//			Codakid.spawnBlock(world, pos, Blocks.STRUCTURE_VOID, 1);
//		}
//		else if(number <= 165)
//		{
//			for(int i = 0; i < 4; i++)
//			{
//				Codakid.spawnBlock(world, pos, Blocks.REDSTONE_BLOCK, 1);
//				Codakid.spawnBlock(world, pos, Blocks.REDSTONE_LAMP, 1);
//				Codakid.spawnBlock(world, pos, Blocks.REDSTONE_ORE, 1);
//				Codakid.spawnBlock(world, pos, Blocks.REDSTONE_TORCH, 1);
//				Codakid.spawnItem(world, pos, Items.REDSTONE, 1);
//				Codakid.spawnBlock(world, pos, Blocks.ACTIVATOR_RAIL, 1);
//				Codakid.spawnBlock(world, pos, Blocks.RAIL, 1);
//				Codakid.spawnBlock(world, pos, Blocks.DETECTOR_RAIL, 1);
//				Codakid.spawnBlock(world, pos, Blocks.GOLDEN_RAIL, 1);
//				Codakid.spawnBlock(world, pos, Blocks.COMMAND_BLOCK, 1);
//				Codakid.spawnBlock(world, pos, Blocks.CHAIN_COMMAND_BLOCK, 1);
//				Codakid.spawnBlock(world, pos, Blocks.REPEATING_COMMAND_BLOCK, 1);
//				Codakid.spawnBlock(world, pos, Blocks.DISPENSER, 1);
//				Codakid.spawnBlock(world, pos, Blocks.DROPPER, 1);
//				Codakid.spawnBlock(world, pos, Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, 1);
//				Codakid.spawnBlock(world, pos, Blocks.IRON_TRAPDOOR, 1);
//				Codakid.spawnBlock(world, pos, Blocks.IRON_DOOR, 1);
//				Codakid.spawnBlock(world, pos, Blocks.LEVER, 1);
//				Codakid.spawnBlock(world, pos, Blocks.NOTEBLOCK, 1);
//				Codakid.spawnBlock(world, pos, Blocks.OBSERVER, 1);
//				Codakid.spawnBlock(world, pos, Blocks.TNT, 1);
//				Codakid.spawnBlock(world, pos, Blocks.WOODEN_BUTTON, 1);
//				Codakid.spawnBlock(world, pos, Blocks.STONE_BUTTON, 1);
//				Codakid.spawnBlock(world, pos, Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE, 1);
//				Codakid.spawnBlock(world, pos, Blocks.STONE_PRESSURE_PLATE, 1);
//				Codakid.spawnBlock(world, pos, Blocks.WOODEN_PRESSURE_PLATE, 1);
//				Codakid.spawnBlock(world, pos, Blocks.DAYLIGHT_DETECTOR, 1);
//				Codakid.spawnBlock(world, pos, Blocks.HOPPER, 1);
//				Codakid.spawnBlock(world, pos, Blocks.PISTON, 1);
//				Codakid.spawnBlock(world, pos, Blocks.STICKY_PISTON, 1);
//				Codakid.spawnBlock(world, pos, Blocks.TRIPWIRE_HOOK, 1);
//				Codakid.spawnItem(world, pos, Items.REPEATER, 1);
//				Codakid.spawnItem(world, pos, Items.COMPARATOR, 1);
//			}
//		}
//		else if(number <= 170)
//		{
//			Codakid.spawnItem(world, pos, Items.ENDER_PEARL, 16);
//			Codakid.spawnItem(world, pos, Items.ENDER_EYE, 64);
//		}
//		else if(number <= 175)
//		{
//			Codakid.spawnBlock(world, pos, Blocks.ANVIL, 1);
//			Codakid.spawnBlock(world, pos, Blocks.BREWING_STAND, 1);
//			Codakid.spawnBlock(world, pos, Blocks.BOOKSHELF, 15);
//			Codakid.spawnBlock(world, pos, Blocks.COMMAND_BLOCK, 1);
//			Codakid.spawnBlock(world, pos, Blocks.CRAFTING_TABLE, 1);
//			Codakid.spawnBlock(world, pos, Blocks.BED, 1);
//			Codakid.spawnBlock(world, pos, Blocks.ENCHANTING_TABLE, 1);
//			Codakid.spawnBlock(world, pos, Blocks.ENDER_CHEST, 1);
//			Codakid.spawnBlock(world, pos, Blocks.CHAIN_COMMAND_BLOCK, 1);
//			Codakid.spawnBlock(world, pos, Blocks.CHEST, 1);
//			Codakid.spawnBlock(world, pos, Blocks.FURNACE, 1);
//			Codakid.spawnBlock(world, pos, Blocks.STRUCTURE_BLOCK, 1);
//			Codakid.spawnBlock(world, pos, Blocks.YELLOW_SHULKER_BOX, 1);
//			Codakid.spawnBlock(world, pos, Blocks.CAULDRON, 1);
//			Codakid.spawnBlock(world, pos, Blocks.REPEATING_COMMAND_BLOCK, 1);
//		}
//		else if(number <= 180)
//		{
//			for(int i = 0; i < 16; i++)
//			{
//				Codakid.spawnBlock(world, pos, Blocks.BREWING_STAND, 1);
//				Codakid.spawnBlock(world, pos, Blocks.CAULDRON, 1);
//				Codakid.spawnItem(world, pos, Items.BUCKET, 1);
//				Codakid.spawnItem(world, pos, Items.GLASS_BOTTLE, 1);
//				Codakid.spawnItem(world, pos, Items.NETHER_WART, 1);
//				Codakid.spawnItem(world, pos, Items.BLAZE_POWDER, 1);
//				Codakid.spawnItem(world, pos, Items.SPECKLED_MELON, 1);
//				Codakid.spawnItem(world, pos, Items.SUGAR, 1);
//				Codakid.spawnItem(world, pos, Items.GOLDEN_CARROT, 1);
//				Codakid.spawnItem(world, pos, Items.FERMENTED_SPIDER_EYE, 1);
//				Codakid.spawnItem(world, pos, Items.GHAST_TEAR, 1);
//				Codakid.spawnItem(world, pos, Items.SPIDER_EYE, 1);
//				Codakid.spawnItem(world, pos, Items.REDSTONE, 1);
//				Codakid.spawnItem(world, pos, Items.DRAGON_BREATH, 1);
//				Codakid.spawnItem(world, pos, Items.GLOWSTONE_DUST, 1);
//				Codakid.spawnItem(world, pos, Items.MAGMA_CREAM, 1);
//				Codakid.spawnItem(world, pos, Items.FISH.getItemById(3), 1);
//				Codakid.spawnItem(world, pos, Items.GUNPOWDER, 1);
//				Codakid.spawnItem(world, pos, Items.RABBIT_FOOT, 1);
//			}
//		}
//		else if(number <= 185)
//		{
//			for(int i = 0; i < 5; i++)
//			{
//				Codakid.spawnItem(world, pos, Items.FISH.getItemById(3), 1);
//				Codakid.spawnItem(world, pos, Items.FISH.getItemById(1), 1);
//				Codakid.spawnItem(world, pos, Items.FISH.getItemById(2), 1);
//				Codakid.spawnItem(world, pos, Items.FISH, 1);
//			}
//		}
//		else if(number <= 190)
//		{
//			for(int i = 0; i < 6; i++)
//			{
//				Codakid.spawnBlock(world, pos, Blocks.RED_FLOWER.getBlockById(8), 1);
//				Codakid.spawnBlock(world, pos, Blocks.RED_FLOWER.getBlockById(7), 1);
//				Codakid.spawnBlock(world, pos, Blocks.RED_FLOWER.getBlockById(6), 1);
//				Codakid.spawnBlock(world, pos, Blocks.RED_FLOWER.getBlockById(5), 1);
//				Codakid.spawnBlock(world, pos, Blocks.RED_FLOWER.getBlockById(4), 1);
//				Codakid.spawnBlock(world, pos, Blocks.RED_FLOWER.getBlockById(3), 1);
//				Codakid.spawnBlock(world, pos, Blocks.RED_FLOWER.getBlockById(2), 1);
//				Codakid.spawnBlock(world, pos, Blocks.RED_FLOWER.getBlockById(1), 1);
//				Codakid.spawnBlock(world, pos, Blocks.RED_FLOWER, 1);
//				Codakid.spawnBlock(world, pos, Blocks.YELLOW_FLOWER, 1);
//			}
//		}
//		else if(number <= 195)
//		{
//			for(int i = 0; i < 1; i++)
//			{
//				Codakid.spawnItem(world, pos, Items.SADDLE, 1);
//			}
//		}
//		else if(number <= 210)
//		{
//			for(int i = 0; i < 1000; i++)
//			{
//				Codakid.spawnEntity(world, pos, new EntityTNTPrimed(world));
//				Codakid.spawnEntity(world, pos, new EntityTNTPrimed(world));
//			}
//		}
//		else if(number <= 215)
//		{
//			world.setBlockState(pos, Main.mysticalSmallStructure.getDefaultState());
//		}
//		else if(number <= 220)
//		{
//			world.setBlockState(pos, Main.myStructure.getDefaultState());
//		}
//		else if(number <= 225)
//		{
//			Codakid.spawnEntity(world, pos, new GodMonster(world));
//			Codakid.spawnEntity(world, pos, new CustomMonster(world));
//			Codakid.spawnEntity(world, pos, new MysticalMonster(world));
//		}
//		else if(number <= 230)
//		{
//			Codakid.spawnEntity(world, pos, new CustomMonster(world));
//		}
//		else if(number <= 235)
//		{
//			Codakid.spawnEntity(world, pos, new MysticalMonster(world));
//		}
//		else if(number <= 240)
//		{
//			Codakid.spawnEntity(world, pos, new GodMonster(world));
//		}
//	}
	@Override
	public void onEndFalling(World worldIn, BlockPos pos, IBlockState p_176502_3_, IBlockState p_176502_4_)
    {
		worldIn.setBlockState(pos,Main.mysticalLuckyBlock.getDefaultState());
    }
	@Override
	public void onBroken(World world, BlockPos pos) {
		Codakid.spawnBlock(world, pos, Main.mysticalLuckyBlock, 1);
	}

}
