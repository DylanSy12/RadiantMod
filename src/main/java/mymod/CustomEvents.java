package mymod;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.lwjgl.opengl.GL11;

import akka.actor.FSM.Event;
import mymod.Commands.CommandCancelNuke;
import mymod._01_ForgeYourSword.CustomMonster;
import mymod._01_ForgeYourSword.DestructionSword;
import mymod._01_ForgeYourSword.LegendDestructionSword;
import mymod._01_ForgeYourSword.LegendGodSword;
import mymod._01_ForgeYourSword.LegendMysticalSword;
import mymod._01_ForgeYourSword.LegendRadiantSword;
import mymod._03_MagicArmor.CustomArmor;
import mymod._03_MagicArmor.DestructionArmor;
import mymod._03_MagicArmor.GodArmor;
import mymod._03_MagicArmor.GodlyPotionOrb;
import mymod._03_MagicArmor.MysticalArmor;
import mymod._04_CreateACreature.DestructionMonster;
import mymod._04_CreateACreature.GodMonster;
import mymod._04_CreateACreature.MysticalMonster;
import mymod._07_BuildAndBoom.ExplodingBlock;
import mymod._07_BuildAndBoom.SphereExplosion;
import mymod._07_BuildAndBoom.SpherePoints;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderLightningBolt;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.command.ICommand;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityDragonFireball;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagLong;
import net.minecraft.potion.PotionEffect;
import net.minecraft.scoreboard.IScoreCriteria;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

//@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid = Main.MODID)
public class CustomEvents {
	public static long time4 = System.currentTimeMillis();
	public static List<BlockPos> cloudAreas = new ArrayList<BlockPos>();
	public static List<BlockPos> lightningStrikes = new ArrayList<BlockPos>();
	public static List<BlockPos> radiantExplosions = new ArrayList<BlockPos>();
	public static List<Float> effectRadius = new ArrayList<Float>();
	public static List<Integer> numBolts = new ArrayList<Integer>();
	public static List<Float> explosionPower = new ArrayList<Float>();
	public static List<BlockPos> cloudAreasL = new ArrayList<BlockPos>();
	public static List<BlockPos> lightningStrikesL = new ArrayList<BlockPos>();
	public static List<BlockPos> radiantExplosionsL = new ArrayList<BlockPos>();
	public static List<Float> effectRadiusL = new ArrayList<Float>();
	public static List<Integer> numBoltsL = new ArrayList<Integer>();
	public static List<Float> explosionPowerL = new ArrayList<Float>();
	public static List<SphereExplosion> sphereExplosionList = new ArrayList<SphereExplosion>();
	public static Map<EntityPlayer, Long> doomTimers = new HashMap();
	public static Map<EntityPlayer, Long> shieldCooldowns = new HashMap();
	public static Map<EntityPlayer, Integer> playerShields = new HashMap();
	public static Map<EntityPlayer, Float> prevHealths = new HashMap();
	public static Map<EntityPlayer, Boolean> curseKills = new HashMap();
	public static Map<EntityPlayer, Boolean> maxHealthBoost = new HashMap();
//	public static Map<EntityLivingBase, Long> shieldCooldownTimers = new HashMap();
//	public static Map<EntityLivingBase, Integer> entityShieldStrength = new HashMap();
	
	@SubscribeEvent
	public void playerJoinEvents(PlayerEvent.PlayerLoggedInEvent event) {
		EntityPlayer player = event.player;
//		World world = player.getEntityWorld();
		doomTimers.put(player, System.currentTimeMillis());
		shieldCooldowns.put(player, System.currentTimeMillis());
		playerShields.put(player, 0);
		prevHealths.put(player, player.getHealth());
		curseKills.put(player, false);
	}
	
