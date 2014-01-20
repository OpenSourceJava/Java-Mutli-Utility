package org.phin.mu.lib;

import java.awt.Dimension;

import org.phin.mu.frame.AdminMainFrame;
import org.phin.mu.frame.ConsoleFrame;

public class Strings {
	
	// the height and width of the frames
	public static final int DEFAULT_HEIGHT = 700;
	public static final int DEFAULT_WIDTH = 750;
	
	// user set height and width of the frame
	public static int CURRENT_HEIGHT;
	public static int CURRENT_WIDTH;
	
	// the dimension of the frame (width * height)
	public static final Dimension DEFAULT_DIM = new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	
	// the current frame dimension
	public static Dimension CURRENT_DIM = new Dimension(CURRENT_WIDTH, CURRENT_HEIGHT);
	
	// this is just for simplicity you should probably NOT
	// store passwords and user names in a class but rather a database
	public static final String ADMIN_USERNAME = "admin";
	public static final String ADMIN_PASSWORD = "password123;";
	
	public static final String USERNAME_1 = "leroy46";
	public static final String PASSWORD_1 = "suagar12;";
	
	 // if true the user is a admin otherwise the user is not
	public static boolean isAdmin = false;
	
	// the RGB frame color integers
	public static int RED = 0;
	public static int GREEN = 0;
	public static int BLUE = 0;
	
	// the RGB dialog color integers
	public static int DIALOG_RED = 0;
	public static int DIALOG_GREEN = 0;
	public static int DIALOG_BLUE = 0;
	
	// prompts
	public static boolean logoutPrompt = true; // true by default
	public static boolean exitPrompt = true; // by default
	public static boolean reloadPrompt = false;
	
	// if a log is open isLog will be true otherwise and by default false
	public static boolean isLog = false;
	
	// dialog dimensions
	public static final int DEFAULT_DIALOG_WIDTH = 350;
	public static final int DEFAULT_DIALOG_HEIGHT = 210;
	
	public static final Dimension DEFAULT_DIALOG_DIM = new Dimension(DEFAULT_DIALOG_WIDTH, DEFAULT_DIALOG_HEIGHT);

	// universal reference to a Admin frame (yes i am a noob and i can't make a logout system any other way)
	public static AdminMainFrame adminFrame;
	public static ConsoleFrame consoleFrame;
	
}
