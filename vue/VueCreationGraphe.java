package vue;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.Modele;

public class VueCreationGraphe extends VueJeu {

	public Button point;
	public Button segment;
	public Button supprimer;
	public Button undo;
	public Button redo;
	public Button supprimerTout;
	public HBox undoRedo;
	public VBox top;
	public VBox bottom;

	public VueCreationGraphe(Modele m) {
		super(m);
		creationBouton();
		majListe();
		super.primaryStage.setTitle("Création d'un graphe");
		HBox undoRedo = new HBox();
		top = new VBox();
		bottom = new VBox();
		undoRedo.getChildren().addAll(undo, redo);
		top.getChildren().addAll(point, segment, supprimer, undoRedo);
		bottom.getChildren().addAll(supprimerTout);
		top.setSpacing(20);
		bottom.setStyle("-fx-padding: 10;");
		undoRedo.setSpacing(20);
		menu.setTop(top);
		menu.setBottom(bottom);
		boutons.put(point, "point");
		boutons.put(supprimer, "supprimer");
		boutons.put(undo, "undo");
		boutons.put(segment, "segment");
		boutons.put(redo, "redo");
		boutons.put(supprimerTout, "supprimerTout");
	}

	public void creationBouton() {
		Image imagePoint = new Image("images/point.png");
		ImageView viewPoint = new ImageView(imagePoint);
		viewPoint.setFitHeight(30);
		viewPoint.setFitWidth(30);
		point = new Button("Point", viewPoint);
		point.setMaxWidth(Double.MAX_VALUE);
		point.addEventHandler(MouseEvent.MOUSE_CLICKED, controleur);

		Image imageSegment = new Image("images/segment.png");
		ImageView viewSegment = new ImageView(imageSegment);
		viewSegment.setFitHeight(3);
		viewSegment.setFitWidth(45);
		segment = new Button("Segment", viewSegment);
		segment.setStyle("-fx-padding-top: 100;" + "-fx-padding-bottom: 100;");
		segment.setMaxWidth(Double.MAX_VALUE);
		segment.addEventHandler(MouseEvent.MOUSE_CLICKED, controleur);

		Image imageDelete = new Image("images/delete.png");
		ImageView viewDelete = new ImageView(imageDelete);
		viewDelete.setFitHeight(30);
		viewDelete.setFitWidth(30);
		supprimer = new Button("Supprimer", viewDelete);
		supprimer.setMaxWidth(Double.MAX_VALUE);
		supprimer.addEventHandler(MouseEvent.MOUSE_CLICKED, controleur);

		Image imageUndo = new Image("images/undo.png");
		ImageView viewUndo = new ImageView(imageUndo);
		viewUndo.setFitHeight(30);
		viewUndo.setFitWidth(30);
		undo = new Button("", viewUndo);
		undo.setMaxWidth(Double.MAX_VALUE);
		undo.addEventHandler(MouseEvent.MOUSE_CLICKED, controleur);

		Image imageRedo = new Image("images/redo.png");
		ImageView viewRedo = new ImageView(imageRedo);
		viewRedo.setFitHeight(30);
		viewRedo.setFitWidth(30);
		redo = new Button("", viewRedo);
		redo.setMaxWidth(Double.MAX_VALUE);
		redo.addEventHandler(MouseEvent.MOUSE_CLICKED, controleur);

		supprimerTout = new Button("Supprimer\n    Tout");
		supprimerTout.setMaxWidth(Double.MAX_VALUE);
		supprimerTout.setAlignment(Pos.TOP_CENTER);
		supprimerTout.addEventHandler(MouseEvent.MOUSE_CLICKED, controleur);

	}

}
