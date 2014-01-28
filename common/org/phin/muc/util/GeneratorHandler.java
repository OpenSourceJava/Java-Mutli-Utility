package org.phin.muc.util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * all of the files generated will be generated from here
 * 
 * @author Zachery Kish
 *
 */
public class GeneratorHandler {

	/**
	 * generates the custom command prompt.
	 * Note that this is method called every time the custom command prompt is launched to ensure
	 * that the generated file is up to date with the settings for it.
	 * 
	 * @param title cmd title
	 * @param color cmd color
	 * @param pointer cmd pointer
	 * @throws FileNotFoundException exception thrown
	 */
	public static void createCustomCMD(String title, String color, String pointer) throws FileNotFoundException {
		PrintWriter print = new PrintWriter("customCMD.bat");
		
		print.println("@echo off");
		print.println("break off");
		
		if (title != null && !title.equals("")) {
			print.println("title " + title);
		} else {
			print.println("title custom command prompt");
		}
		
		if (color != null && !color.equals("")) {
			print.println("color " + color);
		} else {
			print.println("color 0a");
		}
		print.println("cls");
		print.println();
		print.println(":cmd");
		
		if (pointer != null && !pointer.equals("")) {
			print.println("set /p cmd=" + pointer);
		} else {
			print.println("set /p cmd=command$");
		}
		
		print.println();
		print.println("%cmd%");
		print.println("echo.");
		print.println("goto cmd");
		
		print.close();
		
	}
	
}
