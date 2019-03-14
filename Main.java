import javafx.application.Application;
import javafx.stage.Stage;
import modele.Modele;
import vue.VuePlateauJeu;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Modele m = Modele.importModele();
		new VuePlateauJeu(m);
	}
	
	@Override
	public void stop() throws Exception {
		System.exit(0);
	}
}
