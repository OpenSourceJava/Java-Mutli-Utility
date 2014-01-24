package org.phin.muc.dialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.phin.muc.util.LoginHandler;

public class LogoutDialog extends MultiUtilityDialog {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JButton btnCancel;
	private JButton btnLogout;
	private JLabel lblLog;
	
	public LogoutDialog() {
		this.createGUI();
	}
	
	@Override
	protected void createGUI() {
		// call the super createGUI
		super.createGUI();
						
		// title set
		super.setTitle("Logout");
						
		// contentPane related things
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		super.colorInit(this.contentPane);
		super.setContentPane(this.contentPane);
		
		this.btnLogout = new JButton("Logout");
		this.btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// logs out
				LoginHandler.logout();
				
				// disposes of this frame
				dispose();
			}
		});
		this.btnLogout.setBounds(195, 147, 89, 23);
		this.contentPane.add(this.btnLogout);
		
		this.btnCancel = new JButton("Cancel");
		this.btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		this.btnCancel.setBounds(60, 146, 90, 25); 
		this.contentPane.add(this.btnCancel);
		
		this.lblLog = new JLabel("Are you sure you want to logout?");
		this.lblLog.setBounds(86, 66, 172, 50);
		this.contentPane.add(this.lblLog);
		
		// loads all components before showing the frame
		super.setLocationRelativeTo(null);
		super.toFront();
		super.setVisible(true);
		
	}
	
}
