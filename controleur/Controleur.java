package controleur;

import java.util.HashMap;
import java.util.Map;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import modele.Joueur;
import modele.Modele;
import modele.point.Point;
import modele.point.PointCouleur;
import modele.segment.Segment;
import modele.segment.SegmentCouleur;
import vue.Vue;
import vue.VueJeu;

public class Controleur implements EventHandler<MouseEvent> {
	protected Modele modele;
	protected Vue vue;
	protected Joueur joueur;
	protected Bouton bouton;
	protected Map<String, Bouton> boutons;
	protected Point premierPoint;

	public Controleur(Vue vue) {
		this.modele = vue.getModele();
		this.vue = vue;
		boutons = new HashMap<>();
		premierPoint = null;
		boutons.put("point", Bouton.POINT);
		boutons.put("segment", Bouton.SEGMENT);
		boutons.put("undo", Bouton.UNDO);
		boutons.put("redo", Bouton.REDO);
		boutons.put("supprimer", Bouton.SUPPRIMER);
		boutons.put("colorier", Bouton.COLORIER);
		boutons.put("deplacer", Bouton.DEPLACER);
		boutons.put("supprimer tout", Bouton.SUPPRIMERTOUT);
	}

	@Override
	public void handle(MouseEvent event) {
		Object source = event.getSource();
		if (source instanceof Circle && vue.getCercles().contains(source)) {
			Point point = modele.getPoint(vue.getCercles().indexOf((Circle) source));
			if (point instanceof PointCouleur && bouton == Bouton.COLORIER) {
				((PointCouleur) point).setCouleur(modele.getJoueur(modele.getJoueurCourant()).getCouleur());
			} else if (bouton == Bouton.SUPPRIMER) {
				modele.removePoint(point);
			} else if (bouton == Bouton.SEGMENT) {
				if (premierPoint == null) {
					premierPoint = modele.getPoint(vue.getCercles().indexOf((Circle) source));
				} else {
					this.modele.addSegment(new Segment(premierPoint, modele.getPoint(vue.getCercles().indexOf((Circle) source))));
					premierPoint = null;
				}
			}
		} else if (source instanceof Line && vue.getLignes().contains(source)) {
			Segment segment = modele.getSegment(vue.getLignes().indexOf((Line) source));
			if (segment instanceof SegmentCouleur && bouton == Bouton.COLORIER) {
				((SegmentCouleur) segment).setCouleur(modele.getJoueur(modele.getJoueurCourant()).getCouleur());
			} else if (bouton == Bouton.SUPPRIMER) {
				modele.removeSegment(vue.getLignes().indexOf((Line) source));
			}
		} else if (vue instanceof VueJeu && source instanceof Pane && ((VueJeu) vue).getGraphe() == source) {
			if (bouton == Bouton.POINT) {
				this.modele.addPoint(new Point(event.getX(), event.getY()));
			}
		} else if (source instanceof Button && vue.getBoutons().containsKey((Button) source)) {
			bouton = boutons.get(vue.getBoutons((Button) source));
		}
		vue.update();
	}
}

enum Bouton {
	POINT, SEGMENT, UNDO, REDO, SUPPRIMER, COLORIER, DEPLACER, SUPPRIMERTOUT
}
