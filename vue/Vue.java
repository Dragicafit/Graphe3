package vue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import controleur.Controleur;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import modele.Modele;

public abstract class Vue {

	protected Modele modele;
	protected Controleur controleur;
	protected ArrayList<Circle> cercles;
	protected ArrayList<Line> lignes;
	protected Map<Button, String> boutons;
	protected Stage primaryStage = new Stage();
	protected BorderPane root = new BorderPane();
	protected Scene scene = new Scene(root, 800, 600);

	public Vue(Modele m) {
		modele = m;
		cercles = new ArrayList<Circle>();
		lignes = new ArrayList<Line>();
		boutons = new HashMap<>();
		this.controleur = creationControleur();
		creationBouton();
		root.setStyle("-fx-padding: 10;");
		primaryStage.setScene(scene);
		primaryStage.setTitle("Vue Generale");
		primaryStage.setMaximized(true);
		primaryStage.show();
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
