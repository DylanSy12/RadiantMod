package mymod.CodakidFiles;

import mymod.Main;
import mymod._07_BuildAndBoom.EntityRadiantClusterGrenade;
import mymod._07_BuildAndBoom.EntityGodClusterGrenade;
import mymod._07_BuildAndBoom.EntityDestructionClusterGrenade;
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
public class RenderDestructionClusterGrenade extends Render<EntityDestructionClusterGrenade>
{
    private static final ResourceLocation destructionClusterGrenadeTexture = new ResourceLocation(
			Main.MODID, "items/destruction_cluster_grenade.png");
    
    public static ItemStack destructionClusterGrenadeStack = ItemStack.EMPTY;
    
    public static final IRenderFactory FACTORY = new FactoryDCG();

    public RenderDestructionClusterGrenade(RenderManager renderManagerIn) {
    	super(renderManagerIn);
	}

	/**
     * Renders the desired {@code T} type Entity.
     */
    public void doRender(EntityDestructionClusterGrenade destructionClusterGrenade, double x, double y, double z, float entityYaw, float partialTicks)
    {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.enableRescaleNormal();
        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate((float)(this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
        this.bindEntityTexture(destructionClusterGrenade);

        if (this.renderOutlines)
        {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(destructionClusterGrenade));
        }

        Minecraft.getMinecraft().getRenderItem().renderItem(destructionClusterGrenadeStack, ItemCameraTransforms.TransformType.GROUND);

        if (this.renderOutlines)
        {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }

        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(destructionClusterGrenade, x, y, z, entityYaw, partialTicks);
    }

    public ItemStack getStackToRender(EntityDestructionClusterGrenade destructionClusterGrenade)
    {
        return destructionClusterGrenadeStack;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityDestructionClusterGrenade destructionClusterGrenade)
    {
        return destructionClusterGrenadeTexture;
    }
    
	public static class FactoryDCG implements IRenderFactory<EntityDestructionClusterGrenade> {
		
		public void setDestructionClusterGrenade(Item destructionClusterGrenade) {
			destructionClusterGrenadeStack = new ItemStack(destructionClusterGrenade);
		}
		
        @Override
        public Render<? super EntityDestructionClusterGrenade> createRenderFor(RenderManager manager) {
            return new RenderDestructionClusterGrenade(manager);
        }

    }
}