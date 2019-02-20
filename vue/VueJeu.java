package vue;

import java.util.LinkedList;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import modele.Modele;
import modele.point.PointCouleur;
import modele.segment.SegmentCouleur;

public abstract class VueJeu extends Vue {

	public BorderPane menu;
	public Pane graphe;

	public VueJeu(Modele m) {
		super(m);
		menu = new BorderPane();
		menu.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		root.setLeft(menu);
		graphe = new Pane();
		graphe.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		graphe.addEventHandler(MouseEvent.MOUSE_CLICKED, controleur);
		root.setCenter(graphe);
	}

	public Pane getGraphe() {
		return graphe;
	}

	public void update() {
		effacerTout();
		majListe();
	}

	public void effacerTout() {
		graphe.getChildren().clear();
		cercles.clear();
		lignes.clear();
	}

	public void majListe() {
		effacerTout();
		if (modele != null) {
			for (int i = 0; i < modele.getSizeSegments(); i++) {
				Line l = new Line(modele.getSegment(i).getPoint1().getX(), modele.getSegment(i).getPoint1().getY(),
						modele.getSegment(i).getPoint2().getX(), modele.getSegment(i).getPoint2().getY());
				if (modele.getSegment(i) instanceof SegmentCouleur) {
					l.setStroke(((SegmentCouleur) modele.getSegment(i)).getCouleur());
				} else {
					l.setStroke(Color.BLACK);
				}
				l.setStrokeWidth(2);
				l.setVisible(true);
				l.addEventHandler(MouseEvent.MOUSE_CLICKED, controleur);
				lignes.add(l);
				this.graphe.getChildren().add(l);
			}
			for (int i = 0; i < modele.getSizePoints(); i++) {
				Circle c = new Circle(modele.getPoint(i).getX(), modele.getPoint(i).getY(), 15);
				if (modele.getPoint(i) instanceof PointCouleur) {
					c.setFill(((PointCouleur) modele.getPoint(i)).getCouleur());
				} else {
					c.setFill(Color.WHITE);
				}
				c.setStroke(Color.BLACK);
				c.setStrokeWidth(3);
				c.setVisible(true);
				c.addEventHandler(MouseEvent.MOUSE_CLICKED, controleur);
				cercles.add(c);
				this.graphe.getChildren().add(c);
			}
		}
	}

	public void putPointOnTop(LinkedList<Circle> l) {
		for (int i = 0; i < cercles.size(); i++) {
			l.get(i).toFront();
		}
	}

	public abstract void creationBouton();

}
