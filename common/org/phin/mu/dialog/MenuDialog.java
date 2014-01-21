package org.phin.mu.dialog;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.phin.mu.lib.Strings;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuDialog extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	private Component btnDisableMenuBar;

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

	public MenuDialog() {
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
		
		// size
		this.setBounds(100, 100, Strings.DEFAULT_WIDTH, Strings.DEFAULT_HEIGHT);
		this.setSize(Strings.DEFAULT_DIM);
		
		// contentPane
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		
		// sets the dialogs background color
		if ((Strings.DIALOG_RED != 0) && (Strings.DIALOG_GREEN != 0) && (Strings.DIALOG_BLUE != 0)) {
			this.contentPane.setBackground(new Color(Strings.DIALOG_RED, Strings.DIALOG_GREEN, Strings.DIALOG_BLUE));  
		} else {
			this.contentPane.setBackground(Color.DARK_GRAY);
		}
		
		this.setContentPane(this.contentPane);
		
		this.btnEnableMenuBar = new JButton("enable menu bar");
		this.btnEnableMenuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Strings.menuBar = true;
			}
		});
		this.btnEnableMenuBar.setBounds(10, 11, 154, 23);
		this.contentPane.add(this.btnEnableMenuBar);
		
		this.btnDisableMenuBar = new JButton("disable menu bar");
		this.btnDisableMenuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Strings.menuBar = false;
			}
		});
		this.btnDisableMenuBar.setBounds(10, 45, 154, 23);
		this.contentPane.add(this.btnDisableMenuBar);
		
		this.btnDefaults = new JButton("defaults");
		this.btnDefaults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Strings.menuBar = true;
				Strings.fileMenu = true;
				Strings.editMenu = true;
				Strings.helpMenu = true;
				Strings.windowMenu = true;
				Strings.appMenu = true;
			}
		});
		this.btnDefaults.setBounds(603, 628, 131, 30);
		this.contentPane.add(this.btnDefaults);
		
		this.label = new JLabel("----------------------------------------");
		this.label.setBounds(10, 79, 174, 14);
		this.contentPane.add(this.label);
		
		this.btnEnableFileMenu = new JButton("enable File menu bar");
		this.btnEnableFileMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Strings.fileMenu = true;
			}
		});
		this.btnEnableFileMenu.setBounds(10, 104, 154, 23);
		this.contentPane.add(btnEnableFileMenu);
		
		this.btnDisableFileMenu = new JButton("disable file menu bar");
		this.btnDisableFileMenu.setBounds(10, 138, 154, 23);
		this.contentPane.add(this.btnDisableFileMenu);
		
		this.label_1 = new JLabel("----------------------------------------");
		this.label_1.setBounds(10, 172, 174, 14);
		this.contentPane.add(this.label_1);
		
		this.btnEnableEditMenu = new JButton("enable Edit menu bar");
		this.btnEnableEditMenu.setBounds(10, 197, 154, 23);
		this.contentPane.add(this.btnEnableEditMenu);
		
		this.btnDisableEditMenu = new JButton("disable Edit menu bar");
		this.btnDisableEditMenu.setBounds(10, 231, 154, 23);
		this.contentPane.add(this.btnDisableEditMenu);
		
		this.label_2 = new JLabel("----------------------------------------");
		this.label_2.setBounds(10, 265, 174, 14);
		this.contentPane.add(this.label_2);
		
		this.btnEnableHelpMenu = new JButton("enable Help menu bar");
		this.btnEnableHelpMenu.setBounds(10, 290, 154, 23);
		this.contentPane.add(this.btnEnableHelpMenu);
		
		this.btnDisableHelpMenu = new JButton("disable Help menu bar");
		this.btnDisableHelpMenu.setBounds(10, 324, 154, 23);
		this.contentPane.add(this.btnDisableHelpMenu);
		
		this.label_3 = new JLabel("----------------------------------------");
		this.label_3.setBounds(10, 358, 174, 14);
		this.contentPane.add(this.label_3);
		
		this.btnCurrentSettings = new JButton("current settings");
		this.btnCurrentSettings.setBounds(462, 628, 131, 30);
		this.contentPane.add(this.btnCurrentSettings);
		
		this.lblStartsTheLog = new JLabel("starts the log ");
		this.lblStartsTheLog.setBounds(483, 607, 85, 14);
		this.contentPane.add(this.lblStartsTheLog);
		
	}
}
