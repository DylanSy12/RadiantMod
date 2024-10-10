package mymod.CodakidFiles;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BossModelBiped extends ModelBase
{
  //fields
    ModelRenderer head;
//    ModelRenderer headwear;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
//    ModelBiped.ArmPose leftArmPose;
//    ModelBiped.ArmPose rightArmPose;
  
  public BossModelBiped()
  {
	textureWidth = 128;
	textureHeight = 32;
//	leftArmPose = ModelBiped.ArmPose.EMPTY;
//	rightArmPose = ModelBiped.ArmPose.EMPTY;
	head = new ModelRenderer(this, 0, 0);
	head.addBox(-4F, -8F, -4F, 8, 8, 8);
	head.setRotationPoint(0F, 0F, 0F);
	head.setTextureSize(128, 32);
	head.mirror = true;
	setRotation(head, 0F, 0F, 0F);
//    headwear = new ModelRenderer(this, 32, 0);
//    headwear.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
//    headwear.setRotationPoint(0.0F, 0.0F, 0.0F);
	body = new ModelRenderer(this, 33, 0);
	body.addBox(-4F, 0F, -2F, 8, 12, 4);
	body.setRotationPoint(0F, 0F, 0F);
	body.setTextureSize(128, 32);
	body.mirror = true;
	setRotation(body, 0F, 0F, 0F);
	rightarm = new ModelRenderer(this, 34, 16);
	rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
	rightarm.setRotationPoint(-5F, 2F, 0F);
	rightarm.setTextureSize(128, 32);
	rightarm.mirror = true;
	setRotation(rightarm, 0F, 0F, 0F);
	leftarm = new ModelRenderer(this, 51, 16);
	leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
	leftarm.setRotationPoint(5F, 2F, 0F);
	leftarm.setTextureSize(128, 32);
	leftarm.mirror = true;
	setRotation(leftarm, 0F, 0F, 0F);
	rightleg = new ModelRenderer(this, 0, 16);
	rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
	rightleg.setRotationPoint(-2F, 12F, 0F);
	rightleg.setTextureSize(128, 32);
	rightleg.mirror = true;
	setRotation(rightleg, 0F, 0F, 0F);
	leftleg = new ModelRenderer(this, 17, 16);
	leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
	leftleg.setRotationPoint(2F, 12F, 0F);
	leftleg.setTextureSize(128, 32);
	leftleg.mirror = true;
	setRotation(leftleg, 0F, 0F, 0F);
  } 
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
//    headwear.render(f5);
    body.render(f5);
    rightarm.render(f5);
    leftarm.render(f5);
    rightleg.render(f5);
    leftleg.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
	  super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    
      this.leftleg.rotateAngleX = MathHelper.cos(f * .6662F) * 1.4F * f1;
      this.rightleg.rotateAngleX = MathHelper.cos(f * .6662F) * 1.4F * f1 * -1;
      this.leftarm.rotateAngleX = MathHelper.cos(f * .6662F) * 1.4F * f1;
      this.rightarm.rotateAngleX = MathHelper.cos(f * .6662F) * 1.4F * f1 * -1;
    
      this.head.rotateAngleY = f4 / (180F / (float)Math.PI);
      this.head.rotateAngleX = f5 / (180F / (float)Math.PI);
    
//      switch (this.leftArmPose)
//      {
//          case EMPTY:
//              this.leftarm.rotateAngleY = 0.0F;
//              break;
//          case BLOCK:
//              this.leftarm.rotateAngleX = this.leftarm.rotateAngleX * 0.5F - 0.9424779F;
//              this.leftarm.rotateAngleY = 0.5235988F;
//              break;
//          case ITEM:
//              this.leftarm.rotateAngleX = this.leftarm.rotateAngleX * 0.5F - ((float)Math.PI / 10F);
//              this.leftarm.rotateAngleY = 0.0F;
//      }
//
//      switch (this.rightArmPose)
//      {
//          case EMPTY:
//              this.rightarm.rotateAngleY = 0.0F;
//              break;
//          case BLOCK:
//              this.rightarm.rotateAngleX = this.rightarm.rotateAngleX * 0.5F - 0.9424779F;
//              this.rightarm.rotateAngleY = -0.5235988F;
//              break;
//          case ITEM:
//              this.rightarm.rotateAngleX = this.rightarm.rotateAngleX * 0.5F - ((float)Math.PI / 10F);
//              this.rightarm.rotateAngleY = 0.0F;
//      }
//
//      if (this.swingProgress > 0.0F)
//      {
//          EnumHandSide enumhandside = this.getMainHand(entity);
//          ModelRenderer modelrenderer = this.getArmForSide(enumhandside);
//          float s1 = this.swingProgress;
//          this.body.rotateAngleY = MathHelper.sin(MathHelper.sqrt(f1) * ((float)Math.PI * 2F)) * 0.2F;
//
//          if (enumhandside == EnumHandSide.LEFT)
//          {
//              this.body.rotateAngleY *= -1.0F;
//          }
//
//          this.rightarm.rotationPointZ = MathHelper.sin(this.body.rotateAngleY) * 5.0F;
//          this.rightarm.rotationPointX = -MathHelper.cos(this.body.rotateAngleY) * 5.0F;
//          this.leftarm.rotationPointZ = -MathHelper.sin(this.body.rotateAngleY) * 5.0F;
//          this.leftarm.rotationPointX = MathHelper.cos(this.body.rotateAngleY) * 5.0F;
//          this.rightarm.rotateAngleY += this.body.rotateAngleY;
//          this.leftarm.rotateAngleY += this.body.rotateAngleY;
//          this.leftarm.rotateAngleX += this.body.rotateAngleY;
//          s1 = 1.0F - this.swingProgress;
//          s1 = s1 * s1;
//          s1 = s1 * s1;
//          s1 = 1.0F - s1;
//          float s2 = MathHelper.sin(s1 * (float)Math.PI);
//          float s3 = MathHelper.sin(this.swingProgress * (float)Math.PI) * -(this.head.rotateAngleX - 0.7F) * 0.75F;
//          modelrenderer.rotateAngleX = (float)((double)modelrenderer.rotateAngleX - ((double)s2 * 1.2D + (double)s3));
//          modelrenderer.rotateAngleY += this.body.rotateAngleY * 2.0F;
//          modelrenderer.rotateAngleZ += MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F;
//      }
//      copyModelAngles(this.bipedHead, this.bipedHeadwear);
  }
  
  protected ModelRenderer getArmForSide(EnumHandSide side)
  {
      return side == EnumHandSide.LEFT ? this.leftarm : this.rightarm;
  }

  protected EnumHandSide getMainHand(Entity entityIn)
  {
      if (entityIn instanceof EntityLivingBase)
      {
          EntityLivingBase entitylivingbase = (EntityLivingBase)entityIn;
          EnumHandSide enumhandside = entitylivingbase.getPrimaryHand();
          return entitylivingbase.swingingHand == EnumHand.MAIN_HAND ? enumhandside : enumhandside.opposite();
      }
      else
      {
          return EnumHandSide.RIGHT;
      }
  }

  @SideOnly(Side.CLIENT)
  public static enum ArmPose
  {
      EMPTY,
      ITEM,
      BLOCK,
      BOW_AND_ARROW;
  }

}
