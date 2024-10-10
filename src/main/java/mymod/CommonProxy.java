package mymod;

import mymod.CodakidFiles.Codakid;
import mymod.CodakidFiles.RenderCustomExplosion;
import mymod.CodakidFiles.RenderCustomExplosion.FactoryCE;
import mymod.CodakidFiles.RenderGodGrenadeBuild;
import mymod.CodakidFiles.RenderGodGrenadeBuild.FactoryGBG;
import mymod.CodakidFiles.RenderGodGrenadeEraser;
import mymod.CodakidFiles.RenderGodGrenadeEraser.FactoryGEG;
import mymod.CodakidFiles.RenderGrenadeBuild;
import mymod.CodakidFiles.RenderGrenadeBuild.FactoryBG;
import mymod.CodakidFiles.RenderGrenadeCluster;
import mymod.CodakidFiles.RenderGrenadeClusterFragment;
import mymod.CodakidFiles.RenderGrenadeClusterFragment.FactoryCGF;
import mymod.CodakidFiles.RenderGrenadeCluster.FactoryCG;
import mymod.CodakidFiles.RenderGrenadeCustom;
import mymod.CodakidFiles.RenderGrenadeCustom.FactoryG;
import mymod.CodakidFiles.RenderGrenadeEraser;
import mymod.CodakidFiles.RenderGrenadeEraser.FactoryEG;
import mymod.CodakidFiles.RenderGrenadeRecursiveCluster;
import mymod.CodakidFiles.RenderGrenadeWorldEnd;
import mymod.CodakidFiles.RenderGrenadeWorldEnd.FactoryWEG;
import mymod.CodakidFiles.RenderGrenadeRecursiveCluster.FactoryRCG;
import mymod.CodakidFiles.RenderRadiantLord;
import mymod.CodakidFiles.RenderNukeCustom;
import mymod.CodakidFiles.RenderNukeCustom.FactoryN;
import mymod.CodakidFiles.RenderWorldGrenadeBuild;
import mymod.CodakidFiles.RenderWorldGrenadeBuild.FactoryWGBR;
import mymod.CodakidFiles.RenderWorldGrenadeEraser;
import mymod.CodakidFiles.RenderWorldGrenadeEraser.FactoryWERG;
import mymod.CodakidFiles.RenderWorldGrenadeErasing;
import mymod.CodakidFiles.RenderWorldGrenadeErasing.FactoryWGER;
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
import mymod._07_BuildAndBoom.EntityBuildGrenade;
import mymod._07_BuildAndBoom.EntityClusterGrenade;
import mymod._07_BuildAndBoom.EntityClusterGrenadeFragment;
import mymod._07_BuildAndBoom.EntityCustomExplosion;
import mymod._07_BuildAndBoom.EntityEraserGrenade;
import mymod._07_BuildAndBoom.EntityGodBuildGrenade;
import mymod._07_BuildAndBoom.EntityGodEraserGrenade;
import mymod._07_BuildAndBoom.EntityGrenade;
import mymod._07_BuildAndBoom.EntityRecursiveClusterGrenade;
import mymod._07_BuildAndBoom.EntityWorldBuildGrenade;
import mymod._07_BuildAndBoom.EntityWorldEndGrenade;
import mymod._07_BuildAndBoom.EntityWorldEraserGrenade;
import mymod._07_BuildAndBoom.EntityWorldErasingGrenade;
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
    	Codakid.registerItem(Main.myCustomGrenade, "my_grenade");
    	Codakid.registerItem(Main.myClusterGrenade, "my_cluster_grenade");
    	Codakid.registerItem(Main.myBuildGrenade, "my_build_grenade");
    	Codakid.registerItem(Main.cowGun, "cow_gun");
    	Codakid.registerItem(Main.lavaLauncher, "lava_launcher");
    	Codakid.registerItem(Main.myHammer, "my_hammer");
    	Codakid.registerBlock(Main.luckyBlock, "lucky_block");
    	Codakid.registerItem(Main.myHelmet, "my_helmet");
    	Codakid.registerItem(Main.myChestplate, "my_chestplate");
    	Codakid.registerItem(Main.myLeggings, "my_leggings");
    	Codakid.registerItem(Main.myBoots, "my_boots");
    	Codakid.registerItem(Main.myPickaxe, "my_pickaxe");
	    Codakid.registerItem(Main.mySword, "my_sword");
	    Codakid.registerItem(Main.myIngot, "my_ingot");
    	Codakid.registerBlock(Main.myOre, "my_ore");
    	Codakid.registerItem(Main.myNuke, "my_nuke");
    	Codakid.registerItem(Main.levitationGun, "levitation_gun");
    	Codakid.registerItem(Main.crystalLauncher, "crystal_launcher");
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
    	Codakid.registerItem(Main.portalHammer, "portal_hammer");
    	Codakid.registerItem(Main.luckyBlockLauncher, "lucky_block_launcher");
    	Codakid.registerBlock(Main.mysticalLuckyBlock, "mystical_lucky_block");
    	Codakid.registerBlock(Main.godLuckyBlock, "god_lucky_block");
    	Codakid.registerBlock(Main.mysticalOre, "mystical_ore");
    	Codakid.registerBlock(Main.godOre, "god_ore");
    	Codakid.registerBlock(Main.godBlock, "god_block");
    	Codakid.registerBlock(Main.radiantBlock, "radiant_block");
    	Codakid.registerBlock(Main.mysticalBlock, "mystical_block");
    	Codakid.registerItem(Main.godBuildGrenade, "god_build_grenade");
    	Codakid.registerItem(Main.boomGun, "boom_gun");
    	Codakid.registerItem(Main.godEraserGrenade, "god_eraser_grenade");
    	Codakid.registerItem(Main.eraserGrenade, "my_eraser_grenade");
    	Codakid.registerItem(Main.eraserHammer, "eraser_hammer");
    	Codakid.registerItem(Main.recursiveClusterGrenade, "recursive_cluster_grenade");
    	Codakid.registerItem(Main.myAxe, "my_axe");
    	Codakid.registerItem(Main.myHoe, "my_hoe");
    	Codakid.registerItem(Main.myShovel, "my_shovel");
    	Codakid.registerItem(Main.mysticalAxe, "mystical_axe");
    	Codakid.registerBlock(Main.myStructure, "my_structure");
    	Codakid.registerBlock(Main.mysticalSmallStructure, "mystical_small_structure");
    	Codakid.registerBlock(Main.godSmallStructure, "god_small_structure");
    	//Codakid.registerBlock(Main.radiantBigStructure, "radiant_big_structure");
    	Codakid.registerBlock(Main.mysticalLuckyBlockF, "mystical_lucky_block_f");
    	Codakid.registerBlock(Main.godLuckyBlockF, "god_lucky_block_f");
    	Codakid.registerBlock(Main.luckyBlockF, "lucky_block_f");
    	Codakid.registerItem(Main.godlyPotionOrb, "godly_potion_orb");
    	Codakid.registerBlock(Main.tntTower, "tnt_tower");
    	Codakid.registerItem(Main.worldEndGrenade, "world_end_grenade");
    	Codakid.registerItem(Main.worldEraserGrenade, "world_eraser_grenade");
    	Codakid.registerItem(Main.worldErasingGrenade, "world_erasing_grenade");
    	Codakid.registerItem(Main.worldBuildGrenade, "world_build_grenade");
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
    	Codakid.registerBlock(Main.worldEndingLuckyBlock, "world_ending_lucky_block");
    	Codakid.registerItem(Main.destructionHelmet, "destruction_helmet");
    	Codakid.registerItem(Main.destructionChestplate, "destruction_chestplate");
    	Codakid.registerItem(Main.destructionLeggings, "destruction_leggings");
    	Codakid.registerItem(Main.destructionBoots, "destruction_boots");
