package controleur;

import java.util.HashMap;
import java.util.Map;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modele.Modele;
import vue.Vue;

public abstract class Controleur implements EventHandler<MouseEvent> {

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

	public abstract void handle(MouseEvent event);
}

enum Bouton {
	POINT, SEGMENT, SUPPRIMER, COLORIER, DEPLACER, SUPPRIMERTOUT, RETOUR, SAUVEGARDER
}
