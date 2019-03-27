package modele;

public class ModeleRegleSnort extends ModeleRegle {
	private static final long serialVersionUID = 200L;
	
	public ModeleRegleSnort() {
		super("Snort");
		this.JouerAcoteSoit = true;
		this.JouerSurEnnemi = false;
		this.EstBlanc = true;
	}
}
