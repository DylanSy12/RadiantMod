package mymod._01_ForgeYourSword;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;

import mymod.CustomEvents;
import mymod.Main;
import mymod._03_MagicArmor.DestructionArmor;
import mymod._03_MagicArmor.GodArmor;
import mymod._07_BuildAndBoom.ExplodingBlock;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
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

public class GodSword extends ItemSword {
	private long time1;
	private long time2;
	private int range;
	private boolean using;
	private boolean boosted;
	private int bolts;
	private int prevCooldown;
	private int cooldownTime;
	public GodSword() {
		super(Main.godSwordMaterial);
		this.setCreativeTab(CreativeTabs.COMBAT);
		this.time1=System.currentTimeMillis()-2500;
		this.range=200;
		this.using=false;
		this.boosted=false;
		this.bolts=1;
		this.prevCooldown=0;
		this.range=200;
		this.cooldownTime=5000;
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand handIn){
		if (!worldIn.isRemote) {
			this.time2=System.currentTimeMillis();
			if (time2-time1>=this.cooldownTime || player.capabilities.isCreativeMode) {
				int pieces=0;
				for (ItemStack armor:player.getArmorInventoryList()) {
					if (armor.getItem() instanceof GodArmor || armor.getItem() instanceof DestructionArmor) {
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
						CustomEvents.lightningStrikes.add(pos);
						CustomEvents.numBolts.add(this.bolts);
//						for (int i=0;i<=this.bolts;i++) {
//							worldIn.spawnEntity(new EntityLightningBolt(worldIn, entity.posX, entity.posY, entity.posZ, false));
//						}
//						worldIn.createExplosion(player, entity.posX, entity.posY, entity.posZ, this.bolts, false);
						
					}
					else {
						for (EntityLivingBase entity:entitylist) {
							BlockPos pos = new BlockPos(entity.posX,entity.posY,entity.posZ);
							CustomEvents.lightningStrikes.add(pos);
							CustomEvents.numBolts.add(this.bolts);
//							for (int i=0;i<=this.bolts;i++) {
//								worldIn.spawnEntity(new EntityLightningBolt(worldIn, entity.posX, entity.posY, entity.posZ, false));
//							}
//							worldIn.createExplosion(player, entity.posX, entity.posY, entity.posZ, this.bolts, false);
						}
					}
				}
				if (player.capabilities.isCreativeMode && this.bolts>1) this.bolts-=1;
				else this.bolts=1;
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
		if (this.bolts<10 && this.boosted==false) {
			this.bolts+=1;
			this.boosted=true;
			if (attacker instanceof EntityPlayer) {
				ITextComponent text = (ITextComponent) new TextComponentString("Lightning Strikes: "+this.bolts);
				attacker.sendMessage(text);
			}
		}
        return false;
    }
}