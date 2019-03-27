import javafx.application.Application;
import javafx.stage.Stage;
import modele.Modele;
import vue.VueCreationGraphe;
import vue.VueCreationRegle;
import vue.VuePlateauJeu;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Modele m = Modele.importModele();
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
