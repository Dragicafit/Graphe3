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
import modele.graphe.ModeleGraphe;
import modele.regle.ModeleRegle;

public class VueAccueil extends Vue {

	protected SplitPane main;

	protected BorderPane Regles;
	protected SplitPane RegleCenter;
	protected BorderPane RegleCenterTop;
	protected BorderPane RegleCenterTopTop;
	protected GridPane RegleCenterTopBottom;
	protected BorderPane RegleCenterBottom;
	protected BorderPane RegleCenterBottomTop;
	protected GridPane RegleCenterBottomBottom;
	protected BorderPane RegleBottom;

	protected BorderPane Graphes;
	protected SplitPane GrapheCenter;
	protected BorderPane GrapheCenterTop;
	protected BorderPane GrapheCenterTopTop;
	protected GridPane GrapheCenterTopBottom;
	protected BorderPane GrapheCenterBottom;
	protected BorderPane GrapheCenterBottomTop;
	protected GridPane GrapheCenterBottomBottom;
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
		RegleCenterTopBottom = creerGridPane(Pos.TOP_LEFT, true);
		RegleCenterBottom = creerBorderPane(true);
		RegleCenterBottomTop = creerBorderPane(false);
		RegleCenterBottomBottom = creerGridPane(Pos.TOP_LEFT, true);
		RegleBottom = creerBorderPane(false);

		Graphes = creerBorderPane(false);
		Graphes.setPrefSize((root.getWidth() - 30) / 2, root.getHeight());
		GrapheCenter = new SplitPane();
		GrapheCenterTop = creerBorderPane(true);
		GrapheCenterTopTop = creerBorderPane(false);
		GrapheCenterTopBottom = creerGridPane(Pos.TOP_LEFT, true);
		GrapheCenterBottom = creerBorderPane(true);
		GrapheCenterBottomTop = creerBorderPane(false);
		GrapheCenterBottomBottom = creerGridPane(Pos.TOP_LEFT, true);
		GrapheBottom = creerGridPane(Pos.CENTER, false);
	
		RegleBottom.setStyle("-fx-padding: 10;");
		
		
		ajoutReglePredef();
		ajoutGraphePredef();
		ajoutRegleLocal();
		ajoutGrapheLocal();

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
		
		boutons.put(creerGraphe, "graphe");
		boutons.put(creerRegle, "regles");
		boutons.put(aleatoireGraphe, "aleatoire");
	}
	
	public void ajoutReglePredef() {
		int x = 0;
		for(ModeleRegle e : this.modele.getReglesPredefinis()) {
			Text t = new Text(e.getNom());
			t.setStyle("-fx-font-size: 20px;");
			RegleCenterTopBottom.add(t, 0, x);
			x++;
		}
	}
	
	public void ajoutRegleLocal() {
		int x = 0;
		for(ModeleRegle e : this.modele.getReglesLocal()) {
			Text t = new Text(e.getNom());
			t.setStyle("-fx-font-size: 20px;");
			RegleCenterBottomBottom.add(t, 0, x);
			x++;
		}
	}
	
	public void ajoutGraphePredef() {
		int x = 0;
		for(ModeleGraphe e : this.modele.getGraphesPredefinis()) {
			Text t = new Text(e.getNom());
			t.setStyle("-fx-font-size: 20px;");
			GrapheCenterTopBottom.add(t, 0, x);
			x++;
		}
	}
	
	public void ajoutGrapheLocal() {
		int x = 0;
		for(ModeleGraphe e : this.modele.getGraphesLocal()) {
			Text t = new Text(e.getNom());
			t.setStyle("-fx-font-size: 20px;");
			GrapheCenterBottomBottom.add(t, 0, x);
			x++;
		}
	}
}
