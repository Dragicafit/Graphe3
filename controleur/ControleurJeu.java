package controleur;

import Jeux.Jeux;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import modele.point.Point;
import modele.point.PointCouleur;
import modele.segment.SegmentCouleur;
import vue.Vue;

public class ControleurJeu extends ControleurRetour {

	protected Jeux jeu;
	private Object action;

	public ControleurJeu(Vue vue) {
		super(vue);
		this.jeu = new Jeux(vue);
		jeu.start();
	}

	public synchronized void setApplique(Object action) {
		this.action = action;
		notify();
	}

	public void applique(PointCouleur p) {
		p.setCouleur(modele.getJoueur(modele.getJoueurCourant()).getCouleur());
		modele.setJoueurCourant((modele.getJoueurCourant() + 1) % modele.getNbJoueurs());
		vue.update();
	}

	public void applique(PointCouleur p, double x, double y) {
		p.setX(x);
		p.setY(y);
		modele.setJoueurCourant((modele.getJoueurCourant() + 1) % modele.getNbJoueurs());
		vue.update();
	}

	public void applique(SegmentCouleur s) {
		s.setCouleur(modele.getJoueur(modele.getJoueurCourant()).getCouleur());
		modele.setJoueurCourant((modele.getJoueurCourant() + 1) % modele.getNbJoueurs());
		vue.update();
	}

	public void appliqueDep(Circle cercle) {
		Dragboard db = cercle.startDragAndDrop(TransferMode.ANY);
		ClipboardContent content = new ClipboardContent();
		content.putString("");
		db.setContent(content);
	}

	@Override
	public synchronized void handle(InputEvent event) {
		super.handle(event);
		Object source = event.getSource();
		if (event instanceof DragEvent) {
			eventDrag((DragEvent) event, (Pane) source);
		} else if (event instanceof MouseEvent) {
			eventMouse((MouseEvent) event, source);
		}
		event.consume();
	}

	@Override
	public synchronized void exit() {
		jeu.interrupt();
		notifyAll();
		super.exit();
	}

	public void eventDrag(DragEvent event, Pane source) {
		if (source instanceof Pane) {
			if (event.getEventType() == DragEvent.DRAG_OVER) {
				event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
			} else if (event.getEventType() == DragEvent.DRAG_DROPPED) {
				Circle cercle = (Circle) event.getGestureSource();
				Point p = modele.getPoint(vue.getCercles().indexOf(cercle));
				event.setDropCompleted(deplacerPoint(p, event.getX(), event.getY()));
				vue.update();
			}
		}
	}

	public void eventMouse(MouseEvent event, Object source) {
		action = null;
		jeu.setEvent(event);
		try {
			wait();
			if (action != null) {
				jeu.applique(action);
			}
		} catch (InterruptedException e) {
		}
	}

	public boolean deplacerPoint(Point p, double x, double y) {
		for (int i = 0; i < modele.getSizePoints(); i++) {
			if (Math.sqrt(
					Math.pow(modele.getPoint(i).getX() - x, 2) + Math.pow(modele.getPoint(i).getY() - y, 2)) < 15) {
				return false;
			}
		}
		p.setX(x);
		p.setY(y);
		return true;
	}
}
