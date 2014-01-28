package org.phin.muc.dialog.options;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import org.phin.muc.dialog.DisableUserFileMenuDialog;
import org.phin.muc.dialog.DisableUserMenuDialog;
import org.phin.muc.dialog.MultiUtilityDialog;
import org.phin.muc.lib.Strings;
import org.phin.muc.lib.UserSettings;

public class UserMenuBarOptions extends MultiUtilityDialog {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private JRadioButton rBtnMenuBar;
	private JRadioButton rBtnFileMenu;
	private JRadioButton rBtnEditMenu;
	private JRadioButton rBtnWindowMenu;
	private JRadioButton rBtnHelpMenu;
	private JRadioButton rBtnAppMenu;
	//private JRadioButton rBtnAdminMenu;
	
	private JButton btnDefaults;
	private JButton btnOkay;

	public UserMenuBarOptions() {
		this.createGUI();
	}
	
	@Override
	protected void createGUI() {
		// call the super createGUI
		super.createGUI();
				
		// title set
		super.setTitle("Menu Bar Settings");
	
		// contentPane related things
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		super.colorInit(this.contentPane);
		super.setContentPane(this.contentPane);
		
		if (Strings.userOptions != null) {
			Strings.userOptions.setEnabled(false);	
		}
		
		this.rBtnMenuBar = new JRadioButton("Menu Bar");
		this.rBtnMenuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (UserSettings.userMenuBar) {
					DisableUserMenuDialog dialog = new DisableUserMenuDialog();
					dialog.setVisible(true);
				} else {
					UserSettings.userMenuBar = true;
				}
			}
		});
		this.rBtnMenuBar.setBounds(10, 10, 119, 30);
		this.contentPane.add(this.rBtnMenuBar);
		
		this.rBtnFileMenu = new JRadioButton("File Menu");
		this.rBtnFileMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (UserSettings.userFileMenu) {
					DisableUserFileMenuDialog dialog = new DisableUserFileMenuDialog();
					dialog.setVisible(true);
				} else {
					UserSettings.userFileMenu = true;
				}
			}
		});
		this.rBtnFileMenu.setBounds(10, 50, 119, 30);
		this.contentPane.add(this.rBtnFileMenu);
		
		this.rBtnEditMenu = new JRadioButton("Edit Menu");
		this.rBtnEditMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (UserSettings.userEditMenu) {
					UserSettings.userEditMenu = false;
				} else {
					UserSettings.userEditMenu = true;
				}
			}
		});
		this.rBtnEditMenu.setBounds(10, 90, 119, 36);
		this.contentPane.add(this.rBtnEditMenu);
		
		this.rBtnWindowMenu = new JRadioButton("Window Menu");
		this.rBtnWindowMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (UserSettings.userWindowMenu) {
					UserSettings.userWindowMenu = false;
				} else {
					UserSettings.userWindowMenu = true;
				}
			}
		});
		this.rBtnWindowMenu.setBounds(142, 50, 119, 30);
		this.contentPane.add(this.rBtnWindowMenu);
		
		this.rBtnHelpMenu = new JRadioButton("Help Menu");
		this.rBtnHelpMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (UserSettings.userHelpMenu) {
					UserSettings.userHelpMenu = false;
				} else {
					UserSettings.userHelpMenu = true;
				}
			}
		});
		this.rBtnHelpMenu.setBounds(142, 90, 119, 30);
		this.contentPane.add(this.rBtnHelpMenu);
		
		this.rBtnAppMenu = new JRadioButton("App Menu");
		this.rBtnAppMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (UserSettings.userAppMenu) {
					UserSettings.userAppMenu = false;
				} else {
					UserSettings.userAppMenu = true;
				}
			}
		});
		this.rBtnAppMenu.setBounds(142, 10, 119, 30);
		this.contentPane.add(this.rBtnAppMenu);
		
		this.btnDefaults = new JButton("Defaults");
		this.btnDefaults.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserSettings.userMenuBar = true;
				UserSettings.userFileMenu = true;
				UserSettings.userEditMenu = true;
				UserSettings.userWindowMenu = true;
				UserSettings.userHelpMenu = true;
				UserSettings.userAppMenu = true;
			}
		});
		this.btnDefaults.setBounds(142, 135, 93, 36);
		this.contentPane.add(this.btnDefaults);
		
		this.btnOkay = new JButton("Okay");
		this.btnOkay.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		this.btnOkay.setBounds(245, 135, 89, 36);
		this.contentPane.add(this.btnOkay);
		
		this.checkSettings();

		this.setLocationRelativeTo(null);
		this.setVisible(true);
	
	}
	
	private void checkSettings() {
		if (UserSettings.menuBar) {
			this.rBtnMenuBar.doClick();
		}
		
		if (UserSettings.userFileMenu) {
			this.rBtnFileMenu.doClick();
		}
		
		if (UserSettings.userEditMenu) {
			this.rBtnEditMenu.doClick();
		}
		
		if (UserSettings.userHelpMenu) {
			this.rBtnHelpMenu.doClick();
		}
		
		if (UserSettings.userAppMenu) {
			this.rBtnAppMenu.doClick();
		}
		
		if (UserSettings.userWindowMenu) {
			this.rBtnWindowMenu.doClick();
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
