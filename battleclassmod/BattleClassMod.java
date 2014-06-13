package battleclassmod;

import net.minecraftforge.common.MinecraftForge;
import battleclassmod.commands.CommandHandler;
import battleclassmod.config.ConfigHandler;
import battleclassmod.guis.BCMGuiHandler;
import battleclassmod.items.Items;
import battleclassmod.keybinds.KeyBindHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod( modid = BCMInfo.ID, name = BCMInfo.NAME, version = BCMInfo.VERSION )
@NetworkMod( channels = {BCMInfo.CHANNEL}, clientSideRequired = true, serverSideRequired = true, packetHandler = BCMPacketHandler.class )

public class BattleClassMod {
	
	private static int modGuiIndex = 0;
	public static final int GUI_CLASS_INTERFACE_INV = modGuiIndex++;
	
	@Instance(BCMInfo.ID)
	public static BattleClassMod instance = new BattleClassMod();
	
	@EventHandler
	@SideOnly(Side.CLIENT)
	public void clientPreInit( FMLPreInitializationEvent event ){
		KeyBindHandler.Init();
	}
	
	@EventHandler
	public void preInit( FMLPreInitializationEvent event ){
		ConfigHandler.Init(event.getSuggestedConfigurationFile());
		Items.init();
		NetworkRegistry.instance().registerGuiHandler(this, new BCMGuiHandler());
	}

	@EventHandler
	public void Init( FMLInitializationEvent event ){
		
		MinecraftForge.EVENT_BUS.register(new BCMEventHandler());
		
	}
	
	@EventHandler
	public void serverStart( FMLServerStartingEvent event ){
		CommandHandler.Init();
	}
	
	@EventHandler
	public void postInit( FMLPostInitializationEvent event ){
		
	}
	
	@SidedProxy( clientSide = BCMInfo.PROXY_LOCATION + ".ClientProxy", serverSide = BCMInfo.PROXY_LOCATION + ".CommonProxy" )
	public static CommonProxy proxy;
}
