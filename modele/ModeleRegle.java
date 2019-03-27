package modele;

import java.io.Serializable;

public class ModeleRegle implements Serializable {
	private String nom;
	
	public ModeleRegle(String nom) {
		this.nom = nom;
	}
	
	public ModeleRegle() {
		this.nom = null;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
}
