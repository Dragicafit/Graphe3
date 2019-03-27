package Jeux;

import controleur.ControleurJeu;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import modele.Modele;
import modele.point.Point;
import modele.point.PointCouleur;
import regles.Regles;
import vue.Vue;

public abstract class Jeux extends Thread {

	protected String nom;
	protected Regles regles;
	protected Modele m;
	protected Vue vue;
	protected InputEvent event;

	public Jeux(String nom, Regles r, Vue vue) {
		super("Jeu");
		this.nom = nom;
		this.regles = r;
		this.m = vue.getModele();
		this.vue = vue;
		this.event = null;
	}

	@Override
	public void run() {
		try {
			while (!end_game()) {
				int j = m.getJoueurCourant();
				if (tour(j)) {
					m.setJoueurCourant((j + 1) % m.getNbJoueurs());
				} else {
					synchronized (vue.getControleur()) {
						((ControleurJeu) vue.getControleur()).notify();
					}
				}
			}
		} catch (InterruptedException e) {
		} finally {
			vue.getControleur().exit();
		}
	}

	public synchronized void setEvent(InputEvent event) {
		this.event = event;
		notify();
	}
	
	public synchronized boolean tour(int nb) throws InterruptedException {
		wait();
		Object source = event.getSource();
		if (event.getEventType() == MouseEvent.DRAG_DETECTED) {
			if (source instanceof Circle && vue.getCercles().contains(source)) {
				if (deplacementAvailable()) {
					((ControleurJeu) vue.getControleur()).setApplique((Circle) source);
					return false;
				}
			}
		} else if (source instanceof Circle && vue.getCercles().contains((Circle) source)) {
			PointCouleur point = (PointCouleur) m.getPoint(vue.getCercles().indexOf((Circle) source));
			if (check_regles(point)) {
				((ControleurJeu) vue.getControleur()).setApplique(point);
				return true;
			}
		}
		return false;
	}
	
	public abstract boolean check_regles(Point p);

	public abstract boolean end_game();

	public abstract void applique(Object o);
	
	public abstract boolean deplacementAvailable();

}
