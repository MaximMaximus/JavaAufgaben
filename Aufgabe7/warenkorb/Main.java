package warenkorb;

public class Main {

	public static void main(String[] args) {
		Warenkorb warenkorb1 = new Warenkorb();
		
		Produkt auto = new Luxusartikel("Golf", 20000);
		Produkt uhr = new Schmuck("Uhr", 10000);
		Produkt buch = new Buch("Buch", "Autor", 1000);
		
		warenkorb1.add(auto);
		warenkorb1.add(uhr);
		warenkorb1.add(buch);
		
		warenkorb1.print();
		
		System.out.println("Gesamtpreis " + warenkorb1.gesamtPreis() + " €");
		
		warenkorb1.clear();
		
		if(warenkorb1.get_artikel().isEmpty() == true) {
			System.out.println("Der Warenkorb ist leer!");
		}

	}

}
