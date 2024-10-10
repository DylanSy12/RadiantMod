package mymod.CodakidFiles;

import mymod.Main;
import mymod._07_BuildAndBoom.EntityBuildGrenade;
import mymod._07_BuildAndBoom.EntityGodBuildGrenade;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGodGrenadeBuild extends Render<EntityGodBuildGrenade>
{
    private static ResourceLocation godGrenadeTexture = new ResourceLocation(
			Main.MODID, "items/god_build_grenade.png");
    
    public static ItemStack godGrenadeStack = ItemStack.EMPTY;
    
    public static final IRenderFactory FACTORY = new FactoryGBG();

    public RenderGodGrenadeBuild(RenderManager renderManagerIn) {
    	super(renderManagerIn);
	}

	/**
     * Renders the desired {@code T} type Entity.
     */
    public void doRender(EntityGodBuildGrenade entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.enableRescaleNormal();
        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate((float)(this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
        this.bindEntityTexture(entity);

        if (this.renderOutlines)
        {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(entity));
        }

        Minecraft.getMinecraft().getRenderItem().renderItem(godGrenadeStack, ItemCameraTransforms.TransformType.GROUND);

        if (this.renderOutlines)
        {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }

        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    public ItemStack getStackToRender(EntityGodBuildGrenade entityIn)
    {
        return godGrenadeStack;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
	protected ResourceLocation getEntityTexture(EntityGodBuildGrenade entity) {
		return godGrenadeTexture;
	}
    
	public static class FactoryGBG implements IRenderFactory<EntityGodBuildGrenade> {
		
		public void setGodGrenade(Item godGrenade) {
			godGrenadeStack = new ItemStack(godGrenade);
		}

        @Override
        public Render<? super EntityGodBuildGrenade> createRenderFor(RenderManager manager) {
            return new RenderGodGrenadeBuild(manager);
        }

    }
}
