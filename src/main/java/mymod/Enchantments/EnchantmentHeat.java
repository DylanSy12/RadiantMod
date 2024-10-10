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
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class EnchantmentHeat extends Enchantment {
//	private String unlocalizedName;
	public EnchantmentHeat() {
		super(Enchantment.Rarity.RARE, EnumEnchantmentType.ARMOR, new EntityEquipmentSlot[] {EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET});
		this.setName("heat");
	}
//	public Enchantment setUnlocalizedName(String unlocalizedName)
//    {
//        this.unlocalizedName = unlocalizedName;
//        return this;
//    }
	/**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    public int getMinEnchantability(int enchantmentLevel)
    {
        return 10 + 20 * (enchantmentLevel - 1);
//    	return 1;
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
        return 5;
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
        ItemStack itemstack = EnchantmentHelper.getEnchantedItem(Main.heatEnchant, user);

        if (shouldHit(level, random))
        {
            if (attacker != null)
            {
                attacker.attackEntityFrom(DamageSource.IN_FIRE, (float)getDamage(level, random));
                attacker.setFire(5);
            }

            if (!itemstack.isEmpty())
            {
                damageArmor(itemstack, 3, user);
            }
        }
        else if (!itemstack.isEmpty())
        {
            damageArmor(itemstack, 1, user);
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

    public static int getDamage(int level, Random rnd)
    {
        return level > 10 ? level - 10 : 1 + rnd.nextInt(4);
    }

    private void damageArmor(ItemStack stack, int amount, EntityLivingBase entity)
    {
        int slot = -1;
        int x = 0;
        for (ItemStack i : entity.getArmorInventoryList())
        {
            if (i == stack){
                slot = x;
                break;
            }
            x++;
        }
        if (slot == -1 || !(stack.getItem() instanceof net.minecraftforge.common.ISpecialArmor))
        {
            stack.damageItem(1, entity);
            return;
        }
        net.minecraftforge.common.ISpecialArmor armor = (net.minecraftforge.common.ISpecialArmor)stack.getItem();
        armor.damageArmor(entity, stack, DamageSource.IN_FIRE, amount, slot);
    }
    public boolean isTreasureEnchantment()
    {
        return true;
    }
}
