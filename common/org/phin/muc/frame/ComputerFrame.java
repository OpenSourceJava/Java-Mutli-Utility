package org.phin.muc.frame;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.phin.muc.dialog.options.CustomCMDOptions;
import org.phin.muc.lib.Strings;
import org.phin.muc.lib.UserSettings;
import org.phin.muc.util.GeneratorHandler;
import org.phin.muc.util.SystemHandler;

public class ComputerFrame extends MultiUtilityFrame {

	private static final long serialVersionUID = 1L;
	
	// contentPane
	private JPanel contentPane;
	
	// labels
	private JLabel lblInfo1;
	private JLabel separator1;
	private JLabel lblInfo3;
	private JLabel lblInfo2;
	private JLabel label;
	
	// buttons
	private JButton btnJavaVersion;
	private JButton btnJavaInstallDirectory;
	private JButton btnOsVersion;
	private JButton btnOsName;
	private JButton btnSystemArchetecture;
	private JButton btnJavaVendorUrl;
	private JButton btnJavaVendor;
	private JButton btnUserWD;
	private JButton btnUsersHD;
	private JButton btnUserName;
	private JButton btnListJavaProps;
	private JButton btnListUserProps;
	private JButton btnListSystemProps;
	private JButton btnFreeRam;
	private JButton btnRunGarbageCollector;
	private JButton btnGetProcessors;
	private JButton btnMaximumRam;
	private JButton btnTotalRam;
	private JButton btnDefinitions;
	private JButton btnStartNotepad;
	private JButton btnRegedit;
	private JButton btnCMD;
	private JButton btnPS;

	private JButton btnStartCustomCMD;

	private JButton btnCustomCMDSettings;

	private JLabel lblInfo;
	
	public ComputerFrame() {
		this.createGUI();
	}
	
