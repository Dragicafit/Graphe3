package modele;

import java.awt.Color;

public class Joueur {
	private final String nom;
	private final Color couleur;
	
	public Joueur(String nom, Color couleur) {
		super();
		this.nom = nom;
		this.couleur = couleur;
	}

	public String getNom() {
		return nom;
	}

	public Color getCouleur() {
		return couleur;
	}
}
