package org.phin.mu.dialog;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.phin.mu.lib.Strings;

public class RGBDialog extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtRed;
	private JTextField txtGreen;
	private JTextField txtJavaColors;
	private JTextField txtBlue;
	private JButton btnRevert;
	private JButton btnOkay;
	private JLabel lblInfo;
	private JLabel lblInfo2;

	public RGBDialog() {
		this.createGUI();
	}
	
	private void createGUI() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setEnabled(true);
		this.setVisible(true);
		this.setTitle("backgroud color changer");
		this.setLocationRelativeTo(null);
		
		// sets the dialogs size
		if ((Strings.CURRENT_DIALOG_HEIGHT != 0) && (Strings.CURRENT_DIALOG_WIDTH != 0)) {
			this.setBounds(100, 100, Strings.CURRENT_DIALOG_WIDTH, Strings.CURRENT_DIALOG_HEIGHT);
			this.setSize(Strings.CURRENT_DIALOG_DIM);
		} else {
			this.setBounds(100, 100, Strings.DEFAULT_DIALOG_WIDTH, Strings.DEFAULT_DIALOG_HEIGHT);
			this.setSize(Strings.DEFAULT_DIALOG_DIM);
		}
		
		// contentPane related things
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		this.setContentPane(this.contentPane);
		
		if ((Strings.DIALOG_RED != 0) && (Strings.DIALOG_GREEN != 0) && (Strings.DIALOG_BLUE != 0)) {
			this.contentPane.setBackground(new Color(Strings.DIALOG_RED, Strings.DIALOG_GREEN, Strings.DIALOG_BLUE));  
		} else {
			this.contentPane.setBackground(Color.LIGHT_GRAY);
		}
		
		this.btnRevert = new JButton("revert");
		this.btnRevert.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtRed.setText("Red");
				txtGreen.setText("Green");
				txtBlue.setText("Blue");
				txtJavaColors.setText("Java Colors");
				
				Strings.BLUE = 0;
				Strings.RED = 0;
				Strings.GREEN = 0;
			}
		});
		this.btnRevert.setBounds(60, 148, 90, 25);
		this.contentPane.add(this.btnRevert);
		
		this.btnOkay = new JButton("okay");
		this.btnOkay.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (!txtRed.getText().equals("Red") && (!txtGreen.getText().equals("Green") && (!txtRed.getText().equals("Red")))) {
					int red, green, blue;
					red = Integer.parseInt(txtRed.getText());
					green = Integer.parseInt(txtGreen.getText());
					blue = Integer.parseInt(txtBlue.getText());
					
					Strings.BLUE = blue;
					Strings.RED = red;
					Strings.GREEN = green;
				} 
				
				if (!txtJavaColors.getText().equals("Java Colors")) {
					System.out.println("not done yet"); // im too lazy to implement this ATM
				}
			}
		});
		this.btnOkay.setBounds(195, 149, 90, 25);
		this.contentPane.add(this.btnOkay);
		
		this.txtRed = new JTextField("Red");
		this.txtRed.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txtRed.getText().equals("Red")) {
					txtRed.setText("");
				}
			}
		});
		this.txtRed.setBounds(10, 50, 86, 20);
		this.txtRed.setColumns(10);
		this.contentPane.add(txtRed);
		
		this.txtGreen = new JTextField("Green");
		this.txtGreen.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txtGreen.getText().equals("Green")) {
					txtGreen.setText("");
				}
			}
		});
		this.txtGreen.setBounds(10, 81, 86, 20);
		this.txtGreen.setColumns(10);
		this.contentPane.add(this.txtGreen);
		
		this.txtJavaColors = new JTextField("Java Colors");
		this.txtJavaColors.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txtJavaColors.getText().equals("Java Colors")) {
					txtJavaColors.setText("");
				}		
			}
		});
		this.txtJavaColors.setBounds(248, 81, 86, 20);
		this.txtJavaColors.setColumns(10);
		this.contentPane.add(this.txtJavaColors);
		
		this.txtBlue = new JTextField("Blue");
		this.txtBlue.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txtBlue.getText().equals("Blue")) {
					txtBlue.setText("");
				}
			}
		});
		this.txtBlue.setBounds(10, 112, 86, 20);
		this.txtBlue.setColumns(10);	
		this.contentPane.add(this.txtBlue);
		
		// info labels
		this.lblInfo = new JLabel("choose the amount of red, green and blue to be in the background");
		this.lblInfo.setBounds(10, 11, 324, 14);
		this.contentPane.add(this.lblInfo);
		
		this.lblInfo2 = new JLabel("you will need to reload the app in order for changes to take affect");
		this.lblInfo2.setBounds(10, 25, 324, 14);
		this.contentPane.add(this.lblInfo2);
		
	}

}
