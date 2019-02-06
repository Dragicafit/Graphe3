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
	
	public Controleur(Vue vue) {
		this.modele = vue.getModele();
		this.vue = vue;
	}

	@Override
	public void handle(ActionEvent event) {
		Object source = event.getSource();
		if(vue.getCircle().contains((Circle)source)) {
			
		}
		if(vue.getSegment().contains((Line)source)) {
			
		}
		if(vue.getPlateau().contains((Object)source)) { // Object à modifier
			
		}
		if(vue.getMenu().contains((Button)source)) {
			
		}
	}
}
