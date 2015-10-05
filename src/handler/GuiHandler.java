package handler;

import client.gui.GuiRiceCooker;
import client.model.tileentity.TileEntityRiceCooker;
import common.block.container.ContainerRiceCooker;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entiry = world.getTileEntity(x, y, z);

		if(entiry instanceof TileEntityRiceCooker){
			return new ContainerRiceCooker(player.inventory,(TileEntityRiceCooker)entiry);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entiry = world.getTileEntity(x, y, z);

		if(entiry instanceof TileEntityRiceCooker){
			return new GuiRiceCooker(player.inventory,(TileEntityRiceCooker)entiry);
		}
		return null;
	}

}
