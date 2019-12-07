package enumeinfach;

public class Main {

	public static void main(String[] args) {
		
		Arbeitnehmer bob = new Arbeitnehmer("Bobowich", "Bob", Aufgabe.Marketing);
		Arbeitnehmer frank = new Arbeitnehmer("Frankenstein", "Frank", Aufgabe.Management);
		Arbeitnehmer susan = new Arbeitnehmer("Susaki", "Susan", Aufgabe.Verwaltung);
		
		System.out.println(bob.toString());
		System.out.println(frank.toString());
		System.out.println(susan.toString());

	}

}
