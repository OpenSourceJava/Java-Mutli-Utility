package org.phin.muc.dialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ExitDialog extends MultiUtilityDialog {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JButton btnCancel;
	private JButton btnExit;
	private JLabel lblLog;
	
	public ExitDialog() {
		this.createGUI();
	}
	
	@Override
	protected void createGUI() {
		// call the super createGUI
		super.createGUI();
				
		// title set
		super.setTitle("Exit");
				
		// contentPane related things
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		super.colorInit(this.contentPane);
		super.setContentPane(this.contentPane);
		
		this.btnExit = new JButton("Exit");
		this.btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		this.btnExit.setBounds(195, 147, 89, 23);
		this.contentPane.add(this.btnExit);
		
		this.btnCancel = new JButton("Cancel");
		this.btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		this.btnCancel.setBounds(60, 146, 90, 25); 
		this.contentPane.add(this.btnCancel);
		
		this.lblLog = new JLabel("Are you sure you want to exit the application?");
		this.lblLog.setBounds(52, 66, 240, 50);
		this.contentPane.add(this.lblLog);
		
		// loads all components before showing the frame
		super.setLocationRelativeTo(null);
		super.toFront();
		super.setVisible(true);
		
	}

}
