package org.phin.muc.util;

import java.awt.Toolkit;

import javax.security.auth.login.CredentialException;

import org.phin.muc.frame.AdminMainFrame;
import org.phin.muc.frame.ConsoleFrame;
import org.phin.muc.frame.UserMainFrame;
import org.phin.muc.lib.Strings;

public class LoginHandler {
	
	public static void login(String password, String username) throws CredentialException {
		if ((Strings.ADMIN_PASSWORD.equals(password)) && (Strings.ADMIN_USERNAME.equals(username))) {
			Strings.isAdmin = true;
			
			// frame creation
			Strings.consoleFrame = new ConsoleFrame();
			Strings.adminFrame = new AdminMainFrame();
			
		} else if ((Strings.USERNAME_1.equals(username) && (Strings.PASSWORD_1.equals(password)))) {
			Strings.isAdmin = false;
			
			// console creation
			Strings.consoleFrame = new ConsoleFrame();
			Strings.userFrame = new UserMainFrame();
			
		} else {
			Toolkit.getDefaultToolkit().beep();
			throw new CredentialException();
		}
	}

}
