package vue;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import modele.Modele;

public class VueAccueil extends Vue {

	public BorderPane Graphes;
	public BorderPane Regles;
	public BorderPane Center;
	public HBox GrapheTop;
	public BorderPane GrapheCenter;
	public VBox SousGrapheTop;
	public VBox SousGrapheBottom;
	public HBox graphePreDef;
	public HBox listeGraphePreDef;
	public HBox mesGraphes;
	public HBox listeMesGraphes;
	public HBox GrapheBottom;
	public BorderPane RegleTop;
	public BorderPane RegleCenter;
	public BorderPane RegleCenterTop;
	public BorderPane RegleCenterBottom;
	public BorderPane RegleCenterTopTop;
	public BorderPane RegleCenterTopBottom;
	public BorderPane RegleCenterBottomTop;
	public BorderPane RegleCenterBottomBottom;
	public HBox RegleBottom;

	public VueAccueil(Modele m) {
		super(m);
		Graphes = new BorderPane();
		Graphes.setPrefSize((root.getWidth() - 30) / 2, 100);
		GrapheTop = new HBox();
		GrapheCenter = new BorderPane();
		SousGrapheTop = new VBox();
		SousGrapheBottom = new VBox();
		graphePreDef = new HBox();
		mesGraphes = new HBox();
		listeGraphePreDef = new HBox();
		listeMesGraphes = new HBox();
		GrapheBottom = new HBox();
		Center = new BorderPane();
		Regles = new BorderPane();
		Regles.setPrefSize((root.getWidth() - 30) / 2, root.getHeight());

		RegleTop = new BorderPane();
		RegleCenter = new BorderPane();
		RegleCenterTop = new BorderPane();
		// RegleCenterTop.setPrefHeight(Double.MAX_VALUE);
		RegleCenterBottom = new BorderPane();
		RegleCenterTopTop = new BorderPane();
		RegleCenterTopBottom = new BorderPane();
		RegleCenterBottomTop = new BorderPane();
		RegleCenterBottomBottom = new BorderPane();
		RegleBottom = new HBox();

		RegleCenterBottomTop.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		RegleCenterBottomBottom.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		RegleCenterTopTop.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		RegleCenterTopBottom.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		RegleCenterTop.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		RegleCenterBottom.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");

		SousGrapheTop.setStyle("-fx-border-style: solid inside;" + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
				+ "-fx-border-radius: 5;" + "-fx-border-color: black;");
		SousGrapheBottom.setStyle("-fx-border-style: solid inside;" + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
				+ "-fx-border-radius: 5;" + "-fx-border-color: black;");
		graphePreDef.setStyle("-fx-border-style: solid inside;" + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
				+ "-fx-border-radius: 5;" + "-fx-border-color: black;");
		mesGraphes.setStyle("-fx-border-style: solid inside;" + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
				+ "-fx-border-radius: 5;" + "-fx-border-color: black;");
		listeGraphePreDef.setStyle("-fx-border-style: solid inside;" + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
				+ "-fx-border-radius: 5;" + "-fx-border-color: black;");
		listeMesGraphes.setStyle("-fx-border-style: solid inside;" + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
				+ "-fx-border-radius: 5;" + "-fx-border-color: black;");

		Center.setStyle("-fx-border-style: solid inside;" + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
				+ "-fx-border-radius: 5;" + "-fx-border-color: black;");
		/*
		 * Graphes.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" +
		 * "-fx-border-width: 2;" + "-fx-border-insets: 5;" + "-fx-border-radius: 5;" +
		 * "-fx-border-color: black;"); Regles.setStyle("-fx-padding: 10;" +
		 * "-fx-border-style: solid inside;" + "-fx-border-width: 2;" +
		 * "-fx-border-insets: 5;" + "-fx-border-radius: 5;" +
		 * "-fx-border-color: black;");
		 */
		GrapheTop.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		GrapheBottom.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		GrapheCenter.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		RegleTop.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;"
				+ "-fx-text-align: center");
		RegleBottom.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		RegleCenter.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");

		Button creerGraphe = new Button("Créer");
		Button aleatoireGraphe = new Button("Aléatoire");
		Button creerRegle = new Button("Créer");

		RegleTop.setCenter(new Text("Règles"));
		RegleCenterTopTop.setCenter(new Text("Prédéfini"));
		RegleCenterBottomTop.setCenter(new Text("Mes Règles"));
		RegleCenterTop.setMinHeight(250);
		RegleCenterBottom.setMinHeight(250);

		GrapheTop.getChildren().add(new Text("Graphes"));
		GrapheBottom.getChildren().addAll(creerGraphe, aleatoireGraphe);
		RegleBottom.getChildren().add(creerRegle);
		Graphes.setTop(GrapheTop);

		graphePreDef.getChildren().add(new Text("Règles"));
		mesGraphes.getChildren().add(new Text("Règles"));
		listeGraphePreDef.getChildren().add(new Text("Règles"));
		listeMesGraphes.getChildren().add(new Text("Règles"));

		GrapheCenter.setTop(SousGrapheTop);
		GrapheCenter.setBottom(SousGrapheBottom);
		Graphes.setCenter(GrapheCenter);
		Graphes.setBottom(GrapheBottom);
		Regles.setTop(RegleTop);
		Regles.setCenter(RegleCenter);
		Regles.setBottom(RegleBottom);
		RegleCenter.setTop(RegleCenterTop);
		RegleCenter.setBottom(RegleCenterBottom);
		RegleCenterTop.setBottom(RegleCenterTopBottom);
		RegleCenterTop.setTop(RegleCenterTopTop);
		RegleCenterBottom.setBottom(RegleCenterBottomBottom);
		RegleCenterBottom.setTop(RegleCenterBottomTop);
		root.setLeft(Graphes);
		root.setRight(Regles);
		root.setCenter(Center);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}
}
