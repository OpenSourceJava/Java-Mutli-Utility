package org.phin.muc.util;

import java.awt.Toolkit;

import javax.security.auth.login.CredentialException;

import org.phin.muc.frame.AdminMainFrame;
import org.phin.muc.frame.ConsoleFrame;
import org.phin.muc.frame.LoginFrame;
import org.phin.muc.frame.UserMainFrame;
import org.phin.muc.lib.Strings;
import org.phin.muc.lib.UserSettings;

public class LoginHandler {
	
	public static void login(String password, String username) throws CredentialException {
		if ((Strings.ADMIN_PASSWORD.equals(password)) && (Strings.ADMIN_USERNAME.equals(username))) {
			Strings.isAdmin = true;
			
			// frame creation
			Strings.consoleFrame = new ConsoleFrame();
			Strings.adminFrame = new AdminMainFrame();
			
		} else if ((Strings.USERNAME_1.equals(username) && (Strings.PASSWORD_1.equals(password)))) {
			Strings.isAdmin = false;
			
			if (UserSettings.userConsole) {
				Strings.consoleFrame = new ConsoleFrame();
			}
			
			// console creation
			Strings.userFrame = new UserMainFrame();
			
		} else {
			Toolkit.getDefaultToolkit().beep();
			throw new CredentialException();
		}
	}
	
	public static void logout() {
		if (Strings.isAdmin) {
			if (Strings.adminOptions != null) {
				Strings.adminOptions.dispose();
			}
			
			if (Strings.compFrame != null) {
				Strings.compFrame.dispose();
			}
			
			Strings.adminFrame.dispose();
		
		} else {
			if (Strings.userFrame != null) {
				Strings.userFrame.dispose();
			}
		}
		
		if (Strings.messageFrame != null) {
			Strings.messageFrame.dispose();
		}
		
		if (Strings.calculator != null) {
			Strings.calculator.dispose();
		}
		
		if (Strings.consoleFrame != null) {
			Strings.consoleFrame.dispose();
		}
		
		LoginFrame frame = new LoginFrame();
		frame.setVisible(true);
		
	}

}
