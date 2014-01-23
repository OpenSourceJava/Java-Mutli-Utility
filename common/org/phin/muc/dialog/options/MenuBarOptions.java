package org.phin.muc.dialog.options;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.phin.muc.dialog.DisableFileDialog;
import org.phin.muc.dialog.DisableMenuDialog;
import org.phin.muc.lib.Strings;
import org.phin.muc.lib.UserSettings;
import org.phin.muc.util.MenuHandler;

public class MenuBarOptions extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	private JButton btnDisableMenuBar;
	private JButton btnEnableMenuBar;
	private JButton btnDefaults;
	private JLabel label;
	private JButton btnEnableFileMenu;
	private JButton btnDisableFileMenu;
	private JLabel label_1;
	private JButton btnEnableEditMenu;
	private JButton btnDisableEditMenu;
	private JLabel label_2;
	private JButton btnEnableHelpMenu;
	private JButton btnDisableHelpMenu;
	private JLabel label_3;
	private JButton btnCurrentSettings;
	private JLabel lblStartsTheLog;
	private JButton btnDone;
	private JButton btnEnableAppMenu;
	private JButton btnDisableAppMenu;
	private JLabel label_4;
	private JButton btnEnableWindowMenu;
	private JButton btnDisableWindowMenu;

	public MenuBarOptions() {
		this.createGUI();
	}
	
	private void createGUI() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setEnabled(true);
		this.setVisible(true);
		this.setTitle("menu bar settings");
		this.setLocationRelativeTo(null);
		
		if (Strings.isAdmin) {
			if (Strings.adminFrame != null) {
				Strings.adminFrame.setEnabled(false);
			}
		} else {
			if (Strings.userFrame != null) {
				Strings.userFrame.setEnabled(false);
			}
		}
		
		if (Strings.consoleFrame != null) {
			Strings.consoleFrame.setEnabled(false);
		}
		
		// size
		this.setBounds(100, 100, Strings.DEFAULT_WIDTH, Strings.DEFAULT_HEIGHT);
		this.setSize(Strings.DEFAULT_DIM);
		
		// contentPane
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		
		// sets the dialogs background color
		if ((UserSettings.DIALOG_RED != 0) && (UserSettings.DIALOG_GREEN != 0) && (UserSettings.DIALOG_BLUE != 0)) {
			this.contentPane.setBackground(new Color(UserSettings.DIALOG_RED, UserSettings.DIALOG_GREEN, UserSettings.DIALOG_BLUE));  
		} else {
			this.contentPane.setBackground(Color.DARK_GRAY);
		}
		
		this.setContentPane(this.contentPane);
		
		this.btnEnableMenuBar = new JButton("enable menu bar");
		this.btnEnableMenuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserSettings.menuBar = true;
			}
		});
		this.btnEnableMenuBar.setBounds(10, 11, 154, 23);
		this.contentPane.add(this.btnEnableMenuBar);
		
		this.btnDisableMenuBar = new JButton("disable menu bar");
		this.btnDisableMenuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				DisableMenuDialog frame = new DisableMenuDialog();
				frame.setVisible(true);
			}
		});
		this.btnDisableMenuBar.setBounds(10, 45, 154, 23);
		this.contentPane.add(this.btnDisableMenuBar);
		
		this.btnDefaults = new JButton("defaults");
		this.btnDefaults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserSettings.menuBar = true;
				UserSettings.fileMenu = true;
				UserSettings.editMenu = true;
				UserSettings.helpMenu = true;
				UserSettings.windowMenu = true;
				UserSettings.appMenu = true;
			}
		});
		this.btnDefaults.setBounds(462, 628, 131, 30);
		this.contentPane.add(this.btnDefaults);
		
		this.label = new JLabel("----------------------------------------");
		this.label.setBounds(10, 79, 174, 14);
		this.contentPane.add(this.label);
		
		this.btnEnableFileMenu = new JButton("enable File menu bar");
		this.btnEnableFileMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserSettings.fileMenu = true;
			}
		});
		this.btnEnableFileMenu.setBounds(10, 104, 154, 23);
		this.contentPane.add(btnEnableFileMenu);
		
		this.btnDisableFileMenu = new JButton("disable File menu bar");
		this.btnDisableFileMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				DisableFileDialog frame = new DisableFileDialog();
				frame.setVisible(true);
			}
		});
		this.btnDisableFileMenu.setBounds(10, 138, 154, 23);
		this.contentPane.add(this.btnDisableFileMenu);
		
		this.label_1 = new JLabel("----------------------------------------");
		this.label_1.setBounds(10, 172, 174, 14);
		this.contentPane.add(this.label_1);
		
		this.btnEnableEditMenu = new JButton("enable Edit menu bar");
		this.btnEnableEditMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserSettings.editMenu = true;
			}
		});
		this.btnEnableEditMenu.setBounds(10, 197, 154, 23);
		this.contentPane.add(this.btnEnableEditMenu);
		
		this.btnDisableEditMenu = new JButton("disable Edit menu bar");
		this.btnDisableEditMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserSettings.editMenu = false;
			}
		});
		this.btnDisableEditMenu.setBounds(10, 231, 154, 23);
		this.contentPane.add(this.btnDisableEditMenu);
		
		this.label_2 = new JLabel("----------------------------------------");
		this.label_2.setBounds(10, 265, 174, 14);
		this.contentPane.add(this.label_2);
		
		this.btnEnableHelpMenu = new JButton("enable Help menu bar");
		this.btnEnableHelpMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserSettings.helpMenu = true;
			}
		});
		this.btnEnableHelpMenu.setBounds(10, 290, 154, 23);
		this.contentPane.add(this.btnEnableHelpMenu);
		
		this.btnDisableHelpMenu = new JButton("disable Help menu bar");
		this.btnDisableHelpMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserSettings.helpMenu = false;
			}
		});
		this.btnDisableHelpMenu.setBounds(10, 324, 154, 23);
		this.contentPane.add(this.btnDisableHelpMenu);
		
		this.label_3 = new JLabel("----------------------------------------");
		this.label_3.setBounds(10, 358, 174, 14);
		this.contentPane.add(this.label_3);
		
		this.btnCurrentSettings = new JButton("current settings");
		this.btnCurrentSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (Strings.isAdmin) {
					MenuHandler.getMenuAsAdmin();
				} else {
					// TODO
				}
			}
		});
		this.btnCurrentSettings.setBounds(321, 628, 131, 30);
		this.contentPane.add(this.btnCurrentSettings);
		
		this.lblStartsTheLog = new JLabel("starts the log ");
		this.lblStartsTheLog.setBounds(347, 603, 85, 14);
		this.contentPane.add(this.lblStartsTheLog);
		
		this.btnDone = new JButton("done");
		this.btnDone.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		this.btnDone.setBounds(603, 628, 131, 30);
		this.contentPane.add(this.btnDone);
		
		this.btnEnableAppMenu = new JButton("enable App menu bar");
		this.btnEnableAppMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserSettings.appMenu = true;
			}
		});
		this.btnEnableAppMenu.setBounds(10, 383, 154, 23);
		this.contentPane.add(this.btnEnableAppMenu);
		
		this.btnDisableAppMenu = new JButton("disable App menu bar");
		this.btnDisableAppMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserSettings.appMenu = false;
			}
		});
		this.btnDisableAppMenu.setBounds(10, 417, 154, 23);
		this.contentPane.add(this.btnDisableAppMenu);
		
		this.label_4 = new JLabel("----------------------------------------");
		this.label_4.setBounds(10, 451, 174, 14);
		this.contentPane.add(this.label_4);
		
		this.btnEnableWindowMenu = new JButton("enable Window menu bar");
		this.btnEnableWindowMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserSettings.windowMenu = true;
			}
		});
		this.btnEnableWindowMenu.setBounds(10, 476, 154, 23);
		this.contentPane.add(btnEnableWindowMenu);
		
		this.btnDisableWindowMenu = new JButton("disable Window menu bar");
		this.btnDisableWindowMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserSettings.windowMenu = false;
			}
		});
		this.btnDisableWindowMenu.setBounds(10, 510, 154, 23);
		this.contentPane.add(this.btnDisableWindowMenu);
		
	}
	
	@Override
	public void dispose() {
		super.dispose();
		
		if (Strings.adminFrame != null) {
			Strings.adminFrame.setEnabled(true);
		} else if (Strings.userFrame != null) {
			Strings.userFrame.setEnabled(true);
		}
		
		if (Strings.consoleFrame != null) {
			Strings.consoleFrame.setEnabled(true);
		}
		
	}
}
