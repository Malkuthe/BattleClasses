package battleclassmod.guis;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import battleclassmod.BattleClassMod;
import battleclassmod.PlayerClass;
import battleclassmod.inventories.containers.BCMInterfaceContainer;
import cpw.mods.fml.common.network.IGuiHandler;

public class BCMGuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		if (ID == BattleClassMod.GUI_CLASS_INTERFACE_INV){
			return new BCMInterfaceContainer(player, player.inventory, PlayerClass.get(player).inventory);
		} else {
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		if (ID == BattleClassMod.GUI_CLASS_INTERFACE_INV){
			return new BCMInterfaceInventoryGui(player, player.inventory, PlayerClass.get(player).inventory);
		} else {
			return null;
		}
	}

}