	@SubscribeEvent
	public void playerLeaveEvents(PlayerEvent.PlayerLoggedOutEvent event) {
		EntityPlayer player = event.player;
//		World world = player.getEntityWorld();
		doomTimers.remove(player);
		shieldCooldowns.remove(player);
		playerShields.remove(player);
		prevHealths.remove(player);
		curseKills.remove(player);
	}
	
//	@SubsribeEvent
//	public void newEvent(Living event) {
//		
//	}
	
//	@SubscribeEvent
//	public void customGUIEvents(GuiScreenEvent.DrawScreenEvent.Pre event) 
//	{
//		if (event.getGui() instanceof GuiContainer)
//		{
//			GlStateManager.disableTexture2D();
//            GlStateManager.color(1F, 1F, 1F, 1F);
//            BufferBuilder bb = Tessellator.getInstance().getBuffer();
//            GuiContainer container = (GuiContainer) event.getGui();
//            int i = container.getGuiLeft();
//            int j = container.getGuiTop();
//            bb.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_COLOR);
//            for (Slot s : container.inventorySlots.inventorySlots)
//            {
//                if (!s.getStack().isEmpty())
//                {
//                    float x = s.xPos;
//                    float y = s.yPos;
//                    if (s.getStack().getItem() instanceof LegendGodSword)
//                    {
////                    	LegendGodSword item = (LegendGodSword) container.mc.player.inventory.mainInventory.get(s.slotNumber).getItem();
//                    	LegendGodSword item = (LegendGodSword) s.getStack().getItem();
//                        bb.pos(i + x + 1, j + y + 3, 100).color(0.9098f, 0.9098f, 0.9098f, 1F).endVertex();
//                        bb.pos(i + x + 15, j + y + 3, 100).color(0.9098f, 0.9098f, 0.9098f, 1F).endVertex();
//                        bb.pos(i + x + 15, j + y + 1, 100).color(0.9098f, 0.9098f, 0.9098f, 1F).endVertex();
//                        bb.pos(i + x + 1, j + y + 1, 100).color(0.9098f, 0.9098f, 0.9098f, 1F).endVertex();
//                        float val = ((float) item.charge)/((float) item.maxCharge);
//                        bb.pos(i + x + 1, j + y + 2, 100).color(1f, 0.9412f, 0.6784f, 1F).endVertex();
//                        bb.pos(i + x + 1 + 14 * val, j + y + 2, 100).color(1f, 0.9412f, 0.6784f, 1F).endVertex();
//                        bb.pos(i + x + 1 + 14 * val, j + y + 1, 100).color(1f, 0.9412f, 0.6784f, 1F).endVertex();
//                        bb.pos(i + x + 1, j + y + 1, 100).color(1f, 0.9412f, 0.6784f, 1F).endVertex();
//                    }
//                }
//            }
//
//            Tessellator.getInstance().draw();
//            GlStateManager.enableTexture2D();
//		}
//	}
	
//	@SubscribeEvent
//	public void customRenderEvents(RenderTickEvent event) {
//		event.
//	}
	
//	@SubscribeEvent
//	public void customRenderEvents(RenderTooltipEvent event) {
//		
//	}
//	
//	@SubscribeEvent
//	public void customHUDEvents(RenderGameOverlayEvent.Pre event) {
//		EntityPlayer player = Minecraft.getMinecraft().player;
//		if (event.getType() == ElementType.HOTBAR) {
//			ScaledResolution sr = event.getResolution();
//			int i = sr.getScaledWidth() / 2;
//			for (int l = 0; l < 9; ++l)
//            {
//                int i1 = i - 90 + l * 20 + 2;
//                int j1 = sr.getScaledHeight() - 16 - 3;
//                renderHotbarItem(i1, j1, event.getPartialTicks(), player, player.inventory.mainInventory.get(l));
//            }
//		}
//	}
	
