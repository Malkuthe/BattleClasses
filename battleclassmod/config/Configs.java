package battleclassmod.config;

public class Configs {
	
	/*
	 * Categories
	 */
	public static final String CATEGORY_ITEMS = "Item ID's";
	public static final String CATEGORY_MESSAGES = "Message Configurations";
	
	/*
	 * Items
	 */
	//Boons
	public static int boonID;
	public static final String boonID_NAME = "Gods' Boon";
	public static final int boonID_DEFAULT = 24201;
	
	/*
	 * Messages
	 */
	
	//Novice Join Class
	public static String noviceJoin;
	public static String noviceJoinCont;
	public static final String noviceJoin_NAME = "Novice Join Message";
	public static final String noviceJoinCont_NAME = "Novice Join Message End";
	public static final String noviceJoin_DEFAULT = "Welcome, Novice, to the Order of the ";
	public static final String noviceJoinCont_DEFAULT = "";
	public static final String noviceJoin_DESC = "First part of the message displayed to novices when they join a class";
	public static final String noviceJoinCont_DESC = "Second part, blank by default";
	
	//Class Change Error Message
	public static String classChangeErr;
	public static String classChangeErrCont;
	public static final String classChangeErr_NAME = "Class Change Error Message";
	public static final String classChangeErrCont_NAME = "Class Change Error Message End";
	public static final String classChangeErr_DEFAULT = "You already belong to the Order of the ";
	public static final String classChangeErrCont_DEFAULT = "";
	public static final String classChangeErr_DESC = "First part of the error message displayed when trying to change to the same class";
	public static final String classChangeErrCont_DESC = "Second part, blank by default";
	
	//Class Change Success Message
	public static String classChange;
	public static String classChangeCont;
	public static final String classChange_NAME = "Class Change Message";
	public static final String classChangeCont_NAME = "Class Change Message End";
	public static final String classChange_DEFAULT = "You have chosen to change paths. The Order of the ";
	public static final String classChangeCont_DEFAULT = " welcomes you";
	public static final String classChange_DESC = "First part of the message displayed on successful class change";
	public static final String classChangeCont_DESC = "Second part";
	
	//Classless Check
	public static String classless;
	public static String classlessCont;
	public static final String classless_NAME = "Classless Check Message";
	public static final String classlessCont_NAME = "Classless Check Message End";
	public static final String classless_DEFAULT = "You do not belong to any order, you are a ";
	public static final String classlessCont_DEFAULT = "";
	public static final String classless_DESC = "Message displayed when checking class without first choosing a class. Comes before 'novice' identification on message";
	public static final String classlessCont_DESC = "Second part. Comes after 'novice' identification on message.";
	
	//Class Check Message
	public static String classCheck;
	public static String classCheckCont;
	public static final String classCheck_NAME = "Class Check Message";
	public static final String classCheckCont_NAME = "Class Check Message End";
	public static final String classCheck_DEFAULT = "You belong to the Order of the ";
	public static final String classCheckCont_DEFAULT = "";
	public static final String classCheck_DESC = "Message displayed when checking class. Comes before 'class' identification on message.";
	public static final String classCheckCont_DESC = "Second part. Comes after 'class' identification on message.";
	
}
