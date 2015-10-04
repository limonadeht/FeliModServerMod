package client;

import org.lwjgl.input.Keyboard;

import client.model.tileentity.RenderBento;
import client.model.tileentity.TileEntityBento;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import server.ServerProxy;

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

	@Override
	public boolean isShiftKeyDown() {
		return Keyboard.isKeyDown(Keyboard.KEY_LSHIFT);
	}
}
