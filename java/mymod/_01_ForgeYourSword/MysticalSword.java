package mymod._01_ForgeYourSword;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;

import mymod.CustomEvents;
import mymod.Main;
import mymod._03_MagicArmor.DestructionArmor;
import mymod._03_MagicArmor.GodArmor;
import mymod._03_MagicArmor.MysticalArmor;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityDragonFireball;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MysticalSword extends ItemSword {
	private long time1;
	private long time2;
	private int range;
	private boolean using;
	private float radius;
	private boolean boosted;
	private int prevCooldown;
	private int cooldownTime;
	public MysticalSword() {
		super(Main.myToolMaterial5);
		this.setCreativeTab(CreativeTabs.COMBAT);
		this.time1=System.currentTimeMillis()-7500;
		this.range=200;
		this.using=false;
		this.radius=1;
		this.boosted=false;
		this.prevCooldown=0;
		this.cooldownTime=15000;
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand handIn){
		if (!worldIn.isRemote) {
			this.time2=System.currentTimeMillis();
			if (time2-time1>=this.cooldownTime || player.capabilities.isCreativeMode) {
				int pieces=0;
				for (ItemStack armor:player.getArmorInventoryList()) {
					if (armor.getItem() instanceof MysticalArmor || armor.getItem() instanceof DestructionArmor) {
						pieces+=1;
					}
				}
				if (pieces==4 || player.capabilities.isCreativeMode) {
					BlockPos pos1 = new BlockPos(player.posX-20,player.posY-20,player.posZ-20);
					BlockPos pos2 = new BlockPos(player.posX+20,player.posY+20,player.posZ+20);
					AxisAlignedBB box = new AxisAlignedBB(pos1, pos2);
					List<Entity> entityList = worldIn.getEntitiesWithinAABBExcludingEntity(player, box);
					List<EntityLivingBase> entitylist = new ArrayList<EntityLivingBase>();
					for (Entity entity:entityList) {
						if (entity instanceof EntityLivingBase) entitylist.add((EntityLivingBase)entity);
					}
					if (entitylist.size()==1) {
						EntityLivingBase entity = entitylist.get(0);
						BlockPos pos = new BlockPos(entity.posX,entity.posY,entity.posZ);
						CustomEvents.cloudAreas.add(pos);
						CustomEvents.effectRadius.add(this.radius);
					}
					else {
						for (EntityLivingBase entity:entitylist) {
							BlockPos pos = new BlockPos(entity.posX,entity.posY,entity.posZ);
							CustomEvents.cloudAreas.add(pos);
							CustomEvents.effectRadius.add(this.radius);
						}
					}
				}
				if (player.capabilities.isCreativeMode && this.radius>1) this.radius-=1;
				else this.radius=1;
				this.time1=System.currentTimeMillis();
			}
			else {
				int cooldown=(int)(this.cooldownTime-(this.time2-this.time1))/1000;
				if (cooldown!=this.prevCooldown) {
					ITextComponent text = (ITextComponent) new TextComponentString("Ability in Cooldown: "+(cooldown+1)+" Seconds Left");
					player.sendMessage(text);
					this.prevCooldown=cooldown;
				}
			}
		}
		return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(handIn));
	}
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
		if (entityIn instanceof EntityPlayer) {
			if (isSelected==true) {
				if (!Mouse.isButtonDown(0)) {
					this.boosted=false;
				}
			}
			this.time2=System.currentTimeMillis();
			if (time2-time1>=this.cooldownTime) {
				if (this.using==true) {
					this.using=false;
					ITextComponent text = (ITextComponent) new TextComponentString(this.getItemStackDisplayName(stack)+"'s ability is now ready");
					entityIn.sendMessage(text);
				}
			}
			else this.using=true;
		}
    }
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
		if (this.radius<9 && this.boosted==false) {
			this.radius+=1;
			this.boosted=true;
			if (attacker instanceof EntityPlayer) {
				ITextComponent text = (ITextComponent) new TextComponentString("Cloud Radius: "+(int)this.radius);
				attacker.sendMessage(text);
			}
		}
        return false;
    }
}