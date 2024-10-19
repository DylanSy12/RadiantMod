package mymod.CodakidFiles;

import mymod.Main;
import mymod._07_BuildAndBoom.EntityRadiantBuildGrenade;
import mymod._07_BuildAndBoom.EntityGodBuildGrenade;
import mymod._07_BuildAndBoom.EntityGodEraserGrenade;
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
public class RenderWorldGrenadeErasing extends Render<EntityDestructionTNTGrenade>
{
    private static ResourceLocation worldErasingGrenadeTexture = new ResourceLocation(
			Main.MODID, "items/world_erasing_grenade.png");
    
    public static ItemStack worldErasingGrenadeStack = ItemStack.EMPTY;
    
    public static final IRenderFactory FACTORY = new FactoryDTG();

    public RenderWorldGrenadeErasing(RenderManager renderManagerIn) {
    	super(renderManagerIn);
	}

	/**
     * Renders the desired {@code T} type Entity.
     */
    public void doRender(EntityDestructionTNTGrenade entity, double x, double y, double z, float entityYaw, float partialTicks)
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

        Minecraft.getMinecraft().getRenderItem().renderItem(worldErasingGrenadeStack, ItemCameraTransforms.TransformType.GROUND);

        if (this.renderOutlines)
        {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }

        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    public ItemStack getStackToRender(EntityDestructionTNTGrenade entityIn)
    {
        return worldErasingGrenadeStack;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
	protected ResourceLocation getEntityTexture(EntityDestructionTNTGrenade entity) {
		return worldErasingGrenadeTexture;
	}
    
	public static class FactoryDTG implements IRenderFactory<EntityDestructionTNTGrenade> {
		
		public void setDestructionTNTGrenade(Item worldErasingGrenade) {
			worldErasingGrenadeStack = new ItemStack(worldErasingGrenade);
		}

        @Override
        public Render<? super EntityDestructionTNTGrenade> createRenderFor(RenderManager manager) {
            return new RenderWorldGrenadeErasing(manager);
        }

    }
}