	//TODO Add the attack triggers for the swords here
	@SubscribeEvent
	public void attackEvents(LivingDamageEvent event) {
		World world = event.getEntity().getEntityWorld();
		if (event.getEntity() instanceof EntityLivingBase) {
			EntityLivingBase entity = (EntityLivingBase) event.getEntity();
			if (entity instanceof DestructionMonster || entity instanceof GodMonster || entity instanceof MysticalMonster || entity instanceof CustomMonster) {
				if (entity instanceof DestructionMonster) {
					DestructionMonster destructionMonster = (DestructionMonster)entity;
					System.out.println("DestructionLord Health:" + (destructionMonster.getHealth()+destructionMonster.healthExtra));
				}
				else if (entity instanceof GodMonster) {
					GodMonster godMonster = (GodMonster)entity;
					System.out.println("GodLord Health:" + (godMonster.getHealth()));
				}
				else if (entity instanceof CustomMonster) {
					CustomMonster radiantMonster = (CustomMonster)entity;
					System.out.println("RadiantLord Health:" + (radiantMonster.getHealth()));
				}
				else if (entity instanceof MysticalMonster) {
					MysticalMonster mysticalMonster = (MysticalMonster)entity;
					System.out.println("MysticalLord Health:" + (mysticalMonster.getHealth()));
				}
			}
			Random rand = new Random();
			// destruction lord damage
			if (event.getSource().getTrueSource() instanceof DestructionMonster && !event.getSource().isExplosion() && event.getSource().getTrueSource() != entity) {
				if (!world.isRemote) {
					int x = rand.nextInt(2)-1;
        			int z = rand.nextInt(2)-1;
					for (int i = 0; i < 2; i++) {
						EntityLightningBolt bolt = new EntityLightningBolt(world, entity.posX+x, entity.posY, entity.posZ+z, false);
						bolt.setPosition(entity.posX, entity.posY, entity.posZ);
						world.spawnEntity(bolt);
						world.addWeatherEffect(bolt);
						world.createExplosion(event.getSource().getTrueSource(), entity.posX+x, entity.posY, entity.posZ+z, 2, true);
					}
					BlockPos pos = new BlockPos(entity.posX+x, entity.posY, entity.posZ+z);
					float radius = 3;
					EntityAreaEffectCloud entityareaeffectcloud = new EntityAreaEffectCloud(world, pos.getX(), pos.getY(), pos.getZ());
	                entityareaeffectcloud.setOwner((DestructionMonster) event.getSource().getTrueSource());
	                entityareaeffectcloud.setParticle(EnumParticleTypes.REDSTONE);
	                entityareaeffectcloud.setRadius(radius);
	                entityareaeffectcloud.setDuration(200);
	                entityareaeffectcloud.addEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE, 1, 2));
	                entityareaeffectcloud.addEffect(new PotionEffect(MobEffects.WITHER, 150, 3));
	                entityareaeffectcloud.setPosition(pos.getX(), pos.getY(), pos.getZ());
	                world.playEvent(2006, pos, 0);
	                world.spawnEntity(entityareaeffectcloud);
				}
			}
			// god lord damage
			if (event.getSource().getTrueSource() instanceof GodMonster && !event.getSource().isExplosion() && event.getSource().getTrueSource() != entity) {
				if (!world.isRemote) {
					int x = rand.nextInt(2)-1;
        			int z = rand.nextInt(2)-1;
					EntityLightningBolt bolt = new EntityLightningBolt(world, entity.posX+x, entity.posY, entity.posZ+z, false);
					bolt.setPosition(entity.posX+x, entity.posY, entity.posZ+z);
					world.spawnEntity(bolt);
					world.addWeatherEffect(bolt);
					world.createExplosion(event.getSource().getTrueSource(), entity.posX+x, entity.posY, entity.posZ+z, 1, false);
				}
			}
			// radiant lord damage
			if (event.getSource().getTrueSource() instanceof CustomMonster && !event.getSource().isExplosion() && event.getSource().getTrueSource() != entity) {
				if (!world.isRemote) {
					int x = rand.nextInt(4)-2;
        			int z = rand.nextInt(4)-2;
					world.createExplosion(event.getSource().getTrueSource(), entity.posX+x, entity.posY+2, entity.posZ+z, 2, true);
				}
			}
			// mystical lord damage
			if (event.getSource().getTrueSource() instanceof MysticalMonster && event.getSource().getTrueSource() != entity) {
				if (!world.isRemote) {
					int x = rand.nextInt(4)-2;
        			int z = rand.nextInt(4)-2;
					BlockPos pos = new BlockPos(entity.posX+x, entity.posY, entity.posZ+z);
					float radius = 1.5f;
					EntityAreaEffectCloud entityareaeffectcloud = new EntityAreaEffectCloud(world, pos.getX(), pos.getY(), pos.getZ());
	                entityareaeffectcloud.setOwner((MysticalMonster)event.getSource().getTrueSource());
	                entityareaeffectcloud.setParticle(EnumParticleTypes.DRAGON_BREATH);
	                entityareaeffectcloud.setRadius(radius);
	                entityareaeffectcloud.setDuration(100);
	                entityareaeffectcloud.addEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE, 1, 1));
	                entityareaeffectcloud.addEffect(new PotionEffect(MobEffects.POISON, 100, 2));
	                entityareaeffectcloud.setPosition(pos.getX(), pos.getY(), pos.getZ());
	                world.playEvent(2006, pos, 0);
	                world.spawnEntity(entityareaeffectcloud);
				}
			}
		}
		//TODO Make it so that it doesn't trigger off of thorns or area damage
