/*************************************************************
 ****************CODAKID MINECRAFT MODDING********************
 *************************************************************/

package mymod;

import java.util.Map;
import java.util.UUID;

import org.apache.logging.log4j.Logger;

import mymod.CodakidFiles.Codakid;
import mymod.Enchantments.EnchantmentBlindingLight;
import mymod.Enchantments.EnchantmentCurseOfCertainDeath;
import mymod.Enchantments.EnchantmentCurseOfDoom;
import mymod.Enchantments.EnchantmentCurseOfRecoil;
import mymod.Enchantments.EnchantmentCurseOfRevenge;
import mymod.Enchantments.EnchantmentDeathTouch;
import mymod.Enchantments.EnchantmentDebuffingStrike;
import mymod.Enchantments.EnchantmentExperienceBoost;
import mymod.Enchantments.EnchantmentExplosiveStrike;
import mymod.Enchantments.EnchantmentHeat;
import mymod.Enchantments.EnchantmentLifeSteal;
import mymod.Enchantments.EnchantmentRepulsion;
import mymod.Enchantments.EnchantmentShield;
import mymod.Enchantments.EnchantmentSlowTouch;
import mymod.Enchantments.EnchantmentThunderingStrike;
import mymod.Enchantments.EnchantmentWitheringTouch;
import mymod._01_ForgeYourSword.CustomSword;
import mymod._01_ForgeYourSword.DestructionSword;
import mymod._01_ForgeYourSword.GodSword;
import mymod._01_ForgeYourSword.LegendDestructionSword;
import mymod._01_ForgeYourSword.LegendGodSword;
import mymod._01_ForgeYourSword.LegendMysticalSword;
import mymod._01_ForgeYourSword.LegendRadiantSword;
import mymod._01_ForgeYourSword.MysticalSword;
import mymod._02_PowerOre.CustomAxe;
import mymod._02_PowerOre.CustomHoe;
import mymod._02_PowerOre.CustomIngot;
import mymod._02_PowerOre.CustomOre;
import mymod._02_PowerOre.CustomPickaxe;
import mymod._02_PowerOre.CustomShovel;
import mymod._02_PowerOre.GodAxe;
import mymod._02_PowerOre.GodBlock;
import mymod._02_PowerOre.GodHoe;
import mymod._02_PowerOre.GodIngot;
import mymod._02_PowerOre.GodOre;
import mymod._02_PowerOre.GodPickaxe;
import mymod._02_PowerOre.GodShovel;
import mymod._02_PowerOre.MysticalAxe;
import mymod._02_PowerOre.MysticalBlock;
import mymod._02_PowerOre.MysticalHoe;
import mymod._02_PowerOre.MysticalIngot;
import mymod._02_PowerOre.MysticalOre;
import mymod._02_PowerOre.MysticalPickaxe;
import mymod._02_PowerOre.MysticalShovel;
import mymod._02_PowerOre.RadiantBlock;
import mymod._03_MagicArmor.CustomArmor;
import mymod._03_MagicArmor.DestructionArmor;
import mymod._03_MagicArmor.GodArmor;
import mymod._03_MagicArmor.GodlyPotionOrb;
import mymod._03_MagicArmor.MysticalArmor;
import mymod._05_LuckyBlock.CustomFalling;
import mymod._05_LuckyBlock.CustomNuke;
import mymod._05_LuckyBlock.EntityNuke;
import mymod._05_LuckyBlock.GodLuckyBlock;
import mymod._05_LuckyBlock.GodLuckyBlockF;
import mymod._05_LuckyBlock.LuckyBlock;
import mymod._05_LuckyBlock.LuckyBlockF;
import mymod._05_LuckyBlock.MysticalLuckyBlock;
import mymod._05_LuckyBlock.MysticalLuckyBlockF;
import mymod._05_LuckyBlock.WorldEndingLuckyBlock;
import mymod._06_BrandNewBiomes.CustomBiome;
import mymod._06_BrandNewBiomes.LuckyBiome;
import mymod._06_BrandNewBiomes.MysticalBiome;
import mymod._06_BrandNewBiomes.RadiantBiome;
import mymod._07_BuildAndBoom.BuildGrenade;
import mymod._07_BuildAndBoom.ClusterGrenade;
import mymod._07_BuildAndBoom.CustomExplosion;
import mymod._07_BuildAndBoom.CustomGrenade;
import mymod._07_BuildAndBoom.EraserGrenade;
import mymod._07_BuildAndBoom.GodBuildGrenade;
import mymod._07_BuildAndBoom.GodEraserGrenade;
import mymod._07_BuildAndBoom.RecursiveClusterGrenade;
import mymod._07_BuildAndBoom.WorldBuildGrenade;
import mymod._07_BuildAndBoom.WorldEndGrenade;
import mymod._07_BuildAndBoom.WorldEraserGrenade;
import mymod._07_BuildAndBoom.WorldErasingGrenade;
import mymod._08_HouseInABox.BarrierBox;
import mymod._08_HouseInABox.GodSmallStructureBlock;
import mymod._08_HouseInABox.MysticalSmallStructureBlock;
import mymod._08_HouseInABox.RadiantBigStructureBlock;
import mymod._08_HouseInABox.StructureBlock;
import mymod._08_HouseInABox.TNTTower;
import mymod._09_EpicWeapons.BoomGun;
import mymod._09_EpicWeapons.CowGun;
import mymod._09_EpicWeapons.CrystalLauncher;
import mymod._09_EpicWeapons.EraserHammer;
import mymod._09_EpicWeapons.ExplosionHammer;
import mymod._09_EpicWeapons.LavaLauncher;
import mymod._09_EpicWeapons.LevitationGun;
import mymod._09_EpicWeapons.LuckyBlockLauncher;
import mymod._09_EpicWeapons.PortalHammer;
import mymod._09_EpicWeapons.ThunderHammer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION, useMetadata = true)
public class Main {

