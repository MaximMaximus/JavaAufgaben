package artikelverwaltung;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EingabeTester {

	public int testeInt() {
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

	public double testeDouble() {
		Scanner sc = new Scanner(System.in);
		double input = 0;

		do {
			try {
				input = sc.nextDouble();
				break;
			} catch (InputMismatchException exception) {
				input = -1;
				break;
			}
		} while (true);

		return input;
	}

}
