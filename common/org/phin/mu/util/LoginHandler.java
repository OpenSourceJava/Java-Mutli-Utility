package org.phin.mu.util;

import java.awt.Toolkit;

import javax.security.auth.login.CredentialException;
import javax.swing.JFrame;

import org.phin.mu.frame.AdminMainFrame;
import org.phin.mu.frame.ConsoleFrame;
import org.phin.mu.lib.Strings;

public class LoginHandler {
	
	public static void login(String password, String username) throws CredentialException {
		if ((Strings.ADMIN_PASSWORD.equals(password)) && (Strings.ADMIN_USERNAME.equals(username))) {
			Strings.isAdmin = true;
			
			// console creation
			JFrame frame = new ConsoleFrame();
			frame.setVisible(true);
			
			JFrame frame2 = new AdminMainFrame();
			frame2.setVisible(true);
			
		} else if ((Strings.USERNAME_1.equals(username) && (Strings.PASSWORD_1.equals(password)))) {
			Strings.isAdmin = false;
			
			// console creation
			ConsoleFrame frame = new ConsoleFrame();
			frame.setVisible(true);
			
		} else {
			Toolkit.getDefaultToolkit().beep();
			throw new CredentialException();
		}
	}

}
