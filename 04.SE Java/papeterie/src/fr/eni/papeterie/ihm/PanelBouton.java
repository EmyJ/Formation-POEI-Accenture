package fr.eni.papeterie.ihm;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelBouton extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton btnPrecedent;
	private JButton btnNouveau;
	private JButton btnEnregistrer;
	private JButton btnSupprimer;
	private JButton btnSuivant;

	private List<ObservateurPanelBoutons> observateur = new ArrayList<>();
	
	public PanelBouton() {
		setLayout(new FlowLayout());
		add(getBtnPrecedent());
		add(getBtnNouveau());
		add(getBtnEnregistrer());
		add(getBtnSupprimer());
		add(getBtnSuivant());
	}
	
	public void registerObserver(ObservateurPanelBoutons obs) {
		observateur.add(obs);
	}
	
	public JButton getBtnPrecedent() {
		if (btnPrecedent == null) {
			btnPrecedent = new JButton();
			ImageIcon image = new ImageIcon(this.getClass().getResource("resources/Back24.gif"));
			btnPrecedent.setIcon(image);
			btnPrecedent.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					notifyClickSurBtnPrecedent();
				}
			});
		}
		return btnPrecedent;
	}
	
	private void notifyClickSurBtnPrecedent() {
		for (ObservateurPanelBoutons o : observateur) {
			o.clickSurBtPrecedent();
		}
	}

	public JButton getBtnNouveau() {
		if (btnNouveau == null) {
			btnNouveau = new JButton();
			ImageIcon image = new ImageIcon(this.getClass().getResource("resources/New24.gif"));
			btnNouveau.setIcon(image);
			btnNouveau.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					notifyClickSurBtnNouveau();
				}
			});
		}

		return btnNouveau;
	}
	private void notifyClickSurBtnNouveau() {
		for (ObservateurPanelBoutons o : observateur) {
			o.clickSurBtnNouveau();
		}
	}

	public JButton getBtnEnregistrer() {
		if (btnEnregistrer == null) {
			btnEnregistrer = new JButton();
			ImageIcon image = new ImageIcon(this.getClass().getResource("resources/Save24.gif"));
			btnEnregistrer.setIcon(image);
			btnEnregistrer.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					notifyClickSurBtnEnregistrer();
					JOptionPane.showMessageDialog(btnEnregistrer,"Ajout effectué");
				}
			});
		}
		return btnEnregistrer;
	}
	private void notifyClickSurBtnEnregistrer() {
		for (ObservateurPanelBoutons o : observateur) {
			o.clickSurBtnEnregistrer();
		}
	}

	public JButton getBtnSupprimer() {
		if (btnSupprimer == null) {
			btnSupprimer = new JButton();
			ImageIcon image = new ImageIcon(this.getClass().getResource("resources/Delete24.gif"));
			btnSupprimer.setIcon(image);
			btnSupprimer.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					notifyClickSurBtnSupprimer();
					JOptionPane.showMessageDialog(btnSupprimer,"Suppresion effectuée");
				}
			});
		}
		return btnSupprimer;
	}
	private void notifyClickSurBtnSupprimer() {
		for (ObservateurPanelBoutons o : observateur) {
			o.clickSurBtnSupprimer();
		}
	}

	public JButton getBtnSuivant() {
		if (btnSuivant == null) {
			btnSuivant = new JButton();
			ImageIcon image = new ImageIcon(this.getClass().getResource("resources/Forward24.gif"));
			btnSuivant.setIcon(image);
			btnSuivant.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					notifyClickSurBtnSuivant();
				}
			});
		}
		return btnSuivant;
	}
	
	private void notifyClickSurBtnSuivant() {
		for (ObservateurPanelBoutons o : observateur) {
			o.clickSurBtSuivant();
		}
	}
}
