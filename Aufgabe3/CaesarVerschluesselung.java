import java.util.InputMismatchException;
import java.util.Scanner;

public class CaesarVerschluesselung {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String textVer = "";
		String textEnt = "";
		String resultVer = "";
		String resultEnt = "";
		short key = 3;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Caesar Verschlüsselung");
			System.out.println("1. Verschlüsseln");
			System.out.println("2. Entschlüsseln");
			System.out.println("3. Ende");
			int wahl = testeEingabe();
			if (wahl == 1) {
				key = eingabeKey();
				textVer = eingabeText();
				resultVer = caesarVer(key, textVer);
				System.out.println("Eingabe: " + textVer);
				System.out.println("Ausgabe: " + resultVer);
			} else if (wahl == 2) {
				key = eingabeKey();
				textEnt = eingabeText();
				resultEnt = caesarEnt(key, textEnt);
				System.out.println("Eingabe: " + textEnt);
				System.out.println("Ausgabe: " + resultEnt);
			} else if (wahl == 3) {
				System.out.println("Ende");
				break;
			} else {
				System.out.println("Unbekannte Operation!");
			}
		} while (true);

		sc.close();
	}

	public static int testeEingabe() {
		Scanner sc = new Scanner(System.in);
		int eingabe = 0;
		do {
			try {
				eingabe = sc.nextInt();
				break;
			} catch (InputMismatchException exception) {
				// System.out.println("Unbekannte Operation!");
				break;
			}
		} while (true);
		return eingabe;
	}

	public static short eingabeKey() {
		System.out.println("Bitte den Key eingeben (1 - 26):");
		Scanner sc = new Scanner(System.in);
		short key = 0;
		do {
			key = (short) testeEingabe();
			if (key > 0 && key < 27) {
				break;
			} else {
				System.out.println("Außerhalb des Wertebereichs, bitte erneut eingeben!");
			}
		} while (true);
		System.out.println("Key: " + key);
		return key;
	}

	public static String eingabeText() {
		System.out.println("Bitte den Text eingeben:");
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		return temp;
	}

	public static String caesarVer(short key, String text) {
		String result = "";
		for (int i = 0; i < text.length(); i++) {
			if (Character.isLowerCase(text.charAt(i))) {
				char ch = (char) (((int) text.charAt(i) + key - 'a') % 26 + 'a');
				result += ch;
			} else if (Character.isUpperCase(text.charAt(i))) {
				char ch = (char) (((int) text.charAt(i) + key - 'A') % 26 + 'A');
				result += ch;
			}
		}
		return result;
	}

	public static String caesarEnt(short key, String text) {
		String result = "";
		for (int i = 0; i < text.length(); i++) {
			if (Character.isLowerCase(text.charAt(i))) {
				char ch = (char) (((int) text.charAt(i) - key - 'a') % 26 + 'a');
				if (ch < 'a') {
					ch = (char) ((int) ch + 'z' - 'a' + 1);
				}
				result += ch;
			} else if (Character.isUpperCase(text.charAt(i))) {
				char ch = (char) (((int) text.charAt(i) - key - 'A') % 26 + 'A');
				if (ch < 'A') {
					ch = (char) ((int) ch + 'Z' - 'A' + 1);
				}
				result += ch;
			}
		}
		return result;
	}
}