//    	Codakid.registerItem(Main.customExplosion, "custom_explosion");
    	Codakid.registerItem(Main.destructionSword, "destruction_sword");
    	Codakid.registerItem(Main.explosionHammer, "explosion_hammer");
    	Codakid.registerItem(Main.godSwordL, "legend_god_sword");
    	Codakid.registerItem(Main.mysticalSwordL, "legend_mystical_sword");
    	Codakid.registerItem(Main.radiantSwordL, "legend_radiant_sword");
    	Codakid.registerItem(Main.destructionSwordL, "legend_destruction_sword");
    	MinecraftForge.EVENT_BUS.register(new CustomEvents());
    	
    	
    	//************* REGISTER MOBS ***************
    	Codakid.registerMobEntity(RadiantLord.class, "my_monster", RenderRadiantLord.FACTORY, Color.RED.getRGB(), Color.YELLOW.getRGB());
    	EntityRegistry.addSpawn(RadiantLord.class, 50, 1, 2, EnumCreatureType.CREATURE, Biomes.MESA, Biomes.DESERT, Biomes.SAVANNA, Biomes.DEFAULT, Main.radiantBiome, Main.luckyBiome);
    	Codakid.registerMobEntity(GodLord.class, "god_monster", RenderGodLord.FACTORY, Color.WHITE.getRGB(), Color.YELLOW.getRGB());
    	EntityRegistry.addSpawn(GodLord.class, 50, 1, 1, EnumCreatureType.CREATURE, Biomes.ICE_MOUNTAINS, Biomes.DESERT, Biomes.EXTREME_HILLS, Biomes.DEFAULT, Main.godBiome, Main.luckyBiome);
    	Codakid.registerMobEntity(MysticalLord.class, "mystical_monster", RenderMysticalLord.FACTORY, Color.BLUE.getRGB(), Color.MAGENTA.getRGB());
    	EntityRegistry.addSpawn(MysticalLord.class, 50, 1, 1, EnumCreatureType.CREATURE, Biomes.ICE_MOUNTAINS, Biomes.FROZEN_OCEAN, Biomes.TAIGA, Biomes.ICE_PLAINS, Biomes.COLD_TAIGA, Biomes.DEFAULT, Main.mysticalBiome, Main.luckyBiome);
    	Color darkred = new Color(51,0,9);
    	Codakid.registerMobEntity(DestructionLord.class, "destruction_monster", RenderDestructionLord.FACTORY, Color.BLACK.getRGB(), darkred.getRGB());
    	EntityRegistry.addSpawn(DestructionLord.class, 50, 1, 1, EnumCreatureType.CREATURE, Biomes.DEFAULT, Main.luckyBiome);
    	
    	
    	
    	
    	
    	// ************* MAKE RENDERERS ***************
    	FactoryG renderGrenade = (FactoryG) RenderGrenadeCustom.FACTORY;
    	renderGrenade.setGrenade(Main.myCustomGrenade);
    	FactoryCG renderClusterGrenade = (FactoryCG) RenderGrenadeCluster.FACTORY;
    	renderClusterGrenade.setGrenade(Main.myClusterGrenade);
    	FactoryCGF renderClusterGrenadeFragment = (FactoryCGF) RenderGrenadeClusterFragment.FACTORY;
    	renderClusterGrenadeFragment.setGrenade(Main.myClusterGrenade);
    	FactoryBG renderBuildGrenade = (FactoryBG) RenderGrenadeBuild.FACTORY;
    	renderBuildGrenade.setGrenade(Main.myBuildGrenade);
    	
    	FactoryN renderNuke = (FactoryN) RenderNukeCustom.FACTORY;
    	renderNuke.setNuke(Main.myNuke);
    	FactoryGBG renderGodBuildGrenade = (FactoryGBG) RenderGodGrenadeBuild.FACTORY;
    	renderGodBuildGrenade.setGodGrenade(Main.godBuildGrenade);
    	FactoryGEG renderGodEraserGrenade = (FactoryGEG) RenderGodGrenadeEraser.FACTORY;
    	renderGodEraserGrenade.setGodGrenade(Main.godEraserGrenade);
    	FactoryEG renderEraserGrenade = (FactoryEG) RenderGrenadeEraser.FACTORY;
    	renderEraserGrenade.setGrenade(Main.eraserGrenade);
    	FactoryRCG renderGodClusterGrenade = (FactoryRCG) RenderGrenadeRecursiveCluster.FACTORY;
    	renderGodClusterGrenade.setGodGrenade(Main.recursiveClusterGrenade);
    	FactoryWEG renderWorldEndGrenade = (FactoryWEG) RenderGrenadeWorldEnd.FACTORY;
    	renderWorldEndGrenade.setWorldGrenade(Main.worldEndGrenade);
    	FactoryWERG renderWorldEraserGrenade = (FactoryWERG) RenderWorldGrenadeEraser.FACTORY;
    	renderWorldEraserGrenade.setWorldGrenade(Main.worldEraserGrenade);
    	FactoryWGER renderWorldErasingGrenade = (FactoryWGER) RenderWorldGrenadeErasing.FACTORY;
    	renderWorldErasingGrenade.setWorldGrenade(Main.worldErasingGrenade);
    	FactoryWGBR renderWorldBuildGrenade = (FactoryWGBR) RenderWorldGrenadeBuild.FACTORY;
    	renderWorldBuildGrenade.setWorldGrenade(Main.worldBuildGrenade);
    	for (int i=5;i<=125;i+=5) {
    		CustomExplosion customExplosion = new CustomExplosion(i);
    		Codakid.registerItem(customExplosion, "custom_explosion_"+i);
    		FactoryCE renderCustomExplosion = (FactoryCE) RenderCustomExplosion.FACTORY;
        	renderCustomExplosion.setExplosion(customExplosion);
        	Codakid.registerEntity(EntityCustomExplosion.class, "custom_explosion_"+i, renderCustomExplosion);
    	}
    	
    	
    	
        
        //************* REGISTER ENTITIES ***************
    	Codakid.registerEntity(EntityGrenade.class, "my_grenade", renderGrenade);
    	Codakid.registerEntity(EntityClusterGrenade.class, "my_cluster_grenade", renderClusterGrenade);
    	Codakid.registerEntity(EntityClusterGrenadeFragment.class, "my_cluster_grenade", renderClusterGrenadeFragment);
    	Codakid.registerEntity(EntityBuildGrenade.class, "my_build_grenade", renderBuildGrenade);
    	Codakid.registerEntity(EntityNuke.class, "my_nuke", renderNuke);
    	Codakid.registerEntity(EntityGodBuildGrenade.class, "god_build_grenade", renderGodBuildGrenade);
    	Codakid.registerEntity(EntityGodEraserGrenade.class, "god_eraser_grenade", renderGodEraserGrenade);
    	Codakid.registerEntity(EntityEraserGrenade.class, "my_eraser_grenade", renderEraserGrenade);
    	Codakid.registerEntity(EntityRecursiveClusterGrenade.class, "recursive_cluster_grenade", renderGodClusterGrenade);
    	Codakid.registerEntity(EntityWorldEndGrenade.class, "world_end_grenade", renderWorldEndGrenade);
    	Codakid.registerEntity(EntityWorldEraserGrenade.class, "world_eraser_grenade", renderWorldEraserGrenade);
    	Codakid.registerEntity(EntityWorldErasingGrenade.class, "world_erasing_grenade", renderWorldErasingGrenade);
    	Codakid.registerEntity(EntityWorldBuildGrenade.class, "world_build_grenade", renderWorldBuildGrenade);
    	
    	
    	
        
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
    	GameRegistry.addSmelting(Main.myOre, new ItemStack(Main.myIngot, 1), 2.0f);
    	GameRegistry.addSmelting(Main.mysticalOre, new ItemStack(Main.mysticalIngot, 1), 2.0f);
    	GameRegistry.addSmelting(Main.godOre, new ItemStack(Main.godIngot, 1), 2.0f);
    	
    	
    	//************* BIOME SETUP ***************
    	BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(Main.godBiome, 5));
    	BiomeManager.removeSpawnBiome(Main.godBiome);
//    	BiomeManager.addSpawnBiome(Main.myBiome);
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
