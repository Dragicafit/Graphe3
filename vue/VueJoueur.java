package vue;

import java.util.ArrayList;

import controleur.Controleur;
import controleur.ControleurJoueur;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import modele.Bouton;
import modele.Couleur;
import modele.Modele;

public class VueJoueur extends Vue {

	private ArrayList<CreerJoueur> joueurs;

	public VueJoueur(Modele m, int nb) {
		super(m);
		joueurs = new ArrayList<>();
		VBox main = creerVBox(Pos.CENTER);
		TilePane tilePane = creerTilePane(Pos.TOP_CENTER, false);
		Button valider = creerBouton("Valider");
		boutons.put(valider, Bouton.VALIDER);
		valider.setStyle("-fx-font-size: 30px;");
		for (int i = 0; i < nb; i++) {
			joueurs.add(new CreerJoueur());
		}
		tilePane.getChildren().addAll(joueurs);
		main.getChildren().addAll(tilePane, valider);
		root.setCenter(main);
	}
	
	public class CreerJoueur extends VBox {
		private TextField nomJoueur;
		private Slider rouge;
		private Slider vert;
		private Slider bleu;
		private Rectangle r;
		
		public CreerJoueur() {
			this.setAlignment(Pos.CENTER);
			this.setSpacing(40);
			HBox boxCouleur = new HBox();
			boxCouleur.setSpacing(20);
			boxCouleur.setAlignment(Pos.CENTER);
			rouge = creerSlider();
			vert = creerSlider();
			bleu = creerSlider();
			boxCouleur.getChildren().addAll(rouge, vert, bleu);
			r = new Rectangle(80, 40);
			r.setStrokeWidth(3);
			r.setStroke(Color.BLACK);
			r.setFill(Color.BLACK);
			nomJoueur = creerZoneText("Nom du joueur");
			nomJoueur.setStyle("-fx-font-size: 20px;");
			nomJoueur.setAlignment(Pos.CENTER);
			nomJoueur.setMaxWidth(350);
			this.getChildren().addAll(nomJoueur, r, boxCouleur);
		}
		
		public TextField getNomJoueur() {
			return nomJoueur;
		}
		
		public Couleur getCouleur() {
			return new Couleur(rouge.getValue()/255, vert.getValue()/255, bleu.getValue()/255);
		}
	}

	@Override
	public void update() {
		for (CreerJoueur joueur : joueurs) {
			joueur.r.setFill(joueur.getCouleur().toColor());
		}
	}
	
	@Override
	public Controleur creationControleur() {
		return new ControleurJoueur(this);
	}

	public ArrayList<CreerJoueur> getJoueurs() {
		return joueurs;
	}
}
