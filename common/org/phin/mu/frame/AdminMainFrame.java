package org.phin.mu.frame;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.phin.mu.lib.Strings;
import org.phin.mu.util.MenuHandler;

public class AdminMainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private MenuHandler handler;

	public AdminMainFrame() {
		this.createGUI();
	}
	
	private void createGUI() {

		// checks the current size and sets the frames size accordingly  
		if ((Strings.CURRENT_HEIGHT != 0) && (Strings.CURRENT_WIDTH != 0)) {
			this.setBounds(100, 100, Strings.CURRENT_WIDTH, Strings.CURRENT_HEIGHT);
			this.setSize(Strings.CURRENT_DIM);
		} else {
			this.setBounds(100, 100, Strings.DEFAULT_WIDTH, Strings.DEFAULT_HEIGHT);
			this.setSize(Strings.DEFAULT_DIM);
		}
		
		// general JFrame usage
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		this.setAlwaysOnTop(false);
		this.setEnabled(true);
		this.setTitle("Admin Main Frame");
		this.setLocationRelativeTo(null);
		
		// menu init
		this.handler = new MenuHandler();
		this.handler.initMenu(this);

		// contentPane usage
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		// Apply the background color
		if ((Strings.RED != 0) && (Strings.GREEN != 0) && (Strings.BLUE != 0)) {
			this.contentPane.setBackground(new Color(Strings.RED, Strings.GREEN, Strings.BLUE));
		} else {
			this.contentPane.setBackground(Color.LIGHT_GRAY);
		}
		
		this.setContentPane(this.contentPane);
		
	}

}
