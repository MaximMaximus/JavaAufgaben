package warenkorb;

public class Buch implements Produkt {

	private String _name;
	private String _autor;
	private double _preis;
	private double _mwst = 1.05;
	
	public Buch (String name, String autor, double preis) {
		this._name = name;
		this._autor = autor;
		this._preis = preis;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public String get_autor() {
		return _autor;
	}

	public void set_author(String _autor) {
		this._autor = _autor;
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
		return "Buch " + this.get_name() + " Autor: " + this.get_autor() +" Preis: " + this.get_preis() + " Brutto: " + this.bruttoPreis();
	}

}
