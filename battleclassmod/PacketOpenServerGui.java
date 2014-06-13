package battleclassmod;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.network.packet.Packet250CustomPayload;

public class PacketOpenServerGui {
	public static Packet250CustomPayload getPacket(int guiID){
		ByteArrayOutputStream bos = new ByteArrayOutputStream(5);
		DataOutputStream outputStream = new DataOutputStream(bos);
		
		try {
			// Notice this first line writes the packet id - do this in your ExtendedPlayer.sync() method as well and add 1 to the size.
			outputStream.writeByte(BCMPacketHandler.OPEN_SERVER_GUI);
			outputStream.writeInt(guiID);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	
		return new Packet250CustomPayload(BCMInfo.CHANNEL, bos.toByteArray());
	}
	
}