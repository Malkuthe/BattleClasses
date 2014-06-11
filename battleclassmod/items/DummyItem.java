package battleclassmod.items;

import battleclassmod.PlayerClass;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DummyItem extends Item {
	
	public DummyItem(int id){
		super(id);
		setCreativeTab(CreativeTabs.tabCombat);
		setMaxStackSize(1);
		setUnlocalizedName(ItemInfo.dummyItemUnlocalized);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player){
		if (!world.isRemote){
			PlayerClass props = PlayerClass.get(player);
			props.ClassChange("Knight");
		}
		return itemstack;
	}
	
}
