package Jeux;

import javafx.scene.shape.Circle;
import modele.Joueur;
import regles.Regles;
import vue.Vue;
import modele.point.*;

public class Snort extends Jeux{
	
	private boolean mode_jeu; //True = ne pas jouer a coté ennemis, a coté de soit sinon
	
	public Snort(Regles r, boolean mode_jeu, Vue vue) {
		super("Snort", r, vue);
		this.mode_jeu = mode_jeu;
	}
	
	@Override
	public void tour(int nb) {
		Joueur j = m.getJoueur(nb);
		attente();
		Object source = event.getSource();
		if (source instanceof Circle && vue.getCercles().contains((Circle) source)) {
			Point point = m.getPoint(vue.getCercles().indexOf((Circle) source));
			if(check_regles(point)) {
				(ControleurJeu) vue.getControleur().applique(event);
			}
		}
	}
	
	

	@Override
	public boolean end_game() {
		boolean b = false;
		for(int i = 0; i< m.getSizePoints(); i++ ) {
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
