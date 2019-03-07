package vue;

import controleur.Controleur;
import controleur.ControleurAccueil;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import modele.Modele;

public class VueAccueil extends Vue {

	public SplitPane main;
	
	public BorderPane Regles;
	public BorderPane RegleTop;
	public SplitPane RegleCenter;
	public BorderPane RegleCenterTop;
	public BorderPane RegleCenterTopTop;
	public BorderPane RegleCenterTopBottom;
	public BorderPane RegleCenterBottom;
	public BorderPane RegleCenterBottomTop;
	public BorderPane RegleCenterBottomBottom;
	public BorderPane RegleBottom;
	
	public BorderPane Graphes;
	public BorderPane GrapheTop;
	public SplitPane GrapheCenter;
	public BorderPane GrapheCenterTop;
	public BorderPane GrapheCenterTopTop;
	public BorderPane GrapheCenterTopBottom;
	public BorderPane GrapheCenterBottom;
	public BorderPane GrapheCenterBottomTop;
	public BorderPane GrapheCenterBottomBottom;
	public BorderPane GrapheBottom;
	public HBox hBoxGrapheBottom;
	
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
		GrapheTop = new BorderPane();
		GrapheCenter = new SplitPane();
		GrapheCenterTop = new BorderPane();
		GrapheCenterTopTop = new BorderPane();
		GrapheCenterTopBottom = new BorderPane();
		GrapheCenterBottom = new BorderPane();
		GrapheCenterBottomTop = new BorderPane();
		GrapheCenterBottomBottom = new BorderPane();
		GrapheBottom = new BorderPane();
		hBoxGrapheBottom = new HBox();
		
		
	
		RegleCenterTop.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		RegleCenterBottom.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		RegleBottom.setStyle("-fx-padding: 10;");
		
		GrapheTop.setStyle("-fx-padding: 10;");
		GrapheCenterTopTop.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		GrapheCenterTopBottom.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		GrapheCenterBottomTop.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		GrapheCenterBottomBottom.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		GrapheBottom.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		hBoxGrapheBottom.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");

		
		creerGraphe = new Button("Créer");
		aleatoireGraphe = new Button("Aléatoire");
		creerRegle = new Button("Créer Règles");
		creerRegle.setPrefWidth(150.);
		creerRegle.setPrefHeight(40.);

		Text RP = new Text("Règles Prédéfinies");
		Text RM = new Text("Mes Règles");
		RP.setStyle("-fx-font-size: 20px;");
		RM.setStyle("-fx-font-size: 20px;");
		RegleCenterTopTop.setCenter(RP);
		RegleCenterBottomTop.setCenter(RM);
		
		Text G = new Text("Graphes");
		G.setStyle("-fx-font-size: 30px;");
		GrapheTop.setCenter(G);
		GrapheCenterTopTop.setCenter(new Text("Prédéfini"));
		GrapheCenterBottomTop.setCenter(new Text("Mes Graphes"));
		

		hBoxGrapheBottom.getChildren().addAll(creerGraphe, aleatoireGraphe);
		GrapheBottom.setCenter(hBoxGrapheBottom);
		RegleBottom.setCenter(creerRegle);		
		
		
		Regles.setCenter(RegleCenter);
		RegleCenter.setOrientation(Orientation.VERTICAL);
		RegleCenter.getItems().addAll(RegleCenterTop, RegleCenterBottom);
		RegleCenterTop.setTop(RegleCenterTopTop);
		RegleCenterTop.setCenter(RegleCenterTopBottom);
		RegleCenterBottom.setTop(RegleCenterBottomTop);
		RegleCenterBottom.setCenter(RegleCenterBottomBottom);
		Regles.setBottom(RegleBottom);
		
		Graphes.setTop(GrapheTop);
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
}
