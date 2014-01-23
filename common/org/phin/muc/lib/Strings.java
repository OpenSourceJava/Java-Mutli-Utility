package org.phin.muc.lib;

import java.awt.Dimension;

import org.phin.deskcalc.frame.BasicCalculatorFrame;
import org.phin.muc.frame.AdminMainFrame;
import org.phin.muc.frame.AdminOptionsFrame;
import org.phin.muc.frame.ComputerFrame;
import org.phin.muc.frame.ConsoleFrame;
import org.phin.muc.frame.LogFrame;
import org.phin.muc.frame.LoginFrame;
import org.phin.muc.frame.UserMainFrame;

public class Strings {
	
	// the height and width of the frames
	public static final int DEFAULT_HEIGHT = 700;
	public static final int DEFAULT_WIDTH = 750;
	
	// the dimension of the frame (width * height)
	public static final Dimension DEFAULT_DIM = new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);

	// this is just for simplicity you should probably NOT
	// store passwords and user names in a class but rather a database
	public static final String ADMIN_USERNAME = "admin";
	public static final String ADMIN_PASSWORD = "password123;";
	
	public static final String USERNAME_1 = "leroy46";
	public static final String PASSWORD_1 = "sugar12;";
	
	// dialog dimensions
	public static final int DEFAULT_DIALOG_WIDTH = 350;
	public static final int DEFAULT_DIALOG_HEIGHT = 210;
	
	public static final Dimension DEFAULT_DIALOG_DIM = new Dimension(DEFAULT_DIALOG_WIDTH, DEFAULT_DIALOG_HEIGHT);

	// universal frames for managing what is open where easily 
	public static AdminMainFrame adminFrame;
	public static AdminOptionsFrame adminOptions;
	public static ComputerFrame compFrame;
	public static LoginFrame loginFrame;
	public static ConsoleFrame consoleFrame;
	public static LogFrame messageFrame;
	public static UserMainFrame userFrame;
	
	// global apps
	public static BasicCalculatorFrame calculator;
	
	// if true the user is a admin otherwise the user is not
	// be default and for obvious reasons the default is false.
	public static boolean isAdmin = false;
	
}
