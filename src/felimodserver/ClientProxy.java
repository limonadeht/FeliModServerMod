package felimodserver;

import cpw.mods.fml.client.registry.ClientRegistry;
import felimodserver.render.RenderBento;
import felimodserver.tileentity.TileEntityBento;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class ClientProxy extends ServerProxy
{
	public void registerRenderThings()
	{
		TileEntitySpecialRenderer render = new RenderBento();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBento.class, render);
	}

	public void registerTileEntitySpecialRenderer()
	{

	}
}
