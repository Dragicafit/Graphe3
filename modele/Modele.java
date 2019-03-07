package modele;

import java.util.ArrayList;

import modele.point.Point;
import modele.segment.Segment;

public class Modele {
	private ArrayList<Point> points;
	private ArrayList<Segment> segments;
	private ArrayList<Joueur> joueurs;

	private int joueurCourant;

	public Modele() {
		this.points = new ArrayList<>();
		this.segments = new ArrayList<>();
		this.joueurs = new ArrayList<>();
		this.joueurCourant = 0;
	}

	public void addPoint(Point point) {
		points.add(point);
	}

	public void addSegment(Segment segment) {
		segments.add(segment);
	}

	public void addJoueur(Joueur joueur) {
		joueurs.add(joueur);
	}

	public Point getPoint(int index) {
		return points.get(index);
	}

	public Segment getSegment(int index) {
		return segments.get(index);
	}
	
	public int getSize_segments() {
		return segments.size();
	}

	public boolean containsPoint(Point p) {
		return points.contains(p);
	}
	
	public boolean containsSegment(Segment s) {
		return segments.contains(s);
	}
	
	public Joueur getJoueur(int index) {
		return joueurs.get(index);
	}
	
	public int getJoueurCourant() {
		return joueurCourant;
	}
	
	public void setJoueurCourant(int joueurCourant) {
		this.joueurCourant = joueurCourant;
	}
	
	public int getSizePoints() {
		return points.size();
	}
	
	public int getSizeSegments() {
		return segments.size();
	}
	
	public void removePoint(Point p) {
		for (int i = segments.size()-1; i>=0; i--) {
			if (segments.get(i).getPoint1() == p || segments.get(i).getPoint2() == p)
				removeSegment(i);
		}
		points.remove(p);
	}
	
	public void removePoint(int nb) {
		removePoint(points.get(nb));
	}
	
	public void removeSegment(Segment s) {
		segments.remove(s);
	}
	
	public void removeSegment(int i) {
		segments.remove(i);
	}
	
	public void supprimerTout() {
		points.clear();
		segments.clear();
	}
}
