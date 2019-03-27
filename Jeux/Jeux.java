package Jeux;

import java.util.ArrayList;

import controleur.ControleurJeu;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import modele.Modele;
import modele.point.Point;
import modele.point.PointCouleur;
import modele.segment.SegmentCouleur;
import regles.Regles;
import vue.Vue;

public class Jeux extends Thread {

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
				if (regles.DeplacementAutorise) {
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

	public boolean check_regles(Point p) {
		if (regles.JouerAcoteSoit != null) {
			if (regles.JouerAcoteSoit) {
				if (!regles.jouerAcoteSoit((PointCouleur) p)) {
					return false;
				}
			} else {
				if (regles.jouerAcoteSoit((PointCouleur) p)) {
					return false;
				}
			}
		}
		if (regles.JouerAcoteEnnemi != null) {
			if (regles.JouerAcoteEnnemi) {
				if (!regles.jouerAcoteEnnemi((PointCouleur) p)) {
					return false;
				}
			} else {
				if (regles.jouerAcoteEnnemi((PointCouleur) p)) {
					return false;
				}
			}
		}
		if (regles.JouerSurEnnemi != null) {
			if (regles.JouerSurEnnemi) {
				if (!regles.jouerSurEnnemi(p)) {
					return false;
				}
			} else {
				if (regles.jouerSurEnnemi(p)) {
					return false;
				}
			}
		}
		if (regles.EstBlanc != null) {
			if (regles.EstBlanc) {
				if (!regles.estBlanc((PointCouleur) p)) {
					return false;

				}
			} else {
				if (regles.estBlanc((PointCouleur) p)) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean end_game() {
		if (regles.FinHex) {
			ArrayList<Point> point = new ArrayList<>();
			if (regles.estLie(this.red2, point, this.red1)) {
				return true;
			}
			point.clear();
			if (regles.estLie(this.blue2, point, this.blue1)) {
				return true;
			}
			return false;
		} else {
			for (int i = 0; i < m.getSizePoints(); i++) {
				PointCouleur p = (PointCouleur) m.getPoint(i);
				if (!check_regles(p)) {
					return false;
				}
			}
			return true;
		}
	}
	
	public void applique(Object o) {
		ControleurJeu c = (ControleurJeu) vue.getControleur();
		if (o instanceof PointCouleur) {
			c.applique((PointCouleur) o);
		} else if (o instanceof SegmentCouleur) {
			c.applique((SegmentCouleur) o);
		} else if (o instanceof Circle) {
			c.appliqueDep((Circle) o);
		}
	}

}
