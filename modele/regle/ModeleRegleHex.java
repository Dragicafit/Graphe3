package modele.regle;

public class ModeleRegleHex extends ModeleRegle{
	private static final long serialVersionUID = 202L;

	public ModeleRegleHex() {
		super("Hex");
		this.JouerAcoteEnnemi.set(false);
		this.JouerSurEnnemi.set(false);
		this.EstBlanc.set(true);
	}
}
