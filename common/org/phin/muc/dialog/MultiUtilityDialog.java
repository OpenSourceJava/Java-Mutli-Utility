package org.phin.muc.dialog;

import static org.phin.muc.lib.UserSettings.DIALOG_BLUE;
import static org.phin.muc.lib.UserSettings.DIALOG_GREEN;
import static org.phin.muc.lib.UserSettings.DIALOG_RED;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.phin.muc.lib.Strings;

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
		
		if (Strings.adminOptions != null) {
			Strings.adminOptions.setEnabled(true);
		}
			
		if (Strings.compFrame != null) {
			Strings.compFrame.setEnabled(true);
		}
			
		if (Strings.isAdmin) {
			Strings.adminFrame.setEnabled(true);	
		}

		if (Strings.userFrame != null) {
				Strings.userFrame.setEnabled(true);
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
		if (Strings.adminOptions != null) {
					Strings.adminOptions.setEnabled(false);
		}
				
		if (Strings.compFrame != null) {
			Strings.compFrame.setEnabled(false);
		}
		
		if (Strings.adminFrame != null) {
			Strings.adminFrame.setEnabled(false);
		}
			
		if (Strings.userFrame != null) {
			Strings.userFrame.setEnabled(false);
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
	 * you must call this on your own
	 * 
	 * @param contentPane your classes contentPane / JPanel
	 * 
	 */
	protected void colorInit(JPanel contentPane) {
		if ((((DIALOG_RED <= 255 && DIALOG_RED >= 0)) && (DIALOG_GREEN <= 255 && DIALOG_GREEN >= 0) && (DIALOG_BLUE <= 255 && DIALOG_BLUE >= 0))) {
			contentPane.setBackground(new Color(DIALOG_RED, DIALOG_GREEN, DIALOG_BLUE));
		} else {
			contentPane.setBackground(Color.LIGHT_GRAY);
		}
		
	}

}
