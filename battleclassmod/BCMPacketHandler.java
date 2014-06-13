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
	
	public static final byte PLAYER_CLASS = 1, OPEN_SERVER_GUI = 2;

	public BCMPacketHandler () {
		
	}
	
	@Override
	public void onPacketData( INetworkManager manager, Packet250CustomPayload packet, Player player ){
		DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
		byte packetType;

		try {
			// Read the packet type
			packetType = inputStream.readByte();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		if (packet.channel.equals(BCMInfo.CHANNEL)){
			// Handle each case appropriately:
			switch(packetType) {
				case PLAYER_CLASS: handleExtendedProperties(packet, player, inputStream); break;
				case OPEN_SERVER_GUI: handleOpenServerGui(packet, (EntityPlayer) player, inputStream); break;
				default: System.out.println("[PACKET][WARNING] Unknown packet type " + packetType);
			}
		}
		
	}
	
	private void handleExtendedProperties( Packet250CustomPayload packet, Player player, DataInputStream inputStream){
		PlayerClass props = PlayerClass.get((EntityPlayer) player);
		
		try {
			props.setClass(inputStream.readUTF());
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		System.out.println("[PACKET] Class from Packet " + props.getClass());
	}
	
	private void handleOpenServerGui( Packet250CustomPayload packet, EntityPlayer player, DataInputStream inputStream){
		int guiID;
		
		try {
			guiID = inputStream.readInt();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
			// Now we can open the server gui element:
		player.openGui(BattleClassMod.instance, guiID, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
	}
	
}
