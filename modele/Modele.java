package modele;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import modele.point.Point;
import modele.segment.Segment;

public class Modele implements Serializable {
	private static final long serialVersionUID = 50L;

	private ArrayList<ModeleGraphe> graphesPredefinis;
	private ArrayList<ModeleGraphe> graphesLocal;
	private ArrayList<ModeleRegle> reglesPredefinis;
	private ArrayList<ModeleRegle> reglesLocal;

	private ModeleGraphe grapheCourant;
	private ModeleRegle regleCourant;

	public Modele() {
		graphesPredefinis = new ArrayList<>();
		graphesLocal = new ArrayList<>();
		reglesPredefinis = new ArrayList<>();
		reglesLocal = new ArrayList<>();

		grapheCourant = null;
		regleCourant = null;
	}

	public void exportModele() throws IOException {
		String fileName = "modele.ser";
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this);
		oos.close();
	}

	public static Modele importModele() throws IOException, ClassNotFoundException {
		String fileName = "modele.ser";
		FileInputStream fin = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fin);
		Modele m = (Modele) ois.readObject();
		ois.close();
		return m;
	}

	public ArrayList<ModeleGraphe> getGraphesPredefinis() {
		return graphesPredefinis;
	}

	public void setGraphesPredefinis(ArrayList<ModeleGraphe> graphesPredefinis) {
		this.graphesPredefinis = graphesPredefinis;
	}

	public ArrayList<ModeleGraphe> getGraphesLocal() {
		return graphesLocal;
	}

	public void setGraphesLocal(ArrayList<ModeleGraphe> graphesLocal) {
		this.graphesLocal = graphesLocal;
	}

	public ArrayList<ModeleRegle> getReglesPredefinis() {
		return reglesPredefinis;
	}

	public void setReglesPredefinis(ArrayList<ModeleRegle> reglesPredefinis) {
		this.reglesPredefinis = reglesPredefinis;
	}

	public ArrayList<ModeleRegle> getReglesLocal() {
		return reglesLocal;
	}

	public void setReglesLocal(ArrayList<ModeleRegle> reglesLocal) {
		this.reglesLocal = reglesLocal;
	}

	public ModeleGraphe getGrapheCourant() {
		return grapheCourant;
	}

	public void setGrapheCourant(ModeleGraphe grapheCourant) {
		this.grapheCourant = grapheCourant;
	}

	public ModeleRegle getRegleCourant() {
		return regleCourant;
	}

	public void setRegleCourant(ModeleRegle regleCourant) {
		this.regleCourant = regleCourant;
	}

	public void addPoint(Point point) {
		grapheCourant.addPoint(point);
	}

	public void addSegment(Segment segment) {
		grapheCourant.addSegment(segment);
	}

	public void addJoueur(Joueur joueur) {
		grapheCourant.addJoueur(joueur);
	}

	public Point getPoint(int index) {
		return grapheCourant.getPoint(index);
	}

	public ArrayList<Point> getPoints() {
		return grapheCourant.getPoints();
	}

	public Segment getSegment(int index) {
		return grapheCourant.getSegment(index);
	}

	public ArrayList<Segment> getSegments() {
		return grapheCourant.getSegments();
	}

	public boolean containsPoint(Point p) {
		return grapheCourant.containsPoint(p);
	}

	public boolean containsSegment(Segment s) {
		return grapheCourant.containsSegment(s);
	}

	public Joueur getJoueur(int index) {
		return grapheCourant.getJoueur(index);
	}

	public int getJoueurCourant() {
		return grapheCourant.getJoueurCourant();
	}

	public void setJoueurCourant(int joueurCourant) {
		this.grapheCourant.setJoueurCourant(joueurCourant);
		;
	}

	public int getSizePoints() {
		return grapheCourant.getSizePoints();
	}

	public int getSizeSegments() {
		return grapheCourant.getSizeSegments();
	}

	public int getNbJoueurs() {
		return grapheCourant.getNbJoueurs();
	}

	public void removePoint(Point p) {
		grapheCourant.removePoint(p);
	}

	public void removePoint(int nb) {
		grapheCourant.removePoint(nb);
	}

	public void removeSegment(Segment s) {
		grapheCourant.removeSegment(s);
	}

	public void removeSegment(int i) {
		grapheCourant.removeSegment(i);
	}

	public void supprimerTout() {
		grapheCourant.supprimerTout();
	}

}
