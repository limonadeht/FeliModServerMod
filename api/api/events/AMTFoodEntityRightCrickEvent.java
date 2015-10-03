package api.events;

import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * This class will be deleted for fix the typo.
 */
@Deprecated
@Cancelable
@Event.HasResult
public class AMTFoodEntityRightCrickEvent extends AMTFoodEntityRightClickEvent {

	public AMTFoodEntityRightCrickEvent(World thisWorld, EntityPlayer thisPlayer, ItemStack item, Entity entity) {
		super(thisWorld, thisPlayer, item, entity);
	}
}
