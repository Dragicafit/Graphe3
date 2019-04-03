package controleur;

import javafx.scene.input.InputEvent;
import modele.graphe.ModeleGraphe;
import modele.regle.ModeleRegle;
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
			modele.setGrapheCourant(new ModeleGraphe());
			new VueCreationGraphe(modele);
			exit();
		} else if (bouton == Bouton.CREERREGLE) {
			modele.setRegleCourant(new ModeleRegle());
			new VueCreationRegle(modele);
			exit();
		}
	}
}
