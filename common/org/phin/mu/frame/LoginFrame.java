package org.phin.mu.frame;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.phin.mu.lib.Reference;
import org.phin.mu.lib.Strings;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	public LoginFrame() {
		this.createGUI();
	}
	
	private void createGUI() {
		
		// JFrame related methods
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(Strings.DEFAULT_DIM);
		this.setTitle(Reference.MU_TITLE);
		this.setResizable(false);
		this.setEnabled(true);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		// content pane related methods
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		this.contentPane.setBackground(Color.LIGHT_GRAY);
		this.setContentPane(this.contentPane);
	}

}
