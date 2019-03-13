package vue;

import controleur.Controleur;
import controleur.ControleurAccueil;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import modele.Modele;

public class VueAccueil extends Vue {

	public SplitPane main;

	public BorderPane Regles;
	public SplitPane RegleCenter;
	public BorderPane RegleCenterTop;
	public BorderPane RegleCenterTopTop;
	public BorderPane RegleCenterTopBottom;
	public BorderPane RegleCenterBottom;
	public BorderPane RegleCenterBottomTop;
	public BorderPane RegleCenterBottomBottom;
	public BorderPane RegleBottom;

	public BorderPane Graphes;
	public SplitPane GrapheCenter;
	public BorderPane GrapheCenterTop;
	public BorderPane GrapheCenterTopTop;
	public BorderPane GrapheCenterTopBottom;
	public BorderPane GrapheCenterBottom;
	public BorderPane GrapheCenterBottomTop;
	public BorderPane GrapheCenterBottomBottom;
	public GridPane GrapheBottom;

	public Button creerGraphe;
	public Button aleatoireGraphe;
	public Button creerRegle;

	public VueAccueil(Modele m) {
		super(m);
		main = new SplitPane();

		Regles = creerBorderPane(false);
		Regles.setPrefSize((root.getWidth() - 30) / 2, root.getHeight());
		RegleCenter = new SplitPane();
		RegleCenterTop = creerBorderPane(true);
		RegleCenterTopTop = creerBorderPane(false);
		RegleCenterTopBottom = creerBorderPane(false);
		RegleCenterBottom = creerBorderPane(true);
		RegleCenterBottomTop = creerBorderPane(false);
		RegleCenterBottomBottom = creerBorderPane(false);
		RegleBottom = creerBorderPane(false);

		Graphes = creerBorderPane(false);
		Graphes.setPrefSize((root.getWidth() - 30) / 2, root.getHeight());
		GrapheCenter = new SplitPane();
		GrapheCenterTop = creerBorderPane(true);
		GrapheCenterTopTop = creerBorderPane(false);
		GrapheCenterTopBottom = creerBorderPane(false);
		GrapheCenterBottom = creerBorderPane(true);
		GrapheCenterBottomTop = creerBorderPane(false);
		GrapheCenterBottomBottom = creerBorderPane(false);
		GrapheBottom = creerGridPane(Pos.CENTER, false);
	
		RegleBottom.setStyle("-fx-padding: 10;");

		Text RP = new Text("Règles Prédéfinies");
		Text RM = new Text("Mes Règles");
		RP.setStyle("-fx-font-size: 20px;");
		RM.setStyle("-fx-font-size: 20px;");
		RegleCenterTopTop.setCenter(RP);
		RegleCenterBottomTop.setCenter(RM);

		Text GP = new Text("Graphes Prédéfinis");
		Text GM = new Text("Mes Graphes");
		GP.setStyle("-fx-font-size: 20px;");
		GM.setStyle("-fx-font-size: 20px;");
		GrapheCenterTopTop.setCenter(GP);
		GrapheCenterBottomTop.setCenter(GM);

		GrapheBottom.add(creerGraphe, 0, 0);
		GrapheBottom.add(aleatoireGraphe, 1, 0);
		RegleBottom.setCenter(creerRegle);

		Regles.setCenter(RegleCenter);
		RegleCenter.setOrientation(Orientation.VERTICAL);
		RegleCenter.getItems().addAll(RegleCenterTop, RegleCenterBottom);
		RegleCenterTop.setTop(RegleCenterTopTop);
		RegleCenterTop.setCenter(RegleCenterTopBottom);
		RegleCenterBottom.setTop(RegleCenterBottomTop);
		RegleCenterBottom.setCenter(RegleCenterBottomBottom);
		Regles.setBottom(RegleBottom);

		Graphes.setCenter(GrapheCenter);
		GrapheCenter.setOrientation(Orientation.VERTICAL);
		GrapheCenter.getItems().addAll(GrapheCenterTop, GrapheCenterBottom);
		GrapheCenterTop.setTop(GrapheCenterTopTop);
		GrapheCenterTop.setCenter(GrapheCenterTopBottom);
		GrapheCenterBottom.setTop(GrapheCenterBottomTop);
		GrapheCenterBottom.setCenter(GrapheCenterBottomBottom);
		Graphes.setBottom(GrapheBottom);

		root.setCenter(main);
		main.setOrientation(Orientation.HORIZONTAL);
		Graphes.minWidthProperty().bind(main.widthProperty().multiply(0.25));
		Regles.minWidthProperty().bind(main.widthProperty().multiply(0.25));
		main.getItems().addAll(Graphes, Regles);
	}

	@Override
	public void update() {

	}

	@Override
	public Controleur creationControleur() {
		return new ControleurAccueil(this);
	}
	
	@Override
	public Button creerBouton(String nom) {
		Button b = super.creerBouton(nom);
		b.setPrefWidth(150.);
		b.setPrefHeight(40.);
		return b;
	}

	@Override
	public void creationBouton() {
		creerGraphe = creerBouton("Créer Graphes");
		aleatoireGraphe = creerBouton("Graphes Aléatoire");
		creerRegle = creerBouton("Créer Règles");
	}
}
