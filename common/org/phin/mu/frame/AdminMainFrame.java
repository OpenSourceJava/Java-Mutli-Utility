package org.phin.mu.frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.phin.mu.lib.Strings;
import org.phin.mu.util.MenuHandler;

public class AdminMainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private MenuHandler handler;
	private JButton btnMyComputer;

	private Component btnLog;

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
		this.contentPane.setLayout(null);
		
		// Apply the background color
		if ((Strings.RED != 0) && (Strings.GREEN != 0) && (Strings.BLUE != 0)) {
			this.contentPane.setBackground(new Color(Strings.RED, Strings.GREEN, Strings.BLUE));
		} else {
			this.contentPane.setBackground(Color.LIGHT_GRAY);
		}
		
		this.setContentPane(this.contentPane);
		
		this.btnMyComputer = new JButton("My Computer");
		this.btnMyComputer.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ComputerFrame frame = new ComputerFrame();
				frame.setVisible(true);
			}
		});
		this.btnMyComputer.setBounds(10, 11, 110, 38);
		this.contentPane.add(this.btnMyComputer);
		
		this.btnLog = new JButton("log");
		this.btnLog.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				LogFrame frame = new LogFrame();
				frame.setVisible(true);
			}
		});
		this.btnLog.setBounds(130, 11, 110, 38);
		this.contentPane.add(this.btnLog);
		
	}

}
