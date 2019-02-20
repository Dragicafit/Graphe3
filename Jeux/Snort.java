package Jeux;

import modele.Modele;
import regles.Regles;
import modele.point.*;

public class Snort extends Jeux{
	
	private boolean mode_jeu; //True = ne pas jouer a coté ennemis, a coté de soit sinon
	
	public Snort(Regles r, boolean mode_jeu, Modele m, Vue vue) {
		super("Snort", r, m, vue);
		this.mode_jeu = mode_jeu;
	}

	@Override
	public void Jeu() {
		while(!end_game()) {
			int j = m.getJoueurCourant();
			tour(j);
		}
		
	}
	
	public void tour(int nb) {
		
	}

	@Override
	public boolean end_game() {
		boolean b = false;
		for(int i = 0; i< 4/*m.getSize_points()*/; i++ ) {
			Point p = m.getPoint(i);
			if(mode_jeu && !regles.check_cote_ennemi(p)) {
					b = true;
			}else if(!regles.check_cote_soit(p)) {
					b = true;
			}
		}
		return b;
	}

	@Override
	public boolean check_regles(Point p) {
		if(mode_jeu && !regles.check_cote_ennemi(p)) {
			return true;
		}else if(!mode_jeu && !regles.check_cote_soit(p)) {
			return true;
		}
		return false;
	}
	
}
