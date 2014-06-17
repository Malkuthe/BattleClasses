package battleclassmod.inventories.slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import battleclassmod.BCMInfo;
import battleclassmod.items.BoonItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SlotBoon extends Slot{
	
	private final int slotIndex;

	public SlotBoon(IInventory inventory, int slotIndex, int x, int y) {
		super(inventory, slotIndex, x, y);
		this.slotIndex = slotIndex;
	}
	
	@Override
	public boolean isItemValid(ItemStack itemStack){
		return itemStack.getItem() instanceof BoonItem;
	}
	
	private static final ResourceLocation iconLocation = new ResourceLocation(BCMInfo.ID, "textures/gui/boonslotIcon.png");
	
	public ItemStack getStack(){
		return this.inventory.getStackInSlot(this.slotIndex);
	}
	
	@Override
	public boolean getHasStack(){
		return this.getStack() != null;
	}
	
	@SideOnly(Side.CLIENT)
	public void setBackgroundIconTexture(ResourceLocation texture){
		this.texture = iconLocation;
	}

}
