package warenkorb;

public class Schmuck extends Luxusartikel {

	public Schmuck(String name, double preis) {
		super(name, preis);
	}
	
	@Override
	public double bruttoPreis() {
		return this.get_preis() * this.get_mwst() + (this.get_preis() * 0.3);
	}
	
	@Override
	public String toString() {
		return "Schmuck " + this.get_name() + " Preis: " + this.get_preis() + " Brutto: " + this.bruttoPreis();
	}

}
