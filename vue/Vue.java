package vue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import controleur.Controleur;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
		root.setStyle("-fx-padding: 10;");
		primaryStage.setScene(scene);
		primaryStage.setTitle("Vue Generale");
		primaryStage.setMaximized(true);
		primaryStage.show();
		this.controleur = creationControleur();
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
}
