package battleclassmod;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class BCMPacketHandler implements IPacketHandler {

	public BCMPacketHandler () {
		
	}
	
	@Override
	public void onPacketData( INetworkManager manager, Packet250CustomPayload packet, Player player ){
		if (packet.channel.equals(BCMInfo.CHANNEL)){
			handleExtendedProperties( packet, player );
		}
	}
	
	private void handleExtendedProperties( Packet250CustomPayload packet, Player player){
		DataInputStream inputStream = new DataInputStream( new ByteArrayInputStream(packet.data));
		PlayerClass props = PlayerClass.get((EntityPlayer) player);
		
		try {
			props.setClass(inputStream.readUTF());
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		System.out.println("[PACKET] Class from Packet " + props.getClass());
	}
	
}
