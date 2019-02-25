package fr.eni.jpa.demo13.entity.single;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classe en charge 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 20 févr. 2019 - 15:15:04
 */
@Entity(name="JoinedVoitureDeCourseEntity")
@Table(name="JoinedVoitureDeCourse")
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

    @Override
    public String toString() {
	return super.toString() + " " + ecurie;
    }
     
}
