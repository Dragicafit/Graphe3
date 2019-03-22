package controleur;

import Jeux.Jeux;
import javafx.scene.control.Button;
import javafx.scene.input.InputEvent;
import modele.point.PointCouleur;
import modele.segment.SegmentCouleur;
import vue.Vue;

public class ControleurJeu extends ControleurRetour {

	protected Jeux jeu;

	public ControleurJeu(Vue vue, Jeux jeu) {
		super(vue);
		this.jeu = jeu;
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
	public void handle(InputEvent event) {
		super.handle(event);
		Object source = event.getSource();
		if (source instanceof Button && vue.getBoutons().containsKey(source)) {
			bouton = boutons.get(vue.getBoutons((Button) source));
		} else {
			jeu.setEvent(event);
		}
		event.consume();
	}

	@Override
	public void exit() {
		jeu.interrupt();
		super.exit();
	}
}
