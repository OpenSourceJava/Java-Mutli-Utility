package org.phin.muc.util;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.phin.cb1.frame.ChatBotFrame;
import org.phin.deskcalc.frame.BasicCalculatorFrame;
import org.phin.muc.dialog.DialogOptionsDialog;
import org.phin.muc.dialog.ExitDialog;
import org.phin.muc.dialog.LogoutDialog;
import org.phin.muc.dialog.MenuDialog;
import org.phin.muc.dialog.RGBDialog;
import org.phin.muc.dialog.ReloadDialog;
import org.phin.muc.frame.ConsoleFrame;
import org.phin.muc.frame.LogFrame;
import org.phin.muc.lib.Strings;

public class MenuHandler {

	// the menu bar
	private JMenuBar bar;
	
	// JMenus
	private JMenu fileMenu;
	private JMenu helpMenu;
	private JMenu appMenu;
	private JMenu editMenu;
	private JMenu windowMenu;
	
	// file menu items
	private JMenuItem logoutItem;
	private JMenuItem reloadItem;
	private JMenuItem exitItem;
	
	// Edit menu items
	private JMenuItem RGBItem;
	private JMenuItem dialogItem;
	private JMenuItem credentialItem;
	private JMenuItem menuItem;
	
	// App menu items
	private JMenuItem calculator;
	private JMenuItem chatBot;
	
	// window menu items
	private JMenuItem showConsoleItem;
	private JMenuItem startConsole;
	
	// help menu
	private JMenuItem aboutItem;
	
	public final void initMenu(final JFrame frame) {
		this.bar = new JMenuBar();
		
		// sets the frames menu bar
		frame.setJMenuBar(this.bar);
		
		// menu instantiations 
		this.fileMenu = new JMenu("File");
		this.helpMenu = new JMenu("Help"); 
		this.appMenu = new JMenu ("Applications");
		this.editMenu = new JMenu("Edit");
		this.windowMenu = new JMenu("Window");
		
		// FILE MENU -----------------------------------------------------------
		if (Strings.fileMenu) {
			this.logoutItem = new JMenuItem("Logout");
			this.logoutItem.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (Strings.logoutPrompt) {
						if (Strings.logoutDialog != null) {
							Strings.logoutDialog.dispose();
							Strings.logoutDialog = new LogoutDialog();
						} else {
							Strings.logoutDialog = new LogoutDialog();
						}
					} else {
						if (Strings.consoleFrame != null) {
							Strings.consoleFrame.dispose();
							Strings.adminFrame.dispose();
						}
					}
				}
			});
			this.fileMenu.add(this.logoutItem);
			
			this.reloadItem = new JMenuItem("Reload");
			this.reloadItem.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (Strings.reloadPrompt) {
						if (Strings.reloadDialog != null) {
							Strings.reloadDialog.dispose();
							Strings.reloadDialog = new ReloadDialog();
						} else {
							Strings.reloadDialog = new ReloadDialog();
						}
					} else {
						ReloadHandler.reloadUI();
					}
				}
			});
			this.fileMenu.add(this.reloadItem);
			
			this.fileMenu.addSeparator();
			
			this.menuItem = new JMenuItem("Menu bar options");
			this.menuItem.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (Strings.menuDialog != null) {
						Strings.menuDialog.dispose();
						Strings.menuDialog = new MenuDialog();
					} else {
						Strings.menuDialog = new MenuDialog();
					}
				}
			});
			this.fileMenu.add(this.menuItem);
			
			this.fileMenu.addSeparator();
			
			this.exitItem = new JMenuItem ("Exit");
			this.exitItem.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (Strings.exitPrompt) {
						if (Strings.exitDialog != null) {
							Strings.exitDialog.dispose();
							Strings.exitDialog = new ExitDialog();
						} else {
							Strings.exitDialog = new ExitDialog();
						}
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
		if (Strings.editMenu) {
			// edit menu related things
			this.RGBItem = new JMenuItem("RGB");
			this.RGBItem.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (Strings.rgbDialog != null) {
						Strings.rgbDialog.dispose();
						Strings.rgbDialog = new RGBDialog();
					} else {
						Strings.rgbDialog = new RGBDialog();
					}
				}
			});
			this.editMenu.add(this.RGBItem);
			
			this.dialogItem = new JMenuItem("Dialog box Options");
			this.dialogItem.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (Strings.dialogOptions != null) {
						Strings.dialogOptions.dispose();
						Strings.dialogOptions = new DialogOptionsDialog();
					} else {
						Strings.dialogOptions = new DialogOptionsDialog();
					}
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
		}
		
		// APP MENU -----------------------------------------------------------
		if (Strings.appMenu) {
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
			
			this.chatBot = new JMenuItem("Chat Bot");
			this.chatBot.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (Strings.chatBot != null) {
						Strings.chatBot.dispose();
						Strings.chatBot = new ChatBotFrame();
					} else {
						Strings.chatBot = new ChatBotFrame();
					}
				}
			});
			this.appMenu.add(this.chatBot);
			
			// adds app menu to the menu bar
			this.bar.add(this.appMenu);
			
		}
			
		// WINDOW MENU -----------------------------------------------------------
		if (Strings.windowMenu) {
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
		}
		
		// HELP MENU -----------------------------------------------------------
		this.aboutItem = new JMenuItem("about");
		this.aboutItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// display about dialog
			}
		});
		this.helpMenu.add(this.aboutItem);
		
		this.bar.add(this.helpMenu);
		
		// ----------------------------------------------------------------------------
	}
	
	public static void getMenuAsAdmin() {
		if (Strings.log != null) {
			if ((Strings.saveLogText) && (!Strings.log.getText().equals(""))) {
				final String text = Strings.log.getText();
				Strings.log.dispose();
				Strings.log = new LogFrame(text);
				Strings.log.setLocationRelativeTo(Strings.adminFrame);
			} else {
				Strings.log.dispose();
				Strings.log = new LogFrame();
				Strings.log.setLocationRelativeTo(Strings.adminFrame);
			}
		} else {
			Strings.log = new LogFrame();
			Strings.log.setLocationRelativeTo(Strings.adminFrame);
		}
		
		if (Strings.menuBar) {
			Strings.log.print("the menu bar is enabled \n");
		} else {
			Strings.log.print("the menu bar is disabled \n");
		}
		
		if (Strings.fileMenu) {
			Strings.log.print("the file menu is enabled \n");
		} else {
			Strings.log.print("the file menu is disabled \n");
		}
		
		if (Strings.editMenu) {
			Strings.log.print("the edit menu is enabled \n");
		} else {
			Strings.log.print("the edit menu is disabled \n");
		}
		
		if (Strings.helpMenu) {
			Strings.log.print("the help menu is enabled \n");
		} else {
			Strings.log.print("the help menu is disabled \n");
		}
		
		if (Strings.appMenu) {
			Strings.log.print("the app menu is enabled \n");
		} else {
			Strings.log.print("the app menu is disabled \n");
		}
		
		if (Strings.windowMenu) {
			Strings.log.print("the window menu is enabled \n");
		} else {
			Strings.log.print("the window menu is disabled \n");
		}
		
	}
	
}
