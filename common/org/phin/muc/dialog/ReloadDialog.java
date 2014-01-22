package org.phin.muc.dialog;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.phin.muc.lib.Strings;

public class ReloadDialog extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	private JButton btnCancel;

	private JButton btnOkay;

	private JLabel lblLog;

	public ReloadDialog() {
		this.createGUI();
	}
	
	private void createGUI() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setEnabled(true);
		this.setVisible(true);
		this.setTitle("reload application");
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
		
		// sets the dialogs size
		this.setBounds(100, 100, Strings.DEFAULT_DIALOG_WIDTH, Strings.DEFAULT_DIALOG_HEIGHT);
		this.setSize(Strings.DEFAULT_DIALOG_DIM);
		
		// contentPane related things
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		this.setContentPane(this.contentPane);
		
		// sets the dialogs background color
		if ((Strings.DIALOG_RED != 0) && (Strings.DIALOG_GREEN != 0) && (Strings.DIALOG_BLUE != 0)) {
			this.contentPane.setBackground(new Color(Strings.DIALOG_RED, Strings.DIALOG_GREEN, Strings.DIALOG_BLUE));  
		} else {
			this.contentPane.setBackground(Color.DARK_GRAY);
		}
		
		this.btnOkay = new JButton("okay");
		this.btnOkay.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO
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
		
		this.lblLog = new JLabel("do you want to reload the application?");
		this.lblLog.setBounds(72, 66, 200, 50);
		this.contentPane.add(this.lblLog);
		
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
