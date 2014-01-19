package org.phin.mu;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.phin.mu.frame.LoginFrame;

public class Main {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new LoginFrame();
				frame.setVisible(true);
			}
		});
	}

}
