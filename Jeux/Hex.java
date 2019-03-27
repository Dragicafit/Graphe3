package Jeux;

import controleur.ControleurJeu;
import javafx.scene.shape.Circle;
import modele.point.Point;
import modele.point.PointCouleur;
import modele.segment.SegmentCouleur;
import regles.Regles;
import vue.Vue;

public class Hex extends Jeux{
	
	private PointCouleur red1;
	private PointCouleur red2;
	private PointCouleur blue1;
	private PointCouleur blue2;
	private PointCouleur PointDepart;
	private PointCouleur PointArrivee;



	public Hex(Regles r, Vue vue, PointCouleur red1, PointCouleur red2, PointCouleur blue1, PointCouleur blue2) {
		super("Hex", r, vue);
		this.red1 = red1;
		this.red2 = red2;
		this.blue1 = blue1;
		this.blue2 = blue2;

	}
	
	@Override
	public boolean tour(int nb) throws InterruptedException {
		wait();
		Object source = event.getSource();
		if (source instanceof Circle && vue.getCercles().contains((Circle) source)) {
			PointCouleur point = (PointCouleur) m.getPoint(vue.getCercles().indexOf((Circle) source));
			if (check_regles(point)) {
				applique(point);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean check_regles(Point p) {
		return regles.check_cote_soit((PointCouleur) p) && regles.estBlanc((PointCouleur)p);
	}


	@Override
	public boolean end_game() {
		if(estLie(this.red1)) {
			return true;
		}
		if(estLie(this.blue1)) {
			return true;
		}	
		return false;
	}
	
	public boolean estLie(PointCouleur p) {
		for(int i =0; i<m.getSize_segments();i++) {
			if(m.getSegment(i).getPoint1() == p && ((PointCouleur) m.getSegment(i).getPoint2()).getCouleur() == PointDepart.getCouleur()){
				return estLie((PointCouleur) m.getSegment(i).getPoint2());
			}
		}
		return false;
	}
	@Override
	public void applique(Object o) {
		ControleurJeu c = (ControleurJeu) vue.getControleur();
		if(o instanceof PointCouleur) {
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
