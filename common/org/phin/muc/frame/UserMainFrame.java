package org.phin.muc.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.phin.muc.util.MenuHandler;

public class UserMainFrame extends MultiUtilityFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	private MenuHandler handler;

	public UserMainFrame() {
		// create gui
		super.createGUI();
		super.setTitle("User Main Frame");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// contentPane related invocations
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		super.colorInit(this.contentPane);
		this.setContentPane(this.contentPane);
		
		this.handler = new MenuHandler();
		this.handler.userMenuInit(this);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}

}
