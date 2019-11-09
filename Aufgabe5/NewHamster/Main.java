package hamsterprogramm;

import java.util.Scanner;

public class Main {

	public static int feldSizeY = 10;
	public static int feldSizeX = 10;

	private static FeldObjekt[][] feld;
	private static FeldObjekt[][] hamsterfeld = new FeldObjekt[feldSizeY][feldSizeX];
	private static Hamster hamster;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int wahl = 0;
		int gesamtKorn = 3;
		int steps = 0;

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

			// wahl = sc.nextInt();
			// wahl = (int) (Math.random() * 3 + 1);

			wahl = hamsterKi(feld, hamster, hamsterfeld);

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
			steps++;
			// pause(300);
			if (gesamtKorn == hamster.getKornCounter()) {
				wahl = 0;
			}

		} while (wahl != 0);
		printFeld();
		System.out.println("Ende!");
		System.out.println("Benötigte Schritte: " + steps);
		printHamsterFeld();

		sc.close();

	}

	public static int hamsterKi(FeldObjekt[][] feld, Hamster hamster, FeldObjekt[][] hamsterfled) {
		int move = (int) (Math.random() * 3 + 1);
		int kornY = 0;
		int kornX = 0;
		LeeresFeld markierung = new LeeresFeld('X');
		for (int i = 0; i < feldSizeY; i++) {
			for (int j = 0; j < feldSizeX; j++) {
				if (feld[i][j].getClass().equals(Korn.class)) {
					kornY = i;
					kornX = j;
				}
				if (feld[i][j].getClass().equals(Hamster.class)) {
					hamsterfeld[hamster.getY()][hamster.getX()] = markierung;
				}
			}
		}

		boolean wandRechts = (feld[hamster.getY()][hamster.getX() + 1].getClass().equals(Wand.class));
		boolean wandLinks = (feld[hamster.getY()][hamster.getX() - 1].getClass().equals(Wand.class));
		boolean wandOben = (feld[hamster.getY() - 1][hamster.getX()].getClass().equals(Wand.class));
		boolean wandUnten = (feld[hamster.getY() + 1][hamster.getX()].getClass().equals(Wand.class));

		// dir 1 = links 2 = rechts 3 = oben 4 = unten
		int dir = 0;
		if (wandRechts || wandLinks || wandOben || wandUnten) {
			dir = (int) (Math.random() * 4 + 1);
		} else {
			if (hamster.getX() > kornX)
				dir = 1;
			else if (hamster.getX() < kornX)
				dir = 2;
			else if (hamster.getY() > kornY)
				dir = 3;
			else if (hamster.getY() < kornY)
				dir = 4;
		}
		System.out.println("hamsterx: " + hamster.getX() + " hamstery: " + hamster.getY() + " kornx: " + kornX
				+ " korny: " + kornY);

		System.out.println("direction " + dir);
		System.out.println(wandOben);

		if (dir == 3) {
			if (wandOben == false) {
				hamster.setSymbol('^');
				hamster.laufVorwaerts(feld);
			} else if (wandOben == true && wandLinks == true && wandRechts == false && wandUnten == true) {
				hamster.setSymbol('>');
				hamster.laufVorwaerts(feld);
			} else if (wandOben == true && wandLinks == true && wandRechts == true && wandUnten == false) {
				hamster.setSymbol('v');
				hamster.laufVorwaerts(feld);
			} else if (wandOben == true && wandLinks == false && wandRechts == true && wandUnten == true) {
				hamster.setSymbol('<');
				hamster.laufVorwaerts(feld);
			} else if (wandOben == true && wandLinks == true && wandRechts == false && wandUnten == true) {
				hamster.setSymbol('>');
				hamster.laufVorwaerts(feld);
			} else if (wandOben == true && wandLinks == false && wandRechts == false && wandUnten == true) {
				hamster.setSymbol('>');
				hamster.laufVorwaerts(feld);
			} else if (wandOben == true && wandLinks == false && wandRechts == true && wandUnten == true) {
				hamster.setSymbol('<');
				hamster.laufVorwaerts(feld);
			} else if (wandOben == true && wandLinks == false && wandRechts == false && wandUnten == false) {
				hamster.setSymbol('<');
				hamster.laufVorwaerts(feld);
			}
			hamster.setSymbol('^');
			move = 3;
		} else if (dir == 4) {
			if (wandOben == false && wandLinks == true && wandRechts == true && wandUnten == true) {
				hamster.setSymbol('^');
				hamster.laufVorwaerts(feld);
			} else if (wandOben == false && wandLinks == true && wandRechts == false && wandUnten == true) {
				hamster.setSymbol('>');
				hamster.laufVorwaerts(feld);
			} else if (wandOben == true && wandLinks == true && wandRechts == false && wandUnten == true) {
				hamster.setSymbol('>');
				hamster.laufVorwaerts(feld);
			} else if (wandOben == false && wandLinks == false && wandRechts == true && wandUnten == true) {
				hamster.setSymbol('<');
				hamster.laufVorwaerts(feld);
			} else if (wandOben == false && wandLinks == false && wandRechts == false && wandUnten == true) {
				hamster.setSymbol('<');
				hamster.laufVorwaerts(feld);
			} else if (wandOben == true && wandLinks == false && wandRechts == false && wandUnten == true) {
				hamster.setSymbol('>');
				hamster.laufVorwaerts(feld);
			} else if (wandOben == true && wandLinks == false && wandRechts == true && wandUnten == true) {
				hamster.setSymbol('<');
				hamster.laufVorwaerts(feld);
			} else if (wandUnten == false) {
				hamster.setSymbol('v');
				hamster.laufVorwaerts(feld);
			}
			hamster.setSymbol('v');
			move = 3;
		} else if (dir == 1) {
			if (wandOben == false && wandLinks == true && wandRechts == true && wandUnten == true) {
				hamster.setSymbol('^');
				hamster.laufVorwaerts(feld);
			} else if (wandOben == true && wandLinks == true && wandRechts == false && wandUnten == true) {
				hamster.setSymbol('>');
				hamster.laufVorwaerts(feld);
			} else if (wandOben == true && wandLinks == true && wandRechts == true && wandUnten == false) {
				hamster.setSymbol('v');
				hamster.laufVorwaerts(feld);
			} else if (wandOben == false && wandLinks == true && wandRechts == false && wandUnten == true) {
				hamster.setSymbol('^');
				hamster.laufVorwaerts(feld);
			} else if (wandOben == false && wandLinks == true && wandRechts == true && wandUnten == false) {
				hamster.setSymbol('v');
				hamster.laufVorwaerts(feld);
			} else if (wandOben == true && wandLinks == true && wandRechts == false && wandUnten == false) {
				hamster.setSymbol('v');
				hamster.laufVorwaerts(feld);
			} else if (wandOben == false && wandLinks == true && wandRechts == false && wandUnten == false) {
				hamster.setSymbol('v');
				hamster.laufVorwaerts(feld);
			} else if (wandLinks == false) {
				hamster.setSymbol('<');
				hamster.laufVorwaerts(feld);
			}
			hamster.setSymbol('<');
			move = 3;
		} else if (dir == 2) {
			if (wandOben == true && wandLinks == true && wandRechts == true && wandUnten == false) {
				hamster.setSymbol('v');
				hamster.laufVorwaerts(feld);
			} else if (wandOben == true && wandLinks == false && wandRechts == true && wandUnten == true) {
				hamster.setSymbol('<');
				hamster.laufVorwaerts(feld);
			} else if (wandOben == false && wandLinks == true && wandRechts == true && wandUnten == true) {
				hamster.setSymbol('^');
				hamster.laufVorwaerts(feld);
			} else if (wandOben == false && wandLinks == false && wandRechts == true && wandUnten == false) {
				hamster.setSymbol('v');
				hamster.laufVorwaerts(feld);
			} else if (wandOben == false && wandLinks == true && wandRechts == true && wandUnten == false) {
				hamster.setSymbol('v');
				hamster.laufVorwaerts(feld);
			} else if (wandOben == false && wandLinks == false && wandRechts == true && wandUnten == true) {
				hamster.setSymbol('^');
				hamster.laufVorwaerts(feld);
			} else if (wandOben == false && wandLinks == false && wandRechts == true && wandUnten == false) {
				hamster.setSymbol('v');
				hamster.laufVorwaerts(feld);
			} else if (wandLinks == false) {
				hamster.setSymbol('>');
				hamster.laufVorwaerts(feld);
			}
			hamster.setSymbol('>');
			move = 3;
		}

		return move;
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
				hamsterfeld[i][j] = leeresFeld;
			}
		}

		// Außenwand zeichnen
		for (int i = 0; i < feldSizeY; i++) {
			for (int j = 0; j < feldSizeX; j++) {
				if (i == 0 || i == feldSizeY - 1) {
					feld[i][j] = wand;
					hamsterfeld[i][j] = wand;
				}
				if (j == 0 || j == feldSizeX - 1) {
					feld[i][j] = wand;
					hamsterfeld[i][j] = wand;
				}
			}
		}
		feld[3][1] = wand;
		feld[3][2] = wand;
		feld[3][3] = wand;
		feld[3][4] = wand;
		feld[7][5] = wand;
		feld[5][4] = wand;
		feld[6][7] = wand;
		feld[2][7] = wand;
		
		hamsterfeld[3][1] = wand;
		hamsterfeld[3][2] = wand;
		hamsterfeld[3][3] = wand;
		hamsterfeld[3][4] = wand;
		hamsterfeld[7][5] = wand;
		hamsterfeld[5][4] = wand;
		hamsterfeld[6][7] = wand;
		hamsterfeld[2][7] = wand;

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

	public static void printHamsterFeld() {
		System.out.println("Hamster-Movement:");
		for (int i = 0; i < feldSizeY; i++) {
			for (int j = 0; j < feldSizeX; j++) {
				System.out.print(hamsterfeld[i][j].getSymbol());
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void pause(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			System.err.format("IOException: %s%n", e);
		}
	}

}
