package geoObjekt;

public class Kreis extends GeoObjekt {
	
	private int _radius;
	
	public Kreis(double x, double y, int radius) {
		super(x, y);
		this._radius = radius;
	}

	public int get_radius() {
		return _radius;
	}

	public void set_radius(int _radius) {
		this._radius = _radius;
	}

	@Override
	public double berechneFlaeche() {
		return Math.pow(this.get_radius(),2) * Math.PI;
	}

	@Override
	public double berechneUmfang() {
		return this.get_radius() * 2 * Math.PI;
	}

}
