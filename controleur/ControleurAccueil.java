package controleur;

import javafx.scene.control.Button;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
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
			eventGrapheLocal((Button) source, ((MouseEvent) event).getButton() == MouseButton.PRIMARY);
			eventGraphePredef((Button) source);
			eventRegleLocal((Button) source, ((MouseEvent) event).getButton() == MouseButton.PRIMARY);
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
			modele.setGrapheCourant((ModeleGraphe) vueAccueil.getGraphePredef(source).clone());
		}
	}
	
	public void eventGrapheLocal(Button source, boolean click) {
		VueAccueil vueAccueil = (VueAccueil) vue;
		if (vueAccueil.getGrapheLocal().containsKey(source)) {
			if (click) {
				modele.setGrapheCourant((ModeleGraphe) vueAccueil.getGrapheLocal(source).clone());
			} else {
				modele.getGraphesLocal().remove(vueAccueil.getGrapheLocal(source));
				vue.update();
			}
		}
	}
	
	public void eventReglePredef(Button source) {
		VueAccueil vueAccueil = (VueAccueil) vue;
		if (vueAccueil.getReglePredef().containsKey(source)) {
			modele.setRegleCourant((ModeleRegle) vueAccueil.getReglePredef(source).clone());
		}
	}
	
	public void eventRegleLocal(Button source, boolean click) {
		VueAccueil vueAccueil = (VueAccueil) vue;
		if (vueAccueil.getRegleLocal().containsKey(source)) {
			if (click) {
				modele.setRegleCourant((ModeleRegle) vueAccueil.getRegleLocal(source).clone());
			} else {
				modele.getReglesLocal().remove(vueAccueil.getRegleLocal(source));
				vue.update();
			}
		}
	}
	
	public void launcher() {
		if (modele.getGrapheCourant() != null && modele.getRegleCourant() != null) {
			exit();
			new VuePlateauJeu(modele);
		}
	}
}
