package vue;

import controleur.Controleur;
import controleur.ControleurJeu;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import modele.Modele;

public class VuePlateauJeu extends VueJeu {

	public Button colorier;
	public Button deplacer;
	public Text nomJoueur;

	public VuePlateauJeu(Modele m) {
		super(m);
		creationBouton();
		majListe();
		super.primaryStage.setTitle("Lets GO !!!");
		top.getChildren().addAll(this.nomJoueur, this.colorier, this.deplacer);
	}

	public void creationBouton() {
		super.creationBouton();
		this.colorier = creerBouton("Colorier");
		this.deplacer = creerBouton("Déplacer");
		boutons.put(colorier, "colorier");
		boutons.put(deplacer, "deplacer");
		this.nomJoueur = new Text();
		this.nomJoueur.setText("   Inserer le nom  \n     du joueur !!!");
	}

	@Override
	public Controleur creationControleur() {
		return new ControleurJeu(this);
	}

}
