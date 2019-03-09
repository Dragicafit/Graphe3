package controleur;

import Jeux.Jeux;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import modele.point.Point;
import modele.point.PointCouleur;
import modele.segment.Segment;
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

	public void applique(MouseEvent event) {
		Object source = event.getSource();
		if (source instanceof Circle && vue.getCercles().contains(source)) {
			Point point = modele.getPoint(vue.getCercles().indexOf(source));
			if (point instanceof PointCouleur && bouton == Bouton.COLORIER) {
				((PointCouleur) point).setCouleur(modele.getJoueur(modele.getJoueurCourant()).getCouleur());
			}
		} else if (source instanceof Line && vue.getLignes().contains(source)) {
			Segment segment = modele.getSegment(vue.getLignes().indexOf(source));
			if (segment instanceof SegmentCouleur && bouton == Bouton.COLORIER) {
				((SegmentCouleur) segment).setCouleur(modele.getJoueur(modele.getJoueurCourant()).getCouleur());
			}
		}
	}

	@Override
	public void handle(MouseEvent event) {
		Object source = event.getSource();
		if (source instanceof Button && vue.getBoutons().containsKey(source)) {
			bouton = boutons.get(vue.getBoutons((Button) source));
		} else {
			jeu.setEvent(event);
			jeu.run();
		}
		vue.update();
	}
}
