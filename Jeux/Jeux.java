package Jeux;

import controleur.ControleurJeu;
import javafx.scene.input.InputEvent;
import modele.Modele;
import modele.point.Point;
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
					((ControleurJeu) vue.getControleur()).setApplique(null);
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

	public abstract boolean deplacementAvailable();

	public abstract boolean end_game();

	public abstract boolean tour(int nb) throws InterruptedException;

	public abstract boolean check_regles(Point p);

	public abstract void applique(Object o);
}
