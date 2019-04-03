package vue;

import javafx.scene.control.Button;
import modele.Modele;

public abstract class VueRetour extends Vue {

	public Button sauvegarder;
	public Button retour;

	public VueRetour(Modele m) {
		super(m);
	}

	@Override
	public void creationBouton() {
		sauvegarder = creerBouton("Sauvegarder");
		retour = creerBouton("Retour");
		boutons.put(sauvegarder, "sauvegarder");
		boutons.put(retour, "retour");
	}
}
