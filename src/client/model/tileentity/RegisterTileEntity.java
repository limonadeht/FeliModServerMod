package client.model.tileentity;

import common.FeliModServerMod;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterTileEntity
{
	public static void registerFeliModServerModTileEntity()
	{
		GameRegistry.registerTileEntity(TileJuicer.class, FeliModServerMod.MOD_ID + ":Juicer");
	}
}
