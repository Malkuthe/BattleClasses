package battleclassmod.keybinds;

import java.util.EnumSet;

import net.minecraft.client.settings.KeyBinding;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class ClassGuiKeyBind extends KeyHandler {
	
	private EnumSet tickTypes = EnumSet.of(TickType.CLIENT);
	
	public ClassGuiKeyBind(KeyBinding[] keyBindings, boolean[] repeatings){
		super(keyBindings, repeatings);
	}

	@Override
	public String getLabel() {
		return "[BCM] Class Interface";
	}

	@Override
	public void keyDown(EnumSet<TickType> types, KeyBinding kb,
			boolean tickEnd, boolean isRepeat) {
		
		//on keypress down
		
	}

	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {

		//on keyrelease up
		
	}

	@Override
	public EnumSet<TickType> ticks() {
		return tickTypes;
	}

}
