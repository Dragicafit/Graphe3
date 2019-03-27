package Jeux;

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
			if (!regles.jouerAcoteEnnemi(p) && regles.jouerAcoteEnnemi(p)) {
				return false;
			}
		}
		return true;
	}

}
