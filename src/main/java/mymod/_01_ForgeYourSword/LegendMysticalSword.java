package mymod._01_ForgeYourSword;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import org.lwjgl.input.Mouse;

import mymod.CustomEvents;
import mymod.Main;
import mymod._03_MagicArmor.RadiantArmor;
import mymod._03_MagicArmor.DestructionArmor;
import mymod._03_MagicArmor.GodArmor;
import mymod._03_MagicArmor.MysticalArmor;
import mymod._07_BuildAndBoom.ExplodingBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
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
	// Ability information NBT tags
	private static NBTTagCompound customTags = new NBTTagCompound();
	static {
//		customTags.setInteger("charge", 3);
//		customTags.setInteger("charge_increment", 3);
//		customTags.setInteger("min_charge", 3);
//		customTags.setInteger("max_charge", 27);
		customTags.setInteger("charge", 0);
		customTags.setInteger("charge_increment", 1);
		customTags.setInteger("min_charge", 0);
		customTags.setInteger("max_charge", 20);
		customTags.setFloat("cloud_increment", 1);
		customTags.setInteger("cooldown_time", 120);
		customTags.setInteger("max_usage_time", 80);
		customTags.setFloat("radius_increment", 0.5f);
		customTags.setInteger("min_radius", 20);
	}
	
	public LegendMysticalSword() 
	{
		super(Main.legendMysticalSwordMaterial);
		this.setCreativeTab(CreativeTabs.COMBAT);
	}
	
	/**
     * Called when the equipped item is right clicked.
     */
	@Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        
        boolean isCreative = playerIn.capabilities.isCreativeMode;
		int armorPieces = 0;
		
    	for (ItemStack armor : playerIn.getArmorInventoryList()) 
    	{
    		if (armor.getItem() instanceof MysticalArmor || armor.getItem() instanceof RadiantArmor || 
				armor.getItem() instanceof GodArmor || armor.getItem() instanceof DestructionArmor) 
			{
				armorPieces += 1;
			}
		}
        
		if (armorPieces != 4 && !isCreative) 
		{
	        return armorPieces == 4 ? new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack) : new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
		}
		else {
			playerIn.setActiveHand(handIn);
	        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
		}
    }
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
		// Applies the custom NBT data if the sword does not already have it
		if (stack.getTagCompound() != null) 
		{
			for (String key : customTags.getKeySet()) 
			{
				if (!stack.getTagCompound().hasKey(key)) 
				{
					stack.getTagCompound().merge(customTags);
					break;
				}
			}
		}
		
		// Applies enchantments if the sword does not have/has lower level versions of them
		if (EnchantmentHelper.getEnchantmentLevel(Main.debuffingStrikeEnchant, stack) < 3) stack.addEnchantment(Main.debuffingStrikeEnchant, 3);
		if (EnchantmentHelper.getEnchantmentLevel(Main.slowTouchEnchant, stack) < 5) stack.addEnchantment(Main.slowTouchEnchant, 5);
		if (EnchantmentHelper.getEnchantmentLevel(Main.witheringTouchEnchant, stack) < 4) stack.addEnchantment(Main.witheringTouchEnchant, 4);
		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.BANE_OF_ARTHROPODS, stack) < 10) stack.addEnchantment(Enchantments.BANE_OF_ARTHROPODS, 10);
    }
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
		// Charges the sword when attacking
		NBTTagCompound nbt = stack.getTagCompound();
		int c = nbt.getInteger("charge");
		
		if (c < nbt.getInteger("max_charge")) 
		{
			stack.getTagCompound().setInteger("charge", c+nbt.getInteger("charge_increment"));
		}
		
        return false;
    }
	
	/**
     * How long it takes to use or consume an item
     */
	@Override
    public int getMaxItemUseDuration(ItemStack stack)
    {
		return stack.getTagCompound().getInteger("max_usage_time");
    }
	
    /**
     * Called when the player stops using an Item (stops holding the right mouse button).
     */
	@Override
    public void onPlayerStoppedUsing(ItemStack item, World worldIn, EntityLivingBase entityLiving, int timeLeft)
    {
    	if (entityLiving instanceof EntityPlayer) 
    	{
    		EntityPlayer player = (EntityPlayer) entityLiving;
	    	if (!worldIn.isRemote) 
			{
				boolean isCreative = player.capabilities.isCreativeMode;
				NBTTagCompound nbt = item.getTagCompound();
				int c = nbt.getInteger("charge");
				float r = nbt.getInteger("min_radius")+((item.getMaxItemUseDuration()-timeLeft)*nbt.getFloat("radius_increment"));
	
				// Gets a list all entities within a certain range
				BlockPos pos1 = new BlockPos(player.posX-r, player.posY-r, player.posZ-r);
				BlockPos pos2 = new BlockPos(player.posX+r, player.posY+r, player.posZ+r);
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
				
				// Adds the positions of all entities within range to the lists in CustomEvents, along with the ability's charge level
				if (entitylist.size() == 1) 
				{
					EntityLivingBase entity = entitylist.get(0);
					BlockPos pos = new BlockPos(entity.posX, entity.posY, entity.posZ);
					
					CustomEvents.cloudAreasL.add(pos);
					CustomEvents.effectRadiusL.add(c*nbt.getFloat("cloud_increment"));
				}
				else 
				{
					for (EntityLivingBase entity : entitylist) 
					{
						BlockPos pos = new BlockPos(entity.posX, entity.posY, entity.posZ);
						
						CustomEvents.cloudAreasL.add(pos);
						CustomEvents.effectRadiusL.add(c*nbt.getFloat("cloud_increment"));
					}
				}
				
				// Resets/decreases the sword's charge level and sets the ability's cooldown
				if (isCreative && c > nbt.getInteger("min_charge")) item.getTagCompound().setInteger("charge", c-nbt.getInteger("charge_increment"));
				else item.getTagCompound().setInteger("charge", nbt.getInteger("min_charge"));
				if (!isCreative) player.getCooldownTracker().setCooldown(this, item.getTagCompound().getInteger("cooldown_time")+((item.getMaxItemUseDuration()-timeLeft)/2));
			}
    	}
    }
    
    
	/**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BLOCK;
    }
	
	/**
     * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
     * the Item before the action is complete.
     */
    public ItemStack onItemUseFinish(ItemStack item, World worldIn, EntityLivingBase entityLiving)
    {
    	if (entityLiving instanceof EntityPlayer) 
    	{
    		EntityPlayer player = (EntityPlayer) entityLiving;
	    	if (!worldIn.isRemote) 
			{
				boolean isCreative = player.capabilities.isCreativeMode;
				NBTTagCompound nbt = item.getTagCompound();
				int c = nbt.getInteger("charge");
				float r = nbt.getInteger("min_radius")+(nbt.getInteger("max_usage_time")*nbt.getFloat("radius_increment"));
					
				// Gets a list all entities within a certain range
				BlockPos pos1 = new BlockPos(player.posX-r, player.posY-r, player.posZ-r);
				BlockPos pos2 = new BlockPos(player.posX+r, player.posY+r, player.posZ+r);
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
				
				// Adds the positions of all entities within range to the lists in CustomEvents, along with the ability's charge level
				if (entitylist.size() == 1) 
				{
					EntityLivingBase entity = entitylist.get(0);
					BlockPos pos = new BlockPos(entity.posX, entity.posY, entity.posZ);
					
					CustomEvents.cloudAreasL.add(pos);
					CustomEvents.effectRadiusL.add(c*nbt.getFloat("cloud_increment"));
				}
				else 
				{
					for (EntityLivingBase entity : entitylist) 
					{
						BlockPos pos = new BlockPos(entity.posX, entity.posY, entity.posZ);
						
						CustomEvents.cloudAreasL.add(pos);
						CustomEvents.effectRadiusL.add(c*nbt.getFloat("cloud_increment"));
					}
				}
				
				// Resets/decreases the sword's charge level and radius and sets the ability's cooldown
				if (isCreative && c > nbt.getInteger("min_charge")) item.getTagCompound().setInteger("charge", c-nbt.getInteger("charge_increment"));
				else item.getTagCompound().setInteger("charge", nbt.getInteger("min_charge"));
				if (!isCreative) player.getCooldownTracker().setCooldown(this, item.getTagCompound().getInteger("cooldown_time")+(item.getTagCompound().getInteger("max_usage_time")/2));
			}
    	}
        return item;
    }
    
    //TODO Use to add details to item info display
    /**
     * allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
    }
    
    /**
     * Allow the item one last chance to modify its name used for the
     * tool highlight useful for adding something extra that can't be removed
     * by a user in the displayed name, such as a mode of operation.
     *
     * @param item the ItemStack for the item.
     * @param displayName the name that will be displayed unless it is changed in this method.
     */
    @Override
    public String getHighlightTip(ItemStack item, String displayName)
    {
    	NBTTagCompound nbt = item.getTagCompound();
    	float range = nbt.getInteger("min_radius")+(Minecraft.getMinecraft().player.getItemInUseMaxCount()*nbt.getFloat("radius_increment"));
    	float maxRange = nbt.getInteger("min_radius")+(nbt.getInteger("max_usage_time")*nbt.getFloat("radius_increment"));
//    	return displayName+" | Effect Cloud Radius: "+nbt.getInteger("charge")+"/"+nbt.getInteger("max_charge")+" | Range: "+range+"/"+maxRange;
    	return displayName+" | Ability Charge: "+(nbt.getInteger("charge")*5)+"% | Range: "+range+"/"+maxRange;
    }
}