import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import modele.Modele;
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
}
