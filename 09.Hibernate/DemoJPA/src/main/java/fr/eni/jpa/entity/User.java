/**
 * 
 */
package fr.eni.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe en charge 
 * @author ejezeque2018
 * @version DemoJPA - V1.0
 * @date 18 févr. 2019 - 16:12:24
 */
@Entity
@Table (name="user")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    @Column(name="login", length=255, nullable=false)
    private String login;
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    
    @Column(name="password", length=255, nullable=false)
    private String password;
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    /**
     * Constructeur;
     * Par default.
     * 
     */
    public User() {
    }
    /**
     * Constructeur.
     * @param login
     * @param password
     */
    public User(String login, String password) {
	this.login = login;
	this.password = password;
    }

    /**
     * Constructeur.
     * @param id
     * @param login
     * @param password
     */
    public User(int id, String login, String password) {
	this(login,password);
	this.id = id;
    }
    
    /** 
     * {@inheritDoc}
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "User " + id + ", login = " + login + ", password = " + password;
    }
    
    
    
}
