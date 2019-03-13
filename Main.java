import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import modele.Joueur;
import modele.Modele;
import modele.point.Point;
import modele.point.PointCouleur;
import modele.segment.Segment;
import vue.VueCreationGraphe;
import vue.VuePlateauJeu;

public class Main extends Application {

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Modele m = new Modele();
		Modele m2 = new Modele();
		m.addJoueur(new Joueur("j1", Color.RED));
		m.addJoueur(new Joueur("j2", Color.BLUE));
		Point p1 = new PointCouleur(200, 100, Color.WHITE);
		Point p2 = new PointCouleur(300, 200, Color.WHITE);
		Point p3 = new PointCouleur(200, 200, Color.WHITE);
		Point p4 = new PointCouleur(400, 200, Color.WHITE);
		Point p5 = new PointCouleur(500, 100, Color.WHITE);
		Point p6 = new PointCouleur(500, 200, Color.WHITE);
		Point p7 = new PointCouleur(200, 300, Color.WHITE);
		Point p8 = new PointCouleur(500, 300, Color.WHITE);
		Point p9 = new PointCouleur(600, 200, Color.BLUE);
		Point p10 = new PointCouleur(100, 200, Color.RED);
		m.addPoint(p1);
		m.addPoint(p2);
		m.addPoint(p3);
		m.addPoint(p4);
		m.addPoint(p5);
		m.addPoint(p6);
		m.addPoint(p7);
		m.addPoint(p8);
		m.addPoint(p9);
		m.addPoint(p10);
		m.addSegment(new Segment(p1, p2));
		m.addSegment(new Segment(p2, p3));
		m.addSegment(new Segment(p1, p3));
		m.addSegment(new Segment(p4, p2));
		m.addSegment(new Segment(p5, p6));
		m.addSegment(new Segment(p4, p5));
		m.addSegment(new Segment(p4, p6));
		m.addSegment(new Segment(p3, p7));
		m.addSegment(new Segment(p7, p2));
		m.addSegment(new Segment(p8, p6));
		m.addSegment(new Segment(p8, p4));
		m.addSegment(new Segment(p3, p10));
		m.addSegment(new Segment(p9, p6));
		new VueCreationGraphe(m2);
	}
}
