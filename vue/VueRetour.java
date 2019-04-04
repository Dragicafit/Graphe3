package vue;

import javafx.scene.control.Button;
import modele.Modele;

public abstract class VueRetour extends Vue {

	protected Button sauvegarder;
	protected Button retour;

	public VueRetour(Modele m) {
		super(m);
		sauvegarder = creerBouton("Sauvegarder");
		retour = creerBouton("Retour");
		boutons.put(sauvegarder, "sauvegarder");
		boutons.put(retour, "retour");
	}
}
