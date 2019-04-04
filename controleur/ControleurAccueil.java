package controleur;

import javafx.scene.control.Button;
import javafx.scene.input.InputEvent;
import modele.graphe.ModeleGraphe;
import modele.regle.ModeleRegle;
import vue.Vue;
import vue.VueAccueil;
import vue.VueCreationGraphe;
import vue.VueCreationRegle;
import vue.VuePlateauJeu;

public class ControleurAccueil extends Controleur {
	
	public ControleurAccueil(Vue vue) {
		super(vue);
		boutons.put("regles", Bouton.CREERREGLE);
		boutons.put("aleatoire", Bouton.ALEATOIRE);
		boutons.put("graphe", Bouton.CREERGRAPHE);
	}

	@Override
	public void handle(InputEvent event) {
		super.handle(event);
		eventBouton();
		Object source = event.getSource();
		if (source instanceof Button) {
			eventGrapheLocal((Button) source);
			eventGraphePredef((Button) source);
			eventRegleLocal((Button) source);
			eventReglePredef((Button) source);
		}
		launcher();
	}
	
	public void eventBouton() {
		if (bouton == Bouton.ALEATOIRE) {
			new VueCreationGraphe(modele);
			exit();
		} else if (bouton == Bouton.CREERGRAPHE) {
			modele.setGrapheCourant(new ModeleGraphe());
			new VueCreationGraphe(modele);
			exit();
		} else if (bouton == Bouton.CREERREGLE) {
			modele.setRegleCourant(new ModeleRegle());
			new VueCreationRegle(modele);
			exit();
		}
	}
	
	public void eventGraphePredef(Button source) {
		VueAccueil vueAccueil = (VueAccueil) vue;
		if (vueAccueil.getGraphePredef().containsKey(source)) {
			modele.setGrapheCourant(vueAccueil.getGraphePredef(source));
		}
	}
	
	public void eventGrapheLocal(Button source) {
		VueAccueil vueAccueil = (VueAccueil) vue;
		if (vueAccueil.getGrapheLocal().containsKey(source)) {
			modele.setGrapheCourant(vueAccueil.getGrapheLocal(source));
		}
	}
	
	public void eventReglePredef(Button source) {
		VueAccueil vueAccueil = (VueAccueil) vue;
		if (vueAccueil.getReglePredef().containsKey(source)) {
			modele.setRegleCourant(vueAccueil.getReglePredef(source));
		}
	}
	
	public void eventRegleLocal(Button source) {
		VueAccueil vueAccueil = (VueAccueil) vue;
		if (vueAccueil.getRegleLocal().containsKey(source)) {
			modele.setRegleCourant(vueAccueil.getRegleLocal(source));
		}
	}
	
	public void launcher() {
		if (modele.getGrapheCourant() != null && modele.getRegleCourant() != null) {
			exit();
			new VuePlateauJeu(modele);
		}
	}
}
