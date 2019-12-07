package warenkorb;

public class Luxusartikel implements Produkt {
	
	private String _name;
	private double _preis;
	private double _mwst = 1.25;
	
	public Luxusartikel(String name, double preis) {
		this._name = name;
		this._preis = preis;
	}
	
	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public double get_preis() {
		return _preis;
	}

	public void set_preis(double _preis) {
		this._preis = _preis;
	}

	public double get_mwst() {
		return _mwst;
	}

	@Override
	public double bruttoPreis() {
		return this.get_preis() * this.get_mwst();
	}
	
	@Override
	public String toString() {
		return "Luxusartikel " + this.get_name() + " Preis: " + this.get_preis() + " Brutto: " + this.bruttoPreis();
	}

}
