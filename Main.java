import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import modele.Modele;
import modele.graphe.ModeleGraphe;
import modele.graphe.ModeleGraphe1;
import modele.graphe.ModeleGraphe2;
import modele.graphe.ModeleGraphe3;
import modele.graphe.ModeleGraphe4;
import modele.graphe.ModeleGraphe5;
import modele.graphe.ModeleGrapheHex;
import modele.regle.ModeleRegle;
import modele.regle.ModeleRegleCol;
import modele.regle.ModeleRegleHex;
import modele.regle.ModeleRegleSnort;
import vue.VueCreationGraphe;
import vue.VuePlateauJeu;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Modele m = new Modele();
			m.setGrapheCourant(new ModeleGrapheHex());
			ArrayList<ModeleGraphe> graphe = m.getGraphesPredefinis();
			graphe.add(new ModeleGraphe1());
			graphe.add(new ModeleGraphe2());
			graphe.add(new ModeleGraphe3());
			graphe.add(new ModeleGraphe4());
			graphe.add(new ModeleGraphe5());
			
			m.setRegleCourant(new ModeleRegleSnort());
			ArrayList<ModeleRegle> regles = m.getReglesPredefinis();
			regles.add(new ModeleRegleSnort());
			regles.add(new ModeleRegleHex());
			regles.add(new ModeleRegleCol());
			
			new VuePlateauJeu(m);
			new VueCreationGraphe(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void stop() {
		System.exit(0);
	}
}
