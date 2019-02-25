package fr.eni.demoSwing01.ihm;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EcranPrincipal extends JFrame {

	public EcranPrincipal() {
		setTitle("Ecran principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(500, 400));
		setLocationRelativeTo(null);
		initIHM();
	}
	
	private void initIHM() {
		JPanel panneauPrincipal = new JPanel();
		panneauPrincipal.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		//Ligne 1
		gbc.gridx = 0;
		gbc.gridy = 0;		
		panneauPrincipal.add(new JLabel("Nom : "), gbc);
		
		gbc.gridx = 1;
		panneauPrincipal.add(new JTextField(30), gbc);
		
		//Ligne 2
		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		panneauPrincipal.add(getPanneauBoutons(), gbc);
		
		//Affectation du panneau au "contentPane" de l'écran
		setContentPane(panneauPrincipal);
		
	}
	
	private JPanel getPanneauBoutons() {
		JPanel panelBoutons = new JPanel();
		panelBoutons.setLayout(new FlowLayout());
		panelBoutons.add(new JButton("OK"));
		panelBoutons.add(new JButton("ANNULER"));
		
		return panelBoutons;
		
	}
	
	
}
