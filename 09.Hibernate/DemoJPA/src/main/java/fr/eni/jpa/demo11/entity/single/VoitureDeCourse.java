package fr.eni.jpa.demo11.entity.single;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe en charge 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 20 févr. 2019 - 15:15:04
 */
@Entity
@DiscriminatorValue(value="C")
public class VoitureDeCourse extends Voiture{

    private String ecurie;

    public VoitureDeCourse() {
	super();
    }

    public VoitureDeCourse(String marque, String ecurie) {
	super(marque);
	this.ecurie = ecurie;
    }

    public String getEcurie() {
        return ecurie;
    }

    public void setEcurie(String ecurie) {
        this.ecurie = ecurie;
    }

    /** 
     * {@inheritDoc}
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return super.toString() + " " + ecurie;
    }
    
    
}