	@Override
	protected void createGUI() {
		// create gui
		super.createGUI();
		super.setTitle("My Computer");

		// contentPane related invocations
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		super.colorInit(this.contentPane);
		this.setContentPane(this.contentPane);
		
		this.lblInfo1 = new JLabel("Windows Functions");
		this.lblInfo1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblInfo1.setBounds(20, 11, 141, 28);
		this.contentPane.add(this.lblInfo1);
		
		this.btnCMD = new JButton("Start Command Prompt");
		this.btnCMD.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (Strings.isAdmin) {
					try {
						Runtime.getRuntime().exec("cmd /c start cmd");
					} catch (Exception e1) {
						ConsoleFrame.printMessage("error: could not create process cmd.exe\n");
						e1.printStackTrace();
					} 
				} else {
					if (UserSettings.userCMD) {
						try {
							Runtime.getRuntime().exec("cmd /c start cmd");
						} catch (Exception e1) {
							ConsoleFrame.printMessage("error: could not create process cmd.exe");
							e1.printStackTrace();
						}
					} else {
						ConsoleFrame.printMessage("error: command prompt has been disabled\n");
						throw new SecurityException();
					}
				}
			}
		});
		this.btnCMD.setBounds(10, 50, 151, 23);
		this.contentPane.add(this.btnCMD);
		
		this.btnPS = new JButton("start powershell");
		this.btnPS.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (Strings.isAdmin) {
					try {
						Runtime.getRuntime().exec("powershell /c start powershell");
					} catch (Exception e1) {
						ConsoleFrame.printMessage("error: could not create process powershell.exe\n");
						e1.printStackTrace();
					} 
				} else {
					if (UserSettings.userCMD) {
						try {
							Runtime.getRuntime().exec("powershell /c start powershell");
						} catch (Exception e1) {
							ConsoleFrame.printMessage("error: could not create process powershell.exe\n");
							e1.printStackTrace();
						}
					} else {
						ConsoleFrame.printMessage("error: powershell has been disabled\n");
						throw new SecurityException();
					}
				}
			}
		});
		this.btnPS.setBounds(10, 84, 151, 23);
		this.contentPane.add(this.btnPS);
		
		this.separator1 = new JLabel("------------------------------------------------------------------------------------");
		this.separator1.setBounds(10, 324, 363, 14);
		this.contentPane.add(this.separator1);
		
		this.btnJavaVersion = new JButton("Java Version");
		this.btnJavaVersion.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String string = System.getProperty("java.version");
				Strings.messageFrame.print("java version = " + string + "\n");
			}
		});
		this.btnJavaVersion.setBounds(10, 349, 141, 23);
		this.contentPane.add(this.btnJavaVersion);
		
		this.btnJavaVendorUrl = new JButton("java vendor url");
		this.btnJavaVendorUrl.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String string = System.getProperty("java.vendor.url");
				Strings.messageFrame.print("java vendor url = " + string + "\n");
			}
		});
		this.btnJavaVendorUrl.setBounds(10, 383, 141, 23);
		this.contentPane.add(this.btnJavaVendorUrl);
		
		this.btnJavaVendor = new JButton("java vendor");
		this.btnJavaVendor.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String string = System.getProperty("java.vendor");
				Strings.messageFrame.print("java vendor = " + string + "\n");
			}
		});
		this.btnJavaVendor.setBounds(10, 417, 141, 23);
		this.contentPane.add(this.btnJavaVendor);
		
		this.btnSystemArchetecture = new JButton("system architecture");
		this.btnSystemArchetecture.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String string = System.getProperty("os.arch");
				Strings.messageFrame.print("system architecture = " + string + "\n");
			}
		});
		this.btnSystemArchetecture.setBounds(10, 511, 141, 23);
		this.contentPane.add(this.btnSystemArchetecture);
		
		this.btnOsName = new JButton("OS name");
		this.btnOsName.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String string = System.getProperty("os.name");
				Strings.messageFrame.print("system name = " + string + "\n");
			}
		});
		this.btnOsName.setBounds(10, 545, 141, 23);
		this.contentPane.add(this.btnOsName);
		
		this.btnOsVersion = new JButton("OS version");
		this.btnOsVersion.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String string = System.getProperty("os.version");
				Strings.messageFrame.print("system version = " + string + "\n");
			}
		});
		this.btnOsVersion.setBounds(10, 579, 141, 23);
		this.contentPane.add(this.btnOsVersion);
	
		this.btnJavaInstallDirectory = new JButton("java install directory");
		this.btnJavaInstallDirectory.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String string = System.getProperty("java.home");
				Strings.messageFrame.print("java install directory = " + string + "\n");
			}
		});
		this.btnJavaInstallDirectory.setBounds(10, 452, 141, 23);
		this.contentPane.add(this.btnJavaInstallDirectory);
		
		// WD stands for working directory 
		this.btnUserWD = new JButton("users working directory");
		this.btnUserWD.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String string = System.getProperty("user.dir");
				Strings.messageFrame.print("user working directory  = " + string + "\n");
			}
		});
		this.btnUserWD.setBounds(161, 349, 153, 23);
		this.contentPane.add(this.btnUserWD);
		
		// HD stands for home directory 
		this.btnUsersHD = new JButton("users home directory");
		this.btnUsersHD.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String string = System.getProperty("user.home");
				Strings.messageFrame.print("users home directory  = " + string + "\n");
			}
		});
		this.btnUsersHD.setBounds(161, 383, 133, 23);
		this.contentPane.add(this.btnUsersHD);
		
		this.btnUserName = new JButton("user name");
		this.btnUserName.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String string = System.getProperty("user.name");
				Strings.messageFrame.print("users name  = " + string + "\n");
			}
		});
		this.btnUserName.setBounds(161, 417, 133, 23);
		this.contentPane.add(this.btnUserName);
		
		this.btnListJavaProps = new JButton("list Java props");
		this.btnListJavaProps.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String string1 = System.getProperty("java.version");
				Strings.messageFrame.print("java version = " + string1 + "\n");
				
				String string2 = System.getProperty("java.vendor.url");
				Strings.messageFrame.print("java vendor url = " + string2 + "\n");
				
				String string3 = System.getProperty("java.vendor");
				Strings.messageFrame.print("java vendor = " + string3 + "\n");
				
				String string4 = System.getProperty("java.home");
				Strings.messageFrame.print("java install directory = " + string4 + "\n");
			}
		});
		this.btnListJavaProps.setBounds(10, 638, 125, 23);
		this.contentPane.add(this.btnListJavaProps);
		
		this.btnListUserProps = new JButton("list user props");
		this.btnListUserProps.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String string1 = System.getProperty("user.dir");
				Strings.messageFrame.print("user working directory  = " + string1 + "\n");
				
				String string2 = System.getProperty("user.home");
				Strings.messageFrame.print("users home directory  = " + string2 + "\n");
				
				String string = System.getProperty("user.name");
				Strings.messageFrame.print("users name  = " + string + "\n");
			}
		});
		this.btnListUserProps.setBounds(145, 638, 133, 23);
		this.contentPane.add(this.btnListUserProps);
		
		this.btnListSystemProps = new JButton("list system props");
		this.btnListSystemProps.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String string1 = System.getProperty("os.name");
				Strings.messageFrame.print("system name  = " + string1 + "\n");
				
				String string2 = System.getProperty("os.version");
				Strings.messageFrame.print("system version  = " + string2 + "\n");
				
				String string3 = System.getProperty("os.arch");
				Strings.messageFrame.print("system architecture  = " + string3 + "\n");
			}
		});
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
					ConsoleFrame.printMessage("error: could not create process notepad.exe \n");
					e1.printStackTrace();
				}
			}
		});
		this.btnStartNotepad.setBounds(10, 118, 151, 23);
		this.contentPane.add(this.btnStartNotepad);
		
		this.btnRegedit = new JButton("regedit");
		this.btnRegedit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (Strings.isAdmin) {
					try {
						GeneratorHandler.createCustomCMD(UserSettings.CMD_TITLE, UserSettings.CMD_TEXT_COLOR, UserSettings.CMD_POINTER);
						Runtime.getRuntime().exec("regedit");
					} catch (IOException e2) {
						ConsoleFrame.printMessage("error: could not create process regedit.exe \n");
						e2.printStackTrace();
					}
				} else {
					if (UserSettings.userRegedit) {
						try {
							GeneratorHandler.createCustomCMD(UserSettings.CMD_TITLE, UserSettings.CMD_TEXT_COLOR, UserSettings.CMD_POINTER);
							Runtime.getRuntime().exec("regedit");
						} catch (IOException e2) {
							ConsoleFrame.printMessage("error: could not create process regedit.exe \n");
							e2.printStackTrace();
						}
					} else {
						ConsoleFrame.printMessage("command prompt has been disabled");
					}
				}
			}
		});
		this.btnRegedit.setBounds(10, 152, 151, 23);
		this.contentPane.add(this.btnRegedit);
		
		this.lblInfo2 = new JLabel("Linux Functions");
		this.lblInfo2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblInfo2.setBounds(171, 11, 141, 28);
		this.contentPane.add(this.lblInfo2);
		
		this.label = new JLabel("------------------------------------------------------------------------------------");
		this.label.setBounds(10, 486, 363, 14);
		this.contentPane.add(this.label);
		
		this.btnFreeRam = new JButton("current free RAM");
		this.btnFreeRam.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				SystemHandler.getRAM();
			}
		});
		this.btnFreeRam.setBounds(161, 511, 141, 23);
		this.contentPane.add(this.btnFreeRam);
		
		this.btnRunGarbageCollector = new JButton("run garbage collector");
		this.btnRunGarbageCollector.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				SystemHandler.runGC();
			}
		});
		this.btnRunGarbageCollector.setBounds(161, 545, 141, 23);
		this.contentPane.add(this.btnRunGarbageCollector);
		
		this.btnGetProcessors = new JButton("get processors");
		this.btnGetProcessors.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				SystemHandler.getProcessors();
			}
		});
		this.btnGetProcessors.setBounds(161, 579, 141, 23);
		this.contentPane.add(this.btnGetProcessors);
		
		this.btnMaximumRam = new JButton("maximum RAM");
		this.btnMaximumRam.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				SystemHandler.getMaxRAM();
			}
		});
		this.btnMaximumRam.setBounds(312, 511, 141, 23);
		this.contentPane.add(this.btnMaximumRam);
		
		this.btnTotalRam = new JButton("total RAM");
		this.btnTotalRam.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				SystemHandler.getTotalRam();
			}
		});
		this.btnTotalRam.setBounds(312, 545, 141, 23);
		this.contentPane.add(this.btnTotalRam);
		
		this.btnDefinitions = new JButton("definitions");
		this.btnDefinitions.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Strings.messageFrame.print("RAM = Random Access Memory \n");
				Strings.messageFrame.print("JVM = Java Virtual Machine \n");
				Strings.messageFrame.print("Total RAM = total ram in the JVM \n");
				Strings.messageFrame.print("max RAM = most RAM the JVM will ever attempt to use \n");
				Strings.messageFrame.print("GC or Grabage Collector = the JVMs way of freeing unused objects \n");
			}
		});
		this.btnDefinitions.setBounds(312, 579, 141, 23);
		this.contentPane.add(this.btnDefinitions);
		
		this.btnStartCustomCMD = new JButton("start custom command prompt");
		this.btnStartCustomCMD.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (Strings.isAdmin) {
					try {
						GeneratorHandler.createCustomCMD(UserSettings.CMD_TITLE, UserSettings.CMD_TEXT_COLOR, UserSettings.CMD_POINTER);
						Runtime.getRuntime().exec("cmd /c start customCMD.bat");
					} catch (IOException e2) {
						ConsoleFrame.printMessage("error: could not create process customCMD.bat \n");
						e2.printStackTrace();
					}
				} else {
					if (UserSettings.userCMD) {
						try {
							GeneratorHandler.createCustomCMD(UserSettings.CMD_TITLE, UserSettings.CMD_TEXT_COLOR, UserSettings.CMD_POINTER);
							Runtime.getRuntime().exec("cmd /c start customCMD.bat");
						} catch (IOException e2) {
							ConsoleFrame.printMessage("error: could not create process customCMD.bat \n");
							e2.printStackTrace();
						}
					} else {
						ConsoleFrame.printMessage("command prompt has been disabled");
					}
				}
			}
		});
		this.btnStartCustomCMD.setBounds(10, 290, 204, 23);
		this.contentPane.add(this.btnStartCustomCMD);
		
		this.btnCustomCMDSettings = new JButton("custom command prompt settings");
		this.btnCustomCMDSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				CustomCMDOptions option = new CustomCMDOptions();
				option.setVisible(true);
			}
		});
		this.btnCustomCMDSettings.setBounds(10, 252, 204, 23);
		this.contentPane.add(this.btnCustomCMDSettings);
		
		this.lblInfo = new JLabel("a custom command prompt");
		this.lblInfo.setBounds(10, 224, 172, 14);
		this.contentPane.add(this.lblInfo);

		this.setVisible(true);
		
	}
}
