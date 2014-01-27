package org.phin.muc.util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GeneratorHandler {

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
