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
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.gen.feature.WorldGenEndPodium;
import net.minecraft.world.gen.feature.WorldGenerator;
import mymod.Main;
import mymod.CodakidFiles.Codakid;
import mymod._01_ForgeYourSword.RadiantLord;
import mymod._04_CreateACreature.DestructionLord;
import mymod._04_CreateACreature.GodLord;
import mymod._04_CreateACreature.MysticalLord;
import mymod._07_BuildAndBoom.EntityRadiantBuildGrenade;
import mymod._07_BuildAndBoom.EntityRadiantClusterGrenade;
import mymod._07_BuildAndBoom.EntityMysticalEraserGrenade;
import mymod._07_BuildAndBoom.EntityGodBuildGrenade;
import mymod._07_BuildAndBoom.EntityGodEraserGrenade;
import mymod._07_BuildAndBoom.EntityRadiantGrenade;
import mymod._07_BuildAndBoom.EntityGodClusterGrenade;
import mymod._07_BuildAndBoom.EntityDestructionBuildGrenade;
import mymod._07_BuildAndBoom.EntityDestructionEraserGrenade;
import mymod._07_BuildAndBoom.EntityDestructionTNTGrenade;
import net.minecraft.block.Block;
import net.minecraft.block.BlockObsidian;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DestructionLuckyBlock extends Block {
	
	public DestructionLuckyBlock() {
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
		int number = rand.nextInt(300) + 1;
		System.out.println(number);
//		number=118;
//		number=240;
//		number=270;
		EntityPlayer player=world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 50, false);
		//10% chance for 64 diamonds
		if(number <= 5)
		{
			Codakid.spawnEntity(world, pos, new EntityRadiantBuildGrenade(world));
		}
		else if(number <= 8) {
//			Codakid.spawnEntity(world, pos, new EntityWorldBuildGrenade(world));
		}
		else if(number <= 11) {
//			Codakid.spawnEntity(world, pos, new EntityWorldErasingGrenade(world));
		}
		else if(number <= 14) {
			Codakid.spawnEntity(world, pos, new EntityDestructionEraserGrenade(world));
		}
		else if(number <= 19)
		{
			Codakid.spawnEntity(world, pos, new EntityRadiantGrenade(world));
		}
		else if(number <= 24)
		{
			Codakid.spawnEntity(world, pos, new EntityMysticalEraserGrenade(world));
		}
		else if(number <= 34)
		{
			for(int i = 0; i < 25; i++)
			{
				Codakid.spawnEntity(world, pos, new EntityTNTPrimed(world));
			}
		}
		else if(number <= 49)
		{
			if (player!=null) {
				for (int x=-2;x<=2;x++) {
					for (int y=-2;y<=2;y++) {
						for (int z=-2;z<=2;z++) {
							world.setBlockState(player.getPosition().add(x,y,z), Blocks.BARRIER.getDefaultState());
						}
					}
				}
			}
		}
		else if(number <= 52)
		{
			if (player!=null) world.setBlockState(player.getPosition(), Main.barrierBox.getDefaultState());
		}
		else if(number <= 57)
		{
			world.setBlockState(pos, Blocks.DIAMOND_BLOCK.getDefaultState());
			for(int i = 0; i < 60; i++)
			{
				Codakid.spawnEntity(world, pos, new EntityTNTPrimed(world));
			}
		}
		else if(number <= 67)
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
		else if(number <= 77)
		{
			Codakid.spawnEntity(world, pos, new EntityWither(world));
		}
		else if(number <= 82)
		{
			for (int i=0;i<rand.nextInt(64)+1;i++) {
				EntityDragon dragon = new EntityDragon(world);
				dragon.getPhaseManager().setPhase(PhaseList.TAKEOFF);
				Codakid.spawnEntity(world, pos, dragon);
			}
		}
		else if(number <= 87)
		{
			for (int i=0;i<rand.nextInt(64)+1;i++) {
				Codakid.spawnEntity(world, pos, new EntityWither(world));
			}
		}
		else if(number <= 92)
		{
			Codakid.spawnEntity(world, pos, new EntityNuke(world, 0, 10, 0));
		}
		else if(number <= 97)
		{
			for(int i = 0; i < 1000; i++)
			{
				Codakid.spawnEntity(world, pos, new EntityTNTPrimed(world));
				Codakid.spawnEntity(world, pos, new EntityTNTPrimed(world));
			}
		}
		else if(number <= 102)
		{
			Codakid.spawnEntity(world, pos, new GodLord(world));
			Codakid.spawnEntity(world, pos, new RadiantLord(world));
			Codakid.spawnEntity(world, pos, new MysticalLord(world));
		}
		else if(number <= 107)
		{
			Codakid.spawnEntity(world, pos, new RadiantLord(world));
		}
		else if(number <= 113)
		{
			Codakid.spawnEntity(world, pos, new MysticalLord(world));
		}
		else if(number <= 117)
		{
			Codakid.spawnEntity(world, pos, new GodLord(world));
		}
		else if(number <= 122)
		{
			if (world.isAnyPlayerWithinRangeAt(pos.getX(), pos.getY(), pos.getZ(), 50)) {
				float p=player.rotationYaw;
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
		else if(number <= 127) {
			Codakid.spawnEntity(world, pos, new EntityRadiantClusterGrenade(world));
		}
		else if(number <= 132) {
			Codakid.spawnEntity(world, pos, new EntityGodBuildGrenade(world));
		}
		else if(number <= 137) {
			Codakid.spawnEntity(world, pos, new EntityGodEraserGrenade(world));
		}
		else if(number <= 142) {
			Codakid.spawnEntity(world, pos, new EntityGodClusterGrenade(world));
		}
		else if(number <= 145)
		{
			for (int i=0;i<rand.nextInt(64);i++) Codakid.spawnEntity(world, pos, new GodLord(world));
			for (int i=0;i<rand.nextInt(64);i++) Codakid.spawnEntity(world, pos, new RadiantLord(world));
			for (int i=0;i<rand.nextInt(64);i++) Codakid.spawnEntity(world, pos, new MysticalLord(world));
		}
		else if(number <= 150)
		{
			for (int i=0;i<rand.nextInt(64);i++) Codakid.spawnEntity(world, pos, new RadiantLord(world));
		}
		else if(number <= 156)
		{
			for (int i=0;i<rand.nextInt(64);i++) Codakid.spawnEntity(world, pos, new MysticalLord(world));
		}
		else if(number <= 160)
		{
			for (int i=0;i<rand.nextInt(64);i++) Codakid.spawnEntity(world, pos, new GodLord(world));
		}
		else if(number <= 165)
		{
			for (int x=-1;x<=1;x++) {
				for (int z=-1;z<=1;z++) {
					world.setBlockState(new BlockPos(pos.getX()+x,0,pos.getZ()+z), Main.tntTower.getDefaultState());
				}
			}
			world.setBlockState(new BlockPos(pos.getX(),1,pos.getZ()), Blocks.FIRE.getDefaultState());
		}
		else if(number <= 170) {
			if (player!=null) player.attemptTeleport(pos.getX(), -5, pos.getZ());
		}
		else if(number <= 175) {
			if (player!=null) player.noClip=true;
		}
		else if(number <= 180) {
			if (player!=null) player.onKillCommand();
		}
		else if(number <= 185) {
			if (player!=null) {
				ItemStack stack=player.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
				if (stack==null) {
					ItemStack newstack=new ItemStack(Main.godLeggings);
					newstack.addEnchantment(Main.curseOfCertainDeathEnchant,1);
					if (player!=null) player.setItemStackToSlot(EntityEquipmentSlot.LEGS, newstack);
				}
				else {
					if (EnchantmentHelper.getEnchantmentLevel(Main.curseOfCertainDeathEnchant, stack)<1) {
						stack.addEnchantment(Main.curseOfCertainDeathEnchant,1);
					}
				}
			}
		}
		else if(number <= 190) {
			if (player!=null) {
				ItemStack stack=player.getItemStackFromSlot(EntityEquipmentSlot.FEET);
				if (stack==null) {
					ItemStack newstack=new ItemStack(Main.godBoots);
					newstack.addEnchantment(Main.curseOfCertainDeathEnchant,1);
					if (player!=null) player.setItemStackToSlot(EntityEquipmentSlot.FEET, newstack);
				}
				else {
					if (EnchantmentHelper.getEnchantmentLevel(Main.curseOfCertainDeathEnchant, stack)<1) {
						stack.addEnchantment(Main.curseOfCertainDeathEnchant,1);
					}
				}
			}
		}
		else if(number <= 195) {
			if (player!=null) {
				ItemStack stack=player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
				if (stack==null) {
					ItemStack newstack=new ItemStack(Main.godHelmet);
					newstack.addEnchantment(Main.curseOfCertainDeathEnchant,1);
					if (player!=null) player.setItemStackToSlot(EntityEquipmentSlot.HEAD, newstack);
				}
				else {
					if (EnchantmentHelper.getEnchantmentLevel(Main.curseOfCertainDeathEnchant, stack)<1) {
						stack.addEnchantment(Main.curseOfCertainDeathEnchant,1);
					}
				}
			}
		}
		else if(number <= 200) {
			if (player!=null) {
				ItemStack stack=player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
				if (stack==null) {
					ItemStack newstack=new ItemStack(Main.godChestplate);
					newstack.addEnchantment(Main.curseOfCertainDeathEnchant,1);
					if (player!=null) player.setItemStackToSlot(EntityEquipmentSlot.CHEST, newstack);
				}
				else {
					if (EnchantmentHelper.getEnchantmentLevel(Main.curseOfCertainDeathEnchant, stack)<1) {
						stack.addEnchantment(Main.curseOfCertainDeathEnchant,1);
					}
				}
			}
		}
		else if(number <= 205) {
			world.getGameRules().setOrCreateGameRule("keepInventory", "false");
		}
		else if(number <= 210) {
			if (player!=null) {
				player.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS,999999999));
				player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION,999999999));
				player.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE,999999999));
				player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA,999999999));
				player.addPotionEffect(new PotionEffect(MobEffects.POISON,999999999));
				player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST,999999999,999999999));
				player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE,999999999,5));
				player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION,999999999));
				player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS,999999999,4));
				player.addPotionEffect(new PotionEffect(MobEffects.UNLUCK,999999999));
				player.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS,999999999));
			}
		}
		else if(number <= 215) {
//			if (player!=null) player.changeDimension(-1);
			if (player!=null) {
				for (int x=-2;x<=2;x++) {
					for (int y=-2;y<=2;y++) {
						for (int z=-2;z<=2;z++) {
							world.setBlockState(player.getPosition().add(x,y,z), Blocks.BARRIER.getDefaultState());
						}
					}
				}
				world.setBlockState(player.getPosition(), Blocks.PORTAL.getDefaultState());
			}
		}
		else if(number <= 220) {
//			if (player!=null) player.changeDimension(1);
			if (player!=null) {
				for (int x=-2;x<=2;x++) {
					for (int y=-2;y<=2;y++) {
						for (int z=-2;z<=2;z++) {
							world.setBlockState(player.getPosition().add(x,y,z), Blocks.BARRIER.getDefaultState());
						}
					}
				}
				world.setBlockState(player.getPosition(), Blocks.END_PORTAL.getDefaultState());
			}
		}
		else if(number <= 225) {
			if (player!=null && player.dimension!=0) player.changeDimension(0);
		}
		else if(number <= 230) {
			world.setBlockState(pos, Blocks.REDSTONE_BLOCK.getDefaultState());
			world.setBlockState(pos.add(1,0,0), Main.destructionLuckyBlock.getDefaultState());
			world.setBlockState(pos.add(-1,0,0), Main.destructionLuckyBlock.getDefaultState());
			world.setBlockState(pos.add(0,1,0), Main.destructionLuckyBlock.getDefaultState());
			world.setBlockState(pos.add(0,-1,0), Main.destructionLuckyBlock.getDefaultState());
			world.setBlockState(pos.add(0,0,1), Main.destructionLuckyBlock.getDefaultState());
			world.setBlockState(pos.add(0,0,-1), Main.destructionLuckyBlock.getDefaultState());
		}
		else if(number <= 240) {
			world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 255.0F, true);
		}
		else if(number <= 260) {
			int power = rand.nextInt(255)+1;
			world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), power, true);
			System.out.println("Power: "+power);
		}
		else if(number <= 270) {
			DestructionLord monster = new DestructionLord(world);
			monster.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Main.destructionHelmet));
			monster.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Main.destructionChestplate));
			monster.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(Main.destructionLeggings));
			monster.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(Main.destructionBoots));
			monster.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Main.destructionSword));
			Codakid.spawnEntity(world, pos, monster);
		}
		else if(number <= 280) {
			GodLord monster = new GodLord(world);
			monster.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Main.godHelmet));
			monster.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Main.godChestplate));
			monster.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(Main.godLeggings));
			monster.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(Main.godBoots));
			monster.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Main.godSword));
			Codakid.spawnEntity(world, pos, monster);
		}
		else if(number <= 290) {
			RadiantLord monster = new RadiantLord(world);
			monster.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Main.radiantHelmet));
			monster.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Main.radiantChestplate));
			monster.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(Main.radiantLeggings));
			monster.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(Main.radiantBoots));
			monster.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Main.radiantSword));
			Codakid.spawnEntity(world, pos, monster);
		}
		else if(number <= 300) {
			MysticalLord monster = new MysticalLord(world);
			monster.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Main.mysticalHelmet));
			monster.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Main.mysticalChestplate));
			monster.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(Main.mysticalLeggings));
			monster.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(Main.mysticalBoots));
			monster.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Main.mysticalSword));
			Codakid.spawnEntity(world, pos, monster);
		}
	}

}
