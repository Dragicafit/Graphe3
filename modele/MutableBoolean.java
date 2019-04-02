package modele;

public class MutableBoolean {
	private Boolean b;
	
	public MutableBoolean() {
		this.b = null;
	}

	public MutableBoolean(boolean b) {
		this.b = b;
	}
	
	public MutableBoolean(Boolean b) {
		this.b = b;
	}

	public Boolean get() {
		return b;
	}
	
	public void set(boolean b) {
		this.b = b;
	}

	public void set(Boolean b) {
		this.b = b;
	}
}
