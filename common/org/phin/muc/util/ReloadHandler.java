package org.phin.muc.util;

import org.phin.muc.frame.AdminMainFrame;
import org.phin.muc.frame.ConsoleFrame;
import org.phin.muc.frame.UserMainFrame;
import org.phin.muc.lib.Strings;

public class ReloadHandler {

	public static void reloadUI() {
		if (Strings.isAdmin) {
			if (Strings.adminFrame != null) {
				
				if (Strings.consoleFrame != null) {
					Strings.consoleFrame.dispose();
					Strings.consoleFrame = new ConsoleFrame();
				}
				
				Strings.adminFrame.dispose();
				Strings.adminFrame = new AdminMainFrame();
				
				disposeAll();
				
			}
		} else {
			if (Strings.userFrame != null) {
				Strings.userFrame.dispose();
				Strings.userFrame = new UserMainFrame();
				
				if (Strings.consoleFrame != null) {
					Strings.consoleFrame.dispose();
					Strings.consoleFrame = new ConsoleFrame();
				}
				
				disposeAll();
				
			} 
		}
		
	}
	
	private static void disposeAll() {
		
		// frames
		if (Strings.adminOptions != null) {
			Strings.adminOptions.dispose();
		}
		
		if (Strings.compFrame != null) {
			Strings.compFrame.dispose();
		}
		
		if (Strings.loginFrame != null) {
			Strings.loginFrame.dispose();
		}
		
		if (Strings.messageFrame != null) {
			Strings.messageFrame.dispose();
		}
		
		if (Strings.calculator != null) {
			Strings.calculator.dispose();
		}
		
	}
}
