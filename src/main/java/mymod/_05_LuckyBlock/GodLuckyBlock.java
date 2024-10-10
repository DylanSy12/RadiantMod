package mymod._05_LuckyBlock;


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
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import mymod.Main;
import mymod.CodakidFiles.Codakid;
import mymod._01_ForgeYourSword.RadiantLord;
import mymod._04_CreateACreature.GodLord;
import mymod._04_CreateACreature.MysticalLord;
import mymod._07_BuildAndBoom.EntityBuildGrenade;
import mymod._07_BuildAndBoom.EntityClusterGrenade;
import mymod._07_BuildAndBoom.EntityGodEraserGrenade;
import mymod._07_BuildAndBoom.EntityGrenade;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemFirework;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GodLuckyBlock extends Block {
	
	public GodLuckyBlock() {
		super(Material.BARRIER);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setResistance(1024f);
		this.setLightLevel(1f);
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
		int number = rand.nextInt(285) + 1;
//		System.out.println(number);
//		number=53;
//		number=65;
//		number=40;
//		number=118;
		//10% chance for 64 diamonds
		if(number <= 8)
		{
			Codakid.spawnItem(world, pos, Items.DIAMOND, 64);
		}
		else if(number <= 8)
		{
			world.setBlockState(pos, Blocks.EMERALD_BLOCK.getDefaultState());
		}
		else if(number <= 10)
		{
			Codakid.spawnEntity(world, pos, new EntityClusterGrenade(world));
		}
		else if(number <= 16)
		{
			world.setBlockState(pos, Blocks.DIAMOND_BLOCK.getDefaultState());
		}
		else if(number <= 18)
		{
			Codakid.spawnEntity(world, pos, new EntityGrenade(world));
		}
		else if(number <= 25)
		{
			Codakid.spawnItem(world, pos, Main.godBoots, 1);
			Codakid.spawnItem(world, pos, Main.godSword, 1);
			Codakid.spawnItem(world, pos, Main.godChestplate, 1);
			Codakid.spawnItem(world, pos, Main.godHelmet, 1);
			Codakid.spawnItem(world, pos, Main.godLeggings, 1);
			Codakid.spawnItem(world, pos, Main.godIngot, 1);
			Codakid.spawnItem(world, pos, Main.godPickaxe, 1);
			Codakid.spawnBlock(world, pos, Main.godOre, 1);
			Codakid.spawnBlock(world, pos, Main.godLuckyBlock, 1);
			Codakid.spawnItem(world, pos, Main.eraserHammer, 1);
			Codakid.spawnItem(world, pos, Main.luckyBlockLauncher, 1);
			Codakid.spawnItem(world, pos, Main.boomGun, 1);
			Codakid.spawnItem(world, pos, Main.godEraserGrenade, 1);
			Codakid.spawnItem(world, pos, Main.recursiveClusterGrenade, 1);
			Codakid.spawnItem(world, pos, Main.godBuildGrenade, 1);
			Codakid.spawnBlock(world, pos, Main.godBlock, 1);
			Codakid.spawnItem(world, pos, Main.godAxe,1);
			Codakid.spawnItem(world, pos, Main.godShovel,1);
			Codakid.spawnItem(world, pos, Main.godHoe,1);
		}
		
		else if(number <= 28)
		{
			for(int i = 0; i < rand.nextInt(11)+5; i++)
			{
				Codakid.spawnEntity(world, pos, new EntityTNTPrimed(world));
			}
		}
		else if(number <= 36)
		{
			world.setBlockState(pos.add(0,35,0), Main.godLuckyBlockF.getDefaultState());
		}
		else if(number <= 40)
		{
			for (int i=0; i<rand.nextInt(10)+1;i++) {
				world.setBlockState(pos.add(0,35+i,0), Main.godLuckyBlockF.getDefaultState());
			}
		}
		else if(number <= 41)
		{
			world.setBlockState(pos, Main.godOre.getDefaultState());
		}
		else if(number <= 43)
		{
			world.setBlockState(pos, Blocks.BARRIER.getDefaultState());
		}
		//15% chance of spawning 7 barriers
		else if(number <= 45)
		{
			Codakid.spawnBlock(world, pos, Blocks.BARRIER, rand.nextInt(10)+1);
		}
		else if(number <= 53)
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
//			world.
		}
		
		
		
		//20% chance of spawning 20 eggs and diamonds
		else if(number <= 60)
		{
			for(int i = 0; i < rand.nextInt(31)+15; i++)
			{
				EntityEgg egg=new EntityEgg(world);
				egg.setVelocity(rand.nextInt(11)-5, rand.nextInt(11), rand.nextInt(10)-5);
				Codakid.spawnEntity(world, pos, egg);
				Codakid.spawnItem(world, pos, Items.DIAMOND, 1);
			}
		}
		else if(number <= 64)
		{
			Codakid.spawnItem(world, pos, Items.IRON_HORSE_ARMOR, 1);
			Codakid.spawnItem(world, pos, Items.GOLDEN_HORSE_ARMOR, 1);
			Codakid.spawnItem(world, pos, Items.DIAMOND_HORSE_ARMOR, 1);
		}
		else if(number <= 65)
		{
			for (int i=0;i<rand.nextInt(9)+1;i++) {
				world.setBlockState(pos.add(0,35+i,0), Main.fallingDiamond.getDefaultState());
//				world.setBlockState(pos.add(0,40+i,0), BlockFalling.getBlockById(Blocks.DIAMOND_BLOCK.getIdFromBlock(Blocks.DIAMOND_BLOCK)).getDefaultState());
			}
		}
		else if(number <= 66)
		{
			Codakid.spawnBlock(world, pos, Blocks.SPONGE, rand.nextInt(3)+1);
		}
		else if(number <= 67)
		{
			Codakid.spawnBlock(world, pos, Blocks.ENDER_CHEST, rand.nextInt(3)+1);
		}
		else if(number <= 68)
		{
			Codakid.spawnBlock(world, pos, Blocks.TNT, rand.nextInt(9)+4);
		}
		//19% transform into obsidian
		else if(number <= 70)
		{
			world.setBlockState(pos, Blocks.OBSIDIAN.getDefaultState());
		}
		
		//1% chance spawn 7 lucky blocks
		else if(number <= 90)
		{
			Codakid.spawnBlock(world, pos, Main.godLuckyBlock, 7);
		}
		
		else if(number <= 105)
		{
			Codakid.spawnEntity(world, pos, new EntityIronGolem(world));
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
			Codakid.spawnBlock(world, pos, Blocks.BEACON, 14);
			Codakid.spawnBlock(world, pos, Blocks.TNT, 6);
			Codakid.spawnItem(world, pos, Main.myIngot, 25);
			Codakid.spawnItem(world, pos, Main.godIngot, 79);
			Codakid.spawnItem(world, pos, Main.mysticalIngot, 18);
			Codakid.spawnItem(world, pos, Main.godEraserGrenade, 1);
			Codakid.spawnItem(world, pos, Main.myNuke, 1);
			Codakid.spawnBlock(world, pos, Main.godLuckyBlock, 1);
			Codakid.spawnBlock(world, pos, Main.luckyBlock, 2);
			Codakid.spawnBlock(world, pos, Main.mysticalLuckyBlock, 2);
			Codakid.spawnBlock(world, pos, Blocks.DROPPER, 1);
			Codakid.spawnItem(world, pos, Main.myClusterGrenade, 1);
			Codakid.spawnBlock(world, pos, Main.godBlock, 1);
		}
		else if(number <= 120)
		{
//			worldIn.createExplosion(world, pos, pos, pos, 127f, false);
//			world.createExplosion(world, pos, pos, pos, 127, true);
			Codakid.spawnEntity(world, pos, new EntityGodEraserGrenade(world));
			
		}
		else if(number <= 125)
		{
			for(int i = 0; i < rand.nextInt(101)+50; i++) 
			{
				Codakid.spawnEntity(world, pos, new EntityExpBottle(world));
			}
		}
		else if(number <= 130)
		{
			Codakid.spawnBlock(world, pos, Blocks.EMERALD_BLOCK, rand.nextInt(4)+1);
		}
		else if(number <= 135)
		{
			Codakid.spawnBlock(world, pos, Blocks.DIAMOND_BLOCK, rand.nextInt(3)+1);
		}
		else if(number <= 140)
		{
			Codakid.spawnBlock(world, pos, Blocks.QUARTZ_ORE, rand.nextInt(13)+6);
			Codakid.spawnBlock(world, pos, Blocks.QUARTZ_BLOCK, rand.nextInt(11)+4);
			Codakid.spawnBlock(world, pos, Blocks.QUARTZ_STAIRS, rand.nextInt(9)+2);
			Codakid.spawnItem(world, pos, Items.QUARTZ, rand.nextInt(15)+8);
		}
		else if(number <= 145)
		{
			Codakid.spawnItem(world, pos, Items.DIAMOND_HORSE_ARMOR, 1);
			Codakid.spawnItem(world, pos, Items.DIAMOND_HELMET, 1);
			Codakid.spawnItem(world, pos, Items.DIAMOND_BOOTS, 1);
			Codakid.spawnItem(world, pos, Items.DIAMOND_LEGGINGS, 1);
			Codakid.spawnItem(world, pos, Items.DIAMOND_CHESTPLATE, 1);
			Codakid.spawnItem(world, pos, Items.DIAMOND_SWORD, 1);
			Codakid.spawnItem(world, pos, Items.DIAMOND_PICKAXE, 1);
			Codakid.spawnItem(world, pos, Items.DIAMOND_AXE, 1);
			Codakid.spawnItem(world, pos, Items.DIAMOND_SHOVEL, 1);
			Codakid.spawnItem(world, pos, Items.DIAMOND_HOE, 1);
			
		}
		else if(number <= 150)
		{
			Codakid.spawnBlock(world, pos, Blocks.DIAMOND_BLOCK, 64);
		}
		else if(number <= 155)
		{
			Codakid.spawnBlock(world, pos, Main.godLuckyBlock, rand.nextInt(64)+1);
		}
		else if(number <= 160)
		{
			Codakid.spawnBlock(world, pos, Main.luckyBlock, 64);
		}
		else if(number <= 165)
		{
			Codakid.spawnBlock(world, pos, Blocks.EMERALD_BLOCK, 64);
		}
		else if(number <= 170)
		{
			Codakid.spawnBlock(world, pos, Blocks.GOLD_BLOCK, 64);
		}
		else if(number <= 175)
		{
			Codakid.spawnBlock(world, pos, Blocks.LAPIS_BLOCK, 64);
		}
		else if(number <= 180)
		{
			Codakid.spawnBlock(world, pos, Blocks.IRON_BLOCK, 64);
		}
		else if(number <= 185)
		{
			Codakid.spawnBlock(world, pos, Main.godBlock, 64);
		}
		else if(number <= 190)
		{
			Codakid.spawnBlock(world, pos, Main.mysticalBlock, 64);
		}
		else if(number <= 195)
		{
			Codakid.spawnBlock(world, pos, Main.radiantBlock, 64);
		}
		else if(number <= 200)
		{
			Codakid.spawnBlock(world, pos, Main.mysticalLuckyBlock, 64);
		}
		else if(number <= 205)
		{
			Codakid.spawnItem(world, pos, Items.APPLE, 1);
			Codakid.spawnBlock(world, pos, Blocks.GOLD_BLOCK, 8);
			Codakid.spawnItem(world, pos, Items.GOLDEN_APPLE, rand.nextInt(7)+3);
		}
		else if(number <= 210)
		{
			Codakid.spawnBlock(world, pos, Blocks.COMMAND_BLOCK, 1);
			Codakid.spawnBlock(world, pos, Blocks.CHAIN_COMMAND_BLOCK, 1);
			Codakid.spawnBlock(world, pos, Blocks.STRUCTURE_BLOCK, 1);
			Codakid.spawnBlock(world, pos, Blocks.REPEATING_COMMAND_BLOCK, 1);
			Codakid.spawnBlock(world, pos, Blocks.MOB_SPAWNER, 1);
			Codakid.spawnBlock(world, pos, Blocks.BARRIER, 1);
			Codakid.spawnBlock(world, pos, Blocks.STRUCTURE_VOID, 1);
		}
		else if(number <= 215)
		{
			Codakid.spawnItem(world, pos, Items.ENDER_PEARL, 16);
			Codakid.spawnItem(world, pos, Items.ENDER_EYE, 64);
		}
		else if(number <= 220)
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
		else if(number <= 225)
		{
			Codakid.spawnItem(world, pos, Items.SADDLE, rand.nextInt(3)+1);
		}
		else if(number <= 230)
		{
			Codakid.spawnBlock(world, pos, Main.godLuckyBlock, 64);
		}
		else if(number <= 235)
		{
			world.setBlockState(pos, Main.myStructure.getDefaultState());
		}
		else if(number <= 240)
		{
			world.setBlockState(pos, Main.godSmallStructure.getDefaultState());
		}
		else if(number <= 245)
		{
			Codakid.spawnEntity(world, pos, new RadiantLord(world));
		}
		else if(number <= 250)
		{
			Codakid.spawnEntity(world, pos, new MysticalLord(world));
		}
		else if(number <= 255)
		{
			Codakid.spawnEntity(world, pos, new GodLord(world));
		}
		else if(number<=260)
		{
			Codakid.spawnBlock(world, pos, Main.godBlock, rand.nextInt(64)+1);
		}
		else if(number<=265)
		{
			Codakid.spawnBlock(world, pos, Main.radiantBlock, rand.nextInt(64)+1);
		}
		else if(number<=270)
		{
			Codakid.spawnBlock(world, pos, Main.mysticalBlock, rand.nextInt(64)+1);
		}
		else if(number<=275)
		{
			Codakid.spawnBlock(world, pos, Main.luckyBlock, rand.nextInt(64)+1);
		}
		else if(number<=280)
		{
			Codakid.spawnBlock(world, pos, Main.mysticalLuckyBlock, rand.nextInt(64)+1);
		}
		else if(number<=282)
		{
			Codakid.spawnBlock(world, pos, Main.godBlock, rand.nextInt(65));
			Codakid.spawnBlock(world, pos, Main.godLuckyBlock, rand.nextInt(65));
			Codakid.spawnBlock(world, pos, Main.godSmallStructure, rand.nextInt(65));
			Codakid.spawnBlock(world, pos, Main.godOre, rand.nextInt(65));
			Codakid.spawnBlock(world, pos, Main.radiantBlock, rand.nextInt(65));
			Codakid.spawnBlock(world, pos, Main.luckyBlock, rand.nextInt(65));
			Codakid.spawnBlock(world, pos, Main.myStructure, rand.nextInt(65));
			Codakid.spawnBlock(world, pos, Main.myOre, rand.nextInt(65));
			Codakid.spawnBlock(world, pos, Main.mysticalBlock, rand.nextInt(65));
			Codakid.spawnBlock(world, pos, Main.mysticalLuckyBlock, rand.nextInt(65));
			Codakid.spawnBlock(world, pos, Main.mysticalSmallStructure, rand.nextInt(65));
			Codakid.spawnBlock(world, pos, Main.mysticalOre, rand.nextInt(65));
			Codakid.spawnBlock(world, pos, Main.tntTower, rand.nextInt(65));
			Codakid.spawnItem(world, pos, Main.godHelmet, rand.nextInt(2));
			Codakid.spawnItem(world, pos, Main.godChestplate, rand.nextInt(2));
			Codakid.spawnItem(world, pos, Main.godLeggings, rand.nextInt(2));
			Codakid.spawnItem(world, pos, Main.godBoots, rand.nextInt(2));
			Codakid.spawnItem(world, pos, Main.godBuildGrenade, rand.nextInt(65));
			Codakid.spawnItem(world, pos, Main.godEraserGrenade, rand.nextInt(65));
			Codakid.spawnItem(world, pos, Main.recursiveClusterGrenade, rand.nextInt(65));
			Codakid.spawnItem(world, pos, Main.boomGun, rand.nextInt(65));
			Codakid.spawnItem(world, pos, Main.eraserHammer, rand.nextInt(2));
			Codakid.spawnItem(world, pos, Main.luckyBlockLauncher, rand.nextInt(65));
			Codakid.spawnItem(world, pos, Main.godIngot, rand.nextInt(65));
			Codakid.spawnItem(world, pos, Main.godSword, rand.nextInt(2));
			Codakid.spawnItem(world, pos, Main.godPickaxe, rand.nextInt(2));
			Codakid.spawnItem(world, pos, Main.godShovel, rand.nextInt(2));
			Codakid.spawnItem(world, pos, Main.godAxe, rand.nextInt(2));
			Codakid.spawnItem(world, pos, Main.godHoe, rand.nextInt(2));
			Codakid.spawnItem(world, pos, Main.myHelmet, rand.nextInt(2));
			Codakid.spawnItem(world, pos, Main.myChestplate, rand.nextInt(2));
			Codakid.spawnItem(world, pos, Main.myLeggings, rand.nextInt(2));
			Codakid.spawnItem(world, pos, Main.myBoots, rand.nextInt(2));
			Codakid.spawnItem(world, pos, Main.myBuildGrenade, rand.nextInt(65));
			Codakid.spawnItem(world, pos, Main.myCustomGrenade, rand.nextInt(65));
			Codakid.spawnItem(world, pos, Main.myClusterGrenade, rand.nextInt(65));
			Codakid.spawnItem(world, pos, Main.cowGun, rand.nextInt(65));
			Codakid.spawnItem(world, pos, Main.myHammer, rand.nextInt(2));
			Codakid.spawnItem(world, pos, Main.lavaLauncher, rand.nextInt(65));
			Codakid.spawnItem(world, pos, Main.myIngot, rand.nextInt(65));
			Codakid.spawnItem(world, pos, Main.mySword, rand.nextInt(2));
			Codakid.spawnItem(world, pos, Main.myPickaxe, rand.nextInt(2));
			Codakid.spawnItem(world, pos, Main.myShovel, rand.nextInt(2));
			Codakid.spawnItem(world, pos, Main.myAxe, rand.nextInt(2));
			Codakid.spawnItem(world, pos, Main.myHoe, rand.nextInt(2));
			Codakid.spawnItem(world, pos, Main.mysticalHelmet, rand.nextInt(2));
			Codakid.spawnItem(world, pos, Main.mysticalChestplate, rand.nextInt(2));
			Codakid.spawnItem(world, pos, Main.mysticalLeggings, rand.nextInt(2));
			Codakid.spawnItem(world, pos, Main.mysticalBoots, rand.nextInt(2));
			Codakid.spawnItem(world, pos, Main.myNuke, rand.nextInt(65));
			Codakid.spawnItem(world, pos, Main.eraserGrenade, rand.nextInt(65));
			Codakid.spawnItem(world, pos, Main.levitationGun, rand.nextInt(65));
			Codakid.spawnItem(world, pos, Main.portalHammer, rand.nextInt(2));
			Codakid.spawnItem(world, pos, Main.crystalLauncher, rand.nextInt(65));
			Codakid.spawnItem(world, pos, Main.mysticalIngot, rand.nextInt(65));
			Codakid.spawnItem(world, pos, Main.mysticalSword, rand.nextInt(2));
			Codakid.spawnItem(world, pos, Main.mysticalPickaxe, rand.nextInt(2));
			Codakid.spawnItem(world, pos, Main.mysticalShovel, rand.nextInt(2));
			Codakid.spawnItem(world, pos, Main.mysticalAxe, rand.nextInt(2));
			Codakid.spawnItem(world, pos, Main.mysticalHoe, rand.nextInt(2));
			Codakid.spawnItem(world, pos, Main.worldBuildGrenade, rand.nextInt(65));
			Codakid.spawnItem(world, pos, Main.worldErasingGrenade, rand.nextInt(65));
			Codakid.spawnItem(world, pos, Main.worldEndGrenade, rand.nextInt(65));
			Codakid.spawnItem(world, pos, Main.worldEraserGrenade, rand.nextInt(65));
			for (int g=0;g<rand.nextInt(65);g++) {
				Codakid.spawnEntity(world, pos, new GodLord(world));
			}
			for (int r=0;r<rand.nextInt(65);r++) {
				Codakid.spawnEntity(world, pos, new RadiantLord(world));
			}
			for (int m=0;m<rand.nextInt(65);m++) {
				Codakid.spawnEntity(world, pos, new MysticalLord(world));
			}
			for (int i=1;i<=5;i++) {
				ItemStack heat = new ItemStack(Items.ENCHANTED_BOOK,rand.nextInt(65));
				heat.addEnchantment(Main.heatEnchant, i);
				world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), heat));
				ItemStack slowTouch = new ItemStack(Items.ENCHANTED_BOOK,rand.nextInt(65));
				slowTouch.addEnchantment(Main.slowTouchEnchant, i);
				world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), slowTouch));
			}
		}
		else if(number<=285)
		{
			Codakid.spawnBlock(world, pos, Main.godBlock, 1);
			Codakid.spawnBlock(world, pos, Main.godLuckyBlock, 1);
			Codakid.spawnBlock(world, pos, Main.godSmallStructure, 1);
			Codakid.spawnBlock(world, pos, Main.godOre, 1);
			Codakid.spawnBlock(world, pos, Main.radiantBlock, 1);
			Codakid.spawnBlock(world, pos, Main.luckyBlock, 1);
			Codakid.spawnBlock(world, pos, Main.myStructure, 1);
			Codakid.spawnBlock(world, pos, Main.myOre, 1);
			Codakid.spawnBlock(world, pos, Main.mysticalBlock, 1);
			Codakid.spawnBlock(world, pos, Main.mysticalLuckyBlock, 1);
			Codakid.spawnBlock(world, pos, Main.mysticalSmallStructure, 1);
			Codakid.spawnBlock(world, pos, Main.mysticalOre, 1);
			Codakid.spawnBlock(world, pos, Main.tntTower, 1);
			Codakid.spawnItem(world, pos, Main.godHelmet, 1);
			Codakid.spawnItem(world, pos, Main.godChestplate, 1);
			Codakid.spawnItem(world, pos, Main.godLeggings, 1);
			Codakid.spawnItem(world, pos, Main.godBoots, 1);
			Codakid.spawnItem(world, pos, Main.godBuildGrenade, 1);
			Codakid.spawnItem(world, pos, Main.godEraserGrenade, 1);
			Codakid.spawnItem(world, pos, Main.recursiveClusterGrenade, 1);
			Codakid.spawnItem(world, pos, Main.boomGun, 1);
			Codakid.spawnItem(world, pos, Main.eraserHammer, 1);
			Codakid.spawnItem(world, pos, Main.luckyBlockLauncher, 1);
			Codakid.spawnItem(world, pos, Main.godIngot, 1);
			Codakid.spawnItem(world, pos, Main.godSword, 1);
			Codakid.spawnItem(world, pos, Main.godPickaxe, 1);
			Codakid.spawnItem(world, pos, Main.godShovel, 1);
			Codakid.spawnItem(world, pos, Main.godAxe, 1);
			Codakid.spawnItem(world, pos, Main.godHoe, 1);
			Codakid.spawnItem(world, pos, Main.myHelmet, 1);
			Codakid.spawnItem(world, pos, Main.myChestplate, 1);
			Codakid.spawnItem(world, pos, Main.myLeggings, 1);
			Codakid.spawnItem(world, pos, Main.myBoots, 1);
			Codakid.spawnItem(world, pos, Main.myBuildGrenade, 1);
			Codakid.spawnItem(world, pos, Main.myCustomGrenade, 1);
			Codakid.spawnItem(world, pos, Main.myClusterGrenade, 1);
			Codakid.spawnItem(world, pos, Main.cowGun, 1);
			Codakid.spawnItem(world, pos, Main.myHammer, 1);
			Codakid.spawnItem(world, pos, Main.lavaLauncher, 1);
			Codakid.spawnItem(world, pos, Main.myIngot, 1);
			Codakid.spawnItem(world, pos, Main.mySword, 1);
			Codakid.spawnItem(world, pos, Main.myPickaxe, 1);
			Codakid.spawnItem(world, pos, Main.myShovel, 1);
			Codakid.spawnItem(world, pos, Main.myAxe, 1);
			Codakid.spawnItem(world, pos, Main.myHoe, 1);
			Codakid.spawnItem(world, pos, Main.mysticalHelmet, 1);
			Codakid.spawnItem(world, pos, Main.mysticalChestplate, 1);
			Codakid.spawnItem(world, pos, Main.mysticalLeggings, 1);
			Codakid.spawnItem(world, pos, Main.mysticalBoots, 1);
			Codakid.spawnItem(world, pos, Main.myNuke, 1);
			Codakid.spawnItem(world, pos, Main.eraserGrenade, 1);
			Codakid.spawnItem(world, pos, Main.levitationGun, 1);
			Codakid.spawnItem(world, pos, Main.portalHammer, 1);
			Codakid.spawnItem(world, pos, Main.crystalLauncher, 1);
			Codakid.spawnItem(world, pos, Main.mysticalIngot, 1);
			Codakid.spawnItem(world, pos, Main.mysticalSword, 1);
			Codakid.spawnItem(world, pos, Main.mysticalPickaxe, 1);
			Codakid.spawnItem(world, pos, Main.mysticalShovel, 1);
			Codakid.spawnItem(world, pos, Main.mysticalAxe, 1);
			Codakid.spawnItem(world, pos, Main.mysticalHoe, 1);
			Codakid.spawnItem(world, pos, Main.worldBuildGrenade, 1);
			Codakid.spawnItem(world, pos, Main.worldErasingGrenade, 1);
			Codakid.spawnItem(world, pos, Main.worldEndGrenade, 1);
			Codakid.spawnItem(world, pos, Main.worldEraserGrenade, 1);
			Codakid.spawnEntity(world, pos, new GodLord(world));
			Codakid.spawnEntity(world, pos, new RadiantLord(world));
			Codakid.spawnEntity(world, pos, new MysticalLord(world));
			for (int i=1;i<=5;i++) {
				ItemStack heat = new ItemStack(Items.ENCHANTED_BOOK);
				heat.addEnchantment(Main.heatEnchant, i);
				world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), heat));
				ItemStack slowTouch = new ItemStack(Items.ENCHANTED_BOOK);
				slowTouch.addEnchantment(Main.slowTouchEnchant, i);
				world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), slowTouch));
			}
			
//			Item heat = new ItemEnchantedBook().addEnchantment(p_92115_0_, Main.heatEnchant);;
			
//			Codakid.spawnItem(world, pos, , 1);
		}
	}

}
