package mymod.CodakidFiles;

import mymod.Main;
import mymod._05_LuckyBlock.CustomNuke;
import mymod._05_LuckyBlock.EntityNuke;
import mymod._07_BuildAndBoom.EntityCustomExplosion;
import mymod._07_BuildAndBoom.EntityGrenade;
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
public class RenderCustomExplosion extends Render<EntityCustomExplosion>
{   
	
	private static final ResourceLocation explosionTexture = new ResourceLocation(
			Main.MODID, "items/custom_explosion.png");
	
	public static final IRenderFactory FACTORY = new FactoryCE();
	   

    public static ItemStack explosionStack = ItemStack.EMPTY;
	
	
	public RenderCustomExplosion(RenderManager renderManager)
	{
		super(renderManager);
	}

    @Override
    public void doRender(EntityCustomExplosion entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, z);
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
 
        Minecraft.getMinecraft().getRenderItem().renderItem(explosionStack, ItemCameraTransforms.TransformType.GROUND);
 
        if (this.renderOutlines)
        {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
 
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
	
	protected ResourceLocation getEntityTexture(EntityCustomExplosion entity) {
    	return explosionTexture;
    }
    
    public static class FactoryCE implements IRenderFactory<EntityCustomExplosion> {
		
    	public void setExplosion(Item explosion) {
    		explosionStack = new ItemStack(explosion);
			// TODO Auto-generated method stub
			
		}

		@Override
		public Render<? super EntityCustomExplosion> createRenderFor(RenderManager manager) {
			// TODO Auto-generated method stub
			return new RenderCustomExplosion(manager);
		}

    }
}

