package vue;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import modele.Modele;

public class VueAccueil extends Vue {

	public BorderPane Graphes;
	public BorderPane Regles;
	public BorderPane Center;
	public HBox GrapheTop;
	public BorderPane GrapheCenter;
	public HBox GrapheBottom;
	public HBox RegleTop;
	public BorderPane RegleCenter;
	public HBox RegleBottom;

	public VueAccueil(Modele m) {
		super(m);
		Graphes = new BorderPane();
		Regles = new BorderPane();
		Graphes.setPrefSize((root.getWidth() - 30) / 2, 100);
		Regles.setPrefSize((root.getWidth() - 30) / 2, root.getHeight());
		GrapheTop = new HBox();
		GrapheCenter = new BorderPane();
		GrapheBottom = new HBox();
		RegleTop = new HBox();
		RegleCenter = new BorderPane();
		RegleBottom = new HBox();
		Center = new BorderPane();

		Center.setStyle("-fx-border-style: solid inside;" + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
				+ "-fx-border-radius: 5;" + "-fx-border-color: black;");
		Graphes.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		Regles.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		GrapheTop.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		GrapheBottom.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		GrapheCenter.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		RegleTop.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		RegleBottom.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		RegleCenter.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");

		Button creerGraphe = new Button("Créer");
		Button aleatoireGraphe = new Button("Aléatoire");
		Button creerRegle = new Button("Créer");

		RegleTop.getChildren().add(new Text("Règles"));
		GrapheTop.getChildren().add(new Text("Graphes"));
		GrapheBottom.getChildren().addAll(creerGraphe, aleatoireGraphe);
		RegleBottom.getChildren().add(creerRegle);
		Graphes.setTop(GrapheTop);
		Graphes.setCenter(GrapheCenter);
		Graphes.setBottom(GrapheBottom);
		Regles.setTop(RegleTop);
		Regles.setCenter(RegleCenter);
		Regles.setBottom(RegleBottom);
		root.setLeft(Graphes);
		root.setRight(Regles);
		root.setCenter(Center);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}
}
