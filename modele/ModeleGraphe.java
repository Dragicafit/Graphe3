package modele;

import java.io.Serializable;
import java.util.ArrayList;

import modele.point.Point;
import modele.point.PointCouleur;
import modele.segment.Segment;

public class ModeleGraphe implements Serializable {
	
	private String nom;
	private ArrayList<Point> points;
	private ArrayList<Segment> segments;
	private ArrayList<Joueur> joueurs;

	private int joueurCourant;

	public ModeleGraphe(String nom) {
		this.points = new ArrayList<>();
		this.segments = new ArrayList<>();
		this.joueurs = new ArrayList<>();
		this.joueurCourant = 0;
		this.nom = nom;
	}
	
	public ModeleGraphe() {
		this.points = new ArrayList<>();
		this.segments = new ArrayList<>();
		this.joueurs = new ArrayList<>();
		this.joueurCourant = 0;
		this.nom = null;
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
	
	public ArrayList<Point> getPoints() {
		return points;
	}

	public Segment getSegment(int index) {
		return segments.get(index);
	}
	
	public ArrayList<Segment> getSegments() {
		return segments;
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

	public int getNbJoueurs() {
		return joueurs.size();
	}

	public void removePoint(Point p) {
		for (int i = segments.size() - 1; i >= 0; i--) {
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
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
}