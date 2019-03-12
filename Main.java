import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import modele.Joueur;
import modele.Modele;
import modele.point.Point;
import modele.point.PointCouleur;
import modele.segment.Segment;
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
		Point p1 = new PointCouleur(100, 100, Color.RED);
		Point p2 = new PointCouleur(200, 200, Color.WHITE);
		Point p3 = new PointCouleur(100, 200, Color.WHITE);
		Point p4 = new PointCouleur(300, 200, Color.BLUE);
		m.addPoint(p1);
		m.addPoint(p2);
		m.addPoint(p3);
		m.addPoint(p4);
		m.addSegment(new Segment(p1, p2));
		m.addSegment(new Segment(p2, p3));
		m.addSegment(new Segment(p1, p3));
		m.addSegment(new Segment(p4, p2));
		new VuePlateauJeu(m);
	}
}
