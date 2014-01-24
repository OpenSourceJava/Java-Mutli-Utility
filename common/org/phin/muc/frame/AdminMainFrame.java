package org.phin.muc.frame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.phin.muc.lib.Strings;
import org.phin.muc.lib.UserSettings;
import org.phin.muc.util.MenuHandler;

public class AdminMainFrame extends MultiUtilityFrame {

	private static final long serialVersionUID = 1L;
	
	// contentPane
	private JPanel contentPane;
	
	// menu object
	private MenuHandler handler;
	
	// labels
	private JLabel label;
	
	// buttons
	private JButton btnMyComputer;
	private JButton btnLog;
	private JButton btnApplicationOptions;
	private JButton btnNetworkOptions;

	public AdminMainFrame() {
		this.createGUI();
	}
	
	@Override
	protected void createGUI() {
		super.createGUI();
		
		super.setTitle("Admin Main Frame");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		// contentPane related inokes
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		super.colorInit(this.contentPane);
		this.setContentPane(this.contentPane);
		
		// menu init
		this.handler = new MenuHandler();
		this.handler.initMenu(this);
		
		this.btnMyComputer = new JButton("My Computer");
		this.btnMyComputer.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				initLogFrame();
				
				if (Strings.compFrame != null) {
					Strings.compFrame.dispose();
					Strings.compFrame = new ComputerFrame();
					Strings.compFrame.setLocation(Strings.messageFrame.getX() - 800, getY() - 25);
				} else {
					Strings.compFrame = new ComputerFrame();
					Strings.compFrame.setLocation(Strings.messageFrame.getX() - 800, getY() - 25);
				}
			}
		});
		this.btnMyComputer.setBounds(10, 11, 110, 38);
		this.contentPane.add(this.btnMyComputer);
		
		this.btnLog = new JButton("log");
		this.btnLog.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				initLogFrame();
			}
		});
		this.btnLog.setBounds(130, 11, 131, 38);
		this.contentPane.add(this.btnLog);
		
		this.btnApplicationOptions = new JButton("Application Options");
		this.btnApplicationOptions.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (Strings.adminOptions != null) {
					Strings.adminOptions.dispose();
					Strings.adminOptions = new AdminOptionsFrame();
				} else {
					Strings.adminOptions = new AdminOptionsFrame();
				}
			}
		});
		this.btnApplicationOptions.setBounds(10, 393, 163, 38);
		this.contentPane.add(this.btnApplicationOptions);
		
		this.label = new JLabel("-----------------------------------------------------------------------------------------------");
		this.label.setBounds(10, 368, 424, 14);
		this.contentPane.add(this.label);
		
		// this will not be implemented for a long long time
		this.btnNetworkOptions = new JButton("Network Options");
		this.btnNetworkOptions.setBounds(10, 442, 163, 38);
		this.contentPane.add(this.btnNetworkOptions);
		
		super.setLocationRelativeTo(null);
		super.setVisible(true);
		
	}
	
	private void initLogFrame() {
		if (Strings.messageFrame != null) {
			if (UserSettings.saveLogText) {
				final String text = Strings.messageFrame.getText();
				Strings.messageFrame.dispose();
				Strings.messageFrame = new LogFrame(text);
				Strings.messageFrame.setLocation(this.getX() + 400, this.getY() + 25);
			} else {
				Strings.messageFrame.dispose();
				Strings.messageFrame = new LogFrame();
				Strings.messageFrame.setLocation(this.getX() + 400, this.getY() + 25);
			}
		} else {
			Strings.messageFrame = new LogFrame();
			Strings.messageFrame.setLocation(this.getX() + 400, this.getY() + 25);
		}
	}

}