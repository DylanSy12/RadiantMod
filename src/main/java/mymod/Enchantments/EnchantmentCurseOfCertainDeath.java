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
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class EnchantmentCurseOfCertainDeath extends Enchantment {
	public EnchantmentCurseOfCertainDeath() {
		super(Enchantment.Rarity.VERY_RARE, EnumEnchantmentType.ARMOR, new EntityEquipmentSlot[] {EntityEquipmentSlot.HEAD,EntityEquipmentSlot.CHEST,EntityEquipmentSlot.LEGS,EntityEquipmentSlot.FEET});
		this.setName("curse_of_certain_death");
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

    public boolean isTreasureEnchantment()
    {
        return true;
    }
    public boolean isCurse()
    {
        return true;
    }
}
