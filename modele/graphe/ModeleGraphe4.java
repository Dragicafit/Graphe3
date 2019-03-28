package modele.graphe;

import modele.Couleur;
import modele.Joueur;
import modele.point.Point;
import modele.point.PointCouleur;
import modele.segment.Segment;

public class ModeleGraphe4 extends ModeleGraphe {
	private static final long serialVersionUID = 104L;

	public ModeleGraphe4() {
		super("4");
		addJoueur(new Joueur("j1", Couleur.ROUGE));
		addJoueur(new Joueur("j2", Couleur.BLEU));
		Point p1 = new PointCouleur(200, 100, Couleur.BLANC);
		Point p2 = new PointCouleur(300, 200, Couleur.BLANC);
		Point p3 = new PointCouleur(200, 200, Couleur.BLANC);
		Point p4 = new PointCouleur(400, 200, Couleur.BLANC);
		Point p5 = new PointCouleur(500, 100, Couleur.BLANC);
		Point p6 = new PointCouleur(500, 200, Couleur.BLANC);
		Point p7 = new PointCouleur(200, 300, Couleur.BLANC);
		Point p8 = new PointCouleur(500, 300, Couleur.BLANC);
		Point p9 = new PointCouleur(600, 200, Couleur.BLEU);
		Point p10 = new PointCouleur(100, 200, Couleur.ROUGE);
		addPoint(p1);
		addPoint(p2);
		addPoint(p3);
		addPoint(p4);
		addPoint(p5);
		addPoint(p6);
		addPoint(p7);
		addPoint(p8);
		addPoint(p9);
		addPoint(p10);
		addSegment(new Segment(p1, p2));
		addSegment(new Segment(p2, p3));
		addSegment(new Segment(p1, p3));
		addSegment(new Segment(p4, p2));
		addSegment(new Segment(p5, p6));
		addSegment(new Segment(p4, p5));
		addSegment(new Segment(p4, p6));
		addSegment(new Segment(p3, p7));
		addSegment(new Segment(p7, p2));
		addSegment(new Segment(p8, p6));
		addSegment(new Segment(p8, p4));
		addSegment(new Segment(p3, p10));
		addSegment(new Segment(p9, p6));
	}
}