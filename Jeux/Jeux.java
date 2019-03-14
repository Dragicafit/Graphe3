package Jeux;

import javafx.scene.input.MouseEvent;
import modele.Modele;
import modele.point.Point;
import regles.Regles;
import vue.Vue;

public abstract class Jeux extends Thread {

	protected String nom;
	protected Regles regles;
	protected Modele m;
	protected Vue vue;
	protected MouseEvent event;

	public Jeux(String nom, Regles r, Vue vue) {
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
				if(tour(j)) {
					m.setJoueurCourant((j + 1) % m.getNbJoueurs());
					vue.update();

				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void setEvent(MouseEvent event) {
		this.event = event;
		notify();
	}
	
	public abstract boolean deplacementAvailable();

	public abstract boolean end_game();

	public abstract boolean tour(int nb) throws InterruptedException;

	public abstract boolean check_regles(Point p);
}
