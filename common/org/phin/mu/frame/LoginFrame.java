package org.phin.mu.frame;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.security.auth.login.CredentialException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.phin.mu.lib.Reference;
import org.phin.mu.lib.Strings;
import org.phin.mu.util.LAFHandler;
import org.phin.mu.util.LoginHandler;

public class LoginFrame extends JFrame {

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
		this.createGUI();
	}
	
	private void createGUI() {
		
		// look and feel handler
		LAFHandler.setNativeLookAndFeel();
		
		this.setBounds(100, 100, Strings.DEFAULT_WIDTH, Strings.DEFAULT_HEIGHT);
		this.setSize(Strings.DEFAULT_DIM);
				
		// JFrame related methods
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle(Reference.MU_TITLE);
		this.setResizable(false);
		this.setEnabled(true);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		// content pane related methods
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		this.contentPane.setBackground(Color.LIGHT_GRAY);
		this.setContentPane(this.contentPane);
		
		if ((Strings.RED != 0) && (Strings.GREEN != 0) && (Strings.BLUE != 0)) {
			this.contentPane.setBackground(new Color(Strings.RED, Strings.GREEN, Strings.BLUE));
		} else {
			this.contentPane.setBackground(Color.LIGHT_GRAY);
		}
		
		// components 
		this.userNameField = new JTextField();
		this.userNameField.setToolTipText("enter a user name here");
		this.userNameField.setBounds(329, 160, 86, 20);
		this.userNameField.setColumns(10);
		this.contentPane.add(this.userNameField);
		
		this.lblUsername = new JLabel("username:");
		this.lblUsername.setBounds(341, 135, 58, 14);
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
		this.passwordField.setBounds(329, 216, 86, 20);
		this.contentPane.add(this.passwordField);
		
		this.lblPassword = new JLabel("password:");
		this.lblPassword.setBounds(341, 191, 58, 14);
		this.contentPane.add(this.lblPassword);
		
		this.visiblePasswordField = new JTextField();
		this.visiblePasswordField.setEditable(false);
		this.visiblePasswordField.setBounds(329, 270, 86, 20);
		this.visiblePasswordField.setColumns(10);
		this.contentPane.add(this.visiblePasswordField);
		
		this.lblVisiblePassword = new JLabel("visible password:");
		this.lblVisiblePassword.setBounds(329, 247, 86, 14);
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
		this.btnViewPassword.setBounds(425, 216, 103, 20);
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
		this.btnLogin.setBounds(327, 610, 89, 23);
		this.contentPane.add(this.btnLogin);
	
	}

}
