package geoObjekt;

public class Main {

	public static void main(String[] args) {
		GeoObjekt kreis = new Kreis(20, 20, 20);
		GeoObjekt quadrat = new Quadrat(10, 10, 10);
		GeoObjekt rechteck = new Rechteck(1, 1, 1, 1);

		System.out.println("Kreisfläche: " + kreis.berechneFlaeche());
		System.out.println("Kreisumfang: " + kreis.berechneUmfang());

		System.out.println("Quadratfläche: " + quadrat.berechneFlaeche());
		System.out.println("Quadratumfang: " + quadrat.berechneUmfang());

		System.out.println("Rechtecksfläche: " + rechteck.berechneFlaeche());
		System.out.println("Rechtecksumfang: " + rechteck.berechneUmfang());

	}

}
