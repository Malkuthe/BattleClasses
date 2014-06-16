package battleclassmod.items.crafting;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import battleclassmod.config.Configs;
import battleclassmod.items.Items;
import cpw.mods.fml.common.registry.GameRegistry;

public class ClassHandler {
	
	private static final int CLASSES_NUMBER = Configs.classNumber;
	private static final int INGREDIENTS_NUMBER = 4;
	
	static ItemStack gold = new ItemStack(Item.ingotGold);
	static ItemStack heart = new ItemStack(Items.songsItem,1,0);
	private static Object[][] classRecipe = new Object[CLASSES_NUMBER][];
	private static String[] boonClass;
	
	public static void BoonClass(int classnum){
		boonClass = DefaultClasses.defaultClasses;
		String bcmBoonClass = boonClass[classnum];
		
		for (int i = 0; i < INGREDIENTS_NUMBER; ++i){
			classRecipe[classnum][i] = DefaultClasses.classRecipes[classnum][i];
		}
		
		ItemStack boonItem = new ItemStack(Items.boonItem);
		NBTTagCompound properties = boonItem.stackTagCompound;
		properties.setString("Class", bcmBoonClass);
		
		GameRegistry.addRecipe(boonItem, "xax", "boc", "xdx", 'x', gold, 'o', heart, 'a', classRecipe[classnum][1],
				'b', classRecipe[classnum][2], 'c', classRecipe[classnum][3], 'd',classRecipe[classnum][4]);
		System.out.println("Added Recipe");
	}

}
