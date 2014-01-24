package org.phin.muc.lib;

public class UserSettings {
	
	// the RGB frame color integers
	public static int RED = 90;
	public static int GREEN = 90;
	public static int BLUE = 90;
	
	// the RGB dialog color integers
	public static int DIALOG_RED = 64;
	public static int DIALOG_GREEN = 64;
	public static int DIALOG_BLUE = 64;
	
	// prompt values
	public static boolean logoutPrompt = true; 
	public static boolean exitPrompt = true; 
	public static boolean reloadPrompt = true;

	// menu bar values
	// this allows users to determine which menuBars to enable or disable
	// and ensures that the menu Handler knows what to do
	public static boolean menuBar = true;
	public static boolean fileMenu = true;
	public static boolean editMenu = true;
	public static boolean helpMenu = true;
	public static boolean appMenu = true;
	public static boolean windowMenu = true;
	
	// save text value
	public static boolean saveLogText = true;
	
}
