package org.phin.muc.dialog.options;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.phin.muc.dialog.MultiUtilityDialog;
import org.phin.muc.lib.UserSettings;

public class DialogPromptOptions extends MultiUtilityDialog {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblInfo2;
	private JButton btnEnableLogout;
	private JButton btnDisableLogout;
	private JLabel label;
	private JLabel label_1;
	private JButton btnEnableReload;
	private JButton btnDisableReload;
	private JButton btnDisableExit;
	private JButton btnEnableExit;
	private JButton btnDefaults;
	
	public DialogPromptOptions() {
		this.createGUI();
	}
	
	@Override
	protected void createGUI() {
		// call the super createGUI
		super.createGUI();
		
		// title set
		super.setTitle("dialog options");
		
		// sets the dialogs size
		super.setBounds(100, 100, 600, 600);
		super.setSize(600, 600);
		
		// contentPane related things
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		super.setDialogColor(this.contentPane);
		super.setContentPane(this.contentPane);
		
		// components -----------------------------------------------------------------------
		this.lblInfo2 = new JLabel("choose wether or not a dialog appears when you click components");
		this.lblInfo2.setBounds(10, 11, 324, 25);
		this.contentPane.add(this.lblInfo2);
		
		this.btnEnableExit = new JButton("enable exit dialog");
		this.btnEnableExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserSettings.exitPrompt = true;
			}
		});
		this.btnEnableExit.setBounds(10, 47, 123, 23);
		this.contentPane.add(this.btnEnableExit);
		
		this.btnDisableExit = new JButton("disable exit dialog");
		this.btnDisableExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserSettings.exitPrompt = false;
			}
		});
		this.btnDisableExit.setBounds(10, 81, 123, 23);
		this.contentPane.add(this.btnDisableExit);
		
		this.btnEnableLogout = new JButton("enable logout dialog");
		this.btnEnableLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserSettings.logoutPrompt = true;
			}
		});
		this.btnEnableLogout.setBounds(10, 140, 151, 23);
		this.contentPane.add(this.btnEnableLogout);
		
		this.btnDisableLogout = new JButton("disable logout dialog");
		this.btnDisableLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserSettings.logoutPrompt = false;
			}
		});
		this.btnDisableLogout.setBounds(10, 174, 151, 23);
		this.contentPane.add(this.btnDisableLogout);
		
		this.label = new JLabel("----------------------------");
		this.label.setBounds(10, 115, 200, 14);
		this.contentPane.add(this.label);
		
		this.label_1 = new JLabel("----------------------------");
		this.label_1.setBounds(10, 208, 200, 14);
		this.contentPane.add(this.label_1);
		
		this.btnEnableReload = new JButton("enable reload dialog");
		this.btnEnableReload.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserSettings.reloadPrompt = true;
			}
		});
		this.btnEnableReload.setBounds(10, 233, 133, 23); 
		this.contentPane.add(this.btnEnableReload);
		
		this.btnDisableReload = new JButton("disable reload dialog");
		this.btnDisableReload.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserSettings.reloadPrompt = false;
			}
		});
		this.btnDisableReload.setBounds(10, 267, 133, 23);
		this.contentPane.add(this.btnDisableReload);
		
		this.btnDefaults = new JButton("defaults");
		this.btnDefaults.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserSettings.exitPrompt = true;
				UserSettings.reloadPrompt = false;
				UserSettings.logoutPrompt = true;
			}
		});
		this.btnDefaults.setBounds(10, 540, 89, 23);
		this.contentPane.add(this.btnDefaults);
		
		// loads all components before showing the frame
		super.setLocationRelativeTo(null);
		super.setVisible(true);
		
	}
	
}
