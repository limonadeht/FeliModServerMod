package common.food;

import java.util.List;

import common.FeliModServerMod;
import common.block.FeliModServerModBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class itemFoodsample extends Item
{

	public final int itemUseDuration;
	private final int healAmount;
	private boolean alwaysEdible;
	private int potionId;
	private int potionDuration;
	private int potionAmplifier;
	private float potionEffectProbability;
	private final float saturationModifier;

	private ItemStack emptyItem = null;

	public itemFoodsample(float par1, float par2, boolean par3)
	{
		this.setCreativeTab(FeliModServerMod.tabFeliModServerMod);
		this.setUnlocalizedName("bento_sample");
		this.itemUseDuration = 3;
		this.healAmount = 1;
		this.saturationModifier = par2;
		this.maxStackSize = 1;
		this.setMaxDamage(3);
		this.setNoRepair();
		this.setTextureName("felimodserver:bentou_sample");
	}

	@Override
    @SideOnly(Side.CLIENT)
	//ToolTipの設定。EnumChatFormattingでカラーコードが指定可能
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean advanced) {
        list.add("OMG This is sample Food.");
        list.add(EnumChatFormatting.GOLD + "HealAmount: " + healAmount);

        String potionid = this.getPotionEffect(itemStack);
        if(potionid == null)
        {
        	list.add(EnumChatFormatting.AQUA + "PotionEffect: none");
        }else{
        	list.add(EnumChatFormatting.AQUA + "PotionEffect: " + potionId + potionDuration);
        }
        list.add(EnumChatFormatting.DARK_GRAY + "Durability: " + itemStack.getItemDamage() + "/" + this.getMaxDamage());
    }

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10){
		if(par7 != 1){
			return false;
		}else{
			if(player.canPlayerEdit(x, y + 1, z, par7, stack) && player.canPlayerEdit(x, y + 2, z, par7, stack)){
				world.setBlock(x, y + 1, z, FeliModServerModBlocks.BlockBento);
				world.notifyBlockOfNeighborChange(x, y + 1, z, FeliModServerModBlocks.BlockBento);
				--stack.stackSize;
				return true;
			}else{
				return false;
			}
		}
	}

	public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
		//damageItem()で耐久値を1減らしている
        itemstack.damageItem(1, entityplayer);
        entityplayer.getFoodStats().addStats(healAmount, potionEffectProbability);
        world.playSoundAtEntity(entityplayer, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
        this.onFoodEaten(itemstack, world, entityplayer);
        return itemstack;
    }

	protected void onFoodEaten(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        if (!world.isRemote && this.potionId > 0 && world.rand.nextFloat() < this.potionEffectProbability)
        {
            entityplayer.addPotionEffect(new PotionEffect(this.potionId, this.potionDuration * 20, this.potionAmplifier));
        }
    }

	//食べる速さ。デフォルト32
	public int getMaxItemUseDuration(ItemStack itemstack)
    {
        return 3;
    }

	public EnumAction getItemUseAction(ItemStack itemstack)
    {
        return EnumAction.eat;
    }

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
           if (entityplayer.canEat(this.alwaysEdible))
           {
        	   //if(itemstack.getItemDamage() >= this.getMaxDamage() - 1)
               entityplayer.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));
           }
        return itemstack;
    }

	public int func_150905_g(ItemStack itemstack)
    {
        return this.healAmount;
    }

	public float func_150906_h(ItemStack itemstack)
    {
        return this.saturationModifier;
    }

	public itemFoodsample setAlwaysEdible()
    {
        this.alwaysEdible = true;
        return this;
    }

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconregister)
	{
		this.itemIcon = iconregister.registerIcon("felimodserver:bentou_sample");
	}
}
