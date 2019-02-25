package fr.eni.papeterie.ihm;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.eni.papeterie.bll.BLLException;
import fr.eni.papeterie.bll.CatalogueManager;
import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;

public class EcranPrincipal extends JFrame { // il h�rite de JFrame

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger("fr.eni.papeterie.ihm.EcranPrincipal"); 
	                                                        
	private int index = 0;

	private static final int LARGEUR_CHAMP = 30;

	private JTextField txtRef;
	private JTextField txtDesignation;
	private JTextField txtMarque;
	private JTextField numStock;
	private JTextField numPrix;
	private ButtonGroup radioType = new ButtonGroup();
	private JRadioButton cbRamette;
	private JRadioButton cbStylo;
	private ButtonGroup checkboxGrammage;
	private JCheckBox rb80;
	private JCheckBox rb100;
	private JComboBox<String> selectCouleur;
	private JButton btnBack, btnForward, btnDelete, btnNew, btnSave;
	private String[] tableau = { "rouge", "bleu", "vert", "jaune", "violet" };
	private CatalogueManager mger;
	private Article art;

	private List<Article> catalogue;

	public static int getLargeurChamp() {
		return LARGEUR_CHAMP;
	}

	/**
	 * Constructeur de l'�cran principal
	 */
	public EcranPrincipal() {
		
		setTitle("Articles"); // Le titre de l'application
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // pour sortir de l'application lorsque l'on clique sur la croix
		setSize(new Dimension(500, 400)); // Taille de la fen�tre
		setLocationRelativeTo(null); // l'emplacement (x et y) relatif de l'�cran
		this.setResizable(false);
		
		initIHM();
		initContent();
		afficheContent();
	}

	/**
	 * Initialise l'�cran principal
	 */
	private void initIHM() {

		JPanel panneauPrincipal = new JPanel();

		panneauPrincipal.setOpaque(true);

		panneauPrincipal.setLayout(new GridBagLayout()); // On utilise le layout GridBagLayout

		GridBagConstraints gbc = new GridBagConstraints(); // On va pouvoir g�rer les coordonn�es de chaque �l�ment

		// 1�re ligne R�f�rence
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 5, 5, 5);
		panneauPrincipal.add(new JLabel("Référence : "), gbc);
		gbc.gridx = 1;
		panneauPrincipal.add(getTxtRef(), gbc);
		// 2e ligne Designation
		gbc.gridx = 0;
		gbc.gridy = 1;
		panneauPrincipal.add(new JLabel("Désignation : "), gbc);
		gbc.gridx = 1;
		panneauPrincipal.add(getTxtDesignation(), gbc);
		// 3e ligne Marque
		gbc.gridx = 0;
		gbc.gridy = 2;
		panneauPrincipal.add(new JLabel("Marque : "), gbc);
		gbc.gridx = 1;
		panneauPrincipal.add(getTxtMarque(), gbc);
		// 3e ligne Stock
		gbc.gridx = 0;
		gbc.gridy = 3;
		panneauPrincipal.add(new JLabel("Stock : "), gbc);
		gbc.gridx = 1;
		panneauPrincipal.add(getNumStock(), gbc);
		// 4e ligne Prix
		gbc.gridx = 0;
		gbc.gridy = 4;
		panneauPrincipal.add(new JLabel("Prix : "), gbc);
		gbc.gridx = 1;
		panneauPrincipal.add(getNumPrix(), gbc);
		// 5e ligne Type
		gbc.gridx = 0;
		gbc.gridy = 5;
		panneauPrincipal.add(new JLabel("Type : "), gbc);
		gbc.gridx = 1;
		panneauPrincipal.add(getPanneauType(), gbc);
		// 6e ligne Grammage
		gbc.gridx = 0;
		gbc.gridy = 6;
		panneauPrincipal.add(new JLabel("Grammage : "), gbc);
		gbc.gridx = 1;
		panneauPrincipal.add(getPanneauGrammage(), gbc);
		// 7e ligne couleurs
		gbc.gridx = 0;
		gbc.gridy = 7;
		panneauPrincipal.add(new JLabel("Couleur : "), gbc);
		gbc.gridx = 1;
		panneauPrincipal.add(getSelectCouleur(), gbc);
		// 8e ligne boutons
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.gridwidth = 2;
		panneauPrincipal.add(getPanneauBoutons(), gbc);

