package vue;

import controleur.Controleur;
import controleur.ControleurCreationGaphe;
import javafx.scene.control.Button;
import modele.Modele;

public class VueCreationGraphe extends VueJeu {

	public Button point;
	public Button segment;
	public Button supprimer;
	public Button supprimerTout;

	public VueCreationGraphe(Modele m) {
		super(m);
		super.primaryStage.setTitle("Création d'un graphe");
		top.getChildren().addAll(point, segment, supprimer, supprimerTout);
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
		return new ControleurCreationGaphe(this);
	}
}
