package Jeux;

import java.util.ArrayList;

import controleur.ControleurJeu;
import javafx.application.Platform;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import modele.Modele;
import modele.point.Point;
import modele.point.PointCouleur;
import modele.segment.SegmentCouleur;
import regles.Regles;
import vue.Vue;
import vue.VueGagnant;

public class Jeux extends Thread {

	protected Regles regles;
	protected Modele modele;
	protected Vue vue;
	protected InputEvent event;

	public Jeux(Vue vue) {
		super("Jeu");
		this.modele = vue.getModele();
		this.regles = new Regles(modele);
		this.vue = vue;
		this.event = null;
	}

	@Override
	public void run() {
		try {
			while (!end_game()) {
				int j = modele.getJoueurCourant();
				if (!tour(j)) {
					synchronized (vue.getControleur()) {
						((ControleurJeu) vue.getControleur()).notify();
					}
				}
			}
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					new VueGagnant(modele);
				}
			});
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
			if (source instanceof Circle && vue.getCercles().containsKey(source)) {
				if (modele.getRegleCourant().DeplacementAutorise.get()) {
					((ControleurJeu) vue.getControleur()).setApplique((Circle) source);
					return false;
				}
			}
		} else if (source instanceof Circle && vue.getCercles().containsKey((Circle) source)) {
			PointCouleur point = (PointCouleur) (vue.getCercles().get((Circle) source));
			if (check_regles(point)) {
				((ControleurJeu) vue.getControleur()).setApplique(point);
				return true;
			}
		}
		return false;
	}

	public boolean check_regles(Point p) {
		if (modele.getRegleCourant().JouerAcoteSoit.get() != null) {
			if (modele.getRegleCourant().JouerAcoteSoit.get()) {
				if (!regles.jouerAcoteSoit((PointCouleur) p)) {
					return false;
				}
			} else {
				if (regles.jouerAcoteSoit((PointCouleur) p)) {
					return false;
				}
			}
		}
		if (modele.getRegleCourant().JouerAcoteEnnemi.get() != null) {
			if (modele.getRegleCourant().JouerAcoteEnnemi.get()) {
				if (!regles.jouerAcoteEnnemi((PointCouleur) p)) {
					return false;
				}
			} else {
				if (regles.jouerAcoteEnnemi((PointCouleur) p)) {
					return false;
				}
			}
		}
		if (modele.getRegleCourant().JouerSurEnnemi.get() != null) {
			if (!modele.getRegleCourant().JouerSurEnnemi.get()) {
				if (regles.jouerSurEnnemi((PointCouleur) p)) {
					return false;
				}
			}
		}
		if (modele.getRegleCourant().EstBlanc.get() != null) {
			if (modele.getRegleCourant().EstBlanc.get()) {
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
		if (modele.getRegleCourant().FinHex.get()) {
			ArrayList<Point> point = new ArrayList<>();
			if (regles.estLie(modele.getGrapheCourant().getPointSpeciaux("depart0"), point, this.modele.getGrapheCourant().getPointSpeciaux("arrive0"))) {
				return true;
			}
			point.clear();
			if (regles.estLie(modele.getGrapheCourant().getPointSpeciaux("depart1"), point, modele.getGrapheCourant().getPointSpeciaux("arrive1"))) {
				return true;
			}
			return false;
		} else {
			for (Point p : modele.getPoints()) {
				if (check_regles(p)) {
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
