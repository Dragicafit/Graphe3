package vue;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import modele.Modele;

public class VuePlateauJeu extends VueJeu {

	public Button colorier;
	public Button deplacer;
	public Text nomJoueur;
	public VBox menuJeu;

	public VuePlateauJeu(Modele m) {
		super(m);
		creationBouton();
		majListe();
		super.primaryStage.setTitle("Lets GO !!!");
		menuJeu = new VBox();
		menuJeu.getChildren().addAll(this.nomJoueur, this.colorier, this.deplacer);
		menuJeu.setSpacing(20);
		menuJeu.setStyle("-fx-padding: 10;");
		menu.setCenter(menuJeu);
	}

	public void creationBouton() {
		this.colorier = new Button("Colorier");
		this.colorier.setMaxWidth(Double.MAX_VALUE);
		this.deplacer = new Button("Déplacer");
		this.deplacer.setMaxWidth(Double.MAX_VALUE);
		this.nomJoueur = new Text();
		this.nomJoueur.setText("   Inserer le nom  \n     du joueur !!!");
	}

}
