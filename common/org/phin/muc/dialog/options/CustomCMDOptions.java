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

public class CustomCMDOptions extends MultiUtilityDialog {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtCMDTitle;
	private JTextField txtCMDPointer;
	private JTextField txtCMDColor;
	private JLabel lblegRoot;
	private JLabel lblTheTextColor;
	private JButton btnDefaults;
	private JLabel lblSetsTheText;
	private JButton btnOkay;

	private JLabel lblSetsTheTitle;

	public CustomCMDOptions() {
		this.createGUI();
	}
	
	@Override
	public void createGUI() {
		// call the super createGUI
		super.createGUI();
				
		// title set
		super.setTitle("Custom Command Prompt Settings");
		super.setSize(400, 275);
				
		// contentPane related things
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		super.colorInit(this.contentPane);
		super.setContentPane(this.contentPane);
		
		this.txtCMDTitle = new JTextField();
		this.txtCMDTitle.setText("command prompt title");
		this.txtCMDTitle.setBounds(10, 32, 120, 20);
		this.txtCMDTitle.setColumns(10);
		this.contentPane.add(this.txtCMDTitle);
		
		this.lblSetsTheTitle = new JLabel("sets the title of the dos window");
		this.lblSetsTheTitle.setBounds(10, 7, 151, 14);
		this.contentPane.add(this.lblSetsTheTitle);
		
		this.txtCMDPointer = new JTextField();
		this.txtCMDPointer.setText("command line pointer");
		this.txtCMDPointer.setBounds(10, 113, 120, 20);
		this.txtCMDPointer.setColumns(10);
		this.contentPane.add(this.txtCMDPointer);
		
		this.lblSetsTheText = new JLabel("sets the command line pointer");
		this.lblSetsTheText.setBounds(10, 63, 167, 14);
		this.contentPane.add(this.lblSetsTheText);
		
		this.btnOkay = new JButton("Okay");
		this.btnOkay.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (!txtCMDTitle.getText().equals("") && !txtCMDTitle.getText().equals("command prompt title")) {
					UserSettings.CMD_TITLE = txtCMDTitle.getText();
				}
				
				if (!txtCMDColor.equals("")  && !txtCMDColor.getText().equals("command prompt color"))  {
					UserSettings.CMD_TEXT_COLOR = txtCMDColor.getText();
				}
				
				if (!txtCMDPointer.getText().equals("") && !txtCMDPointer.getText().equals("command prompt pointer")) {
					UserSettings.CMD_POINTER = txtCMDPointer.getText();
				}
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				dispose();
			}
		});
		this.btnOkay.setBounds(295, 206, 89, 30);
		this.contentPane.add(this.btnOkay);
		
		this.btnDefaults = new JButton("Defaults");
		this.btnDefaults.addMouseListener(new MouseAdapter()  {
			@Override
			public void mousePressed(MouseEvent e) {
				UserSettings.CMD_POINTER = "";
				UserSettings.CMD_TEXT_COLOR = "";
				UserSettings.CMD_TITLE = "";
			}
		});
		this.btnDefaults.setBounds(196, 206, 89, 30);
		this.contentPane.add(this.btnDefaults);
		
		this.txtCMDColor = new JTextField();
		this.txtCMDColor.setText("command prompt color");
		this.txtCMDColor.setBounds(10, 172, 127, 20);
		this.txtCMDColor.setColumns(10);
		this.contentPane.add(this.txtCMDColor);
		
		this.lblegRoot = new JLabel("(eg: root$)");
		this.lblegRoot.setBounds(10, 88, 86, 14);
		this.contentPane.add(this.lblegRoot);
		
		this.lblTheTextColor = new JLabel("the text color of the command prompt");
		this.lblTheTextColor.setBounds(10, 144, 203, 14);
		this.contentPane.add(this.lblTheTextColor);
	}
	
}
