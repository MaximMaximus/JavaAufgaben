package formverwaltung;

public class Rechteck extends Quadrat {
	private double _breite;
	
	public Rechteck(double laenge, double breite) {
		super(laenge);
		this._breite = breite;
	}

	public double getBreite() {
		return _breite;
	}

	public void setBreite(double _breite) {
		this._breite = _breite;
	}
	
	public double berechneUmfang() {
		return 2 * this.getLaenge() + 2 * this._breite;
	}
	
	public double berechneFlaeche() {
		return this.getLaenge() * this._breite;
	}
	
}
