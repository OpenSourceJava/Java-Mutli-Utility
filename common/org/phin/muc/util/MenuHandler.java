package org.phin.muc.util;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.phin.deskcalc.frame.BasicCalculatorFrame;
import org.phin.muc.dialog.AboutDialog;
import org.phin.muc.dialog.ExitDialog;
import org.phin.muc.dialog.LogoutDialog;
import org.phin.muc.dialog.ReloadDialog;
import org.phin.muc.dialog.options.DialogPromptOptions;
import org.phin.muc.dialog.options.MenuBarOptions;
import org.phin.muc.dialog.options.RGBOptions;
import org.phin.muc.dialog.options.UserSettingOptions;
import org.phin.muc.frame.ComputerFrame;
import org.phin.muc.frame.ConsoleFrame;
import org.phin.muc.frame.LogFrame;
import org.phin.muc.lib.Strings;
import org.phin.muc.lib.UserSettings;

public class MenuHandler {

	// the menu bar
	private JMenuBar bar;
	
	// JMenus
	private JMenu fileMenu;
	private JMenu helpMenu;
	private JMenu appMenu;
	private JMenu editMenu;
	private JMenu windowMenu;
	private JMenu administrativeMenu;
	
	// file menu items
	private JMenuItem logoutItem;
	private JMenuItem reloadItem;
	private JMenuItem exitItem;
	private JMenuItem computerItem;  
	
	// Edit menu items
	private JMenuItem RGBItem;
	private JMenuItem dialogItem;
	private JMenuItem credentialItem;
	private JMenuItem menuItem;
	
	// App menu items
	private JMenuItem calculator;
	
	// window menu items
	private JMenuItem showConsoleItem;
	private JMenuItem startConsole;
	
	// help menu items
	private JMenuItem aboutItem;
	
	// admim menu items
	private JMenuItem userPrivileges;

	//private JMenuItem consolePrivileges;
	//private JMenuItem systemPrivileges;
	
