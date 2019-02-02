package modele.point;

import java.awt.Color;

import modele.estColoriable;

public class PointCouleur extends Point implements estColoriable {

	private Color couleur;

	public PointCouleur(double x, double y, double rayon, boolean deplacable, Color couleur) {
		super(x, y, rayon, deplacable);
		this.couleur = couleur;
	}

	public PointCouleur(double x, double y, double rayon, Color couleur) {
		super(x, y, rayon);
		this.couleur = couleur;
	}

	public PointCouleur(double x, double y, Color couleur) {
		super(x, y);
		this.couleur = couleur;
	}

	@Override
	public Color getCouleur() {
		return couleur;
	}

	@Override
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
}
