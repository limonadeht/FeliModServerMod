package api.recipe;

import net.minecraft.block.Block;

public interface ICookingHeatSource {

	Block getBlock();

	int getMetadata();

}
