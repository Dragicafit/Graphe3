package controleur;

import Jeux.Jeux;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import modele.point.PointCouleur;
import modele.segment.SegmentCouleur;
import vue.Vue;

public class ControleurJeu extends Controleur {

	protected Jeux jeu;

	public ControleurJeu(Vue vue, Jeux jeu) {
		super(vue);
		this.jeu = jeu;
		this.boutons.put("colorier", Bouton.COLORIER);
		this.boutons.put("deplacer", Bouton.DEPLACER);
	}

	public void applique(PointCouleur p) {
		if (bouton == Bouton.COLORIER) {
			p.setCouleur(modele.getJoueur(modele.getJoueurCourant()).getCouleur());
		}
	}
	
	public void applique(PointCouleur p, double x, double y) {
		if (bouton == Bouton.DEPLACER) {
			p.setX(x);
			p.setY(y);
		}
	}

	public void applique(SegmentCouleur s) {
		if (bouton == Bouton.COLORIER) {
			s.setCouleur(modele.getJoueur(modele.getJoueurCourant()).getCouleur());
		}
	}

	@Override
	public void handle(MouseEvent event) {
		Object source = event.getSource();
		if (source instanceof Button && vue.getBoutons().containsKey(source)) {
			bouton = boutons.get(vue.getBoutons((Button) source));
		} else {
			jeu.setEvent(event);
		}
		event.consume();
	}
}
