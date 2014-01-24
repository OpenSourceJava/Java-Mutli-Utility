package org.phin.muc.frame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.phin.muc.lib.Strings;

public class ConsoleFrame extends MultiUtilityFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnEnter;
	private static JTextArea textArea;

	public ConsoleFrame() {
		this.createGUI();
	}
	
	@Override
	protected void createGUI() {		
		super.createGUI();
		super.setTitle("Console");
		
		super.setBounds(100, 100, 525, 325);
		super.setSize(525, 325);
		
		// contentPane related inokes
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		super.colorInit(this.contentPane);
		this.setContentPane(this.contentPane);
		
		this.btnEnter = new JButton("Enter");
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
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (Strings.isAdmin) {
					// implement command handler
				} else {
					textArea.append("sorry you dont have sufficient user privileges \n"); 
					textArea.append("to access the console commands \n");
					throw new SecurityException();
				}
			}
		});
		this.textField.setBounds(10, 264, 400, 20);
		this.textField.setColumns(10);
		this.contentPane.add(this.textField);
		
		ConsoleFrame.textArea = new JTextArea();
		ConsoleFrame.textArea.setEditable(false);
		ConsoleFrame.textArea.setAutoscrolls(true);
		ConsoleFrame.textArea.setBounds(10, 11, 499, 241);
		this.contentPane.add(ConsoleFrame.textArea);
		
		this.checkAccessLevel();
		this.setVisible(true);
		
	}

	private void checkAccessLevel() {
		if (Strings.isAdmin) {
			this.setTitle("Admin Console");
			this.textField.setEditable(true);
			ConsoleFrame.textArea.append("info: privilege level = admin \n");
		} else {
			this.setTitle("Console");
			this.textField.setEditable(false);
			ConsoleFrame.textArea.append("info: privilege level = non-privileged \n");
		}
	}
	
	public static void printMessage(String message) {
		ConsoleFrame.textArea.append(message);
	}
	
}
