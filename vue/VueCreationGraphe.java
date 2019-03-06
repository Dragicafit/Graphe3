package vue;

import controleur.Controleur;
import controleur.ControleurCreationGaphe;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import modele.Modele;

public class VueCreationGraphe extends VueJeu {

	public Button point;
	public Button segment;
	public Button supprimer;
	public Button supprimerTout;
	public VBox top;
	public VBox bottom;

	public VueCreationGraphe(Modele m) {
		super(m);
		majListe();
		super.primaryStage.setTitle("Création d'un graphe");
		top = new VBox();
		bottom = new VBox();
		top.getChildren().addAll(point, segment, supprimer);
		bottom.getChildren().addAll(supprimerTout);
		top.setSpacing(20);
		bottom.setStyle("-fx-padding: 10;");
		menu.setTop(top);
		menu.setBottom(bottom);
		
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

		supprimerTout = new Button("Supprimer\n    Tout");
		supprimerTout.setMaxWidth(Double.MAX_VALUE);
		supprimerTout.setAlignment(Pos.TOP_CENTER);
		supprimerTout.addEventHandler(MouseEvent.MOUSE_CLICKED, controleur);
		
		boutons.put(point, "point");
		boutons.put(supprimer, "supprimer");
		boutons.put(segment, "segment");
		boutons.put(supprimerTout, "supprimerTout");

	}

	@Override
	public Controleur creationControleur() {
		return new ControleurCreationGaphe(this);
	}

}
