package geoObjekt;

public abstract class GeoObjekt implements Rechnen {
	
	private double _x;
	private double _y;
	
	public GeoObjekt(double x, double y) {
		this._x = x;
		this._y = y;
	}

	public double get_x() {
		return _x;
	}

	public void set_x(double _x) {
		this._x = _x;
	}

	public double get_y() {
		return _y;
	}

	public void set_y(double _y) {
		this._y = _y;
	}

}
