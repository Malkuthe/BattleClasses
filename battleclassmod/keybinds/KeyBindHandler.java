package battleclassmod.keybinds;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.KeyBindingRegistry;

public class KeyBindHandler {

	public static void Init(){
		KeyBinding[] key = {new KeyBinding("Class Gui", Keyboard.KEY_C)};
			boolean [] repeat = {false};
			KeyBindingRegistry.registerKeyBinding(new ClassGuiKeyBind(key, repeat));
	}
	
	
}
