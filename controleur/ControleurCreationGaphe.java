package controleur;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
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
		this.boutons.put("supprimerTout", Bouton.SUPPRIMERTOUT);
		this.boutons.put("sauvegarder", Bouton.SAUVEGARDER);
		this.boutons.put("retour", Bouton.RETOUR);
	}

	@Override
	public void handle(MouseEvent event) {
		Object source = event.getSource();
		if (source instanceof Circle && vue.getCercles().contains(source)) {
			event.consume();
			Point point = modele.getPoint(vue.getCercles().indexOf(source));
			if (point instanceof PointCouleur && bouton == Bouton.COLORIER) {
				((PointCouleur) point).setCouleur(modele.getJoueur(modele.getJoueurCourant()).getCouleur());
			} else if (bouton == Bouton.SUPPRIMER) {
				modele.removePoint(point);
			} else if (bouton == Bouton.SEGMENT) {
				if (premierPoint == null) {
					premierPoint = modele.getPoint(vue.getCercles().indexOf(source));
				} else {
					addSegment(premierPoint, modele.getPoint(vue.getCercles().indexOf(source)));
					if (event.isControlDown() && premierPoint != null) {
						premierPoint = modele.getPoint(vue.getCercles().indexOf(source));
					} else {
						premierPoint = null;
					}
				}
			} else {
				premierPoint = modele.getPoint(vue.getCercles().indexOf(source));
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
				double x = event.getX();
				double y = event.getY();
				if (premierPoint != null) {
					if (event.isShiftDown()) {
						if (event.getX() > premierPoint.getX() - 60 && event.getX() < premierPoint.getX() + 60) {
							x = premierPoint.getX();
						} else if (event.getY() > premierPoint.getY() - 60 && event.getY() < premierPoint.getY() + 60) {
							y = premierPoint.getY();
						}
					} else if (event.isAltDown()) {
						x = premierPoint.getX() + (x - premierPoint.getX()) * 120 / Math.sqrt(Math.pow(x - premierPoint.getX(), 2) + Math.pow(y - premierPoint.getY(), 2));
						y = premierPoint.getY() + (y - premierPoint.getY()) * 120 / Math.sqrt(Math.pow(x - premierPoint.getX(), 2) + Math.pow(y - premierPoint.getY(), 2));
					}
				}
				addPoint(x, y);
				premierPoint = modele.getPoint(modele.getSizePoints() - 1);
			} else if (bouton == Bouton.SEGMENT && premierPoint != null) {
				if (event.isControlDown()) {
					addPointSegment(event.getX(), event.getY());
				} else if (event.isShiftDown()) {
					if (event.getX() > premierPoint.getX() - 60 && event.getX() < premierPoint.getX() + 60) {
						addPointSegment(premierPoint.getX(), event.getY());
					} else if (event.getY() > premierPoint.getY() - 60 && event.getY() < premierPoint.getY() + 60) {
						addPointSegment(event.getX(), premierPoint.getY());
					}
				} else if (event.isAltDown()) {
					double x = event.getX();
					double y = event.getY();
					x = premierPoint.getX() + (x - premierPoint.getX()) * 120 / Math.sqrt(Math.pow(x - premierPoint.getX(), 2) + Math.pow(y - premierPoint.getY(), 2));
					y = premierPoint.getY() + (y - premierPoint.getY()) * 120 / Math.sqrt(Math.pow(x - premierPoint.getX(), 2) + Math.pow(y - premierPoint.getY(), 2));
					addPointSegment(x, y);
				}
				premierPoint = modele.getPoint(modele.getSizePoints() - 1);
			} else {
				premierPoint = null;
			}
		} else if (source instanceof Button && vue.getBoutons().containsKey(source)) {
			if (bouton == boutons.get(vue.getBoutons((Button) source))) {
				bouton = null;
			} else {
				bouton = boutons.get(vue.getBoutons((Button) source));
				premierPoint = null;
			}
		}
		if (bouton == Bouton.SUPPRIMERTOUT) {
			modele.supprimerTout();
			bouton = null;
			premierPoint = null;
		}
		vue.update();
	}

	public void addPoint(double x, double y) {
		for (int i = 0; i < modele.getSizePoints(); i++) {
			if (Math.sqrt(Math.pow(modele.getPoint(i).getX() - x, 2) + Math.pow(modele.getPoint(i).getY() - y, 2)) < 60) {
				return;
			}
		}
		this.modele.addPoint(new PointCouleur(x, y, Color.WHITE));
	}
	
	public void addSegment(Point p1, Point p2) {
		this.modele.addSegment(new SegmentCouleur(p1, p2, Color.BLACK));
	}
	
	public void addPointSegment(double x, double y) {
		addPoint(x, y);
		addSegment(premierPoint, modele.getPoint(modele.getSizePoints() - 1));
	}
}
