package Jeux;

import java.util.ArrayList;

import controleur.ControleurJeu;
import javafx.scene.shape.Circle;
import modele.point.Point;
import modele.point.PointCouleur;
import modele.segment.Segment;
import modele.segment.SegmentCouleur;
import regles.Regles;
import vue.Vue;

public class Hex extends Jeux {

	private PointCouleur red1;
	private PointCouleur red2;
	private PointCouleur blue1;
	private PointCouleur blue2;

	public Hex(Regles r, Vue vue, PointCouleur red1, PointCouleur red2, PointCouleur blue1, PointCouleur blue2) {
		super("Hex", r, vue);
		this.red1 = red1;
		this.red2 = red2;
		this.blue1 = blue1;
		this.blue2 = blue2;

	}

	@Override
	public boolean check_regles(Point p) {
		return regles.check_cote_soit((PointCouleur) p) && regles.estBlanc((PointCouleur) p);
	}

	@Override
	public boolean end_game() {
		ArrayList<Point> point = new ArrayList<>();
		if (regles.estLie(this.red2, point, red1)) {
			return true;
		}
		point.clear();
		if (regles.estLie(this.blue2, point, blue1)) {
			return true;
		}
		return false;
	}

	@Override
	public void applique(Object o) {
		ControleurJeu c = (ControleurJeu) vue.getControleur();
		if (o instanceof PointCouleur) {
			c.applique((PointCouleur) o);
		} else if (o instanceof SegmentCouleur) {
			c.applique((SegmentCouleur) o);
		}
	}

	@Override
	public boolean deplacementAvailable() {
		return false;
	}

}
