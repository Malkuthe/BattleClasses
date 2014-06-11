package battleclassmod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class PlayerClass implements IExtendedEntityProperties {

	public final static String EXT_PROP_NAME = "PlayerClass";
	private final EntityPlayer player;
	private String playerClass;
	
	public PlayerClass( EntityPlayer player ){
		this.player = player;
		this.playerClass = "classless";
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
	 * methods to interact with new variables
	 */
	
	//changes class
	public void ClassChange( String bcm ){
		if ( this.playerClass.equals("classless") ) {
			this.playerClass = bcm;
			player.addChatMessage("Welcome, novice, into the ranks of the Order of the " + EnumChatFormatting.RED + this.playerClass );
			
			//debug
			System.out.println("[PlayerClasses] class chosen confirmed");
		} else if( this.playerClass.equals(bcm) ){
			player.addChatMessage("You already belong to the Order of the " + EnumChatFormatting.RED + this.playerClass);
		} else {
			this.playerClass = bcm;
			player.addChatMessage("You have chosen to change your path. The Order of the " + EnumChatFormatting.RED + this.playerClass);
			
			//debug
			System.out.println("[PlayerClasses] class change confirmed");
		}
	}
	
	public void ClassCheck(){
		if ( this.playerClass.equals("classless") ) {
			player.addChatMessage("You are not a member of any Order, you are " + EnumChatFormatting.RED + "classless");
		} else {
			player.addChatMessage("You belong to the Order of the " + EnumChatFormatting.RED + this.playerClass);
		}
	}
}
