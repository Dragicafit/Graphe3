package vue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import controleur.Controleur;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import modele.Modele;

public abstract class Vue extends Stage{

	protected Modele modele;
	protected Controleur controleur;
	protected ArrayList<Circle> cercles;
	protected ArrayList<Line> lignes;
	protected Map<Button, String> boutons;
	protected BorderPane root;
	protected Scene scene;

	public Vue(Modele m) {
		root = new BorderPane();
		scene = new Scene(root, 800, 600);
		modele = m;
		cercles = new ArrayList<Circle>();
		lignes = new ArrayList<Line>();
		boutons = new HashMap<>();
		this.controleur = creationControleur();
		creationBouton();
		root.setStyle("-fx-padding: 10;");
		this.setScene(scene);
		this.setTitle("Vue Générale");
		this.setMaximized(true);
		this.show();
	}

	public abstract void creationBouton();

	public Button creerBouton(String nom) {
		Button b = new Button(nom);
		b.setAlignment(Pos.CENTER);
		b.addEventHandler(MouseEvent.MOUSE_CLICKED, controleur);
		return b;
	}

	public Button creerBouton(String nomPoint, String nomImage) {
		return creerBouton(nomPoint, nomImage, 30, 30);
	}

	public Button creerBouton(String nomPoint, String nomImage, int height, int width) {

		Image image = new Image("images/" + nomImage);
		ImageView view = new ImageView(image);
		view.setFitHeight(height);
		view.setFitWidth(width);
		Button b = new Button(nomPoint, view);
		b.setMaxWidth(Double.MAX_VALUE);
		b.setAlignment(Pos.TOP_CENTER);
		b.addEventHandler(MouseEvent.MOUSE_CLICKED, controleur);
		return b;
	}
	
	public TextField creerZoneText (String nom, Double taille) {
		TextField zone = new TextField();
		zone.setPromptText(nom);
		zone.setPrefHeight(taille);
		zone.setFocusTraversable(false);
		return zone;
	}
	
	public TextField creerZoneText (String nom) {
		TextField zone = new TextField();
		zone.setPromptText(nom);
		zone.setFocusTraversable(false);
		return zone;
	}
	
	public CheckBox creerCheckBox (String nom) {
		CheckBox c = new CheckBox(nom);
		return c;
	}
	
	public CheckBox creerCheckBox (String nom, boolean underline) {
		CheckBox c = creerCheckBox(nom);
		c.setUnderline(underline);
		return c;
	}
	
	public ScrollPane creerScrollPane() {
		ScrollPane scroll = new ScrollPane();
		scroll.setFitToWidth(true);
		scroll.setFitToHeight(true);
		scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
		return scroll;
	}
	
	public GridPane creerGridPane(Pos p, boolean Border) {
		GridPane grid = new GridPane();
		grid.setAlignment(p);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(10, 10, 10, 10));
		if(Border) {
		grid.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		}else {
			grid.setStyle("-fx-padding: 10;");
		}
		return grid;
	}
	
	public TilePane creerTilePane(Pos p, boolean Border) {
		TilePane tile = new TilePane();
		tile.setAlignment(p);
		tile.setHgap(10);
		tile.setVgap(10);
		if(Border) {
			tile.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		}else {
			tile.setStyle("-fx-padding: 10;");
		}
		return tile;
	}	
	
	public BorderPane creerBorderPane(boolean Border) {
		BorderPane pane = new BorderPane();
		if(Border) pane.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;" + "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		return pane;
	}

	public abstract void update();

	public abstract Controleur creationControleur();

	public Modele getModele() {
		return modele;
	}

	public ArrayList<Circle> getCercles() {
		return cercles;
	}

	public ArrayList<Line> getLignes() {
		return lignes;
	}

	public String getBoutons(Button b) {
		return boutons.get(b);
	}

	public Map<Button, String> getBoutons() {
		return boutons;
	}

	public Controleur getControleur() {
		return controleur;
	}
}
