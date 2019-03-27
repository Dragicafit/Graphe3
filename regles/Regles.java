package regles;

import java.util.ArrayList;

import modele.Couleur;
import modele.Joueur;
import modele.Modele;
import modele.point.Point;
import modele.point.PointCouleur;
import modele.segment.Segment;

public class Regles {
	public Modele m;
	private Boolean jouerAcoteSoit;
	private Boolean jouerAcoteEnnemi;
	private Boolean jouerSurEnnemi;
	private Boolean estBlanc;
	

	public Regles(Modele modele, Boolean check_soit, Boolean check_ennemi, Boolean jouerSurEnnemi, Boolean estBlanc) {
		this.jouerAcoteSoit = check_soit;
		this.jouerAcoteEnnemi = check_ennemi;
		this.jouerSurEnnemi = jouerSurEnnemi;
		this.m = modele;
	}
	
	public Boolean getCheckCoteSoit() {
		return jouerAcoteSoit;
	}
	
	public Boolean getCheckCoteEnnemi() {
		return jouerAcoteEnnemi;
	}
	
	public Boolean getSurEnnemi() {
		return jouerSurEnnemi;
	}
	
	public Boolean getEstBlanc() {
		return estBlanc;
	}



	public boolean jouerAcoteSoit(PointCouleur p) {
		Joueur j = m.getJoueur(m.getJoueurCourant());
		for (int i = 0; i < m.getSizeSegments(); i++) {
			Point v = m.getSegment(i).getVoisin(p);
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
		Joueur j = m.getJoueur(m.getJoueurCourant());
		for (int i = 0; i < m.getSizeSegments(); i++) {
			Point v = m.getSegment(i).getVoisin(p);
			if (v instanceof PointCouleur) {
				PointCouleur pc = (PointCouleur) v;
				if (!pc.getCouleur().equals(j.getCouleur()) && !pc.getCouleur().equals(Couleur.BLANC)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean jouerSurEnnemi(Point p) {
		Joueur j = m.getJoueur(m.getJoueurCourant());
		PointCouleur ennemi;
		for (int i = 0; i < m.getSizeSegments(); i++) {
			if (m.getSegment(i).getPoint1() == p) {
				ennemi = (PointCouleur) m.getSegment(i).getPoint1();
				if (ennemi.getCouleur() != j.getCouleur()) {
					return true;
				}
			} else if (m.getSegment(i).getPoint2() == p) {
				ennemi = (PointCouleur) m.getSegment(i).getPoint2();
				if (ennemi.getCouleur() != j.getCouleur()) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean estBlanc(PointCouleur p) {
		return p.getCouleur().equals(Couleur.BLANC);
	}

	public boolean allAround(Point p) {
		Joueur j = m.getJoueur(m.getJoueurCourant());
		for (int i = 0; i < m.getSizeSegments(); i++) {
			Point v = m.getSegment(i).getVoisin(p);
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
	
	public boolean estLie(Point p, ArrayList<Point> point,Point depart) {
		point.add(p);
		for (Segment s : m.getSegments()) {
			Point deux = s.getVoisin(p);
			if (deux == depart) {
				return true;
			}
			if (deux != null && !point.contains(deux)) {
				return estLie(deux, point, depart);
			}

		}
		return false;
	}
	

}
