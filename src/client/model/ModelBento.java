package client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBento extends ModelBase
{
	public static ModelBento instance = new ModelBento();

  //fields
    ModelRenderer bentoHako1;
    ModelRenderer bentoHako2;
    ModelRenderer bentoHako3;
    ModelRenderer bentoHako4;
    ModelRenderer bentoSoko;

  public ModelBento()
  {
    textureWidth = 64;
    textureHeight = 32;

      bentoHako1 = new ModelRenderer(this, 0, 0);
      bentoHako1.addBox(0F, 0F, 0F, 8, 3, 1);
      bentoHako1.setRotationPoint(-4F, 21F, 4F);
      bentoHako1.setTextureSize(64, 32);
      bentoHako1.mirror = true;
      setRotation(bentoHako1, 0F, 0F, 0F);
      bentoHako2 = new ModelRenderer(this, 0, 0);
      bentoHako2.addBox(0F, 0F, 0F, 8, 3, 1);
      bentoHako2.setRotationPoint(-4F, 21F, -5F);
      bentoHako2.setTextureSize(64, 32);
      bentoHako2.mirror = true;
      setRotation(bentoHako2, 0F, 0F, 0F);
      bentoHako3 = new ModelRenderer(this, 0, 0);
      bentoHako3.addBox(0F, 0F, 0F, 1, 3, 10);
      bentoHako3.setRotationPoint(4F, 21F, -5F);
      bentoHako3.setTextureSize(64, 32);
      bentoHako3.mirror = true;
      setRotation(bentoHako3, 0F, 0F, 0F);
      bentoHako4 = new ModelRenderer(this, 0, 0);
      bentoHako4.addBox(0F, 0F, 0F, 1, 3, 10);
      bentoHako4.setRotationPoint(-4F, 21F, -5F);
      bentoHako4.setTextureSize(64, 32);
      bentoHako4.mirror = true;
      setRotation(bentoHako4, 0F, 0F, 0F);
      bentoSoko = new ModelRenderer(this, 0, 0);
      bentoSoko.addBox(0F, 0F, 0F, 9, 1, 10);
      bentoSoko.setRotationPoint(-4F, 23F, -5F);
      bentoSoko.setTextureSize(64, 32);
      bentoSoko.mirror = true;
      setRotation(bentoSoko, 0F, 0F, 0F);
  }

  public void renderBento(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    bentoHako1.render(f5);
    bentoHako2.render(f5);
    bentoHako3.render(f5);
    bentoHako4.render(f5);
    bentoSoko.render(f5);
  }

  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

  public void renderModel(float f)
  {
	  bentoHako1.render(f);
	  bentoHako2.render(f);
	  bentoHako3.render(f);
	  bentoHako4.render(f);
	  bentoSoko.render(f);
  }

  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
