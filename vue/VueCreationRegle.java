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
import modele.Modele;
import modele.MutableBoolean;

public class VueCreationRegle extends VueRetour {

	protected BorderPane main;
	protected SplitPane pointEtSegment;
	protected GridPane point;
	protected GridPane segment;
	protected GridPane bottom;
	protected TextField nomRegleField;

	protected Map<CheckBox, MutableBoolean> reglesChoisis;

	public VueCreationRegle(Modele m) {
		super(m);
		reglesChoisis = new HashMap<>();
		reglesChoisis.put(creerCheckBox("Point Coloriable", true), modele.getRegleCourant().Coloriable);
		reglesChoisis.put(creerCheckBox("Point Deplacable", true), modele.getRegleCourant().DeplacementAutorise);
		reglesChoisis.put(creerCheckBox("A Cote De Soit"), modele.getRegleCourant().JouerAcoteSoit);
		reglesChoisis.put(creerCheckBox("A Cote D'un Ennemi"), modele.getRegleCourant().JouerAcoteEnnemi);
		reglesChoisis.put(creerCheckBox("Sur Un Ennemi"), modele.getRegleCourant().JouerSurEnnemi);
		//reglesChoisis.put(creerCheckBox("colorier point entourer par nos points"), modele.getRegleCourant().);
		main = new BorderPane();
		pointEtSegment = new SplitPane();
		point = creerGridPane(Pos.CENTER_LEFT, true);
		int x = 0;
		for (Map.Entry<CheckBox, MutableBoolean> entry : reglesChoisis.entrySet()) {
			point.add(entry.getKey(), 0, x);
			x++;
		}
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
