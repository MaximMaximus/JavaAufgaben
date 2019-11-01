package Studentenverwaltung;

import java.util.Scanner;

public class Main {

	public static Hochschule oth = new Hochschule();
	static EingabeTester inputTester = new EingabeTester();

	public static void main(String[] args) {

		// Hochschule erstellen und mit daten füllen
		othInitialisieren();

		Scanner sc = new Scanner(System.in);
		int wahl = 0;
		int ende = 8;

		// Test

		Student max = new Student();
		max.setVorname("Max");
		max.setNachname("Mustermann");
		max.setMatrikelnummer(1234567);
		max.setStudiengang(oth.getStudiengang().get(0));
		max.setEmail();

		oth.addStudent(max);

		max.getStudiengang().getKurs().get(1).setNote(3.3);
		max.getStudiengang().getKurs().get(3).setNote(2);
		max.getStudiengang().getKurs().get(5).setNote(1.7);
		max.getStudiengang().getKurs().get(6).setNote(2);
		max.getStudiengang().getKurs().get(8).setNote(3.3);
		max.getStudiengang().getKurs().get(4).setNote(1);
		
		Student anna = new Student();
		anna.setVorname("Anna");
		anna.setNachname("Hanna");
		anna.setMatrikelnummer(7654321);
		anna.setStudiengang(oth.getStudiengang().get(0));
		anna.setEmail();
		
		oth.addStudent(anna);
		
		anna.getStudiengang().getKurs().get(3).setNote(1);
		anna.getStudiengang().getKurs().get(5).setNote(1);
		anna.getStudiengang().getKurs().get(6).setNote(1);

		// System.out.println(max.printStudentData());
		// System.out.println(max.printStudentKurs());

		// Hauptschliefe
		do {
			System.out.println("Studentenverwaltung der " + oth.getName());
			System.out.println("1. Studenten anlegen");
			System.out.println("2. Studenten-Daten bearbeiten");
			System.out.println("3. Kursnoten hinzufügen");
			System.out.println("4. Studenten-Daten ausgeben");
			System.out.println("5. Alle Studenten ausgeben");
			System.out.println("6. Alle Studenten-Daten ausgeben");
			System.out.println("7. Studiengänge der " + oth.getName());
			System.out.println("8. Programm beenden");

			wahl = inputTester.testeInt();

			switch (wahl) {
			case 1:
				oth.addStudent(studentAnlegen());
				break;
			case 2:
				studentBearbeiten();
				break;
			case 3:
				kursnotenHinzufuegen();
				break;
			case 4:
				studentAusgeben();
				break;
			case 5:
				System.out.println(oth.studentenAusgeben());
				break;
			case 6:
				System.out.println(oth.studentenKomplettAusgeben());
				break;
			case 7:
				System.out.println(oth.studiengaengeAusgeben());
				break;
			case 8:
				System.out.println("Ende");
				break;
			default:
				System.out.println("Ungültige Eingabe!");
				break;
			}

		} while (wahl != ende);

		sc.close();
	}

	private static Student studentAnlegen() {
		Student neu = new Student();
		neu = studentenDatenAendern(neu);

		Studiengang neuFach = fachWaehlen(oth);
		neu.setStudiengang(neuFach);

		return neu;
	}

	private static Student studentBearbeiten() {
		Student edit = studentWaehlen(oth);
		edit = studentenDatenAendern(edit);

		Studiengang neuFach = fachWaehlen(oth);
		edit.setStudiengang(neuFach);

		return edit;
	}

	private static void kursnotenHinzufuegen() {
		Student edit = studentWaehlen(oth);
		Kurs editKurs = kursWaehlen(edit);

		System.out.println("Bitte Note eingeben: ");
		double note = inputTester.testeDouble();
		editKurs.setNote(note);
	}

	private static void studentAusgeben() {
		Student student = studentWaehlen(oth);
		System.out.println(student.printStudentData());
		System.out.println(student.printStudentKurs());
	}

	private static Kurs kursWaehlen(Student student) {
		int i = 1;
		for (Kurs akurs : student.getStudiengang().getKurs()) {
			System.out.println(i + ". " + akurs.getName());
			i++;
		}
		System.out.println("Kurs wählen: ");
		int wahl = 0;
		do {
			wahl = inputTester.testeInt();
			if (wahl != -1 && wahl != 0 && wahl <= student.getStudiengang().anzahlKurse()) {
				break;
			} else {
				System.out.println("Fehler!");
				System.out.println("Bitte nochmals wählen: ");
			}
		} while (true);
		return student.getStudiengang().getKurs().get(wahl - 1);
	}

