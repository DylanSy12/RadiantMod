package mymod._05_LuckyBlock;


import java.util.Random;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.boss.dragon.phase.IPhase;
import net.minecraft.entity.boss.dragon.phase.PhaseBase;
import net.minecraft.entity.boss.dragon.phase.PhaseList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.gen.feature.WorldGenEndPodium;
import net.minecraft.world.gen.feature.WorldGenerator;
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
import net.minecraft.block.BlockObsidian;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MysticalLuckyBlock extends Block {
	
	public MysticalLuckyBlock() {
		super(Material.BARRIER);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setResistance(1024f);
		this.setLightLevel(0.5f);
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
		int number = rand.nextInt(251) + 1;
//		System.out.println(number);
//		number=118;
		
		//10% chance for 64 diamonds
		if(number <= 4)
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
		else if(number <= 12)
		{
			world.setBlockState(pos, Blocks.EMERALD_BLOCK.getDefaultState());
		}
		else if(number <= 16)
		{
			Codakid.spawnEntity(world, pos, new EntityGrenade(world));
		}
		else if(number <= 24)
		{
			Codakid.spawnItem(world, pos, Main.mysticalBoots, 1);
			Codakid.spawnItem(world, pos, Main.mysticalSword, 1);
			Codakid.spawnItem(world, pos, Main.mysticalChestplate, 1);
			Codakid.spawnItem(world, pos, Main.mysticalHelmet, 1);
			Codakid.spawnItem(world, pos, Main.mysticalLeggings, 1);
			Codakid.spawnItem(world, pos, Main.mysticalIngot, 1);
			Codakid.spawnItem(world, pos, Main.mysticalPickaxe, 1);
			Codakid.spawnBlock(world, pos, Main.mysticalOre, 1);
			Codakid.spawnBlock(world, pos, Main.mysticalLuckyBlock, 1);
			Codakid.spawnItem(world, pos, Main.portalHammer, 1);
			Codakid.spawnItem(world, pos, Main.crystalLauncher, 1);
			Codakid.spawnItem(world, pos, Main.levitationGun, 1);
			Codakid.spawnItem(world, pos, Main.eraserGrenade, 1);
			Codakid.spawnBlock(world, pos, Main.mysticalBlock, 1);
			Codakid.spawnItem(world, pos, Main.mysticalAxe, 1);
			Codakid.spawnItem(world, pos, Main.mysticalShovel, 1);
			Codakid.spawnItem(world, pos, Main.mysticalHoe, 1);
		}
		else if(number <= 33)
		{
			Codakid.spawnEntity(world, pos, new EntityEraserGrenade(world));
		}
		else if(number <= 35)
		{
			for(int i = 0; i < 25; i++)
			{
				Codakid.spawnEntity(world, pos, new EntityTNTPrimed(world));
			}
		}
		else if(number <= 38)
		{
			world.setBlockState(pos.add(0,35,0), Main.mysticalLuckyBlockF.getDefaultState());
		}
		else if(number <= 40)
		{
			world.setBlockState(pos.add(0,35,0), Main.luckyBlockF.getDefaultState());
		}
		
		else if(number <= 44)
		{
			world.setBlockState(pos, Main.mysticalOre.getDefaultState());
		}
		else if(number <= 48)
		{
			world.setBlockState(pos, Blocks.BARRIER.getDefaultState());
		}
		//15% chance of spawning 7 barriers
		else if(number <= 50)
		{
			Codakid.spawnBlock(world, pos, Blocks.BARRIER, rand.nextInt(65));
		}
		else if(number <= 55)
		{
			Codakid.spawnBlock(world, pos, Blocks.BLACK_GLAZED_TERRACOTTA, rand.nextInt(65));
			Codakid.spawnBlock(world, pos, Blocks.BLUE_GLAZED_TERRACOTTA, rand.nextInt(65));
			Codakid.spawnBlock(world, pos, Blocks.BROWN_GLAZED_TERRACOTTA, rand.nextInt(65));
			Codakid.spawnBlock(world, pos, Blocks.YELLOW_GLAZED_TERRACOTTA, rand.nextInt(65));
			Codakid.spawnBlock(world, pos, Blocks.RED_GLAZED_TERRACOTTA, rand.nextInt(65));
			Codakid.spawnBlock(world, pos, Blocks.ORANGE_GLAZED_TERRACOTTA, rand.nextInt(65));
			Codakid.spawnBlock(world, pos, Blocks.CYAN_GLAZED_TERRACOTTA, rand.nextInt(65));
			Codakid.spawnBlock(world, pos, Blocks.GRAY_GLAZED_TERRACOTTA, rand.nextInt(65));
			Codakid.spawnBlock(world, pos, Blocks.GREEN_GLAZED_TERRACOTTA, rand.nextInt(65));
			Codakid.spawnBlock(world, pos, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, rand.nextInt(65));
			Codakid.spawnBlock(world, pos, Blocks.LIME_GLAZED_TERRACOTTA, rand.nextInt(65));
			Codakid.spawnBlock(world, pos, Blocks.MAGENTA_GLAZED_TERRACOTTA, rand.nextInt(65));
			Codakid.spawnBlock(world, pos, Blocks.PINK_GLAZED_TERRACOTTA, rand.nextInt(65));
			Codakid.spawnBlock(world, pos, Blocks.PURPLE_GLAZED_TERRACOTTA, rand.nextInt(65));
			Codakid.spawnBlock(world, pos, Blocks.SILVER_GLAZED_TERRACOTTA, rand.nextInt(65));
			Codakid.spawnBlock(world, pos, Blocks.WHITE_GLAZED_TERRACOTTA, rand.nextInt(65));
		}
		else if(number <= 60)
		{
			Codakid.spawnBlock(world, pos, Blocks.BRICK_BLOCK, rand.nextInt(32)+1);
		}
		else if(number <= 61)
		{
			Codakid.spawnBlock(world, pos, Blocks.DIAMOND_BLOCK, rand.nextInt(3)+1);
		}
		else if(number <= 62)
		{
			Codakid.spawnBlock(world, pos, Blocks.EMERALD_BLOCK, rand.nextInt(4)+1);
		}
		else if(number <= 65)
		{
			Codakid.spawnBlock(world, pos, Blocks.ICE, rand.nextInt(32)+1);
		}
		else if(number <= 68)
		{
			world.setBlockState(pos, Blocks.CHEST.getDefaultState());
		}
		//20% chance of spawning 20 eggs and diamonds
		else if(number <= 70)
		{
			for(int i = 0; i < rand.nextInt(11)+10; i++)
			{
				EntityEgg egg=new EntityEgg(world);
				egg.setVelocity(rand.nextInt(11)-5, rand.nextInt(11), rand.nextInt(10)-5);
				Codakid.spawnEntity(world, pos, egg);
				Codakid.spawnItem(world, pos, Items.DIAMOND, rand.nextInt(1));
			}
		}
		else if(number <= 80)
		{
			Codakid.spawnBlock(world, pos, Blocks.BEDROCK, rand.nextInt(32)+1);
		}
		else if(number <= 83)
		{
			world.setBlockState(pos, Blocks.IRON_BLOCK.getDefaultState());
		}
		else if(number <= 85)
		{
			world.setBlockState(pos, Blocks.DIAMOND_BLOCK.getDefaultState());
			for(int i = 0; i < 60; i++)
			{
				Codakid.spawnEntity(world, pos, new EntityTNTPrimed(world));
			}
		}
		else if(number <= 90)
		{
			Codakid.spawnBlock(world, pos, Blocks.HAY_BLOCK, rand.nextInt(32)+1);
		}
		else if(number <= 95)
		{
			Codakid.spawnBlock(world, pos, Blocks.GLASS, rand.nextInt(32)+1);
		}
		//19% transform into obsidian
		else if(number <= 99)
		{
			world.setBlockState(pos, Blocks.OBSIDIAN.getDefaultState());
		}
		
		//1% chance spawn 7 lucky blocks
		else if(number <= 100)
		{
			Codakid.spawnBlock(world, pos, Main.mysticalLuckyBlock, 7);
		}
		else if(number <= 103)
		{
			world.setBlockState(pos, Blocks.GOLD_BLOCK.getDefaultState());
		}
		else if(number <= 104)
		{
//			WorldGenEndPodium.END_PODIUM_LOCATION=pos;
//			world.WorldGenerator.;
//			Random r=new Random();
//			WorldGenEndPodium.generate(world,world.rand,pos);
			EntityDragon dragon = new EntityDragon(world);
			dragon.getPhaseManager().setPhase(PhaseList.TAKEOFF);
			Codakid.spawnEntity(world, pos, dragon);
//			world.onEntityAdded(dragon);
//			world.spawnEntity(dragon);
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
			Codakid.spawnBlock(world, pos, Blocks.TNT, 1);
			Codakid.spawnItem(world, pos, Main.mysticalIngot, 73);
			Codakid.spawnItem(world, pos, Main.myIngot, 4);
			Codakid.spawnItem(world, pos, Items.DIAMOND, 13);
			Codakid.spawnBlock(world, pos, Blocks.OBSIDIAN, 12);
			ItemStack lapis1=new ItemStack(Items.DYE,22);
			lapis1.setItemDamage(4);
			world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), lapis1));
