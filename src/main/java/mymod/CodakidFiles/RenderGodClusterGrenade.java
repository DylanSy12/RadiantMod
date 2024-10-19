package mymod.CodakidFiles;

import mymod.Main;
import mymod._07_BuildAndBoom.EntityRadiantClusterGrenade;
import mymod._07_BuildAndBoom.EntityGodClusterGrenade;
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
public class RenderGodClusterGrenade extends Render<EntityGodClusterGrenade>
{
    private static final ResourceLocation godClusterGrenadeTexture = new ResourceLocation(
			Main.MODID, "items/god_cluster_grenade.png");
    
    public static ItemStack godClusterGrenadeStack = ItemStack.EMPTY;
    
    public static final IRenderFactory FACTORY = new FactoryGCG();

    public RenderGodClusterGrenade(RenderManager renderManagerIn) {
    	super(renderManagerIn);
	}

	/**
     * Renders the desired {@code T} type Entity.
     */
    public void doRender(EntityGodClusterGrenade godClusterGrenade, double x, double y, double z, float entityYaw, float partialTicks)
    {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.enableRescaleNormal();
        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate((float)(this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
        this.bindEntityTexture(godClusterGrenade);

        if (this.renderOutlines)
        {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(godClusterGrenade));
        }

        Minecraft.getMinecraft().getRenderItem().renderItem(godClusterGrenadeStack, ItemCameraTransforms.TransformType.GROUND);

        if (this.renderOutlines)
        {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }

        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(godClusterGrenade, x, y, z, entityYaw, partialTicks);
    }

    public ItemStack getStackToRender(EntityGodClusterGrenade godClusterGrenade)
    {
        return godClusterGrenadeStack;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityGodClusterGrenade godClusterGrenade)
    {
        return godClusterGrenadeTexture;
    }
    
	public static class FactoryGCG implements IRenderFactory<EntityGodClusterGrenade> {
		
		public void setGodClusterGrenade(Item godClusterGrenade) {
			godClusterGrenadeStack = new ItemStack(godClusterGrenade);
		}
		
        @Override
        public Render<? super EntityGodClusterGrenade> createRenderFor(RenderManager manager) {
            return new RenderGodClusterGrenade(manager);
        }

    }
}