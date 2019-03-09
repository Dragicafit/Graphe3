import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import modele.Joueur;
import modele.Modele;
import vue.VueCreationGraphe;
import vue.VuePlateauJeu;

public class Main extends Application {

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Modele m = new Modele();
		m.addJoueur(new Joueur("j1", Color.RED));
		m.addJoueur(new Joueur("j2", Color.BLUE));
		new VueCreationGraphe(m);
		new VuePlateauJeu(m);
	}

}
