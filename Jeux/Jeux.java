package Jeux;
import modele.Modele;
import modele.point.Point;
import regles.Regles;
import vue.Vue;

public abstract class Jeux {
	
	private String nom;
	protected Regles regles;
	private Modele m;
	private Vue vue;
	
	
	public Jeux(String nom,  Regles r, Modele m, Vue vue){
		this.nom = nom;
		this.regles = r;
		this.m = m;
		this.vue = vue;
		
	}
	
	public abstract void Jeu();
	
	public abstract boolean end_game();
	
	public abstract boolean check_regles(Point p);
}
