package Jeux;

import controleur.ControleurJeu;
import javafx.scene.shape.Circle;
import modele.point.PointCouleur;
import modele.segment.SegmentCouleur;
import regles.Regles;
import vue.Vue;

public class Snort extends Jeux {
	
	public Snort(Regles r, Vue vue) {
		super("Snort", r, vue);
	}

	@Override
	public boolean end_game() {
		for (int i = 0; i < m.getSizePoints(); i++) {
			PointCouleur p = (PointCouleur) m.getPoint(i);
			if (!regles.jouerAcoteEnnemi(p)) {
					return false;
			}
		}
		return true;
	}
	
	@Override
	public void applique(Object o) {
		ControleurJeu c = (ControleurJeu) vue.getControleur();
		if (o instanceof PointCouleur) {
			c.applique((PointCouleur) o);
		} else if (o instanceof SegmentCouleur) {
			c.applique((SegmentCouleur) o);
		} else if (o instanceof Circle) {
			c.appliqueDep((Circle) o);
		}
	}

	@Override
	public boolean deplacementAvailable() {
		return false;
	}
}