    public static final String MODID = "foundations";
    public static final String MODNAME = "RADIANT Mod";
    public static final String VERSION = "0.0.1";
    
    @SidedProxy(clientSide = "mymod.CodakidFiles.ClientProxy", serverSide = "mymod.CodakidFiles.ServerProxy")
    public static CommonProxy proxy;
    @Mod.Instance
    public static Main instance;
    public static Logger logger;
    
    //************* DECLARE VARIABLES ***************
    public static EnchantmentHeat heatEnchant;
    public static EnchantmentSlowTouch slowTouchEnchant;
    public static EnchantmentBlindingLight blindingLightEnchant;
    public static EnchantmentThunderingStrike thunderingStrikeEnchant;
    public static EnchantmentCurseOfDoom curseOfDoomEnchant;
    public static EnchantmentLifeSteal lifeStealEnchant;
    public static EnchantmentShield shieldEnchant;
    public static EnchantmentExplosiveStrike explosiveStrikeEnchant;
    public static EnchantmentDeathTouch deathTouchEnchant;
    public static EnchantmentDebuffingStrike debuffingStrikeEnchant;
    public static EnchantmentWitheringTouch witheringTouchEnchant;
    public static EnchantmentExperienceBoost experienceBoostEnchant;
    public static EnchantmentCurseOfRecoil curseOfRecoilEnchant;
    public static EnchantmentCurseOfRevenge curseOfRevengeEnchant;
    public static EnchantmentRepulsion repulsionEnchant;
    public static EnchantmentCurseOfCertainDeath curseOfCertainDeathEnchant;
    public static CustomIngot myIngot;
    public static GodIngot godIngot;
    public static MysticalIngot mysticalIngot;
    public static CustomGrenade myCustomGrenade;
    public static ClusterGrenade myClusterGrenade;
    public static BuildGrenade myBuildGrenade;
    public static CowGun cowGun;
    public static LavaLauncher lavaLauncher;
    public static ToolMaterial myToolMaterial3;
    public static ThunderHammer myHammer;
    public static LuckyBlock luckyBlock;
    public static CustomArmor myHelmet;
    public static CustomArmor myChestplate;
    public static CustomArmor chestplate1;
    public static CustomArmor myLeggings;
    public static CustomArmor myBoots;
    public static ArmorMaterial myArmorMaterial;
    public static ToolMaterial myToolMaterial2;
    public static CustomPickaxe myPickaxe;
    public static ToolMaterial myToolMaterial;
    public static CustomSword mySword;
    public static CustomOre myOre;
    public static CustomNuke myNuke;
    public static LevitationGun levitationGun;
    public static CrystalLauncher crystalLauncher;
    public static MysticalPickaxe mysticalPickaxe;
    public static ToolMaterial myToolMaterial4;
    public static ToolMaterial myToolMaterial5;
    public static MysticalSword mysticalSword;
    public static ArmorMaterial myArmorMaterial2;
    public static MysticalArmor mysticalHelmet;
    public static MysticalArmor mysticalChestplate;
    public static MysticalArmor mysticalLeggings;
    public static MysticalArmor mysticalBoots;
    public static ArmorMaterial myArmorMaterial3;
    public static GodArmor godHelmet;
    public static GodArmor godChestplate;
    public static GodArmor godLeggings;
    public static GodArmor godBoots;
    public static ToolMaterial myToolMaterial6;
    public static GodSword godSword;
    public static ToolMaterial myToolMaterial7;
    public static GodPickaxe godPickaxe;
    public static ToolMaterial myToolMaterial8;
    public static PortalHammer portalHammer;
    public static LuckyBlockLauncher luckyBlockLauncher;
    public static MysticalLuckyBlock mysticalLuckyBlock;
    public static GodLuckyBlock godLuckyBlock;
    public static MysticalOre mysticalOre;
    public static GodOre godOre;
    public static GodBlock godBlock;
    public static RadiantBlock radiantBlock;
    public static MysticalBlock mysticalBlock;
    public static GodBuildGrenade godBuildGrenade;
    public static BoomGun boomGun;
    public static GodEraserGrenade godEraserGrenade;
    public static EraserGrenade eraserGrenade;
    public static ToolMaterial myToolMaterial9;
    public static EraserHammer eraserHammer;
    public static RecursiveClusterGrenade recursiveClusterGrenade;
    public static ToolMaterial myToolMaterial10;
    public static CustomAxe myAxe;
    public static ToolMaterial myToolMaterial14;
    public static ToolMaterial myToolMaterial11;
    public static CustomHoe myHoe;
    public static ToolMaterial myToolMaterial12;
    public static CustomShovel myShovel;
    public static ToolMaterial myToolMaterial13;
    public static MysticalAxe mysticalAxe;
    public static CustomBiome godBiome;
    public static RadiantBiome radiantBiome;
    public static MysticalBiome mysticalBiome;
    public static LuckyBiome luckyBiome;
    public static StructureBlock myStructure;
    public static MysticalSmallStructureBlock mysticalSmallStructure;
    public static GodSmallStructureBlock godSmallStructure;
    public static RadiantBigStructureBlock radiantBigStructure;
    //public static final PropertyDirection FACING = BlockHorizontal.FACING;
    public static MysticalLuckyBlockF mysticalLuckyBlockF;
    public static GodLuckyBlockF godLuckyBlockF;
    public static LuckyBlockF luckyBlockF;
    public static GodlyPotionOrb godlyPotionOrb;
    public static TNTTower tntTower;
    public static WorldEndGrenade worldEndGrenade;
    public static WorldEraserGrenade worldEraserGrenade;
    public static WorldErasingGrenade worldErasingGrenade;
    public static WorldBuildGrenade worldBuildGrenade;
    public static CustomFalling fallingDiamond;
    public static ToolMaterial myToolMaterial15;
    public static ToolMaterial myToolMaterial16;
    public static ToolMaterial myToolMaterial17;
    public static ToolMaterial myToolMaterial18;
    public static GodAxe godAxe;
    public static GodHoe godHoe;
    public static GodShovel godShovel;
    public static MysticalHoe mysticalHoe;
    public static MysticalShovel mysticalShovel;
    public static BarrierBox barrierBox;
    public static WorldEndingLuckyBlock worldEndingLuckyBlock;
    public static ArmorMaterial myArmorMaterial4;
    public static DestructionArmor destructionHelmet;
    public static DestructionArmor destructionChestplate;
    public static DestructionArmor destructionLeggings;
    public static DestructionArmor destructionBoots;
    public static ToolMaterial myToolMaterial19;
    public static ToolMaterial myToolMaterial20;
//    public static CustomExplosion customExplosion;
    public static DestructionSword destructionSword;
    public static ExplosionHammer explosionHammer;
    public static ToolMaterial myToolMaterial21;
    public static ToolMaterial myToolMaterial22;
    public static ToolMaterial myToolMaterial23;
    public static ToolMaterial myToolMaterial24;
    public static LegendGodSword godSwordL;
    public static LegendMysticalSword mysticalSwordL;
    public static LegendRadiantSword radiantSwordL;
    public static LegendDestructionSword destructionSwordL;
//    public static int power;
//    public static final UUID MAX_HEALTH_UUID = UUID.fromString("01712f7e-776c-4d28-a28f-0fe6cb491ad9");
    

    
    
    

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	logger = event.getModLog();
    	
