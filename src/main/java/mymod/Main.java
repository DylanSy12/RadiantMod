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
import mymod._01_ForgeYourSword.RadiantSword;
import mymod._01_ForgeYourSword.DestructionSword;
import mymod._01_ForgeYourSword.GodSword;
import mymod._01_ForgeYourSword.LegendDestructionSword;
import mymod._01_ForgeYourSword.LegendGodSword;
import mymod._01_ForgeYourSword.LegendMysticalSword;
import mymod._01_ForgeYourSword.LegendRadiantSword;
import mymod._01_ForgeYourSword.MysticalSword;
import mymod._02_PowerOre.RadiantAxe;
import mymod._02_PowerOre.RadiantHoe;
import mymod._02_PowerOre.RadiantIngot;
import mymod._02_PowerOre.RadiantOre;
import mymod._02_PowerOre.RadiantPickaxe;
import mymod._02_PowerOre.RadiantShovel;
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
import mymod._03_MagicArmor.RadiantArmor;
import mymod._03_MagicArmor.DestructionArmor;
import mymod._03_MagicArmor.GodArmor;
import mymod._03_MagicArmor.GodPotionOrb;
import mymod._03_MagicArmor.MysticalArmor;
import mymod._05_LuckyBlock.CustomFalling;
import mymod._05_LuckyBlock.Nuke;
import mymod._05_LuckyBlock.EntityNuke;
import mymod._05_LuckyBlock.GodLuckyBlock;
import mymod._05_LuckyBlock.GodLuckyBlockF;
import mymod._05_LuckyBlock.RadiantLuckyBlock;
import mymod._05_LuckyBlock.RadiantLuckyBlockF;
import mymod._05_LuckyBlock.MysticalLuckyBlock;
import mymod._05_LuckyBlock.MysticalLuckyBlockF;
import mymod._05_LuckyBlock.DestructionLuckyBlock;
import mymod._06_BrandNewBiomes.GodBiome;
import mymod._06_BrandNewBiomes.LuckyBiome;
import mymod._06_BrandNewBiomes.MysticalBiome;
import mymod._06_BrandNewBiomes.RadiantBiome;
import mymod._07_BuildAndBoom.RadiantBuildGrenade;
import mymod._07_BuildAndBoom.RadiantClusterGrenade;
import mymod._07_BuildAndBoom.CustomExplosion;
import mymod._07_BuildAndBoom.RadiantGrenade;
import mymod._07_BuildAndBoom.MysticalEraserGrenade;
import mymod._07_BuildAndBoom.GodBuildGrenade;
import mymod._07_BuildAndBoom.GodEraserGrenade;
import mymod._07_BuildAndBoom.GodClusterGrenade;
import mymod._07_BuildAndBoom.DestructionBuildGrenade;
import mymod._07_BuildAndBoom.DestructionClusterGrenade;
import mymod._07_BuildAndBoom.DestructionEraserGrenade;
import mymod._07_BuildAndBoom.DestructionTNTGrenade;
import mymod._08_HouseInABox.BarrierBox;
import mymod._08_HouseInABox.GodSmallStructureBlock;
import mymod._08_HouseInABox.MysticalSmallStructureBlock;
import mymod._08_HouseInABox.RadiantBigStructureBlock;
import mymod._08_HouseInABox.RadiantSmallStructureBlock;
import mymod._08_HouseInABox.TNTTower;
import mymod._09_EpicWeapons.GodGrenadeGun;
import mymod._09_EpicWeapons.RadiantTNTGun;
import mymod._09_EpicWeapons.MysticalCrystalLauncher;
import mymod._09_EpicWeapons.GodEraserSword;
import mymod._09_EpicWeapons.DestructionExplosionSword;
import mymod._09_EpicWeapons.RadiantLavaLauncher;
import mymod._09_EpicWeapons.MysticalDragonFireballGun;
import mymod._09_EpicWeapons.GodLuckyBlockLauncher;
import mymod._09_EpicWeapons.MysticalPortalSword;
import mymod._09_EpicWeapons.RadiantLightningSword;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
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
import net.minecraftforge.client.settings.IKeyConflictContext;
import net.minecraftforge.client.settings.KeyConflictContext;
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
    public static RadiantIngot radiantIngot;
    public static GodIngot godIngot;
    public static MysticalIngot mysticalIngot;
    public static RadiantGrenade radiantGrenade;
    public static RadiantClusterGrenade radiantClusterGrenade;
    public static RadiantBuildGrenade radiantBuildGrenade;
    public static RadiantTNTGun radiantTNTGun;
    public static RadiantLavaLauncher radiantLavaLauncher;
    public static ToolMaterial radiantLightningSwordMaterial;
    public static RadiantLightningSword radiantLightningSword;
    public static RadiantLuckyBlock radiantLuckyBlock;
    public static RadiantArmor radiantHelmet;
    public static RadiantArmor radiantChestplate;
    public static RadiantArmor chestplate1;
    public static RadiantArmor radiantLeggings;
    public static RadiantArmor radiantBoots;
    public static ArmorMaterial radiantArmorMaterial;
    public static ToolMaterial radiantPickaxeMaterial;
    public static RadiantPickaxe radiantPickaxe;
    public static ToolMaterial radiantSwordMaterial;
    public static RadiantSword radiantSword;
    public static RadiantOre radiantOre;
    public static Nuke nuke;
    public static MysticalDragonFireballGun mysticalDragonGun;
    public static MysticalCrystalLauncher mysticalCrystalLauncher;
    public static MysticalPickaxe mysticalPickaxe;
    public static ToolMaterial mysticalPickaxeMaterial;
    public static ToolMaterial mysticalSwordMaterial;
    public static MysticalSword mysticalSword;
    public static ArmorMaterial mysticalArmorMaterial;
    public static MysticalArmor mysticalHelmet;
    public static MysticalArmor mysticalChestplate;
    public static MysticalArmor mysticalLeggings;
    public static MysticalArmor mysticalBoots;
    public static ArmorMaterial godArmorMaterial;
    public static GodArmor godHelmet;
    public static GodArmor godChestplate;
    public static GodArmor godLeggings;
    public static GodArmor godBoots;
    public static ToolMaterial godSwordMaterial;
    public static GodSword godSword;
    public static ToolMaterial godPickaxeMaterial;
    public static GodPickaxe godPickaxe;
    public static ToolMaterial mysticalPortalSwordMaterial;
    public static MysticalPortalSword mysticalPortalSword;
    public static GodLuckyBlockLauncher godLuckyBlockLauncher;
    public static MysticalLuckyBlock mysticalLuckyBlock;
    public static GodLuckyBlock godLuckyBlock;
    public static MysticalOre mysticalOre;
    public static GodOre godOre;
    public static GodBlock godBlock;
    public static RadiantBlock radiantBlock;
    public static MysticalBlock mysticalBlock;
    public static GodBuildGrenade godBuildGrenade;
    public static GodGrenadeGun godGrenadeGun;
    public static GodEraserGrenade godEraserGrenade;
    public static MysticalEraserGrenade mysticalEraserGrenade;
    public static ToolMaterial godEraserSwordMaterial;
    public static GodEraserSword godEraserSword;
    public static GodClusterGrenade godClusterGrenade;
    public static ToolMaterial radiantAxeMaterial;
    public static RadiantAxe radiantAxe;
    public static ToolMaterial mysticalHoeMaterial;
    public static ToolMaterial radiantHoeMaterial;
    public static RadiantHoe radiantHoe;
    public static ToolMaterial radiantShovelMaterial;
    public static RadiantShovel radiantShovel;
    public static ToolMaterial mysticalAxeMaterial;
    public static MysticalAxe mysticalAxe;
    public static GodBiome godBiome;
    public static RadiantBiome radiantBiome;
    public static MysticalBiome mysticalBiome;
    public static LuckyBiome luckyBiome;
    public static RadiantSmallStructureBlock radiantSmallStructure;
    public static MysticalSmallStructureBlock mysticalSmallStructure;
    public static GodSmallStructureBlock godSmallStructure;
    public static RadiantBigStructureBlock radiantBigStructure;
    //public static final PropertyDirection FACING = BlockHorizontal.FACING;
    public static MysticalLuckyBlockF mysticalLuckyBlockF;
    public static GodLuckyBlockF godLuckyBlockF;
    public static RadiantLuckyBlockF radiantLuckyBlockF;
    public static GodPotionOrb godPotionOrb;
    public static TNTTower tntTower;
    public static DestructionClusterGrenade destructionClusterGrenade;
    public static DestructionEraserGrenade destructionEraserGrenade;
    public static DestructionTNTGrenade destructionTNTGrenade;
    public static DestructionBuildGrenade destructionBuildGrenade;
    public static CustomFalling fallingDiamond;
    public static ToolMaterial mysticalShovelMaterial;
    public static ToolMaterial godAxeMaterial;
    public static ToolMaterial godHoeMaterial;
    public static ToolMaterial godShovelMaterial;
    public static GodAxe godAxe;
    public static GodHoe godHoe;
    public static GodShovel godShovel;
    public static MysticalHoe mysticalHoe;
    public static MysticalShovel mysticalShovel;
    public static BarrierBox barrierBox;
    public static DestructionLuckyBlock destructionLuckyBlock;
    public static ArmorMaterial destructionArmorMaterial;
    public static DestructionArmor destructionHelmet;
    public static DestructionArmor destructionChestplate;
    public static DestructionArmor destructionLeggings;
    public static DestructionArmor destructionBoots;
    public static ToolMaterial destructionSwordMaterial;
    public static ToolMaterial destructionExplosionSwordMaterial;
