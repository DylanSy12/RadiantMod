package mymod._01_ForgeYourSword;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.lwjgl.input.Mouse;

import com.google.common.collect.Multimap;

import mymod.CustomEvents;
import mymod.Main;
import mymod.CodakidFiles.Codakid;
import mymod._03_MagicArmor.DestructionArmor;
import mymod._07_BuildAndBoom.EntityCustomExplosion;
import mymod._07_BuildAndBoom.EntityGodEraserGrenade;
import mymod._07_BuildAndBoom.ExplodingBlock;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LegendDestructionSword2 extends ItemSword 
{

//	private long time1;
//	private long time2;
//	private int range;
	private int radius = 60;
//	private boolean using;
	private boolean boosted = false;
//	private int prevCooldown;
//	private int cooldownTime;
	private int cooldownTime = 100;
	private int charge = 15;
	private int chargeIncrement = 15;
	private int minCharge = 15;
	private int maxCharge = 765;
	
	public LegendDestructionSword2() 
	{
		super(Main.legendDestructionSwordMaterial);
		this.setCreativeTab(CreativeTabs.COMBAT);
//		this.explosionStrength = 15;
//		this.using = false;
//		this.boosted = false;
//		this.time1 = System.currentTimeMillis()-2500;
//		this.prevCooldown = 0;
//		this.cooldownTime = 5000;
	}
	
//	@Override
//	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand handIn) {
//        
//		if (!worldIn.isRemote) {
//			this.time2 = System.currentTimeMillis();
//			if (time2-time1 >= this.cooldownTime || player.capabilities.isCreativeMode) {
//				int pieces = 0;
//				for (ItemStack armor:player.getArmorInventoryList()) {
//					if (armor.getItem() instanceof DestructionArmor) {
//						pieces += 1;
//					}
//				}
//				if (pieces == 4 || player.capabilities.isCreativeMode) {
//					BlockPos pos1 = new BlockPos(player.posX-60, player.posY-60, player.posZ-60);
//					BlockPos pos2 = new BlockPos(player.posX+60, player.posY+60, player.posZ+60);
//					AxisAlignedBB box = new AxisAlignedBB(pos1, pos2);
//					List<Entity> entityList = worldIn.getEntitiesWithinAABBExcludingEntity(player, box);
//					List<EntityLivingBase> entitylist = new ArrayList<EntityLivingBase>();
//					for (Entity entity : entityList) {
//						if (entity instanceof EntityLivingBase) entitylist.add((EntityLivingBase)entity);
//					}
//					
//					
//					if (entitylist.size() == 1) {
//						EntityLivingBase entity = entitylist.get(0);
//						BlockPos pos = new BlockPos(entity.posX, entity.posY, entity.posZ);
//						for (int i = 0;i < 3; i++) {
//							if (this.explosionStrength > 255) {
//								float r = this.explosionStrength/255;
//								int ir = (int)r;
//								if (r > ir) {
//									CustomEvents.destructionExplosionsL.add(pos);
//									CustomEvents.explosionPowerL.add(this.explosionStrength%255);
//								}
//								for (int a = 0; a < ir; a++) {
//									CustomEvents.destructionExplosionsL.add(pos);
//									CustomEvents.explosionPowerL.add(255f);
//								}
//							}
//							else {
//								CustomEvents.destructionExplosionsL.add(pos);
//								CustomEvents.explosionPowerL.add(this.explosionStrength);
//							}
//						}
//					}
//					else {
//						for (EntityLivingBase entity : entitylist) {
//							BlockPos pos = new BlockPos(entity.posX, entity.posY, entity.posZ);
//							for (int i = 0; i < 3; i++) {
//								if (this.explosionStrength > 255) {
//									float r = this.explosionStrength/255;
//									int ir = (int)r;
//									if (r > ir) {
//										CustomEvents.destructionExplosionsL.add(pos);
//										CustomEvents.explosionPowerL.add(this.explosionStrength%255);
//									}
//									for (int a = 0; a < ir; a++) {
//										CustomEvents.destructionExplosionsL.add(pos);
//										CustomEvents.explosionPowerL.add(255f);
//									}
//								}
//								else {
//									CustomEvents.destructionExplosionsL.add(pos);
//									CustomEvents.explosionPowerL.add(this.explosionStrength);
//								}
//							}
//						}
//					}
//
//					if (player.capabilities.isCreativeMode && this.explosionStrength > 15) this.explosionStrength -= 15;
//					else this.explosionStrength = 15;
//					this.time1 = System.currentTimeMillis();
//				}
//			}
//			else {
//				int cooldown = (int)(this.cooldownTime-(this.time2-this.time1))/1000;
//				if (cooldown != this.prevCooldown) {
//					ITextComponent text = (ITextComponent) new TextComponentString("Ability in Cooldown: "+(cooldown+1)+" Seconds Left");
//					player.sendMessage(text);
//					this.prevCooldown=cooldown;
//				}
//			}
//		}
//		return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(handIn));
//	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand handIn) 
	{
		if (!worldIn.isRemote) 
		{
			boolean isCreative = player.capabilities.isCreativeMode;
			int armorPieces = 0;

	        if (!isCreative) 
	        {
	        	player.getCooldownTracker().setCooldown(this, this.cooldownTime);
	        	for (ItemStack armor : player.getArmorInventoryList()) 
	        	{
					if (armor.getItem() instanceof DestructionArmor) 
					{
						armorPieces += 1;
					}
				}
	        }
			
			if (armorPieces == 4 || isCreative) 
			{
				BlockPos pos1 = new BlockPos(player.posX-this.radius, player.posY-this.radius, player.posZ-this.radius);
				BlockPos pos2 = new BlockPos(player.posX+this.radius, player.posY+this.radius, player.posZ+this.radius);
				AxisAlignedBB box = new AxisAlignedBB(pos1, pos2);
				List<Entity> entityList = worldIn.getEntitiesWithinAABBExcludingEntity(player, box);
				List<EntityLivingBase> entitylist = new ArrayList<EntityLivingBase>();
				
				for (Entity entity : entityList) 
				{
					if (entity instanceof EntityLivingBase) 
					{
						entitylist.add((EntityLivingBase) entity);
					}
				}
				
				if (entitylist.size() == 1) 
				{
					EntityLivingBase entity = entitylist.get(0);
					BlockPos pos = new BlockPos(entity.posX, entity.posY, entity.posZ);
					
					for (int i = 0; i < 3; i++) 
					{
						if (this.charge > 255) 
						{
							float r = this.charge/255;
							int ir = (int) r;
							if (r > ir) 
							{
								CustomEvents.radiantExplosionsL.add(pos);
								CustomEvents.explosionPowerL.add((float) this.charge%255);
							}
							for (int a = 0; a < ir; a++) 
							{
								CustomEvents.radiantExplosionsL.add(pos);
								CustomEvents.explosionPowerL.add(255f);
							}
						}
						else 
						{
							CustomEvents.radiantExplosionsL.add(pos);
							CustomEvents.explosionPowerL.add((float) this.charge);
						}
					}
				}
				else 
				{
					for (EntityLivingBase entity : entitylist) 
					{
						BlockPos pos = new BlockPos(entity.posX, entity.posY, entity.posZ);
						
						for (int i = 0; i < 3; i++) 
						{
							if (this.charge > 255) 
							{
								float r = this.charge/255;
								int ir = (int) r;
								if (r > ir) 
								{
									CustomEvents.radiantExplosionsL.add(pos);
									CustomEvents.explosionPowerL.add((float) this.charge%255);
								}
								for (int a = 0; a < ir; a++) 
								{
									CustomEvents.radiantExplosionsL.add(pos);
									CustomEvents.explosionPowerL.add(255f);
								}
							}
							else 
							{
								CustomEvents.radiantExplosionsL.add(pos);
								CustomEvents.explosionPowerL.add((float) this.charge);
							}
						}
					}
				}

				if (isCreative && this.charge > this.minCharge) this.charge -= this.chargeIncrement;
				else this.charge = this.minCharge;
			}
		}
		
		return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(handIn));
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) 
	{
		if (EnchantmentHelper.getEnchantmentLevel(Main.explosiveStrikeEnchant, stack) < 5) stack.addEnchantment(Main.explosiveStrikeEnchant, 5);
		if (EnchantmentHelper.getEnchantmentLevel(Main.deathTouchEnchant, stack) < 1) stack.addEnchantment(Main.deathTouchEnchant, 1);
		if (EnchantmentHelper.getEnchantmentLevel(Main.thunderingStrikeEnchant, stack) < 5) stack.addEnchantment(Main.thunderingStrikeEnchant, 5);
		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.SMITE, stack) < 10) stack.addEnchantment(Enchantments.SMITE, 10);
		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.BANE_OF_ARTHROPODS, stack) < 10) stack.addEnchantment(Enchantments.BANE_OF_ARTHROPODS, 10);
		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.SWEEPING, stack) < 5) stack.addEnchantment(Enchantments.SWEEPING, 5);
		if (EnchantmentHelper.getEnchantmentLevel(Main.lifeStealEnchant, stack) < 4) stack.addEnchantment(Main.lifeStealEnchant, 4);
		if (EnchantmentHelper.getEnchantmentLevel(Main.experienceBoostEnchant, stack) < 7) stack.addEnchantment(Main.experienceBoostEnchant, 7);
		if (EnchantmentHelper.getEnchantmentLevel(Main.debuffingStrikeEnchant, stack) < 3) stack.addEnchantment(Main.debuffingStrikeEnchant, 3);
		if (EnchantmentHelper.getEnchantmentLevel(Main.slowTouchEnchant, stack) < 5) stack.addEnchantment(Main.slowTouchEnchant, 5);
		if (EnchantmentHelper.getEnchantmentLevel(Main.witheringTouchEnchant, stack) < 4) stack.addEnchantment(Main.witheringTouchEnchant, 4);
		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.LOOTING, stack) < 10) stack.addEnchantment(Enchantments.LOOTING, 10);
		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.MENDING, stack) < 1) stack.addEnchantment(Enchantments.MENDING, 1);
		
		if (entityIn instanceof EntityPlayer)
		{
			if (isSelected == true) 
			{
				if (!Mouse.isButtonDown(0)) 
				{
					this.boosted = false;
				}
			}
//			this.time2 = System.currentTimeMillis();
//			if (time2-time1 >= this.cooldownTime) {
//				if (this.using == true) {
//					this.using = false;
//					ITextComponent text = (ITextComponent) new TextComponentString(this.getItemStackDisplayName(stack)+"'s ability is now ready");
//					entityIn.sendMessage(text);
//				}
//			}
//			else this.using = true;
		}
    }
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) 
	{
		if (this.charge < this.maxCharge && this.boosted == false) 
		{
			this.charge += this.chargeIncrement;
			this.boosted = true;
			if (attacker instanceof EntityPlayer) 
			{
				ITextComponent text = (ITextComponent) new TextComponentString("Explosion Power: "+this.charge);
				attacker.sendMessage(text);
			}
		}
		
        return false;
    }
	
//	/**
//     * Called when the player Left Clicks (attacks) an entity.
//     * Processed before damage is done, if return value is true further processing is canceled
//     * and the entity is not attacked.
//     *
//     * @param stack The Item being used
//     * @param player The player that is attacking
//     * @param entity The entity being attacked
//     * @return True to cancel the rest of the interaction.
//     */
//    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
//    {
//        return false;
//    }
	
//	/**
//     * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
//     */
//    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
//    {
//        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);
//
//        if (equipmentSlot == EntityEquipmentSlot.MAINHAND || equipmentSlot == EntityEquipmentSlot.OFFHAND)
//        {
//            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.attackDamage, 0));
//            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.4000000953674316D, 0));
//        }
//
//        return multimap;
//    }
}