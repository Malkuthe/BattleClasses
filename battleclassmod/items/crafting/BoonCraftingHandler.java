package battleclassmod.items.crafting;

import java.util.HashMap;

import net.minecraft.item.Item;
import battleclassmod.items.Items;

public class BoonCraftingHandler {
	
	public static final int NUMBER_OF_CLASSES = 4;
	
	public static void Init(){
		
		Item boonStack = Items.boonItem;
		Item dummy = Items.boonItem;
		Item blargh = Items.boonItem;
		
		String[] classNames = {
			"Knight", "Thief", "Mage", "Archer"
		};
		
		String[] classKeys = new String[NUMBER_OF_CLASSES]; 
		for (int i = 0; i < NUMBER_OF_CLASSES; ++i){
			classKeys[i] = classNames[i];
		};
		
		Object[][] classRecipes = new Object[NUMBER_OF_CLASSES][];
		classRecipes[0][0] = boonStack;
		classRecipes[0][1] = boonStack;
		classRecipes[0][2] = boonStack;
		classRecipes[0][3] = boonStack;
		
		classRecipes[1][0] = boonStack;
		classRecipes[1][1] = boonStack;
		classRecipes[1][2] = dummy;
		classRecipes[1][3] = dummy;
		
		classRecipes[2][0] = boonStack;
		classRecipes[2][1] = boonStack;
		classRecipes[2][2] = blargh;
		classRecipes[2][3] = blargh;
		
		classRecipes[3][0] = dummy;
		classRecipes[3][1] = dummy;
		classRecipes[3][2] = blargh;
		classRecipes[3][3] = blargh;
		
		
		HashMap<String, Object> classmap = new HashMap<String, Object>();
		for (int i = 0; i < NUMBER_OF_CLASSES; ++i){
			classmap.put(classKeys[i], classRecipes[i]);
		}
		
		for (int i = 0; i < NUMBER_OF_CLASSES; ++i){
			if (classmap.containsKey(classKeys[i])){
				classmap.get(classKeys[i]);
				Object[] items = new Object[4];
				for (int j = 0; j < 4; ++j) {
					items[j] = classRecipes[i][j];
				}
			}
		}
	}

}
