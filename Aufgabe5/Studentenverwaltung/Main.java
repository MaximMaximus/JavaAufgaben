package Studentenverwaltung;

import java.util.Scanner;

public class Main {

	public static Hochschule oth = new Hochschule();
	static EingabeTester inputTester = new EingabeTester();

	public static void main(String[] args) {
		
		// Alte Version
		// Hochschule erstellen und mit daten füllen
		// othInitialisieren();
		
		// Alle Fächer ausgeben
		 Studiengang info = informatikBachelorInitialisieren();
		 System.out.println(info.getAllKurse());
		
		// Variablen
		Scanner sc = new Scanner(System.in);
		int wahl = 0;
		int ende = 8;
		
		// OTH Name und Studiengänge hinzufügen
		String othName = "OTH-Regensburg";
		oth.setName(othName);
		oth.addStudiengang(informatikBachelorInitialisieren());

		// Teststudent
		Student max = new Student();
		max.setVorname("Max");
		max.setNachname("Mustermann");
		max.setMatrikelnummer(1234567);
		max.setStudiengang(informatikBachelorInitialisieren());
		max.setEmail();

		oth.addStudent(max);
		
		
		// erster Studienabschnitt
		max.getStudiengang().getKurs().get(0).setNote(0);
		max.getStudiengang().getKurs().get(1).setNote(3.3);
		max.getStudiengang().getKurs().get(2).setNote(0);
		max.getStudiengang().getKurs().get(3).setNote(2);
		max.getStudiengang().getKurs().get(4).setNote(1);
		max.getStudiengang().getKurs().get(5).setNote(1.7);
		max.getStudiengang().getKurs().get(6).setNote(2);
		max.getStudiengang().getKurs().get(7).setNote(0);
		max.getStudiengang().getKurs().get(8).setNote(3.3);
		max.getStudiengang().getKurs().get(9).setNote(0);

		// zweiter Studienabschnitt

		// dritter Studienabschnitt
		
		System.out.println(max.printStudentData());
		System.out.println(max.printStudentKurs());
		
		// Teststudent
		Student anna = new Student();
		anna.setVorname("Anna");
		anna.setNachname("Hanna");
		anna.setMatrikelnummer(7654321);
		anna.setStudiengang(informatikBachelorInitialisieren());
		anna.setEmail();

		oth.addStudent(anna);

		anna.getStudiengang().getKurs().get(3).setNote(1);
		anna.getStudiengang().getKurs().get(5).setNote(1);
		anna.getStudiengang().getKurs().get(6).setNote(1);
		
		System.out.println(anna.printStudentData());
		System.out.println(anna.printStudentKurs());

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
		Studiengang temp = new Studiengang();
		boolean eingabe = false;
		do {
			System.out.println("Studiengang wählen: ");
			System.out.println(schule.studiengaengeAusgeben());
			int wahl = 0;
			wahl = inputTester.testeInt();
			switch (wahl) {
			case 1:
				temp = informatikBachelorInitialisieren();
				eingabe = true;
				break;
			default:
				System.out.println("Ungültige Eingabe!");
				break;
			}
		} while (eingabe == false);
		return temp;
	}

