package fr.eni.jpa.demo12.entity.single;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classe en charge 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 20 févr. 2019 - 15:10:09
 */
@Entity(name="TPCBerlineEntity")
@Table(name="TPCBerline")
public class Berline extends Voiture{

    private String couleurCuir;

    public Berline() {
	super();
    }

    public Berline(String marque, String couleurCuir) {
	super(marque);
	this.couleurCuir = couleurCuir;
    }

    public String getCouleurCuir() {
        return couleurCuir;
    }

    public void setCouleurCuir(String couleurCuir) {
        this.couleurCuir = couleurCuir;
    }
    
    @Override
    public String toString() {
	return super.toString() + " " + couleurCuir;
    }
    
     
}
