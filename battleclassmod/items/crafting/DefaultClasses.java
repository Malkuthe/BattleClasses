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
			ItemStack itemstack = new ItemStack(Items.songsItem, 1, i);
			songs[i] = itemstack;
		}
	}
	
	public static String[] defaultClasses = {
		"Squire", "Apprentice", "Thief", "Archer",
		"Knight", "Mage", "Rogue", "Hunter"
	};

	public static Object[][] classRecipes = {
		//Squire
		{songs[0],songs[0],songs[1],songs[1]},
		//Apprentice
		{songs[0],songs[0],songs[5],songs[5]},
		//Thief
		{songs[0],songs[0],songs[6],songs[6]},
		//Archer
		{songs[0],songs[0],songs[7],songs[7]},
		//Knight
		{songs[0],songs[1],songs[10],songs[11]},
		//Mage
		{songs[0],songs[4],songs[5],songs[11]},
		//Rogue
		{songs[0],songs[6],songs[8],songs[11]},
		//Hunter
		{songs[0],songs[7],songs[10],songs[11]}
	};
	
	Item boonItem = Items.boonItem;
}
