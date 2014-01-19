package org.phin.mu.frame;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.phin.mu.lib.Strings;

public class ConsoleFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnEnter;
	private JTextArea textArea;

	public ConsoleFrame() {
		this.createGUI();
	}
	
	private void createGUI() {		
		// other invokes
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(525, 325);
		this.setVisible(true);
				
		// contentPane related inokes
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		if ((Strings.RED != 0) && (Strings.GREEN != 0) && (Strings.BLUE != 0)) {
			this.contentPane.setBackground(new Color(Strings.RED, Strings.GREEN, Strings.BLUE));
		} else {
			this.contentPane.setBackground(Color.LIGHT_GRAY);
		}
		
		this.btnEnter = new JButton("enter");
		this.btnEnter.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (Strings.isAdmin) {
					// implement command handler
				} else {
					textArea.append("sorry you dont have sufficient user privileges \n"); 
					textArea.append("to access the console commands \n");
					throw new SecurityException();
				}
			}
		});
		this.btnEnter.setBounds(420, 263, 89, 23);
		this.contentPane.add(this.btnEnter);
		
		this.textField = new JTextField();
		this.textField.setBounds(10, 264, 400, 20);
		this.textField.setColumns(10);
		this.contentPane.add(this.textField);
		
		this.textArea = new JTextArea();
		this.textArea.setEditable(false);
		this.textArea.setBounds(10, 11, 499, 241);
		this.contentPane.add(this.textArea);
		
		this.checkAccessLevel();
		
	}

	private void checkAccessLevel() {
		if (Strings.isAdmin) {
			this.setTitle("Admin Console");
			this.textField.setEditable(true);
			this.textArea.append("privilege level = admin");
		} else {
			this.setTitle("Console");
			this.textField.setEditable(false);
			this.textArea.append("privilege level = non-privileged");
		}
	}
}
