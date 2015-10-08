package common.block;

import common.item.FeliModServerModItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class BlockRice extends BlockCrops
{

	@Override
	protected Item func_149866_i()
    {
        return FeliModServerModItems.itemRiceSeed;
    }

	@Override
    protected Item func_149865_P()
    {
        return FeliModServerModItems.itemRiceSeed;
    }
}
