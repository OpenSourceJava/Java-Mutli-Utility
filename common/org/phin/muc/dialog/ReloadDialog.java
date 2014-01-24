package org.phin.muc.dialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.phin.muc.util.ReloadHandler;

public class ReloadDialog extends MultiUtilityDialog {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JButton btnCancel;
	private JButton btnOkay;
	private JLabel lblLog;

	public ReloadDialog() {
		this.createGUI();
	}
	
	@Override
	protected void createGUI() {
		// call the super createGUI
		super.createGUI();
								
		// title set
		super.setTitle("Reload");
								
		// contentPane related things
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		super.colorInit(this.contentPane);
		super.setContentPane(this.contentPane);
		
		this.btnOkay = new JButton("Reload");
		this.btnOkay.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ReloadHandler.reloadUI();
				dispose();
			}
		});
		this.btnOkay.setBounds(195, 147, 89, 23);
		this.contentPane.add(this.btnOkay);
		
		this.btnCancel = new JButton("Cancel");
		this.btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		this.btnCancel.setBounds(60, 146, 90, 25); 
		this.contentPane.add(this.btnCancel);
		
		this.lblLog = new JLabel("Are your sure you want to reload the application?");
		this.lblLog.setBounds(53, 66, 238, 50);
		this.contentPane.add(this.lblLog);
		
		// loads all components before showing the frame
		super.setLocationRelativeTo(null);
		super.toFront();
		super.setVisible(true);
		
	}

}
