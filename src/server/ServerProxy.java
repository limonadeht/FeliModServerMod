package server;

import client.model.tileentity.TileEntityBento;
import common.FeliModServerMod;
import cpw.mods.fml.common.registry.GameRegistry;

public class ServerProxy
{
	public void registerRenderThings()
	{

	}

	public void registerTileEntitySpecialRenderer()
	{
		GameRegistry.registerTileEntity(TileEntityBento.class, FeliModServerMod.MOD_ID + ":TileBento");
	}
}
