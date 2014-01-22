package org.phin.muc.frame;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AdminOptionsFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	public AdminOptionsFrame() {
		this.createGUI();
	}
	
	private void createGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setTitle("not implemented yet");
		this.setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
