package vue;

import controleur.Controleur;
import controleur.ControleurGraphes;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modele.Modele;

public class VueCreationGraphe extends VueJeu {

	protected Button point;
	protected Button segment;
	protected Button supprimer;
	protected Button supprimerTout;
	protected TextField nomGraphe;

	public VueCreationGraphe(Modele m) {
		super(m);
		super.primaryStage.setTitle("Création d'un graphe");
		nomGraphe = creerZoneText("Nom du Graphe", 40.);
		top.getChildren().addAll(point, segment, supprimer, supprimerTout, nomGraphe);
	}

	@Override
	public void creationBouton() {
		super.creationBouton();
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
		return new ControleurGraphes(this);
	}

	public Button getPoint() {
		return point;
	}

	public Button getSegment() {
		return segment;
	}

	public Button getSupprimer() {
		return supprimer;
	}

	public Button getSupprimerTout() {
		return supprimerTout;
	}

	public TextField getNomGraphe() {
		return nomGraphe;
	}
}
