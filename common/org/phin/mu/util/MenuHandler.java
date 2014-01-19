package org.phin.mu.util;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.phin.mu.dialog.DialogOptionsDialog;
import org.phin.mu.dialog.ExitDialog;
import org.phin.mu.dialog.LogoutDialog;
import org.phin.mu.dialog.RGBDialog;
import org.phin.mu.frame.AdminMainFrame;
import org.phin.mu.frame.ConsoleFrame;
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
	
	// file menu items
	private JMenuItem logoutItem;
	private JMenuItem reloadItem;
	private JMenuItem exitItem;
	
	// Edit menu things
	private JMenuItem RGBItem;
	private JMenuItem dialogItem;
	private JMenuItem credentialItem;
	
	public final void initMenu(final JFrame frame) {
		this.bar = new JMenuBar();
		
		// sets the frames menu bar
		frame.setJMenuBar(this.bar);
		
		// menu instantiations 
		this.fileMenu = new JMenu("File");
		this.helpMenu = new JMenu("Help");
		this.appMenu = new JMenu ("Applications");
		this.editMenu = new JMenu("Edit");
		
		// file menu related things
		this.logoutItem = new JMenuItem("Logout");
		this.logoutItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (Strings.logoutPrompt) {
					LogoutDialog dialog = new LogoutDialog();
					dialog.setVisible(true);
				} else {
					LoginFrame frame = new LoginFrame();
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
				Strings.consoleFrame.dispose();
				Strings.consoleFrame = new ConsoleFrame();
				
				Strings.adminFrame.dispose();
				Strings.adminFrame = new AdminMainFrame();
			}
		});
		this.fileMenu.add(this.reloadItem);
		
		this.fileMenu.addSeparator();
		
		this.exitItem = new JMenuItem ("Exit");
		this.exitItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (Strings.exitPrompt) {
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
		
		// edit menu related things
		this.RGBItem = new JMenuItem("RGB");
		this.RGBItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				RGBDialog dialog = new RGBDialog();
				dialog.setVisible(true);
			}
		});
		this.editMenu.add(this.RGBItem);
		
		this.dialogItem = new JMenuItem("Dialog box Options");
		this.dialogItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				DialogOptionsDialog dialog = new DialogOptionsDialog();
				dialog.setVisible(true);
			}
		});
		this.editMenu.add(this.dialogItem);
		
		// adds edit menu to the menu bar
		this.bar.add(this.editMenu);
	}
	
}
