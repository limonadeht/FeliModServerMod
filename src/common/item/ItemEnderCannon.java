package common.item;

import java.util.List;

import common.ILHsJapaneseFood;
import common.entity.EntityEnderCannon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemEnderCannon extends Item
{
	/*@SideOnly(Side.CLIENT)
	  private IIcon icons;*/

	public ItemEnderCannon()
	{
		int durability = 256;
		this.setMaxStackSize(256);
		this.setCreativeTab(ILHsJapaneseFood.tabFeliModServerMod);
		this.setMaxDamage(durability);
		this.setTextureName("felimodserver:ender_cannon");
	}

	@Override
    @SideOnly(Side.CLIENT)
	//ToolTipの設定。EnumChatFormattingでカラーコードが指定可能
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean advanced) {
		if (ILHsJapaneseFood.serverproxy.isShiftKeyDown()) {
			list.add("This EnderCanonn is using EnderPearl");
			list.add("Pleace Charged EnderPearl.");
			list.add(EnumChatFormatting.DARK_GRAY + "Durability: " + itemStack.getItemDamage() + "/" + this.getMaxDamage());
		}
	}


/*	  @SideOnly(Side.CLIENT)
	  public void func_94581_a(IIconRegister par1IconRegister)
	  {
	    this.icons = par1IconRegister.registerIcon("felimodserver:ender_cannon");
	  }*/

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
		//クリエイティブモードの場合
        if (entityplayer.capabilities.isCreativeMode)
        {
            return itemstack;
        }
        else
        {
        	itemstack.damageItem(1, entityplayer);
            world.playSoundAtEntity(entityplayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (!world.isRemote)
            {
            	world.spawnEntityInWorld(new EntityEnderCannon(world, entityplayer));
            }

            return itemstack;
        }
    }
}
