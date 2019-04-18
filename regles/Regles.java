package regles;

import java.util.ArrayList;

import modele.Couleur;
import modele.Joueur;
import modele.Modele;
import modele.point.Point;
import modele.point.PointCouleur;
import modele.segment.Segment;

public class Regles {
	
	public Modele modele;

	public Regles(Modele modele) {
		this.modele = modele;
	}

	public boolean jouerAcoteSoit(PointCouleur p) {
		Joueur j = modele.getJoueur(modele.getJoueurCourant());
		for (int i = 0; i < modele.getSizeSegments(); i++) {
			Point v = modele.getSegment(i).getVoisin(p);
			if (v instanceof PointCouleur) {
				PointCouleur pc = (PointCouleur) v;
				if (pc.getCouleur().equals(j.getCouleur()) && p.getCouleur().equals(Couleur.BLANC)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean jouerAcoteEnnemi(PointCouleur p) {
		Joueur j = modele.getJoueur(modele.getJoueurCourant());
		for (int i = 0; i < modele.getSizeSegments(); i++) {
			Point v = modele.getSegment(i).getVoisin(p);
			if (v instanceof PointCouleur) {
				PointCouleur pc = (PointCouleur) v;
				if (!pc.getCouleur().equals(j.getCouleur()) && !pc.getCouleur().equals(Couleur.BLANC)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean jouerSurEnnemi(PointCouleur p) {
		Joueur j = modele.getJoueur(modele.getJoueurCourant());
		return !p.getCouleur().equals(j.getCouleur()) && !estBlanc(p);
	}

	public boolean estBlanc(PointCouleur p) {
		return p.getCouleur().equals(Couleur.BLANC);
	}

	public boolean allAround(Point p) {
		Joueur j = modele.getJoueur(modele.getJoueurCourant());
		for (int i = 0; i < modele.getSizeSegments(); i++) {
			Point v = modele.getSegment(i).getVoisin(p);
			if (v != null) {
				if (v != null && v instanceof PointCouleur) {
					PointCouleur pc = (PointCouleur) v;
					if (!pc.getCouleur().equals(j.getCouleur())) {
						return false;
					}
				} else if (v != null) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean estLie(Point p, ArrayList<Point> point, Point depart) {
		point.add(p);
		for (Segment s : modele.getSegments()) {
			Point voisin = s.getVoisin(p);
			if(voisin instanceof PointCouleur) {
				if(((PointCouleur) voisin).getCouleur().equals(((PointCouleur) depart).getCouleur())) {
					if (voisin == depart) {
						return true;
					}
					if (!point.contains(voisin)) {
						if (estLie(voisin, point, depart))
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean estColoriable(){
		for(Point p : modele.getPoints()) {
			if(!(p instanceof PointCouleur)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean seCroise(Segment s1, Segment s2){
		double x1A = s1.getPoint1().getX();
		double y1A = s1.getPoint1().getY();
		double x1B = s1.getPoint2().getX();
		double y1B = s1.getPoint2().getY();
		
		double x2A = s2.getPoint1().getX();
		double y2A = s2.getPoint1().getY();
		double x2B = s2.getPoint2().getX();
		double y2B = s2.getPoint2().getY();
		
		double a1 = (y1B-y1A)/(x1B-x1A);
		double a2 = (y2B-y2A)/(x2B-x2A);
		if(a1 == a2) {return false;}
		double b1 = y1A - (a1 * x1A);
		double b2 = y2B - (a2 * x2B);
		
		double xCommun = (b2-b1)/(a1-a2);
		
		return (xCommun > x1A && xCommun <x1B && xCommun > x2A && xCommun < x2B) || (xCommun < x1A && xCommun >x1B && xCommun < x2A && xCommun > x2B);
		
	}
}
