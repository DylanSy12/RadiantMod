package mymod.CodakidFiles;

import mymod.Main;
import mymod._07_BuildAndBoom.EntityBuildGrenade;
import mymod._07_BuildAndBoom.EntityGodBuildGrenade;
import mymod._07_BuildAndBoom.EntityGodEraserGrenade;
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
public class RenderGodGrenadeEraser extends Render<EntityGodEraserGrenade>
{
    private static ResourceLocation godEraserGrenadeTexture = new ResourceLocation(
			Main.MODID, "items/god_eraser_grenade.png");
    
    public static ItemStack godEraserGrenadeStack = ItemStack.EMPTY;
    
    public static final IRenderFactory FACTORY = new FactoryGEG();

    public RenderGodGrenadeEraser(RenderManager renderManagerIn) {
    	super(renderManagerIn);
	}

	/**
     * Renders the desired {@code T} type Entity.
     */
    public void doRender(EntityGodEraserGrenade entity, double x, double y, double z, float entityYaw, float partialTicks)
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

        Minecraft.getMinecraft().getRenderItem().renderItem(godEraserGrenadeStack, ItemCameraTransforms.TransformType.GROUND);

        if (this.renderOutlines)
        {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }

        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    public ItemStack getStackToRender(EntityGodEraserGrenade entityIn)
    {
        return godEraserGrenadeStack;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
	protected ResourceLocation getEntityTexture(EntityGodEraserGrenade entity) {
		return godEraserGrenadeTexture;
	}
    
	public static class FactoryGEG implements IRenderFactory<EntityGodEraserGrenade> {
		
		public void setGodGrenade(Item godEraserGrenade) {
			godEraserGrenadeStack = new ItemStack(godEraserGrenade);
		}

        @Override
        public Render<? super EntityGodEraserGrenade> createRenderFor(RenderManager manager) {
            return new RenderGodGrenadeEraser(manager);
        }

    }
}
