package mymod._03_MagicArmor;

import com.google.common.collect.Multimap;

import mymod.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class GodPotionOrb extends Item {
	private int regenTick;
	public GodPotionOrb() {
		
		this.setCreativeTab(CreativeTabs.COMBAT);
		this.regenTick=0;
	}
	
//	@Override
//	public void onArmorTick(World worldIn, EntityPlayer playerIn, ItemStack itemIn) {
//		playerIn.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 20));
//		playerIn.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 20));
//		playerIn.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 20, 3));
//		//playerIn.addPotionEffect(new PotionEffect(MobEffects.HEALTH_BOOST, 200, 20));
//		
//		playerIn.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 20, 7));
//		playerIn.addPotionEffect(new PotionEffect(MobEffects.SPEED, 20, 4));
//		playerIn.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 20, 5));
//		playerIn.addPotionEffect(new PotionEffect(MobEffects.HASTE, 20, 5));
//		playerIn.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 20));
//		playerIn.addPotionEffect(new PotionEffect(MobEffects.LUCK, 20, 5));
//		playerIn.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 20));
//	}
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
		if (entityIn instanceof EntityPlayer) {
			EntityPlayer playerIn = (EntityPlayer) entityIn;
			
			playerIn.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 300));
			if (playerIn.isPotionActive(MobEffects.REGENERATION) == false){
				playerIn.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 300));
			}
			else if (playerIn.getActivePotionEffect(MobEffects.REGENERATION).getAmplifier() < 1) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 300));
			}
			if (playerIn.isPotionActive(MobEffects.GLOWING) == false){
				playerIn.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 300));
			}
			if (playerIn.isPotionActive(MobEffects.RESISTANCE) == false){
				playerIn.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 300));
			}
			else if (playerIn.getActivePotionEffect(MobEffects.RESISTANCE).getAmplifier() < 1) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 300));
			}
			if (this.regenTick >= 2400){
				
				playerIn.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 1, 10));
				playerIn.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 1000000, 5));
				playerIn.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 1, 5));
				
				this.regenTick = 1;
			}
			this.regenTick++;
			if (playerIn.isPotionActive(MobEffects.JUMP_BOOST) == false){
				playerIn.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 300, 6));
			}
			else if (playerIn.getActivePotionEffect(MobEffects.JUMP_BOOST).getAmplifier() < 6) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 300, 6));
			}
			if (playerIn.isPotionActive(MobEffects.SPEED) == false){
				playerIn.addPotionEffect(new PotionEffect(MobEffects.SPEED, 300, 3));
			}
			else if (playerIn.getActivePotionEffect(MobEffects.SPEED).getAmplifier() < 3) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.SPEED, 300, 3));
			}
			if (playerIn.isPotionActive(MobEffects.STRENGTH) == false){
				playerIn.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 300, 4));
			}
			else if (playerIn.getActivePotionEffect(MobEffects.STRENGTH).getAmplifier() < 4) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 300, 4));
			}
			if (playerIn.isPotionActive(MobEffects.HASTE) == false){
				playerIn.addPotionEffect(new PotionEffect(MobEffects.HASTE, 300, 4));
			}
			else if (playerIn.getActivePotionEffect(MobEffects.HASTE).getAmplifier() < 4) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.HASTE, 300, 4));
			}
			if (playerIn.isPotionActive(MobEffects.WATER_BREATHING) == false){
				playerIn.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 300));
			}
			if (playerIn.isPotionActive(MobEffects.LUCK) == false){
				playerIn.addPotionEffect(new PotionEffect(MobEffects.LUCK, 300, 4));
			}
			else if (playerIn.getActivePotionEffect(MobEffects.LUCK).getAmplifier() < 4) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.LUCK, 300, 4));
			}
			if (playerIn.isPotionActive(MobEffects.FIRE_RESISTANCE) == false){
				playerIn.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 300));
			}
//			playerIn.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20+(i/2));
//			playerIn.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.33);
		}
    }
	
	/**
     * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
     */
//    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
//    {
//        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);
//
//        if (equipmentSlot == EntityEquipmentSlot.OFFHAND || equipmentSlot == EntityEquipmentSlot.MAINHAND)
//        {
//            multimap.put(SharedMonsterAttributes.MAX_HEALTH.getName(), new AttributeModifier("Max Health", 20, 0));
//            multimap.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName(), new AttributeModifier("Knockback Resistance", 0.33, 0));
//        }
//
//        return multimap;
//    }
}