//		if (event.getSource().getTrueSource() instanceof EntityLivingBase) {
//			EntityLivingBase attacker = (EntityLivingBase) event.getSource().getTrueSource();
//			if (attacker.getHeldItemMainhand().getItem() instanceof LegendGodSword) {
//				NBTTagCompound nbt = attacker.getHeldItemMainhand().getTagCompound();
//				int c = nbt.getInteger("charge");
//				if (c < nbt.getInteger("max_charge")) {
//					attacker.getHeldItemMainhand().getTagCompound().setInteger("charge", c+nbt.getInteger("charge_increment"));
//					if (attacker instanceof EntityPlayer) 
//					{
//						ITextComponent text = (ITextComponent) new TextComponentString("Lightning Strikes: "+attacker.getHeldItemMainhand().getTagCompound().getInteger("charge"));
//						attacker.sendMessage(text);
//					}
//				}
//			}
//		}
	}
	
	@SubscribeEvent
	public void hurtEvents(LivingHurtEvent event) {
		World world = event.getEntity().getEntityWorld();
		if (event.getEntity() instanceof EntityLivingBase) {
			EntityLivingBase entity = (EntityLivingBase) event.getEntity();
			// destruction armor explosion immunity
			int pieces = 0;
			for (ItemStack armor : entity.getArmorInventoryList()) {
				if (armor.getItem() instanceof DestructionArmor) {
					pieces += 1;
				}
			}
			if (event.getSource().isExplosion() && (pieces == 4)) {
				event.setCanceled(true);
			}
		}
	}
	
	@SubscribeEvent
	public void EntityTickEvents(LivingEvent.LivingUpdateEvent event) {
		EntityLivingBase entity = event.getEntityLiving();
		World world = entity.getEntityWorld();
		time4 = System.currentTimeMillis();
		if (entity instanceof DestructionMonster) {
			DestructionMonster destructionMonster = (DestructionMonster)entity;
			if (destructionMonster.isPotionActive(MobEffects.RESISTANCE) == false) {
				destructionMonster.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 450, 2));
			}
			if ((int)destructionMonster.getHealth() != (int)destructionMonster.prevHealth && (int)destructionMonster.healthExtra > 0 && !destructionMonster.isDead && (int)destructionMonster.getHealth() != 0) {
				destructionMonster.healthExtra -= destructionMonster.prevHealth-destructionMonster.getHealth();
				destructionMonster.setHealth(destructionMonster.prevHealth);
			}
			destructionMonster.prevHealth = destructionMonster.getHealth();
			if (time4-destructionMonster.explosionCooldown >= 15000) {
				BlockPos pos1 = new BlockPos(destructionMonster.posX-20, destructionMonster.posY-20, destructionMonster.posZ-20);
				BlockPos pos2 = new BlockPos(destructionMonster.posX+20, destructionMonster.posY+20, destructionMonster.posZ+20);
				AxisAlignedBB box = new AxisAlignedBB(pos1, pos2);
				List<Entity> entityList = world.getEntitiesWithinAABBExcludingEntity(destructionMonster, box);
				List<EntityLivingBase> entitylist = new ArrayList<EntityLivingBase>();
				for (Entity thing : entityList) {
					if (thing instanceof EntityLivingBase) entitylist.add((EntityLivingBase)thing);
				}
				if (!entitylist.isEmpty()) {
					if (!world.isRemote) {
//						world.createExplosion(destructionMonster, destructionMonster.posX, destructionMonster.posY, destructionMonster.posZ, 9, true);
						Random rand = new Random();
						for (int i = 0; i < 3; i++) {
							int x = rand.nextInt(60)-30;
							int y = rand.nextInt(30)-15;
							int z = rand.nextInt(60)-30;
							world.createExplosion(destructionMonster, destructionMonster.posX+x, destructionMonster.posY+y, destructionMonster.posZ+z, 30, true);
						}
						for (int i = 0; i < 15; i++) {
		        			int x = rand.nextInt(40)-20;
		        			int y = rand.nextInt(20)-10;
		        			int z = rand.nextInt(40)-20;
		            		EntityLightningBolt bolt = new EntityLightningBolt(world, destructionMonster.posX+x, destructionMonster.posY+y, destructionMonster.posZ+z, false);
							bolt.setPosition(destructionMonster.posX+x, destructionMonster.posY+y, destructionMonster.posZ+z);
							world.spawnEntity(bolt);
							world.addWeatherEffect(bolt);
							world.createExplosion(destructionMonster, destructionMonster.posX+x, destructionMonster.posY+y, destructionMonster.posZ+z, 6, true);
		        		}
						for (int i = 0; i < 5; i++) {
		        			int x = rand.nextInt(30)-15;
		        			int y = rand.nextInt(10)-5;
		        			int z = rand.nextInt(30)-15;
		        			BlockPos pos = new BlockPos(destructionMonster.posX+x, destructionMonster.posY+y, destructionMonster.posZ+z);
							float radius = 6;
							EntityAreaEffectCloud entityareaeffectcloud = new EntityAreaEffectCloud(world, pos.getX(), pos.getY(), pos.getZ());
			                entityareaeffectcloud.setOwner(destructionMonster);
			                entityareaeffectcloud.setParticle(EnumParticleTypes.REDSTONE);
			                entityareaeffectcloud.setRadius(radius);
			                entityareaeffectcloud.setDuration(200);
			                entityareaeffectcloud.setRadiusPerTick((7.0F-entityareaeffectcloud.getRadius())/(float)entityareaeffectcloud.getDuration());
			                entityareaeffectcloud.addEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE, 1, 3));
			                entityareaeffectcloud.addEffect(new PotionEffect(MobEffects.WITHER, 300, 9));
			                entityareaeffectcloud.setPosition(pos.getX(), pos.getY(), pos.getZ());
			                world.playEvent(2006, pos, 0);
			                world.spawnEntity(entityareaeffectcloud);
		        		}
						destructionMonster.explosionCooldown = System.currentTimeMillis();
					}
				}
			}
		}
		else if (entity instanceof GodMonster) {
			GodMonster godMonster = (GodMonster)entity;
			if (godMonster.isPotionActive(MobEffects.RESISTANCE) == false) {
				godMonster.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 450, 1));
			}
			if (time4-godMonster.lightningCooldown >= 20000) {
				BlockPos pos1 = new BlockPos(godMonster.posX-20, godMonster.posY-20, godMonster.posZ-20);
				BlockPos pos2 = new BlockPos(godMonster.posX+20, godMonster.posY+20, godMonster.posZ+20);
				AxisAlignedBB box = new AxisAlignedBB(pos1, pos2);
				List<Entity> entityList = world.getEntitiesWithinAABBExcludingEntity(godMonster, box);
				List<EntityLivingBase> entitylist = new ArrayList<EntityLivingBase>();
				for (Entity thing : entityList) {
					if (thing instanceof EntityLivingBase) entitylist.add((EntityLivingBase)thing);
				}
				if (!entitylist.isEmpty()) {
					if (!world.isRemote) {
						Random rand = new Random();
						for (int i = 0; i < 10; i++) {
		        			int x = rand.nextInt(30)-15;
		        			int y = rand.nextInt(10)-5;
		        			int z = rand.nextInt(30)-15;
		            		EntityLightningBolt bolt = new EntityLightningBolt(world, godMonster.posX+x, godMonster.posY+y, godMonster.posZ+z, false);
							bolt.setPosition(godMonster.posX+x, godMonster.posY+y, godMonster.posZ+z);
							world.spawnEntity(bolt);
							world.addWeatherEffect(bolt);
							world.createExplosion(godMonster, godMonster.posX+x, godMonster.posY+y, godMonster.posZ+z, 6, true);
		        		}
						godMonster.lightningCooldown = System.currentTimeMillis();
					}
				}
			}
		}
		else if (entity instanceof CustomMonster) {
			CustomMonster radiantMonster = (CustomMonster)entity;
			if (time4-radiantMonster.explosionCooldown >= 20000) {
				BlockPos pos1 = new BlockPos(radiantMonster.posX-20, radiantMonster.posY-20, radiantMonster.posZ-20);
				BlockPos pos2 = new BlockPos(radiantMonster.posX+20, radiantMonster.posY+20, radiantMonster.posZ+20);
				AxisAlignedBB box = new AxisAlignedBB(pos1, pos2);
				List<Entity> entityList = world.getEntitiesWithinAABBExcludingEntity(radiantMonster, box);
				List<EntityLivingBase> entitylist = new ArrayList<EntityLivingBase>();
				for (Entity thing : entityList) {
					if (thing instanceof EntityLivingBase) entitylist.add((EntityLivingBase)thing);
				}
				if (!entitylist.isEmpty()) {
					if (!world.isRemote) {
						Random rand = new Random();
						for (int i = 0; i < 2; i++) {
							int x = rand.nextInt(50)-25;
							int y = rand.nextInt(20)-10;
							int z = rand.nextInt(50)-25;
							world.createExplosion(radiantMonster, radiantMonster.posX+x, radiantMonster.posY+y, radiantMonster.posZ+z, 20, true);
						}
						radiantMonster.explosionCooldown = System.currentTimeMillis();
					}
				}
			}
		}
		else if (entity instanceof MysticalMonster) {
			MysticalMonster mysticalMonster = (MysticalMonster)entity;
			if (time4-mysticalMonster.effectCooldown >= 20000) {
				BlockPos pos1 = new BlockPos(mysticalMonster.posX-20, mysticalMonster.posY-20, mysticalMonster.posZ-20);
				BlockPos pos2 = new BlockPos(mysticalMonster.posX+20, mysticalMonster.posY+20, mysticalMonster.posZ+20);
				AxisAlignedBB box = new AxisAlignedBB(pos1, pos2);
				List<Entity> entityList = world.getEntitiesWithinAABBExcludingEntity(mysticalMonster, box);
				List<EntityLivingBase> entitylist = new ArrayList<EntityLivingBase>();
				for (Entity thing : entityList) {
					if (thing instanceof EntityLivingBase) entitylist.add((EntityLivingBase)thing);
				}
				if (!entitylist.isEmpty()) {
					if (!world.isRemote) {
						Random rand = new Random();
						for (int i = 0; i < 3; i++) {
		        			int x = rand.nextInt(20)-10;
		        			int y = rand.nextInt(10)-5;
		        			int z = rand.nextInt(20)-10;
		        			BlockPos pos = new BlockPos(mysticalMonster.posX+x, mysticalMonster.posY+y, mysticalMonster.posZ+z);
							float radius = 4;
							EntityAreaEffectCloud entityareaeffectcloud = new EntityAreaEffectCloud(world, pos.getX(), pos.getY(), pos.getZ());
			                entityareaeffectcloud.setOwner(mysticalMonster);
			                entityareaeffectcloud.setParticle(EnumParticleTypes.DRAGON_BREATH);
			                entityareaeffectcloud.setRadius(radius);
			                entityareaeffectcloud.setDuration(150);
			                entityareaeffectcloud.setRadiusPerTick((7.0F-entityareaeffectcloud.getRadius())/(float)entityareaeffectcloud.getDuration());
			                entityareaeffectcloud.addEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE, 1, 2));
			                entityareaeffectcloud.addEffect(new PotionEffect(MobEffects.POISON, 200, 6));
			                entityareaeffectcloud.setPosition(pos.getX(), pos.getY(), pos.getZ());
			                world.playEvent(2006, pos, 0);
			                world.spawnEntity(entityareaeffectcloud);
		        		}
						mysticalMonster.effectCooldown = System.currentTimeMillis();
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void CustomTickEvents(TickEvent.WorldTickEvent event) {
		World world = event.world;
		if (!world.isRemote) {
			if (!lightningStrikes.isEmpty() && !numBolts.isEmpty()) {
				BlockPos pos = lightningStrikes.get(0);
				int bolts = numBolts.get(0);
				for (int i = 0; i < bolts; i++) {
					EntityLightningBolt bolt = new EntityLightningBolt(world, pos.getX(), pos.getY(), pos.getZ(), false);
					bolt.setPosition(pos.getX(), pos.getY(), pos.getZ());
					world.spawnEntity(bolt);
					world.addWeatherEffect(bolt);
				}
				world.createExplosion(null, pos.getX(), pos.getY()+2, pos.getZ(), (float) bolts, false);
				lightningStrikes.remove(pos);
				numBolts.remove(0);
			}
			if (!lightningStrikesL.isEmpty() && !numBoltsL.isEmpty()) {
				BlockPos pos = lightningStrikesL.get(0);
				int bolts = numBoltsL.get(0);
				for (int i = 0; i < bolts; i++) {
					EntityLightningBolt bolt = new EntityLightningBolt(world, pos.getX(), pos.getY(), pos.getZ(), false);
					bolt.setPosition(pos.getX(), pos.getY(), pos.getZ());
					world.spawnEntity(bolt);
					world.addWeatherEffect(bolt);
				}
				for (int i = 0; i < 3; i++) world.createExplosion(null, pos.getX(), pos.getY()+2, pos.getZ(), (float) bolts, true);
//				System.out.println("bolts: "+bolts);
				lightningStrikesL.remove(pos);
				numBoltsL.remove(0);
			}
			if (!radiantExplosions.isEmpty() && !explosionPower.isEmpty()) {
				BlockPos pos = radiantExplosions.get(0);
				float power = explosionPower.get(0);
				world.newExplosion(null, pos.getX(), pos.getY(), pos.getZ(), power, false, true);
				radiantExplosions.remove(pos);
				explosionPower.remove(power);
			}
			if (!radiantExplosionsL.isEmpty() && !explosionPowerL.isEmpty()) {
				BlockPos pos = radiantExplosionsL.get(0);
				float power = explosionPowerL.get(0);
				world.newExplosion(null, pos.getX(), pos.getY(), pos.getZ(), power, false, true);
				radiantExplosionsL.remove(pos);
				explosionPowerL.remove(power);
			}
			if (!cloudAreas.isEmpty() && !effectRadius.isEmpty()) {
				BlockPos pos = cloudAreas.get(0);
				float radius = effectRadius.get(0);
				EntityAreaEffectCloud entityareaeffectcloud = new EntityAreaEffectCloud(world, pos.getX(), pos.getY(), pos.getZ());
                entityareaeffectcloud.setOwner(null);
                entityareaeffectcloud.setParticle(EnumParticleTypes.DRAGON_BREATH);
                entityareaeffectcloud.setRadius(radius);
                entityareaeffectcloud.setDuration(600);
//                entityareaeffectcloud.setRadiusPerTick((7.0F-entityareaeffectcloud.getRadius())/(float)entityareaeffectcloud.getDuration());
                entityareaeffectcloud.addEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE, 1, 1));
                entityareaeffectcloud.setPosition(pos.getX(), pos.getY(), pos.getZ());
                world.playEvent(2006, pos, 0);
                world.spawnEntity(entityareaeffectcloud);
				cloudAreas.remove(pos);
				effectRadius.remove(radius);
			}
			if (!cloudAreasL.isEmpty() && !effectRadiusL.isEmpty()) {
				BlockPos pos = cloudAreasL.get(0);
				float radius = effectRadiusL.get(0);
				EntityAreaEffectCloud entityareaeffectcloud = new EntityAreaEffectCloud(world, pos.getX(), pos.getY(), pos.getZ());
                entityareaeffectcloud.setOwner(null);
                entityareaeffectcloud.setParticle(EnumParticleTypes.DRAGON_BREATH);
                entityareaeffectcloud.setRadius(radius);
                entityareaeffectcloud.setDuration(1800);
//                entityareaeffectcloud.setRadiusPerTick((7.0F-entityareaeffectcloud.getRadius())/(float)entityareaeffectcloud.getDuration());
                entityareaeffectcloud.addEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE, 1, 3));
                entityareaeffectcloud.addEffect(new PotionEffect(MobEffects.POISON, 300, 9));
                entityareaeffectcloud.setPosition(pos.getX(), pos.getY(), pos.getZ());
                world.playEvent(2006, pos, 0);
                world.spawnEntity(entityareaeffectcloud);
				cloudAreasL.remove(pos);
				effectRadiusL.remove(radius);
			}
			int trigger = 0;
			for (int i = 0; i < 2; i++) {
				if (!sphereExplosionList.isEmpty()) {
					for (int s = sphereExplosionList.size()-1; s >= 0; s--) {
						SphereExplosion sphereExplosion = sphereExplosionList.get(s);
						if (sphereExplosion.currentLayer <= sphereExplosion.radius) {
							System.out.println(sphereExplosion.currentLayer);
							SpherePoints points = new SpherePoints();
							for (BlockPos pos : points.getPointsOnSphere(sphereExplosion.center, sphereExplosion.currentLayer)) {
								if (world.getBlockState(pos) != Blocks.BEDROCK.getDefaultState()) {
									world.setBlockToAir(pos);
									if (sphereExplosion.currentLayer%2 == 0) {
										if (sphereExplosion.currentLayer == sphereExplosion.radius) {
											if (trigger%15 == 0) {
												world.newExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 20, true, true);
												for (int l = 0; l < 2; l++) {
													EntityLightningBolt bolt = new EntityLightningBolt(world, pos.getX(), pos.getY(), pos.getZ(), false);
													bolt.setPosition(pos.getX(), pos.getY(), pos.getZ());
													world.spawnEntity(bolt);
													world.addWeatherEffect(bolt);
												}
											}
										}
										else if (sphereExplosion.currentLayer <= 4) {
											if (trigger%7 == 0) world.newExplosion(null, pos.getX(), pos.getY(), pos.getZ(), sphereExplosion.radius, true, true);
											if (trigger%4 == 0) {
												for (int l = 0; l < 2; l++) {
													EntityLightningBolt bolt = new EntityLightningBolt(world, pos.getX(), pos.getY(), pos.getZ(), false);
													bolt.setPosition(pos.getX(), pos.getY(), pos.getZ());
													world.spawnEntity(bolt);
													world.addWeatherEffect(bolt);
												}
											}
										}
										else {
											if (trigger%12 == 0) world.newExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 3, true, false);
											if (trigger%9 == 0) {
												for (int l = 0; l < 2; l++) {
													EntityLightningBolt bolt = new EntityLightningBolt(world, pos.getX(), pos.getY(), pos.getZ(), false);
													bolt.setPosition(pos.getX(), pos.getY(), pos.getZ());
													world.spawnEntity(bolt);
													world.addWeatherEffect(bolt);
												}
											}
										}
									}
									trigger++;
								}
							}
//							world.newExplosion(null, sphereExplosion.center.getX(), sphereExplosion.center.getY(), sphereExplosion.center.getZ(), sphereExplosion.currentLayer, true, true);
							sphereExplosion.currentLayer++;
						}
						else {
							sphereExplosionList.remove(sphereExplosion);
							world.newExplosion(
								null, sphereExplosion.center.getX(), sphereExplosion.center.getY(), sphereExplosion.center.getZ(), 
								sphereExplosion.currentLayer, true, true
							);
						}
					}
				}
			}
