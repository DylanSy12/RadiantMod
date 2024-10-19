package mymod.CodakidFiles;

import mymod.Main;
import mymod._07_BuildAndBoom.EntityRadiantClusterGrenadeFragment;
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
public class RenderRadiantClusterGrenadeFragment extends Render<EntityRadiantClusterGrenadeFragment>
{
    //protected final Item item;
    //private final RenderItem itemRenderer;
    private static final ResourceLocation radiantClusterGrenadeFragmentTexture = new ResourceLocation(
    		Main.MODID, "items/radiant_cluster_grenade.png");
    
    public static ItemStack radiantClusterGrenadeFragmentStack = ItemStack.EMPTY;
    
    public static final IRenderFactory FACTORY = new FactoryRCGF();

    public RenderRadiantClusterGrenadeFragment(RenderManager renderManagerIn) {
    	super(renderManagerIn);
	}

	/**
     * Renders the desired {@code T} type Entity.
     */
    public void doRender(EntityRadiantClusterGrenadeFragment radiantClusterGrenadeFragment, double x, double y, double z, float entityYaw, float partialTicks)
    {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.enableRescaleNormal();
        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate((float)(this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
        this.bindEntityTexture(radiantClusterGrenadeFragment);

        if (this.renderOutlines)
        {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(radiantClusterGrenadeFragment));
        }

        Minecraft.getMinecraft().getRenderItem().renderItem(radiantClusterGrenadeFragmentStack, ItemCameraTransforms.TransformType.GROUND);

        if (this.renderOutlines)
        {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }

        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(radiantClusterGrenadeFragment, x, y, z, entityYaw, partialTicks);
    }

    public ItemStack getStackToRender(EntityRadiantClusterGrenadeFragment radiantClusterGrenadeFragment)
    {
        return radiantClusterGrenadeFragmentStack;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityRadiantClusterGrenadeFragment radiantClusterGrenadeFragment)
    {
        return radiantClusterGrenadeFragmentTexture;
    }
    
	public static class FactoryRCGF implements IRenderFactory<EntityRadiantClusterGrenadeFragment> {

		public void setRadiantClusterGrenadeFragment(Item radiantClusterGrenadeFragment) {
			radiantClusterGrenadeFragmentStack = new ItemStack(radiantClusterGrenadeFragment);
		}
		
        @Override
        public Render<? super EntityRadiantClusterGrenadeFragment> createRenderFor(RenderManager manager) {
            return new RenderRadiantClusterGrenadeFragment(manager);
        }

    }
}