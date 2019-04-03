package vue;

import java.util.Map;

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
		for (Map.Entry<Button, String> entry : boutons.entrySet()) {
			top.getChildren().add(entry.getKey());
		}
		bottom.getChildren().add(0, nomGraphe);
	}

	@Override
	public void creationBouton() {
		super.creationBouton();
		boutons.put(creerBouton("Point", "point.png"), "point");
		boutons.put(creerBouton("Segment", "segment.png", 3, 45), "segment");
		boutons.put(creerBouton("Supprimer", "delete.png"), "supprimer");
		boutons.put(creerBouton("Supprimer\n    Tout"), "supprimerTout");
	}

	@Override
	public Controleur creationControleur() {
		return new ControleurGraphes(this);
	}

	public TextField getNomGraphe() {
		return nomGraphe;
	}
}
