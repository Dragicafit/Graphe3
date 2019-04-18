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
import modele.segment.Segment;
import modele.segment.SegmentCouleur;
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
			if (checkDebut()){
				while (!checkFin()) {
					int j = modele.getJoueurCourant();
					if (!tour(j)) {
						synchronized (vue.getControleur()) {
							((ControleurJeu) vue.getControleur()).notify();
						}
					}
					sleep(200);
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

	public synchronized boolean tour(int nb) throws InterruptedException, RuntimeException {
		wait();
		Object source = event.getSource();
		if (event.getEventType() == MouseEvent.DRAG_DETECTED) {
			if (modele.getRegleCourant().DeplacementAutorise.get()) {
				if (source instanceof Circle && vue.getCercles().containsKey(source)) {
					((ControleurJeu) vue.getControleur()).setApplique((Circle) source);
					return false;
				}
			}
		} else if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
			if (modele.getRegleCourant().ClickAutorise.get()) {
				if (source instanceof Circle && vue.getCercles().containsKey(source)) {
					PointCouleur point = (PointCouleur) (vue.getCercles().get(source));
					if (checkRegles(point)) {
						((ControleurJeu) vue.getControleur()).setApplique(point);
						return true;
					}
				}
			}
		} else {
			throw new RuntimeException("mauvait event");
		}
		return false;
	}

	public boolean checkRegles(Point p) {
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

	public boolean checkDebut() {
		return true;
	}

	public boolean checkFin() {
		if (modele.getRegleCourant().FinHex.get()) {
			ArrayList<Point> point = new ArrayList<>();
			if (regles.estLie(modele.getGrapheCourant().getPointSpeciaux("depart0"), point,
					this.modele.getGrapheCourant().getPointSpeciaux("arrive0"))) {
				return true;
			}
			point.clear();
			if (regles.estLie(modele.getGrapheCourant().getPointSpeciaux("depart1"), point,
					modele.getGrapheCourant().getPointSpeciaux("arrive1"))) {
				return true;
			}
			return false;
		}
		if (modele.getRegleCourant().FinDeplacement.get()) {
			for (Segment s : modele.getSegments()) {
				for (Segment seg : modele.getSegments()) {
					if (!s.sommetCommun(seg) && regles.seCroise(s, seg)) {
						return false;
					}
				}
			}
			return true;
		}
		for (Point p : modele.getPoints()) {
			if (checkRegles(p)) {
				return false;
			}
		}
		return true;
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
