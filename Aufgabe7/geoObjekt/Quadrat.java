package geoObjekt;

public class Quadrat extends GeoObjekt{
	
	private int _laenge;
	
	public Quadrat(double x, double y, int laenge) {
		super(x, y);
		this._laenge = laenge;
	}

	public int get_laenge() {
		return _laenge;
	}

	public void set_laenge(int _laenge) {
		this._laenge = _laenge;
	}

	@Override
	public double berechneFlaeche() {
		return this.get_laenge() * this.get_laenge();
	}

	@Override
	public double berechneUmfang() {
		return this.get_laenge() * 4;
	}

}
