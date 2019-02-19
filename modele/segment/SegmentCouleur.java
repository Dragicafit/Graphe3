package modele.segment;

import javafx.scene.paint.Color;

import modele.estColoriable;
import modele.point.Point;

public class SegmentCouleur extends Segment implements estColoriable {

	private Color couleur;

	public SegmentCouleur(Point point1, Point point2, boolean oriente, Color couleur) {
		super(point1, point2, oriente);
		this.couleur = couleur;
	}

	public SegmentCouleur(Point point1, Point point2, Color couleur) {
		super(point1, point2);
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
