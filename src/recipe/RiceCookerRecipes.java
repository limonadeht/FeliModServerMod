package recipe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;

public class RiceCookerRecipes {

	private static final RiceCookerRecipes smeltingBase = new RiceCookerRecipes();

	private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();

	public static RiceCookerRecipes smelting(){
		return smeltingBase;
	}

	public static void registerFeliModServerModRiceCookerRecipes(){

		GameRegistry.addSmelting(Blocks.iron_ore, new ItemStack(Items.iron_ingot), 0.7F);
        GameRegistry.addSmelting(Blocks.gold_ore, new ItemStack(Items.gold_ingot), 1.0F);
        GameRegistry.addSmelting(Blocks.diamond_ore, new ItemStack(Items.diamond), 1.0F);
        GameRegistry.addSmelting(Blocks.sand, new ItemStack(Blocks.glass), 0.1F);
        GameRegistry.addSmelting(Items.porkchop, new ItemStack(Items.cooked_porkchop), 0.35F);
        GameRegistry.addSmelting(Items.beef, new ItemStack(Items.cooked_beef), 0.35F);
        GameRegistry.addSmelting(Items.chicken, new ItemStack(Items.cooked_chicken), 0.35F);
        GameRegistry.addSmelting(Blocks.cobblestone, new ItemStack(Blocks.stone), 0.1F);
        GameRegistry.addSmelting(Items.clay_ball, new ItemStack(Items.brick), 0.3F);
        GameRegistry.addSmelting(Blocks.clay, new ItemStack(Blocks.hardened_clay), 0.35F);
        GameRegistry.addSmelting(Blocks.cactus, new ItemStack(Items.dye, 1, 2), 0.2F);
        GameRegistry.addSmelting(Blocks.log, new ItemStack(Items.coal, 1, 1), 0.15F);
        GameRegistry.addSmelting(Blocks.log2, new ItemStack(Items.coal, 1, 1), 0.15F);
        GameRegistry.addSmelting(Blocks.emerald_ore, new ItemStack(Items.emerald), 1.0F);
        GameRegistry.addSmelting(Items.potato, new ItemStack(Items.baked_potato), 0.35F);
        GameRegistry.addSmelting(Blocks.netherrack, new ItemStack(Items.netherbrick), 0.1F);
        ItemFishFood.FishType[] afishtype = ItemFishFood.FishType.values();
        int i = afishtype.length;

        for (int j = 0; j < i; ++j)
        {
            ItemFishFood.FishType fishtype = afishtype[j];

            if (fishtype.func_150973_i())
            {
            	GameRegistry.addSmelting(new ItemStack(Items.fish, 1, fishtype.func_150976_a()), new ItemStack(Items.cooked_fished, 1, fishtype.func_150976_a()), 0.35F);
            }
        }

        GameRegistry.addSmelting(Blocks.coal_ore, new ItemStack(Items.coal), 0.1F);
        GameRegistry.addSmelting(Blocks.redstone_ore, new ItemStack(Items.redstone), 0.7F);
        GameRegistry.addSmelting(Blocks.lapis_ore, new ItemStack(Items.dye, 1, 4), 0.2F);
        GameRegistry.addSmelting(Blocks.quartz_ore, new ItemStack(Items.quartz), 0.2F);
	}

	public ItemStack getSmeltingResult(ItemStack itemstack) {
		Iterator iterator = this.smeltingList.entrySet().iterator();
		Entry entry;

		do {
			if (!iterator.hasNext()) {
				return null;
			}
			entry = (Entry) iterator.next();
		} while (!canBeSmelted(itemstack, (ItemStack) entry.getKey()));
		return (ItemStack) entry.getValue();
	}

	private boolean canBeSmelted(ItemStack par1, ItemStack par2)
    {
        return par2.getItem() == par1.getItem() && (par2.getItemDamage() == 32767 || par2.getItemDamage() == par1.getItemDamage());
    }

	public float giveExperience(ItemStack itemstack){
		Iterator iterator = this.experienceList.entrySet().iterator();
		Entry entry;

		do{
			if(!iterator.hasNext()){
				return 0.0f;
			}

			entry = (Entry) iterator.next();
		}
		while(!this.canBeSmelted(itemstack, (ItemStack) entry.getKey()));

		if(itemstack.getItem().getSmeltingExperience(itemstack) != -1){
				return itemstack.getItem().getSmeltingExperience(itemstack);
		}

		return ((Float) entry.getValue()).floatValue();
	}

	public void addRecipie(Item item, ItemStack itemstack, float experience){
		this.addLists(item, itemstack, experience);
	}

	public void addLists(Item item, ItemStack itemstack, float experience){
		this.putLists(new ItemStack(item, 1, 32767), itemstack, experience);
	}

	public void putLists(ItemStack itemstack, ItemStack itemstack2, float experience){
		this.smeltingList.put(itemstack, itemstack2);
		this.experienceList.put(itemstack2, Float.valueOf(experience));
	}


}
