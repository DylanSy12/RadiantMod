package mymod.CodakidFiles;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraftforge.fml.relauncher.SideOnly;
import mymod.Main;
import mymod._01_ForgeYourSword.RadiantLord;
import mymod._04_CreateACreature.GodLord;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderRadiantLord extends RenderBiped<RadiantLord> {

	private static final ResourceLocation radiantLordTexture = new ResourceLocation(
//			Main.MODID, "mobs/biped_texture.png");
			Main.MODID, "mobs/radiant_lord_texture.png");
	
	public static final Factory FACTORY = new Factory();
	
	public RenderRadiantLord(RenderManager renderManager) {
//		super(renderManager, new BossModelBiped(), 0.5f);
		super(renderManager, new ModelBiped(0.0f, 0.0F, 64, 64), 0.5f);
		this.addLayer(new LayerHeldItem(this));
        this.addLayer(new LayerBipedArmor(this)
        {
            protected void initArmor()
            {
                this.modelLeggings = new ModelBiped(0.5F);
                this.modelArmor = new ModelBiped(1.0F);
            }
        });
	}
	

//	public void func_177_a(CustomMonster entity, double d, double d1, double d2,
//			float f, float f1) {
//		super.doRender(entity, d, d1, d2, f, f1);
//	}
//
//	public void doRenderLiving(EntityLiving entityliving, double d, double d1,
//			double d2, float f, float f1) {
//		func_177_a((CustomMonster) entityliving, d, d1, d2, f, f1);
//	}
//
//	public void doRender(Entity entity, double d, double d1, double d2,
//			float f, float f1) {
//		func_177_a((CustomMonster) entity, d, d1, d2, f, f1);
//	}
//
//	protected ResourceLocation func_110872_a(CustomMonster par1Entity) {
//		return bipedTexture;
//	}
//
//	protected ResourceLocation getEntityTexture(Entity var1) {
//		return func_110872_a((CustomMonster) var1);
//	}
	
	public static class Factory implements IRenderFactory<RadiantLord> {

        @Override
        public Render<? super RadiantLord> createRenderFor(RenderManager manager) {
            return new RenderRadiantLord(manager);
        }

    }
	
	protected ResourceLocation getEntityTexture(RadiantLord entity)
    {
        return radiantLordTexture;
    }
}