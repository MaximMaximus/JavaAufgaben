import java.util.InputMismatchException;
import java.util.Scanner;

public class Roulette {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 0 - 36
		// rot = ungerade
		// schwarz = gerade
		// 35x für richtige Zahl
		// 2x für richtige Farbe
		// 1000€ Startkapital
		int casino = 1000000;
		int kapital = 1000;
		int spielwahl = 0;
		int einsatz = 0;
		int zahl = 0;
		int farbe = 0;
		int roulette = 0;

		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("ROULETTE");
			System.out.println("Kapital: " + kapital + " €");
			System.out.println("Kapital-Casino: " + casino + " €");
			if (kapital < 1) {
				System.out.println("Sie haben kein Kapital!");
				System.out.println("Ende");
				break;
			} else if (casino < 1) {
				System.out.println("Das Casino hat kein Geld mehr!");
				System.out.println("Ende");
				break;
			} else {
				// Spielwahl
				spielwahl = spielAuswaehlen();

				// Einsatzwahl
				if (spielwahl != 3) {
					einsatz = einsatzWahl(kapital, casino, spielwahl);
				}

				roulette = (int) (Math.random() * 36) + 0;
				//System.out.println("roulette debug " + roulette);

				if (spielwahl == 1) {
					// Farbe wählen
					farbe = farbWahl();
					if (farbe == roulette % 2 && roulette != 0) {
						System.out.println("Gewonnen!");
						kapital += einsatz;
						casino -= einsatz;
					} else {
						System.out.println("Verloren!");
						System.out.println(kapital + " - " + einsatz + " = " + (kapital - einsatz));
						kapital -= einsatz;
						casino += einsatz;
					}
				} else if (spielwahl == 2) {
					// Zahl wählen
					zahl = zahlWahl();
					if (zahl == roulette) {
						System.out.println("Gewonnen!");
						System.out.println(einsatz + " x 35 = " + (einsatz * 35));
						einsatz *= 34;
						casino -= einsatz;
						kapital += einsatz;
					} else {
						System.out.println("Verloren!");
						System.out.println(kapital + " - " + einsatz + " = " + (kapital - einsatz));
						kapital -= einsatz;
						casino += einsatz;
					}
				} else if (spielwahl == 3) {
					// Ende
					System.out.println("Ende");
					break;
				} else {
					System.out.println("Ungültige Auswhal!");
				}
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

	public static int spielAuswaehlen() {
		Scanner sc = new Scanner(System.in);
		int input = 0;
		System.out.println("1. Auf Farbe setzten");
		System.out.println("2. Auf Zahl setzten");
		System.out.println("3. Ende");
		do {
			System.out.println("Wahl: ");
			input = eingabeTesten();
			if (input == 1 || input == 2 || input == 3) {
				break;
			} else {
				System.out.println("Ungültige Wahl!");
			}
		} while (true);
		return input;
	}

	public static int einsatzWahl(int kapital, int casino, int spielwahl) {
		int einsatz = 0;
		do {
			System.out.println("Wie viel Geld möchten Sie setzen?");
			System.out.println("Wahl: ");
			einsatz = eingabeTesten();
			if (spielwahl == 1) {
				if (einsatz <= kapital && einsatz > 0 && einsatz <= casino) {
					break;
				} else if (einsatz > kapital) {
					System.out.println("Sie haben nicht genügend Kapital!");
				} else if (einsatz > casino) {
					System.out.println("Das Casino hat nicht genug Kapital!");
				} else {
					System.out.println("Ungültige Eingabe!");
				}
			} else {
				if (einsatz <= kapital && einsatz > 0 && einsatz * 35 <= casino) {
					break;
				} else if (einsatz > kapital) {
					System.out.println("Sie haben nicht genügend Kapital!");
				} else if (einsatz * 35 > casino) {
					System.out.println("Im Gewinnfall hat das Casino nicht genug Kapital!");
				} else {
					System.out.println("Ungültige Eingabe!");
				}
			}
		} while (true);
		return einsatz;
	}

	public static int farbWahl() {
		Scanner sc = new Scanner(System.in);
		int wahl = 0;
		System.out.println("Wählen Sie die Farbe auf die Sie setzten möchten.");
		do {
			System.out.println("1. Rot");
			System.out.println("2. Schwarz");
			wahl = eingabeTesten();
			if (wahl == 1) {
				break;
			} else if (wahl == 2) {
				wahl = 0;
				break;
			} else {
				System.out.println("Ungültige Eingabe!");
			}
		} while (true);
		return wahl;
	}

	public static int zahlWahl() {
		Scanner sc = new Scanner(System.in);
		int wahl = 0;
		System.out.println("Bitte eine Zahl von 0 bis 36 wählen.");
		do {
			System.out.println("Ihre Wahl: ");
			wahl = eingabeTesten();
			if (wahl >= 0 && wahl <= 36) {
				break;
			} else {
				System.out.println("Ungültige Zahl!");
			}
		} while (true);
		return wahl;
	}
}
