import java.util.Scanner;

public class Wechselkursrechner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float wechselkurs = 1.1135f;
		float gesamtCent = 0f;
		float gesamtMuenzen = 0f;
		float gesamtScheine = 0f;
		float gesamtBetragEuro = 0f;
		float gesamtBetragDollar = 0f;
		
		Scanner sc = new Scanner(System.in);

		int[] cent = { 1, 2, 5, 10, 20, 50 };
		int[] muenzen = { 1, 2 };
		int[] scheine = { 5, 10, 20, 50, 100, 200 };

		System.out.println("Cent:");
		for (int i = 0; i < cent.length; i++) {
			System.out.println("Wie viele " + cent[i] + " Cent Münzen haben Sie?");
			gesamtCent += sc.nextInt() * cent[i];
		}
		
		System.out.println("Münzen:");
		for (int i = 0; i < muenzen.length; i++) {
			System.out.println("Wie viele " + muenzen[i] + " Euro Münzen haben Sie?");
			gesamtMuenzen += sc.nextInt() * muenzen[i];
		}
		
		System.out.println("Scheine:");
		for (int i = 0; i < scheine.length; i++) {
			System.out.println("Wie viele " + scheine[i] + " Euro Scheine haben Sie?");
			gesamtScheine += sc.nextInt() * scheine[i];
		}
		
		gesamtBetragEuro = gesamtScheine + gesamtMuenzen + (gesamtCent / 100);
		gesamtBetragDollar = gesamtBetragEuro * wechselkurs;
		
		System.out.println("Cent: " + (gesamtCent / 100) + " Euro");
		System.out.println("Euro Münzen " + gesamtMuenzen + " Euro");
		System.out.println("Scheine: " + gesamtScheine + " Euro");
		System.out.println(String.format("Gesamtbegrag %.2f Euro", gesamtBetragEuro));
		System.out.println(String.format("Gesamtbegrag %.2f Dollar", gesamtBetragDollar));
		
		sc.close();
	}

}
