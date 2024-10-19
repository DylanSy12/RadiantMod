package mymod;

import mymod.CodakidFiles.Codakid;
import mymod.CodakidFiles.RenderCustomExplosion;
import mymod.CodakidFiles.RenderCustomExplosion.FactoryCE;
import mymod.CodakidFiles.RenderGodBuildGrenade;
import mymod.CodakidFiles.RenderGodBuildGrenade.FactoryGBG;
import mymod.CodakidFiles.RenderGodEraserGrenade;
import mymod.CodakidFiles.RenderGodEraserGrenade.FactoryGEG;
import mymod.CodakidFiles.RenderRadiantBuildGrenade;
import mymod.CodakidFiles.RenderRadiantBuildGrenade.FactoryRBG;
import mymod.CodakidFiles.RenderRadiantClusterGrenade;
import mymod.CodakidFiles.RenderRadiantClusterGrenadeFragment;
import mymod.CodakidFiles.RenderRadiantClusterGrenadeFragment.FactoryRCGF;
import mymod.CodakidFiles.RenderRadiantClusterGrenade.FactoryRCG;
import mymod.CodakidFiles.RenderRadiantGrenade;
import mymod.CodakidFiles.RenderRadiantGrenade.FactoryRG;
import mymod.CodakidFiles.RenderMysticalEraserGrenade;
import mymod.CodakidFiles.RenderMysticalEraserGrenade.FactoryMEG;
import mymod.CodakidFiles.RenderGodClusterGrenade;
import mymod.CodakidFiles.RenderDestructionClusterGrenade;
import mymod.CodakidFiles.RenderDestructionClusterGrenade.FactoryDCG;
import mymod.CodakidFiles.RenderGodClusterGrenade.FactoryGCG;
import mymod.CodakidFiles.RenderRadiantLord;
import mymod.CodakidFiles.RenderNuke;
import mymod.CodakidFiles.RenderNuke.FactoryN;
import mymod.CodakidFiles.RenderDestructionBuildGrenade;
import mymod.CodakidFiles.RenderDestructionBuildGrenade.FactoryDBG;
import mymod.CodakidFiles.RenderWorldGrenadeEraser;
import mymod.CodakidFiles.RenderWorldGrenadeEraser.FactoryDEG;
import mymod.CodakidFiles.RenderWorldGrenadeErasing;
import mymod.CodakidFiles.RenderWorldGrenadeErasing.FactoryDTG;
import mymod._01_ForgeYourSword.RadiantLord;
import mymod._02_PowerOre.CustomWorldGen;
import mymod._04_CreateACreature.DestructionLord;
import mymod._04_CreateACreature.GodLord;
import mymod._04_CreateACreature.MysticalLord;
import mymod._04_CreateACreature.RenderDestructionLord;
import mymod._04_CreateACreature.RenderGodLord;
import mymod._04_CreateACreature.RenderMysticalLord;
import mymod._05_LuckyBlock.EntityNuke;
import mymod._07_BuildAndBoom.CustomExplosion;
import mymod._07_BuildAndBoom.EntityRadiantBuildGrenade;
import mymod._07_BuildAndBoom.EntityRadiantClusterGrenade;
import mymod._07_BuildAndBoom.EntityRadiantClusterGrenadeFragment;
import mymod._07_BuildAndBoom.EntityCustomExplosion;
import mymod._07_BuildAndBoom.EntityMysticalEraserGrenade;
import mymod._07_BuildAndBoom.EntityGodBuildGrenade;
import mymod._07_BuildAndBoom.EntityGodEraserGrenade;
import mymod._07_BuildAndBoom.EntityRadiantGrenade;
import mymod._07_BuildAndBoom.EntityGodClusterGrenade;
import mymod._07_BuildAndBoom.EntityDestructionBuildGrenade;
import mymod._07_BuildAndBoom.EntityDestructionClusterGrenade;
import mymod._07_BuildAndBoom.EntityDestructionEraserGrenade;
import mymod._07_BuildAndBoom.EntityDestructionTNTGrenade;
import net.minecraft.block.Block;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

