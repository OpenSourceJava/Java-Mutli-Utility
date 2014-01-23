package org.phin.muc.frame;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import org.phin.muc.dialog.options.LogOptions;
import org.phin.muc.lib.Strings;
import org.phin.muc.lib.UserSettings;

public class LogFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextArea textArea;
	private JButton btnClear;
	private JButton btnLogOptions;
	private JLabel lbl1;
	
	public LogFrame() {
		this.createGUI();
	}
	
	public LogFrame(String text) {
		this.createGUI();
		this.textArea.setText(text);
	}
	
	private void createGUI() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("log");
		this.setEnabled(true);
		this.setVisible(true);
		this.setResizable(false);
		
		this.setBounds(100, 100, Strings.DEFAULT_WIDTH, Strings.DEFAULT_HEIGHT);
		this.setSize(Strings.DEFAULT_DIM);
		
		// contentPane
		this.contentPane = new JPanel();
		this.contentPane.setLayout(null);
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		// Apply the background color
		if ((UserSettings.RED != 0) && (UserSettings.GREEN != 0) && (UserSettings.BLUE != 0)) {
			this.contentPane.setBackground(new Color(UserSettings.RED, UserSettings.GREEN, UserSettings.BLUE));
		} else {
			this.contentPane.setBackground(Color.DARK_GRAY);
		}
		
		this.setContentPane(this.contentPane);
		
		this.textArea = new JTextArea();
		this.textArea.setBounds(10, 11, 725, 616);
		this.textArea.setEditable(false);
		this.contentPane.add(this.textArea);
		
		this.btnClear = new JButton("Clear");
		this.btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textArea.setText("");
			}
		});
		this.btnClear.setBounds(535, 638, 200, 23);
		this.contentPane.add(this.btnClear);
		
		this.btnLogOptions = new JButton("log options");
		this.btnLogOptions.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				LogOptions option = new LogOptions();
				option.setVisible(true);
			}
		});
		this.btnLogOptions.setBounds(324, 638, 201, 23);
		this.contentPane.add(this.btnLogOptions);
		
		this.lbl1 = new JLabel("when a console will not suffice ..........");
		this.lbl1.setBounds(53, 642, 200, 14);
		this.contentPane.add(this.lbl1);
		
	}
	
	public void print(String string) {
		this.textArea.append(string);
	}
	
	public String getText() {
		return this.textArea.getText();
	}
	
}
