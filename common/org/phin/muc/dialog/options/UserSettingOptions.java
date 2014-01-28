package org.phin.muc.dialog.options;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.phin.muc.dialog.MultiUtilityDialog;

public class UserSettingOptions extends MultiUtilityDialog {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	private JButton btnConsoleSettings;
	private JButton btnSystemSettings;
	private JButton btnMenuSettings;

	public UserSettingOptions() {
		this.createGUI();
	}
	
	@Override
	protected void createGUI() {
		// call the super createGUI
		super.createGUI();
				
		// title set
		super.setTitle("User Settings");
				
		// contentPane related things
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		super.colorInit(this.contentPane);
		super.setContentPane(this.contentPane);
		
		this.btnConsoleSettings = new JButton("Console Settings");
		this.btnConsoleSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserConsoleOptions option = new UserConsoleOptions();
				option.setVisible(true);
			}
		});
		this.btnConsoleSettings.setBounds(10, 11, 167, 56);
		this.contentPane.add(this.btnConsoleSettings);
		
		this.btnSystemSettings = new JButton("System Settings");
		this.btnSystemSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserSystemOptions option = new UserSystemOptions();
				option.setVisible(true);
			}
		});
		this.btnSystemSettings.setBounds(10, 115, 167, 56);
		this.contentPane.add(this.btnSystemSettings);
		
		this.btnMenuSettings = new JButton("Menu Settings");
		this.btnMenuSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserMenuBarOptions option = new UserMenuBarOptions();
				option.setVisible(true);
			}
		});
		this.btnMenuSettings.setBounds(196, 56, 138, 71);
		this.contentPane.add(this.btnMenuSettings);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	
	} 

}
