package mymod._01_ForgeYourSword;

import java.util.Random;

import javax.annotation.Nullable;

import mymod.Main;
import mymod.CodakidFiles.Codakid;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIZombieAttack;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class CustomMonster extends EntityMob {
	
	public float moveSpeed;
	public float attackDamage;
	public float health;
	public long explosionCooldown;
	
	public static final ResourceLocation LOOT = new ResourceLocation(Main.MODID, "entities/my_monster");
	
	public CustomMonster(World world)
	{
		super(world);
		this.explosionCooldown = System.currentTimeMillis();
	}

	@Override
	public boolean isImmuneToExplosions() {
		return true;
	}
	
	@Override
	public void onDeath(DamageSource cause) {
		if (net.minecraftforge.common.ForgeHooks.onLivingDeath(this, cause))
			return;
		if (!this.dead) {
			Entity entity = cause.getTrueSource();
			EntityLivingBase entitylivingbase = this.getAttackingEntity();

			if (this.scoreValue >= 0 && entitylivingbase != null) {
				entitylivingbase.awardKillScore(this, this.scoreValue, cause);
			}

			if (entity != null) {
				entity.onKillEntity(this);
			}

			this.dead = true;
			this.getCombatTracker().reset();

			if (!this.world.isRemote) {
				Random rand = new Random();
				for (int i = 0; i < 3; i++) {
					int x = rand.nextInt(70) - 35;
					int y = rand.nextInt(20) - 10;
					int z = rand.nextInt(70) - 35;
					this.world.createExplosion(this, this.posX + x, this.posY + y, this.posZ + z, 50, true);
				}
				int i = net.minecraftforge.common.ForgeHooks.getLootingLevel(this, entity, cause);

				captureDrops = true;
				capturedDrops.clear();

				if (this.canDropLoot() && this.world.getGameRules().getBoolean("doMobLoot")) {
					boolean flag = this.recentlyHit > 0;
					this.dropLoot(flag, i, cause);
				}

				captureDrops = false;

				if (!net.minecraftforge.common.ForgeHooks.onLivingDrops(this, cause, capturedDrops, i,
						recentlyHit > 0)) {
					for (EntityItem item : capturedDrops) {
						world.spawnEntity(item);
					}
				}
			}

			this.world.setEntityState(this, (byte) 3);
		}
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		
		this.moveSpeed = 1.25F;
		this.attackDamage = 25;
		this.health = 750;
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(50.0D);
		Codakid.setMovementSpeed(this, this.moveSpeed);
		Codakid.setAttackDamage(this, this.attackDamage);
		Codakid.setMaxHealth(this, this.health);
	}

    protected void applyEntityAI()
    {
        this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[] {EntityPigZombie.class}));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityVillager.class, false));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityIronGolem.class, true));
        this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityMob.class, true));
    }
	@Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, false));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityMob.class, 8.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.applyEntityAI();
    }
	
	@Nullable
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
    {
        livingdata = super.onInitialSpawn(difficulty, livingdata);
        if (this.rand.nextInt(10) == 1) {
        	this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Main.myHelmet));
        }
        if (this.rand.nextInt(10) == 1) {
        	this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Main.myChestplate));
        }
        if (this.rand.nextInt(10) == 1) {
        	this.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(Main.myLeggings));
        }
        if (this.rand.nextInt(10) == 1) {
        	this.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(Main.myBoots));
        }
        if (this.rand.nextInt(10) == 1) {
        	int i = this.rand.nextInt(6);
        	if (i <= 2) this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Main.mySword));
        	else if (i <= 3) this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Main.radiantSwordL));
        	else this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Main.myHammer));
        }
        this.setCanPickUpLoot(true);

        return livingdata;
    }
	
	@Override
    @Nullable
    protected ResourceLocation getLootTable() {
        return LOOT;
    }	

}