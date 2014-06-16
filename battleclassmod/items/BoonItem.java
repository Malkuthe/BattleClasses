package battleclassmod.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import battleclassmod.BCMInfo;
import battleclassmod.BattleClassMod;
import battleclassmod.PlayerClass;
import battleclassmod.config.Configs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BoonItem extends Item {
	
	public BoonItem(int id){
		super(id);
		setCreativeTab(BattleClassMod.tabCustom);
		setMaxStackSize(1);
		setUnlocalizedName(ItemInfo.boonItemUnlocalized);
	}
	
	public void onItemCreated(ItemStack itemstack, World world, EntityPlayer player){
		itemstack.stackTagCompound = new NBTTagCompound();
	}

	public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean j){
		if (itemstack.stackTagCompound == null){
			itemstack.setTagCompound(new NBTTagCompound());
			itemstack.stackTagCompound.setString("Owner", "none");
			itemstack.stackTagCompound.setString("Class", Configs.defaultClass);
		}
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
					if(properties.getString("Class") == null){
						props.ClassChange(Configs.defaultClass);
					} else {
						props.ClassChange(properties.getString("Class"));
					}
				}
			} else {
				
			}
				
		}
		return itemstack;
	}
	
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
		this.itemIcon = iconIndex[0];
		if (properties != null){
			if (properties.getString("Owner") != null && !properties.getString("Owner").equals("none")){
				return iconIndex[1];
			} 
			return iconIndex[0];
		}
		return this.itemIcon;
			
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconIndex(ItemStack itemstack){
		NBTTagCompound properties = itemstack.stackTagCompound;
		this.itemIcon = iconIndex[0];
		if (properties != null){
			if (properties.getString("Owner") != null && !properties.getString("Owner").equals("none")){
				return iconIndex[1];
			} 
			return iconIndex[0];
		}
		return this.itemIcon;
	}
	
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean bool){
		
	}
	
}
