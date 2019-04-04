package vue;

import java.util.HashMap;
import java.util.Map;

import controleur.Controleur;
import controleur.ControleurRegles;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modele.Modele;
import modele.MutableBoolean;

public class VueCreationRegle extends VueRetour {

	protected BorderPane main;
	protected SplitPane pointEtSegment;
	protected BorderPane point;
	protected VBox VBoxPoint;
	protected GridPane segment;
	protected GridPane bottom;
	protected TextField nomRegleField;

	protected Map<CheckBox, MutableBoolean> reglesChoisis;

	public VueCreationRegle(Modele m) {
		super(m);
		point = creerBorderPane(true);
		VBoxPoint = creerVBox(Pos.CENTER_LEFT);
		VBoxPoint.setStyle("-fx-padding: 10;");
		reglesChoisis = new HashMap<>();
		ajoutCheckBox(creerCheckBoxUnderline("Point Coloriable"), modele.getRegleCourant().Coloriable);
		ajoutCheckBox(creerCheckBox("A Cote De Soit"), modele.getRegleCourant().JouerAcoteSoit);
		ajoutCheckBox(creerCheckBox("A Cote D'un Ennemi"), modele.getRegleCourant().JouerAcoteEnnemi);
		ajoutCheckBox(creerCheckBox("Sur Un Ennemi"), modele.getRegleCourant().JouerSurEnnemi);
		ajoutCheckBox(creerCheckBoxUnderline("Point Deplacable"), modele.getRegleCourant().DeplacementAutorise);
		//reglesChoisis.put(creerCheckBox("colorier point entourer par nos points"), modele.getRegleCourant().);
		main = new BorderPane();
		pointEtSegment = new SplitPane();
		segment = creerGridPane(Pos.CENTER_LEFT, true);
		bottom = creerGridPane(Pos.CENTER, true);
		nomRegleField = creerZoneText("Nom de la règle", 40.);
		bottom.add(retour, 0, 0);
		bottom.add(nomRegleField, 1,0);
		bottom.add(sauvegarder, 2, 0);		
		pointEtSegment.setOrientation(Orientation.HORIZONTAL);
		point.setLeft(VBoxPoint);
		point.maxWidthProperty().bind(pointEtSegment.widthProperty().multiply(0.5));
		point.minWidthProperty().bind(pointEtSegment.widthProperty().multiply(0.5));
		pointEtSegment.getItems().addAll(point, segment);
		main.setCenter(pointEtSegment);
		main.setBottom(bottom);
		root.setCenter(main);
	}
	
	public void ajoutCheckBox(CheckBox c, MutableBoolean b) {
		reglesChoisis.put(c, b);
		VBoxPoint.getChildren().add(c);
	}

	@Override
	public Button creerBouton(String nom) {
		Button b = super.creerBouton(nom);
		b.setPrefWidth(150.);
		b.setPrefHeight(40.);
		return b;
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
	
	public Map<CheckBox, MutableBoolean> getReglesChoisis() {
		return reglesChoisis;
	}
}
