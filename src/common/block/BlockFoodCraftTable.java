package common.block;

import client.model.tileentity.TileEntityFoodCraftTable;
import common.FeliModServerMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockFoodCraftTable extends Block
{
	@SideOnly(Side.CLIENT)
    private IIcon iconTop;
    @SideOnly(Side.CLIENT)
    private IIcon iconFront;

    public BlockFoodCraftTable()
    {
    	super(Material.iron);
    	this.setCreativeTab(FeliModServerMod.tabFeliModServerMod);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ == 1 ? this.iconTop : (p_149691_1_ == 0 ? Blocks.planks.getBlockTextureFromSide(p_149691_1_) : (p_149691_1_ != 2 && p_149691_1_ != 4 ? this.blockIcon : this.iconTop));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon("felimodserver:food_craft_table_side");
        this.iconTop = p_149651_1_.registerIcon("food_craft_table_top");
        this.iconFront = p_149651_1_.registerIcon("food_craft_table_front");
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityplayer, int par6, float par7, float par8, float par9)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            entityplayer.openGui(FeliModServerMod.Instance, 1, world, x, y, z);
            return true;
        }
    }

    public TileEntity createNewTileEntity(World world, int par2)
	{
		return new TileEntityFoodCraftTable();
	}
}
