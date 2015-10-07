package common.item;

import java.util.List;

import common.FeliModServerMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class itemDebug extends Item
{
	public itemDebug()
	{
		this.setCreativeTab(FeliModServerMod.tabFeliModServerMod);
		this.setUnlocalizedName("felimodserver:itemdebug");
		this.setTextureName("felimodserver:debug_item");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		entityplayer.capabilities.allowFlying = !entityplayer.capabilities.allowFlying;
		entityplayer.capabilities.disableDamage = !entityplayer.capabilities.disableDamage;


		int i = (int) world.getWorldTime();
		if(world.isRemote)
		{
		if(i <= 1000)
		{
			world.setWorldTime(world.getWorldTime() + 100);
			//entityplayer.addChatComponentMessage(new ChatComponentText("Mode Ghanged: " + EnumChatFormatting.RED + "Enabled"));
		}else{
			world.setWorldTime(world.getWorldTime() + 200);
			//entityplayer.addChatComponentMessage(new ChatComponentText("Mode Changed: " + EnumChatFormatting.RED + "Disabled"));
		}
		}
		return super.onItemRightClick(itemstack, world, entityplayer);
	}

	@Override
    @SideOnly(Side.CLIENT)
	//ToolTipの設定。EnumChatFormattingでカラーコードが指定可能
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean advanced)
	{
		if (FeliModServerMod.serverproxy.isShiftKeyDown())
		{
		list.add("Debugger Item.");
		list.add("Right-Click flyMode");

		EntityPlayer entityplayer = player;
		if(player.capabilities.isFlying)
		{
			list.add(EnumChatFormatting.AQUA + "FlyingMode: " + EnumChatFormatting.RED + "enabled");
		}else{
			list.add(EnumChatFormatting.AQUA + "FlyingMode: " + EnumChatFormatting.RED + "disabled");
		}
		}
	}
}
