package fr.eni.demoSwing01.ihm;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ApplicationSwing {

	
	public static void main(String[] args) {
		
//		SwingUtilities.invokeLater( new ApplicationSwing.MaClasseInterne());
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				EcranPrincipal ecranPrincipal = new EcranPrincipal();
				ecranPrincipal.setVisible(true);
			}
			
		});
		
	}
	
		
	
	//Classe interne 
//	private static class MaClasseInterne implements Runnable{
//
//		@Override
//		public void run() {
//			EcranPrincipal ecranPrincipal = new EcranPrincipal();
//			ecranPrincipal.setVisible(true);
//			
//		}
//		
//	}

}
