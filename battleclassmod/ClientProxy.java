package battleclassmod;

import battleclassmod.keybinds.KeyBindHandler;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenderers() {
		KeyBindHandler.Init();
	}

}
