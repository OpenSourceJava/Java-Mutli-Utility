package org.phin.muc.dialog;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.phin.muc.lib.Strings;

public class LogDialog extends JFrame {

	private static final long serialVersionUID = 1;
	
	private JPanel contentPane;
	private JButton btnOkay;
	private JButton btnRevert;
	private JTextField txtDefaultHeight;
	private JTextField txtDefaultWidth;

	private Component btnEnableTextSaving;

	private Component btnDisableTextSaving;

	public LogDialog() {
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
		if ((Strings.RED != 0) && (Strings.GREEN != 0) && (Strings.BLUE != 0)) {
			this.contentPane.setBackground(new Color(Strings.RED, Strings.GREEN, Strings.BLUE));
		} else {
			this.contentPane.setBackground(Color.DARK_GRAY);
		}
		
		this.setContentPane(this.contentPane);
		
		this.btnRevert = new JButton("revert");
		this.btnRevert.setBounds(146, 148, 89, 23);
		this.contentPane.add(this.btnRevert);
		
		this.btnOkay = new JButton("okay");
		this.btnOkay.setBounds(245, 148, 89, 23);
		this.contentPane.add(this.btnOkay);
		
		this.txtDefaultHeight = new JTextField("default height");
		this.txtDefaultHeight.setBounds(10, 11, 86, 20);
		this.txtDefaultHeight.setColumns(10);
		this.contentPane.add(this.txtDefaultHeight);
		
		this.txtDefaultWidth = new JTextField("default width");
		this.txtDefaultWidth.setBounds(10, 42, 86, 20);
		this.txtDefaultWidth.setColumns(10);
		this.contentPane.add(this.txtDefaultWidth);
		
		this.btnEnableTextSaving = new JButton("enable text saving");
		this.btnEnableTextSaving.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Strings.saveLogText = true;
			}
		});
		this.btnEnableTextSaving.setBounds(106, 10, 128, 23);
		this.contentPane.add(this.btnEnableTextSaving);
		
		this.btnDisableTextSaving = new JButton("disable text saving");
		this.btnDisableTextSaving.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Strings.saveLogText = false;
			}
		});
		this.btnDisableTextSaving.setBounds(106, 41, 128, 23);
		this.contentPane.add(this.btnDisableTextSaving);
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