//			}
		}
	}
//	@SubscribeEvent
//	public void ItemUseTickEvents(LivingEntityUseItemEvent.Tick event) {
//		if (event.getItem().getItem() instanceof LegendGodSword) {
//			System.out.println("Event1: "+event.getDuration()+", "+event.getItem());
////			System.out.println("Event2: "+event.getResult()+", "+event.getPhase());
////			NBTTagCompound nbt = event.getItem().getTagCompound();
//			CustomGui.renderCustomSwordHighlight(event.getItem(), event.getItem().getTagCompound().getInteger("max_usage_time")-event.getDuration());
////			event.getItem().getTagCompound().setInteger("usage_time", nbt.getInteger("usage_time")+1);
//		}
//	}
	@SubscribeEvent
	public void CustomHotbarRenderEvents(RenderGameOverlayEvent.Post event) 
	{
		EntityPlayer player = Minecraft.getMinecraft().player;
		if (event.getType() == ElementType.HOTBAR) 
		{
			if (player.isHandActive()) 
			{
				ItemStack item = player.getActiveItemStack();
				if (item.getItem() instanceof LegendDestructionSword || item.getItem() instanceof LegendGodSword || 
					item.getItem() instanceof LegendRadiantSword || item.getItem() instanceof LegendMysticalSword) 
				{
					CustomGui.renderCustomSwordHighlight(item);
				}
			}
//			else if (player.getSwingProgress(event.getPartialTicks()) != 0) 
//			{
//				ItemStack item = player.getHeldItemMainhand();
//				if (item.getItem() instanceof LegendGodSword)
//				{
//					CustomGui.renderCustomSwordHighlight(item);
//				}
//			}
		}
	}
