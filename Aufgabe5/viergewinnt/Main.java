package viergewinnt;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		boolean ende = false;
		int turn = 1;

		Feld feld = new Feld();
		feld.clearFeld();
		Spieler spieler1 = new Spieler("Spieler 1", 'O');
		Spieler spieler2 = new Spieler("Spieler 2", 'X');

		// feld.setFeld(spieler1.getPlayerY(),spieler1.getPlayerX(),
		// spieler1.getPlayerSymbol());

		do {
			feld.drawFeld();
			if (spieler1.isGewonnen() == true || spieler2.isGewonnen() == true) {
				if (spieler1.isGewonnen() == true) {
					System.out.println(spieler1.getPlayerName() + " hat gewonnen!");
				} else {
					System.out.println(spieler2.getPlayerName() + " hat gewonnen!");
				}
				System.out.println("Nochmal spielen? (1/0)");
				int wahl = sc.nextInt();
				if (wahl == 1) {
					feld.clearFeld();
					turn = 1;
					feld.drawFeld();
				} else {
					ende = true;
					break;
				}
			}

			if (turn % 2 == 1) {
				// Spieler 1
				int p1newX = playerMove(spieler1, feld);
				feld.placeSymbol(p1newX, spieler1.getPlayerSymbol());
				spieler1.setGewonnen(checkFeld(spieler1, feld));
			} else if (turn % 2 == 0) {
				// Spieler 2
				int p2newX = playerMove(spieler2, feld);
				feld.placeSymbol(p2newX, spieler2.getPlayerSymbol());
				spieler2.setGewonnen(checkFeld(spieler2, feld));
			}
			// Check Feld

			turn++;

		} while (ende == false);
		if (spieler1.isGewonnen() == true) {
			System.out.println(spieler1.getPlayerName() + " hat gewonnen!");
		} else {
			System.out.println(spieler2.getPlayerName() + " hat gewonnen!");
		}
		System.out.println("Ende");

		sc.close();

	}

	public static int playerMove(Spieler spieler, Feld feld) {
		int x = 0;

		do {
			System.out.println(spieler.getPlayerName() + " bitte Spalte wählen: ");
			x = getInput();
			if (x < 0 || x > 6) {
				System.out.println("Ungültige Eingabe");
			} else if (feld.checkFull(x) == true) {
				System.out.println("Feld bereits voll!");
			} else {
				System.out.println(spieler.getPlayerName() + " wirft in die Spalte " + (x + 1));
				spieler.setPlayerX(x);
				break;
			}

		} while (true);

		return spieler.getPlayerX();
	}

	public static int getInput() {
		Scanner sc = new Scanner(System.in);
		int input = 0;

		do {
			try {
				input = sc.nextInt();
				break;
			} catch (InputMismatchException exception) {
				// input = -1;
				// break;
			}
		} while (true);
		input--;
		return input;
	}

	public static boolean checkFeld(Spieler spieler, Feld feld) {
		boolean gewinn = false;
		if (feld.checkHorizontal(spieler.getPlayerSymbol()) || feld.checkVertikal(spieler.getPlayerSymbol())
				|| feld.checkDiagonalDown(spieler.getPlayerSymbol())
				|| feld.checkDiagonalUp(spieler.getPlayerSymbol())) {
			gewinn = true;
		}
		return gewinn;
	}
}
