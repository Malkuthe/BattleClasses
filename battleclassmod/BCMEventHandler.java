package battleclassmod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;

public class BCMEventHandler {

	@ForgeSubscribe
	public void onEntityConstructing( EntityConstructing event ){
		if ( event.entity instanceof EntityPlayer && PlayerClass.get( (EntityPlayer) event.entity ) == null){
			PlayerClass.register( (EntityPlayer) event.entity );
		}
		
		if ( event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(PlayerClass.EXT_PROP_NAME) == null){
			event.entity.registerExtendedProperties(PlayerClass.EXT_PROP_NAME, new PlayerClass((EntityPlayer) event.entity) );
		}
	}
	
}
