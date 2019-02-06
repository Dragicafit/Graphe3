package controleur;

import javax.swing.plaf.basic.BasicSliderUI.ComponentHandler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import modele.Modele;

public class Controleur implements EventHandler<ActionEvent> {
	protected Modele modele;
	protected Vue vue;
	protected Regles regle;
	protected boolean bouton1;
	protected boolean bouton2;
	protected boolean bouton3;
	protected boolean bouton4;
	protected boolean bouton5;
	
	public Controleur(Vue vue) {
		this.modele = vue.getModele();
		this.vue = vue;
		this.regle = new regle();
		this.bouton1 = false;
		this.bouton2 = false;
		this.bouton3 = false;
		this.bouton4 = false;
		this.bouton5 = false;
	}

	@Override
	public void handle(ActionEvent event) {
		Object source = event.getSource();
		if(vue.getCircles().contains((Circle)source)) {
			if(regle.check_regle_choisie()) {
			
			}
		}
		if(vue.getSegment().contains((Line)source)) {
			
		}
		if(vue.getPlateau().contains((Object)source)) { // Object à modifier
			
		}
		if(vue.getMenu().contains((Button)source)) {
			
		}
	}
}
