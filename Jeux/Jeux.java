package Jeux;

import javafx.scene.input.MouseEvent;
import modele.Modele;
import modele.point.Point;
import regles.Regles;
import vue.Vue;

public abstract class Jeux {

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

	public abstract void tour(int nb);

	public void jeu() {
		while (!end_game()) {
			int j = m.getJoueurCourant();
			tour(j);
		}
	}

	public void setEvent(MouseEvent event) {
		this.event = event;
	}

	public abstract boolean end_game();

	public abstract boolean check_regles(Point p);

	public void attente() {
		while (event == null) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}

		}
	}
}
