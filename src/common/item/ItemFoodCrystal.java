package common.item;

import java.util.List;

import common.FeliModServerMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class ItemFoodCrystal extends Item {

	public ItemFoodCrystal()
	{
		this.setCreativeTab(FeliModServerMod.tabFeliModServerMod);
		this.setTextureName("felimodserver:food_crystal");
		this.setUnlocalizedName("food_crystal");
		this.setMaxStackSize(1);
		this.setMaxDamage(16);
		this.setNoRepair();
		this.setContainerItem(FeliModServerModItems.ItemFoodCrystal);
	}

	@Override
    @SideOnly(Side.CLIENT)
	//ToolTipの設定。EnumChatFormattingでカラーコードが指定可能
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean advanced) {
		if (FeliModServerMod.serverproxy.isShiftKeyDown()) {
			list.add(EnumChatFormatting.DARK_GRAY + "Durability: " + itemStack.getItemDamage() + "/" + this.getMaxDamage());
		}else{
			EnumChatFormatting It = EnumChatFormatting.ITALIC;
			EnumChatFormatting Wh = EnumChatFormatting.WHITE;
			list.add(It + "<Hold Shift>");
		}
	}

	@Override
	public boolean hasEffect(ItemStack p_77636_1_) {
		return true;
	}
}
