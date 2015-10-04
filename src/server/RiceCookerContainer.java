package server;

import client.model.tileentity.TileEntityRiceCooker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class RiceCookerContainer extends Container
{
	private TileEntityRiceCooker tileFurnace;
	//座標でGUIを開くか判定するためのもの。
    int xCoord, yCoord, zCorrd;
    public RiceCookerContainer(int x, int y, int z)
    {
        this.xCoord = x;
        this.yCoord = y;
        this.zCorrd = z;
    }

	@Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return true;
    }
}
