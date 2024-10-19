package mymod._01_ForgeYourSword;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.lwjgl.input.Mouse;

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
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.init.Blocks;
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

public class DestructionSword extends ItemSword {
	private float explosionStrength;
	private int range;
	private boolean using;
	private boolean boosted;
	private long time1;
	private long time2;
	private int prevCooldown;
	private int cooldownTime;
	public DestructionSword() {
		super(Main.destructionSwordMaterial);
		this.setCreativeTab(CreativeTabs.COMBAT);
		this.explosionStrength=5;
//		this.range=200;
		this.using=false;
		this.boosted=false;
		this.time1=System.currentTimeMillis()-5000;
		this.prevCooldown=0;
		this.cooldownTime=10000;
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand handIn) {
		if (!worldIn.isRemote) {
			this.time2=System.currentTimeMillis();
			if (time2-time1>=this.cooldownTime || player.capabilities.isCreativeMode) {
				int pieces=0;
				for (ItemStack armor:player.getArmorInventoryList()) {
					if (armor.getItem() instanceof DestructionArmor) {
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
//						ExplodingBlock explodingBlock = new ExplodingBlock(this.explosionStrength);
//						worldIn.setBlockState(pos, explodingBlock.getDefaultState());
//						worldIn.immediateBlockTick(pos, worldIn.getBlockState(pos), worldIn.rand);
						CustomEvents.radiantExplosions.add(pos);
						CustomEvents.explosionPower.add(this.explosionStrength);
					}
					else {
						for (EntityLivingBase entity:entitylist) {
							BlockPos pos = new BlockPos(entity.posX,entity.posY,entity.posZ);
//							ExplodingBlock explodingBlock = new ExplodingBlock(this.explosionStrength);
//							worldIn.setBlockState(pos, explodingBlock.getDefaultState());
//							worldIn.immediateBlockTick(pos, worldIn.getBlockState(pos), worldIn.rand);
							CustomEvents.radiantExplosions.add(pos);
							CustomEvents.explosionPower.add(this.explosionStrength);
						}
					}
				}
				if (player.capabilities.isCreativeMode && this.explosionStrength>5) this.explosionStrength-=5;
				else this.explosionStrength=5;
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
//	Mouse.isButtonDown(1)
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
		if (this.explosionStrength<255 && this.boosted==false) {
			this.explosionStrength+=5;
			this.boosted=true;
			if (attacker instanceof EntityPlayer) {
				ITextComponent text = (ITextComponent) new TextComponentString("Explosion Power: "+(int)this.explosionStrength);
				attacker.sendMessage(text);
			}
		}
        return false;
    }
	public void spawnExplosion(World worldIn, BlockPos pos) {
		EntityCreeper creeper = new EntityCreeper(worldIn);
		NBTTagCompound tag = new NBTTagCompound();
		creeper.writeEntityToNBT(tag);
//		tag.setBoolean("ignited", true);
		tag.setShort("Fuse", (short)1);
		tag.setByte("ExplosionRadius", (byte)this.explosionStrength);
		creeper.readEntityFromNBT(tag);
		creeper.setPosition(pos.getX(), pos.getY(), pos.getZ());
//		creeper.setNoGravity(true);
//		creeper.setNoAI(true);
//		creeper.setCreeperState(1);
		worldIn.spawnEntity(creeper);
//		Codakid.spawnEntity(worldIn, pos, creeper);
//		creeper.setInvisible(true);
		creeper.setCustomNameTag("Destruction Sword Bomb");
//		creeper.getDataManager().set(creeper., Boolean.valueOf(true));
//		creeper.ignite();
		System.out.println(creeper.hasIgnited());
		System.out.println(creeper.getCreeperState());
//		worldIn.updateEntity(creeper);
	}
	public boolean causeExplosions(World worldIn, EntityPlayer player, BlockPos pos1, BlockPos pos2) {
		boolean creepers = false;
		for (Entity entity:worldIn.getEntitiesWithinAABBExcludingEntity(player, new AxisAlignedBB(pos1, pos2))) {
			if (entity instanceof EntityCreeper) {
				if (entity.getCustomNameTag()=="Destruction Sword Bomb") {
					BlockPos pos = new BlockPos(entity.posX, entity.posY, entity.posZ);
					spawnExplosion(worldIn, pos);
//					worldIn.removeEntity(entity);
					creepers = true;
				}
			}
		}
		worldIn.updateEntities();
		if (creepers==true) return causeExplosions(worldIn, player, pos1, pos2);
		else return false;
	}
	private float getExplosionStrength() {
		return this.explosionStrength;
	}
}