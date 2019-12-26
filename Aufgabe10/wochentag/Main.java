package wochentag;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Calendar gcal = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE, yyyy.MM.dd G 'at' HH:mm:ss zzzz");
		Scanner sc = new Scanner(System.in);
		boolean schaltjahr = false;

		System.out.println("Datumeingabe");
		System.out.println("Bitte geben Sie das Jahr ein: ");
		int jahr = jahrEingabe(sc);
		schaltjahr = schaltjahrTest(jahr);
		System.out.println("Bitte geben Sie den Monat ein: ");
		int monat = monatEingabe(sc);
		System.out.println("Bitte geben Sie den tag ein: ");
		int tag = tagEingabe(sc, monat, schaltjahr);

		gcal.set(Calendar.DATE, tag);
		gcal.set(Calendar.MONTH, monat - 1);
		gcal.set(Calendar.YEAR, jahr);

		System.out.println(sdf.format(gcal.getTime()));

		sc.close();
	}

	public static int tagEingabe(Scanner sc, int monat, boolean schaltjahr) {
		int tag = 1;
		do {
			tag = sc.nextInt();
			if (schaltjahr && monat == 2) {
				if (tag > 0 && tag < 30) {
					break;
				} else {
					System.out.println("Ungültige Eingabe");
					System.out.println("Bitte nochmal eingeben: ");
				}
			} else if (!schaltjahr && monat == 2) {
				if (tag > 0 && tag < 29) {
					break;
				} else {
					System.out.println("Ungültige Eingabe");
					System.out.println("Bitte nochmal eingeben: ");
				}
			} else if (!(monat == 2)) {
				if (tag > 0 && tag < 32) {
					break;
				} else {
					System.out.println("Ungültige Eingabe");
					System.out.println("Bitte nochmal eingeben: ");
				}
			}

		} while (true);
		return tag;
	}

	public static int monatEingabe(Scanner sc) {
		int monat = 1;
		do {
			monat = sc.nextInt();
			if (monat > 0 && monat < 13) {
				break;
			} else {
				System.out.println("Ungültige Eingabe");
				System.out.println("Bitte nochmal eingeben: ");
			}

		} while (true);
		return monat;
	}

	public static int jahrEingabe(Scanner sc) {
		int jahr = 1;
		do {
			jahr = sc.nextInt();
			if (jahr > 1582) {
				break;
			} else {
				System.out.println("Ungültige Eingabe");
				System.out.println("Bitte nochmal eingeben: ");
			}

		} while (true);
		return jahr;
	}

	public static boolean schaltjahrTest(int jahr) {
		boolean schaltjahr = false;
		if (jahr % 400 == 0) {
			schaltjahr = true;
		} else if (jahr % 100 == 0) {
			schaltjahr = false;
		} else if (jahr % 4 == 0) {
			schaltjahr = true;
		}
		return schaltjahr;
	}

}
