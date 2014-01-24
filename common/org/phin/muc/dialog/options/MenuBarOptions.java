package org.phin.muc.dialog.options;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import org.phin.muc.dialog.MultiUtilityDialog;
import org.phin.muc.lib.UserSettings;

public class MenuBarOptions extends MultiUtilityDialog {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private JRadioButton rBtnMenuBar;
	private JRadioButton rBtnFileMenu;
	private JRadioButton rBtnEditMenu;
	private JRadioButton rBtnWindowMenu;
	private JRadioButton rBtnHelpMenu;
	private JRadioButton rBtnAppMenu;

	private JButton btnDefaults;
	private JButton btnOkay;

	public MenuBarOptions() {
		this.createGUI();
	}
	
	@Override
	protected void createGUI() {
		// call the super createGUI
		super.createGUI();
				
		// title set
		super.setTitle("Menu Bar Options");
	
		// contentPane related things
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		super.colorInit(this.contentPane);
		super.setContentPane(this.contentPane);
		
		this.rBtnMenuBar = new JRadioButton("Menu Bar");
		this.rBtnMenuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (UserSettings.menuBar) {
					UserSettings.menuBar = false;
				} else {
					UserSettings.menuBar = true;
				}
			}
		});
		this.rBtnMenuBar.setBounds(10, 10, 119, 30);
		this.contentPane.add(this.rBtnMenuBar);
		
		this.rBtnFileMenu = new JRadioButton("File Menu");
		this.rBtnFileMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (UserSettings.fileMenu) {
					UserSettings.fileMenu = false;
				} else {
					UserSettings.fileMenu = true;
				}
			}
		});
		this.rBtnFileMenu.setBounds(10, 50, 119, 30);
		this.contentPane.add(this.rBtnFileMenu);
		
		this.rBtnEditMenu = new JRadioButton("Edit Menu");
		this.rBtnEditMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (UserSettings.editMenu) {
					UserSettings.editMenu = false;
				} else {
					UserSettings.editMenu = true;
				}
			}
		});
		this.rBtnEditMenu.setBounds(10, 90, 119, 30);
		this.contentPane.add(this.rBtnEditMenu);
		
		this.rBtnWindowMenu = new JRadioButton("Window Menu");
		this.rBtnWindowMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (UserSettings.windowMenu) {
					UserSettings.windowMenu = false;
				} else {
					UserSettings.windowMenu = true;
				}
			}
		});
		this.rBtnWindowMenu.setBounds(142, 50, 119, 30);
		this.contentPane.add(this.rBtnWindowMenu);
		
		this.rBtnHelpMenu = new JRadioButton("Help Menu");
		this.rBtnHelpMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (UserSettings.helpMenu) {
					UserSettings.helpMenu = false;
				} else {
					UserSettings.helpMenu = true;
				}
			}
		});
		this.rBtnHelpMenu.setBounds(142, 90, 119, 30);
		this.contentPane.add(this.rBtnHelpMenu);
		
		this.rBtnAppMenu = new JRadioButton("App Menu");
		this.rBtnAppMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (UserSettings.appMenu) {
					UserSettings.appMenu = false;
				} else {
					UserSettings.appMenu = true;
				}
			}
		});
		this.rBtnAppMenu.setBounds(142, 10, 119, 30);
		this.contentPane.add(this.rBtnAppMenu);
		
		this.btnDefaults = new JButton("Defaults");
		this.btnDefaults.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserSettings.menuBar = true;
				UserSettings.fileMenu = true;
				UserSettings.editMenu = true;
				UserSettings.windowMenu = true;
				UserSettings.helpMenu = true;
				UserSettings.appMenu = true;
			}
		});
		this.btnDefaults.setBounds(146, 148, 89, 23);
		this.contentPane.add(this.btnDefaults);
		
		this.btnOkay = new JButton("Okay");
		this.btnOkay.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		this.btnOkay.setBounds(245, 148, 89, 23);
		this.contentPane.add(this.btnOkay);
		
		this.checkSettings();

		this.setLocationRelativeTo(null);
		this.setVisible(true);
	
	}
	
	private void checkSettings() {
		if (UserSettings.menuBar) {
			this.rBtnMenuBar.doClick();
		}
		
		if (UserSettings.fileMenu) {
			this.rBtnFileMenu.doClick();
		}
		
		if (UserSettings.editMenu) {
			this.rBtnEditMenu.doClick();
		}
		
		if (UserSettings.helpMenu) {
			this.rBtnHelpMenu.doClick();
		}
		
		if (UserSettings.appMenu) {
			this.rBtnAppMenu.doClick();
		}
		
		if (UserSettings.windowMenu) {
			this.rBtnWindowMenu.doClick();
		}
		
	}
	
}
