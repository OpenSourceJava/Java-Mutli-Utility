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

public class DisableMenuDialog extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JButton btnCancel;
	private JLabel info2;
	private JLabel info1;
	private JButton btnContinue;

	public DisableMenuDialog() {
		this.createGUI();
	}
	
	private void createGUI() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setEnabled(true);
		this.setVisible(true);
		this.setTitle("warning!");
		this.setLocationRelativeTo(null);
		
		this.setBounds(100, 100, Strings.DEFAULT_DIALOG_WIDTH, Strings.DEFAULT_DIALOG_HEIGHT);
		this.setSize(Strings.DEFAULT_DIALOG_DIM);
	
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
		
		this.info1 = new JLabel("disabling the menu bar can be irreversible with out a app restart");
		this.info1.setBounds(10, 65, 324, 14);
		this.contentPane.add(this.info1);
		
		this.info2 = new JLabel("are your sure you want to do this?");
		this.info2.setBounds(72, 90, 210, 14);
		this.contentPane.add(this.info2);
		
		this.btnCancel = new JButton("Cancel");
		this.btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		this.btnCancel.setBounds(50, 148, 89, 23);
		this.contentPane.add(this.btnCancel);
		
		this.btnContinue = new JButton("Continue");
		this.btnContinue.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Strings.menuBar = false;
				dispose();
			}
		});
		this.btnContinue.setBounds(195, 148, 89, 23);
		this.contentPane.add(this.btnContinue);
		
	}

}
