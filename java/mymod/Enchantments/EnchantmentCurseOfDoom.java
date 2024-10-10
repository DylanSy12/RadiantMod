package mymod.Enchantments;

import java.util.Random;

import mymod.Main;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class EnchantmentCurseOfDoom extends Enchantment {
	public EnchantmentCurseOfDoom() {
		super(Enchantment.Rarity.VERY_RARE, EnumEnchantmentType.ARMOR, new EntityEquipmentSlot[] {EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET});
		this.setName("curse_of_doom");
	}
	/**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    public int getMinEnchantability(int enchantmentLevel)
    {
        return 25;
    }

    /**
     * Returns the maximum value of enchantability needed on the enchantment level passed.
     */
    public int getMaxEnchantability(int enchantmentLevel)
    {
        return super.getMinEnchantability(enchantmentLevel) + 50;
    }

    /**
     * Returns the maximum level that the enchantment can have.
     */
    public int getMaxLevel()
    {
        return 1;
    }
    
    /**
     * Determines if this enchantment can be applied to a specific ItemStack.
     */
    public boolean canApply(ItemStack stack)
    {
        return stack.getItem() instanceof ItemArmor ? true : super.canApply(stack);
    }

    /**
     * Whenever an entity that has this enchantment on one of its associated items is damaged this method will be
     * called.
     */
    public void onUserHurt(EntityLivingBase user, Entity attacker, int level)
    {
        Random random = user.getRNG();
        ItemStack itemstack = EnchantmentHelper.getEnchantedItem(Main.curseOfDoomEnchant, user);
        if (! EnchantmentHelper.hasBindingCurse(itemstack)) itemstack.addEnchantment(Enchantments.BINDING_CURSE,1);
        if (! EnchantmentHelper.hasVanishingCurse(itemstack)) itemstack.addEnchantment(Enchantments.VANISHING_CURSE,1);
        itemstack.setRepairCost(1000000000);
        if (shouldHit(level, random))
        {
            if (attacker != null)
            {
            	if (attacker instanceof EntityLivingBase)
                {
                    EntityLivingBase entitylivingbase = (EntityLivingBase)attacker;
                    if (itemstack.getItemDamage()<itemstack.getMaxDamage()-1) itemstack.setItemDamage(itemstack.getMaxDamage()-1);
                    entitylivingbase.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 1800));
                    entitylivingbase.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 1800));
                    entitylivingbase.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 1800));
                    entitylivingbase.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 1800));
                    entitylivingbase.addPotionEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE, 1, 2));
                    entitylivingbase.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 1800));
                    entitylivingbase.addPotionEffect(new PotionEffect(MobEffects.LEVITATION, 1800));
                    entitylivingbase.addPotionEffect(new PotionEffect(MobEffects.POISON, 1800, 2));
                    entitylivingbase.addPotionEffect(new PotionEffect(MobEffects.UNLUCK, 1800));
                    entitylivingbase.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 1800));
                    entitylivingbase.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 1800));
                    entitylivingbase.addPotionEffect(new PotionEffect(MobEffects.WITHER, 1800));
                    user.playSound(SoundEvents.ENTITY_WITCH_AMBIENT, 100, 1);
                }
            }
        }
    }

    public static boolean shouldHit(int level, Random rnd)
    {
        if (level <= 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public boolean isCurse()
    {
        return true;
    }
    public boolean isTreasureEnchantment()
    {
        return true;
    }
}
