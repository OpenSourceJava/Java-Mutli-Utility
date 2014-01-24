package org.phin.muc.frame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import org.phin.muc.dialog.options.LogOptions;

public class LogFrame extends MultiUtilityFrame {

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
	
	@Override
	protected void createGUI() {
		super.createGUI();
		super.setTitle("Log");
		
		// contentPane related inokes
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		super.colorInit(this.contentPane);
		this.setContentPane(this.contentPane);
		
		this.textArea = new JTextArea();
		this.textArea.setBounds(10, 11, 674, 616);
		this.textArea.setEditable(false);
		this.contentPane.add(this.textArea);
		
		this.btnClear = new JButton("Clear");
		this.btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textArea.setText("");
			}
		});
		this.btnClear.setBounds(490, 638, 194, 23);
		this.contentPane.add(this.btnClear);
		
		this.btnLogOptions = new JButton("log options");
		this.btnLogOptions.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				LogOptions option = new LogOptions();
				option.setVisible(true);
			}
		});
		this.btnLogOptions.setBounds(279, 638, 201, 23);
		this.contentPane.add(this.btnLogOptions);
		
		this.lbl1 = new JLabel("when a console will not suffice ..........");
		this.lbl1.setBounds(53, 642, 200, 14);
		this.contentPane.add(this.lbl1);
		
		super.setLocationRelativeTo(null);
		super.setVisible(true);
		
	}
	
	public void print(String string) {
		this.textArea.append(string);
	}
	
	public String getText() {
		return this.textArea.getText();
	}
	
}
