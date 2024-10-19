package mymod.CodakidFiles;

import mymod.Main;
import mymod._07_BuildAndBoom.EntityRadiantBuildGrenade;
import mymod._07_BuildAndBoom.EntityMysticalEraserGrenade;
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
public class RenderMysticalEraserGrenade extends Render<EntityMysticalEraserGrenade>
{
    private static ResourceLocation mysticalEraserGrenadeTexture = new ResourceLocation(
			Main.MODID, "items/mystical_eraser_grenade.png");
    
    public static ItemStack mysticalEraserGrenadeStack = ItemStack.EMPTY;
    
    public static final IRenderFactory FACTORY = new FactoryMEG();

    public RenderMysticalEraserGrenade(RenderManager renderManagerIn) {
    	super(renderManagerIn);
	}

	/**
     * Renders the desired {@code T} type Entity.
     */
    public void doRender(EntityMysticalEraserGrenade mysticalEraserGrenade, double x, double y, double z, float entityYaw, float partialTicks)
    {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.enableRescaleNormal();
        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate((float)(this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
        this.bindEntityTexture(mysticalEraserGrenade);

        if (this.renderOutlines)
        {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(mysticalEraserGrenade));
        }

        Minecraft.getMinecraft().getRenderItem().renderItem(mysticalEraserGrenadeStack, ItemCameraTransforms.TransformType.GROUND);

        if (this.renderOutlines)
        {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }

        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(mysticalEraserGrenade, x, y, z, entityYaw, partialTicks);
    }

    public ItemStack getStackToRender(EntityMysticalEraserGrenade mysticalEraserGrenade)
    {
        return mysticalEraserGrenadeStack;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
	protected ResourceLocation getEntityTexture(EntityMysticalEraserGrenade mysticalEraserGrenade) {
		return mysticalEraserGrenadeTexture;
	}
    
	public static class FactoryMEG implements IRenderFactory<EntityMysticalEraserGrenade> {
		
		public void setMysticalEraserGrenade(Item mysticalEraserGrenade) {
			mysticalEraserGrenadeStack = new ItemStack(mysticalEraserGrenade);
		}

        @Override
        public Render<? super EntityMysticalEraserGrenade> createRenderFor(RenderManager manager) {
            return new RenderMysticalEraserGrenade(manager);
        }

    }
}
