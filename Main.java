import javafx.application.Application;
import javafx.stage.Stage;
import modele.Modele;
import vue.Vue;
import vue.VueAccueil;
import vue.VueCreationGraphe;
import vue.VuePlateauJeu;


public class Main extends Application{

	public static void main(String[] args) {
		
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Modele m = new Modele();
		Vue vue1 = new VueCreationGraphe(m);
		Vue vue2 = new VueAccueil(m);
		Vue vue3 = new VuePlateauJeu(m);
		
	}
	
}
