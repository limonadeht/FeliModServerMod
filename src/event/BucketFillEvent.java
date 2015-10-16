package event;

import java.util.HashMap;
import java.util.Map;

import common.JPFLogger;
import common.Register;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;

/**
 * This Class was created based on the BucketHander.class (BuildCraft).
 * Original code was created by SpaceToad and BuildCraft Team.
 */
public class BucketFillEvent {

	public static Map<Block, Item> buckets = new HashMap<Block, Item>();

	@SubscribeEvent
	public void onBucketFill(FillBucketEvent event) {
		ItemStack result = fillCustomBucket(event.world, event.target);

		if (result == null) {
			return;
		}

		event.result = result;
		event.setResult(Result.ALLOW);
	}

	private ItemStack fillCustomBucket(World world, MovingObjectPosition pos) {
		Block block = world.getBlock(pos.blockX, pos.blockY, pos.blockZ);

		Item bucket = buckets.get(block);
		if (bucket != null) {
			JPFLogger.info("bucket event : " + bucket.getUnlocalizedName());
		}

		if (bucket != null && world.getBlockMetadata(pos.blockX, pos.blockY, pos.blockZ) == 0) {
			world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
			return new ItemStack(bucket);
		} else {
			return null;
		}
	}

	public void register() {
		buckets.put(Register.FluidBlockLimone, Register.ItemBucketLimone);
	}

}