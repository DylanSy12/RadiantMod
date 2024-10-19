package mymod.CodakidFiles;

import mymod.Main;
import mymod._05_LuckyBlock.Nuke;
import mymod._05_LuckyBlock.EntityNuke;
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
public class RenderRadiantGrenade extends Render<EntityRadiantGrenade>
{   
	private static final ResourceLocation radiantGrenadeTexture = new ResourceLocation(
			Main.MODID, "items/radiant_grenade.png");

	
	public static final IRenderFactory FACTORY = new FactoryRG();
	   
	public static ItemStack radiantGrenadeStack = ItemStack.EMPTY;
	
	public RenderRadiantGrenade(RenderManager renderManager)
    {
        super(renderManager);
    }

    @Override
    public void doRender(EntityRadiantGrenade radiantGrenade, double x, double y, double z, float entityYaw, float partialTicks)
    {
        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, z);
        GlStateManager.enableRescaleNormal();
        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate((float)(this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
        this.bindEntityTexture(radiantGrenade);
 
        if (this.renderOutlines)
        {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(radiantGrenade));
        }
 
        Minecraft.getMinecraft().getRenderItem().renderItem(radiantGrenadeStack, ItemCameraTransforms.TransformType.GROUND);
 
        if (this.renderOutlines)
        {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
 
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(radiantGrenade, x, y, z, entityYaw, partialTicks);
    }
	
	@Override
	protected ResourceLocation getEntityTexture(EntityRadiantGrenade radiantGrenade) {
		return radiantGrenadeTexture; 
	}
	
	public static class FactoryRG implements IRenderFactory<EntityRadiantGrenade> {
		
		public void setRadiantGrenade(Item radiantGrenade) {
			radiantGrenadeStack = new ItemStack(radiantGrenade);
		}
		
        @Override
        public Render<? super EntityRadiantGrenade> createRenderFor(RenderManager manager) {
            return new RenderRadiantGrenade(manager);
        }
	}

}
