package battleclassmod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod( modid = BCMInfo.ID, name = BCMInfo.NAME, version = BCMInfo.VERSION )
@NetworkMod( channels = BCMInfo.CHANNEL, clientSideRequired = true, serverSideRequired = true )

public class BattleClassMod {
	
	@EventHandler
	public static void preInit( FMLPreInitializationEvent event ){
		
	}

	@EventHandler
	public static void Init( FMLInitializationEvent event ){
		
	}
	
	@EventHandler
	public static void postInit( FMLPostInitializationEvent event ){
		
	}
	
}
