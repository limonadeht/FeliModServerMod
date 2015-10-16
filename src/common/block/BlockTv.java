package common.block;

import client.model.tileentity.TileEntityTv;
import common.ILHsJapaneseFood;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockTv extends BlockContainer
{

	public BlockTv(Material material)
	{
		super(material);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod);
	}

	public int getRenderType()
	{
		return -1;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
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

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	{
		return new TileEntityTv();
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityplayer, ItemStack itemstack){
		if(entityplayer == null)
		{
			return;
		}
		TileEntityTv tile = (TileEntityTv) world.getTileEntity(x, y, z);
		tile.direction = MathHelper.floor_double((double) (entityplayer.rotationYaw * 4.0F / 360) + 0.5D) &3;
	}

}