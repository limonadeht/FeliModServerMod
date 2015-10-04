package common;

import client.GuiRiceCooker;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import server.RiceCookerContainer;

public class GuiHandler implements IGuiHandler
{
	/*サーバー側の処理*/
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == FeliModServerMod.GUI_ID) {
            return new RiceCookerContainer(x, y, z);
        }
        return null;
    }

    /*クライアント側の処理*/
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == FeliModServerMod.GUI_ID) {
            return new GuiRiceCooker(x, y, z);
        }
        return null;
    }
}