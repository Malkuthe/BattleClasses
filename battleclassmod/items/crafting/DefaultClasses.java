package battleclassmod.items.crafting;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import battleclassmod.config.Configs;
import battleclassmod.items.Items;

public class DefaultClasses {
	
	private static final int CLASSES_NUMBER = Configs.classNumber;
	public static final int SONGS_NUMBER = 12;
	
	public static Object[] songs;
	
	/*
	 * 0 - Song of Virtue
	 * 1 - Song of Courage
	 * 2 - Song of Rage
	 * 3 - Song of Healing
	 * 4 - Song of Wisdom
	 * 5 - Song of Knowledge
	 * 6 - Song of Celerity
	 * 7 - Song of Acuity
	 * 8 - Song of Agility
	 * 9 - Song of Strength
	 * 10 - Song of Might
	 * 11 - Song of Divinity
	 */
	
	public void Songs(){
		for(int i = 0; i < SONGS_NUMBER; ++i){
			ItemStack itemstack = new ItemStack(Configs.songsID, 1, i);
			songs[i] = itemstack;
		}
	}
	
	public static Object[][] classRecipes;
	
	public void Recipes(){
		//Squire
		classRecipes[0][0] = songs[0];
		classRecipes[0][1] = songs[0];
		classRecipes[0][2] = songs[1];
		classRecipes[0][3] = songs[1];
		
		//Apprentice
		classRecipes[1][0] = songs[0];
		classRecipes[1][1] = songs[0];
		classRecipes[1][2] = songs[5];
		classRecipes[1][3] = songs[5];
		
		//Thief
		classRecipes[2][0] = songs[0];
		classRecipes[2][1] = songs[0];
		classRecipes[2][2] = songs[6];
		classRecipes[2][3] = songs[6];
		
		//Archer
		classRecipes[3][0] = songs[0];
		classRecipes[3][1] = songs[0];
		classRecipes[3][2] = songs[7];
		classRecipes[3][3] = songs[7];
		
		//Knight
		classRecipes[4][0] = songs[0];
		classRecipes[4][1] = songs[11];
		classRecipes[4][2] = songs[1];
		classRecipes[4][3] = songs[10];
		
		//Mage
		classRecipes[5][0] = songs[0];
		classRecipes[5][1] = songs[4];
		classRecipes[5][2] = songs[5];
		classRecipes[5][3] = songs[11];
		
		//Rogue
		classRecipes[6][0] = songs[0];
		classRecipes[6][1] = songs[6];
		classRecipes[6][2] = songs[8];
		classRecipes[6][3] = songs[11];
		
		//Hunter
		classRecipes[7][0] = songs[0];
		classRecipes[7][1] = songs[7];
		classRecipes[7][2] = songs[10];
		classRecipes[7][3] = songs[11];
		
	}
	
	Item boonItem = Items.boonItem;
	
	public static String[] defaultClasses = {
			"Squire", "Apprentice", "Thief", "Archer",
			"Knight", "Mage", "Rogue", "Hunter"
	};
	
	public DefaultClasses(){
		
	}
	
	
	
	

}
