package modele;

import java.io.Serializable;

public class ModeleRegle implements Serializable {
	private static final long serialVersionUID = 52L;

	private String nom;

	public ModeleRegle(String nom) {
		this.nom = nom;
	}

	public ModeleRegle() {
		this.nom = null;
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
			return nom.equals(modeleRegle.nom);
		}
		return false;
	}
}
