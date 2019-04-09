package vue;

import controleur.Controleur;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import modele.Modele;

public class VueGagnant extends Vue{
	
	protected Button Relancer;
	protected Button Retour;

	public VueGagnant(Modele m) {
		super(m);
		BorderPane main = creerBorderPane(false);
		VBox box = creerVBox(Pos.CENTER, 40);
		HBox hbox = new HBox();
		hbox.setSpacing(40);
		hbox.setAlignment(Pos.CENTER);
		Text finJeu = new Text("BRAVO A (ajouter nom joueur)");//Text finJeu = new Text("BRAVO A " + m.getJoueur(m.getJoueurCourant()).getNom());
		finJeu.setStyle("-fx-font-size: 80px;");
		Relancer = new Button("Revanche !!!");
		Relancer.setStyle("-fx-font-size: 40px;");
		Retour = new Button("--> Accueil");
		Retour.setStyle("-fx-font-size: 40px;");
		hbox.getChildren().addAll(Relancer, Retour);
		box.getChildren().addAll(finJeu, hbox);
		main.setCenter(box);
		root.setCenter(main);
	}

	@Override
	public void update() {
		
	}

	@Override
	public Controleur creationControleur() {
		return null;
	}

}
