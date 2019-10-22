import java.util.Scanner;

public class SummeProduktSchleife {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float summe = 0f;
		float produkt = 1.00f;
		String zahlen = "";
		boolean eingabe = true;
		int zahlenCounter = 0;
		Scanner sc = new Scanner(System.in);
		do {
			if (zahlenCounter > 1) {
				System.out.println("Weitere Zahlen eingeben (0/1)?");
				int wahl = sc.nextInt();
				if (wahl == 0 || wahl != 1) {
					System.out.println("Programm Ende!");
					eingabe = false;
					break;
				}
			}
			System.out.println("Bitte geben Sie eine Zahl ein: ");
			float zahl = sc.nextFloat();
			summe += zahl;
			produkt *= zahl;
			zahlen += String.format("%.2f, ", zahl);
			zahlenCounter++;
		} while (eingabe == true);
		zahlen = zahlen.substring(0, zahlen.length()-2);
		System.out.println("Sie haben eingegeben: " + zahlen);
		System.out.println("Summe: " + summe);
		System.out.println("Produkt: " + produkt);
		sc.close();
	}
}
