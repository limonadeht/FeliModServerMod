package client.model.render;

import org.lwjgl.opengl.GL11;

import client.model.ModelBento;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderBento implements IItemRenderer
{
	public static ResourceLocation TEXTURE = new ResourceLocation("felimodserver", "textures/models/ModelBento.png");

	protected ModelBento model;

	public ItemRenderBento()
	{
		this.model = new ModelBento();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		switch(type)
		{
		case EQUIPPED: return true;
		case EQUIPPED_FIRST_PERSON: return true;
		case INVENTORY: return true;
		case ENTITY: return true;
		default: return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		switch(type)
		{
		case EQUIPPED:
		{
			renderBento(0.1F, 1.0F, 0.3F, false); break;
			/*
			GL11.glPushMatrix();

			Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);

			GL11.glTranslatef(10, 1, 1);
			GL11.glRotatef(5, 0, 0, 1);
            GL11.glScalef(1.5F, 1.0F, 1.0F);

			this.model.renderModel(0.0625F);

			GL11.glPopMatrix();
			*/
		}
		/*
		case EQUIPPED_FIRST_PERSON:
		{

		}
		*/
		default:
			break;
		}
	}

	private void renderBento(float i, float j, float k, boolean entity)
	{
		float scale = 0.041666668F;
	    Tessellator tesselator = Tessellator.instance;

	    GL11.glPushMatrix();
	    GL11.glTranslatef(i, j, k);
	    if (entity) {
	    	GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
	      //GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
	    }
	    GL11.glRotatef(180.0F, 1.0F, 0.2F, -0.1F);
	    //GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
	    this.model.renderModel(0.0625F);
	    GL11.glPopMatrix();
	}

}
