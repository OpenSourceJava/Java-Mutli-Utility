package org.phin.muc.dialog.options;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.phin.muc.dialog.MultiUtilityDialog;
import org.phin.muc.lib.UserSettings;
import javax.swing.JRadioButton;

public class LogOptions extends MultiUtilityDialog {

	private static final long serialVersionUID = 1;
	
	private JPanel contentPane;
	private JButton btnOkay;
	private JButton btnRevert;
	private JRadioButton rBtnSaveText;

	public LogOptions() {
		this.createGUI();
	}
	
	@Override
	protected void createGUI() {
		// call the super createGUI
		super.createGUI();
				
		// title set
		super.setTitle("Log options");
				
		// contentPane related things
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		super.colorInit(this.contentPane);
		super.setContentPane(this.contentPane);
		
		this.btnRevert = new JButton("Defaults");
		this.btnRevert.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserSettings.saveLogText = true;
			}
		});
		this.btnRevert.setBounds(146, 148, 89, 23);
		this.contentPane.add(this.btnRevert);
		
		this.btnOkay = new JButton("Okay");
		this.btnOkay.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		this.btnOkay.setBounds(245, 148, 89, 23);
		this.contentPane.add(this.btnOkay);
		
		this.rBtnSaveText = new JRadioButton("Save Text on Log Exit");
		this.rBtnSaveText.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (UserSettings.saveLogText) {
					UserSettings.saveLogText = false;
				} else {
					UserSettings.saveLogText = true;
				}
			}
		});
		this.rBtnSaveText.setBounds(6, 7, 166, 42);
		this.contentPane.add(this.rBtnSaveText);
		
		if (UserSettings.saveLogText) {
			this.rBtnSaveText.doClick();
		}
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
		
}
