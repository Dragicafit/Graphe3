package vue;

import javafx.scene.control.Button;
import modele.Modele;

public abstract class VueRetour extends Vue {

	public VueRetour(Modele m) {
		super(m);
	}

	public Button sauvegarder;
	public Button retour;

	@Override
	public void creationBouton() {
		sauvegarder = creerBouton("Sauvegarder");
		retour = creerBouton("Retour");
	}
}
