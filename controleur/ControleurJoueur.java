package controleur;

import java.util.Map;

import javafx.scene.input.InputEvent;
import modele.Bouton;
import modele.Joueur;
import modele.point.Point;
import modele.point.PointCouleur;
import vue.Vue;
import vue.VueJeu;
import vue.VueJoueur;
import vue.VueJoueur.CreerJoueur;

public class ControleurJoueur extends ControleurRetour {
	
	
	public ControleurJoueur(Vue vue) {
		super(vue);
	}
	
	@Override
	public void handle(InputEvent event) {
		super.handle(event);
		if (bouton == Bouton.VALIDER) {
			VueJoueur vueJoueur = (VueJoueur) vue;
			for (CreerJoueur joueur : vueJoueur.getJoueurs()) {
				modele.addJoueur(new Joueur(joueur.getNomJoueur().getText(), joueur.getCouleur()));
			}
			for (Map.Entry<String, Point> entry : modele.getGrapheCourant().getPointsSpeciaux().entrySet()) {
				for (int i = 0; i < modele.getNbJoueurs(); i++) {
					if(entry.getKey().startsWith("j" + i)) {
						((PointCouleur) entry.getValue()).setCouleur(modele.getJoueur(i).getCouleur());
					}
				}
			}
			exit();
			new VueJeu(modele);
		}
		vue.update();
	}
}
