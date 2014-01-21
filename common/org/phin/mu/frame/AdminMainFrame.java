package org.phin.mu.frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.phin.mu.dialog.MenuDialog;
import org.phin.mu.lib.Strings;
import org.phin.mu.util.MenuHandler;
import javax.swing.JLabel;

public class AdminMainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private MenuHandler handler;
	private JButton btnMyComputer;

	private Component btnLog;
	private JButton btnApplicationOptions;
	private JLabel label;
	private JButton btnNetworkOptions;

	public AdminMainFrame() {
		this.createGUI();
	}
	
	private void createGUI() {
		
		this.setBounds(100, 100, Strings.DEFAULT_WIDTH, Strings.DEFAULT_HEIGHT);
		this.setSize(Strings.DEFAULT_DIM);
		
		// general JFrame usage
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		this.setAlwaysOnTop(false);
		this.setEnabled(true);
		this.setTitle("Admin Main Frame");
		this.setLocationRelativeTo(null);
		
		// menu init
		if (Strings.menuBar) {
			this.handler = new MenuHandler();
			this.handler.initMenu(this);
		} else {
			ConsoleFrame.printMessage("info: menu bar has been disabled!");
		}

		// contentPane usage
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		
		// Apply the background color
		if ((Strings.RED != 0) && (Strings.GREEN != 0) && (Strings.BLUE != 0)) {
			this.contentPane.setBackground(new Color(Strings.RED, Strings.GREEN, Strings.BLUE));
		} else {
			this.contentPane.setBackground(Color.LIGHT_GRAY);
		}
		
		this.setContentPane(this.contentPane);
		
		this.btnMyComputer = new JButton("My Computer");
		this.btnMyComputer.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ComputerFrame frame = new ComputerFrame();
				frame.setVisible(true);
			}
		});
		this.btnMyComputer.setBounds(10, 11, 110, 38);
		this.contentPane.add(this.btnMyComputer);
		
		this.btnLog = new JButton("log");
		this.btnLog.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// log handler
				if (Strings.log != null) {
					if (!Strings.log.getText().equals("")) {
						final String text = Strings.log.getText();
						Strings.log.dispose();
						Strings.log = new LogFrame(text);
					} else {
						Strings.log.dispose();
						Strings.log = new LogFrame();
					}
				} else {
					Strings.log = new LogFrame();
				}
			}
		});
		this.btnLog.setBounds(130, 11, 131, 38);
		this.contentPane.add(this.btnLog);
		
		this.btnApplicationOptions = new JButton("application options");
		this.btnApplicationOptions.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MenuDialog frame = new MenuDialog();
				frame.setVisible(true);
			}
		});
		this.btnApplicationOptions.setBounds(10, 393, 163, 38);
		this.contentPane.add(this.btnApplicationOptions);
		
		this.label = new JLabel("-----------------------------------------------------------------------------------------------");
		this.label.setBounds(10, 368, 424, 14);
		this.contentPane.add(this.label);
		
		// this will not be implemented for a long long time
		this.btnNetworkOptions = new JButton("network options");
		this.btnNetworkOptions.setBounds(10, 442, 163, 38);
		this.contentPane.add(this.btnNetworkOptions);
		
	}

}