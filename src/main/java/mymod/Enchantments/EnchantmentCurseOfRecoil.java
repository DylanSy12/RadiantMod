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
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EnchantmentCurseOfRecoil extends Enchantment {
	public EnchantmentCurseOfRecoil() {
		super(Enchantment.Rarity.VERY_RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND,EntityEquipmentSlot.OFFHAND});
		this.setName("curse_of_recoil");
	}
	/**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    public int getMinEnchantability(int enchantmentLevel)
    {
        return 20 + 15 * (enchantmentLevel - 1);
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
        return stack.getItem() instanceof ItemSword ? true : super.canApply(stack);
    }

    /**
     * Whenever an entity that has this enchantment on one of its associated items is damaged this method will be
     * called.
     */
    @Override
    public void onEntityDamaged(EntityLivingBase user, Entity target, int level)
    {
    	System.out.println("triggered");
    	if (target instanceof EntityLivingBase)
        {
			System.out.println("hurt");
			if (user instanceof EntityPlayer) {
				System.out.println("player");
				EntityPlayer player=(EntityPlayer)user;
				System.out.println(player.motionX);
				System.out.println(player.motionY);
				System.out.println(player.motionZ);
//				user.knockBack(user, level, (double)(-MathHelper.sin(user.rotationYaw * 0.017453292F)), (double)(MathHelper.cos(user.rotationYaw * 0.017453292F)));
//				player.knockBack(player, level, (double)MathHelper.sin(player.rotationYaw * 0.017453292F), (double)(MathHelper.cos(player.rotationYaw * 0.017453292F)));
//				player.knockBack(player, level, (double)(-MathHelper.sin(player.rotationYaw * 0.017453292F)), (double)(MathHelper.cos(player.rotationYaw * 0.017453292F)));
				player.onGround=false;
				player.motionY=level;
				player.motionX*=(-1);
				player.motionZ*=(-1);
				if (player.motionX<0) player.motionX-=level;
				else player.motionX+=level;
				if (player.motionZ<0) player.motionZ-=level;
				else player.motionZ+=level;
				player.knockBack(player, level, (double)(-MathHelper.sin(player.rotationYaw)*level), (double)(MathHelper.cos(player.rotationYaw)*level));
				System.out.println(player.motionX);
				System.out.println(player.motionY);
				System.out.println(player.motionZ);
//				System.out.println(player.);
			}
			else {
				System.out.println("entity");
				user.knockBack(user, level, (double)(-MathHelper.sin(user.rotationYaw * 0.017453292F)), (double)(MathHelper.cos(user.rotationYaw * 0.017453292F)));
			}
        }
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
