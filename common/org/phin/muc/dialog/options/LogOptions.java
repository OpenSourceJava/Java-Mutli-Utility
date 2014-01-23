package org.phin.muc.dialog.options;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.phin.muc.lib.Strings;
import org.phin.muc.lib.UserSettings;

public class LogOptions extends JFrame {

	private static final long serialVersionUID = 1;
	
	private JPanel contentPane;
	private JButton btnOkay;
	private JButton btnRevert;
	private JButton btnEnableTextSaving;
	private JButton btnDisableTextSaving;

	public LogOptions() {
		this.createGUI();
	}
	
	private void createGUI() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("log options");
		this.setEnabled(true);
		this.setVisible(true);
		this.setResizable(false);
		
		if (Strings.isAdmin) {
			if (Strings.adminFrame != null) {
				Strings.adminFrame.setEnabled(false);
			}
		} else {
			if (Strings.userFrame != null) {
				Strings.userFrame.setEnabled(false);
			}
		}
		
		Strings.messageFrame.setEnabled(false);
		
		if (Strings.consoleFrame != null) {
			Strings.consoleFrame.setEnabled(false);
		}
		
		this.setBounds(100, 100, Strings.DEFAULT_DIALOG_WIDTH, Strings.DEFAULT_DIALOG_HEIGHT);
		this.setSize(Strings.DEFAULT_DIALOG_DIM);
		
		// contentPane
		this.contentPane = new JPanel();
		this.contentPane.setLayout(null);
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		// Apply the background color
		if ((UserSettings.RED != 0) && (UserSettings.GREEN != 0) && (UserSettings.BLUE != 0)) {
			this.contentPane.setBackground(new Color(UserSettings.RED, UserSettings.GREEN, UserSettings.BLUE));
		} else {
			this.contentPane.setBackground(Color.DARK_GRAY);
		}
		
		this.setContentPane(this.contentPane);
		
		this.btnRevert = new JButton("revert");
		this.btnRevert.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserSettings.saveLogText = true;
			}
		});
		this.btnRevert.setBounds(146, 148, 89, 23);
		this.contentPane.add(this.btnRevert);
		
		this.btnOkay = new JButton("okay");
		this.btnOkay.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		this.btnOkay.setBounds(245, 148, 89, 23);
		this.contentPane.add(this.btnOkay);
		
		this.btnEnableTextSaving = new JButton("enable text saving");
		this.btnEnableTextSaving.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserSettings.saveLogText = true;
			}
		});
		this.btnEnableTextSaving.setBounds(10, 11, 128, 23);
		this.contentPane.add(this.btnEnableTextSaving);
		
		this.btnDisableTextSaving = new JButton("disable text saving");
		this.btnDisableTextSaving.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserSettings.saveLogText = false;
			}
		});
		this.btnDisableTextSaving.setBounds(10, 44, 128, 23);
		this.contentPane.add(this.btnDisableTextSaving);
	}
		
}
