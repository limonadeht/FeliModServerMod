package common.block;

import common.FeliModServerMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockRiceCooker extends Block
{
	public BlockRiceCooker()
	{
		super(Material.iron);
		this.setCreativeTab(FeliModServerMod.tabFeliModServerMod);
		this.setBlockName("Rice Cooker");
	}

	 @Override
	    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
	        player.openGui(FeliModServerMod.Instance, FeliModServerMod.GUI_ID, world, x, y, z);
	        return true;
	    }
}
