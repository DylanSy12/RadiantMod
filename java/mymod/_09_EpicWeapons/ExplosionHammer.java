package mymod._09_EpicWeapons;

import org.lwjgl.input.Mouse;

import mymod.Main;
import mymod.CodakidFiles.Codakid;
import mymod._03_MagicArmor.DestructionArmor;
import mymod._05_LuckyBlock.EntityNuke;
import mymod._07_BuildAndBoom.EntityBuildGrenade;
import mymod._07_BuildAndBoom.EntityClusterGrenade;
import mymod._07_BuildAndBoom.EntityEraserGrenade;
import mymod._07_BuildAndBoom.EntityGodBuildGrenade;
import mymod._07_BuildAndBoom.EntityGodEraserGrenade;
import mymod._07_BuildAndBoom.EntityGrenade;
import mymod._07_BuildAndBoom.EntityRecursiveClusterGrenade;
import mymod._07_BuildAndBoom.EntityWorldBuildGrenade;
import mymod._07_BuildAndBoom.EntityWorldEraserGrenade;
import mymod._07_BuildAndBoom.EntityWorldErasingGrenade;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ExplosionHammer extends ItemSword {
	private int explosionType;
//	private float amount;
	private int amount;
	private boolean using;
	private boolean switching;
	public ExplosionHammer() {
		super(Main.myToolMaterial20);
		this.setCreativeTab(CreativeTabs.COMBAT);
		this.explosionType=0;
//		this.amount=1;
		this.amount=10;
		this.using=false;
		this.switching=false;
	}
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
		if (!worldIn.isRemote) {
		if (entityIn instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entityIn;
			if (isSelected) {
				if (Mouse.isButtonDown(1)) {
//					if (this.explosionType==0 || this.explosionType==1) this.amount+=0.2f;
//					else if ((this.explosionType==3 || this.explosionType==5 || this.explosionType==7) && (int)this.amount<5) this.amount+=0.2f;
//					else if ((this.explosionType==2 || this.explosionType==4 || this.explosionType==6 || this.explosionType==8) && (int)this.amount<3) this.amount+=0.2f;
					if (this.explosionType==0 || this.explosionType==1) this.amount+=2;
					else if ((this.explosionType==3 || this.explosionType==5 || this.explosionType==7) && (int)this.amount<50) this.amount+=2;
					else if ((this.explosionType==2 || this.explosionType==4 || this.explosionType==6 || this.explosionType==8) && (int)this.amount<30) this.amount+=2;
//					if ((int)this.amount==this.amount) {
					if (this.amount%10==0 && !(this.explosionType==9 || this.explosionType==10 || this.explosionType==11)) {
						ITextComponent text = (ITextComponent) new TextComponentString("Amount: "+(int)(this.amount/10));
						player.sendMessage(text);
					}
					this.using=true;
				}
				else if (this.using==true) {
					this.using=false;
					Vec3d blockHit = player.rayTrace(200, 1f).hitVec;
//					for (int i=0;i<(int)this.amount;i++) {
					BlockPos pos = new BlockPos(blockHit.x,blockHit.y,blockHit.z);
					for (int i=0;i<(int)(this.amount/10);i++) {
						switch (this.explosionType) {
							case 0:
								Codakid.spawnEntity(worldIn, pos, new EntityTNTPrimed(worldIn));
								break;
							case 1:
								Codakid.spawnEntity(worldIn, pos, new EntityGrenade(worldIn));
								break;
							case 2:
								Codakid.spawnEntity(worldIn, pos, new EntityBuildGrenade(worldIn));
								break;
							case 3:
								Codakid.spawnEntity(worldIn, pos, new EntityClusterGrenade(worldIn));
								break;
							case 4:
								Codakid.spawnEntity(worldIn, pos, new EntityEraserGrenade(worldIn));
								break;
							case 5:
								Codakid.spawnEntity(worldIn, pos, new EntityNuke(worldIn));
								break;
							case 6:
								Codakid.spawnEntity(worldIn, pos, new EntityGodBuildGrenade(worldIn));
								break;
							case 7:
								Codakid.spawnEntity(worldIn, pos, new EntityRecursiveClusterGrenade(worldIn));
								break;
							case 8:
								Codakid.spawnEntity(worldIn, pos, new EntityGodEraserGrenade(worldIn));
								break;
							case 9:
								Codakid.spawnEntity(worldIn, pos, new EntityWorldEraserGrenade(worldIn));
								break;
							case 10:
								Codakid.spawnEntity(worldIn, pos, new EntityWorldBuildGrenade(worldIn));
								break;
							case 11:
								Codakid.spawnEntity(worldIn, pos, new EntityWorldErasingGrenade(worldIn));
								break;
						}
//						Codakid.spawnEntity(worldIn, new BlockPos(blockHit), this.explosions[this.explosionType]);
					}
//					this.amount=1;
					this.amount=10;
				}
				if (Mouse.isButtonDown(0)) {
					if (this.switching==false) {
						this.switching=true;
						if (this.explosionType<11) this.explosionType++;
						else this.explosionType=0;
						switch (this.explosionType) {
							case 0:
								sayChat("Primed TNT",player);
								break;
							case 1:
								sayChat("Radiant Grenade",player);
								break;
							case 2:
								sayChat("Radiant Build Grenade",player);
								break;
							case 3:
								sayChat("Radiant Cluster Grenade",player);
								break;
							case 4:
								sayChat("Mystical Eraser Grenade",player);
								break;
							case 5:
								sayChat("Radiant Nuke",player);
								break;
							case 6:
								sayChat("Godly Build Grenade",player);
								break;
							case 7:
								sayChat("Godly Recursive Cluster Grenade",player);
								break;
							case 8:
								sayChat("Godly Eraser Grenade",player);
								break;
							case 9:
								sayChat("World Destroying Grenade",player);
								break;
							case 10:
								sayChat("World Build Grenade",player);
								break;
							case 11:
								sayChat("World Erasing Grenade",player);
								break;
						}
					}
				}
				else this.switching=false;
			}
		}
		}
    }
	public void sayChat(String message,EntityPlayer player) {
		ITextComponent text = (ITextComponent) new TextComponentString("Mode: "+message);
		player.sendMessage(text);
	}
}