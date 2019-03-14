package vue;

import Jeux.Jeux;
import Jeux.Snort;
import controleur.Controleur;
import controleur.ControleurJeu;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import modele.Modele;
import regles.Regles;

public class VuePlateauJeu extends VueJeu {

	public Button colorier;
	public Button deplacer;
	public Text nomJoueur;

	public VuePlateauJeu(Modele m) {
		super(m);
		creationBouton();
		update();
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
	}

	@Override
	public Controleur creationControleur() {
		Jeux jeu = new Snort(new Regles(modele, true, true, true, true), false, this);
		jeu.start();
		return new ControleurJeu(this, jeu);
	}

	@Override
	public void update() {
		super.update();
		this.nomJoueur.setText(modele.getJoueur(modele.getJoueurCourant()).getNom());
	}
}
