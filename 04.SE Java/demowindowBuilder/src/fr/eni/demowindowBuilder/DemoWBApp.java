package fr.eni.demowindowBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;

public class DemoWBApp {

	private JFrame frame;
	private JTextField textField;
	private JPanel panel;
	private JLabel lblBienvenue;
	private JPanel panel_1;
	private JButton btnConnexion;
	private JButton btnAnnuler;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoWBApp window = new DemoWBApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DemoWBApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 822, 522);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(getPanel(), BorderLayout.NORTH);
		frame.getContentPane().add(getPanel_1(), BorderLayout.SOUTH);
	
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getLblBienvenue());
		}
		return panel;
	}
	private JLabel getLblBienvenue() {
		if (lblBienvenue == null) {
			lblBienvenue = new JLabel("Bienvenue");
		}
		return lblBienvenue;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.add(getBtnConnexion());
			panel_1.add(getBtnAnnuler());
		}
		return panel_1;
	}
	private JButton getBtnConnexion() {
		if (btnConnexion == null) {
			btnConnexion = new JButton("connexion");
		}
		return btnConnexion;
	}
	private JButton getBtnAnnuler() {
		if (btnAnnuler == null) {
			btnAnnuler = new JButton("annuler");
		}
		return btnAnnuler;
	}
}
