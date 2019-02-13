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

	public Joueur getJoueur(int index) {
		return joueurs.get(index);
	}

	public int getJoueurCourant() {
		return joueurCourant;
	}

	public void setJoueurCourant(int joueurCourant) {
		this.joueurCourant = joueurCourant;
	}
}
