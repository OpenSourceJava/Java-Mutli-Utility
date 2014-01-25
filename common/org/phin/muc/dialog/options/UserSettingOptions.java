package org.phin.muc.dialog.options;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.phin.muc.dialog.MultiUtilityDialog;
import org.phin.muc.lib.Strings;

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
		super.setSize(Strings.DEFAULT_DIM);
				
		// contentPane related things
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		super.colorInit(this.contentPane);
		super.setContentPane(this.contentPane);
		
		this.btnConsoleSettings = new JButton("Console Settings");
		this.btnConsoleSettings.setBounds(10, 11, 176, 56);
		this.contentPane.add(this.btnConsoleSettings);
		
		this.btnSystemSettings = new JButton("System Settings");
		this.btnSystemSettings.setBounds(10, 78, 176, 56);
		this.contentPane.add(this.btnSystemSettings);
		
		this.btnMenuSettings = new JButton("Menu Settings");
		this.btnMenuSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserMenuBarOptions option = new UserMenuBarOptions();
				option.setVisible(true);
			}
		});
		this.btnMenuSettings.setBounds(10, 141, 176, 56);
		this.contentPane.add(this.btnMenuSettings);
	
	}
}
