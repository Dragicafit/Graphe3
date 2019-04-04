package vue;

import controleur.Controleur;
import controleur.ControleurJeu;
import javafx.scene.text.Text;
import modele.Modele;

public class VuePlateauJeu extends VueJeu {

	private Text nomJoueur;

	public VuePlateauJeu(Modele m) {
		super(m);
		this.setTitle("Lets GO !!!");
		this.nomJoueur = new Text();
		top.getChildren().add(this.nomJoueur);
		update();
	}

	@Override
	public Controleur creationControleur() {
		return new ControleurJeu(this);
	}

	@Override
	public void update() {
		super.update();
		this.nomJoueur.setText(modele.getJoueur(modele.getJoueurCourant()).getNom());
	}
}
