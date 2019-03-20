package vue;

import java.util.LinkedList;

import javafx.application.Platform;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import modele.Modele;
import modele.point.PointCouleur;
import modele.segment.SegmentCouleur;

public abstract class VueJeu extends VueRetour {
	public SplitPane main;
	public BorderPane menu;
	public VBox top;
	public VBox bottom;
	public Pane graphe;

	public VueJeu(Modele m) {
		super(m);
		top = new VBox();
		bottom = new VBox();
		main = new SplitPane();
		main.setOrientation(Orientation.HORIZONTAL);
		main.setDividerPositions(0.);
		menu = new BorderPane();
		top.setSpacing(20);
		top.setAlignment(Pos.CENTER);
		bottom.setSpacing(20);
		bottom.setAlignment(Pos.CENTER);
		bottom.setStyle("-fx-padding: 10;");
		bottom.getChildren().addAll(sauvegarder, retour);
		menu.setTop(top);
		menu.setBottom(bottom);
		menu.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		root.setLeft(menu);
		graphe = new Pane();
		graphe.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: black;");
		graphe.addEventHandler(DragEvent.DRAG_DROPPED, controleur);
		graphe.addEventHandler(DragEvent.DRAG_OVER, controleur);
		graphe.addEventHandler(MouseEvent.MOUSE_CLICKED, controleur);
		menu.maxWidthProperty().set(150.);
		menu.minWidthProperty().set(150.);
		main.getItems().addAll(menu, graphe);
		root.setCenter(main);
		update();
	}

	public Pane getGraphe() {
		return graphe;
	}

	public void update() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				effacerTout();
				majListe();
			}
		});

	}

	public void effacerTout() {
		graphe.getChildren().clear();
		cercles.clear();
		lignes.clear();
	}

	@Override
	public Button creerBouton(String nom) {
		Button b = super.creerBouton(nom);
		b.setMaxWidth(Double.MAX_VALUE);
		return b;
	}

	public void majListe() {
		if (modele == null)
			return;
		for (int i = 0; i < modele.getSizeSegments(); i++) {
			Line l = new Line(modele.getSegment(i).getPoint1().getX(), modele.getSegment(i).getPoint1().getY(),
					modele.getSegment(i).getPoint2().getX(), modele.getSegment(i).getPoint2().getY());
			if (modele.getSegment(i) instanceof SegmentCouleur) {
				l.setStroke(((SegmentCouleur) modele.getSegment(i)).getCouleur().toColor());
			} else {
				l.setStroke(Color.BLACK);
			}
			l.setStrokeWidth(3);
			l.setVisible(true);
			l.addEventHandler(MouseEvent.MOUSE_CLICKED, controleur);
			lignes.add(l);
			this.graphe.getChildren().add(l);
		}
		for (int i = 0; i < modele.getSizePoints(); i++) {
			Circle c = new Circle(modele.getPoint(i).getX(), modele.getPoint(i).getY(), 15);
			if (modele.getPoint(i) instanceof PointCouleur) {
				c.setFill(((PointCouleur) modele.getPoint(i)).getCouleur().toColor());
			} else {
				c.setFill(Color.WHITE);
			}
			c.setStroke(Color.BLACK);
			c.setStrokeWidth(3);
			c.setVisible(true);
			c.addEventHandler(MouseEvent.MOUSE_CLICKED, controleur);
			c.addEventHandler(MouseEvent.DRAG_DETECTED, controleur);
			cercles.add(c);
			this.graphe.getChildren().add(c);
		}
	}

	public void putPointOnTop(LinkedList<Circle> l) {
		for (int i = 0; i < cercles.size(); i++) {
			l.get(i).toFront();
		}
	}
}
