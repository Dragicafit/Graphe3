package controleur;

import java.io.IOException;

import javafx.scene.input.InputEvent;
import vue.Vue;
import vue.VueAccueil;
import vue.VueCreationGraphe;
import vue.VueCreationRegle;
import vue.VueJeu;

public abstract class ControleurRetour extends Controleur {

	public ControleurRetour(Vue vue) {
		super(vue);
		this.boutons.put("sauvegarder", Bouton.SAUVEGARDER);
		this.boutons.put("retour", Bouton.RETOUR);
	}

	@Override
	public void handle(InputEvent event) {
		super.handle(event);
		if (bouton == Bouton.SAUVEGARDER) {
			if (vue instanceof VueCreationGraphe) {
				VueCreationGraphe vueGraphe = (VueCreationGraphe) vue;
				String nomGraphe = vueGraphe.getNomGraphe().getText();
				if (!nomGraphe.isEmpty()) {
					modele.getGrapheCourant().setNom(nomGraphe);
					modele.sauvegardeGraphe();
				}
			} else if (vue instanceof VueCreationRegle) {
				VueCreationRegle vueRegles = (VueCreationRegle) vue;
				String nomRegle = vueRegles.getNomRegleField().getText();
				if (!nomRegle.isEmpty()) {
					modele.getRegleCourant().setNom(nomRegle);
					modele.sauvegardeRegle();
				}
			} else if (vue instanceof VueJeu) {
				try {
					modele.exportModele();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			bouton = null;
		} else if (bouton == Bouton.RETOUR) {
			exit();
			new VueAccueil(modele);
		}
	}
}