//    public static CustomExplosion customExplosion;
    public static DestructionSword destructionSword;
    public static DestructionExplosionSword destructionExplosionSword;
    public static ToolMaterial legendGodSwordMaterial;
    public static ToolMaterial legendMysticalSwordMaterial;
    public static ToolMaterial legendRadiantSwordMaterial;
    public static ToolMaterial legendDestructionSwordMaterial;
    public static LegendGodSword godSwordL;
    public static LegendMysticalSword mysticalSwordL;
    public static LegendRadiantSword radiantSwordL;
    public static LegendDestructionSword destructionSwordL;
    public static KeyBinding keyBindSwitchDestructionSwordChargeMode;
//    public static CustomGui customGui;
//    public static int power;
//    public static final UUID MAX_HEALTH_UUID = UUID.fromString("01712f7e-776c-4d28-a28f-0fe6cb491ad9");
    

    
    
    

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	logger = event.getModLog();
    	
    	//************* INITIALIZE MATERIALS ***************
    	radiantLightningSwordMaterial = EnumHelper.addToolMaterial("RADIANT INGOT4", 5, 999999, 20f, 20f, 50);
    	radiantArmorMaterial = EnumHelper.addArmorMaterial("RADIANT INGOT3", MODID + ":radiant_armor", 999999, new int[] {12, 18, 16, 10}, 45, SoundEvents.BLOCK_ANVIL_HIT, 100);
    	radiantPickaxeMaterial = EnumHelper.addToolMaterial("RADIANT INGOT2", 5, 999999, 25f, 12f, 50);
    	radiantSwordMaterial = EnumHelper.addToolMaterial("RADIANT INGOT", 6, 999999, 30f, 50f, 50);
    	mysticalPickaxeMaterial = EnumHelper.addToolMaterial("MYSTICAL INGOT", 4, 100000, 20f, 8f, 40);
    	mysticalSwordMaterial = EnumHelper.addToolMaterial("MYSTICAL INGOT2", 5, 100000, 25f, 30f, 40);
    	mysticalArmorMaterial = EnumHelper.addArmorMaterial("MYSTICAL INGOT3", MODID + ":mystical_armor", 100000, new int[] {8, 14, 12, 6}, 40, SoundEvents.BLOCK_ANVIL_HIT, 90);
    	godArmorMaterial = EnumHelper.addArmorMaterial("GOD INGOT", MODID + ":god_armor", 999999999, new int[] {16, 22, 20, 14}, 50, SoundEvents.BLOCK_ANVIL_HIT, 300);
    	godSwordMaterial = EnumHelper.addToolMaterial("GOD INGOT2", 7, 999999999, 60f, 100f, 50);
    	godPickaxeMaterial = EnumHelper.addToolMaterial("GOD INGOT3", 6, 999999999, 55f, 75f, 50);
    	mysticalPortalSwordMaterial = EnumHelper.addToolMaterial("MYSTICAL INGOT4", 5, 999999, 15f, 15f, 40);
    	godEraserSwordMaterial = EnumHelper.addToolMaterial("GOD INGOT4", 6, 999999999, 50f, 98f, 50);
    	radiantAxeMaterial = EnumHelper.addToolMaterial("RADIANT INGOT5", 6, 999999, 29f, 53f, 50);
    	radiantHoeMaterial = EnumHelper.addToolMaterial("RADIANT INGOT6", 5, 999999, 24f, 11f, 50);
    	radiantShovelMaterial = EnumHelper.addToolMaterial("RADIANT INGOT7", 5, 999999, 23f, 10f, 50);
    	mysticalAxeMaterial = EnumHelper.addToolMaterial("MYSTICAL INGOT5", 5, 100000, 24f, 31f, 40);
    	mysticalHoeMaterial = EnumHelper.addToolMaterial("MYSTICAL INGOT6", 5, 100000, 29f, 7f, 40);
    	mysticalShovelMaterial = EnumHelper.addToolMaterial("MYSTICAL INGOT7", 5, 100000, 29f, 6f, 40);
    	godAxeMaterial = EnumHelper.addToolMaterial("GOD INGOT5", 6, 99999999, 55f, 105f, 50);
    	godHoeMaterial = EnumHelper.addToolMaterial("GOD INGOT6", 6, 99999999, 50f, 75f, 50);
    	godShovelMaterial = EnumHelper.addToolMaterial("GOD INGOT7", 6, 99999999, 50f, 70f, 50);
    	destructionArmorMaterial = EnumHelper.addArmorMaterial("DESTRUCTION INGOT", MODID + ":destruction_armor", 999999999, new int[] {20, 26, 24, 18}, 55, SoundEvents.BLOCK_ANVIL_HIT, 1000);
    	destructionSwordMaterial = EnumHelper.addToolMaterial("DESTRUCTION INGOT2", 8, 999999999, 90f, 150f, 55);
    	destructionExplosionSwordMaterial = EnumHelper.addToolMaterial("DESTRUCTION INGOT3", 7, 999999999, 80f, 130f, 55);
    	legendGodSwordMaterial = EnumHelper.addToolMaterial("GOD INGOT LEGEND", 21, 999999999, 180f, 300f, 150);
    	legendMysticalSwordMaterial = EnumHelper.addToolMaterial("MYSTICAL INGOT LEGEND", 15, 300000, 100f, 90f, 120);
    	legendRadiantSwordMaterial = EnumHelper.addToolMaterial("RADIANT INGOT LEGEND", 18, 9999999, 90f, 150f, 150);
    	legendDestructionSwordMaterial = EnumHelper.addToolMaterial("DESTRUCTION INGOT LEGEND", 24, 999999999, 270f, 450f, 165);
    	
    	
    	
    	
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
    	radiantIngot = new RadiantIngot();
    	godIngot = new GodIngot();
    	mysticalIngot = new MysticalIngot();
    	radiantGrenade = new RadiantGrenade();
    	radiantClusterGrenade = new RadiantClusterGrenade();
    	radiantBuildGrenade = new RadiantBuildGrenade();
    	radiantTNTGun = new RadiantTNTGun();
    	radiantLavaLauncher = new RadiantLavaLauncher();
    	radiantLightningSword = new RadiantLightningSword();
    	radiantLuckyBlock = new RadiantLuckyBlock();
    	radiantHelmet = new RadiantArmor(1, EntityEquipmentSlot.HEAD);
    	radiantChestplate = new RadiantArmor(1, EntityEquipmentSlot.CHEST);
    	radiantLeggings = new RadiantArmor(2, EntityEquipmentSlot.LEGS);
    	radiantBoots = new RadiantArmor(1, EntityEquipmentSlot.FEET);
    	radiantPickaxe = new RadiantPickaxe();
    	radiantSword = new RadiantSword();
    	radiantOre = new RadiantOre();
    	nuke = new Nuke();
    	mysticalDragonGun = new MysticalDragonFireballGun();
    	mysticalCrystalLauncher = new MysticalCrystalLauncher();
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
    	mysticalPortalSword = new MysticalPortalSword();
    	godLuckyBlockLauncher = new GodLuckyBlockLauncher();
    	mysticalLuckyBlock = new MysticalLuckyBlock();
    	godLuckyBlock = new GodLuckyBlock();
    	mysticalOre = new MysticalOre();
    	godOre = new GodOre();
    	godBlock = new GodBlock();
    	radiantBlock = new RadiantBlock();
    	mysticalBlock = new MysticalBlock();
    	godBuildGrenade = new GodBuildGrenade();
    	godGrenadeGun = new GodGrenadeGun();
    	godEraserGrenade = new GodEraserGrenade();
    	mysticalEraserGrenade = new MysticalEraserGrenade();
    	godEraserSword = new GodEraserSword();
    	godClusterGrenade = new GodClusterGrenade();
    	radiantAxe = new RadiantAxe();
    	radiantHoe = new RadiantHoe();
    	radiantShovel = new RadiantShovel();
    	mysticalAxe = new MysticalAxe();
    	godBiome = new GodBiome();
    	radiantBiome = new RadiantBiome();
    	mysticalBiome = new MysticalBiome();
    	luckyBiome = new LuckyBiome();
    	radiantSmallStructure = new RadiantSmallStructureBlock();
    	mysticalSmallStructure = new MysticalSmallStructureBlock();
    	godSmallStructure = new GodSmallStructureBlock();
    	radiantBigStructure = new RadiantBigStructureBlock();
    	mysticalLuckyBlockF = new MysticalLuckyBlockF();
    	godLuckyBlockF = new GodLuckyBlockF();
    	radiantLuckyBlockF = new RadiantLuckyBlockF();
    	godPotionOrb = new GodPotionOrb();
    	tntTower = new TNTTower();
    	destructionClusterGrenade = new DestructionClusterGrenade();
    	destructionEraserGrenade = new DestructionEraserGrenade();
    	destructionTNTGrenade = new DestructionTNTGrenade();
    	destructionBuildGrenade = new DestructionBuildGrenade();
    	fallingDiamond = new CustomFalling(Blocks.DIAMOND_BLOCK);
    	godAxe = new GodAxe();
    	mysticalHoe = new MysticalHoe();
    	mysticalShovel = new MysticalShovel();
    	godHoe = new GodHoe();
    	godShovel = new GodShovel();
    	barrierBox = new BarrierBox();
    	destructionLuckyBlock = new DestructionLuckyBlock();
    	destructionHelmet = new DestructionArmor(1, EntityEquipmentSlot.HEAD);
    	destructionChestplate = new DestructionArmor(1, EntityEquipmentSlot.CHEST);
    	destructionLeggings = new DestructionArmor(2, EntityEquipmentSlot.LEGS);
    	destructionBoots = new DestructionArmor(1, EntityEquipmentSlot.FEET);
//    	customExplosion = new CustomExplosion(power);
    	destructionSword = new DestructionSword();
    	destructionExplosionSword = new DestructionExplosionSword();
    	godSwordL = new LegendGodSword();
    	mysticalSwordL = new LegendMysticalSword();
    	radiantSwordL = new LegendRadiantSword();
    	destructionSwordL = new LegendDestructionSword();
    	keyBindSwitchDestructionSwordChargeMode = new KeyBinding("key.switch_destruction_sword_charge_mode", KeyConflictContext.IN_GAME, 50, "key.categories.gameplay");
//    	customGui = new CustomGui(Minecraft.getMinecraft());
    	
    	
    	
    	
    	
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