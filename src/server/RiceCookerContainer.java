package server;

import client.model.tileentity.TileEntityRiceCooker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;

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

    public RiceCookerContainer(InventoryPlayer player, TileEntityRiceCooker tileEntityFurnace){
		this.tileFurnace = tileEntityFurnace;
		this.addSlotToContainer(new Slot(tileEntityFurnace, 0, 56, 17));
		this.addSlotToContainer(new Slot(tileEntityFurnace, 1, 56, 53));
		this.addSlotToContainer(new SlotFurnace(player.player, tileEntityFurnace, 2, 116, 35));
		int i;

		for(i = 0; i < 3; ++i){
			for(int j = 0; j < 9; ++j){
				this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for(i = 0; i < 9; ++i){
			this.addSlotToContainer(new Slot(player, i , 8 + i * 18 , 142));
		}
	}

	@Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return true;
    }
}
