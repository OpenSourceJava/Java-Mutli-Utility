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
import org.phin.mu.util.ColorHandler;

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
	private JTextField txtDialogRed;
	private JTextField txtDialogGreen;
	private JTextField txtDialogBlue;

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
	
		this.setBounds(100, 100, Strings.DEFAULT_DIALOG_WIDTH, Strings.DEFAULT_DIALOG_HEIGHT);
		this.setSize(Strings.DEFAULT_DIALOG_DIM);
		
		// contentPane related things
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		this.setContentPane(this.contentPane);
		
		// sets the dialogs background color
		if ((Strings.DIALOG_RED != 0) && (Strings.DIALOG_GREEN != 0) && (Strings.DIALOG_BLUE != 0)) {
			this.contentPane.setBackground(new Color(Strings.DIALOG_RED, Strings.DIALOG_GREEN, Strings.DIALOG_BLUE));  
		} else {
			this.contentPane.setBackground(Color.DARK_GRAY);
		}
		
		this.btnRevert = new JButton("revert");
		this.btnRevert.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtRed.setText("Red");
				txtGreen.setText("Green");
				txtBlue.setText("Blue");
				
				txtDialogBlue.setText("Dialog Blue");
				txtDialogRed.setText("Dialog Red");
				txtDialogGreen.setText("Dialog Green");
				txtJavaColors.setText("Java Colors");
				
				Strings.BLUE = 0;
				Strings.RED = 0;
				Strings.GREEN = 0;
				
				Strings.DIALOG_BLUE = 0;
				Strings.DIALOG_GREEN = 0;
				Strings.DIALOG_RED = 0;
			}
		});
		this.btnRevert.setBounds(60, 148, 90, 25);
		this.contentPane.add(this.btnRevert);
		
		this.btnOkay = new JButton("okay");
		this.btnOkay.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (!txtRed.getText().equals("Red") && (!txtGreen.getText().equals("Green") && (!txtBlue.getText().equals("Blue")))) {
					int red, green, blue;
					red = Integer.parseInt(txtRed.getText());
					green = Integer.parseInt(txtGreen.getText());
					blue = Integer.parseInt(txtBlue.getText());
					
					Strings.BLUE = blue;
					Strings.RED = red;
					Strings.GREEN = green;
				} 
				
				if (!txtDialogRed.getText().equals("Dialog Red") && (!txtDialogGreen.getText().equals("Dialog Green") && (!txtDialogBlue.getText().equals("Dialog Blue")))) {
					int red, green, blue;
					red = Integer.parseInt(txtDialogRed.getText());
					green = Integer.parseInt(txtDialogGreen.getText());
					blue = Integer.parseInt(txtDialogBlue.getText());
					
					Strings.DIALOG_BLUE = blue;
					Strings.DIALOG_RED = red;
					Strings.DIALOG_GREEN = green;
				} 
				
				if (!txtJavaColors.getText().equals("Java Colors")) {
					String colorString = txtJavaColors.getText();
					ColorHandler.checkColor(colorString);
				}
				
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				dispose();
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
		
		this.txtDialogRed = new JTextField("Dialog Red");
		this.txtDialogRed.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txtDialogRed.getText().equals("Dialog Red")) {
					txtDialogRed.setText("");
				}
			}
		});
		this.txtDialogRed.setBounds(106, 50, 86, 20);
		this.txtDialogRed.setColumns(10);
		this.contentPane.add(this.txtDialogRed);
		
		this.txtDialogGreen = new JTextField("Dialog Green");
		this.txtDialogGreen.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txtDialogGreen.getText().equals("Dialog Green")) {
					txtDialogGreen.setText("");
				}
			}
		});
		this.txtDialogGreen.setBounds(106, 81, 86, 20);
		this.txtDialogGreen.setColumns(10);
		this.contentPane.add(this.txtDialogGreen);
		
		this.txtDialogBlue = new JTextField("Dialog Blue");
		this.txtDialogBlue.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txtDialogBlue.getText().equals("Dialog Blue")) {
					txtDialogBlue.setText("");
				}
			}
		});
		this.txtDialogBlue.setBounds(106, 112, 86, 20);
		this.txtDialogBlue.setColumns(10);
		this.contentPane.add(this.txtDialogBlue);
	
	}
}
