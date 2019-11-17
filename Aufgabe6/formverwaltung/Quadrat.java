package formverwaltung;

public class Quadrat {
	private double _laenge;
	
	public Quadrat(double laenge) {
		this._laenge = laenge;
	}
	
	protected void setLaenge(double laenge) {
		this._laenge = laenge;
	}
	
	protected double getLaenge() {
		return this._laenge;
	}
	
	public double berechneUmfang() {
		return this._laenge * 4;
	}
	
	public double berechneFlaeche() {
		return this._laenge * this._laenge;
	}

}
