package org.phin.muc.frame;

import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.security.auth.login.CredentialException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.phin.muc.util.LAFHandler;
import org.phin.muc.util.LoginHandler;

public class LoginFrame extends MultiUtilityFrame {

	private static final long serialVersionUID = 1L;
	
	// Component fields/variables 
	private JPanel contentPane;
	private JTextField userNameField;
	private JPasswordField passwordField;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblVisiblePassword;
	private JButton btnViewPassword;
	private JTextField visiblePasswordField;
	private JButton btnLogin;

	public LoginFrame() {
		// sets look and feel
		LAFHandler.setNativeLookAndFeel();
		
		// creates the gui
		this.createGUI();
	}
	
	@Override
	protected void createGUI() {
		super.createGUI();
		super.setTitle("Login");
		
		// contentPane related inokes
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		super.colorInit(this.contentPane);
		this.setContentPane(this.contentPane);
		
		// components 
		this.userNameField = new JTextField();
		this.userNameField.setToolTipText("enter a user name here");
		this.userNameField.setBounds(304, 234, 86, 20);
		this.userNameField.setColumns(10);
		this.contentPane.add(this.userNameField);
		
		this.lblUsername = new JLabel("username:");
		this.lblUsername.setBounds(318, 209, 58, 14);
		this.contentPane.add(this.lblUsername);
		
		this.passwordField = new JPasswordField();
		this.passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					// username
					String username = userNameField.getText();
					
					// password
					char[] passwordArray = passwordField.getPassword();
					String password = String.valueOf(passwordArray);
					
					try {
						LoginHandler.login(password, username);
						dispose();
					} catch (CredentialException e1) {
						e1.printStackTrace();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				} 
			}
		});
		this.passwordField.setBounds(304, 290, 86, 20);
		this.contentPane.add(this.passwordField);
		
		this.lblPassword = new JLabel("password:");
		this.lblPassword.setBounds(314, 265, 58, 14);
		this.contentPane.add(this.lblPassword);
		
		this.visiblePasswordField = new JTextField();
		this.visiblePasswordField.setEditable(false);
		this.visiblePasswordField.setBounds(304, 346, 86, 20);
		this.visiblePasswordField.setColumns(10);
		this.contentPane.add(this.visiblePasswordField);
		
		this.lblVisiblePassword = new JLabel("visible password:");
		this.lblVisiblePassword.setBounds(304, 321, 86, 14);
		this.contentPane.add(this.lblVisiblePassword);
		
		this.btnViewPassword = new JButton("view password");
		this.btnViewPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					char[] textPwd = passwordField.getPassword();
					String password = String.valueOf(textPwd);
					visiblePasswordField.setText(password);
				} else {
					Toolkit.getDefaultToolkit().beep();
				}
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				visiblePasswordField.setText("");
			}
			
		});
		this.btnViewPassword.setBounds(400, 290, 103, 20);
		this.contentPane.add(this.btnViewPassword);
		
		this.btnLogin = new JButton("login");
		this.btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// username
				String username = userNameField.getText();
				
				// password
				char[] passwordArray = passwordField.getPassword();
				String password = String.valueOf(passwordArray);
				
				try {
					LoginHandler.login(password, username);
					dispose();
				} catch (CredentialException e1) {
					e1.printStackTrace();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		this.btnLogin.setBounds(301, 377, 89, 32);
		this.contentPane.add(this.btnLogin);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	
	}

}
