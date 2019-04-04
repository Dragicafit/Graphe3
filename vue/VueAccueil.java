package vue;

import java.util.HashMap;
import java.util.Map;

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
	
	private TilePane RegleCenterTopBottom;
	private TilePane RegleCenterBottomBottom;
	private TilePane GrapheCenterTopBottom;
	private TilePane GrapheCenterBottomBottom;
	protected Map<Button, ModeleGraphe> graphePredef;
	protected Map<Button, ModeleGraphe> grapheLocal;
	protected Map<Button, ModeleRegle> reglePredef;
	protected Map<Button, ModeleRegle> regleLocal;

	public VueAccueil(Modele m) {
		super(m);
		graphePredef = new HashMap<>();
		grapheLocal = new HashMap<>();
		reglePredef = new HashMap<>();
		regleLocal = new HashMap<>();
		modele.resetCourant();
		SplitPane main = new SplitPane();

		BorderPane Regles = creerBorderPane(false);
		Regles.setPrefSize((root.getWidth() - 30) / 2, root.getHeight());
		SplitPane RegleCenter = new SplitPane();
		BorderPane RegleCenterTop = creerBorderPane(true);
		BorderPane RegleCenterTopTop = creerBorderPane(false);
		ScrollPane RegleCenterTopScroll = creerScrollPane();
		RegleCenterTopBottom = creerTilePane(Pos.TOP_LEFT, false);
		BorderPane RegleCenterBottom = creerBorderPane(true);
		BorderPane RegleCenterBottomTop = creerBorderPane(false);
		ScrollPane RegleCenterBottomScroll = creerScrollPane();
		RegleCenterBottomBottom = creerTilePane(Pos.TOP_LEFT, false);
		BorderPane RegleBottom = creerBorderPane(false);

		BorderPane Graphes = creerBorderPane(false);
		Graphes.setPrefSize((root.getWidth() - 30) / 2, root.getHeight());
		SplitPane GrapheCenter = new SplitPane();
		BorderPane GrapheCenterTop = creerBorderPane(true);
		BorderPane GrapheCenterTopTop = creerBorderPane(false);
		ScrollPane GrapheCenterTopScroll = creerScrollPane();
		GrapheCenterTopBottom = creerTilePane(Pos.TOP_LEFT, false);
		BorderPane GrapheCenterBottom = creerBorderPane(true);
		BorderPane GrapheCenterBottomTop = creerBorderPane(false);
		ScrollPane GrapheCenterBottomScroll = creerScrollPane();
		GrapheCenterBottomBottom = creerTilePane(Pos.TOP_LEFT, false);
		GridPane GrapheBottom = creerGridPane(Pos.CENTER, false);

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

		GrapheBottom.add(ajoutBouton(creerBouton("Créer Graphes"), "graphe"), 0, 0);
		GrapheBottom.add(ajoutBouton(creerBouton("Graphes Aléatoire"), "aleatoire"), 1, 0);
		RegleBottom.setCenter(ajoutBouton(creerBouton("Créer Règles"), "regles"));

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
	
	public Button ajoutBouton(Button b, String s) {
		boutons.put(b, s);
		return b;
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
	
	public void ajoutReglePredef() {
		for(ModeleRegle e : this.modele.getReglesPredefinis()) {
			Button b = creerBouton(e.getNom());
			reglePredef.put(b, e);
			RegleCenterTopBottom.getChildren().add(b);
		}
	}
	
	public void ajoutRegleLocal() {
		for(ModeleRegle e : this.modele.getReglesLocal()) {
			Button b = creerBouton(e.getNom());
			regleLocal.put(b, e);
			RegleCenterBottomBottom.getChildren().add(b);
		}
	}
	
	public void ajoutGraphePredef() {
		for(ModeleGraphe e : this.modele.getGraphesPredefinis()) {
			/*Text t = new Text(e.getNom());
			t.setStyle("-fx-font-size: 20px;");
			GrapheCenterTopBottom.getChildren().add(t);*/
			Button b = creerBouton(e.getNom());
			graphePredef.put(b, e);
			GrapheCenterTopBottom.getChildren().add(b);
		}
	}
	
	public void ajoutGrapheLocal() {
		for(ModeleGraphe e : this.modele.getGraphesLocal()) {
			Button b = creerBouton(e.getNom());
			grapheLocal.put(b, e);
			GrapheCenterBottomBottom.getChildren().add(b);
		}
	}

	public Map<Button, ModeleGraphe> getGraphePredef() {
		return graphePredef;
	}
	
	public ModeleGraphe getGraphePredef(Button key) {
		return graphePredef.get(key);
	}

	public void setGraphePredef(Map<Button, ModeleGraphe> graphePredef) {
		this.graphePredef = graphePredef;
	}

	public Map<Button, ModeleGraphe> getGrapheLocal() {
		return grapheLocal;
	}
	
	public ModeleGraphe getGrapheLocal(Button key) {
		return grapheLocal.get(key);
	}

	public void setGrapheLocal(Map<Button, ModeleGraphe> grapheLocal) {
		this.grapheLocal = grapheLocal;
	}

	public Map<Button, ModeleRegle> getReglePredef() {
		return reglePredef;
	}
	
	public ModeleRegle getReglePredef(Button key) {
		return reglePredef.get(key);
	}

	public void setReglePredef(Map<Button, ModeleRegle> reglePredef) {
		this.reglePredef = reglePredef;
	}

	public Map<Button, ModeleRegle> getRegleLocal() {
		return regleLocal;
	}
	
	public ModeleRegle getRegleLocal(Button key) {
		return regleLocal.get(key);
	}

	public void setRegleLocal(Map<Button, ModeleRegle> regleLocal) {
		this.regleLocal = regleLocal;
	}
}
