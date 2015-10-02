package felimodserver.render;

import org.lwjgl.opengl.GL11;

import felimodserver.model.ModelBento;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderBento extends TileEntitySpecialRenderer
{
	private static final ResourceLocation TEXTURE = new ResourceLocation("felimodserver", "textures/models/ModelBento.png");

	private ModelBento model;

	public RenderBento()
	{
		this.model = new ModelBento();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef(180, 0, 0, 1);
		this.bindTexture(TEXTURE);

		GL11.glPushMatrix();
		this.model.renderModel(0.0625F);
		GL11.glPopMatrix();

		GL11.glPopMatrix();
	}
}