    	//************* INITIALIZE MATERIALS ***************
    	myToolMaterial3 = EnumHelper.addToolMaterial("RADIANT INGOT4", 5, 999999, 20f, 20f, 50);
    	myArmorMaterial = EnumHelper.addArmorMaterial("RADIANT INGOT3", MODID + ":my_armor", 999999, new int[] {12, 18, 16, 10}, 45, SoundEvents.BLOCK_ANVIL_HIT, 100);
    	myToolMaterial2 = EnumHelper.addToolMaterial("RADIANT INGOT2", 5, 999999, 25f, 12f, 50);
    	myToolMaterial = EnumHelper.addToolMaterial("RADIANT INGOT", 6, 999999, 30f, 50f, 50);
    	myToolMaterial4 = EnumHelper.addToolMaterial("MYSTICAL INGOT", 4, 100000, 20f, 8f, 40);
    	myToolMaterial5 = EnumHelper.addToolMaterial("MYSTICAL INGOT2", 5, 100000, 25f, 30f, 40);
    	myArmorMaterial2 = EnumHelper.addArmorMaterial("MYSTICAL INGOT3", MODID + ":mystical_armor", 100000, new int[] {8, 14, 12, 6}, 40, SoundEvents.BLOCK_ANVIL_HIT, 90);
    	myArmorMaterial3 = EnumHelper.addArmorMaterial("GOD INGOT", MODID + ":god_armor", 999999999, new int[] {16, 22, 20, 14}, 50, SoundEvents.BLOCK_ANVIL_HIT, 300);
    	myToolMaterial6 = EnumHelper.addToolMaterial("GOD INGOT2", 7, 999999999, 60f, 100f, 50);
    	myToolMaterial7 = EnumHelper.addToolMaterial("GOD INGOT3", 6, 999999999, 55f, 75f, 50);
    	myToolMaterial8 = EnumHelper.addToolMaterial("MYSTICAL INGOT4", 5, 999999, 15f, 15f, 40);
    	myToolMaterial9 = EnumHelper.addToolMaterial("GOD INGOT4", 6, 999999999, 50f, 98f, 50);
    	myToolMaterial10 = EnumHelper.addToolMaterial("RADIANT INGOT5", 6, 999999, 29f, 53f, 50);
    	myToolMaterial11 = EnumHelper.addToolMaterial("RADIANT INGOT6", 5, 999999, 24f, 11f, 50);
    	myToolMaterial12 = EnumHelper.addToolMaterial("RADIANT INGOT7", 5, 999999, 23f, 10f, 50);
    	myToolMaterial13 = EnumHelper.addToolMaterial("MYSTICAL INGOT5", 5, 100000, 24f, 31f, 40);
    	myToolMaterial14 = EnumHelper.addToolMaterial("MYSTICAL INGOT6", 5, 100000, 29f, 7f, 40);
    	myToolMaterial15 = EnumHelper.addToolMaterial("MYSTICAL INGOT7", 5, 100000, 29f, 6f, 40);
    	myToolMaterial16 = EnumHelper.addToolMaterial("GOD INGOT5", 6, 99999999, 55f, 105f, 50);
    	myToolMaterial17 = EnumHelper.addToolMaterial("GOD INGOT6", 6, 99999999, 50f, 75f, 50);
    	myToolMaterial18 = EnumHelper.addToolMaterial("GOD INGOT7", 6, 99999999, 50f, 70f, 50);
    	myArmorMaterial4 = EnumHelper.addArmorMaterial("DESTRUCTION INGOT", MODID + ":destruction_armor", 999999999, new int[] {20, 26, 24, 18}, 55, SoundEvents.BLOCK_ANVIL_HIT, 1000);
    	myToolMaterial19 = EnumHelper.addToolMaterial("DESTRUCTION INGOT2", 8, 999999999, 90f, 150f, 55);
    	myToolMaterial20 = EnumHelper.addToolMaterial("DESTRUCTION INGOT3", 7, 999999999, 80f, 130f, 55);
    	myToolMaterial21 = EnumHelper.addToolMaterial("GOD INGOT LEGEND", 21, 999999999, 180f, 300f, 150);
    	myToolMaterial22 = EnumHelper.addToolMaterial("MYSTICAL INGOT LEGEND", 15, 300000, 100f, 90f, 120);
    	myToolMaterial23 = EnumHelper.addToolMaterial("RADIANT INGOT LEGEND", 18, 9999999, 90f, 150f, 150);
    	myToolMaterial24 = EnumHelper.addToolMaterial("DESTRUCTION INGOT LEGEND", 24, 999999999, 270f, 450f, 165);
    	
    	
    	
    	
    	//************* INITIALIZE VARIABLES ***************
    	heatEnchant = new EnchantmentHeat();
    	slowTouchEnchant = new EnchantmentSlowTouch();
    	blindingLightEnchant = new EnchantmentBlindingLight();
    	thunderingStrikeEnchant = new EnchantmentThunderingStrike();
    	curseOfDoomEnchant = new EnchantmentCurseOfDoom();
    	lifeStealEnchant = new EnchantmentLifeSteal();
    	shieldEnchant = new EnchantmentShield();
    	explosiveStrikeEnchant = new EnchantmentExplosiveStrike();
    	deathTouchEnchant = new EnchantmentDeathTouch();
    	debuffingStrikeEnchant = new EnchantmentDebuffingStrike();
    	witheringTouchEnchant = new EnchantmentWitheringTouch();
    	experienceBoostEnchant = new EnchantmentExperienceBoost();
    	curseOfRecoilEnchant = new EnchantmentCurseOfRecoil();
        curseOfRevengeEnchant = new EnchantmentCurseOfRevenge();
        repulsionEnchant = new EnchantmentRepulsion();
        curseOfCertainDeathEnchant = new EnchantmentCurseOfCertainDeath();
    	myIngot = new CustomIngot();
    	godIngot = new GodIngot();
    	mysticalIngot = new MysticalIngot();
    	myCustomGrenade = new CustomGrenade();
    	myClusterGrenade = new ClusterGrenade();
    	myBuildGrenade = new BuildGrenade();
    	cowGun = new CowGun();
    	lavaLauncher = new LavaLauncher();
    	myHammer = new ThunderHammer();
    	luckyBlock = new LuckyBlock();
    	myHelmet = new CustomArmor(1, EntityEquipmentSlot.HEAD);
    	myChestplate = new CustomArmor(1, EntityEquipmentSlot.CHEST);
    	myLeggings = new CustomArmor(2, EntityEquipmentSlot.LEGS);
    	myBoots = new CustomArmor(1, EntityEquipmentSlot.FEET);
    	myPickaxe = new CustomPickaxe();
    	mySword = new CustomSword();
    	myOre = new CustomOre();
    	myNuke = new CustomNuke();
    	levitationGun = new LevitationGun();
    	crystalLauncher = new CrystalLauncher();
    	mysticalPickaxe = new MysticalPickaxe();
    	mysticalSword = new MysticalSword();
    	mysticalHelmet = new MysticalArmor(1, EntityEquipmentSlot.HEAD);
    	mysticalChestplate = new MysticalArmor(1, EntityEquipmentSlot.CHEST);
    	mysticalLeggings = new MysticalArmor(2, EntityEquipmentSlot.LEGS);
    	mysticalBoots = new MysticalArmor(1, EntityEquipmentSlot.FEET);
    	godHelmet = new GodArmor(1, EntityEquipmentSlot.HEAD);
    	godChestplate = new GodArmor(1, EntityEquipmentSlot.CHEST);
    	godLeggings = new GodArmor(2, EntityEquipmentSlot.LEGS);
    	godBoots = new GodArmor(1, EntityEquipmentSlot.FEET);
    	godSword = new GodSword();
    	godPickaxe = new GodPickaxe();
    	portalHammer = new PortalHammer();
    	luckyBlockLauncher = new LuckyBlockLauncher();
    	mysticalLuckyBlock = new MysticalLuckyBlock();
    	godLuckyBlock = new GodLuckyBlock();
    	mysticalOre = new MysticalOre();
    	godOre = new GodOre();
    	godBlock = new GodBlock();
    	radiantBlock = new RadiantBlock();
    	mysticalBlock = new MysticalBlock();
    	godBuildGrenade = new GodBuildGrenade();
    	boomGun = new BoomGun();
    	godEraserGrenade = new GodEraserGrenade();
    	eraserGrenade = new EraserGrenade();
    	eraserHammer = new EraserHammer();
    	recursiveClusterGrenade = new RecursiveClusterGrenade();
    	myAxe = new CustomAxe();
    	myHoe = new CustomHoe();
    	myShovel = new CustomShovel();
    	mysticalAxe = new MysticalAxe();
    	godBiome = new CustomBiome();
    	radiantBiome = new RadiantBiome();
    	mysticalBiome = new MysticalBiome();
    	luckyBiome = new LuckyBiome();
    	myStructure = new StructureBlock();
    	mysticalSmallStructure = new MysticalSmallStructureBlock();
    	godSmallStructure = new GodSmallStructureBlock();
    	radiantBigStructure = new RadiantBigStructureBlock();
    	mysticalLuckyBlockF = new MysticalLuckyBlockF();
    	godLuckyBlockF = new GodLuckyBlockF();
    	luckyBlockF = new LuckyBlockF();
    	godlyPotionOrb = new GodlyPotionOrb();
    	tntTower = new TNTTower();
    	worldEndGrenade = new WorldEndGrenade();
    	worldEraserGrenade = new WorldEraserGrenade();
    	worldErasingGrenade = new WorldErasingGrenade();
    	worldBuildGrenade = new WorldBuildGrenade();
    	fallingDiamond = new CustomFalling(Blocks.DIAMOND_BLOCK);
    	godAxe = new GodAxe();
    	mysticalHoe = new MysticalHoe();
    	mysticalShovel = new MysticalShovel();
    	godHoe = new GodHoe();
    	godShovel = new GodShovel();
    	barrierBox = new BarrierBox();
    	worldEndingLuckyBlock = new WorldEndingLuckyBlock();
    	destructionHelmet = new DestructionArmor(1, EntityEquipmentSlot.HEAD);
    	destructionChestplate = new DestructionArmor(1, EntityEquipmentSlot.CHEST);
    	destructionLeggings = new DestructionArmor(2, EntityEquipmentSlot.LEGS);
    	destructionBoots = new DestructionArmor(1, EntityEquipmentSlot.FEET);
//    	customExplosion = new CustomExplosion(power);
    	destructionSword = new DestructionSword();
    	explosionHammer = new ExplosionHammer();
    	godSwordL = new LegendGodSword();
    	mysticalSwordL = new LegendMysticalSword();
    	radiantSwordL = new LegendRadiantSword();
    	destructionSwordL = new LegendDestructionSword();
    	
    	
    	
    	
    	
        proxy.preInit(event);
    }
    

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
    
    @SideOnly(Side.CLIENT)
    public static void initModels() {
    	Codakid.initModels();
    }

}