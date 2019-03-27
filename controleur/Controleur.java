package controleur;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Platform;
import javafx.event.EventHandler;
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
	}
	
	public void exit() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				vue.getPrimaryStage().close();
			}
		});
	}
}

enum Bouton {
	POINT, SEGMENT, SUPPRIMER, SUPPRIMERTOUT, RETOUR, SAUVEGARDER, CREERREGLE, CREERGRAPHE, ALEATOIRE
}
