package vue;

import controleur.Controleur;
import controleur.ControleurAccueil;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import modele.Modele;
import modele.graphe.ModeleGraphe;
import modele.regle.ModeleRegle;

public class VueAccueil extends Vue {

	protected SplitPane main;

	protected BorderPane Regles;
	protected SplitPane RegleCenter;
	protected BorderPane RegleCenterTop;
	protected BorderPane RegleCenterTopTop;
	protected ScrollPane RegleCenterTopScroll;
	protected TilePane RegleCenterTopBottom;
	protected BorderPane RegleCenterBottom;
	protected BorderPane RegleCenterBottomTop;
	protected ScrollPane RegleCenterBottomScroll;
	protected TilePane RegleCenterBottomBottom;
	protected BorderPane RegleBottom;

	protected BorderPane Graphes;
	protected SplitPane GrapheCenter;
	protected BorderPane GrapheCenterTop;
	protected BorderPane GrapheCenterTopTop;
	protected ScrollPane GrapheCenterTopScroll;
	protected TilePane GrapheCenterTopBottom;
	protected BorderPane GrapheCenterBottom;
	protected BorderPane GrapheCenterBottomTop;
	protected ScrollPane GrapheCenterBottomScroll;
	protected TilePane GrapheCenterBottomBottom;
	protected GridPane GrapheBottom;

	protected Button creerGraphe;
	protected Button aleatoireGraphe;
	protected Button creerRegle;

	public VueAccueil(Modele m) {
		super(m);
		main = new SplitPane();

		Regles = creerBorderPane(false);
		Regles.setPrefSize((root.getWidth() - 30) / 2, root.getHeight());
		RegleCenter = new SplitPane();
		RegleCenterTop = creerBorderPane(true);
		RegleCenterTopTop = creerBorderPane(false);
		RegleCenterTopScroll = creerScrollPane();
		RegleCenterTopBottom = creerTilePane(Pos.TOP_LEFT, false);
		RegleCenterBottom = creerBorderPane(true);
		RegleCenterBottomTop = creerBorderPane(false);
		RegleCenterBottomScroll = creerScrollPane();
		RegleCenterBottomBottom = creerTilePane(Pos.TOP_LEFT, false);
		RegleBottom = creerBorderPane(false);

		Graphes = creerBorderPane(false);
		Graphes.setPrefSize((root.getWidth() - 30) / 2, root.getHeight());
		GrapheCenter = new SplitPane();
		GrapheCenterTop = creerBorderPane(true);
		GrapheCenterTopTop = creerBorderPane(false);
		GrapheCenterTopScroll = creerScrollPane();
		GrapheCenterTopBottom = creerTilePane(Pos.TOP_LEFT, false);
		GrapheCenterBottom = creerBorderPane(true);
		GrapheCenterBottomTop = creerBorderPane(false);
		GrapheCenterBottomScroll = creerScrollPane();
		GrapheCenterBottomBottom = creerTilePane(Pos.TOP_LEFT, false);
		GrapheBottom = creerGridPane(Pos.CENTER, false);
	
		RegleBottom.setStyle("-fx-padding: 10;");
		
		ajoutReglePredef();
		ajoutGraphePredef();
		ajoutRegleLocal();
		ajoutGrapheLocal();
		RegleCenterTopScroll.setContent(RegleCenterTopBottom);
		RegleCenterBottomScroll.setContent(RegleCenterBottomBottom);
		GrapheCenterTopScroll.setContent(GrapheCenterTopBottom);
		GrapheCenterBottomScroll.setContent(GrapheCenterBottomBottom);

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
		RegleCenterTop.setCenter(RegleCenterTopScroll);
		RegleCenterBottom.setTop(RegleCenterBottomTop);
		RegleCenterBottom.setCenter(RegleCenterBottomScroll);
		Regles.setBottom(RegleBottom);

		Graphes.setCenter(GrapheCenter);
		GrapheCenter.setOrientation(Orientation.VERTICAL);
		GrapheCenter.getItems().addAll(GrapheCenterTop, GrapheCenterBottom);
		GrapheCenterTop.setTop(GrapheCenterTopTop);
		GrapheCenterTop.setCenter(GrapheCenterTopScroll);
		GrapheCenterBottom.setTop(GrapheCenterBottomTop);
		GrapheCenterBottom.setCenter(GrapheCenterBottomScroll);
		Graphes.setBottom(GrapheBottom);

		root.setCenter(main);
		main.setOrientation(Orientation.HORIZONTAL);
		Graphes.minWidthProperty().bind(main.widthProperty().multiply(0.25));
		GrapheCenterTop.minHeightProperty().bind(main.heightProperty().multiply(0.25));
		GrapheCenterBottom.minHeightProperty().bind(main.heightProperty().multiply(0.25));
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
		
		boutons.put(creerGraphe, "graphe");
		boutons.put(creerRegle, "regles");
		boutons.put(aleatoireGraphe, "aleatoire");
	}
	
	public void ajoutReglePredef() {
		for(ModeleRegle e : this.modele.getReglesPredefinis()) {
			Button b = creerBouton(e.getNom());
			RegleCenterTopBottom.getChildren().add(b);
		}
	}
	
	public void ajoutRegleLocal() {
		for(ModeleRegle e : this.modele.getReglesLocal()) {
			Button b = creerBouton(e.getNom());
			RegleCenterBottomBottom.getChildren().add(b);
		}
	}
	
	public void ajoutGraphePredef() {
		for(ModeleGraphe e : this.modele.getGraphesPredefinis()) {
			/*Text t = new Text(e.getNom());
			t.setStyle("-fx-font-size: 20px;");
			GrapheCenterTopBottom.getChildren().add(t);*/
			Button b = creerBouton(e.getNom());
			GrapheCenterTopBottom.getChildren().add(b);
		}
	}
	
	public void ajoutGrapheLocal() {
		for(ModeleGraphe e : this.modele.getGraphesLocal()) {
			Button b = creerBouton(e.getNom());
			GrapheCenterBottomBottom.getChildren().add(b);
		}
	}
}
