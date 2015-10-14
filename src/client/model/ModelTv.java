package client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTv extends ModelBase
{
	public static ModelTv instance = new ModelTv();

  //fields
    ModelRenderer Base1;
    ModelRenderer Base2;
    ModelRenderer Wall1;
    ModelRenderer Display1;
    ModelRenderer DisplayBorderUp;
    ModelRenderer DisplayBorderDown;
    ModelRenderer DisplayBorderLeft;
    ModelRenderer DisplayBorderRight;
    ModelRenderer ButternOn;
    ModelRenderer ButternOff;

  public ModelTv()
  {
    textureWidth = 128;
    textureHeight = 64;

      Base1 = new ModelRenderer(this, 0, 17);
      Base1.addBox(0F, 0F, 0F, 18, 1, 10);
      Base1.setRotationPoint(-9F, 23F, -5F);
      Base1.setTextureSize(128, 64);
      Base1.mirror = true;
      setRotation(Base1, 0F, 0F, 0F);
      Base2 = new ModelRenderer(this, 0, 8);
      Base2.addBox(0F, 0F, 0F, 12, 2, 6);
      Base2.setRotationPoint(-6F, 22F, -3F);
      Base2.setTextureSize(128, 64);
      Base2.mirror = true;
      setRotation(Base2, 0F, 0F, 0F);
      Wall1 = new ModelRenderer(this, 37, 6);
      Wall1.addBox(0F, 0F, 0F, 5, 9, 1);
      Wall1.setRotationPoint(-3F, 14F, 1F);
      Wall1.setTextureSize(128, 64);
      Wall1.mirror = true;
      setRotation(Wall1, 0F, 0F, 0F);
      Display1 = new ModelRenderer(this, 1, 42);
      Display1.addBox(0F, 0F, 0F, 36, 20, 1);
      Display1.setRotationPoint(-18F, -2F, 0F);
      Display1.setTextureSize(128, 64);
      Display1.mirror = true;
      setRotation(Display1, 0F, 0F, 0F);
      Display1.mirror = false;
      DisplayBorderUp = new ModelRenderer(this, 0, 29);
      DisplayBorderUp.addBox(0F, 0F, 0F, 40, 2, 1);
      DisplayBorderUp.setRotationPoint(-20F, -4F, -1F);
      DisplayBorderUp.setTextureSize(128, 64);
      DisplayBorderUp.mirror = true;
      setRotation(DisplayBorderUp, 0F, 0F, 0F);
      DisplayBorderDown = new ModelRenderer(this, 0, 33);
      DisplayBorderDown.addBox(0F, 0F, 0F, 40, 3, 1);
      DisplayBorderDown.setRotationPoint(-20F, 18F, -1F);
      DisplayBorderDown.setTextureSize(128, 64);
      DisplayBorderDown.mirror = true;
      setRotation(DisplayBorderDown, 0F, 0F, 0F);
      DisplayBorderLeft = new ModelRenderer(this, 76, 38);
      DisplayBorderLeft.addBox(0F, 0F, 0F, 2, 24, 1);
      DisplayBorderLeft.setRotationPoint(-20F, -4F, -1F);
      DisplayBorderLeft.setTextureSize(128, 64);
      DisplayBorderLeft.mirror = true;
      setRotation(DisplayBorderLeft, 0F, 0F, 0F);
      DisplayBorderRight = new ModelRenderer(this, 83, 38);
      DisplayBorderRight.addBox(0F, 0F, 0F, 2, 24, 1);
      DisplayBorderRight.setRotationPoint(18F, -4F, -1F);
      DisplayBorderRight.setTextureSize(128, 64);
      DisplayBorderRight.mirror = true;
      setRotation(DisplayBorderRight, 0F, 0F, 0F);
      ButternOn = new ModelRenderer(this, 1, 6);
      ButternOn.addBox(0F, 0F, 0F, 1, 1, 0);
      ButternOn.setRotationPoint(15F, 19F, -1F);
      ButternOn.setTextureSize(128, 64);
      ButternOn.mirror = true;
      setRotation(ButternOn, 0F, 0F, 0F);
      ButternOff = new ModelRenderer(this, 4, 6);
      ButternOff.addBox(0F, 0F, 0F, 1, 1, 0);
      ButternOff.setRotationPoint(17F, 19F, -1F);
      ButternOff.setTextureSize(128, 64);
      ButternOff.mirror = true;
      setRotation(ButternOff, 0F, 0F, 0F);
  }

  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Base1.render(f5);
    Base2.render(f5);
    Wall1.render(f5);
    Display1.render(f5);
    DisplayBorderUp.render(f5);
    DisplayBorderDown.render(f5);
    DisplayBorderLeft.render(f5);
    DisplayBorderRight.render(f5);
    ButternOn.render(f5);
    ButternOff.render(f5);
  }

  public void renderModel(float f)
  {
	Base1.render(f);
	Base2.render(f);
	Wall1.render(f);
	Display1.render(f);
	DisplayBorderUp.render(f);
	DisplayBorderDown.render(f);
	DisplayBorderLeft.render(f);
	DisplayBorderRight.render(f);
	ButternOn.render(f);
	ButternOff.render(f);
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
  }

}