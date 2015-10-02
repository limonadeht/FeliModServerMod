package felimodserver;

import cpw.mods.fml.common.registry.GameRegistry;
import felimodserver.tileentity.TileEntityBento;

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
