package fr.eni.jpa.demo10.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe en charge 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 20 févr. 2019 - 11:41:12
 */
@Entity
@Table(name = "PaysMTM")
public class Pays {

    @Id
    @Column(name = "cle")
    private String key;
    private String libelle;
    
    public Pays() {
    }

    public Pays(String key, String libelle) {
	setKey(key);
	setLibelle(libelle);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
	return "" + libelle;
    }
    
    
}
