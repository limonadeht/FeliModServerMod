package common.block;

import client.model.tileentity.TileEntityRiceCooker;
import common.FeliModServerMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockRiceCooker extends BlockContainer
{
	  @SideOnly(Side.CLIENT)
	  private IIcon TopIcon;
	  @SideOnly(Side.CLIENT)
	  private IIcon field_149986_M;

	  public BlockRiceCooker()
	  {
		  super(Material.iron);
		  this.setCreativeTab(FeliModServerMod.tabFeliModServerMod);
		  this.setHardness(5.0F);
		  this.setBlockName("Roce Cooker");
		  this.setStepSound(soundTypeAnvil);
	  }

	  public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float dx, float dy, float dz)
	  {
	    if (!world.isRemote) {
	      player.openGui(FeliModServerMod.Instance, FeliModServerMod.GUI_ID, world, x, y, z);
	    }
	    return true;
	  }

	  public TileEntity createNewTileEntity(World world, int par2)
	  {
	    return new TileEntityRiceCooker();
	  }

	  public void breakBlock(World world, int x, int y, int z, Block block, int meta)
	  {
		  TileEntityRiceCooker tileEntity = (TileEntityRiceCooker)world.getTileEntity(x, y, z);
		    if (tileEntity != null) {
		      dropItem(tileEntity, world, x, y, z);
		    }
		    super.breakBlock(world, x, y, z, block, meta);
	  }

	  private void dropItem(IInventory iinventory, World world, int xCoord, int yCoord, int zCoord)
	  {
	    for (int slotIndex = 0; slotIndex < iinventory.getSizeInventory(); slotIndex++)
	    {
	      ItemStack itemStack = iinventory.getStackInSlot(slotIndex);
	      if (itemStack != null)
	      {
	        EntityItem entityitem = new EntityItem(world, xCoord, yCoord, zCoord, itemStack);

	        world.equals(entityitem);
	      }
	    }
	  }
}
