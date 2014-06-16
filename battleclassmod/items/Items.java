package battleclassmod.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import battleclassmod.BCMInfo;
import battleclassmod.config.Configs;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Items{

	public static Item boonItem;
	
	public static void init(){
		boonItem = new BoonItem(Configs.boonID);
	}
	
	public static void addNames() {
		LanguageRegistry.addName(boonItem, ItemInfo.boonItemLocalized);
	}
	
	
}
