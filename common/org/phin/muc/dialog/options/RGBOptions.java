package org.phin.muc.dialog.options;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.phin.muc.dialog.MultiUtilityDialog;
import org.phin.muc.lib.UserSettings;
import org.phin.muc.util.ColorHandler;
import org.phin.muc.util.ReloadHandler;

public class RGBOptions extends MultiUtilityDialog {

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
	private JTextField txtJavaDialogColors;

	public RGBOptions() {
		this.createGUI();
	}
	
	@Override
	protected void createGUI() {
		// call the super createGUI
		super.createGUI();
				
		// title set
		super.setTitle("Color Picker");
				
		// contentPane related things
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		super.colorInit(this.contentPane);
		super.setContentPane(this.contentPane);
		
		this.btnRevert = new JButton("Revert");
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
				
				UserSettings.BLUE = 90;
				UserSettings.RED = 90;
				UserSettings.GREEN = 90;
				
				UserSettings.DIALOG_BLUE = 64;
				UserSettings.DIALOG_GREEN = 64;
				UserSettings.DIALOG_RED = 64;
				
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				dispose();
			}
		});
		this.btnRevert.setBounds(10, 149, 140, 25);
		this.contentPane.add(this.btnRevert);
		
		this.btnOkay = new JButton("Okay (will issue a reload)");
		this.btnOkay.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				ColorHandler.frameRGB(txtRed.getText(), txtGreen.getText(), txtBlue.getText());
				ColorHandler.dialogRGB(txtDialogRed.getText(), txtDialogGreen.getText(), txtDialogBlue.getText());
				ColorHandler.checkColor(txtJavaColors.getText());
				ReloadHandler.reloadUI();
				
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				dispose();
			}
		});
		this.btnOkay.setBounds(160, 149, 174, 25);
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
		this.txtJavaColors.setBounds(227, 64, 107, 20);
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
		
		this.txtJavaDialogColors = new JTextField();
		this.txtJavaDialogColors.setText("Java Dialog Colors");
		this.txtJavaDialogColors.setBounds(227, 96, 107, 20);
		this.txtJavaDialogColors.setColumns(10);
		this.contentPane.add(this.txtJavaDialogColors);
		
		this.setVisible(true);
	
	}
}
