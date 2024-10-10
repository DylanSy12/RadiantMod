package mymod._04_CreateACreature;

import mymod.Main;
import mymod.CodakidFiles.BossModelBiped;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderBiped;
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
public class RenderGodLord extends RenderBiped<GodLord> {

	private static final ResourceLocation mobTexture = new ResourceLocation(
//			Main.MODID, "mobs/god_biped_texture.png");
			Main.MODID, "mobs/god_lord_texture.png");
	
	public static final Factory FACTORY = new Factory();

	public RenderGodLord(RenderManager renderManager) {
		// erase null and add your model
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

//	public void func_177_a(GodMonster entity, double d, double d1, double d2,
//			float f, float f1) {
//		super.doRender(entity, d, d1, d2, f, f1);
//	}
//
//	public void doRenderLiving(EntityLiving entityliving, double d, double d1,
//			double d2, float f, float f1) {
//		func_177_a((GodMonster) entityliving, d, d1, d2, f, f1);
//	}
//
//	public void doRender(Entity entity, double d, double d1, double d2,
//			float f, float f1) {
//		func_177_a((GodMonster) entity, d, d1, d2, f, f1);
//	}
//
//	protected ResourceLocation func_110872_a(EntityLiving par1Entity) {
//		return mobTexture;
//	}
//
//	protected ResourceLocation getEntityTexture(Entity var1) {
//		return func_110872_a((EntityLiving)var1);
//	}
	
	public static class Factory implements IRenderFactory<GodLord> {

        @Override
        public Render<? super GodLord> createRenderFor(RenderManager manager) {
            return new RenderGodLord(manager);
        }

    }
	protected ResourceLocation getEntityTexture(GodLord entity)
    {
        return mobTexture;
    }
}
