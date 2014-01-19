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

public class ExitDialog extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JButton btnCancel;
	private JButton btnOkay;
	private JLabel lblLog;
	
	public ExitDialog() {
		this.createGUI();
	}
	
	protected void createGUI() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setEnabled(true);
		this.setVisible(true);
		this.setTitle("exit");
		this.setLocationRelativeTo(null);
		
		// sets the dialogs size
		if ((Strings.CURRENT_DIALOG_HEIGHT != 0) && (Strings.CURRENT_DIALOG_WIDTH != 0)) {
			this.setBounds(100, 100, Strings.CURRENT_DIALOG_WIDTH, Strings.CURRENT_DIALOG_HEIGHT);
			this.setSize(Strings.CURRENT_DIALOG_DIM);
		} else {
			this.setBounds(100, 100, Strings.DEFAULT_DIALOG_WIDTH, Strings.DEFAULT_DIALOG_HEIGHT);
			this.setSize(Strings.DEFAULT_DIALOG_DIM);
		}
		
		// contentPane related things
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
		
		this.btnOkay = new JButton("okay");
		this.btnOkay.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		this.btnOkay.setBounds(195, 147, 89, 23);
		this.contentPane.add(this.btnOkay);
		
		this.btnCancel = new JButton("cancel");
		this.btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		this.btnCancel.setBounds(60, 146, 90, 25); 
		this.contentPane.add(this.btnCancel);
		
		this.lblLog = new JLabel("do you want to exit the application?");
		this.lblLog.setBounds(100, 66, 172, 50);
		this.contentPane.add(this.lblLog);
		
	}

}
