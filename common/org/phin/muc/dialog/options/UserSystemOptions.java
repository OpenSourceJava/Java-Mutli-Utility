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

public class UserSystemOptions extends MultiUtilityDialog {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JRadioButton rdbtnCommandPrompt;
	private JRadioButton rdbtnRegedit;
	private JRadioButton rdbtnMyComputer;
	private JButton btnOkay;
	private JButton btnDefaults;

	public UserSystemOptions() {
		this.createGUI();
	}
	
	@Override
	protected void createGUI() {
		// call the super createGUI
		super.createGUI();
				
		// title set
		super.setTitle("User System Settings");
		
		if (Strings.userOptions != null) {
			Strings.userOptions.setEnabled(false);	
		}
				
		// contentPane related things
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		super.colorInit(this.contentPane);
		super.setContentPane(this.contentPane);
		
		this.rdbtnCommandPrompt = new JRadioButton("command prompt (windows)");
		this.rdbtnCommandPrompt.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (UserSettings.userCMD) {
					UserSettings.userCMD = false;
				} else {
					UserSettings.userCMD = true;
				}
			}
		});
		this.rdbtnCommandPrompt.setToolTipText("enables or disables the command prompt as well as the custom command prompt");
		this.rdbtnCommandPrompt.setBounds(6, 7, 172, 39);
		this.contentPane.add(this.rdbtnCommandPrompt);
		
		this.rdbtnRegedit = new JRadioButton("registry editor (windows)");
		this.rdbtnRegedit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (UserSettings.userRegedit) {
					UserSettings.userRegedit = false;
				} else {
					UserSettings.userRegedit = true;
				}
			}
		});
		this.rdbtnRegedit.setBounds(51, 71, 153, 39);
		this.contentPane.add(this.rdbtnRegedit);
		
		this.rdbtnMyComputer = new JRadioButton("My Computer (windows)");
		this.rdbtnMyComputer.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (UserSettings.userComputerFrame) {
					UserSettings.userComputerFrame = false;
				} else {
					UserSettings.userComputerFrame = true;
				}
			}
		});
		this.rdbtnMyComputer.setBounds(6, 136, 153, 39);
		this.contentPane.add(this.rdbtnMyComputer);
		
		this.btnOkay = new JButton("Okay");
		this.btnOkay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e)  {
				dispose();
			}
		});
		this.btnOkay.setBounds(232, 152, 102, 23);
		this.contentPane.add(this.btnOkay);
		
		this.btnDefaults = new JButton("Defaults");
		this.btnDefaults.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserSettings.userCMD = true;
				UserSettings.userComputerFrame = true;
				UserSettings.userRegedit = true;
			}
		});
		this.btnDefaults.setBounds(232, 118, 102, 23);
		this.contentPane.add(this.btnDefaults);
		
		this.checkSettings();
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	private void checkSettings() {
		if (UserSettings.userCMD) {
			this.rdbtnCommandPrompt.doClick();
		}
		
		if (UserSettings.userRegedit) {
			this.rdbtnRegedit.doClick();
		}
		
		if (UserSettings.userComputerFrame) {
			this.rdbtnMyComputer.doClick();
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
