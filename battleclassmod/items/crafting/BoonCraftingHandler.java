package battleclassmod.items.crafting;

import java.util.HashMap;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import battleclassmod.items.Items;

public class BoonCraftingHandler {
	
	public static void Init(){
		for (int i = 0; i < 8; ++i){
			ClassHandler.BoonClass(i);
		}
	}

}
