package modele.regle;

public class ModeleRegleSnort extends ModeleRegle {
	private static final long serialVersionUID = 200L;
	
	public ModeleRegleSnort() {
		super("Snort");
		this.JouerAcoteSoit = null;
		this.JouerAcoteEnnemi = false;
		this.JouerSurEnnemi = false;
		this.EstBlanc = true;
	}
}
