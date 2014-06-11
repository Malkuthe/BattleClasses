package battleclassmod;

import net.minecraftforge.common.MinecraftForge;
import battleclassmod.items.Items;
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
		Items.init();
	}

	@EventHandler
	public static void Init( FMLInitializationEvent event ){
		
		MinecraftForge.EVENT_BUS.register(new BCMEventHandler());
		
	}
	
	@EventHandler
	public static void postInit( FMLPostInitializationEvent event ){
		
	}
	
}
