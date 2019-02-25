package fr.eni.jpa.demo11.entity.single;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe en charge 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 20 févr. 2019 - 15:10:09
 */
@Entity
@DiscriminatorValue(value="B")
public class Berline extends Voiture{

    private String couleurCuir;

    public Berline() {
	super();
    }

    /**
     * Constructeur.
     * @param couleurCuir
     */
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

    /** 
     * {@inheritDoc}
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return super.toString() + " " + couleurCuir;
    }
    
     
}
