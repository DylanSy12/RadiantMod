package mymod._01_ForgeYourSword;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;

import mymod.CustomEvents;
import mymod.Main;
import mymod._03_MagicArmor.CustomArmor;
import mymod._03_MagicArmor.DestructionArmor;
import mymod._03_MagicArmor.GodArmor;
import mymod._03_MagicArmor.MysticalArmor;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CustomSword extends ItemSword {
	private long time1;
	private long time2;
	private boolean using;
	private float power;
	private boolean boosted;
	private int prevCooldown;
	private int cooldownTime;
	public CustomSword() {
		super(Main.myToolMaterial);
		this.setCreativeTab(CreativeTabs.COMBAT);
		this.time1=System.currentTimeMillis()-1250;
		this.using=false;
		this.power=3;
		this.boosted=false;
		this.prevCooldown=0;
		this.cooldownTime=2500;
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand handIn){
		if (!worldIn.isRemote) {
			this.time2=System.currentTimeMillis();
			if (time2-time1>=this.cooldownTime || player.capabilities.isCreativeMode) {
				int pieces=0;
				for (ItemStack armor:player.getArmorInventoryList()) {
					if (armor.getItem() instanceof CustomArmor || armor.getItem() instanceof DestructionArmor) {
						pieces+=1;
					}
				}
				if (pieces==4 || player.capabilities.isCreativeMode) {
//					Vec3d blockHit = player.rayTrace(200, 1f).hitVec;
//					worldIn.spawnEntity(new EntityLightningBolt(worldIn, blockHit.x, blockHit.y, blockHit.z, false));
					EntityLargeFireball entityFireball = new EntityLargeFireball(worldIn, player, 6F, 7F, 9F);
					entityFireball.explosionPower=(int)this.power;
					Vec3d looking = entityFireball.getLookVec();
		            if (looking != null) {
		            	entityFireball.motionX = looking.x;
		            	entityFireball.motionY = looking.y;
		            	entityFireball.motionZ = looking.z;
		            	entityFireball.accelerationX = entityFireball.motionX * 0.1D;
		            	entityFireball.accelerationY = entityFireball.motionY * 0.1D;
		            	entityFireball.accelerationZ = entityFireball.motionZ * 0.1D;
		            }
		            worldIn.spawnEntity(entityFireball);
				}
				if (player.capabilities.isCreativeMode && this.power>3) this.power-=3;
				else this.power=3;
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
		if (this.power<75 && this.boosted==false) {
			this.power+=3;
			this.boosted=true;
			if (attacker instanceof EntityPlayer) {
				ITextComponent text = (ITextComponent) new TextComponentString("Fireball Power: "+(int)this.power);
				attacker.sendMessage(text);
			}
		}
        return false;
    }
}