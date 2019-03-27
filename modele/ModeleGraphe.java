package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import modele.point.Point;
import modele.segment.Segment;

public class ModeleGraphe implements Serializable {
	private static final long serialVersionUID = 51L;

	private String nom;
	private ArrayList<Point> points;
	private Map<String, Point> pointsSpeciaux;
	private ArrayList<Segment> segments;
	private ArrayList<Joueur> joueurs;

	private int joueurCourant;

	public ModeleGraphe(String nom) {
		this();
		this.nom = nom;
	}

	public ModeleGraphe() {
		this.nom = null;
		this.points = new ArrayList<>();
		this.pointsSpeciaux = new HashMap<>();
		this.segments = new ArrayList<>();
		this.joueurs = new ArrayList<>();
		this.joueurCourant = 0;
	}

	public void addPoint(Point point) {
		if (!points.contains(point))
			points.add(point);
	}

	public void addPointSpeciaux(String string, Point point) {
		if (!pointsSpeciaux.containsKey(string))
			pointsSpeciaux.put(string, point);
	}

	public void addSegment(Segment segment) {
		if (!segments.contains(segment))
			segments.add(segment);
	}

	public void addJoueur(Joueur joueur) {
		if (!joueurs.contains(joueur))
			joueurs.add(joueur);
	}

	public Point getPoint(int index) {
		return points.get(index);
	}

	public ArrayList<Point> getPoints() {
		return points;
	}

	public Point getPointSpeciaux(String string) {
		return pointsSpeciaux.get(string);
	}

	public Map<String, Point> getPointsSpeciaux() {
		return pointsSpeciaux;
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

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ModeleGraphe) {
			ModeleGraphe modeleGraphe = (ModeleGraphe) obj;
			return nom.equals(modeleGraphe.nom) && points.equals(modeleGraphe.points)
					&& pointsSpeciaux.equals(modeleGraphe.pointsSpeciaux) && segments.equals(modeleGraphe.segments)
					&& joueurs.equals(modeleGraphe.joueurs);
		}
		return false;
	}

}