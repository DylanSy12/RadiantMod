package mymod._03_MagicArmor;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.jar.Attributes;

import javax.annotation.Nullable;
import javax.xml.stream.events.Attribute;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

import mymod.Main;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentDurability;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.walkers.BlockEntityTag;
import net.minecraft.util.datafix.walkers.EntityTag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.client.model.obj.OBJModel.Material;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DestructionArmor extends ItemArmor {
	private int regenTick;
    private static final UUID[] ARMOR_MODIFIERS = new UUID[] {UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"), UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"), UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"), UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150")};
    private static Map<EntityEquipmentSlot, Integer> HEALTH_MODIFIERS = new HashMap();
    static {
    	HEALTH_MODIFIERS.put(EntityEquipmentSlot.HEAD, 9);
    	HEALTH_MODIFIERS.put(EntityEquipmentSlot.CHEST, 14);
    	HEALTH_MODIFIERS.put(EntityEquipmentSlot.LEGS, 11);
    	HEALTH_MODIFIERS.put(EntityEquipmentSlot.FEET, 6);
    }
    
    public DestructionArmor(int renderIndexIn, EntityEquipmentSlot armorType) {
		super(Main.myArmorMaterial4, renderIndexIn, armorType);
		this.setCreativeTab(CreativeTabs.COMBAT);
		this.regenTick = 0;
		this.setMaxDamage(999999999);
	}
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		stack.addEnchantment(Main.blindingLightEnchant, 4);
		stack.addEnchantment(Main.heatEnchant, 4);
		stack.addEnchantment(Enchantments.BLAST_PROTECTION, 3);
		stack.addEnchantment(Enchantments.FIRE_PROTECTION, 3);
		stack.addEnchantment(Enchantments.MENDING, 1);
		stack.addEnchantment(Enchantments.PROJECTILE_PROTECTION, 3);
		stack.addEnchantment(Enchantments.PROTECTION, 3);
		stack.addEnchantment(Enchantments.THORNS, 2);
		stack.addEnchantment(Enchantments.UNBREAKING, 2);
		if (stack.getItem().isValidArmor(stack, EntityEquipmentSlot.CHEST, playerIn)) {
			stack.addEnchantment(Main.shieldEnchant, 4);
			stack.addEnchantment(Main.repulsionEnchant, 3);
		}
		if (stack.getItem().isValidArmor(stack, EntityEquipmentSlot.FEET, playerIn)) {
			stack.addEnchantment(Enchantments.DEPTH_STRIDER, 1);
			stack.addEnchantment(Enchantments.FEATHER_FALLING, 3);
		}
		if (stack.getItem().isValidArmor(stack, EntityEquipmentSlot.HEAD, playerIn)) {
			stack.addEnchantment(Enchantments.AQUA_AFFINITY, 1);
			stack.addEnchantment(Enchantments.RESPIRATION, 2);
		}
	}
	@Override
	public void onArmorTick(World worldIn, EntityPlayer playerIn, ItemStack itemIn) {
		if (EnchantmentHelper.getEnchantmentLevel(Main.blindingLightEnchant, itemIn) < 4) {
			itemIn.addEnchantment(Main.blindingLightEnchant, 4);
		}
		if (EnchantmentHelper.getEnchantmentLevel(Main.heatEnchant, itemIn) < 4) {
			itemIn.addEnchantment(Main.heatEnchant, 4);
		}
		if (EnchantmentHelper.getEnchantmentLevel(Main.shieldEnchant, itemIn) < 4 && itemIn.getItem().isValidArmor(itemIn, EntityEquipmentSlot.CHEST, playerIn)) {
			itemIn.addEnchantment(Main.shieldEnchant, 4);
		}
		if (EnchantmentHelper.getEnchantmentLevel(Main.repulsionEnchant, itemIn) < 3 && itemIn.getItem().isValidArmor(itemIn, EntityEquipmentSlot.CHEST, playerIn)) {
			itemIn.addEnchantment(Main.repulsionEnchant, 3);
		}
		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.RESPIRATION, itemIn) < 2 && itemIn.getItem().isValidArmor(itemIn, EntityEquipmentSlot.HEAD, playerIn)) {
			itemIn.addEnchantment(Enchantments.RESPIRATION, 2);
		}
		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.AQUA_AFFINITY, itemIn) < 1 && itemIn.getItem().isValidArmor(itemIn, EntityEquipmentSlot.HEAD, playerIn)) {
			itemIn.addEnchantment(Enchantments.AQUA_AFFINITY, 1);
		}
		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.DEPTH_STRIDER, itemIn) < 1 && itemIn.getItem().isValidArmor(itemIn, EntityEquipmentSlot.FEET, playerIn)) {
			itemIn.addEnchantment(Enchantments.DEPTH_STRIDER, 1);
		}
		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FEATHER_FALLING, itemIn) < 3 && itemIn.getItem().isValidArmor(itemIn, EntityEquipmentSlot.FEET, playerIn)) {
			itemIn.addEnchantment(Enchantments.FEATHER_FALLING, 3);
		}
		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.BLAST_PROTECTION, itemIn) < 3) {
			itemIn.addEnchantment(Enchantments.BLAST_PROTECTION, 3);
		}
		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FIRE_PROTECTION, itemIn) < 3) {
			itemIn.addEnchantment(Enchantments.FIRE_PROTECTION, 3);
		}
		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.PROJECTILE_PROTECTION, itemIn) < 3) {
			itemIn.addEnchantment(Enchantments.PROJECTILE_PROTECTION, 3);
		}
		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.PROTECTION, itemIn) < 3) {
			itemIn.addEnchantment(Enchantments.PROTECTION, 3);
		}
		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.MENDING, itemIn) < 1) {
			itemIn.addEnchantment(Enchantments.MENDING, 1);
		}
		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.THORNS, itemIn) < 2) {
			itemIn.addEnchantment(Enchantments.THORNS, 2);
		}
		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.UNBREAKING, itemIn) < 2) {
			itemIn.addEnchantment(Enchantments.UNBREAKING, 2);
		}
		
		playerIn.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 450));
		if (playerIn.isPotionActive(MobEffects.REGENERATION) == false) {
			playerIn.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 450, 3));
		}
		else if (playerIn.getActivePotionEffect(MobEffects.REGENERATION).getAmplifier() < 3) {
			playerIn.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 450, 3));
		}
		if (playerIn.isPotionActive(MobEffects.GLOWING) == false) {
			playerIn.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 450));
		}
		if (playerIn.isPotionActive(MobEffects.RESISTANCE) == false) {
			playerIn.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 450, 3));
		}
		else if (playerIn.getActivePotionEffect(MobEffects.RESISTANCE).getAmplifier() < 3) {
			playerIn.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 450, 3));
		}
		if (this.regenTick >= 800){
			
			playerIn.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 1, 40));
			playerIn.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 1000000, 20));
			playerIn.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 1, 30));
			
			this.regenTick = 1;
		}
		this.regenTick++;
		if(this.armorType == EntityEquipmentSlot.FEET) {
			if (playerIn.isPotionActive(MobEffects.JUMP_BOOST) == false) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 450, 8));
			}
			else if (playerIn.getActivePotionEffect(MobEffects.JUMP_BOOST).getAmplifier() < 8) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 450, 8));
			}
			if (playerIn.isPotionActive(MobEffects.SPEED) == false){
				playerIn.addPotionEffect(new PotionEffect(MobEffects.SPEED, 450, 5));
			}
			else if (playerIn.getActivePotionEffect(MobEffects.SPEED).getAmplifier() < 5) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.SPEED, 450, 5));
			}
		}
		if(this.armorType == EntityEquipmentSlot.CHEST) {
			if (playerIn.isPotionActive(MobEffects.STRENGTH) == false) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 450, 10));
			}
			else if (playerIn.getActivePotionEffect(MobEffects.STRENGTH).getAmplifier() < 10) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 450, 10));
			}
			if (playerIn.isPotionActive(MobEffects.HASTE) == false) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.HASTE, 450, 10));
			}
			else if (playerIn.getActivePotionEffect(MobEffects.HASTE).getAmplifier() < 10) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.HASTE, 450, 10));
			}
		}
		if (this.armorType == EntityEquipmentSlot.HEAD) {
			if (playerIn.isPotionActive(MobEffects.WATER_BREATHING) == false) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 450));
			}
			if (playerIn.isPotionActive(MobEffects.LUCK) == false) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.LUCK, 450, 10));
			}
			else if (playerIn.getActivePotionEffect(MobEffects.LUCK).getAmplifier() < 10) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.LUCK, 450, 10));
			}
		}
		if (this.armorType == EntityEquipmentSlot.LEGS) {
			if (playerIn.isPotionActive(MobEffects.FIRE_RESISTANCE) == false) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 450));
			}
		}
	}
	@Override
	public boolean isDamageable()
    {
        return true;
    }
	
	/**
     * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
     */
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == this.armorType)
        {
            multimap.put(SharedMonsterAttributes.MAX_HEALTH.getName(), new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getIndex()], "Max Health", (double)HEALTH_MODIFIERS.get(this.armorType), 0));
            multimap.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName(), new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getIndex()], "Knockback Resistance", 1, 0));
        }

        return multimap;
    }
	
}
