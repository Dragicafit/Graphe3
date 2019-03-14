package modele.point;

import modele.Couleur;
import modele.estColoriable;

public class PointCouleur extends Point implements estColoriable {

	private Couleur couleur;

	public PointCouleur(double x, double y, double rayon, boolean deplacable, Couleur couleur) {
		super(x, y, rayon, deplacable);
		this.couleur = couleur;
	}

	public PointCouleur(double x, double y, double rayon, Couleur couleur) {
		super(x, y, rayon);
		this.couleur = couleur;
	}

	public PointCouleur(double x, double y, Couleur couleur) {
		super(x, y);
		this.couleur = couleur;
	}

	@Override
	public Couleur getCouleur() {
		return couleur;
	}

	@Override
	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}
}
