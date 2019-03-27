import javafx.application.Application;
import javafx.stage.Stage;
import modele.Modele;
import modele.ModeleGraphe1;
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
			m.setGrapheCourant(new ModeleGraphe1());
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
