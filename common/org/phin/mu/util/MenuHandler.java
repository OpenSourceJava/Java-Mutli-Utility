package org.phin.mu.util;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.phin.cb1.frame.ChatBotFrame;
import org.phin.deskcalc.frame.BasicCalculatorFrame;
import org.phin.mu.dialog.DialogOptionsDialog;
import org.phin.mu.dialog.ExitDialog;
import org.phin.mu.dialog.LogoutDialog;
import org.phin.mu.dialog.MenuDialog;
import org.phin.mu.dialog.RGBDialog;
import org.phin.mu.frame.AdminMainFrame;
import org.phin.mu.frame.ConsoleFrame;
import org.phin.mu.frame.LogFrame;
import org.phin.mu.frame.LoginFrame;
import org.phin.mu.lib.Strings;

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
	private JMenuItem console;
	
	// window menu items
	private JMenuItem showConsoleItem;
	
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
						JFrame dialog = new LogoutDialog();
						dialog.setVisible(true);
					} else {
						JFrame frame = new LoginFrame();
						frame.setVisible(true);
						
						// disposes of the universal admin frame and the console frame
						Strings.adminFrame.dispose();
						Strings.consoleFrame.dispose();
					}
				}
			});
			this.fileMenu.add(this.logoutItem);
			
			this.reloadItem = new JMenuItem("Reload");
			this.reloadItem.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					try {
						Runtime.getRuntime().exec("java -jar JMU.jar");
						System.exit(0);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
			this.fileMenu.add(this.reloadItem);
			
			this.fileMenu.addSeparator();
			
			this.menuItem = new JMenuItem("Menu bar options");
			this.menuItem.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					MenuDialog frame = new MenuDialog();
					frame.setVisible(true);
				}
			});
			this.fileMenu.add(this.menuItem);
			
			this.fileMenu.addSeparator();
			
			this.exitItem = new JMenuItem ("Exit");
			this.exitItem.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (Strings.exitPrompt) {
						JFrame dialog = new ExitDialog();
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
		if (Strings.editMenu) {
			// edit menu related things
			this.RGBItem = new JMenuItem("RGB");
			this.RGBItem.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					JFrame dialog = new RGBDialog();
					dialog.setVisible(true);
				}
			});
			this.editMenu.add(this.RGBItem);
			
			this.dialogItem = new JMenuItem("Dialog box Options");
			this.dialogItem.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					JFrame dialog = new DialogOptionsDialog();
					dialog.setVisible(true);
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
			
			this.console = new JMenuItem("Console");
			this.console.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (Strings.consoleFrame != null) {
						Strings.consoleFrame.dispose();
						Strings.consoleFrame = new ConsoleFrame();
					}
				}
			});
			this.appMenu.add(this.console);
			
			// adds app menu to the menu bar
			this.bar.add(this.appMenu);
		}
		
	}
	
	public static void getMenuAsAdmin() {
		if (Strings.log != null) {
			if (!Strings.log.getText().equals("")) {
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
