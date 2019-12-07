package warenkorb;

import java.util.ArrayList;
import java.util.List;

public class Warenkorb {

	private List<Produkt> _artikel = new ArrayList<Produkt>();
	
	

	public List<Produkt> get_artikel() {
		return _artikel;
	}

	public void set_artikel(List<Produkt> _artikel) {
		this._artikel = _artikel;
	}

	public void clear() {
		this._artikel.clear();
	}

	public void add(Produkt artikel) {
		this._artikel.add(artikel);
	}

	public double gesamtPreis() {
		double summe = 0;
		for (Produkt produkt : _artikel) {
			summe += produkt.bruttoPreis();
		}
		return summe;
	}

	public void print() {
		for (Produkt produkt : _artikel) {
			System.out.println(produkt.toString());
		}
	}

}
