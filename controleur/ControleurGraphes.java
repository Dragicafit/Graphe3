package controleur;

import javafx.scene.control.Button;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import modele.Couleur;
import modele.point.Point;
import modele.point.PointCouleur;
import modele.segment.Segment;
import modele.segment.SegmentCouleur;
import vue.Vue;
import vue.VueJeu;

public class ControleurGraphes extends ControleurRetour {

	private Point premierPoint;

	public ControleurGraphes(Vue vue) {
		super(vue);
		this.premierPoint = null;
		this.boutons.put("point", Bouton.POINT);
		this.boutons.put("segment", Bouton.SEGMENT);
		this.boutons.put("supprimer", Bouton.SUPPRIMER);
		this.boutons.put("colorier", Bouton.COLORIER);
		this.boutons.put("supprimerTout", Bouton.SUPPRIMERTOUT);
		this.boutons.put("sauvegarder", Bouton.SAUVEGARDER);
		this.boutons.put("retour", Bouton.RETOUR);
	}

	@Override
	public void handle(InputEvent event) {
        
        event.consume();
		Object source = event.getSource();
		if (event instanceof DragEvent) {
			DragEvent drag = (DragEvent) event;
			if (source instanceof Pane) {
				Circle cercle = (Circle) drag.getGestureSource();
				Point p = modele.getPoint(vue.getCercles().indexOf(cercle));
				drag.setDropCompleted(deplacerPoint(p, drag.getX(), drag.getY()));
			}
		} else if (event instanceof MouseEvent) {
			MouseEvent clic = (MouseEvent) event;
			if (clic.isDragDetect() && clic.getEventType() == MouseEvent.DRAG_DETECTED) {
				if (source instanceof Circle && vue.getCercles().contains(source)) {
					Dragboard db = ((Circle) source).startDragAndDrop(TransferMode.ANY);
			        ClipboardContent content = new ClipboardContent();
			        content.putString("");
			        db.setContent(content);
			        return;
				}
			} else {
				if (source instanceof Circle && vue.getCercles().contains(source)) {
					eventCercle(clic, (Circle) source);
				} else if (source instanceof Line && vue.getLignes().contains(source)) {
					eventLine(clic, (Line) source);
				} else if (vue instanceof VueJeu && source instanceof Pane && source == ((VueJeu) vue).getGraphe()) {
					eventVueJeu(clic);
				} else if (source instanceof Button && vue.getBoutons().containsKey(source)) {
					if (bouton == boutons.get(vue.getBoutons((Button) source))) {
						bouton = null;
					} else {
						bouton = boutons.get(vue.getBoutons((Button) source));
						premierPoint = null;
					}
				}
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
		this.modele.addPoint(new PointCouleur(x, y, Couleur.BLANC));
	}
	
	public boolean deplacerPoint(Point p, double x, double y) {
		for (int i = 0; i < modele.getSizePoints(); i++) {
			if (Math.sqrt(Math.pow(modele.getPoint(i).getX() - x, 2) + Math.pow(modele.getPoint(i).getY() - y, 2)) < 60) {
				return false;
			}
		}
		p.setX(x);
		p.setY(y);
		return true;
	}

	public void addSegment(Point p1, Point p2) {
		this.modele.addSegment(new SegmentCouleur(p1, p2, Couleur.BLANC));
	}

	public void addPointSegment(double x, double y) {
		addPoint(x, y);
		addSegment(premierPoint, modele.getPoint(modele.getSizePoints() - 1));
	}
	
	public void eventCercle(MouseEvent event, Circle source) {
		event.consume();
		Point point = modele.getPoint(vue.getCercles().indexOf(source));
		if (point instanceof PointCouleur && bouton == Bouton.COLORIER) {
			((PointCouleur) point).setCouleur(modele.getJoueur(modele.getJoueurCourant()).getCouleur());
		} else if (bouton == Bouton.SUPPRIMER) {
			modele.removePoint(point);
		} else if (bouton == Bouton.SEGMENT) {
			if (premierPoint == null) {
				premierPoint = point;
			} else {
				addSegment(premierPoint, point);
				if (event.isControlDown()) {
					premierPoint = point;
				} else {
					premierPoint = null;
				}
			}
		} else {
			premierPoint = point;
		}
	}
	
	public void eventLine(MouseEvent event, Line source) {
		Segment segment = modele.getSegment(vue.getLignes().indexOf(source));
		if (segment instanceof SegmentCouleur && bouton == Bouton.COLORIER) {
			((SegmentCouleur) segment).setCouleur(modele.getJoueur(modele.getJoueurCourant()).getCouleur());
		} else if (bouton == Bouton.SUPPRIMER) {
			modele.removeSegment(segment);
		}
	}
	
	public void eventVueJeu(MouseEvent event) {
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
			double x = event.getX();
			double y = event.getY();
			if (event.isShiftDown()) {
				if (60 > Math.abs(premierPoint.getX() - x)) {
					x = premierPoint.getX();
				} else if (60 > Math.abs(premierPoint.getY() - y)) {
					y = premierPoint.getY();
				}
			}
			if (event.isAltDown()) {
				x = premierPoint.getX() + (x - premierPoint.getX()) * 120 / Math.sqrt(Math.pow(x - premierPoint.getX(), 2) + Math.pow(y - premierPoint.getY(), 2));
				y = premierPoint.getY() + (y - premierPoint.getY()) * 120 / Math.sqrt(Math.pow(x - premierPoint.getX(), 2) + Math.pow(y - premierPoint.getY(), 2));
			}
			if (!event.isControlDown()) {
				addPointSegment(x, y);
			}
			premierPoint = modele.getPoint(modele.getSizePoints() - 1);
		} else {
			premierPoint = null;
		}
	}
}
