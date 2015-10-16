package common.block;

import java.util.Random;

import client.model.tileentity.TileEntityRiceCooker;
import common.ILHsJapaneseFood;
import common.Register;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;

public class BlockRiceCooker extends BlockContainer
{

	private final Random randomdrop = new Random();

	 @SideOnly(Side.CLIENT)
	 private IIcon top;
	 @SideOnly(Side.CLIENT)
	 private IIcon front;

	  private final boolean isActive;

	  private static boolean keepInventory;

	  public BlockRiceCooker(boolean isActive)
	  {
		  super(Material.iron);
		  this.setHardness(5.0F);
		  this.setBlockName("Rice Cooker");
		  this.setStepSound(soundTypeAnvil);

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
		  return Item.getItemFromBlock(Register.BlockRiceCookerIdle);

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

		ItemStack itemstack = player.inventory.getCurrentItem();
		TileEntityRiceCooker tileentity = (TileEntityRiceCooker) world.getTileEntity(x, y, z);

		if(tileentity == null || player.isSneaking()){
			return false;
		}

		if (tileentity != null)
        {
    		FluidStack fluid = tileentity.waterTank.getFluid();

        	if (itemstack == null)
        	{
        		player.openGui(ILHsJapaneseFood.Instance, 0, world, x, y, z);

        		return true;
        	}
        	else
        	{
    			FluidStack fluid2 =  FluidContainerRegistry.getFluidForFilledItem(itemstack);
        		if (fluid2 != null && fluid2.getFluid() != null)
        		{
    				int put =  tileentity.fill(ForgeDirection.UNKNOWN, fluid2, false);

    				if (put == fluid2.amount)
    				{
    					tileentity.fill(ForgeDirection.UNKNOWN, fluid2, true);

    					ItemStack emptyContainer = FluidContainerRegistry.drainFluidContainer(itemstack);
    					if (emptyContainer != null)
    					{
    						if (!player.inventory.addItemStackToInventory(emptyContainer.copy()))
        		        	{
        		        		player.entityDropItem(emptyContainer.copy(), 1);
        		        	}
    					}
    					if (!player.capabilities.isCreativeMode && itemstack.stackSize-- <= 0)
    	                                {
    	            	                	player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
    	                                }

    				        tileentity.markDirty();
    	        		        player.inventory.markDirty();
    	        		        world.markBlockForUpdate(x, y, z);
    	        		        world.playSoundAtEntity(player, "random.pop", 0.4F, 1.8F);

    	        		        return true;
    				}
        		}
        		else
        		{
        			if (fluid != null && fluid.getFluid() != null)
        			{
        				if (fluid.amount < 1000) return true;

        				ItemStack get = FluidContainerRegistry.fillFluidContainer(new FluidStack(fluid.getFluid(), 1000), itemstack);

        				if (get != null)
        				{
            				tileentity.drain(ForgeDirection.UNKNOWN, 1000, true);

        					if (!player.inventory.addItemStackToInventory(get.copy()))
        		        	{
        		        		player.entityDropItem(get.copy(), 1);
        		        	}

        				if (!player.capabilities.isCreativeMode && itemstack.stackSize-- <= 0)
        	                        {
        	            	        player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
        	                        }
        				tileentity.markDirty();
        	        		player.inventory.markDirty();
        	        		world.markBlockForUpdate(x, y, z);
        	        		world.playSoundAtEntity(player, "random.pop", 0.4F, 1.8F);
        				}
        				player.openGui(ILHsJapaneseFood.Instance, 0, world, x, y, z);
        				return true;
        			}
        			else
        			{
        				player.openGui(ILHsJapaneseFood.Instance, 0, world, x, y, z);
        				return true;
        			}
        		}
        	}
        }

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
			worldObj.setBlock(xCoord, yCoord, zCoord, Register.BlockRiceCookerActive);
		}else{
			worldObj.setBlock(xCoord, yCoord, zCoord, Register.BlockRiceCookerIdle);
		}

		keepInventory = false;
		worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);

		if(tileentity != null){
			tileentity.validate();
			worldObj.setTileEntity(xCoord, yCoord, zCoord, tileentity);
		}
	}

	public void breakBlock(World world, int par2, int par3, int par4, Block block, int par6)
    {
        if (!keepInventory)
        {
        	TileEntityRiceCooker tileentityricecooker = (TileEntityRiceCooker)world.getTileEntity(par2, par3, par4);

            if (tileentityricecooker != null)
            {
                for (int i1 = 0; i1 < tileentityricecooker.getSizeInventory(); ++i1)
                {
                    ItemStack itemstack = tileentityricecooker.getStackInSlot(i1);

                    if (itemstack != null)
                    {
                        float f = this.randomdrop.nextFloat() * 0.8F + 0.1F;
                        float f1 = this.randomdrop.nextFloat() * 0.8F + 0.1F;
                        float f2 = this.randomdrop.nextFloat() * 0.8F + 0.1F;

                        while (itemstack.stackSize > 0)
                        {
                            int j1 = this.randomdrop.nextInt(21) + 10;

                            if (j1 > itemstack.stackSize)
                            {
                                j1 = itemstack.stackSize;
                            }

                            itemstack.stackSize -= j1;
                            EntityItem entityitem = new EntityItem(world, (double)((float)par2 + f), (double)((float)par3 + f1), (double)((float)par4 + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));

                            if (itemstack.hasTagCompound())
                            {
                                entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                            }

                            float f3 = 0.05F;
                            entityitem.motionX = (double)((float)this.randomdrop.nextGaussian() * f3);
                            entityitem.motionY = (double)((float)this.randomdrop.nextGaussian() * f3 + 0.2F);
                            entityitem.motionZ = (double)((float)this.randomdrop.nextGaussian() * f3);
                            world.spawnEntityInWorld(entityitem);
                        }
                    }
                }

                world.func_147453_f(par2, par3, par4, block);
            }
        }

        super.breakBlock(world, par2, par3, par4, block, par6);
    }
}
