package org.phin.mu.util;

import org.phin.mu.lib.Strings;

public class ColorHandler {
	
	public static void checkColor(String text) {
		if (text.equalsIgnoreCase("black")) {
			Strings.RED = 1;
			Strings.GREEN = 1;
			Strings.BLUE = 1;
		} else if (text.equalsIgnoreCase("blue")) {
			Strings.RED = 1;
			Strings.GREEN = 1;
			Strings.BLUE = 255;
		} else if (text.equalsIgnoreCase("cyan")) {
			Strings.RED = 1;
			Strings.GREEN = 255;
			Strings.BLUE = 255;
		} else if (text.equalsIgnoreCase("darkGray")) {
			Strings.RED = 64;
			Strings.GREEN = 64;
			Strings.BLUE = 64;
		} else if (text.equalsIgnoreCase("gray")) {
			Strings.RED = 128;
			Strings.GREEN = 128;
			Strings.BLUE = 128;
		} else if (text.equalsIgnoreCase("green")) {
			Strings.RED = 1;
			Strings.GREEN = 255;
			Strings.BLUE = 1;
		} else if (text.equalsIgnoreCase("lightGray")) {
			Strings.RED = 192;
			Strings.GREEN = 192;
			Strings.BLUE = 192;
		} else if (text.equalsIgnoreCase("magenta")) {
			Strings.RED = 255;
			Strings.GREEN = 1;
			Strings.BLUE = 255;
		} else if (text.equalsIgnoreCase("orange")) {
			Strings.RED = 255;
			Strings.GREEN = 200;
			Strings.BLUE = 255;
		} else if (text.equalsIgnoreCase("pink")) {
			Strings.RED = 255;
			Strings.GREEN = 175;
			Strings.BLUE = 175;
		} else if (text.equalsIgnoreCase("red")) {
			Strings.RED = 255;
			Strings.GREEN = 1;
			Strings.BLUE = 1;
		} else if (text.equalsIgnoreCase("white")) {
			Strings.RED = 255;
			Strings.GREEN = 255;
			Strings.BLUE = 255;
		} else if (text.equalsIgnoreCase("yellow")) {
			Strings.RED = 255;
			Strings.GREEN = 255;
			Strings.BLUE = 1;
		}
	}

}
