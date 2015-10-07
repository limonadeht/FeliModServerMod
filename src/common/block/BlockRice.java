package common.block;

import common.item.FeliModServerModItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class BlockRice extends BlockCrops
{
	@SideOnly(Side.CLIENT)
    private IIcon[] iconArray;

	public BlockRice()
	{
	}

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
        if (par2 < 7)
        {
            if (par2 == 6)
            {
                par2 = 5;
            }

            return this.iconArray[par2 >> 1];
        }
        else
        {
            return this.iconArray[3];
        }
    }

    //収穫できる種
    protected Item func_149866_i()
    {
        return FeliModServerModItems.itemRiceSeed;
    }

    //収穫できるアイテム
    protected Item func_149865_P()
    {
        return FeliModServerModItems.itemRiceSeed;
    }

    //ブロックのテクスチャ
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.iconArray = new IIcon[4];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon("multiengineeing:sfx_block_crops_iron_" + i);
        }
    }
}