//			ItemStack lapis2=new ItemStack(Items.DYE,22,4);
//			lapis2.setItemDamage(4);
//			world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), lapis2));
//			Codakid.spawnItem(world, pos, Items.DYE, 22);
//			Codakid.spawnItem(world, pos, lapis.getItem(), 22);
			Codakid.spawnItem(world, pos, Items.ENDER_PEARL, 2);
			Codakid.spawnItem(world, pos, Items.END_CRYSTAL, 3);
			Codakid.spawnItem(world, pos, Items.SHULKER_SHELL, 2);
			Codakid.spawnBlock(world, pos, Blocks.DROPPER, 1);
			Codakid.spawnBlock(world, pos, Main.luckyBlock, 1);
			Codakid.spawnBlock(world, pos, Main.godLuckyBlock, 1);
			Codakid.spawnBlock(world, pos, Main.mysticalBlock, 1);
		}
		else if(number <= 120)
		{
			Codakid.spawnEntity(world, pos, new EntityNuke(world));
		}
		else if(number <= 125)
		{
			world.setBlockState(pos, Blocks.LAPIS_BLOCK.getDefaultState());
		}
		else if(number <= 130)
		{
			world.setBlockState(pos, Blocks.REDSTONE_BLOCK.getDefaultState());
		}
		else if(number <= 135)
		{
			for(int i = 0; i < 100; i++) 
			{
				Codakid.spawnEntity(world, pos, new EntityExpBottle(world));
			}
		}
		else if(number <= 140)
		{
			Codakid.spawnBlock(world, pos, Blocks.QUARTZ_ORE, rand.nextInt(64)+1);
			Codakid.spawnBlock(world, pos, Blocks.QUARTZ_BLOCK, rand.nextInt(64)+1);
			Codakid.spawnBlock(world, pos, Blocks.QUARTZ_STAIRS, rand.nextInt(64)+1);
			Codakid.spawnItem(world, pos, Items.QUARTZ, rand.nextInt(64)+1);
		}
		else if(number <= 145)
		{
			world.setBlockState(pos, Blocks.COAL_BLOCK.getDefaultState());
		}
		else if(number <= 150)
		{
			Codakid.spawnBlock(world, pos, Main.mysticalLuckyBlock, 64);
		}
		else if(number <= 155)
		{
			Codakid.spawnItem(world, pos, Items.APPLE, 1);
			Codakid.spawnBlock(world, pos, Blocks.GOLD_BLOCK, 7);
			Codakid.spawnItem(world, pos, Items.GOLDEN_APPLE, rand.nextInt(4)+2);
		}
		else if(number <= 160)
		{
			Codakid.spawnBlock(world, pos, Blocks.COMMAND_BLOCK, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.CHAIN_COMMAND_BLOCK, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.STRUCTURE_BLOCK, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.REPEATING_COMMAND_BLOCK, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.MOB_SPAWNER, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.BARRIER, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.STRUCTURE_VOID, rand.nextInt(32)+1);
		}
		else if(number <= 165)
		{
			Codakid.spawnBlock(world, pos, Blocks.REDSTONE_BLOCK, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.REDSTONE_LAMP, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.REDSTONE_ORE, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.REDSTONE_TORCH, rand.nextInt(32)+1);
			Codakid.spawnItem(world, pos, Items.REDSTONE, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.ACTIVATOR_RAIL, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.RAIL, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.DETECTOR_RAIL, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.GOLDEN_RAIL, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.COMMAND_BLOCK, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.CHAIN_COMMAND_BLOCK, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.REPEATING_COMMAND_BLOCK, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.DISPENSER, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.DROPPER, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.IRON_TRAPDOOR, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.IRON_DOOR, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.LEVER, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.NOTEBLOCK, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.OBSERVER, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.TNT, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.WOODEN_BUTTON, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.STONE_BUTTON, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.STONE_PRESSURE_PLATE, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.WOODEN_PRESSURE_PLATE, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.DAYLIGHT_DETECTOR, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.HOPPER, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.PISTON, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.STICKY_PISTON, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.TRIPWIRE_HOOK, rand.nextInt(32)+1);
			Codakid.spawnItem(world, pos, Items.REPEATER, rand.nextInt(32)+1);
			Codakid.spawnItem(world, pos, Items.COMPARATOR, rand.nextInt(32)+1);
		}
		else if(number <= 170)
		{
			Codakid.spawnItem(world, pos, Items.ENDER_PEARL, 16);
			Codakid.spawnItem(world, pos, Items.ENDER_EYE, 64);
		}
		else if(number <= 175)
		{
			Codakid.spawnBlock(world, pos, Blocks.ANVIL, rand.nextInt(64)+1);
			Codakid.spawnBlock(world, pos, Blocks.BREWING_STAND, rand.nextInt(64)+1);
			Codakid.spawnBlock(world, pos, Blocks.BOOKSHELF, rand.nextInt(64)+1);
			Codakid.spawnBlock(world, pos, Blocks.COMMAND_BLOCK, rand.nextInt(64)+1);
			Codakid.spawnBlock(world, pos, Blocks.CRAFTING_TABLE, rand.nextInt(64)+1);
			Codakid.spawnBlock(world, pos, Blocks.BED, rand.nextInt(64)+1);
			Codakid.spawnBlock(world, pos, Blocks.ENCHANTING_TABLE, rand.nextInt(64)+1);
			Codakid.spawnBlock(world, pos, Blocks.ENDER_CHEST, rand.nextInt(64)+1);
			Codakid.spawnBlock(world, pos, Blocks.CHAIN_COMMAND_BLOCK, rand.nextInt(64)+1);
			Codakid.spawnBlock(world, pos, Blocks.CHEST, rand.nextInt(64)+1);
			Codakid.spawnBlock(world, pos, Blocks.FURNACE, rand.nextInt(64)+1);
			Codakid.spawnBlock(world, pos, Blocks.STRUCTURE_BLOCK, rand.nextInt(64)+1);
			Codakid.spawnBlock(world, pos, Blocks.PURPLE_SHULKER_BOX, rand.nextInt(64)+1);
			Codakid.spawnBlock(world, pos, Blocks.CAULDRON, rand.nextInt(64)+1);
			Codakid.spawnBlock(world, pos, Blocks.REPEATING_COMMAND_BLOCK, rand.nextInt(64)+1);
		}
		else if(number <= 180)
		{
			Codakid.spawnBlock(world, pos, Blocks.BREWING_STAND, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.CAULDRON, rand.nextInt(32)+1);
			Codakid.spawnItem(world, pos, Items.BUCKET, rand.nextInt(32)+1);
			Codakid.spawnItem(world, pos, Items.GLASS_BOTTLE, rand.nextInt(32)+1);
			Codakid.spawnItem(world, pos, Items.NETHER_WART, rand.nextInt(32)+1);
			Codakid.spawnItem(world, pos, Items.BLAZE_POWDER, rand.nextInt(32)+1);
			Codakid.spawnItem(world, pos, Items.SPECKLED_MELON, rand.nextInt(32)+1);
			Codakid.spawnItem(world, pos, Items.SUGAR, rand.nextInt(32)+1);
			Codakid.spawnItem(world, pos, Items.GOLDEN_CARROT, rand.nextInt(32)+1);
			Codakid.spawnItem(world, pos, Items.FERMENTED_SPIDER_EYE, rand.nextInt(32)+1);
			Codakid.spawnItem(world, pos, Items.GHAST_TEAR, rand.nextInt(32)+1);
			Codakid.spawnItem(world, pos, Items.SPIDER_EYE, rand.nextInt(32)+1);
			Codakid.spawnItem(world, pos, Items.REDSTONE, rand.nextInt(32)+1);
			Codakid.spawnItem(world, pos, Items.DRAGON_BREATH, rand.nextInt(32)+1);
			Codakid.spawnItem(world, pos, Items.GLOWSTONE_DUST, rand.nextInt(32)+1);
			Codakid.spawnItem(world, pos, Items.MAGMA_CREAM, rand.nextInt(32)+1);
//			Codakid.spawnItem(world, pos, Items.FISH.getItemById(3), rand.nextInt(32)+1);
			Codakid.spawnItem(world, pos, Items.GUNPOWDER, rand.nextInt(32)+1);
			Codakid.spawnItem(world, pos, Items.RABBIT_FOOT, rand.nextInt(32)+1);
		}
		else if(number <= 185)
		{
//			Codakid.spawnItem(world, pos, Items.FISH.getItemById(3), 1);
//			Codakid.spawnItem(world, pos, Items.FISH.getItemById(1), 1);
//			Codakid.spawnItem(world, pos, Items.FISH.getItemById(2), 1);
			Codakid.spawnItem(world, pos, Items.FISH, rand.nextInt(32)+1);
		}
		else if(number <= 190)
		{
//			Codakid.spawnBlock(world, pos, Blocks.RED_FLOWER.getBlockById(8), 1);
//			Codakid.spawnBlock(world, pos, Blocks.RED_FLOWER.getBlockById(7), 1);
//			Codakid.spawnBlock(world, pos, Blocks.RED_FLOWER.getBlockById(6), 1);
//			Codakid.spawnBlock(world, pos, Blocks.RED_FLOWER.getBlockById(5), 1);
//			Codakid.spawnBlock(world, pos, Blocks.RED_FLOWER.getBlockById(4), 1);
//			Codakid.spawnBlock(world, pos, Blocks.RED_FLOWER.getBlockById(3), 1);
//			Codakid.spawnBlock(world, pos, Blocks.RED_FLOWER.getBlockById(2), 1);
//			Codakid.spawnBlock(world, pos, Blocks.RED_FLOWER.getBlockById(1), 1);
			Codakid.spawnBlock(world, pos, Blocks.RED_FLOWER, rand.nextInt(32)+1);
			Codakid.spawnBlock(world, pos, Blocks.YELLOW_FLOWER, rand.nextInt(32)+1);
		}
		else if(number <= 195)
		{
			Codakid.spawnItem(world, pos, Items.SADDLE, rand.nextInt(2));
		}
		else if(number <= 210)
		{
			for(int i = 0; i < 1000; i++)
			{
				Codakid.spawnEntity(world, pos, new EntityTNTPrimed(world));
				Codakid.spawnEntity(world, pos, new EntityTNTPrimed(world));
			}
		}
		else if(number <= 215)
		{
			world.setBlockState(pos, Main.mysticalSmallStructure.getDefaultState());
		}
		else if(number <= 220)
		{
			world.setBlockState(pos, Main.myStructure.getDefaultState());
		}
		else if(number <= 225)
		{
			Codakid.spawnEntity(world, pos, new GodLord(world));
			Codakid.spawnEntity(world, pos, new RadiantLord(world));
			Codakid.spawnEntity(world, pos, new MysticalLord(world));
		}
		else if(number <= 230)
		{
			Codakid.spawnEntity(world, pos, new RadiantLord(world));
		}
		else if(number <= 235)
		{
			Codakid.spawnEntity(world, pos, new MysticalLord(world));
		}
		else if(number <= 240)
		{
			Codakid.spawnEntity(world, pos, new GodLord(world));
		}
		else if(number <=245)
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
		else if(number<=246) {
			for (int i=0; i<rand.nextInt(10)+1;i++) {
				world.setBlockState(pos.add(0,35+i,0), Main.mysticalLuckyBlockF.getDefaultState());
			}
		}
	}

}
