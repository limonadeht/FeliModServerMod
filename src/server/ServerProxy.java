package server;

import client.model.tileentity.TileEntityBento;
import common.ILHsJapaneseFood;
import cpw.mods.fml.common.registry.GameRegistry;

public class ServerProxy
{
	public void registerRenderThings()
	{
	}
	
	public void registerRenderers()
	{
	}

	public void registerTileEntitySpecialRenderer()
	{
		GameRegistry.registerTileEntity(TileEntityBento.class, ILHsJapaneseFood.MOD_ID + ":TileBento");
	}

	public boolean isShiftKeyDown() {
		return false;
	}

	public void LoadNEI() {}
}
