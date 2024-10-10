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
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EnchantmentRepulsion extends Enchantment {
	public EnchantmentRepulsion() {
		super(Enchantment.Rarity.RARE, EnumEnchantmentType.ARMOR, new EntityEquipmentSlot[] {EntityEquipmentSlot.CHEST});
		this.setName("repulsion");
	}
	/**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    public int getMinEnchantability(int enchantmentLevel)
    {
        return 15 + 20 * (enchantmentLevel - 1);
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
        return 4;
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
        ItemStack itemstack = EnchantmentHelper.getEnchantedItem(Main.repulsionEnchant, user);

        if (shouldHit(level, random))
        {
        	if (attacker != null)
            {
            	if (attacker instanceof EntityLivingBase)
                {
                    EntityLivingBase entitylivingbase = (EntityLivingBase)attacker;
//                    entitylivingbase.knockBack(entitylivingbase, level, level, level);
                    entitylivingbase.knockBack(entitylivingbase, level, (double)(-MathHelper.sin(entitylivingbase.rotationYaw * 0.017453292F)), (double)(MathHelper.cos(entitylivingbase.rotationYaw * 0.017453292F)));
                    
                }
            	else
                {
                    attacker.addVelocity((double)(MathHelper.sin(attacker.rotationYaw * 0.017453292F) * (float)level * 0.5F), 0.1D, (double)(-MathHelper.cos(attacker.rotationYaw * 0.017453292F) * (float)level * 0.5F));
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
            return rnd.nextFloat() < 0.15F * (float)level;
        }
    }
    
    public boolean isTreasureEnchantment()
    {
        return true;
    }
}
