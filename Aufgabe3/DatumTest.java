import java.util.Scanner;

public class DatumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tag = 0;
		int monat = 0;
		int jahr = 0;
		String meldung = new String();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Zum beenden Jahr 0 eingeben!");
			System.out.println("Geben Sie bitte ein Datum ein");
			System.out.println("Geben Sie den Tag ein: ");
			tag = sc.nextInt();
			System.out.println("Geben Sie den Monat ein: ");
			monat = sc.nextInt();
			System.out.println("Geben Sie das Jahr ein: ");
			jahr = sc.nextInt();
			if (jahr == 0) {
				break;
			}
			meldung = testDatum(tag, monat, jahr);
			System.out.println(meldung);
		} while (jahr != 0);
		System.out.println("Endes");
		sc.close();
	}

	public static boolean schaltjahrTest(int jahr) {
		boolean schaltjahr = false;

		if (jahr % 4 == 0) {
			schaltjahr = true;
		} else if (jahr % 400 == 0) {
			schaltjahr = true;
		} else if (jahr % 100 == 0) {
			schaltjahr = false;
		}
		return schaltjahr;
	}

	public static boolean testTag(int tag, int bereich) {
		boolean tagTest = true;
		if (tag < 1 || tag > bereich) {
			tagTest = false;
		}
		return tagTest;
	}

	public static String testDatum(int tag, int monat, int jahr) {
		boolean tagTest = true;
		String ausgabe = new String();
		ausgabe = "Das eingegebene Datum ist gueltig!";
		if (schaltjahrTest(jahr) == true) {
			ausgabe += " Schaltjahr!";
		}
		if (jahr <= 1582 && monat <= 10 && tag < 15) {
			ausgabe = "Das eingegebene Datum liegt unterhalb des gregorianischen Kalenders!";
		} else if (monat < 1 || monat > 12) {
			ausgabe = "Der eingegebene Monat ist ungueltig!";
		} else {
			switch (monat) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				tagTest = testTag(tag, 31);
				break;
			case 2:
				if (schaltjahrTest(jahr) == true) {
					tagTest = testTag(tag, 29);
				} else {
					tagTest = testTag(tag, 28);
				}
				;
				break;
			default:
				tagTest = testTag(tag, 30);
			}
		}
		if (tagTest == false) {
			ausgabe = "Der eingegebene Tag ist ungueltig!";
		}
		return ausgabe;
	}
}
