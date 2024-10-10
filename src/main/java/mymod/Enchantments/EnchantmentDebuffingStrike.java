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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class EnchantmentDebuffingStrike extends Enchantment {

	public EnchantmentDebuffingStrike() {
		super(Enchantment.Rarity.VERY_RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND,EntityEquipmentSlot.OFFHAND});
		this.setName("debuffing_strike");
	}
	
	/**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    public int getMinEnchantability(int enchantmentLevel)
    {
        return 10 + 20 * (enchantmentLevel - 1);
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
        return 3;
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
    	if (target instanceof EntityLivingBase) {
            EntityLivingBase entitylivingbase = (EntityLivingBase)target;
            for (int p = 0; p < level; p++) {
            	entitylivingbase.addPotionEffect(addDebuff(entitylivingbase, level, new PotionEffect[12], 0));
            }
        }
    }
    
    public boolean isTreasureEnchantment()
    {
        return true;
    }
    
    private PotionEffect addDebuff(EntityLivingBase entity, int level, PotionEffect[] effectsTried, int tries) {
    	Random rand = new Random();
    	int number = rand.nextInt(12);
    	PotionEffect potion;
    	if (number == 0) potion = new PotionEffect(MobEffects.BLINDNESS, 30*level);
    	else if (number == 1) potion = new PotionEffect(MobEffects.INSTANT_DAMAGE, 1, level);
    	else if (number == 2) potion = new PotionEffect(MobEffects.LEVITATION, 30*level, level);/* potion=new PotionEffect(MobEffects.INSTANT_DAMAGE,1,level);*/
    	else if (number == 3) potion = new PotionEffect(MobEffects.MINING_FATIGUE, 30*level);
    	else if (number == 4) potion = new PotionEffect(MobEffects.GLOWING, 30*level);
    	else if (number == 5) potion = new PotionEffect(MobEffects.HUNGER, 30*level, level);
    	else if (number == 6) potion = new PotionEffect(MobEffects.NAUSEA, 30*level);
    	else if (number == 7) potion = new PotionEffect(MobEffects.POISON, 30*level, level);
    	else if (number == 8) potion = new PotionEffect(MobEffects.SLOWNESS, 30*level, level);
    	else if (number == 9) potion = new PotionEffect(MobEffects.UNLUCK, 30*level, level);
    	else if (number == 10) potion = new PotionEffect(MobEffects.WEAKNESS, 30*level, level);
    	else potion = new PotionEffect(MobEffects.WITHER, 30*level, level);
    	
    	if ((!(entity.isPotionActive(potion.getPotion()))) && entity.isPotionApplicable(potion)) return potion;
    	else if (tries < 12) {
    		for (PotionEffect effect : effectsTried) {
    			if (effect != null) {
	    			if (effect.getPotion() == potion.getPotion()) {
	    				return addDebuff(entity, level, effectsTried, tries);
	    			}
    			}
    		}
    		effectsTried[tries] = potion;
    		return addDebuff(entity, level, effectsTried, tries+1);
    	}
    	else return new PotionEffect(MobEffects.INSTANT_DAMAGE, 1, level);
    }
}
