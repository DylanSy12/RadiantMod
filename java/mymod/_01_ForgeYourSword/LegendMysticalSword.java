package mymod._01_ForgeYourSword;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;

import mymod.CustomEvents;
import mymod.Main;
import mymod._03_MagicArmor.DestructionArmor;
import mymod._03_MagicArmor.GodArmor;
import mymod._03_MagicArmor.MysticalArmor;
import mymod._07_BuildAndBoom.ExplodingBlock;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LegendMysticalSword extends ItemSword 
{
	private int radius = 60;
	private boolean boosted = false;
	private int cooldownTime = 150;
	private int charge = 3;
	private int chargeIncrement = 3;
	private int minCharge = 3;
	private int maxCharge = 27;
	
	public LegendMysticalSword() 
	{
		super(Main.myToolMaterial22);
		this.setCreativeTab(CreativeTabs.COMBAT);
	}
	
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
					if (armor.getItem() instanceof MysticalArmor || armor.getItem() instanceof DestructionArmor) 
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
					
					CustomEvents.cloudAreasL.add(pos);
					CustomEvents.effectRadiusL.add((float) this.charge);
				}
				else 
				{
					for (EntityLivingBase entity : entitylist) 
					{
						BlockPos pos = new BlockPos(entity.posX,entity.posY,entity.posZ);
						
						CustomEvents.cloudAreasL.add(pos);
						CustomEvents.effectRadiusL.add((float) this.charge);
					}
				}
			}
			
			if (isCreative && this.charge > this.minCharge) this.charge -= this.chargeIncrement;
			else this.charge = this.minCharge;
		}
		
		return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(handIn));
	}
	
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
		if (EnchantmentHelper.getEnchantmentLevel(Main.debuffingStrikeEnchant, stack) < 3) stack.addEnchantment(Main.debuffingStrikeEnchant, 3);
		if (EnchantmentHelper.getEnchantmentLevel(Main.slowTouchEnchant, stack) < 5) stack.addEnchantment(Main.slowTouchEnchant, 5);
		if (EnchantmentHelper.getEnchantmentLevel(Main.witheringTouchEnchant, stack) < 4) stack.addEnchantment(Main.witheringTouchEnchant, 4);
		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.BANE_OF_ARTHROPODS, stack) < 10) stack.addEnchantment(Enchantments.BANE_OF_ARTHROPODS, 10);
		
		if (entityIn instanceof EntityPlayer && isSelected == true && !Mouse.isButtonDown(0)) this.boosted = false;
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
				ITextComponent text = (ITextComponent) new TextComponentString("Cloud Radius: "+this.charge);
				attacker.sendMessage(text);
			}
		}
		
        return false;
    }
}