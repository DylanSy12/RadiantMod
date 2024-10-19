package mymod.CodakidFiles;

import mymod.Main;
import mymod._05_LuckyBlock.Nuke;
import mymod._05_LuckyBlock.EntityNuke;
import mymod._07_BuildAndBoom.EntityRadiantBuildGrenade;
import mymod._07_BuildAndBoom.EntityRadiantGrenade;
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
public class RenderNuke extends Render<EntityNuke>
{   
	
	private static final ResourceLocation nukeTexture = new ResourceLocation(
			Main.MODID, "items/nuke.png");
	
	public static final IRenderFactory FACTORY = new FactoryN();
	   

    public static ItemStack nukeStack = ItemStack.EMPTY;
	
	
	public RenderNuke(RenderManager renderManager)
	{
		super(renderManager);
	}

    @Override
    public void doRender(EntityNuke nuke, double x, double y, double z, float entityYaw, float partialTicks)
    {
        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, z);
        GlStateManager.enableRescaleNormal();
        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate((float)(this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
        this.bindEntityTexture(nuke);
 
        if (this.renderOutlines)
        {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(nuke));
        }
 
        Minecraft.getMinecraft().getRenderItem().renderItem(nukeStack, ItemCameraTransforms.TransformType.GROUND);
 
        if (this.renderOutlines)
        {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
 
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(nuke, x, y, z, entityYaw, partialTicks);
    }

    public ItemStack getStackToRender(EntityNuke nuke)
    {
        return nukeStack;
    }
	
	protected ResourceLocation getEntityTexture(EntityNuke nuke) {
    	return nukeTexture;
    }
    
    public static class FactoryN implements IRenderFactory<EntityNuke> {
		
    	public void setNuke(Item nuke) {
			nukeStack = new ItemStack(nuke);
		}

		@Override
		public Render<? super EntityNuke> createRenderFor(RenderManager manager) {
			return new RenderNuke(manager);
		}

    }
}

