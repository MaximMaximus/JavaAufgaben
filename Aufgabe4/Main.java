import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Passwortmanager pw = new Passwortmanager();
		String passalt = "";
		String passneu = "";
		int wahl = 0;
		Scanner sc = new Scanner(System.in);

		do {
			if (pw.versuche >= 3) {
				System.out.println("Zu viele Fehlversuche!");
				System.out.println("Ende");
				break;
			}

			System.out.println("Passwortmanager");
			System.out.println("1. Passwort eingeben");
			System.out.println("2. Passwort ändern");
			System.out.println("3. Ende");

			wahl = eingabeTesten();

			if (wahl == 1) {
				System.out.println("Geben Sie das Passwort ein: ");
				passalt = sc.next();
				pw.pruefung(passalt);
			} else if (wahl == 2) {
				System.out.println("Bitte altes Passwort eingeben:");
				passalt = sc.next();
				System.out.println("Bitte neues Passwort eingeben: ");
				passneu = sc.next();
				pw.passAendern(passalt, passneu);
			} else if (wahl == 3) {
				System.out.println("Ende");
				break;
			} else {
				System.out.println("Ungültige eingabe!");
			}

		} while (true);

		sc.close();
	}

	public static int eingabeTesten() {
		Scanner sc = new Scanner(System.in);
		int input = 0;

		do {
			try {
				input = sc.nextInt();
				break;
			} catch (InputMismatchException exception) {
				input = -1;
				break;
			}
		} while (true);

		return input;
	}
}
