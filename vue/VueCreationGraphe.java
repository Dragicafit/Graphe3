package vue;

import controleur.Controleur;
import controleur.ControleurGraphes;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modele.Modele;

public class VueCreationGraphe extends VueJeu {

	protected TextField nomGraphe;

	public VueCreationGraphe(Modele m) {
		super(m);
		this.setTitle("Création d'un graphe");
		nomGraphe = creerZoneText("Nom du Graphe", 40.);
		ajoutBouton(creerBouton("Point", "point.png"), "point");
		ajoutBouton(creerBouton("Segment", "segment.png", 3, 45), "segment");
		ajoutBouton(creerBouton("Supprimer", "delete.png"), "supprimer");
		ajoutBouton(creerBouton("Supprimer\n    Tout"), "supprimerTout");
		bottom.getChildren().add(0, nomGraphe);
	}

	public void ajoutBouton(Button b, String s) {
		boutons.put(b, s);
		top.getChildren().add(b);
	}

	@Override
	public Controleur creationControleur() {
		return new ControleurGraphes(this);
	}

	public TextField getNomGraphe() {
		return nomGraphe;
	}
}
