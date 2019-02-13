package controleur;

import javax.swing.plaf.basic.BasicSliderUI.ComponentHandler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import modele.Modele;
import modele.point.Point;
import modele.point.PointCouleur;

public class Controleur implements EventHandler<ActionEvent> {
	protected Modele modele;
	protected Vue vue;
	protected Regles regle;
	protected Joueurs joueur;
	protected boolean point;
	protected boolean segment;
	protected boolean undo;
	protected boolean redo;
	protected boolean supprimer;
	protected boolean colorier;
	protected boolean deplacer;
	
	public Controleur(Vue vue) {
		this.modele = vue.getModele();
		this.vue = vue;
		this.regle = new regle();
		this.point = false;
		this.segment = false;
		this.undo = false;
		this.redo = false;
		this.supprimer = false;
		this.colorier = false;
		this.deplacer = false;
	}

	@Override
	public void handle(ActionEvent event) {
		Object source = event.getSource();
		if(vue.getCircles().contains((Circle)source)) {
			if(regle.check_regle_choisie() && colorier) {
				(modele.getPoint(vue.indexOfCircle((Circle)source))).setCouleur(modele.getJoueur(modele.getJoueurCourant()).getCouleur());
			}
			if(supprimer) {
				modele.removePoint(vue.indexOfPoint((Circle)source)));
			}
		}
		if(vue.getLines().contains((Line)source)) {
			if(regle.check_regle_choisie() && colorier) {
				(modele.getSegment(vue.indexOfLine((Line)source))).setCouleur(modele.getJoueur(modele.getJoueurCourant()).getCouleur());
			}
			if(supprimer) {
				modele.removeLine(vue.indexOfSegment((Line)source)));
			}
		}
		if(vue.getPlateau().contains((Object)source)) { // Object à modifier
			if(point) {
				this.modele.addPoint(new Point(posX, posY));
			}
		}
		if(vue.getMenu().contains((Button)source)) {
			if(((Button)source).getText().equals("point")) {
				point = true;
			}
			if(((Button)source).getText().equals("segment")) {
				segment = true;
			}
			if(((Button)source).getText().equals("undo")) {
				undo = true;
			}
			if(((Button)source).getText().equals("redo")) {
				redo = true;
			}
			if(((Button)source).getText().equals("supprimer")) {
				supprimer = true;
			}
			if(((Button)source).getText().equals("supprimer tout")) {
				vue.setModele(new Modele());
				this.modele = vue.modele;
			}
			if(((Button)source).getText().equals("colorier")) {
				colorier = true;
			}
			if(((Button)source).getText().equals("deplacer")) {
				deplacer = true;
			}
		}
	}
}
