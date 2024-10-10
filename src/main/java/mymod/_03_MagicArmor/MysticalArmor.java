package mymod._03_MagicArmor;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.google.common.collect.Multimap;

import mymod.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MysticalArmor extends ItemArmor {
    private static final UUID[] ARMOR_MODIFIERS = new UUID[] {UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"), UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"), UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"), UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150")};
    private static Map<EntityEquipmentSlot, Integer> HEALTH_MODIFIERS = new HashMap();
    static {
    	HEALTH_MODIFIERS.put(EntityEquipmentSlot.HEAD, 2);
    	HEALTH_MODIFIERS.put(EntityEquipmentSlot.CHEST, 4);
    	HEALTH_MODIFIERS.put(EntityEquipmentSlot.LEGS, 3);
    	HEALTH_MODIFIERS.put(EntityEquipmentSlot.FEET, 1);
    }
    
	public MysticalArmor(int renderIndexIn, EntityEquipmentSlot armorType) {
		super(Main.myArmorMaterial2, renderIndexIn, armorType);
		this.setCreativeTab(CreativeTabs.COMBAT);
	}
	@Override
	public boolean isDamageable()
    {
        return true;
    }
	@Override
	public void onArmorTick(World worldIn, EntityPlayer playerIn, ItemStack itemIn) {
//		BlockPos pos1 = new BlockPos(playerIn.posX-30,playerIn.posY-30,playerIn.posZ-30);
//		BlockPos pos2 = new BlockPos(playerIn.posX+30,playerIn.posY+30,playerIn.posZ+30);
//		for (Entity entity:worldIn.getEntitiesWithinAABBExcludingEntity(playerIn, new AxisAlignedBB(pos1, pos2))) {
//			entity.onKillCommand();
//		}
		playerIn.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 450));
		if (playerIn.isPotionActive(MobEffects.FIRE_RESISTANCE) == false) {
			playerIn.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 150));
		}
		if (playerIn.isPotionActive(MobEffects.WATER_BREATHING) == false) {
			playerIn.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 150));
		}
		if (this.armorType == EntityEquipmentSlot.FEET) {
			if (playerIn.isPotionActive(MobEffects.SPEED) == false) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.SPEED, 150, 1));
			}
			else if (playerIn.getActivePotionEffect(MobEffects.SPEED).getAmplifier() < 1) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.SPEED, 150, 1));
			}
		}
		else if (this.armorType == EntityEquipmentSlot.CHEST) {
			if (playerIn.isPotionActive(MobEffects.STRENGTH) == false) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 150, 1));
			}
			else if (playerIn.getActivePotionEffect(MobEffects.STRENGTH).getAmplifier() < 1) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 150, 1));
			}
		}
		else if (this.armorType == EntityEquipmentSlot.HEAD) {
			if (playerIn.isPotionActive(MobEffects.HASTE) == false) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.HASTE, 150, 1));
			}
			else if (playerIn.getActivePotionEffect(MobEffects.HASTE).getAmplifier() < 1) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.HASTE, 150, 1));
			}
		}
		else if (this.armorType == EntityEquipmentSlot.LEGS) {
			if (playerIn.isPotionActive(MobEffects.JUMP_BOOST) == false) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 150, 1));
			}
			else if (playerIn.getActivePotionEffect(MobEffects.JUMP_BOOST).getAmplifier() < 1) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 150, 1));
			}
		}
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
