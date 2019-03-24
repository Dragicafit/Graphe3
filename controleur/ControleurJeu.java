package controleur;

import Jeux.Jeux;
import javafx.scene.control.Button;
import javafx.scene.input.InputEvent;
import modele.point.PointCouleur;
import modele.segment.SegmentCouleur;
import vue.Vue;

public class ControleurJeu extends ControleurRetour {

	protected Jeux jeu;
	private Object action;

	public ControleurJeu(Vue vue, Jeux jeu) {
		super(vue);
		this.jeu = jeu;
	}

	public synchronized void setApplique(Object action) {
		this.action = action;
		notify();
	}

	public void applique(PointCouleur p) {
		p.setCouleur(modele.getJoueur(modele.getJoueurCourant()).getCouleur());
	}

	public void applique(PointCouleur p, double x, double y) {
		p.setX(x);
		p.setY(y);
	}

	public void applique(SegmentCouleur s) {
		s.setCouleur(modele.getJoueur(modele.getJoueurCourant()).getCouleur());
	}

	@Override
	public synchronized void handle(InputEvent event) {
		super.handle(event);
		Object source = event.getSource();
		if (source instanceof Button && vue.getBoutons().containsKey(source)) {
			bouton = boutons.get(vue.getBoutons((Button) source));
		} else {
			action = null;
			jeu.setEvent(event);
			try {
				wait();
				if (action != null) {
					jeu.applique(action);
					vue.update();
				}
			} catch (InterruptedException e) {
			}
		}
		event.consume();
	}

	@Override
	public void exit() {
		jeu.interrupt();
		super.exit();
	}
}
