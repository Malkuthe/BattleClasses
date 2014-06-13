package battleclassmod.keybinds;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;

import org.lwjgl.input.Keyboard;

import battleclassmod.BCMPacketHandler;
import battleclassmod.BattleClassMod;
import battleclassmod.PacketOpenServerGui;
import battleclassmod.inventories.containers.BCMInterfaceContainer;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class KeyBindHandler extends KeyHandler{
	
	private final Minecraft mc;
	public static final String label = "Class Interface Key";
	public static final int CLASS_INTERFACE = 0;
	private static final String[] desc = {"Class Interface"};
	private static final int[] keyValues = {Keyboard.KEY_N};
	public static final KeyBinding[] keys = new KeyBinding[desc.length];
	
	public static void Init(){
		boolean[] repeat = new boolean[desc.length];
				for (int i = 0; i < desc.length; ++i){
					keys[i] = new KeyBinding(desc[i], keyValues[i]);
					repeat[i] = false;
				}
		KeyBindingRegistry.registerKeyBinding( new KeyBindHandler(keys, repeat));		
	}
	
	private KeyBindHandler(KeyBinding[] keyBindings, boolean[] repeatings){
		super(keyBindings, repeatings);
		this.mc = Minecraft.getMinecraft();
	}

	@Override
	public String getLabel() {
		return this.label;
	}

	@Override
	public void keyDown(EnumSet<TickType> types, KeyBinding kb,
			boolean tickEnd, boolean isRepeat) {
		EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;
		if (tickEnd) {
			if (mc.inGameHasFocus){
				if (kb == keys[CLASS_INTERFACE]){
					PacketOpenServerGui.getPacket(BattleClassMod.GUI_CLASS_INTERFACE_INV);
				}
			} else {
				if (kb == keys[CLASS_INTERFACE] && player.openContainer instanceof BCMInterfaceContainer){
					player.closeScreen();
				}
			}
		}
		
	}

	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {
		
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.PLAYER);
	}
	
	
}
