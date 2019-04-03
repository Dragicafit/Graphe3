package modele.regle;

import modele.DeepClone;

public class ModeleRegle extends DeepClone {
	private static final long serialVersionUID = 52L;

	private String nom;

	public Boolean JouerAcoteSoit;
	public Boolean JouerAcoteEnnemi;
	public Boolean JouerSurEnnemi;
	public Boolean EstBlanc;
	public boolean DeplacementAutorise;
	public boolean FinHex;

	public ModeleRegle(String nom) {
		this.nom = nom;
	}

	public ModeleRegle() {
		this.nom = null;
		this.JouerAcoteSoit = null;
		this.JouerAcoteEnnemi = null;
		this.JouerSurEnnemi = null;
		this.EstBlanc = null;
		this.DeplacementAutorise = false;
		this.FinHex = false;
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
					&& DeplacementAutorise == modeleRegle.DeplacementAutorise && FinHex == modeleRegle.FinHex;
		}
		return false;
	}
}
