package mymod._01_ForgeYourSword;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import org.lwjgl.input.Mouse;

import mymod.CustomEvents;
import mymod.Main;
import mymod._03_MagicArmor.DestructionArmor;
import mymod._03_MagicArmor.GodArmor;
import mymod._07_BuildAndBoom.ExplodingBlock;
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

public class LegendGodSword extends ItemSword 
{
	// Ability information NBT tags
	private static NBTTagCompound customTags = new NBTTagCompound();
	static {
		customTags.setInteger("charge", 3);
		customTags.setInteger("charge_increment", 3);
		customTags.setInteger("min_charge", 3);
		customTags.setInteger("max_charge", 30);
		customTags.setInteger("cooldown_time", 50);
//		customTags.setInteger("ability_radius", 60);
		customTags.setInteger("usage_time", 0);
		customTags.setInteger("max_usage_time", 80);
//		customTags.setInteger("radius", 20);
		customTags.setFloat("radius_increment", 0.5f);
		customTags.setInteger("min_radius", 20);
//		customTags.setInteger("max_radius", 60);
		customTags.setInteger("test", 0);
		customTags.setBoolean("boosted", false);
	}
	
	public LegendGodSword() 
	{
		super(Main.myToolMaterial21);
		this.setCreativeTab(CreativeTabs.COMBAT);
	}
	
//	@Override
//	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand handIn) 
//	{
//		if (!worldIn.isRemote) 
//		{
//			boolean isCreative = player.capabilities.isCreativeMode;
//			int armorPieces = 0;
//			ItemStack item = player.getHeldItem(handIn);
//			NBTTagCompound nbt = item.getTagCompound();
//			int c = nbt.getInteger("charge");
//			int r = nbt.getInteger("ability_radius");
//
//			// Sets the cooldown and checks if the player is able to use the ability
//	        if (!isCreative) 
//	        {
//	        	player.getCooldownTracker().setCooldown(this, nbt.getInteger("cooldown_time"));
//	        	for (ItemStack armor : player.getArmorInventoryList()) 
//	        	{
//					if (armor.getItem() instanceof GodArmor || armor.getItem() instanceof DestructionArmor) 
//					{
//						armorPieces += 1;
//					}
//				}
//	        }
//	        
//			if (armorPieces == 4 || isCreative) 
//			{
//				// Gets all entities within a certain range
//				BlockPos pos1 = new BlockPos(player.posX-r, player.posY-r, player.posZ-r);
//				BlockPos pos2 = new BlockPos(player.posX+r, player.posY+r, player.posZ+r);
//				AxisAlignedBB box = new AxisAlignedBB(pos1, pos2);
//				List<Entity> entityList = worldIn.getEntitiesWithinAABBExcludingEntity(player, box);
//				List<EntityLivingBase> entitylist = new ArrayList<EntityLivingBase>();
//				
//				for (Entity entity : entityList) 
//				{
//					if (entity instanceof EntityLivingBase) 
//					{
//						entitylist.add((EntityLivingBase) entity);
//					}
//				}
//				
//				// Adds the positions of all entities within range to the lists in CustomEvents, along with the ability's charge level
//				if (entitylist.size() == 1) 
//				{
//					EntityLivingBase entity = entitylist.get(0);
//					BlockPos pos = new BlockPos(entity.posX, entity.posY, entity.posZ);
//					
//					CustomEvents.lightningStrikesL.add(pos);
//					CustomEvents.numBoltsL.add(c);
//				}
//				else 
//				{
//					for (EntityLivingBase entity : entitylist) 
//					{
//						BlockPos pos = new BlockPos(entity.posX, entity.posY, entity.posZ);
//						
//						CustomEvents.lightningStrikesL.add(pos);
//						CustomEvents.numBoltsL.add(c);
//					}
//				}
//			}
//			
//			// Resets/decreases the sword's charge level
//			if (isCreative && c > nbt.getInteger("min_charge")) item.getTagCompound().setInteger("charge", c-nbt.getInteger("charge_increment"));
//			else item.getTagCompound().setInteger("charge", nbt.getInteger("min_charge"));
//		}
//		
//		return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(handIn));
//	}
	
