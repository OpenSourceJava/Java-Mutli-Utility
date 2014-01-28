package org.phin.muc.dialog.options;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import org.phin.muc.dialog.MultiUtilityDialog;
import org.phin.muc.lib.Strings;
import org.phin.muc.lib.UserSettings;

public class UserConsoleOptions extends MultiUtilityDialog {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JRadioButton rdbtnConsole;
	private JRadioButton rdbtnConsoleCommands;
	private JButton btnOkay;
	private JButton btnDefaults;

	public UserConsoleOptions() {
		this.createGUI();
	}
	
	@Override
	protected void createGUI() {
		// call the super createGUI
		super.createGUI();
				
		// title set
		super.setTitle("User Console Settings");
		
		if (Strings.userOptions != null) {
			Strings.userOptions.setEnabled(false);	
		}
				
		// contentPane related things
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		super.colorInit(this.contentPane);
		super.setContentPane(this.contentPane);
		
		this.rdbtnConsole = new JRadioButton("console");
		this.rdbtnConsole.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (UserSettings.userConsole) {
					UserSettings.userConsole = false;
				} else {
					UserSettings.userConsole = true;
				}
			}
		});
		this.rdbtnConsole.setBounds(6, 7, 146, 41);
		this.contentPane.add(this.rdbtnConsole);
		
		this.rdbtnConsoleCommands = new JRadioButton("console commands");
		this.rdbtnConsoleCommands.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (UserSettings.userConsoleCommands) {
					UserSettings.userConsoleCommands = false;
				} else {
					UserSettings.userConsoleCommands = true;
				}
			}
		});
		this.rdbtnConsoleCommands.setBounds(6, 56, 146, 41);
		this.contentPane.add(this.rdbtnConsoleCommands);
		
		this.btnOkay = new JButton("Okay");
		this.btnOkay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				dispose();
			}
		});
		this.btnOkay.setBounds(245, 148, 89, 23);
		this.contentPane.add(this.btnOkay);
		
		this.btnDefaults = new JButton("Defaults");
		this.btnDefaults.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				UserSettings.userConsole = true;
				UserSettings.userConsoleCommands = true;
			}
		});
		this.btnDefaults.setBounds(146, 148, 89, 23);
		this.contentPane.add(this.btnDefaults);
		
		this.checkSettings();
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	private void checkSettings() {
		if (UserSettings.userConsole) {
			this.rdbtnConsole.doClick();
		}
		
		if (UserSettings.userConsoleCommands) {
			this.rdbtnConsoleCommands.doClick();
		}
	}
	
	@Override
	public void dispose() {	
		super.dispose();
		
		if (Strings.adminFrame != null) {
			Strings.adminFrame.setEnabled(false);
		}
		
		if (Strings.consoleFrame != null) {
			Strings.consoleFrame.setEnabled(false);
		}
		
		if (Strings.userOptions != null) {
			Strings.userOptions.setEnabled(true);
		}
	}

}
