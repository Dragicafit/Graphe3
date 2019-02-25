package controleur;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import modele.point.Point;
import modele.point.PointCouleur;
import modele.segment.Segment;
import modele.segment.SegmentCouleur;
import vue.Vue;
import vue.VueJeu;

public class ControleurCreationGaphe extends Controleur {

	private Point premierPoint;

	public ControleurCreationGaphe(Vue vue) {
		super(vue);
		this.premierPoint = null;
		this.boutons.put("point", Bouton.POINT);
		this.boutons.put("segment", Bouton.SEGMENT);
		this.boutons.put("supprimer", Bouton.SUPPRIMER);
		this.boutons.put("colorier", Bouton.COLORIER);
		this.boutons.put("deplacer", Bouton.DEPLACER);
		this.boutons.put("supprimer tout", Bouton.SUPPRIMERTOUT);
		this.boutons.put("sauvegarder", Bouton.SAUVEGARDER);
		this.boutons.put("retour", Bouton.RETOUR);
	}

	@Override
	public void handle(MouseEvent event) {
		Object source = event.getSource();
		if (source instanceof Circle && vue.getCercles().contains(source)) {
			Point point = modele.getPoint(vue.getCercles().indexOf(source));
			if (point instanceof PointCouleur && bouton == Bouton.COLORIER) {
				((PointCouleur) point).setCouleur(modele.getJoueur(modele.getJoueurCourant()).getCouleur());
			} else if (bouton == Bouton.SUPPRIMER) {
				modele.removePoint(point);
			} else if (bouton == Bouton.SEGMENT) {
				if (premierPoint == null) {
					premierPoint = modele.getPoint(vue.getCercles().indexOf(source));
				} else {
					this.modele.addSegment(
							new Segment(premierPoint, modele.getPoint(vue.getCercles().indexOf((Circle) source))));
					premierPoint = null;
				}
			}
		} else if (source instanceof Line && vue.getLignes().contains(source)) {
			Segment segment = modele.getSegment(vue.getLignes().indexOf(source));
			if (segment instanceof SegmentCouleur && bouton == Bouton.COLORIER) {
				((SegmentCouleur) segment).setCouleur(modele.getJoueur(modele.getJoueurCourant()).getCouleur());
			} else if (bouton == Bouton.SUPPRIMER) {
				modele.removeSegment(vue.getLignes().indexOf(source));
			}
		} else if (vue instanceof VueJeu && source instanceof Pane && source == ((VueJeu) vue).getGraphe()) {
			if (bouton == Bouton.POINT) {
				this.modele.addPoint(new Point(event.getX(), event.getY()));
			}
		} else if (source instanceof Button && vue.getBoutons().containsKey(source)) {
			bouton = boutons.get(vue.getBoutons((Button) source));
		}
		if (bouton == Bouton.SUPPRIMERTOUT) {
			modele.supprimerTout();
			bouton = null;
		}
		vue.update();
	}
}
