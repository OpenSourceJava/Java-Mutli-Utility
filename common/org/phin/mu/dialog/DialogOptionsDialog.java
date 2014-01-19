package org.phin.mu.dialog;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.phin.mu.lib.Strings;

public class DialogOptionsDialog extends JFrame {

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
	
	public DialogOptionsDialog() {
		this.createGUI();
	}
	
	protected void createGUI() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setEnabled(true);
		this.setVisible(true);
		this.setTitle("dialog options");
		this.setLocationRelativeTo(null);
		
		this.setBounds(100, 100, 600, 600);
		this.setSize(600, 600);
		
		// contentPane related things
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		// sets the dialogs background color
		if ((Strings.DIALOG_RED != 0) && (Strings.DIALOG_GREEN != 0) && (Strings.DIALOG_BLUE != 0)) {
			this.contentPane.setBackground(new Color(Strings.DIALOG_RED, Strings.DIALOG_GREEN, Strings.DIALOG_BLUE));  
		} else {
			this.contentPane.setBackground(Color.LIGHT_GRAY);
		}
		
		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		this.lblInfo2 = new JLabel("choose wether or not a dialog appears when you click components");
		this.lblInfo2.setBounds(10, 11, 324, 25);
		this.contentPane.add(this.lblInfo2);
		
		this.btnEnableExit = new JButton("enable exit dialog");
		this.btnEnableExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Strings.exitPrompt = true;
			}
		});
		this.btnEnableExit.setBounds(10, 47, 123, 23);
		this.contentPane.add(this.btnEnableExit);
		
		this.btnDisableExit = new JButton("disable exit dialog");
		this.btnDisableExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Strings.exitPrompt = false;
			}
		});
		this.btnDisableExit.setBounds(10, 81, 123, 23);
		this.contentPane.add(this.btnDisableExit);
		
		this.btnEnableLogout = new JButton("enable logout dialog");
		this.btnEnableLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Strings.logoutPrompt = true;
			}
		});
		this.btnEnableLogout.setBounds(10, 140, 151, 23);
		this.contentPane.add(this.btnEnableLogout);
		
		this.btnDisableLogout = new JButton("disable logout dialog");
		this.btnDisableLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Strings.logoutPrompt = false;
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
		this.btnEnableReload.setBounds(10, 233, 133, 23);
		this.contentPane.add(this.btnEnableReload);
		
		this.btnDisableReload = new JButton("disable reload dialog");
		this.btnDisableReload.setBounds(10, 267, 133, 23);
		this.contentPane.add(this.btnDisableReload);
		
		this.btnDefaults = new JButton("defaults");
		this.btnDefaults.setBounds(10, 549, 89, 23);
		this.contentPane.add(this.btnDefaults);
		
	}
}
