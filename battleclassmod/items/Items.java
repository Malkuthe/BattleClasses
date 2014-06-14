package battleclassmod.items;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import battleclassmod.BCMInfo;
import battleclassmod.config.Configs;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items {

	public static Item boonItem;
	
	public static void init(){
		boonItem = new BoonItem(Configs.boonID).setTextureName(BCMInfo.ID + ":" + ItemInfo.boonItemUnlocalized);
	}
	
	public static void addNames() {
		LanguageRegistry.addName(boonItem, ItemInfo.boonItemLocalized);
	}
	
	
}
