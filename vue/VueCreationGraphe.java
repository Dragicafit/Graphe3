package vue;

import controleur.Controleur;
import controleur.ControleurCreationGaphe;
import javafx.scene.control.Button;
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
		point = creerBouton("Point", "point.png");
		segment = creerBouton("Segment", "segment.png", 3, 45);
		supprimer = creerBouton("Supprimer", "delete.png");
		supprimerTout = creerBouton("Supprimer\n    Tout");
		
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
