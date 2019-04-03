package controleur;

import javafx.scene.input.InputEvent;
import vue.Vue;
import vue.VueCreationGraphe;
import vue.VueCreationRegle;

public class ControleurAccueil extends Controleur {

	public ControleurAccueil(Vue vue) {
		super(vue);
		boutons.put("regles", Bouton.CREERREGLE);
		boutons.put("aleatoire", Bouton.ALEATOIRE);
		boutons.put("graphe", Bouton.CREERGRAPHE);
	}

	@Override
	public void handle(InputEvent event) {
		super.handle(event);
		if (bouton == Bouton.ALEATOIRE) {
			new VueCreationGraphe(modele);
			exit();
		} else if (bouton == Bouton.CREERGRAPHE) {
			new VueCreationGraphe(modele);
			exit();
		} else if (bouton == Bouton.CREERREGLE) {
			new VueCreationRegle(modele);
			exit();
		}
	}
}
