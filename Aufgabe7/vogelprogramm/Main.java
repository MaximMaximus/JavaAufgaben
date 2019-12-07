package vogelprogramm;

public class Main {

	public static void main(String[] args) {
		Vogel pinguin = new Pinguin("Peter");
		Vogel amsel = new Amsel("Franz");
		Vogel drossel = new Drossel("Dora");
		
		System.out.println(pinguin.getName());
		System.out.println(amsel.getName());
		System.out.println(drossel.getName());

	}

}
