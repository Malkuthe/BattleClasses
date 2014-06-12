package battleclassmod;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import battleclassmod.config.Configs;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class PlayerClass implements IExtendedEntityProperties {

	public final static String EXT_PROP_NAME = "PlayerClass";
	private final EntityPlayer player;
	private String playerClass;
	
	public PlayerClass( EntityPlayer player ){
		this.player = player;
		this.playerClass = "Novice";
	}
	
	//Just for code cleanliness according to the tutorial
	
	public static final void register( EntityPlayer player ){
		player.registerExtendedProperties( PlayerClass.EXT_PROP_NAME, new PlayerClass(player) );
	}
	
	public static final PlayerClass get(EntityPlayer player){
		return (PlayerClass) player.getExtendedProperties(EXT_PROP_NAME);
	}
	
	//required overrides
	
	@Override
	public void saveNBTData( NBTTagCompound compound ){
	
		//creating new tag compound to store class properties
		NBTTagCompound bcmClass = new NBTTagCompound();
		
		//setting variables
		bcmClass.setString("PlayerClass", this.playerClass);
		
		//adding custom tag to player's tag
		compound.setTag(EXT_PROP_NAME, bcmClass);
		
		//debug
		System.out.println("[PlayerClasses] saving class " + this.playerClass);
	}
	
	@Override
	public void loadNBTData( NBTTagCompound compound ){
		
		//fetching tag compound
		NBTTagCompound bcmClass = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		
		//retrieving data from tag compound
		this.playerClass = bcmClass.getString("PlayerClass");
		
		//debug
		System.out.println("[PlayerClasses] loading class " + this.playerClass);
	}
	
	@Override
	public void init( Entity entity, World world ){
		
	}
	
	/*
	 * Syncing
	 */
	public final void syncProperties(){
		ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
		DataOutputStream outputStream = new DataOutputStream(bos);
		
		try {
			outputStream.writeUTF(this.playerClass);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		Packet250CustomPayload packet = new Packet250CustomPayload( BCMInfo.CHANNEL, bos.toByteArray() );
		
		if (!player.worldObj.isRemote) {
			EntityPlayerMP player1 = (EntityPlayerMP) player;
			PacketDispatcher.sendPacketToPlayer(packet, (Player) player1);
		}
	}
	
	//Sets Class
	public final void setClass(String bcm){
		this.playerClass = bcm;
		this.syncProperties();
	}
	
	/*
	 * Methods to save/load data from CommonProxy
	 */
	public static String getSaveKey( EntityPlayer player ){
		return player.username + ":" + EXT_PROP_NAME;
	}
	
	public static void saveProxyData( EntityPlayer player ){
		PlayerClass playerData = PlayerClass.get(player);
		NBTTagCompound savedData = new NBTTagCompound();
		
		playerData.saveNBTData(savedData);
		
		CommonProxy.storeEntityData(getSaveKey(player), savedData);
	}
	
	public static void loadProxyData( EntityPlayer player ){
		PlayerClass playerData = PlayerClass.get(player);
		NBTTagCompound savedData = CommonProxy.getEntityData(getSaveKey(player));
		
		if ( savedData != null ){
			playerData.loadNBTData(savedData);
		}
		
		playerData.syncProperties();
	}
	
	/*
	 * methods to interact with new variables
	 */
	
	//changes class
	public void ClassChange( String bcm ){
		if ( this.playerClass.equals("Novice") ) {
			this.playerClass = bcm;
			player.addChatMessage( Configs.noviceJoin + EnumChatFormatting.RED + this.playerClass + EnumChatFormatting.RESET + Configs.noviceJoinCont );
			
			//debug
			System.out.println("[PlayerClasses] class chosen confirmed");
		} else if( this.playerClass.equals(bcm) ){
			player.addChatMessage( Configs.classChangeErr + EnumChatFormatting.RED + this.playerClass + EnumChatFormatting.RESET + Configs.classChangeErrCont);
		} else {
			this.playerClass = bcm;
			player.addChatMessage( Configs.classChange + EnumChatFormatting.RED + this.playerClass + EnumChatFormatting.RESET + Configs.classChangeCont);
			
			//debug
			System.out.println("[PlayerClasses] class change confirmed");
		}
	}
	
	public void ClassCheck(){
		if ( this.playerClass.equals("Novice") ) {
			player.addChatMessage( Configs.classless + EnumChatFormatting.RED + this.playerClass + EnumChatFormatting.RESET + Configs.classlessCont);
		} else {
			player.addChatMessage( Configs.classCheck + EnumChatFormatting.RED + this.playerClass + EnumChatFormatting.RESET + Configs.classCheckCont);
		}
	}
}
