package vue;

import controleur.Controleur;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import modele.Couleur;
import modele.Modele;

public class VueJoueur extends Vue {
	protected TextField nomJoueur;
	protected Couleur couleur;
	protected Button valider;
	RadioButton rb1;
	RadioButton rb2;
	RadioButton rb3;
	private final ToggleGroup group = new ToggleGroup();

	public VueJoueur(Modele m) {
		super(m);
		BorderPane main = creerBorderPane(false);
		VBox box = creerVBox(Pos.CENTER);
		HBox boxCouleur = new HBox();
		couleur = new Couleur(0, 0, 0);
		rb1 = new RadioButton();
		rb2 = new RadioButton();
		rb3 = new RadioButton();
		rb1.setToggleGroup(group);
		rb2.setToggleGroup(group);
		rb3.setToggleGroup(group);
		box.setSpacing(40);
		boxCouleur.setSpacing(20);
		boxCouleur.setAlignment(Pos.CENTER);
		valider = new Button("Valider");
		valider.setStyle("-fx-font-size: 30px;");
		nomJoueur = creerZoneText("Nom du joueur");
		nomJoueur.setStyle("-fx-font-size: 20px;");
		nomJoueur.setAlignment(Pos.CENTER);
		nomJoueur.setMaxWidth(350);
		Rectangle r = new Rectangle(80, 40);
		r.setStrokeWidth(3);
		r.setStroke(Color.BLACK);
		r.setFill(Couleur.BLEU.toColor());
		ImageView i = creerImageView(r);
		rb1.setGraphic(i);
		r.setFill(Couleur.ROUGE.toColor());
		i = creerImageView(r);
		rb2.setGraphic(i);
		r.setFill(Couleur.VERT.toColor());
		i = creerImageView(r);
		rb3.setGraphic(i);
		boxCouleur.getChildren().addAll(rb1, rb2, rb3);
		box.getChildren().addAll(nomJoueur, boxCouleur, valider);
		main.setCenter(box);
		root.setCenter(main);
	}

	@Override
	public void update() {
		if(rb1.isSelected()) this.couleur = Couleur.BLEU;
		if(rb2.isSelected()) this.couleur = Couleur.ROUGE;
		if(rb3.isSelected()) this.couleur = Couleur.VERT;
	}

	@Override
	public Controleur creationControleur() {
		return null;
	}
}
