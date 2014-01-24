package org.phin.muc.frame;

import static org.phin.muc.lib.UserSettings.BLUE;
import static org.phin.muc.lib.UserSettings.GREEN;
import static org.phin.muc.lib.UserSettings.RED;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.phin.muc.lib.Strings;

public class MultiUtilityFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public MultiUtilityFrame() {
		this.createGUI();
	}
	
	protected void createGUI() {
		// general method calls
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		super.setResizable(false);
		super.setEnabled(true);
		
		// sets the dialogs size
		super.setBounds(100, 100, Strings.DEFAULT_WIDTH, Strings.DEFAULT_HEIGHT);
		super.setSize(Strings.DEFAULT_DIM);
			
	}
	
	/**
	 * you must call this on your own
	 * 
	 * @param contentPane your classes contentPane / JPanel
	 * 
	 */
	protected void colorInit(JPanel contentPane) {
		if ((((RED <= 255 && RED >= 0)) && (GREEN <= 255 && GREEN >= 0) && (BLUE <= 255 && BLUE >= 0))) {
			contentPane.setBackground(new Color(RED, GREEN, BLUE));
		} else {
			contentPane.setBackground(Color.LIGHT_GRAY);
		}
	}

}
