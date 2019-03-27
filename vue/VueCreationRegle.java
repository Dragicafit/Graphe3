package vue;

import controleur.Controleur;
import controleur.ControleurRegles;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import modele.Modele;

public class VueCreationRegle extends VueRetour {


	protected BorderPane main;
	protected SplitPane pointEtSegment;
	protected GridPane point;
	protected GridPane segment;
	protected GridPane bottom;
	protected TextField nomRegleField;
	protected CheckBox pointColoriable;
	protected CheckBox pointDeplacable;
	protected CheckBox aCoteDeSoit;
	protected CheckBox aCoteDennemi;
	protected CheckBox surEnnemi;
	protected CheckBox allAround;


	public VueCreationRegle(Modele m) {
		super(m);
		pointColoriable = creerCheckBox("Point Coloriable");
		pointColoriable.setUnderline(true);
		pointDeplacable = creerCheckBox("Point Deplacable");
		pointDeplacable.setUnderline(true);
		aCoteDeSoit = creerCheckBox("A Cote De Soit");
		aCoteDennemi= creerCheckBox("A Cote D'un Ennemi");
		surEnnemi = creerCheckBox("Sur Un Ennemi");
		allAround = creerCheckBox("colorier point entourer par nos points");
		main = new BorderPane();
		pointEtSegment = new SplitPane();
		point = creerGridPane(Pos.CENTER_LEFT, true);
		point.add(pointColoriable, 0, 0);
		point.add(pointDeplacable, 0, 5);
		point.add(aCoteDeSoit, 1, 1);
		point.add(aCoteDennemi, 1, 2);
		point.add(surEnnemi, 1, 3);
		point.add(allAround, 1, 4);
		segment = creerGridPane(Pos.CENTER_LEFT, true);
		bottom = creerGridPane(Pos.CENTER, true);
		nomRegleField = creerZoneText("Nom de la règle", 40.);
		bottom.add(retour, 0, 0);
		bottom.add(nomRegleField, 1,0);
		bottom.add(sauvegarder, 2, 0);		
		pointEtSegment.setOrientation(Orientation.HORIZONTAL);
		point.maxWidthProperty().bind(pointEtSegment.widthProperty().multiply(0.5));
		point.minWidthProperty().bind(pointEtSegment.widthProperty().multiply(0.5));
		pointEtSegment.getItems().addAll(point, segment);
		main.setCenter(pointEtSegment);
		main.setBottom(bottom);
		root.setCenter(main);
	}

	@Override
	public Button creerBouton(String nom) {
		Button b = super.creerBouton(nom);
		b.setPrefWidth(150.);
		b.setPrefHeight(40.);
		return b;
	}

	public CheckBox creerCheckBox (String nom) {
		CheckBox c = new CheckBox(nom);
		return c;
	}

	@Override
	public void update() {

	}

	@Override
	public Controleur creationControleur() {
		return new ControleurRegles(this);
	}

	public TextField getNomRegleField() {
		return nomRegleField;
	}	
}
