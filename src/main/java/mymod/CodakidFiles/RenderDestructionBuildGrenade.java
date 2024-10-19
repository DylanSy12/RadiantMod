package mymod.CodakidFiles;

import mymod.Main;
import mymod._07_BuildAndBoom.EntityRadiantBuildGrenade;
import mymod._07_BuildAndBoom.EntityGodBuildGrenade;
import mymod._07_BuildAndBoom.EntityGodEraserGrenade;
import mymod._07_BuildAndBoom.EntityDestructionBuildGrenade;
import mymod._07_BuildAndBoom.EntityDestructionEraserGrenade;
import mymod._07_BuildAndBoom.EntityDestructionTNTGrenade;
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
public class RenderDestructionBuildGrenade extends Render<EntityDestructionBuildGrenade>
{
    private static ResourceLocation destructionBuildGrenadeTexture = new ResourceLocation(
			Main.MODID, "items/destruction_build_grenade.png");
    
    public static ItemStack destructionBuildGrenadeStack = ItemStack.EMPTY;
    
    public static final IRenderFactory FACTORY = new FactoryDBG();

    public RenderDestructionBuildGrenade(RenderManager renderManagerIn) 
    {
    	super(renderManagerIn);
	}

	/**
     * Renders the desired {@code T} type Entity.
     */
    public void doRender(EntityDestructionBuildGrenade destructionBuildGrenade, double x, double y, double z, float entityYaw, float partialTicks)
    {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.enableRescaleNormal();
        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate((float)(this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
        this.bindEntityTexture(destructionBuildGrenade);

        if (this.renderOutlines)
        {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(destructionBuildGrenade));
        }

        Minecraft.getMinecraft().getRenderItem().renderItem(destructionBuildGrenadeStack, ItemCameraTransforms.TransformType.GROUND);

        if (this.renderOutlines)
        {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }

        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(destructionBuildGrenade, x, y, z, entityYaw, partialTicks);
    }

    public ItemStack getStackToRender(EntityDestructionBuildGrenade destructionBuildGrenade)
    {
        return destructionBuildGrenadeStack;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
	protected ResourceLocation getEntityTexture(EntityDestructionBuildGrenade destructionBuildGrenade) 
    {
		return destructionBuildGrenadeTexture;
	}
    
	public static class FactoryDBG implements IRenderFactory<EntityDestructionBuildGrenade> {
		
		public void setDestructionBuildGrenade(Item destructionBuildGrenade) {
			destructionBuildGrenadeStack = new ItemStack(destructionBuildGrenade);
		}

        @Override
        public Render<? super EntityDestructionBuildGrenade> createRenderFor(RenderManager manager) {
            return new RenderDestructionBuildGrenade(manager);
        }

    }
}
