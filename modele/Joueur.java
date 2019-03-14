package modele;

import java.io.Serializable;

public class Joueur implements Serializable {
	private final String nom;
	private final Couleur couleur;

	public Joueur(String nom, Couleur couleur) {
		super();
		this.nom = nom;
		this.couleur = couleur;
	}

	public String getNom() {
		return nom;
	}

	public Couleur getCouleur() {
		return couleur;
	}
}
