package org.phin.muc.dialog;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.phin.muc.lib.Reference;

public class AboutDialog extends MultiUtilityDialog {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	private JLabel lblVersion;

	public AboutDialog() {
		this.createGUI();
	}
	
	@Override
	public void createGUI() {
		// call the super createGUI
		super.createGUI();
				
		// title set
		super.setTitle("About");
				
		// contentPane related things
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		this.contentPane.setBackground(Color.LIGHT_GRAY);
		super.setContentPane(this.contentPane);
		
		this.lblVersion = new JLabel("Version = " + Reference.MU_VERSION);
		this.lblVersion.setFont(new Font("Tekton Pro Cond", Font.PLAIN, 18));
		this.lblVersion.setBounds(22, 25, 128, 14);
		this.contentPane.add(this.lblVersion);
		
	}
}