	/**
     * Called when the equipped item is right clicked.
     */
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
    	System.out.println("Right Click");
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        
        boolean isCreative = playerIn.capabilities.isCreativeMode;
		int armorPieces = 0;
		
//    	playerIn.getCooldownTracker().setCooldown(this, itemstack.getTagCompound().getInteger("cooldown_time"));
    	for (ItemStack armor : playerIn.getArmorInventoryList()) 
    	{
			if (armor.getItem() instanceof GodArmor || armor.getItem() instanceof DestructionArmor) 
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
		if (stack.getTagCompound() != null) {
			if (!stack.getTagCompound().hasKey("charge")) {
				stack.getTagCompound().merge(customTags);
			}
		}
		
		// Applies enchantments if the sword does not have/has lower level versions of them
		if (EnchantmentHelper.getEnchantmentLevel(Main.thunderingStrikeEnchant, stack) < 5) stack.addEnchantment(Main.thunderingStrikeEnchant, 5);
		if (EnchantmentHelper.getEnchantmentLevel(Main.lifeStealEnchant, stack) < 4) stack.addEnchantment(Main.lifeStealEnchant, 4);
		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.SMITE, stack) < 10) stack.addEnchantment(Enchantments.SMITE, 10);
		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.MENDING, stack) < 1) stack.addEnchantment(Enchantments.MENDING, 1);
		
		// Allows the sword to charge again after attacking
		if (entityIn instanceof EntityPlayer && isSelected && !Mouse.isButtonDown(0) && stack.getTagCompound().getBoolean("boosted")) {
			stack.getTagCompound().setBoolean("boosted", false);
		}
    }
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
		// Charges the sword when attacking
		NBTTagCompound nbt = stack.getTagCompound();
		int c = nbt.getInteger("charge");
		
		if (c < nbt.getInteger("max_charge") && !nbt.getBoolean("boosted")) 
		{
			stack.getTagCompound().setInteger("charge", c+nbt.getInteger("charge_increment"));
			stack.getTagCompound().setBoolean("boosted", true);
			
			if (attacker instanceof EntityPlayer) 
			{
				ITextComponent text = (ITextComponent) new TextComponentString("Lightning Strikes: "+stack.getTagCompound().getInteger("charge"));
				attacker.sendMessage(text);
			}
		}
		
        return false;
    }
	
	//TODO Use these three functions to have the radius of the ability expand
	/**
     * How long it takes to use or consume an item
     */
	@Override
    public int getMaxItemUseDuration(ItemStack stack)
    {
//		System.out.println("Requested Use Time: "+stack.getTagCompound().getInteger("max_usage_time"));
//        return 80;
		return stack.getTagCompound().getInteger("max_usage_time");
    }
    
    /**
     * Called when the player stops using an Item (stops holding the right mouse button).
     */
	@Override
    public void onPlayerStoppedUsing(ItemStack item, World worldIn, EntityLivingBase entityLiving, int timeLeft)
    {
		System.out.println("Stopped Using");
    	if (entityLiving instanceof EntityPlayer) {
    		EntityPlayer player = (EntityPlayer) entityLiving;
	    	if (!worldIn.isRemote) 
			{
				boolean isCreative = player.capabilities.isCreativeMode;
				NBTTagCompound nbt = item.getTagCompound();
				int c = nbt.getInteger("charge");
				float r = nbt.getInteger("min_radius")+(nbt.getInteger("usage_time")*nbt.getFloat("radius_increment"));
	
				// Gets all entities within a certain range
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
					
					CustomEvents.lightningStrikesL.add(pos);
					CustomEvents.numBoltsL.add(c);
				}
				else 
				{
					for (EntityLivingBase entity : entitylist) 
					{
						BlockPos pos = new BlockPos(entity.posX, entity.posY, entity.posZ);
						
						CustomEvents.lightningStrikesL.add(pos);
						CustomEvents.numBoltsL.add(c);
					}
				}
				
				// Resets/decreases the sword's charge level and radius
				if (isCreative && c > nbt.getInteger("min_charge")) item.getTagCompound().setInteger("charge", c-nbt.getInteger("charge_increment"));
				else item.getTagCompound().setInteger("charge", nbt.getInteger("min_charge"));
				item.getTagCompound().setInteger("usage_time", 0);
				if (!isCreative) player.getCooldownTracker().setCooldown(this, item.getTagCompound().getInteger("cooldown_time"));
			}
    	}
    }
    
    /**
     * Called each tick while using an item.
     * @param stack The Item being used
     * @param player The Player using the item
     * @param count The amount of time in tick the item has been used for continuously
     */
	@Override
    public void onUsingTick(ItemStack stack, EntityLivingBase player, int count)
    {
		System.out.println("Using");
    	NBTTagCompound nbt = stack.getTagCompound();
//    	stack.getTagCompound().setInteger("test", nbt.getInteger("test")+1);
    	stack.getTagCompound().setInteger("usage_time", nbt.getInteger("usage_time")+1);
    }
	
    /**
     * Determine if the player switching between these two item stacks
     * @param oldStack The old stack that was equipped
     * @param newStack The new stack
     * @param slotChanged If the current equipped slot was changed,
     *                    Vanilla does not play the animation if you switch between two
     *                    slots that hold the exact same item.
     * @return True to play the item change animation
     */
    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged)
    {
        return true;
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
    	System.out.println("Finished Using");
    	if (entityLiving instanceof EntityPlayer) {
    		EntityPlayer player = (EntityPlayer) entityLiving;
	    	if (!worldIn.isRemote) 
			{
				boolean isCreative = player.capabilities.isCreativeMode;
				NBTTagCompound nbt = item.getTagCompound();
				int c = nbt.getInteger("charge");
				float r = nbt.getInteger("min_radius")+(nbt.getInteger("usage_time")*nbt.getFloat("radius_increment"));
					
				// Gets all entities within a certain range
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
					
					CustomEvents.lightningStrikesL.add(pos);
					CustomEvents.numBoltsL.add(c);
				}
				else 
				{
					for (EntityLivingBase entity : entitylist) 
					{
						BlockPos pos = new BlockPos(entity.posX, entity.posY, entity.posZ);
						
						CustomEvents.lightningStrikesL.add(pos);
						CustomEvents.numBoltsL.add(c);
					}
				}
				
				// Resets/decreases the sword's charge level and radius
				if (isCreative && c > nbt.getInteger("min_charge")) item.getTagCompound().setInteger("charge", c-nbt.getInteger("charge_increment"));
				else item.getTagCompound().setInteger("charge", nbt.getInteger("min_charge"));
				item.getTagCompound().setInteger("usage_time", 0);
				if (!isCreative) player.getCooldownTracker().setCooldown(this, item.getTagCompound().getInteger("cooldown_time"));
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
    
    //TODO Use to make the charge and/or radius be displayed
    /**
     * Allow the item one last chance to modify its name used for the
     * tool highlight useful for adding something extra that can't be removed
     * by a user in the displayed name, such as a mode of operation.
     *
     * @param item the ItemStack for the item.
     * @param displayName the name that will be displayed unless it is changed in this method.
     */
    @Override
    public String getHighlightTip( ItemStack item, String displayName )
    {
//    	System.out.println("Requested Highlight Tip");
    	NBTTagCompound nbt = item.getTagCompound();
    	float range = nbt.getInteger("min_radius")+(nbt.getInteger("usage_time")*nbt.getFloat("radius_increment"));
    	float maxRange = nbt.getInteger("min_radius")+(nbt.getInteger("max_usage_time")*nbt.getFloat("radius_increment"));
    	return displayName+" | Bolts: "+nbt.getInteger("charge")+"/"+nbt.getInteger("max_charge")+" | Range: "+range+"/"+maxRange;
    }
}