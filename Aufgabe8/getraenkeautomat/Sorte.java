package getraenkeautomat;

public enum Sorte {
	COLA(1, "Cola", 80), WASSER(2, "Wasser", 60), LIMO(3, "Limo", 70);

	private int _id;
	private String _marke;
	private int _preis;

	Sorte(int id, String marke, int preis) {
		this._id = id;
		this._marke = marke;
		this._preis = preis;
	}

	public int get_id() {
		return _id;
	}

	public String get_marke() {
		return _marke;
	}

	public int get_preis() {
		return _preis;
	}
	
	public String toString() {
		return this.get_id() + " = " + this.get_marke() + " (" + this.get_preis() + " Cent)";
	}
}
