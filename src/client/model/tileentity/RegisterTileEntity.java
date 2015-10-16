package client.model.tileentity;

import common.ILHsJapaneseFood;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterTileEntity
{
	public static void registerFeliModServerModTileEntity()
	{
		GameRegistry.registerTileEntity(TileJuicer.class, ILHsJapaneseFood.MOD_ID + ":Juicer");
	}
}