	public final void initMenu(final JFrame frame) {
		this.bar = new JMenuBar();
		
		if (UserSettings.menuBar) {
			frame.setJMenuBar(this.bar);
		} else {
			ConsoleFrame.printMessage("warning: menu bar is disabled \n");
		}
		
		// menu instantiations 
		this.fileMenu = new JMenu("File");
		this.helpMenu = new JMenu("Help"); 
		this.appMenu = new JMenu ("Applications");
		this.editMenu = new JMenu("Edit");
		this.windowMenu = new JMenu("Window");
		this.administrativeMenu = new JMenu("Administrative"); 
		
		// FILE MENU -----------------------------------------------------------
		if (UserSettings.fileMenu) {
			this.logoutItem = new JMenuItem("Logout");
			this.logoutItem.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (UserSettings.logoutPrompt) {
						LogoutDialog dialog = new LogoutDialog();
						dialog.setVisible(true);
					} else {
						LoginHandler.logout();
					}
				}
			});
			this.fileMenu.add(this.logoutItem);
			
			this.reloadItem = new JMenuItem("Reload");
			this.reloadItem.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (UserSettings.reloadPrompt) {
						ReloadDialog dialog = new ReloadDialog();
						dialog.setVisible(true);
					} else {
						ReloadHandler.reloadUI();
					}
				}
			});
			this.fileMenu.add(this.reloadItem);
			
			this.computerItem = new JMenuItem("My Computer");
			this.computerItem.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (Strings.messageFrame != null) {
						if (UserSettings.saveLogText) {
							final String text = Strings.messageFrame.getText();
							Strings.messageFrame.dispose();
							Strings.messageFrame = new LogFrame(text);
							Strings.messageFrame.setLocation(frame.getX() + 400, frame.getY() + 25);
						} else {
							Strings.messageFrame.dispose();
							Strings.messageFrame = new LogFrame();
							Strings.messageFrame.setLocation(frame.getX() + 400, frame.getY() + 25);
						}
					} else {
						Strings.messageFrame = new LogFrame();
						Strings.messageFrame.setLocation(frame.getX() + 400, frame.getY() + 25);
					}
					
					if (Strings.compFrame != null) {
						Strings.compFrame.dispose();
						Strings.compFrame = new ComputerFrame();
					} else {
						Strings.compFrame = new ComputerFrame();
					}
				}
			});
			this.fileMenu.add(this.computerItem);
			
			this.fileMenu.addSeparator();
			
			if (Strings.isAdmin) {
				this.menuItem = new JMenuItem("Menu bar options");
				this.menuItem.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						MenuBarOptions option = new MenuBarOptions();
						option.setVisible(true);
					}
				});
				this.fileMenu.add(this.menuItem);
				
				this.fileMenu.addSeparator();
			} 
			
			this.exitItem = new JMenuItem ("Exit");
			this.exitItem.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (UserSettings.exitPrompt) {
						ExitDialog dialog = new ExitDialog();
						dialog.setVisible(true);
					} else {
						System.exit(0);
					}
				}
			});
			this.fileMenu.add(this.exitItem);
			
			// adds the file menu to the menuBar
			this.bar.add(this.fileMenu);
		} else {
			ConsoleFrame.printMessage("warning: file menu disabled");
		}
		
		// EDIT MENU -----------------------------------------------------------
		if (UserSettings.editMenu) {
			// edit menu related things
			this.RGBItem = new JMenuItem("RGB");
			this.RGBItem.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					RGBOptions option = new RGBOptions();
					option.setVisible(true);
				}
			});
			this.editMenu.add(this.RGBItem);
			
			this.dialogItem = new JMenuItem("Dialog Box Options");
			this.dialogItem.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					DialogPromptOptions option = new DialogPromptOptions();
					option.setVisible(true);
				}
			});
			this.editMenu.add(this.dialogItem);
			
			this.credentialItem = new JMenuItem("password/username");
			this.credentialItem.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO
				}
			});
			
			// adds edit menu to the menu bar
			this.bar.add(this.editMenu);
		} else {
			ConsoleFrame.printMessage("warning: edit menu is disabled \n");
		}
		
		// ADMIN MENU -----------------------------------------------------------
		if (UserSettings.adminMenu) {
			if (Strings.isAdmin) {
				this.userPrivileges = new JMenuItem("User Privileges");
				this.userPrivileges.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						UserSettingOptions option = new UserSettingOptions();
						option.setVisible(true);
					}
				});
				this.administrativeMenu.add(this.userPrivileges);
				
				this.administrativeMenu.addSeparator();
				
				this.bar.add(this.administrativeMenu);		
			} else {
				ConsoleFrame.printMessage("warning: insufficient privilege level  \n");
			}
		} else {
			ConsoleFrame.printMessage("warning: admin menu disabled \n");
		}
		
		// APP MENU -----------------------------------------------------------
		if (UserSettings.appMenu) {
			this.calculator = new JMenuItem("Calculator");
			this.calculator.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) { 
					if (Strings.calculator != null) {
						Strings.calculator.dispose();
						Strings.calculator = new BasicCalculatorFrame();
					} else {
						Strings.calculator = new BasicCalculatorFrame();
					}
				}
			});
			this.appMenu.add(this.calculator);
			
			// adds app menu to the menu bar
			this.bar.add(this.appMenu);
			
		} else {
			ConsoleFrame.printMessage("warning: app menu is disabled \n");
		}
			
		// WINDOW MENU -----------------------------------------------------------
		if (UserSettings.windowMenu) {
			this.startConsole = new JMenuItem("Console");
			this.startConsole.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (Strings.consoleFrame != null) {
						Strings.consoleFrame.dispose();
						Strings.consoleFrame = new ConsoleFrame();
					} else {
						Strings.consoleFrame = new ConsoleFrame();
					}
				}
			});
			this.windowMenu.add(this.startConsole);
			
			this.showConsoleItem = new JMenuItem("Console Options");
			this.showConsoleItem.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO
				}
			});
			this.windowMenu.add(this.showConsoleItem);
			
			// adds the window menu to the menu bar
			this.bar.add(this.windowMenu);
		} else {
			ConsoleFrame.printMessage("warning: window menu is disabled \n");
		}
		
		// HELP MENU -----------------------------------------------------------
		if (UserSettings.helpMenu) {
			this.aboutItem = new JMenuItem("about");
			this.aboutItem.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					AboutDialog dialog = new AboutDialog();
					dialog.setVisible(true);
				}
			});
			this.helpMenu.add(this.aboutItem);
			
			this.bar.add(this.helpMenu);
		} else {
			ConsoleFrame.printMessage("warning: help menu is disabled \n");
		}
		
		// ----------------------------------------------------------------------------
	}
	
	public void userMenuInit(final JFrame frame) {
		
		if (UserSettings.userMenuBar) {
			this.bar = new JMenuBar();
			frame.setJMenuBar(this.bar);
			
			// FILE MENU -----------------------------------------------------------
			if (UserSettings.userFileMenu) {
				this.fileMenu = new JMenu("File");
				this.logoutItem = new JMenuItem("Logout");
				this.logoutItem.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						if (UserSettings.logoutPrompt) {
							LogoutDialog dialog = new LogoutDialog();
							dialog.setVisible(true);
						} else {
							LoginHandler.logout();
						}
					}
				});
				this.fileMenu.add(this.logoutItem);
				
				this.reloadItem = new JMenuItem("Reload");
				this.reloadItem.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						if (UserSettings.reloadPrompt) {
							ReloadDialog dialog = new ReloadDialog();
							dialog.setVisible(true);
						} else {
							ReloadHandler.reloadUI();
						}
					}
				});
				this.fileMenu.add(this.reloadItem);
				
				this.computerItem = new JMenuItem("My Computer");
				this.computerItem.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						if (Strings.isAdmin) {
							if (Strings.messageFrame != null) {
								if (UserSettings.saveLogText) {
									final String text = Strings.messageFrame.getText();
									Strings.messageFrame.dispose();
									Strings.messageFrame = new LogFrame(text);
									Strings.messageFrame.setLocation(frame.getX() + 400, frame.getY() + 25);
								} else {
									Strings.messageFrame.dispose();
									Strings.messageFrame = new LogFrame();
									Strings.messageFrame.setLocation(frame.getX() + 400, frame.getY() + 25);
								}
							} else {
								Strings.messageFrame = new LogFrame();
								Strings.messageFrame.setLocation(frame.getX() + 400, frame.getY() + 25);
							}
						} else {
							if (UserSettings.userLog) {
								if (Strings.messageFrame != null) {
									if (UserSettings.saveLogText) {
										final String text = Strings.messageFrame.getText();
										Strings.messageFrame.dispose();
										Strings.messageFrame = new LogFrame(text);
										Strings.messageFrame.setLocation(frame.getX() + 400, frame.getY() + 25);
									} else {
										Strings.messageFrame.dispose();
										Strings.messageFrame = new LogFrame();
										Strings.messageFrame.setLocation(frame.getX() + 400, frame.getY() + 25);
									}
								} else {
									Strings.messageFrame = new LogFrame();
									Strings.messageFrame.setLocation(frame.getX() + 400, frame.getY() + 25);
								}
							} else {
								ConsoleFrame.printMessage("warning: log has been disabled \n");
							}
						}
						
						if (Strings.compFrame != null) {
							Strings.compFrame.dispose();
							Strings.compFrame = new ComputerFrame();
						} else {
							Strings.compFrame = new ComputerFrame();
						}
					}
				});
				this.fileMenu.add(this.computerItem);
				
				this.fileMenu.addSeparator();
				
				this.exitItem = new JMenuItem ("Exit");
				this.exitItem.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						if (UserSettings.exitPrompt) {
							ExitDialog dialog = new ExitDialog();
							dialog.setVisible(true);
						} else {
							System.exit(0);
						}
					}
				});
				this.fileMenu.add(this.exitItem);
				
				// adds the file menu to the menuBar
				this.bar.add(this.fileMenu);
			} else {
				ConsoleFrame.printMessage("warning: file menu disabled");
			}
			
			// EDIT MENU -----------------------------------------------------------
			if (UserSettings.userEditMenu) {
				// edit menu related things
				this.editMenu = new JMenu("Edit");
				this.RGBItem = new JMenuItem("RGB");
				this.RGBItem.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						RGBOptions option = new RGBOptions();
						option.setVisible(true);
					}
				});
				this.editMenu.add(this.RGBItem);
				
				this.dialogItem = new JMenuItem("Dialog Box Options");
				this.dialogItem.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						DialogPromptOptions option = new DialogPromptOptions();
						option.setVisible(true);
					}
				});
				this.editMenu.add(this.dialogItem);
				
				this.credentialItem = new JMenuItem("Change Password");
				this.credentialItem.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO
					}
				});
				
				// adds edit menu to the menu bar
				this.bar.add(this.editMenu);
			} else {
				ConsoleFrame.printMessage("warning: edit menu is disabled \n");
			}
			
			// APP MENU -----------------------------------------------------------
			if (UserSettings.userAppMenu) {
				this.appMenu = new JMenu("Applications");
				this.calculator = new JMenuItem("Calculator");
				this.calculator.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) { 
						if (Strings.calculator != null) {
							Strings.calculator.dispose();
							Strings.calculator = new BasicCalculatorFrame();
						} else {
							Strings.calculator = new BasicCalculatorFrame();
						}
					}
				});
				this.appMenu.add(this.calculator);
				
				// adds app menu to the menu bar
				this.bar.add(this.appMenu);
				
			} else {
				ConsoleFrame.printMessage("warning: app menu is disabled \n");
			}
				
			// WINDOW MENU -----------------------------------------------------------
			if (UserSettings.userWindowMenu) {
				this.windowMenu = new JMenu("Window"); 
				this.startConsole = new JMenuItem("Console");
				this.startConsole.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						if (Strings.consoleFrame != null) {
							Strings.consoleFrame.dispose();
							Strings.consoleFrame = new ConsoleFrame();
						} else {
							Strings.consoleFrame = new ConsoleFrame();
						}
					}
				});
				this.windowMenu.add(this.startConsole);
				
				this.showConsoleItem = new JMenuItem("Console Options");
				this.showConsoleItem.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO
					}
				});
				this.windowMenu.add(this.showConsoleItem);
				
				// adds the window menu to the menu bar
				this.bar.add(this.windowMenu);
			} else {
				ConsoleFrame.printMessage("warning: window menu is disabled \n");
			}
			
			// HELP MENU -----------------------------------------------------------
			if (UserSettings.userHelpMenu) {
				this.helpMenu = new JMenu("Help");
				this.aboutItem = new JMenuItem("about");
				this.aboutItem.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						AboutDialog dialog = new AboutDialog();
						dialog.setVisible(true);
					}
				});
				this.helpMenu.add(this.aboutItem);
				
				this.bar.add(this.helpMenu);
			} else {
				ConsoleFrame.printMessage("warning: help menu is disabled \n");
			}
			
			
		}
	}
	
	public static void getMenuAsAdmin() {
		if (Strings.messageFrame != null) {
			if ((UserSettings.saveLogText) && (!Strings.messageFrame.getText().equals(""))) {
				final String text = Strings.messageFrame.getText();
				Strings.messageFrame.dispose();
				Strings.messageFrame = new LogFrame(text);
				Strings.messageFrame.setLocationRelativeTo(Strings.adminFrame);
			} else {
				Strings.messageFrame.dispose();
				Strings.messageFrame = new LogFrame();
				Strings.messageFrame.setLocationRelativeTo(Strings.adminFrame);
			}
		} else {
			Strings.messageFrame = new LogFrame();
			Strings.messageFrame.setLocationRelativeTo(Strings.adminFrame);
		}
		
		if (UserSettings.menuBar) {
			Strings.messageFrame.print("the menu bar is enabled \n");
		} else {
			Strings.messageFrame.print("the menu bar is disabled \n");
		}
		
		if (UserSettings.fileMenu) {
			Strings.messageFrame.print("the file menu is enabled \n");
		} else {
			Strings.messageFrame.print("the file menu is disabled \n");
		}
		
		if (UserSettings.editMenu) {
			Strings.messageFrame.print("the edit menu is enabled \n");
		} else {
			Strings.messageFrame.print("the edit menu is disabled \n");
		}
			
		if (UserSettings.helpMenu) {
			Strings.messageFrame.print("the help menu is enabled \n");
		} else {
			Strings.messageFrame.print("the help menu is disabled \n");
		}
		
		if (UserSettings.appMenu) {
			Strings.messageFrame.print("the app menu is enabled \n");
		} else {
			Strings.messageFrame.print("the app menu is disabled \n");
		}
		
		if (UserSettings.windowMenu) {
			Strings.messageFrame.print("the window menu is enabled \n");
		} else {
			Strings.messageFrame.print("the window menu is disabled \n");
		}
		
	}
	
}
