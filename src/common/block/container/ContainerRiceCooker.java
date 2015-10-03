package common.block.container;

import client.model.tileentity.TileEntityRiceCooker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class ContainerRiceCooker extends Container{

	private TileEntityRiceCooker ricecooker;

	public ContainerRiceCooker(InventoryPlayer inventory,TileEntityRiceCooker tileentity){
		this.ricecooker = tileentity;
	}

	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

}
