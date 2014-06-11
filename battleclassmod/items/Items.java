package battleclassmod.items;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items {

	public static Item dummyItem;
	
	public static void init(){
		dummyItem = new DummyItem(ItemInfo.dummyItemDefault);
	}
	
	public static void addNames() {
		LanguageRegistry.addName(dummyItem, ItemInfo.dummyItemLocalized);
	}
	
	
}
