package modele.regle;

public class ModeleRegleHex extends ModeleRegle{
	private static final long serialVersionUID = 202L;

	public ModeleRegleHex() {
		super("Hex");
		this.JouerAcoteSoit = null;
		this.JouerAcoteEnnemi = false;
		this.JouerSurEnnemi = false;
		this.EstBlanc = true;
	}
}
