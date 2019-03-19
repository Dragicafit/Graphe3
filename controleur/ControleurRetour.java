package controleur;

import java.io.IOException;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import vue.Vue;
import vue.VueAccueil;

public abstract class ControleurRetour extends Controleur {
	
	public ControleurRetour(Vue vue) {
		super(vue);
		this.boutons.put("sauvegarder", Bouton.SAUVEGARDER);
		this.boutons.put("retour", Bouton.RETOUR);
	}

	@Override
	public void handle(MouseEvent event) {
		Object source = event.getSource();
		if (source instanceof Button && vue.getBoutons().containsKey(source)) {
			bouton = boutons.get(vue.getBoutons((Button) source));
			if (bouton == Bouton.SAUVEGARDER) {
				try {
					modele.exportModele();
				} catch (IOException e) {
					System.out.println("Impossible de sauvegarder le jeu en cours");
				}
			} else if (bouton == Bouton.RETOUR) {
				exit();
				new VueAccueil(modele);
			}
		}
	}
}
