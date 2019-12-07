package geoObjekt;

public class Rechteck extends Quadrat {

	private int _breite;

	public Rechteck(double x, double y, int laenge, int breite) {
		super(x, y, laenge);
		this.set_breite(breite);
	}

	public int get_breite() {
		return _breite;
	}

	public void set_breite(int _breite) {
		this._breite = _breite;
	}

	@Override
	public double berechneFlaeche() {
		return this.get_laenge() * this.get_breite();
	}

	@Override
	public double berechneUmfang() {
		return (this.get_laenge() * 2) + (this.get_breite() * 2);
	}

}
