package modele.regle;

public class ModeleRegleCol extends ModeleRegle {
	private static final long serialVersionUID = 201L;
	
	public ModeleRegleCol() {
		super("Col");
		this.JouerAcoteSoit = null;
		this.JouerAcoteEnnemi = false;
		this.JouerSurEnnemi = false;
		this.EstBlanc = true;
	}
}