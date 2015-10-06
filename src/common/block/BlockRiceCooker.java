package common.block;

import client.model.tileentity.TileEntityRiceCooker;
import common.FeliModServerMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockRiceCooker extends BlockContainer
{
	/*
	  @SideOnly(Side.CLIENT)
	  private IIcon top;
	  @SideOnly(Side.CLIENT)
	  private IIcon front;
	  */

	 @SideOnly(Side.CLIENT)
	 private IIcon top;
	 @SideOnly(Side.CLIENT)
	 private IIcon front;

	  private final boolean isActive;

	  private static boolean keepInventory;

	  public BlockRiceCooker(boolean isActive)
	  {
		  super(Material.iron);
		  /*
		  this.setCreativeTab(FeliModServerMod.tabFeliModServerMod);
		  this.setHardness(5.0F);
		  this.setBlockName("Rice Cooker");
		  this.setStepSound(soundTypeAnvil);
		  */

		  this.isActive=isActive;
	  }

	  @SideOnly(Side.CLIENT)
		public void registerBlockIcons(IIconRegister iconregister) {
			this.blockIcon = iconregister.registerIcon("felimodserver:rice_cooker_side");
			this.front = iconregister.registerIcon(this.isActive ? "felimodserver:rice_cooker_active" : "felimodserver:rice_cooker_inactive");
			this.top = iconregister.registerIcon("felimodserver:rice_cooker_top");
		}

	  @SideOnly(Side.CLIENT)
	  public IIcon getIcon(int side, int meta) {
//			if (side == 1) {
//				return top;
//			} else if (side == 3) {
//				return front;
//			} else {
//				return this.blockIcon;
//			}
		  return side == 1 ? this.top : (side == 0 ? this.top : (side != meta ? this.blockIcon : this.front));
		}


	  public Item getItemDropped(World world, int x, int y, int z){
		  return Item.getItemFromBlock(FeliModServerModBlocks.BlockRiceCookerIdle);

	  }

	  public void onBlockAppend(World world, int x, int y, int z){
		  super.onBlockAdded(world, x, y, z);
		  this.setDefaultDirection(world, x, y, z);
	  }

	private void setDefaultDirection(World world, int x, int y, int z) {
		if(!world.isRemote){
			Block b1 = world.getBlock(x, y, z - 1);
			Block b2 = world.getBlock(x, y, z + 1);
			Block b3 = world.getBlock(x - 1, y, z);
			Block b4 = world.getBlock(x + 1, y, z);

			byte b0=3;

			if(b1.func_149730_j()&&!b2.func_149730_j()){
				b0=3;
			}
			if(b2.func_149730_j()&&!b1.func_149730_j()){
				b0=2;
			}

			if(b3.func_149730_j()&&!b4.func_149730_j()){
				b0=5;
			}

			if(b4.func_149730_j()&&!b3.func_149730_j()){
				b0=4;
			}

			world.setBlockMetadataWithNotify(x, y, z, b0,2);
		}

	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){

		TileEntity tileentity = world.getTileEntity(x, y, z);
		if(tileentity == null || player.isSneaking()){
			return false;
		}
		player.openGui(FeliModServerMod.Instance, 0, world, x, y, z);

		return true;
	}

	public TileEntity createNewTileEntity(World world, int par2)
	  {
	    return  new TileEntityRiceCooker();
	  }

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityplayer, ItemStack itemstack){
		int l=MathHelper.floor_double((double)(entityplayer.rotationYaw*4.0f/360.F)+0.5D)&3;

		if(l==0){
			world.setBlockMetadataWithNotify(x,y, z, 2, 2);
		}
		if(l==1){
			world.setBlockMetadataWithNotify(x,y, z, 5, 2);
		}
		if(l==2){
			world.setBlockMetadataWithNotify(x,y, z, 3, 2);
		}
		if(l==3){
			world.setBlockMetadataWithNotify(x,y, z, 4, 2);
		}

		if(itemstack.hasDisplayName()){
			((TileEntityRiceCooker)world.getTileEntity(x, y, z)).setGuiDisplayName(itemstack.getDisplayName());
		}
	}



	public static void updateRiceCookerState(boolean active, World worldObj, int xCoord, int yCoord, int zCoord) {
		int i= worldObj.getBlockMetadata(xCoord, yCoord, zCoord);

		TileEntity tileentity = worldObj.getTileEntity(xCoord, yCoord, zCoord);
		keepInventory = true;

		if(active){
			worldObj.setBlock(xCoord, yCoord, zCoord, FeliModServerModBlocks.BlockRiceCookerActive);
		}else{
			worldObj.setBlock(xCoord, yCoord, zCoord, FeliModServerModBlocks.BlockRiceCookerIdle);
		}

		keepInventory = false;
		worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);

		if(tileentity != null){
			tileentity.validate();
			worldObj.setTileEntity(xCoord, yCoord, zCoord, tileentity);
		}
	}
}
