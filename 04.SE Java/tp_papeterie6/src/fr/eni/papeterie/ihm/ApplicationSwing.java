package fr.eni.papeterie.ihm;

import javax.swing.SwingUtilities;

public class ApplicationSwing {

	
	public static void main(String[] args) {
	
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				EcranPrincipal ecranPrincipal = new EcranPrincipal();
				ecranPrincipal.setVisible(true);
			}
			
		});
	}
}
