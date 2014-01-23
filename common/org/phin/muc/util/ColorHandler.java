package org.phin.muc.util;

import org.phin.muc.lib.UserSettings;

public class ColorHandler {
	
	public static void checkColor(String text) {
		if (text.equalsIgnoreCase("black")) {
			UserSettings.RED = 1;
			UserSettings.GREEN = 1;
			UserSettings.BLUE = 1;
		} else if (text.equalsIgnoreCase("blue")) {
			UserSettings.RED = 1;
			UserSettings.GREEN = 1;
			UserSettings.BLUE = 255;
		} else if (text.equalsIgnoreCase("cyan")) {
			UserSettings.RED = 1;
			UserSettings.GREEN = 255;
			UserSettings.BLUE = 255;
		} else if (text.equalsIgnoreCase("darkGray")) {
			UserSettings.RED = 64;
			UserSettings.GREEN = 64;
			UserSettings.BLUE = 64;
		} else if (text.equalsIgnoreCase("gray")) {
			UserSettings.RED = 128;
			UserSettings.GREEN = 128;
			UserSettings.BLUE = 128;
		} else if (text.equalsIgnoreCase("green")) {
			UserSettings.RED = 1;
			UserSettings.GREEN = 255;
			UserSettings.BLUE = 1;
		} else if (text.equalsIgnoreCase("lightGray")) {
			UserSettings.RED = 192;
			UserSettings.GREEN = 192;
			UserSettings.BLUE = 192;
		} else if (text.equalsIgnoreCase("magenta")) {
			UserSettings.RED = 255;
			UserSettings.GREEN = 1;
			UserSettings.BLUE = 255;
		} else if (text.equalsIgnoreCase("orange")) {
			UserSettings.RED = 255;
			UserSettings.GREEN = 200;
			UserSettings.BLUE = 255;
		} else if (text.equalsIgnoreCase("pink")) {
			UserSettings.RED = 255;
			UserSettings.GREEN = 175;
			UserSettings.BLUE = 175;
		} else if (text.equalsIgnoreCase("red")) {
			UserSettings.RED = 255;
			UserSettings.GREEN = 1;
			UserSettings.BLUE = 1;
		} else if (text.equalsIgnoreCase("white")) {
			UserSettings.RED = 255;
			UserSettings.GREEN = 255;
			UserSettings.BLUE = 255;
		} else if (text.equalsIgnoreCase("yellow")) {
			UserSettings.RED = 255;
			UserSettings.GREEN = 255;
			UserSettings.BLUE = 1;
		}
	}

}
