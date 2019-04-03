package controleur;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.InputEvent;
import modele.Modele;
import vue.Vue;

public abstract class Controleur implements EventHandler<InputEvent> {

	protected Modele modele;
	protected Vue vue;
	protected Bouton bouton;
	protected Map<String, Bouton> boutons;

	public Controleur(Vue vue) {
		this.modele = vue.getModele();
		this.vue = vue;
		this.bouton = null;
		this.boutons = new HashMap<>();
	}

	public void handle(InputEvent event) {
		event.consume();
		Object source = event.getSource();
		if (source instanceof Button && vue.getBoutons().containsKey(source)) {
			if (bouton == boutons.get(vue.getBoutons((Button) source))) {
				bouton = null;
			} else {
				bouton = boutons.get(vue.getBoutons((Button) source));
			}
		}
	}
	
	public void exit() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				vue.close();
			}
		});
	}
}

enum Bouton {
	POINT, SEGMENT, SUPPRIMER, SUPPRIMERTOUT, RETOUR, SAUVEGARDER, CREERREGLE, CREERGRAPHE, ALEATOIRE
}