import java.awt.Color;
import java.awt.color.ColorSpace;
import java.awt.image.ColorModel;

@Mod.EventBusSubscriber
public class CommonProxy {
    
    public void preInit(FMLPreInitializationEvent e) {
    	
    	//************* REGISTER BLOCKS AND ITEMS ***************
    	Codakid.registerItem(Main.radiantGrenade, "radiant_grenade");
    	Codakid.registerItem(Main.radiantClusterGrenade, "radiant_cluster_grenade");
    	Codakid.registerItem(Main.radiantBuildGrenade, "radiant_build_grenade");
    	Codakid.registerItem(Main.radiantTNTGun, "radiant_tnt_gun");
    	Codakid.registerItem(Main.radiantLavaLauncher, "radiant_lava_launcher");
    	Codakid.registerItem(Main.radiantLightningSword, "radiant_lightning_sword");
    	Codakid.registerBlock(Main.radiantLuckyBlock, "radiant_lucky_block");
    	Codakid.registerItem(Main.radiantHelmet, "radiant_helmet");
    	Codakid.registerItem(Main.radiantChestplate, "radiant_chestplate");
    	Codakid.registerItem(Main.radiantLeggings, "radiant_leggings");
    	Codakid.registerItem(Main.radiantBoots, "radiant_boots");
    	Codakid.registerItem(Main.radiantPickaxe, "radiant_pickaxe");
	    Codakid.registerItem(Main.radiantSword, "radiant_sword");
	    Codakid.registerItem(Main.radiantIngot, "radiant_ingot");
    	Codakid.registerBlock(Main.radiantOre, "radiant_ore");
    	Codakid.registerItem(Main.nuke, "nuke");
    	Codakid.registerItem(Main.mysticalDragonGun, "mystical_dragon_gun");
    	Codakid.registerItem(Main.mysticalCrystalLauncher, "mystical_crystal_launcher");
    	Codakid.registerItem(Main.mysticalIngot, "mystical_ingot");
    	Codakid.registerItem(Main.mysticalPickaxe, "mystical_pickaxe");
    	Codakid.registerItem(Main.mysticalSword, "mystical_sword");
    	Codakid.registerItem(Main.mysticalHelmet, "mystical_helmet");
    	Codakid.registerItem(Main.mysticalChestplate, "mystical_chestplate");
    	Codakid.registerItem(Main.mysticalLeggings, "mystical_leggings");
    	Codakid.registerItem(Main.mysticalBoots, "mystical_boots");
    	Codakid.registerItem(Main.godHelmet, "god_helmet");
    	Codakid.registerItem(Main.godChestplate, "god_chestplate");
    	Codakid.registerItem(Main.godLeggings, "god_leggings");
    	Codakid.registerItem(Main.godBoots, "god_boots");
    	Codakid.registerItem(Main.godSword, "god_sword");
    	Codakid.registerItem(Main.godIngot, "god_ingot");
    	Codakid.registerItem(Main.godPickaxe, "god_pickaxe");
    	Codakid.registerItem(Main.mysticalPortalSword, "mystical_portal_sword");
    	Codakid.registerItem(Main.godLuckyBlockLauncher, "god_lucky_block_launcher");
    	Codakid.registerBlock(Main.mysticalLuckyBlock, "mystical_lucky_block");
    	Codakid.registerBlock(Main.godLuckyBlock, "god_lucky_block");
    	Codakid.registerBlock(Main.mysticalOre, "mystical_ore");
    	Codakid.registerBlock(Main.godOre, "god_ore");
    	Codakid.registerBlock(Main.godBlock, "god_block");
    	Codakid.registerBlock(Main.radiantBlock, "radiant_block");
    	Codakid.registerBlock(Main.mysticalBlock, "mystical_block");
    	Codakid.registerItem(Main.godBuildGrenade, "god_build_grenade");
    	Codakid.registerItem(Main.godGrenadeGun, "god_grenade_gun");
    	Codakid.registerItem(Main.godEraserGrenade, "god_eraser_grenade");
    	Codakid.registerItem(Main.mysticalEraserGrenade, "mystical_eraser_grenade");
    	Codakid.registerItem(Main.godEraserSword, "god_eraser_sword");
    	Codakid.registerItem(Main.godClusterGrenade, "god_cluster_grenade");
    	Codakid.registerItem(Main.radiantAxe, "radiant_axe");
    	Codakid.registerItem(Main.radiantHoe, "radiant_hoe");
    	Codakid.registerItem(Main.radiantShovel, "radiant_shovel");
    	Codakid.registerItem(Main.mysticalAxe, "mystical_axe");
    	Codakid.registerBlock(Main.radiantSmallStructure, "radiant_small_structure");
    	Codakid.registerBlock(Main.mysticalSmallStructure, "mystical_small_structure");
    	Codakid.registerBlock(Main.godSmallStructure, "god_small_structure");
    	//Codakid.registerBlock(Main.radiantBigStructure, "radiant_big_structure");
    	Codakid.registerBlock(Main.mysticalLuckyBlockF, "mystical_lucky_block_f");
    	Codakid.registerBlock(Main.godLuckyBlockF, "god_lucky_block_f");
    	Codakid.registerBlock(Main.radiantLuckyBlockF, "radiant_lucky_block_f");
    	Codakid.registerItem(Main.godPotionOrb, "god_potion_orb");
    	Codakid.registerBlock(Main.tntTower, "tnt_tower");
    	Codakid.registerItem(Main.destructionClusterGrenade, "destruction_cluster_grenade");
    	Codakid.registerItem(Main.destructionEraserGrenade, "destruction_eraser_grenade");
    	Codakid.registerItem(Main.destructionTNTGrenade, "destruction_tnt_grenade");
    	Codakid.registerItem(Main.destructionBuildGrenade, "destruction_build_grenade");
    	Codakid.registerEnchantment(Main.heatEnchant, "heat", "Heat");
    	Codakid.registerEnchantment(Main.slowTouchEnchant, "slow_touch", "Slow Touch");
    	Codakid.registerEnchantment(Main.blindingLightEnchant, "blinding_light", "Blinding Light");
    	Codakid.registerEnchantment(Main.thunderingStrikeEnchant, "thundering_strike", "Thundering Strike");
    	Codakid.registerEnchantment(Main.curseOfDoomEnchant, "curse_of_doom", "Curse of Doom");
    	Codakid.registerEnchantment(Main.lifeStealEnchant, "life_steal", "Life Steal");
    	Codakid.registerEnchantment(Main.shieldEnchant, "shield", "Shield");
    	Codakid.registerEnchantment(Main.explosiveStrikeEnchant, "explosive_strike", "Explosive Strike");
    	Codakid.registerEnchantment(Main.deathTouchEnchant, "death_touch", "Death Touch");
    	Codakid.registerEnchantment(Main.debuffingStrikeEnchant, "debuffing_strike", "Debuffing Strike");
    	Codakid.registerEnchantment(Main.witheringTouchEnchant, "withering_touch", "Withering Touch");
    	Codakid.registerEnchantment(Main.experienceBoostEnchant, "experience_boost", "Experience Boost");
//    	Codakid.registerEnchantment(Main.curseOfRecoilEnchant, "curse_of_recoil", "Curse of Recoil");
    	Codakid.registerEnchantment(Main.curseOfRevengeEnchant, "curse_of_revenge", "Curse of Revenge");
    	Codakid.registerEnchantment(Main.curseOfCertainDeathEnchant, "curse_of_certain_death", "Curse of Certain Death");
    	Codakid.registerEnchantment(Main.repulsionEnchant, "repulsion", "Repulsion");
    	Codakid.registerBlock(Main.fallingDiamond, "falling_diamond");
    	Codakid.registerItem(Main.mysticalHoe, "mystical_hoe");
    	Codakid.registerItem(Main.mysticalShovel, "mystical_shovel");
    	Codakid.registerItem(Main.godAxe, "god_axe");
    	Codakid.registerItem(Main.godHoe, "god_hoe");
    	Codakid.registerItem(Main.godShovel, "god_shovel");
    	Codakid.registerBlock(Main.barrierBox, "barrier_box");
    	Codakid.registerBlock(Main.destructionLuckyBlock, "destruction_lucky_block");
    	Codakid.registerItem(Main.destructionHelmet, "destruction_helmet");
    	Codakid.registerItem(Main.destructionChestplate, "destruction_chestplate");
    	Codakid.registerItem(Main.destructionLeggings, "destruction_leggings");
    	Codakid.registerItem(Main.destructionBoots, "destruction_boots");
//    	Codakid.registerItem(Main.customExplosion, "custom_explosion");
    	Codakid.registerItem(Main.destructionSword, "destruction_sword");
    	Codakid.registerItem(Main.destructionExplosionSword, "destruction_explosion_sword");
    	Codakid.registerItem(Main.godSwordL, "legend_god_sword");
    	Codakid.registerItem(Main.mysticalSwordL, "legend_mystical_sword");
    	Codakid.registerItem(Main.radiantSwordL, "legend_radiant_sword");
    	Codakid.registerItem(Main.destructionSwordL, "legend_destruction_sword");
    	MinecraftForge.EVENT_BUS.register(new CustomEvents());
    	
    	
    	//************* REGISTER MOBS ***************
    	Codakid.registerMobEntity(RadiantLord.class, "radiant_lord", RenderRadiantLord.FACTORY, Color.RED.getRGB(), Color.YELLOW.getRGB());
    	EntityRegistry.addSpawn(RadiantLord.class, 50, 1, 2, EnumCreatureType.CREATURE, Biomes.MESA, Biomes.DESERT, Biomes.SAVANNA, Biomes.DEFAULT, Main.radiantBiome, Main.luckyBiome);
    	Codakid.registerMobEntity(GodLord.class, "god_lord", RenderGodLord.FACTORY, Color.WHITE.getRGB(), Color.YELLOW.getRGB());
    	EntityRegistry.addSpawn(GodLord.class, 50, 1, 1, EnumCreatureType.CREATURE, Biomes.ICE_MOUNTAINS, Biomes.DESERT, Biomes.EXTREME_HILLS, Biomes.DEFAULT, Main.godBiome, Main.luckyBiome);
    	Codakid.registerMobEntity(MysticalLord.class, "mystical_lord", RenderMysticalLord.FACTORY, Color.BLUE.getRGB(), Color.MAGENTA.getRGB());
    	EntityRegistry.addSpawn(MysticalLord.class, 50, 1, 1, EnumCreatureType.CREATURE, Biomes.ICE_MOUNTAINS, Biomes.FROZEN_OCEAN, Biomes.TAIGA, Biomes.ICE_PLAINS, Biomes.COLD_TAIGA, Biomes.DEFAULT, Main.mysticalBiome, Main.luckyBiome);
    	Color darkred = new Color(51, 0, 9);
    	Codakid.registerMobEntity(DestructionLord.class, "destruction_lord", RenderDestructionLord.FACTORY, Color.BLACK.getRGB(), darkred.getRGB());
    	EntityRegistry.addSpawn(DestructionLord.class, 50, 1, 1, EnumCreatureType.CREATURE, Biomes.DEFAULT, Main.luckyBiome);
    	
    	
    	
    	
    	
    	// ************* MAKE RENDERERS ***************
    	FactoryRG renderRadiantGrenade = (FactoryRG) RenderRadiantGrenade.FACTORY;
    	renderRadiantGrenade.setRadiantGrenade(Main.radiantGrenade);
    	FactoryRCG renderRadiantClusterGrenade = (FactoryRCG) RenderRadiantClusterGrenade.FACTORY;
    	renderRadiantClusterGrenade.setRadiantClusterGrenade(Main.radiantClusterGrenade);
    	FactoryRCGF renderRadiantClusterGrenadeFragment = (FactoryRCGF) RenderRadiantClusterGrenadeFragment.FACTORY;
    	renderRadiantClusterGrenadeFragment.setRadiantClusterGrenadeFragment(Main.radiantClusterGrenade);
    	FactoryRBG renderRadiantBuildGrenade = (FactoryRBG) RenderRadiantBuildGrenade.FACTORY;
    	renderRadiantBuildGrenade.setRadiantBuildGrenade(Main.radiantBuildGrenade);
    	
    	FactoryN renderNuke = (FactoryN) RenderNuke.FACTORY;
    	renderNuke.setNuke(Main.nuke);
    	FactoryGBG renderGodBuildGrenade = (FactoryGBG) RenderGodBuildGrenade.FACTORY;
    	renderGodBuildGrenade.setGodBuildGrenade(Main.godBuildGrenade);
    	FactoryGEG renderGodEraserGrenade = (FactoryGEG) RenderGodEraserGrenade.FACTORY;
    	renderGodEraserGrenade.setGodEraserGrenade(Main.godEraserGrenade);
    	FactoryMEG renderMysticalEraserGrenade = (FactoryMEG) RenderMysticalEraserGrenade.FACTORY;
    	renderMysticalEraserGrenade.setMysticalEraserGrenade(Main.mysticalEraserGrenade);
    	FactoryGCG renderGodClusterGrenade = (FactoryGCG) RenderGodClusterGrenade.FACTORY;
    	renderGodClusterGrenade.setGodClusterGrenade(Main.godClusterGrenade);
    	FactoryDCG renderDestructionClusterGrenade = (FactoryDCG) RenderDestructionClusterGrenade.FACTORY;
    	renderDestructionClusterGrenade.setDestructionClusterGrenade(Main.destructionClusterGrenade);
    	FactoryDEG renderDestructionEraserGrenade = (FactoryDEG) RenderWorldGrenadeEraser.FACTORY;
    	renderDestructionEraserGrenade.setDestructionEraserGrenade(Main.destructionEraserGrenade);
    	FactoryDTG renderDestructionTNTGrenade = (FactoryDTG) RenderWorldGrenadeErasing.FACTORY;
    	renderDestructionTNTGrenade.setDestructionTNTGrenade(Main.destructionTNTGrenade);
    	FactoryDBG renderDestructionBuildGrenade = (FactoryDBG) RenderDestructionBuildGrenade.FACTORY;
    	renderDestructionBuildGrenade.setDestructionBuildGrenade(Main.destructionBuildGrenade);
//    	for (int i=5;i<=125;i+=5) {
//    		CustomExplosion customExplosion = new CustomExplosion(i);
//    		Codakid.registerItem(customExplosion, "custom_explosion_"+i);
//    		FactoryCE renderCustomExplosion = (FactoryCE) RenderCustomExplosion.FACTORY;
//        	renderCustomExplosion.setExplosion(customExplosion);
//        	Codakid.registerEntity(EntityCustomExplosion.class, "custom_explosion_"+i, renderCustomExplosion);
//    	}
    	
    	
    	
        
        //************* REGISTER ENTITIES ***************
    	Codakid.registerEntity(EntityRadiantGrenade.class, "radiant_grenade", renderRadiantGrenade);
    	Codakid.registerEntity(EntityRadiantClusterGrenade.class, "radiant_cluster_grenade", renderRadiantClusterGrenade);
    	Codakid.registerEntity(EntityRadiantClusterGrenadeFragment.class, "radiant_cluster_grenade", renderRadiantClusterGrenadeFragment);
    	Codakid.registerEntity(EntityRadiantBuildGrenade.class, "radiant_build_grenade", renderRadiantBuildGrenade);
    	Codakid.registerEntity(EntityNuke.class, "nuke", renderNuke);
    	Codakid.registerEntity(EntityGodBuildGrenade.class, "god_build_grenade", renderGodBuildGrenade);
    	Codakid.registerEntity(EntityGodEraserGrenade.class, "god_eraser_grenade", renderGodEraserGrenade);
    	Codakid.registerEntity(EntityMysticalEraserGrenade.class, "mystical_eraser_grenade", renderMysticalEraserGrenade);
    	Codakid.registerEntity(EntityGodClusterGrenade.class, "god_cluster_grenade", renderGodClusterGrenade);
    	Codakid.registerEntity(EntityDestructionClusterGrenade.class, "destruction_cluster_grenade", renderDestructionClusterGrenade);
    	Codakid.registerEntity(EntityDestructionEraserGrenade.class, "destruction_eraser_grenade", renderDestructionEraserGrenade);
    	Codakid.registerEntity(EntityDestructionTNTGrenade.class, "destruction_tnt_grenade", renderDestructionTNTGrenade);
    	Codakid.registerEntity(EntityDestructionBuildGrenade.class, "destruction_build_grenade", renderDestructionBuildGrenade);
    	
    	
    	
        
        //************* REGISTER BIOMES ***************
    	Codakid.registerBiome(Main.godBiome);
    	Codakid.registerBiome(Main.radiantBiome);
    	Codakid.registerBiome(Main.mysticalBiome);
    	Codakid.registerBiome(Main.luckyBiome);
    	
    }

