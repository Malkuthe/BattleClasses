package battleclassmod.items;

import battleclassmod.config.Configs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items {

	public static Item boonItem;
	
	public static void init(){
		boonItem = new BoonItem(Configs.boonID);
	}
	
	public static void addNames() {
		LanguageRegistry.addName(boonItem, ItemInfo.boonItemLocalized);
	}
	
	
}