	public static Studiengang informatikBachelorInitialisieren() {

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

		// zweiten Studienabschnitt
		Kurs ad = new Kurs();
		ad.setCredits(8);
		ad.setMultiplikator(2);
		ad.setName("Algorithmen und Datenstrukturen");

		Kurs db = new Kurs();
		db.setCredits(7);
		db.setMultiplikator(2);
		db.setName("Datenbanken");

		Kurs st = new Kurs();
		st.setCredits(5);
		st.setMultiplikator(2);
		st.setName("Statistik");

		Kurs os = new Kurs();
		os.setCredits(8);
		os.setMultiplikator(2);
		os.setName("Betriebssysteme");

		Kurs cr = new Kurs();
		cr.setCredits(5);
		cr.setMultiplikator(2);
		cr.setName("Computerarithmetik und Rechenverfahren");

		Kurs rt = new Kurs();
		rt.setCredits(7);
		rt.setMultiplikator(2);
		rt.setName("Rechnertechnik");

		Kurs se = new Kurs();
		se.setCredits(8);
		se.setMultiplikator(2);
		se.setName("Software Engineering");

		Kurs ks = new Kurs();
		ks.setCredits(7);
		ks.setMultiplikator(2);
		ks.setName("Kommunikationssysteme");

		Kurs fw1 = new Kurs();
		fw1.setCredits(5);
		fw1.setMultiplikator(2);
		fw1.setName("Fachbezogenes Wahlpflichtmodul 1");

		Kurs aw2 = new Kurs();
		aw2.setCredits(2);
		aw2.setMultiplikator(0.5);
		aw2.setName("AW-Modul 2");

		Kurs aw3 = new Kurs();
		aw3.setCredits(2);
		aw3.setMultiplikator(0.5);
		aw3.setName("AW-Modul 3");

		// TODO: Praxisseminar und Praktikum nach modulhandbuch ohne Notengewichtung
		Kurs ps = new Kurs();
		ps.setCredits(2);
		ps.setMultiplikator(1);
		ps.setName("Praxisseminar");
		
		Kurs pr = new Kurs();
		pr.setCredits(24);
		pr.setMultiplikator(1);
		pr.setName("Praktikum");
		
		// dritter Studienabschnitt
		Kurs vm1 = new Kurs();
		vm1.setCredits(5);
		vm1.setMultiplikator(2);
		vm1.setName("Vertiefungsmodul IN 1/1");

		Kurs vm2 = new Kurs();
		vm2.setCredits(5);
		vm2.setMultiplikator(2);
		vm2.setName("Vertiefungsmodul IN 1/2");

		Kurs vm3 = new Kurs();
		vm3.setCredits(5);
		vm3.setMultiplikator(2);
		vm3.setName("Vertiefungsmodul IN 1/3");

		Kurs vm4 = new Kurs();
		vm4.setCredits(5);
		vm4.setMultiplikator(2);
		vm4.setName("Vertiefungsmodul IN 2/1");

		Kurs vm5 = new Kurs();
		vm5.setCredits(5);
		vm5.setMultiplikator(2);
		vm5.setName("Vertiefungsmodul IN 2/2");

		Kurs vm6 = new Kurs();
		vm6.setCredits(5);
		vm6.setMultiplikator(2);
		vm6.setName("Vertiefungsmodul IN 2/3");

		Kurs or = new Kurs();
		or.setCredits(5);
		or.setMultiplikator(2);
		or.setName("Operations Research");

		Kurs fw2 = new Kurs();
		fw2.setCredits(5);
		fw2.setMultiplikator(2);
		fw2.setName("Fachbezogenes Wahlpflichtmodul 2");

		Kurs fw3 = new Kurs();
		fw3.setCredits(5);
		fw3.setMultiplikator(2);
		fw3.setName("Fachbezogenes Wahlpflichtmodul 3");

		Kurs ba = new Kurs();
		ba.setCredits(12);
		ba.setMultiplikator(6);
		ba.setName("Bachelorarbeit");

		// TODO: Bachelorseminar Notengewihtung
		Kurs bs = new Kurs();
		ba.setCredits(3);
		ba.setMultiplikator(1);
		ba.setName("Bachelorseminar");

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
		informatikB.addKurs(ad);
		informatikB.addKurs(db);
		informatikB.addKurs(st);
		informatikB.addKurs(os);
		informatikB.addKurs(cr);
		informatikB.addKurs(rt);
		informatikB.addKurs(se);
		informatikB.addKurs(ks);
		informatikB.addKurs(fw1);
		informatikB.addKurs(aw2);
		informatikB.addKurs(aw3);
		informatikB.addKurs(ps);
		informatikB.addKurs(pr);
		informatikB.addKurs(vm1);
		informatikB.addKurs(vm2);
		informatikB.addKurs(vm3);
		informatikB.addKurs(vm4);
		informatikB.addKurs(vm5);
		informatikB.addKurs(vm6);
		informatikB.addKurs(or);
		informatikB.addKurs(fw2);
		informatikB.addKurs(fw3);
		informatikB.addKurs(ba);
		informatikB.addKurs(bs);

		return informatikB;
	}

}
