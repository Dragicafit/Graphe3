package Jeux;

import modele.point.Point;
import modele.point.PointCouleur;
import regles.Regles;
import vue.Vue;

public class Col extends Snort{

	public Col(Regles r, Vue vue) {
		super(r, vue);
	}
	
	@Override
	public boolean end_game() {
		for (int i = 0; i < m.getSizePoints(); i++) {
			PointCouleur p = (PointCouleur) m.getPoint(i);
			if (!regles.check_cote_soit(p) && regles.check_cote_ennemi(p)) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public boolean check_regles(Point p) {
		if (!regles.check_cote_soit((PointCouleur) p) && regles.estBlanc((PointCouleur)p)) {
			return true;
		}
		return false;
	}

}
