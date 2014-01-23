package org.phin.muc.dialog;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.phin.muc.lib.Strings;
import org.phin.muc.lib.UserSettings;

public class MultiUtilityDialog extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public MultiUtilityDialog() {
		this.createGUI();
	}
	
	protected void createGUI() {
		// attempts to disable the admin/user frame 
		//and the console frame if applicable
		this.pendFrame();
		
		// general method calls
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		super.setResizable(false);
		super.setAlwaysOnTop(true);
		super.setEnabled(true);
		
		// sets the dialogs size
		this.setBounds(100, 100, Strings.DEFAULT_DIALOG_WIDTH, Strings.DEFAULT_DIALOG_HEIGHT);
		this.setSize(Strings.DEFAULT_DIALOG_DIM);
		
		super.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					dispose();
				}
			}
		}); 
		
	}
	
	@Override
	public void dispose() {
		super.dispose();
		
		if (Strings.isAdmin) {
			if (Strings.adminOptions != null) {
				Strings.adminOptions.setEnabled(true);
			}
			
			if (Strings.compFrame != null) {
				Strings.compFrame.setEnabled(true);
			}
			
			Strings.adminFrame.setEnabled(true);
		
		} else {
			if (Strings.userFrame != null) {
				Strings.userFrame.setEnabled(true);
			}
		}
		
		if (Strings.messageFrame != null) {
			Strings.messageFrame.setEnabled(true);
		}
		
		if (Strings.calculator != null) {
			Strings.calculator.setEnabled(true);
		}
		
		if (Strings.consoleFrame != null) {
			Strings.consoleFrame.setEnabled(true);
		}
		
	}
	
	/**
	 * simulates a 'pending' or 'stalling' of a frame by invoking the method 
	 * <code>setEnabled(false)</code>
	 */
	protected void pendFrame() {
		if (Strings.isAdmin) {
			if (Strings.adminFrame != null) {
				
				if (Strings.adminOptions != null) {
					Strings.adminOptions.setEnabled(false);
				}
				
				if (Strings.compFrame != null) {
					Strings.compFrame.setEnabled(false);
				}
				
				Strings.adminFrame.setEnabled(false);
				
			}
		} else {
			if (Strings.userFrame != null) {
				Strings.userFrame.setEnabled(false);
			}
		}
		
		if (Strings.messageFrame != null) {
			Strings.messageFrame.setEnabled(false);
		}
		
		if (Strings.calculator != null) {
			Strings.calculator.setEnabled(false);
		}
		
		if (Strings.consoleFrame != null) {
			Strings.consoleFrame.setEnabled(false);
		}

		this.requestFocus();
	}
	
	/**
	 * sets the color of the contentPane/
	 * 
	 * <p>
	 * note this is not used in this class its only here to serve
	 * as a simple way to manage the background color.
	 * </p>
	 * 
	 * @param contentPane the contentPane for the color to be set to
	 * 
	 */
	protected void setDialogColor(JPanel contentPane) {
		if ((UserSettings.DIALOG_RED != 0) && (UserSettings.DIALOG_GREEN != 0) && (UserSettings.DIALOG_BLUE != 0)) {
			contentPane.setBackground(new Color(UserSettings.DIALOG_RED, UserSettings.DIALOG_GREEN, UserSettings.DIALOG_BLUE));  
		} else {
			contentPane.setBackground(Color.DARK_GRAY);
		}
	}

}
