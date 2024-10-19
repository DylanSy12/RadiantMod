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

public class GodArmor extends ItemArmor {
    private static final UUID[] ARMOR_MODIFIERS = new UUID[] {UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"), UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"), UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"), UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150")};
    private static Map<EntityEquipmentSlot, Integer> HEALTH_MODIFIERS = new HashMap();
    static {
    	HEALTH_MODIFIERS.put(EntityEquipmentSlot.HEAD, 6);
    	HEALTH_MODIFIERS.put(EntityEquipmentSlot.CHEST, 12);
    	HEALTH_MODIFIERS.put(EntityEquipmentSlot.LEGS, 8);
    	HEALTH_MODIFIERS.put(EntityEquipmentSlot.FEET, 4);
    }
	private int regenTick;
	
	public GodArmor(int renderIndexIn, EntityEquipmentSlot armorType) {
		super(Main.godArmorMaterial, renderIndexIn, armorType);
		this.setCreativeTab(CreativeTabs.COMBAT);
		this.regenTick = 0;
		this.setMaxDamage(999999999);
	}
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		stack.addEnchantment(Main.blindingLightEnchant, 3);
	}
	@Override
	public void onArmorTick(World worldIn, EntityPlayer playerIn, ItemStack itemIn) {
		if (EnchantmentHelper.getEnchantmentLevel(Main.blindingLightEnchant, itemIn) < 3) {
			itemIn.addEnchantment(Main.blindingLightEnchant, 3);
		}
		
		playerIn.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 450));
		if (playerIn.isPotionActive(MobEffects.REGENERATION) == false) {
			playerIn.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 450, 2));
		}
		else if (playerIn.getActivePotionEffect(MobEffects.REGENERATION).getAmplifier() < 2) {
			playerIn.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 450, 2));
		}
		if (playerIn.isPotionActive(MobEffects.GLOWING) == false) {
			playerIn.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 450));
		}
		if (playerIn.isPotionActive(MobEffects.RESISTANCE) == false) {
			playerIn.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 450, 2));
		}
		else if (playerIn.getActivePotionEffect(MobEffects.RESISTANCE).getAmplifier() < 2) {
			playerIn.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 450, 2));
		}
		if (this.regenTick >= 1200){
			playerIn.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 1, 20));
			playerIn.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 1000000, 10));
			playerIn.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 1, 15));
			this.regenTick = 1;
		}
		this.regenTick++;
		if (this.armorType == EntityEquipmentSlot.FEET) {
			if (playerIn.isPotionActive(MobEffects.JUMP_BOOST) == false){
				playerIn.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 450, 7));
			}
			else if (playerIn.getActivePotionEffect(MobEffects.JUMP_BOOST).getAmplifier() < 7) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 450, 7));
			}
			if (playerIn.isPotionActive(MobEffects.SPEED) == false) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.SPEED, 450, 4));
			}
			else if (playerIn.getActivePotionEffect(MobEffects.SPEED).getAmplifier() < 4) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.SPEED, 450, 4));
			}
		}
		else if (this.armorType == EntityEquipmentSlot.CHEST) {
			if (playerIn.isPotionActive(MobEffects.STRENGTH) == false) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 450, 5));
			}
			else if (playerIn.getActivePotionEffect(MobEffects.STRENGTH).getAmplifier() < 5) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 450, 5));
			}
			if (playerIn.isPotionActive(MobEffects.HASTE) == false) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.HASTE, 450, 5));
			}
			else if (playerIn.getActivePotionEffect(MobEffects.HASTE).getAmplifier() < 5) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.HASTE, 450, 5));
			}
		}
		else if (this.armorType == EntityEquipmentSlot.HEAD) {
			if (playerIn.isPotionActive(MobEffects.WATER_BREATHING) == false) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 450));
			}
			if (playerIn.isPotionActive(MobEffects.LUCK) == false) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.LUCK, 450, 5));
			}
			else if (playerIn.getActivePotionEffect(MobEffects.LUCK).getAmplifier() < 5) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.LUCK, 450, 5));
			}
		}
		else if (this.armorType == EntityEquipmentSlot.LEGS) {
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
            multimap.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName(), new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getIndex()], "Knockback Resistance", 0.0625, 0));
        }

        return multimap;
    }
}
