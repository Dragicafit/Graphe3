package controleur;

import javafx.scene.input.MouseEvent;
import vue.Vue;

public class ControleurCreationRegle extends Controleur{

	public ControleurCreationRegle(Vue vue) {
		super(vue);
		this.boutons.put("sauvegarder", Bouton.SAUVEGARDER);
		this.boutons.put("retour", Bouton.RETOUR);
	}

	@Override
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub
	}
}
