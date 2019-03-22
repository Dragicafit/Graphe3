package controleur;

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
		this.boutons.put("supprimerTout", Bouton.SUPPRIMERTOUT);
	}

	@Override
	public void handle(InputEvent event) {
		super.handle(event);
		event.consume();
		Object source = event.getSource();
		if (event instanceof DragEvent) {
			eventDrag((DragEvent) event, (Pane) source);
		} else if (event instanceof MouseEvent) {
			eventMouse((MouseEvent) event, source);
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
		this.modele.addSegment(new SegmentCouleur(p1, p2, Couleur.NOIR));
	}

	public void addPointSegment(double x, double y) {
		addPoint(x, y);
		addSegment(premierPoint, modele.getPoint(modele.getSizePoints() - 1));
	}

	public void eventCercle(MouseEvent event, Circle source) {
		Point point = modele.getPoint(vue.getCercles().indexOf(source));
		if (bouton == Bouton.SUPPRIMER) {
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
		} else if (bouton == Bouton.SUPPRIMER) {
			modele.removePoint(point);
		} else if (point instanceof PointCouleur) {
			PointCouleur p = (PointCouleur) point;
			Couleur c = p.getCouleur();
			if (c.equals(Couleur.BLANC))
				p.setCouleur(Couleur.BLEU);
			else if (c.equals(Couleur.BLEU))
				p.setCouleur(Couleur.ROUGE);
			else if (c.equals(Couleur.ROUGE))
				p.setCouleur(Couleur.BLANC);
		}
		premierPoint = point;
	}

	public void eventLine(MouseEvent event, Line source) {
		Segment segment = modele.getSegment(vue.getLignes().indexOf(source));
		if (segment instanceof SegmentCouleur) {
			((SegmentCouleur) segment).setCouleur(modele.getJoueur(modele.getJoueurCourant()).getCouleur());
		} else if (bouton == Bouton.SUPPRIMER) {
			modele.removeSegment(segment);
		}
	}

	public void eventPane(MouseEvent event) {
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

	public void eventDrag(DragEvent event, Pane source) {
		if (source instanceof Pane) {
			if (event.getEventType() == DragEvent.DRAG_OVER) {
				event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
				return;
			} else if (event.getEventType() == DragEvent.DRAG_DROPPED) {
				Circle cercle = (Circle) event.getGestureSource();
				Point p = modele.getPoint(vue.getCercles().indexOf(cercle));
				event.setDropCompleted(deplacerPoint(p, event.getX(), event.getY()));
			}
		}
	}

	public void eventMouse(MouseEvent event, Object source) {
		if (event.isDragDetect() && event.getEventType() == MouseEvent.DRAG_DETECTED) {
			if (source instanceof Circle && vue.getCercles().contains(source)) {
				Dragboard db = ((Circle) source).startDragAndDrop(TransferMode.ANY);
				ClipboardContent content = new ClipboardContent();
				content.putString("");
				db.setContent(content);
				return;
			}
		} else {
			if (source instanceof Circle && vue.getCercles().contains(source)) {
				eventCercle(event, (Circle) source);
			} else if (source instanceof Line && vue.getLignes().contains(source)) {
				eventLine(event, (Line) source);
			} else if (vue instanceof VueJeu && source instanceof Pane && source == ((VueJeu) vue).getGraphe()) {
				eventPane(event);
			}
		}
	}
}