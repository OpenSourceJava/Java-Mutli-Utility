package org.phin.muc.dialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.phin.muc.lib.UserSettings;

public class DisableFileDialog extends MultiUtilityDialog {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JButton btnCancel;
	private JLabel info2;
	private JLabel info1;
	private JButton btnContinue;

	public DisableFileDialog() {
		this.createGUI();
	}
	
	@Override
	protected void createGUI() {
		// call the super createGUI
		super.createGUI();
				
		// title set
		super.setTitle("Disable File Menu");
				
		// contentPane related things
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		super.setDialogColor(this.contentPane);
		super.setContentPane(this.contentPane);
		
		this.info1 = new JLabel("disabling the file menu can be irreversible with out a app restart");
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
				UserSettings.fileMenu = false;
				dispose();
			}
		});
		this.btnContinue.setBounds(195, 148, 89, 23);
		this.contentPane.add(this.btnContinue);
		
		// loads all components before showing the frame
		super.setLocationRelativeTo(null);
		super.setVisible(true);
		
	}

}