//	@SubscribeEvent
//	public void CustomTooltipRenderEvents1(RenderTooltipEvent.Pre event) {
//		System.out.println("rendered tooltip pre");
//	}
//	@SubscribeEvent
//	public void CustomTooltipRenderEvents2(RenderTooltipEvent.PostBackground event) {
//		System.out.println("rendered tooltip back");
//	}
//	@SubscribeEvent
//	public void CustomTooltipRenderEvents3(RenderTooltipEvent.PostText event) {
//		System.out.println("rendered tooltip text");
//	}
	
	@SubscribeEvent
	public void PlayerCritEvents(CriticalHitEvent event) {
		
	}
	@SubscribeEvent
	public void PlayerTickEvents(TickEvent.PlayerTickEvent event) {
		EntityPlayer player = event.player;
		World world = player.getEntityWorld();
		time4 = System.currentTimeMillis();
		Iterable<ItemStack> armor = player.getArmorInventoryList();
//		NBTTagCompound playerData = player.getEntityData();
//		int i = 0;
//		float k = 0;
		for (ItemStack piece : armor) {
			if (piece.getItem() instanceof CustomArmor) {
				player.resetCooldown();
			}
			else if (piece.getItem() instanceof GodArmor) {
				player.capabilities.allowFlying = true;
				player.capabilities.writeCapabilitiesToNBT(player.getEntityData());
				player.resetCooldown();
			}
			else if (piece.getItem() instanceof DestructionArmor) {
				player.capabilities.allowFlying = true;
				player.capabilities.writeCapabilitiesToNBT(player.getEntityData());
				player.resetCooldown();
			}
		}
		for (ItemStack stack:player.inventory.mainInventory) {
			if (stack.getItem() instanceof GodlyPotionOrb) {
				player.capabilities.allowFlying = true;
				player.capabilities.writeCapabilitiesToNBT(player.getEntityData());
				player.resetCooldown();
			}
		}
		for (ItemStack stack:player.inventory.offHandInventory) {
			if (stack.getItem() instanceof GodlyPotionOrb) {
				player.capabilities.allowFlying = true;
				player.capabilities.writeCapabilitiesToNBT(player.getEntityData());
				player.resetCooldown();
			}
		}
		if (curseKills.get(player) == true && player.isDead == false) {
			curseKills.replace(player, false);
			doomTimers.put(player, System.currentTimeMillis());
			for (ItemStack itemstack:armor) {
				if (EnchantmentHelper.getEnchantmentLevel(Main.curseOfCertainDeathEnchant, itemstack) > 0) {
					Map<Enchantment, Integer> ench = EnchantmentHelper.getEnchantments(itemstack);
					ench.remove(Main.curseOfCertainDeathEnchant);
					EnchantmentHelper.setEnchantments(ench, itemstack);
				}
				if (EnchantmentHelper.getEnchantmentLevel(Enchantments.BINDING_CURSE, itemstack) > 0) {
					Map<Enchantment, Integer> ench = EnchantmentHelper.getEnchantments(itemstack);
					ench.remove(Enchantments.BINDING_CURSE);
					EnchantmentHelper.setEnchantments(ench, itemstack);
				}
			}
		}
		ItemStack item = EnchantmentHelper.getEnchantedItem(Main.shieldEnchant, player);
		shieldCheck(item, false, player);
		if (player.getHealth() < prevHealths.get(player)) {
			shieldCheck(item, true, player);
		}
		prevHealths.put(player, player.getHealth());
		if (checkDeathCurse(player) == false) {
			doomTimers.put(player, System.currentTimeMillis());
		}
		if (player.isDead == false) {
			for (ItemStack itemstack:armor) {
				int deathLevel = EnchantmentHelper.getEnchantmentLevel(Main.curseOfCertainDeathEnchant, itemstack);
				if (deathLevel > 0) {
					if (EnchantmentHelper.getEnchantmentLevel(Enchantments.BINDING_CURSE, itemstack) < 1) {
						itemstack.addEnchantment(Enchantments.BINDING_CURSE, 1);
					}
					long timePassed = doomTimers.get(player);
					if (System.currentTimeMillis()-timePassed >= 600000) {
						player.onKillCommand();
						curseKills.put(player, true);
					}
				}
			}
		}
	}
	
	private void shieldCheck(ItemStack item, boolean damaged, EntityPlayer player) {
		if (item.getItem().isValidArmor(item, EntityEquipmentSlot.CHEST, player)) {
			int shieldLevel = EnchantmentHelper.getEnchantmentLevel(Main.shieldEnchant, item);
			int shieldStacks = playerShields.get(player);
			long shieldTime = shieldCooldowns.get(player);
			if (shieldLevel > 0) {
				if (!damaged) {
					if (shieldStacks < shieldLevel && (System.currentTimeMillis()-shieldTime) >= (150000/shieldLevel)) {
						playerShields.put(player, shieldStacks+1);
						ITextComponent text = (ITextComponent) new TextComponentString("Shield Recharged: "+(shieldStacks+1)+"/"+shieldLevel+" Charged");
						player.sendMessage(text);
						shieldCooldowns.put(player, System.currentTimeMillis());
					}
					else if (shieldStacks >= shieldLevel) {
						playerShields.put(player, shieldLevel);
						shieldCooldowns.put(player, System.currentTimeMillis());
					}
				}
				else {
					if (shieldStacks > 0) {
						player.setHealth(prevHealths.get(player));
						playerShields.put(player, shieldStacks-1);
						ITextComponent text = (ITextComponent) new TextComponentString("Shield Recharged: "+(shieldStacks-1)+"/"+shieldLevel+" Charged");
						player.sendMessage(text);
					}
				}
			}
			else {
				playerShields.put(player, 0);
				shieldCooldowns.put(player, System.currentTimeMillis());
			}
		}
	}
	
	private boolean checkDeathCurse(EntityPlayer player) {
		for (ItemStack armor:player.getArmorInventoryList()) {
			if (EnchantmentHelper.getEnchantmentLevel(Main.curseOfCertainDeathEnchant, armor) > 0) {
				return true;
			}
		}
		return false;
	}
}
