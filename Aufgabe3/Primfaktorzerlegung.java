import java.util.Scanner;

public class Primfaktorzerlegung {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int zahl = 0;
		int teiler = 2;
		int exponent = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("Bitte geben Sie eine Zahl ein: ");
		zahl = sc.nextInt();
		
		String ausgabe = "Die Primfaktorzerlegung von " + zahl + " ist: ";

		while (zahl > 1) {
			exponent = 0;
			while (zahl % teiler != 0) {
				teiler++;
			}

			while (zahl % teiler == 0) {
				zahl /= teiler;
				exponent++;
			}

			if (exponent > 1) {
				ausgabe += teiler + "^" + (exponent);
			} else {
				ausgabe += teiler;
			}

			if (zahl >= teiler) {
				ausgabe += " * ";
			}
		}

		System.out.println(ausgabe);

		sc.close();
	}

}
