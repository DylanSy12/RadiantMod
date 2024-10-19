package mymod.CodakidFiles;

import mymod.Main;
import mymod._07_BuildAndBoom.EntityRadiantClusterGrenade;
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
public class RenderRadiantClusterGrenade extends Render<EntityRadiantClusterGrenade>
{
    private static final ResourceLocation radiantClusterGrenadeTexture = new ResourceLocation(
			Main.MODID, "items/radiant_cluster_grenade.png");
    
    public static ItemStack radiantClusterGrenadeStack = ItemStack.EMPTY;
    
    public static final IRenderFactory FACTORY = new FactoryRCG();

    public RenderRadiantClusterGrenade(RenderManager renderManagerIn) {
    	super(renderManagerIn);
	}

	/**
     * Renders the desired {@code T} type Entity.
     */
    public void doRender(EntityRadiantClusterGrenade radiantClusterGrenade, double x, double y, double z, float entityYaw, float partialTicks)
    {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.enableRescaleNormal();
        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate((float)(this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
        this.bindEntityTexture(radiantClusterGrenade);

        if (this.renderOutlines)
        {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(radiantClusterGrenade));
        }

        Minecraft.getMinecraft().getRenderItem().renderItem(radiantClusterGrenadeStack, ItemCameraTransforms.TransformType.GROUND);

        if (this.renderOutlines)
        {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }

        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(radiantClusterGrenade, x, y, z, entityYaw, partialTicks);
    }

    public ItemStack getStackToRender(EntityRadiantClusterGrenade radiantClusterGrenade)
    {
        return radiantClusterGrenadeStack;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityRadiantClusterGrenade radiantClusterGrenade)
    {
        return radiantClusterGrenadeTexture;
    }
    
	public static class FactoryRCG implements IRenderFactory<EntityRadiantClusterGrenade> {
		
		public void setRadiantClusterGrenade(Item radiantClusterGrenade) {
			radiantClusterGrenadeStack = new ItemStack(radiantClusterGrenade);
		}
		
        @Override
        public Render<? super EntityRadiantClusterGrenade> createRenderFor(RenderManager manager) {
            return new RenderRadiantClusterGrenade(manager);
        }

    }
}