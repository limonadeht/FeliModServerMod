package common.item;

import common.FeliModServerMod;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class itemRiceSeed extends Item implements IPlantable
{
	private Block field_150925_a;
	private Block soilBlockID;

	public itemRiceSeed(Block block, Block block2)
	{
		this.field_150925_a = block;
        this.soilBlockID = block2;
        this.setCreativeTab(FeliModServerMod.tabFeliModServerMod);
	}

	public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if (p_77648_7_ != 1)
        {
            return false;
        }
        else if (entityplayer.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, itemstack) && entityplayer.canPlayerEdit(p_77648_4_, p_77648_5_ + 1, p_77648_6_, p_77648_7_, itemstack))
        {
            if (world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_).canSustainPlant(world, p_77648_4_, p_77648_5_, p_77648_6_, ForgeDirection.UP, this) && world.isAirBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_))
            {
                world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, this.field_150925_a);
                --itemstack.stackSize;
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

	@Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
    {
        return field_150925_a == Blocks.nether_wart ? EnumPlantType.Nether : EnumPlantType.Crop;
    }

    @Override
    public Block getPlant(IBlockAccess world, int x, int y, int z)
    {
        return field_150925_a;
    }

    @Override
    public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
    {
        return 0;
    }
}
