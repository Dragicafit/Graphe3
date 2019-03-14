package Jeux;

import controleur.ControleurJeu;
import javafx.scene.shape.Circle;
import modele.point.Point;
import modele.point.PointCouleur;
import modele.segment.SegmentCouleur;
import regles.Regles;
import vue.Vue;

public class Snort extends Jeux {

	private boolean mode_jeu; // True = ne pas jouer a coté ennemis, a coté de soit sinon

	public Snort(Regles r, boolean mode_jeu, Vue vue) {
		super("Snort", r, vue);
		this.mode_jeu = mode_jeu;
	}

	@Override
	public synchronized void tour(int nb) throws InterruptedException {
		wait();
		Object source = event.getSource();
		if (source instanceof Circle && vue.getCercles().contains((Circle) source)) {
			PointCouleur point = (PointCouleur) m.getPoint(vue.getCercles().indexOf((Circle) source));
			if (check_regles(point)) {
				applique(point);
			}
		}
	}

	@Override
	public boolean end_game() {
		for (int i = 0; i < m.getSizePoints(); i++) {
			PointCouleur p = (PointCouleur) m.getPoint(i);
			if (mode_jeu && regles.check_cote_ennemi(p)) {
				return false;
			} else if (!mode_jeu && regles.check_cote_soit(p)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean check_regles(Point p) {
		if (mode_jeu && !regles.check_cote_ennemi(p)) {
			return true;
		} else if (!mode_jeu && regles.check_cote_soit((PointCouleur) p)) {
			return true;
		}
		return false;
	}

	public void applique(Object o) {
		ControleurJeu c = (ControleurJeu) vue.getControleur();
		if (o instanceof PointCouleur) {
			c.applique((PointCouleur) o);
		} else if (o instanceof SegmentCouleur) {
			c.applique((SegmentCouleur) o);
		}
	}
}
