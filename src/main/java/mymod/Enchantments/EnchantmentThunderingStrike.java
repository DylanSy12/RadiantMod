package mymod.Enchantments;

import java.util.Random;

import mymod.CustomEvents;
import mymod.Main;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EnchantmentThunderingStrike extends Enchantment 
{
	public EnchantmentThunderingStrike() 
	{
		super(Enchantment.Rarity.RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND,EntityEquipmentSlot.OFFHAND});
		this.setName("thundering_strike");
	}

	/**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    public int getMinEnchantability(int enchantmentLevel)
    {
        return 10+20*(enchantmentLevel-1);
    }

    /**
     * Returns the maximum value of enchantability needed on the enchantment level passed.
     */
    public int getMaxEnchantability(int enchantmentLevel)
    {
        return super.getMinEnchantability(enchantmentLevel)+50;
    }

    /**
     * Returns the maximum level that the enchantment can have.
     */
    public int getMaxLevel()
    {
        return 5;
    }
    
    /**
     * Determines if this enchantment can be applied to a specific ItemStack.
     */
    public boolean canApply(ItemStack stack)
    {
        return stack.getItem() instanceof ItemSword ? true : super.canApply(stack);
    }

    /**
     * Whenever an entity that has this enchantment on one of its associated items is damaged this method will be
     * called.
     */
    public void onEntityDamaged(EntityLivingBase user, Entity target, int level)
    {
    	if (target instanceof EntityLivingBase)
        {
            EntityLivingBase entitylivingbase = (EntityLivingBase) target;
            BlockPos pos = new BlockPos(entitylivingbase.posX, entitylivingbase.posY, entitylivingbase.posZ);
			CustomEvents.lightningStrikes.add(pos);
			CustomEvents.numBolts.add(level);
        }
    }
    
    public boolean isTreasureEnchantment()
    {
        return true;
    }
}
