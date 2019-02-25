package fr.eni.papeterie.ihm;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class EcranPrincipal extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private JTextField reference,designation,marque,stock,prix;
	private JRadioButton ramette, stylo;
	private JCheckBox gramme80, gramme100;
	String[] couleurs = {"Bleu", "Noir", "Vert", "Rouge"};
	private JComboBox<String> couleur;
	JButton preview, next, news, save, delete;

	public EcranPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(500, 400));
		setLocationRelativeTo(null);
		initIHM();
		//this.pack();
	}

	private void initIHM() {
		JPanel panneauPrincipal = new JPanel();
		panneauPrincipal.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		//Ligne 1
		gbc.gridx = 0;
		gbc.gridy = 0;		
		panneauPrincipal.add(new JLabel("Reference "), gbc);
		gbc.gridx = 1;
		panneauPrincipal.add(getReference(), gbc);
		
		//Ligne 2
		gbc.gridx = 0;
		gbc.gridy = 1;		
		panneauPrincipal.add(new JLabel("Designation "), gbc);
		gbc.gridx = 1;
		panneauPrincipal.add(getDesignation(), gbc);
		
		//Ligne 3 
		gbc.gridx = 0;
		gbc.gridy = 2;		
		panneauPrincipal.add(new JLabel("Marque "), gbc);
		gbc.gridx = 1;
		panneauPrincipal.add(getMarque(), gbc);
		
		//Ligne 4 
		gbc.gridx = 0;
		gbc.gridy = 3;		
		panneauPrincipal.add(new JLabel("Stock "), gbc);		
		gbc.gridx = 1;
		panneauPrincipal.add(getStock(), gbc);
		
		//Ligne 5 
		gbc.gridx = 0;
		gbc.gridy = 4;		
		panneauPrincipal.add(new JLabel("Prix "), gbc);				
		gbc.gridx = 1;
		panneauPrincipal.add(getPrix(), gbc);
		
		//Ligne 6 
		gbc.gridx = 0;
		gbc.gridy = 5;		
		panneauPrincipal.add(new JLabel("Type "), gbc);				
		gbc.gridx = 1;
		panneauPrincipal.add(getTypes(), gbc);
		
		//Ligne 7 
		gbc.gridx = 0;
		gbc.gridy = 7;		
		panneauPrincipal.add(new JLabel("Grammage "), gbc);				
		gbc.gridx = 1;
		panneauPrincipal.add(getGrammage(), gbc);

		//Ligne8
		gbc.gridx = 0;
		gbc.gridy = 8;		
		panneauPrincipal.add(new JLabel("Couleur "), gbc);				
		gbc.gridx = 1;
		panneauPrincipal.add(getCouleur(), gbc);
		
		//Ligne 9
		gbc.gridy = 9;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		panneauPrincipal.add(getPanneauBoutons(), gbc);
		
		//Affectation du panneau au "contentPane" de l'écran
		setContentPane(panneauPrincipal);
		
	}
	
	private JPanel getReference() {
		JPanel panelReference = new JPanel();
		if (reference == null) {
			panelReference.setLayout(new FlowLayout());
			panelReference.add(new JTextField(30));
		}
		return panelReference;
	}
	
	private JPanel getDesignation() {
		JPanel panelReference = new JPanel();
		if (designation == null) {
			panelReference.setLayout(new FlowLayout());
			panelReference.add(new JTextField(30));
		}
		return panelReference;
	}
	private JPanel getMarque() {
		JPanel panelReference = new JPanel();
		if (marque == null) {
			panelReference.setLayout(new FlowLayout());
			panelReference.add(new JTextField(30));
		}
		return panelReference;
	}
	private JPanel getStock() {
		JPanel panelReference = new JPanel();
		if (stock == null) {
			panelReference.setLayout(new FlowLayout());
			panelReference.add(new JTextField(30));
		}
		return panelReference;
	}
	private JPanel getPrix() {
		JPanel panelReference = new JPanel();
		if (prix == null) {
			panelReference.setLayout(new FlowLayout());
			panelReference.add(new JTextField(30));
		}
		return panelReference;
	}
	
	private JPanel getTypes() {
		JPanel panelType = new JPanel();
		panelType.setLayout(new BoxLayout(panelType, BoxLayout.PAGE_AXIS));
		panelType.add(getramette());
		panelType.add(getStylo());
		return panelType;
	}
	private JRadioButton getramette() {
		if(ramette == null) {
			ramette = new JRadioButton("Ramette");
			ramette.setSelected(true);
		}
		return ramette;
	}
	private JRadioButton getStylo() {
		if(stylo == null) {
			stylo = new JRadioButton("Stylo");
		}
		return stylo;
	}
	
	private JPanel getGrammage() {
		JPanel panelGrammage = new JPanel();
		panelGrammage.setLayout(new BoxLayout(panelGrammage, BoxLayout.PAGE_AXIS));
		panelGrammage.add(getGramme80());
		panelGrammage.add(getGramme100());
		return panelGrammage;
	}
	private JCheckBox getGramme80() {
		if(gramme80 == null) {
			gramme80 = new JCheckBox("80 grammes");
			gramme80.setSelected(true);
		}
		return gramme80;
	}
	private JCheckBox getGramme100() {
		if(gramme100 == null) {
			gramme100 = new JCheckBox("100 grammes");
		}
		return gramme100;
	}
	
	private JPanel getCouleur() {
		JPanel panelCouleur = new JPanel();
		if(couleur == null) {
			panelCouleur.setLayout(new FlowLayout());
			panelCouleur.add(new JComboBox<>(couleurs));
		}
		return panelCouleur;
	}
	public String[] getCouleurs() {
		return couleurs;
	}
	
	private JPanel getPanneauBoutons() {
		JPanel panelBoutons = new JPanel();
		panelBoutons.setLayout(new FlowLayout());
		panelBoutons.add(getBtnPreview());
		panelBoutons.add(getBtnNew());
		panelBoutons.add(getBtnSave());
		panelBoutons.add(getBtnDelete());
		panelBoutons.add(getBtnNext());
		return panelBoutons;
	}
	public JButton getBtnPreview() {
		if (preview == null) {
			preview = new JButton();
			preview.setIcon(new ImageIcon(this.getClass().getResource("images/Back24.gif")));
			preview.setPreferredSize(new Dimension(80,50)); 
		}
		return preview;
	}
	public JButton getBtnNext() {
		if (next == null) {
			next = new JButton();
			next.setIcon(new ImageIcon(this.getClass().getResource("images/Forward24.gif")));
			next.setPreferredSize(new Dimension(80,50)); 
		}
		return next;
	}
	public JButton getBtnNew() {
		if (news == null) {
			news = new JButton();
			news.setIcon(new ImageIcon(this.getClass().getResource("images/New24.gif")));
			news.setPreferredSize(new Dimension(80,50)); 
		}
		return news;
	}
	public JButton getBtnSave() {
		if (save == null) {
			save = new JButton();
			save.setIcon(new ImageIcon(this.getClass().getResource("images/Save24.gif")));
			save.setPreferredSize(new Dimension(80,50)); 
		}
		return save;
	}
	public JButton getBtnDelete() {
		if (delete == null) {
			delete = new JButton();
			delete.setIcon(new ImageIcon(this.getClass().getResource("images/Delete24.gif")));
			delete.setPreferredSize(new Dimension(80,50)); 
		}
		return delete;
	}
}
