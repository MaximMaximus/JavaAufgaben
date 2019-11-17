package formverwaltung;

public class Main {

	public static void main(String[] args) {
		Quadrat q1 = new Quadrat(2.0);
		Rechteck r1 = new Rechteck(2.0, 2.0);

		System.out.println("Quadrat:");
		System.out.println("Länge: " + q1.getLaenge());
		System.out.println("Umfang: " + q1.berechneUmfang());
		System.out.println("Fläche: " + q1.berechneFlaeche());

		System.out.println("Breite:");
		System.out.println("Länge: " + r1.getLaenge());
		System.out.println("Breite: " + r1.getBreite());
		System.out.println("Umfang: " + r1.berechneUmfang());
		System.out.println("Fläche: " + r1.berechneFlaeche());

	}

}
