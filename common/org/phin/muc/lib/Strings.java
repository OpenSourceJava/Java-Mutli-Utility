package org.phin.muc.lib;

import java.awt.Dimension;

import org.phin.cb1.frame.ChatBotFrame;
import org.phin.deskcalc.frame.BasicCalculatorFrame;
import org.phin.muc.dialog.DialogOptionsDialog;
import org.phin.muc.dialog.DisableFileDialog;
import org.phin.muc.dialog.DisableMenuDialog;
import org.phin.muc.dialog.ExitDialog;
import org.phin.muc.dialog.LogDialog;
import org.phin.muc.dialog.LogoutDialog;
import org.phin.muc.dialog.MenuDialog;
import org.phin.muc.dialog.RGBDialog;
import org.phin.muc.dialog.ReloadDialog;
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
	
	// prompt values
	public static boolean logoutPrompt = true; // true by default
	public static boolean exitPrompt = true; // by default
	public static boolean reloadPrompt = false;
	
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
	public static LogFrame log;
	public static UserMainFrame userFrame;
	
	// global apps
	public static BasicCalculatorFrame calculator;
	public static ChatBotFrame chatBot;
	
	// universal dialogs
	public static LogDialog logDialog;
	public static LogoutDialog logoutDialog;
	public static DialogOptionsDialog dialogOptions;
	public static DisableFileDialog disableFile;
	public static DisableMenuDialog disableMenu;
	public static ExitDialog exitDialog;
	public static MenuDialog menuDialog;
	public static RGBDialog rgbDialog;
	public static ReloadDialog reloadDialog;
	
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
