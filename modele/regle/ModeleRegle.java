package modele.regle;

import modele.DeepClone;
import modele.MutableBoolean;

public class ModeleRegle extends DeepClone {
	private static final long serialVersionUID = 52L;

	private String nom;

	public MutableBoolean JouerAcoteSoit;
	public MutableBoolean JouerAcoteEnnemi;
	public MutableBoolean JouerSurEnnemi;
	public MutableBoolean EstBlanc;
	public MutableBoolean Coloriable;
	public MutableBoolean DeplacementAutorise;
	public MutableBoolean SeCroise;
	public MutableBoolean FinDeplacement;
	public MutableBoolean FinHex;
	public int NbJoueurMax;

	public ModeleRegle(String nom) {
		this();
		this.nom = nom;
	}

	public ModeleRegle() {
		this.nom = null;
		this.JouerAcoteSoit = new MutableBoolean();
		this.JouerAcoteEnnemi = new MutableBoolean();
		this.JouerSurEnnemi = new MutableBoolean();
		this.EstBlanc = new MutableBoolean();
		this.SeCroise = new MutableBoolean();
		this.Coloriable = new MutableBoolean(true);
		this.DeplacementAutorise = new MutableBoolean(false);
		this.FinDeplacement = new MutableBoolean(false);
		this.FinHex = new MutableBoolean(false);
		this.NbJoueurMax = 2;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ModeleRegle) {
			ModeleRegle modeleRegle = (ModeleRegle) obj;
			return nom.equals(modeleRegle.nom) && JouerAcoteSoit.equals(modeleRegle.JouerAcoteSoit)
					&& JouerAcoteEnnemi.equals(modeleRegle.JouerAcoteEnnemi)
					&& JouerSurEnnemi.equals(modeleRegle.JouerSurEnnemi) && EstBlanc.equals(modeleRegle.EstBlanc)
					&& DeplacementAutorise == modeleRegle.DeplacementAutorise && FinHex == modeleRegle.FinHex
					&& SeCroise.equals(modeleRegle.SeCroise) && FinDeplacement == modeleRegle.FinDeplacement && NbJoueurMax == modeleRegle.NbJoueurMax;
		}
		return false;
	}
}
