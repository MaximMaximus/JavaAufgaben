package arbeitnehmerclone;

public class Main {

	public static void main(String[] args) {
		Department de1 = new Department(1, "Feldspieler");
		Arbeitnehmer ar1 = new Arbeitnehmer(1, "Thomas Müller", de1);
		
		// Flache Kopie nur Zeiger auf Objekte
		Arbeitnehmer flach1 = ar1;
		System.out.println("Flache Kopie:");
		System.out.println(ar1.toString());
		System.out.println(flach1.toString());
		System.out.println(ar1.get_department().toString());
		System.out.println(flach1.get_department().toString());

		// Tiefe Kopie alle Objekte werden kopiert
		Arbeitnehmer tief1 = ar1.clone();
		System.out.println("Tiefe Kopie");
		System.out.println(ar1.toString());
		System.out.println(tief1.toString());
		System.out.println(ar1.get_department().toString());
		System.out.println(tief1.get_department().toString());

	}

}