		setContentPane(panneauPrincipal);

	}

	/**
	 * Cr�e un panneau pour les chexbox du grammage
	 * 
	 * @return
	 */
	private Component getPanneauGrammage() {
		JPanel panelGrammage = new JPanel();
		panelGrammage.setLayout(new BoxLayout(panelGrammage, BoxLayout.PAGE_AXIS));
		panelGrammage.add(getRb80());
		panelGrammage.add(getRb100());

		return panelGrammage;
	}

	/**
	 * Cr�e un panneau avec 5 boutons
	 * 
	 * @return un panneau
	 */
	private JPanel getPanneauBoutons() {
		JPanel panelBoutons = new JPanel();
		panelBoutons.setLayout(new FlowLayout());
		panelBoutons.add(getBtnBack());
		panelBoutons.add(getBtnNew());
		panelBoutons.add(getBtnSave());
		panelBoutons.add(getBtnDelete());
		panelBoutons.add(getBtnForward());

		return panelBoutons;
	}

	/**
	 * Cr�e un panneau avec 2 boutons pour les checkBox du type
	 * 
	 * @return un panneau
	 */
	private JPanel getPanneauType() {
		JPanel panelType = new JPanel();
		panelType.setLayout(new BoxLayout(panelType, BoxLayout.PAGE_AXIS));
		panelType.add(getCbRamette());
		panelType.add(getCbStylo());

		return panelType;
	}

	/**
	 * Cr�e le champ R�f�rence
	 * 
	 * @return
	 */
	public JTextField getTxtRef() {
		if (txtRef == null) {
			txtRef = new JTextField(LARGEUR_CHAMP);
		}
		return txtRef;
	}

	/**
	 * Cr�e le champ Designation
	 * 
	 * @return
	 */
	public JTextField getTxtDesignation() {
		if (txtDesignation == null) {
			txtDesignation = new JTextField(LARGEUR_CHAMP);
		}
		return txtDesignation;
	}

	/**
	 * Cr�e le champ marque
	 * 
	 * @return
	 */
	public JTextField getTxtMarque() {
		if (txtMarque == null) {
			txtMarque = new JTextField(LARGEUR_CHAMP);
		}
		return txtMarque;
	}

	/**
	 * Cr�e le champ Stock (int)
	 * 
	 * @return
	 */
	public JTextField getNumStock() {
		if (numStock == null) {
			numStock = new JTextField(LARGEUR_CHAMP);
		}
		return numStock;
	}

	/**
	 * Cr�e le champ Prix (float)
	 * 
	 * @return
	 */
	public JTextField getNumPrix() {
		if (numPrix == null) {
			numPrix = new JTextField(LARGEUR_CHAMP);
		}
		return numPrix;
	}

	/**
	 * Cr�e le group de boutons radios pour le type de d'article Article
	 * 
	 * @return
	 */
	public ButtonGroup getRadioType() {
		if (radioType == null) {
			radioType = new ButtonGroup();
		}
		return radioType;
	}

	/**
	 * Cr�e le bouton radio Ramette Ramette
	 * 
	 * @return
	 */
	public JRadioButton getCbRamette() {
		if (cbRamette == null) {
			cbRamette = new JRadioButton("Ramette");
			radioType.add(cbRamette);
			cbRamette.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					getSelectCouleur().setEnabled(false);
					getRb80().setEnabled(true);
					getRb100().setEnabled(true);
				}
			});
		}
		return cbRamette;
	}

	/**
	 * Cr�e le bouton radio Stylo Stylo
	 * 
	 * @return
	 */
	public JRadioButton getCbStylo() {
		if (cbStylo == null) {
			cbStylo = new JRadioButton("Stylo");
			radioType.add(cbStylo);
			cbStylo.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					getSelectCouleur().setEnabled(true);
					getRb80().setEnabled(false);
					getRb100().setEnabled(false);
				}
			});
		}
		return cbStylo;
	}

	/**
	 * Cr�e le groupe de checkbox Grammage Int
	 * 
	 * @return
	 */
	public ButtonGroup getCheckboxGrammage() {
		if (checkboxGrammage == null) {
			checkboxGrammage = new ButtonGroup();
		}
		return checkboxGrammage;
	}

	/**
	 * Cr�e un select pour les couleurs Renvoi un string
	 * 
	 * @return
	 */
	public JComboBox<String> getSelectCouleur() {

		if (selectCouleur == null) {
			selectCouleur = new JComboBox<String>(tableau);
			selectCouleur.setPreferredSize(new Dimension(200, 30));
		}
		return selectCouleur;
	}

	/**
	 * Cr�e le grammage 80
	 * 
	 * @return
	 */
	public JCheckBox getRb80() {
		if (rb80 == null) {
			rb80 = new JCheckBox("80 grammes");
		}
		return rb80;
	}

	/**
	 * Cr�e le grammage 100
	 * 
	 * @return
	 */
	public JCheckBox getRb100() {
		if (rb100 == null) {
			rb100 = new JCheckBox("1000 grammes");
		}
		return rb100;
	}

	/**
	 * Cr�e le bouton Preview
	 * 
	 * @return
	 */
	public JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton(new ImageIcon(this.getClass().getResource("./images/Back24.gif")));
			btnBack.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (index > 0) {
						index--;
						afficheContent();
					}
					if (index == 0) {
						btnBack.setEnabled(true);
					}
				}
			});
		}
		return btnBack;
	}

	/**
	 * Cr�e le bouton Next
	 * 
	 * @return
	 */
	public JButton getBtnForward() {
		if (btnForward == null) {
			btnForward = new JButton(new ImageIcon(this.getClass().getResource("./images/Forward24.gif")));
			btnForward.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					if (index < catalogue.size() - 1) {
						index++;
						afficheContent();
					}

				}
			});
		}
		return btnForward;
	}

	/**
	 * Cr�e le bouton Delete
	 * 
	 * @return
	 */
	public JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton(new ImageIcon(this.getClass().getResource("./images/Delete24.gif")));
			btnDelete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (index >= 0) {
						try {
							mger.removeArticle(catalogue.get(index).getIdArticle());

							if (index == 0) {
								catalogue.remove(index);
							} else {
								catalogue.remove(index);
								index--;
							}
							afficheContent();

						} catch (BLLException e1) {
							logger.error("ERREUR : " + e1.getMessage());
							//e1.printStackTrace();
						}
					}
				}
			});
		}
		return btnDelete;
	}

	/**
	 * Cr�e le bouton New
	 * 
	 * @return
	 */
	public JButton getBtnNew() {
		if (btnNew == null) {
			btnNew = new JButton(new ImageIcon(this.getClass().getResource("./images/New24.gif")));
			btnNew.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					index = -1;
					afficheContent();
				}
			});
		}
		return btnNew;
	}

	/**
	 * Cr�e le bouton Save
	 *  
	 * @return
	 */
	public JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton(new ImageIcon(this.getClass().getResource("./images/Save24.gif")));
			
				btnSave.addActionListener(new ActionListener() {
	
					@Override
					public void actionPerformed(ActionEvent e) {
						
						if(index == 0){
						
							if (getCbRamette().isSelected()) {
								
								int gramme = 0;
								if(getRb80().isSelected()) {
									gramme = 80;
								}else {
									gramme = 100;
								}
								
								art = new Ramette(getTxtMarque().getText().trim(),getTxtRef().getText().trim(),getTxtDesignation().getText().trim(),
										Float.parseFloat(getNumPrix().getText().trim()), Integer.parseInt(getNumStock().getText().trim()), 
										(gramme));
								try {
									mger.addArticle(art);
									index++;
								} catch (BLLException e1) {
									logger.error("ERREUR : " + e1.getMessage());
									//e1.printStackTrace();
								}
							}else {
								art = new Stylo(getTxtMarque().getText().trim(),getTxtRef().getText().trim(),getTxtDesignation().getText().trim(),
										Float.parseFloat(getNumPrix().getText().trim()), Integer.parseInt(getNumStock().getText().trim()),getSelectCouleur().getSelectedItem().toString());
								try {
									mger.addArticle(art);
									index++;
								} catch (BLLException e1) {
									logger.error("ERREUR : " + e1.getMessage());
									//e1.printStackTrace();
								}
							}
							
							catalogue.add(art);
							index += catalogue.size() -1;
							afficheContent();
						} else {
							try {
								mger.updateArticle(catalogue.get(index));
								catalogue.set(index, art);
							} catch (BLLException e1) {
								logger.error("ERREUR : " + e1.getMessage());
								//e1.printStackTrace();
							}
						}
					}
					
					});
				
			
				}
			
		
		return btnSave;
	}

	/**
	 * r�cup�re le catalogue
	 */
	public void initContent() {

		mger = CatalogueManager.getInstance(); // Singleton

		try {
			catalogue = mger.getCatalogue();
			logger.info("Méthode recupere le catalogue");
		} catch (BLLException e) {
			logger.error("ERREUR : " + e.getMessage());
			//e.printStackTrace();
		}

	}

	/**
	 * Affiche le contenu sur l'�cran
	 */
	private void afficheContent() {
		if (index < 0) {
			// Si on cr�e un nouvel article et si le catalogue est vide
			getBtnDelete().setEnabled(false);
			getTxtRef().setText("");
			getTxtDesignation().setText("");
			getTxtMarque().setText("");
			getNumStock().setText("");
			getNumPrix().setText("");
			getCbRamette().setEnabled(true);
			getCbStylo().setEnabled(true);

			radioType.clearSelection();

			getRb80().setEnabled(false);
			getRb100().setEnabled(false);
			getRb80().setSelected(false);
			getRb100().setSelected(false);
			getSelectCouleur().setEnabled(false);

		} else {
			if (catalogue != null) {
				getBtnDelete().setEnabled(true);
				Article article = catalogue.get(index);

				getTxtRef().setText(article.getReference());
				getTxtDesignation().setText(article.getDesignation());
				getTxtMarque().setText(article.getMarque());
				getNumStock().setText(String.valueOf(article.getQteStock()));
				getNumPrix().setText(String.valueOf(article.getPrixUnitaire()));

				if (article instanceof Ramette) {
					getCbRamette().setEnabled(true);
					getCbStylo().setEnabled(false);

					getCbRamette().doClick();

					if (((Ramette) article).getGrammage() == 80) {
						getRb80().setSelected(true);
						getRb100().setSelected(false);
					}
					if (((Ramette) article).getGrammage() == 100) {
						getRb100().setSelected(true);
						getRb80().setSelected(false);
					}
				}

				if (catalogue.get(index) instanceof Stylo) {

					getRadioType().clearSelection();
					getCbStylo().setEnabled(true);
					getCbRamette().setEnabled(false);

					getCbStylo().doClick();

					switch (((Stylo) article).getCouleur()) {
					// "rouge", "bleu", "vert", "jaune", "violet"
					case "rouge":
						getSelectCouleur().setSelectedIndex(0);
						break;
					case "bleu":
						getSelectCouleur().setSelectedIndex(1);
						break;
					case "vert":
						getSelectCouleur().setSelectedIndex(2);
						break;
					case "jaune":
						getSelectCouleur().setSelectedIndex(3);
						break;
					case "violet":
						getSelectCouleur().setSelectedIndex(4);
						break;
					}
				}
			} else {
				index = -1;
				afficheContent();
			}
		}

	}
	
	public Article getArticle() {
		Article article=null;
		if(getCbStylo().isSelected()){
			article = new Stylo();
		}else{
			article = new Ramette();
		}
		try {
			article.setIdArticle(index);
			article.setReference( getTxtRef().getText());
			article.setMarque(getTxtMarque().getText());
			article.setDesignation( getTxtDesignation().getText());
			article.setPrixUnitaire(Float.parseFloat(getNumPrix().getText()));
			article.setQteStock(Integer.parseInt(getNumStock().getText()));
			if (getSelectCouleur().isEnabled()) {
				((Stylo)article).setCouleur( (String) getSelectCouleur().getSelectedItem());
			} else {
				((Ramette) article).setGrammage(getRb80().isSelected()?80:100);
			}
		} catch (Exception e) {
			logger.error("ERREUR : " + e.getMessage());
			//e.printStackTrace();
		}
		return article;
	}

}
