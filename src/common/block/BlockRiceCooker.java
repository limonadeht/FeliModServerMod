package common.block;

import java.util.Random;

import client.model.tileentity.TileEntityRiceCooker;
import common.FeliModServerMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockRiceCooker extends BlockContainer
{
	public BlockRiceCooker()
	{
		super(Material.iron);
		this.setCreativeTab(FeliModServerMod.tabFeliModServerMod);
		this.setBlockName("Rice Cooker");
	}

	@SideOnly(Side.CLIENT)
	private IIcon top;
	@SideOnly(Side.CLIENT)
	private IIcon front;

	private static boolean isBurning;
	private final boolean isBurning2;
	private final Random random = new Random();

	protected BlockRiceCooker(boolean isActive) {
		super(Material.rock);
		isBurning2 = isActive;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconregister) {
		this.blockIcon = iconregister.registerIcon(Strings.MODID + ":TutFurnaceSide");
		this.front = iconregister.registerIcon(this.isBurning2 ? Strings.MODID + ":TutFurnaceActive" : Strings.MODID + ":TutFurnaceInactive");
		this.top = iconregister.registerIcon(Strings.MODID + ":TutFurnaceTop");
	}

	 @Override
	    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
	        player.openGui(FeliModServerMod.Instance, FeliModServerMod.GUI_ID, world, x, y, z);
	        return true;
	    }

	    public TileEntity createNewTileEntity(World world, int par2)
		{
			return new TileEntityRiceCooker();
		}
}
