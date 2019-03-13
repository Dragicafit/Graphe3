package vue;

import controleur.Controleur;
import controleur.ControleurAccueil;
import javafx.geometry.Insets;
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

		Regles = new BorderPane();
		Regles.setPrefSize((root.getWidth() - 30) / 2, root.getHeight());
		RegleCenter = new SplitPane();
		RegleCenterTop = new BorderPane();
		RegleCenterTopTop = new BorderPane();
		RegleCenterTopBottom = new BorderPane();
		RegleCenterBottom = new BorderPane();
		RegleCenterBottomTop = new BorderPane();
		RegleCenterBottomBottom = new BorderPane();
		RegleBottom = new BorderPane();

		Graphes = new BorderPane();
		Graphes.setPrefSize((root.getWidth() - 30) / 2, root.getHeight());
		GrapheCenter = new SplitPane();
		GrapheCenterTop = new BorderPane();
		GrapheCenterTopTop = new BorderPane();
		GrapheCenterTopBottom = new BorderPane();
		GrapheCenterBottom = new BorderPane();
		GrapheCenterBottomTop = new BorderPane();
		GrapheCenterBottomBottom = new BorderPane();
		GrapheBottom = new GridPane();
		GrapheBottom.setHgap(10);
		GrapheBottom.setPadding(new Insets(0, 10, 0, 10));

		RegleCenterTop.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		RegleCenterBottom.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		RegleBottom.setStyle("-fx-padding: 10;");

		GrapheCenterTop.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		GrapheCenterBottom.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		GrapheBottom.setStyle("-fx-padding: 10;");

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
		GrapheBottom.setAlignment(Pos.CENTER);
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
		// TODO Auto-generated method stub

	}

	@Override
	public Controleur creationControleur() {
		return new ControleurAccueil(this);
	}

	@Override
	public void creationBouton() {
		creerGraphe = creerBouton("Créer Graphes");
		creerGraphe.setPrefWidth(150.);
		creerGraphe.setPrefHeight(40.);
		aleatoireGraphe = creerBouton("Graphes Aléatoire");
		aleatoireGraphe.setPrefWidth(150.);
		aleatoireGraphe.setPrefHeight(40.);
		creerRegle = creerBouton("Créer Règles");
		creerRegle.setPrefWidth(150.);
		creerRegle.setPrefHeight(40.);
	}
}
