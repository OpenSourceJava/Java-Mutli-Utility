package org.phin.mu.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.phin.mu.lib.Strings;

public class ComputerFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblInfo1;
	private JButton btnCMD;
	private JButton btnPS;
	private JLabel separator1;
	private JButton btnJavaVersion;
	private JButton btnJavaInstallDirectory;
	private JButton btnOsVersion;
	private JButton btnOsName;
	private JButton btnSystemArchetecture;
	private JLabel separator2;
	private JButton btnJavaVendorUrl;
	private JButton btnJavaVendor;
	private JButton btnUserWD;
	private JButton btnUsersHD;
	private JButton btnUserName;
	private JButton btnListJavaProps;
	private JButton btnListUserProps;
	private JButton btnListSystemProps;
	private JLabel lblInfo3;
	private JButton btnStartNotepad;
	private JButton btnRegedit;
	private JLabel lblInfo2;

	public ComputerFrame() {
		this.createGUI();
	}
	
	private void createGUI() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setEnabled(true);
		this.setVisible(true);
		this.setTitle("My Computer");
		this.setLocationRelativeTo(null);
		
		this.setSize(Strings.DEFAULT_DIM);
		
		// contentPane related invocations
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
		
		this.lblInfo1 = new JLabel("windows functions");
		this.lblInfo1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblInfo1.setBounds(20, 11, 141, 28);
		this.contentPane.add(this.lblInfo1);
		
		this.btnCMD = new JButton("start command prompt");
		this.btnCMD.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					Runtime.getRuntime().exec("cmd /c start cmd");
				} catch (Exception e1) {
					ConsoleFrame.print("could not create process cmd.exe");
					e1.printStackTrace();
				}
			}
		});
		this.btnCMD.setBounds(10, 50, 141, 23);
		this.contentPane.add(this.btnCMD);
		
		this.btnPS = new JButton("start powershell");
		this.btnPS.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					Runtime.getRuntime().exec("powershell /c start powershell");
				} catch (Exception e1) {
					ConsoleFrame.print("could not create process powershell.exe");
					e1.printStackTrace();
				}
			}
		});
		this.btnPS.setBounds(10, 84, 141, 23);
		this.contentPane.add(this.btnPS);
		
		this.separator1 = new JLabel("------------------------------------------------------------------------------------");
		this.separator1.setBounds(10, 324, 363, 14);
		this.contentPane.add(this.separator1);
		
		this.btnJavaVersion = new JButton("java version");
		this.btnJavaVersion.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (Strings.isLog) {
					
				} else {
					String string = System.getProperty("java.version");
					ConsoleFrame.print("java version = " + string);
				}
			}
		});
		this.btnJavaVersion.setBounds(10, 349, 141, 23);
		this.contentPane.add(this.btnJavaVersion);
		
		this.btnJavaVendorUrl = new JButton("java vendor url");
		this.btnJavaVendorUrl.setBounds(10, 383, 141, 23);
		this.contentPane.add(this.btnJavaVendorUrl);
		
		this.btnJavaVendor = new JButton("java vendor");
		this.btnJavaVendor.setBounds(10, 417, 141, 23);
		this.contentPane.add(this.btnJavaVendor);
		
		this.separator2 = new JLabel("-------------------------------------");
		this.separator2.setBounds(10, 486, 158, 14);
		this.contentPane.add(this.separator2);
		
		this.btnSystemArchetecture = new JButton("system architecture");
		this.btnSystemArchetecture.setBounds(10, 511, 141, 23);
		this.contentPane.add(this.btnSystemArchetecture);
		
		this.btnOsName = new JButton("OS name");
		this.btnOsName.setBounds(10, 545, 141, 23);
		this.contentPane.add(this.btnOsName);
		
		this.btnOsVersion = new JButton("OS version");
		this.btnOsVersion.setBounds(10, 579, 141, 23);
		this.contentPane.add(this.btnOsVersion);
	
		this.btnJavaInstallDirectory = new JButton("java install directory");
		this.btnJavaInstallDirectory.setBounds(10, 452, 141, 23);
		this.contentPane.add(this.btnJavaInstallDirectory);
		
		this.btnUserWD = new JButton("users working directory");
		this.btnUserWD.setBounds(161, 349, 153, 23);
		this.contentPane.add(this.btnUserWD);
		
		this.btnUsersHD = new JButton("users home directory");
		this.btnUsersHD.setBounds(161, 383, 133, 23);
		this.contentPane.add(this.btnUsersHD);
		
		this.btnUserName = new JButton("user name");
		this.btnUserName.setBounds(161, 417, 133, 23);
		this.contentPane.add(this.btnUserName);
		
		this.btnListJavaProps = new JButton("list Java props");
		this.btnListJavaProps.setBounds(10, 638, 125, 23);
		this.contentPane.add(this.btnListJavaProps);
		
		this.btnListUserProps = new JButton("list user props");
		this.btnListUserProps.setBounds(145, 638, 133, 23);
		this.contentPane.add(this.btnListUserProps);
		
		this.btnListSystemProps = new JButton("list system props");
		this.btnListSystemProps.setBounds(288, 638, 133, 23);
		this.contentPane.add(this.btnListSystemProps);
		
		this.lblInfo3 = new JLabel("lists all of the properties for either user, system or java ");
		this.lblInfo3.setBounds(10, 613, 315, 14);
		this.contentPane.add(this.lblInfo3);
		
		this.btnStartNotepad = new JButton("start notepad");
		this.btnStartNotepad.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					Runtime.getRuntime().exec("notepad");
				} catch (Exception e1) {
					ConsoleFrame.print("could not create process notepad.exe \n");
					e1.printStackTrace();
				}
			}
		});
		this.btnStartNotepad.setBounds(10, 118, 141, 23);
		this.contentPane.add(this.btnStartNotepad);
		
		this.btnRegedit = new JButton("regedit");
		this.btnRegedit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					Runtime.getRuntime().exec("regedit");
				} catch (Exception e1) {
					ConsoleFrame.print("could not create process regedit.exe \n");  
					ConsoleFrame.print("(most likley need admin privileges) \n");
					e1.printStackTrace();
				}
			}
		});
		this.btnRegedit.setBounds(10, 152, 141, 23);
		this.contentPane.add(this.btnRegedit);
		
		this.lblInfo2 = new JLabel("Linux Functions");
		this.lblInfo2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblInfo2.setBounds(171, 11, 141, 28);
		this.contentPane.add(this.lblInfo2);
		
	}
}
