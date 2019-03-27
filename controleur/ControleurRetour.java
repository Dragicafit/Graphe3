package controleur;

import javafx.scene.control.Button;
import javafx.scene.input.InputEvent;
import vue.Vue;
import vue.VueAccueil;
import vue.VueCreationGraphe;
import vue.VueCreationRegle;

public abstract class ControleurRetour extends Controleur {
	
	public ControleurRetour(Vue vue) {
		super(vue);
		this.boutons.put("sauvegarder", Bouton.SAUVEGARDER);
		this.boutons.put("retour", Bouton.RETOUR);
	}

	@Override
	public void handle(InputEvent event) {
		super.handle(event);
		Object source = event.getSource();
		if (source instanceof Button && vue.getBoutons().containsKey(source)) {
			bouton = boutons.get(vue.getBoutons((Button) source));
			if (bouton == Bouton.SAUVEGARDER) {
				if (vue instanceof VueCreationGraphe) {
					VueCreationGraphe vueGraphe = (VueCreationGraphe) vue;
					String nomGraphe = vueGraphe.getNomGraphe().getText();
					if (!nomGraphe.isEmpty()) {
						modele.getGrapheCourant().setNom(nomGraphe);
						modele.getGraphesLocal().add(modele.getGrapheCourant());
					}
				} else if (vue instanceof VueCreationRegle) {
					VueCreationRegle vueRegles = (VueCreationRegle) vue;
					String nomRegle = vueRegles.getNomRegleField().getText();
					if (!nomRegle.isEmpty()) {
						modele.getRegleCourant().setNom(nomRegle);
						modele.getReglesLocal().add(modele.getRegleCourant());
					}
				}
			} else if (bouton == Bouton.RETOUR) {
				exit();
				new VueAccueil(modele);
			}
		}
	}
}
