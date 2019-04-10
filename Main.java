import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import modele.Modele;
import modele.graphe.ModeleGraphe1;
import modele.graphe.ModeleGraphe2;
import modele.graphe.ModeleGraphe3;
import modele.graphe.ModeleGraphe4;
import modele.graphe.ModeleGraphe5;
import modele.graphe.ModeleGrapheHex;
import modele.graphe.ModeleGrapheHex2;
import modele.regle.ModeleRegleCol;
import modele.regle.ModeleRegleHex;
import modele.regle.ModeleRegleSnort;
import vue.VueAccueil;

public class Main extends Application {

	private Modele m;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			m = Modele.importModele();
			new VueAccueil(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void stop() {
		try {
			m.exportModele();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}

	private Modele initialisation() {
		Modele modele = new Modele();
		
		modele.addGraphesPredefinis(new ModeleGraphe1());
		modele.addGraphesPredefinis(new ModeleGraphe2());
		modele.addGraphesPredefinis(new ModeleGraphe3());
		modele.addGraphesPredefinis(new ModeleGraphe4());
		modele.addGraphesPredefinis(new ModeleGraphe5());
		modele.addGraphesPredefinis(new ModeleGrapheHex());
		modele.addGraphesPredefinis(new ModeleGrapheHex2());

		modele.addReglesPredefinis(new ModeleRegleSnort());
		modele.addReglesPredefinis(new ModeleRegleCol());
		modele.addReglesPredefinis(new ModeleRegleHex());
		
		return modele;
	}
}