    public void init(FMLInitializationEvent e) {
        
        //************* REGISTER WORLD GEN ***************
    	GameRegistry.registerWorldGenerator(new CustomWorldGen(), 0);


        
    	//************* SMELTING RECIPES ***************
    	GameRegistry.addSmelting(Main.radiantOre, new ItemStack(Main.radiantIngot, 1), 2.0f);
    	GameRegistry.addSmelting(Main.mysticalOre, new ItemStack(Main.mysticalIngot, 1), 2.0f);
    	GameRegistry.addSmelting(Main.godOre, new ItemStack(Main.godIngot, 1), 2.0f);
    	
    	
    	//************* BIOME SETUP ***************
    	BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(Main.godBiome, 5));
    	BiomeManager.removeSpawnBiome(Main.godBiome);
//    	BiomeManager.addSpawnBiome(Main.godBiome);
    	BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(Main.radiantBiome, 6));
//    	BiomeManager.addSpawnBiome(Main.radiantBiome);
    	BiomeManager.removeSpawnBiome(Main.radiantBiome);
    	BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(Main.mysticalBiome, 7));
//    	BiomeManager.addSpawnBiome(Main.mysticalBiome);
    	BiomeManager.removeSpawnBiome(Main.mysticalBiome);
    	BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(Main.luckyBiome, 3));
//    	BiomeManager.addSpawnBiome(Main.luckyBiome);
    	BiomeManager.removeSpawnBiome(Main.luckyBiome);
    	
    	//************* REGISTER CUSTOM KEYBINDS ***************
    	ClientRegistry.registerKeyBinding(Main.keyBindSwitchDestructionSwordChargeMode);
    }
    

    public void postInit(FMLPostInitializationEvent e) {
    	
    }
    
    
    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {
    	Codakid.doBiomeRegistry(event);
    }
    
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    	Codakid.doBlockRegistry(event);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
    	Codakid.doItemRegistry(event);
    }
    
    @SubscribeEvent
	public static void registerEnchantments(RegistryEvent.Register<Enchantment> event) {
		Codakid.doEnchantmentRegistry(event);
	}

}
