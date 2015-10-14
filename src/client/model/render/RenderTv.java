package client.model.render;

import org.lwjgl.opengl.GL11;

import client.model.ModelTv;
import client.model.tileentity.TileEntityTv;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderTv extends TileEntitySpecialRenderer{

	private static final ResourceLocation texture = new ResourceLocation("felimodserver", "textures/models/tv.png");

	private ModelTv model;

	public RenderTv()
	{
		this.model = new ModelTv();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef(180, 0, 0, 1);

		TileEntityTv tile = (TileEntityTv) tileentity;
		int direction = tile.direction;
		GL11.glRotatef(direction * 90, 0.0F, 1.0F, 0.0F);

		this.bindTexture(texture);

		GL11.glPushMatrix();
		this.model.renderModel(0.0625F);
		GL11.glPopMatrix();

		GL11.glPopMatrix();

	}
}
