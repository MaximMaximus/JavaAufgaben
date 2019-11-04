package hamsterprogramm;

import java.util.Scanner;

public class Main {

	private static FeldObjekt[][] feld;
	private static Hamster hamster;

	public static int feldSizeY = 10;
	public static int feldSizeX = 10;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int wahl = 0;

		// initFeld
		initFeld();

		do {

			// drawFeld
			printFeld();

			System.out.println("Aktion: ");
			System.out.println("1. Links drehen");
			System.out.println("2. Rechts drehen");
			System.out.println("3. Vorwärts gehen");
			System.out.println("4. Anzahl gefressener Körner ausgeben");
			System.out.println("---");
			System.out.println("0. Beenden");

			wahl = sc.nextInt();

			switch (wahl) {
			case 1:
				hamster.linksDrehen();
				break;
			case 2:
				hamster.rechtsDrehen();
				break;
			case 3:
				feld = hamster.laufVorwaerts(feld);
				break;
			case 4:
				System.out.println(hamster.getKornCounter() + " Körner gefressen");
				break;
			case 0:
				System.out.println("Ende");
				break;
			default:
				System.out.println("Ungültige Eingabe!");
				break;
			}

		} while (wahl != 0);

		sc.close();

	}

	public static void initFeld() {

		feld = new FeldObjekt[feldSizeY][feldSizeX];
		Wand wand = new Wand('#');
		LeeresFeld leeresFeld = new LeeresFeld(' ');
		Korn korn = new Korn('*');
		hamster = new Hamster('>', "Hamster", 4, 4, 0);

		// Feld leeren
		for (int i = 0; i < feldSizeY; i++) {
			for (int j = 0; j < feldSizeX; j++) {
				feld[i][j] = leeresFeld;
			}
		}

		// Außenwand zeichnen
		for (int i = 0; i < feldSizeY; i++) {
			for (int j = 0; j < feldSizeX; j++) {
				if (i == 0 || i == feldSizeY - 1)
					feld[i][j] = wand;
				if (j == 0 || j == feldSizeX - 1)
					feld[i][j] = wand;
			}
		}
		
		feld[3][2] = wand;
		feld[3][3] = wand;
		feld[3][4] = wand;
		feld[7][5] = wand;
		feld[5][4] = wand;
		feld[6][7] = wand;
		feld[2][7] = wand;
		
		feld[2][2] = korn;
		feld[7][4] = korn;
		feld[6][8] = korn;
		
		feld[hamster.getY()][hamster.getX()] = hamster;


	}

	public static void printFeld() {
		for (int i = 0; i < feldSizeY; i++) {
			for (int j = 0; j < feldSizeX; j++) {
				System.out.print(feld[i][j].getSymbol());
			}
			System.out.println();
		}
		System.out.println();
	}

}
