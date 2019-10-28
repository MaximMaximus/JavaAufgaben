import java.util.Scanner;

public class Morse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] zahlen = { "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----." };

		Scanner sc = new Scanner(System.in);
		String morse = "";
		boolean gefunden = false;
		int zahl = 0;

		System.out.println("Morse-Code Zahlen:");
		for (int i = 0; i < zahlen.length; i++) {
			System.out.println("Zahl: " + i + " Morse: " + zahlen[i]);
		}

		System.out.println("Bitte geben Sie eine Zahl in Morse-Code ein: ");
		morse = sc.nextLine();
		//for (int i = 0; i < 5; i++) {
		//	morse += sc.next();
		//}

		for (String s : zahlen) {
			if (s.equals(morse)) {
				System.out.println("Die Zahl ist: " + zahl);
				gefunden = true;
				break;
			}
			zahl++;
		}

		if (gefunden == false) {
			System.out.println("Ungueltiger Morse-Code!");
		}

		sc.close();
	}

}