	private static Student studentWaehlen(Hochschule schule) {
		int i = 1;
		for (Student astudent : schule.getStudent()) {
			System.out.println(Integer.toString(i) + ". " + astudent.getNachname() + " " + astudent.getVorname()
					+ " Matrikelnummer: " + astudent.getMatrikelnummer());
			i++;
		}
		System.out.println("Studenten wählen: ");
		int wahl = 0;
		do {
			wahl = inputTester.testeInt();
			if (wahl != -1 && wahl != 0 && wahl <= schule.anzahlStudenten()) {
				break;
			} else {
				System.out.println("Fehler!");
				System.out.println("Bitte nochmals wählen: ");
			}
		} while (true);
		return schule.getStudent().get(wahl - 1);
	}

	private static Student studentenDatenAendern(Student neu) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nachname: ");
		neu.setNachname(sc.next());

		System.out.println("Vorname: ");
		neu.setVorname(sc.next());

		// System.out.println("Martikelnummer: ");
		neu.setMatrikelnummer();

		neu.setEmail();

		return neu;
	}

	private static Studiengang fachWaehlen(Hochschule schule) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Studiengang wählen: ");
		System.out.println(schule.studiengaengeAusgeben());
		int wahl = 0;
		do {
			wahl = inputTester.testeInt();
			if (wahl != -1 && wahl != 0 && wahl <= schule.anzahlStudiengaenge()) {
				break;
			} else {
				System.out.println("Fehler!");
				System.out.println("Bitte nochmals wählen: ");
			}
		} while (true);
		return schule.getStudiengang().get(wahl - 1);
	}

	public static void othInitialisieren() {

		String othName = "OTH-Regensburg";
		oth.setName(othName);

		// erster Studienabschnitt
		Kurs ds = new Kurs();
		ds.setCredits(8);
		ds.setMultiplikator(1);
		ds.setName("Datenverarbeitungssysteme");

		Kurs ti = new Kurs();
		ti.setCredits(8);
		ti.setMultiplikator(1);
		ti.setName("Theoretische Informatik");

		Kurs mi = new Kurs();
		mi.setCredits(4);
		mi.setMultiplikator(1);
		mi.setName("Medieninformatik");

		Kurs en = new Kurs();
		en.setCredits(3);
		en.setMultiplikator(0.5);
		en.setName("Englisch");

		Kurs aw1 = new Kurs();
		aw1.setCredits(2);
		aw1.setMultiplikator(0.5);
		aw1.setName("AW-Modul 1");

		Kurs bwl = new Kurs();
		bwl.setCredits(5);
		bwl.setMultiplikator(1);
		bwl.setName("Betriebswirtschaftslehre");

		Kurs pg1 = new Kurs();
		pg1.setCredits(8);
		pg1.setMultiplikator(1);
		pg1.setName("Programmieren 1");

		Kurs pg2 = new Kurs();
		pg2.setCredits(8);
		pg2.setMultiplikator(1);
		pg2.setName("Programmieren 2");

		Kurs ma1 = new Kurs();
		ma1.setCredits(7);
		ma1.setMultiplikator(1);
		ma1.setName("Mathematik 1");

		Kurs ma2 = new Kurs();
		ma2.setCredits(7);
		ma2.setMultiplikator(1);
		ma2.setName("Mathematik 2");

		// TODO: zweiten Studienabschnitt

		// Studiengang
		Studiengang informatikB = new Studiengang();
		informatikB.setName("Informatik");
		informatikB.setAbschluss("Bachelor");
		informatikB.addKurs(ds);
		informatikB.addKurs(ti);
		informatikB.addKurs(mi);
		informatikB.addKurs(en);
		informatikB.addKurs(aw1);
		informatikB.addKurs(bwl);
		informatikB.addKurs(pg1);
		informatikB.addKurs(pg2);
		informatikB.addKurs(ma1);
		informatikB.addKurs(ma2);

		oth.addStudiengang(informatikB);
	}

}
