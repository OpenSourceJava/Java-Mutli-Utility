package org.phin.mu.lib;

import java.awt.Dimension;

public class Strings {
	
	// the height and width of the frames
	public static final int DEFAULT_HEIGHT = 700;
	public static final int DEFAULT_WIDTH = 750;
	
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
	
	 // u means under privileged, a means Admin
	public static boolean isAdmin = false;
	
}
