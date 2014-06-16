package battleclassmod.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import battleclassmod.BCMInfo;
import battleclassmod.PlayerClass;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BoonItem extends Item {
	
	public BoonItem(int id){
		super(id);
		setCreativeTab(CreativeTabs.tabCombat);
		setMaxStackSize(1);
		setUnlocalizedName(ItemInfo.boonItemUnlocalized);
	}
	
	public void onItemCreated(ItemStack itemstack, World world, EntityPlayer player){
		itemstack.stackTagCompound = new NBTTagCompound();
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player){
		NBTTagCompound properties = itemstack.stackTagCompound;
		String owner = properties.getString("Owner");
		System.out.println(owner);
		if (!world.isRemote && itemstack != null){
			if(player.isSneaking()){
				if(!owner.equals(player.username) && owner.equals("none")){
					properties.setString("Owner", player.username);
					String newowner = properties.getString("Owner");
					System.out.println("Boon Owner set to:" + newowner);
				} else if (!owner.equals(player.username) && !owner.equals("none")){
					
				} else if (owner.equals(player.username)){
					PlayerClass props = PlayerClass.get(player);
					props.ClassChange("Knight");
				}
			} else {
				
			}
				
		}
		return itemstack;
	}
	
	public void OnUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean j){
		NBTTagCompound properties = itemstack.stackTagCompound;
		if (properties.getString("Owner").isEmpty()){
			properties.setString("Owner", "none");
		}
	};
	
	private Icon[] iconIndex;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register){
		
		iconIndex = new Icon[2];
		
		//registering the two icons
		iconIndex[0] = register.registerIcon(BCMInfo.ID + ":" + ItemInfo.boonItemUnlocalized);
		System.out.println(iconIndex[0]);
		iconIndex[1] = register.registerIcon(BCMInfo.ID + ":" + ItemInfo.boonItemUnlocalized + "Active");
		System.out.println(iconIndex[1]);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(ItemStack itemstack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining){
		NBTTagCompound properties = itemstack.stackTagCompound;
		if (!properties.getString("Owner").equals("none")){
			this.itemIcon = iconIndex[1];
			return iconIndex[1];
		} 
			this.itemIcon = iconIndex[0];
			return iconIndex[0];
	}
	
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean bool){
		
	}
	
}
