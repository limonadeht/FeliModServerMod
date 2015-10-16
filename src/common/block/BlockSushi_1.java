package common.block;

import java.util.Random;

import common.ILHsJapaneseFood;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSushi_1 extends Block{

	@SideOnly(Side.CLIENT)
    private IIcon field_150038_a;
    @SideOnly(Side.CLIENT)
    private IIcon field_150037_b;
    @SideOnly(Side.CLIENT)
    private IIcon field_150039_M;

	public BlockSushi_1()
	{
		super(Material.cake);
        this.setTickRandomly(true);
        this.setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod);
	}

	public void setBlockBoundsBasedOnState(IBlockAccess blockaccess, int x, int y, int z)
    {
        int l = blockaccess.getBlockMetadata(x, y, z);
        float f = 0.0625F;
        float f1 = (float)(1 + l * 2) / 16.0F;
        float f2 = 0.5F;
        this.setBlockBounds(f1, 0.0F, f, 1.0F - f, f2, 1.0F - f);
    }

    public void setBlockBoundsForItemRender()
    {
        float f = 0.0625F;
        float f1 = 0.5F;
        this.setBlockBounds(f, 0.0F, f, 1.0F - f, f1, 1.0F - f);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        int l = world.getBlockMetadata(x, y, z);
        float f = 0.0625F;
        float f1 = (float)(1 + l * 2) / 16.0F;
        float f2 = 0.5F;
        return AxisAlignedBB.getBoundingBox((double)((float)x + f1), (double)y, (double)((float)z + f), (double)((float)(x + 1) - f), (double)((float)y + f2 - f), (double)((float)(z + 1) - f));
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
        return par1 == 1 ? this.field_150038_a : (par1 == 0 ? this.field_150037_b : (par2 > 0 && par1 == 4 ? this.field_150039_M : this.blockIcon));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon(this.getTextureName() + "_side");
        this.field_150039_M = p_149651_1_.registerIcon(this.getTextureName() + "_inner");
        this.field_150038_a = p_149651_1_.registerIcon(this.getTextureName() + "_top");
        this.field_150037_b = p_149651_1_.registerIcon(this.getTextureName() + "_bottom");
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer par5, int par6, float par7, float par8, float par9)
    {
        this.EatEvent(world, x, y, z, par5);
        return true;
    }

    public void onBlockClicked(World world, int x, int y, int z, EntityPlayer entityplayer)
    {
        this.EatEvent(world, x, y, z, entityplayer);
    }

    private void EatEvent(World world, int x, int y, int z, EntityPlayer entityplayer)
    {
        if (entityplayer.canEat(false))
        {
            entityplayer.getFoodStats().addStats(2, 0.1F);
            int l = world.getBlockMetadata(x, y, z) + 1;

            if (l >= 6)
            {
                world.setBlockToAir(x, y, z);
            }
            else
            {
                world.setBlockMetadataWithNotify(x, y, z, l, 2);
            }
        }
    }

    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        return !super.canPlaceBlockAt(world, x, y, z) ? false : this.canBlockStay(world, x, y, z);
    }

    public boolean canBlockStay(World world, int x, int y, int z)
    {
        return world.getBlock(x, y - 1, z).getMaterial().isSolid();
    }

    public int quantityDropped(Random random)
    {
        return 0;
    }

    public Item getItemDropped(int par1, Random random, int par3)
    {
        return null;
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z)
    {
        return Items.cake;
    }
}
