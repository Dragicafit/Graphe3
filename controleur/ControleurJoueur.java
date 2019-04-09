package controleur;

import javafx.scene.input.InputEvent;
import modele.Bouton;
import modele.Joueur;
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
			exit();
			new VueJeu(modele);
		}
		vue.update();
	}
}
