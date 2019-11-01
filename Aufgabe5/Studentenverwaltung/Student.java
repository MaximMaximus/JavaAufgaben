package Studentenverwaltung;

import java.util.Scanner;

public class Student {
	private String name;
	private String vorname;
	private int matrikelnummer;
	private String email;
	private Studiengang studiengang;

	EingabeTester inputTester = new EingabeTester();

	public String getNachname() {
		return name;
	}

	public void setNachname(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public int getMatrikelnummer() {
		return matrikelnummer;
	}

	public void setMatrikelnummer(int nummer) {
		this.matrikelnummer = nummer;
	}

	public void setMatrikelnummer() {
		Scanner sc = new Scanner(System.in);
		int input = 0;
		System.out.println("Matrikelnummer (7 Zahlen): ");
		do {
			input = inputTester.testeInt();
			if (Integer.toString(input).length() == 7) {
				break;
			} else {
				System.out.println("Ungültige Eingabe!");
			}
		} while (true);
		this.matrikelnummer = input;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail() {
		String email = new String();
		email += this.getVorname().toLowerCase();
		email += ".";
		email += this.getNachname().toLowerCase();
		email += "@st.oth-regensburg.de";
		this.email = email;
	}

	public Studiengang getStudiengang() {
		return studiengang;
	}

	public void setStudiengang(Studiengang studiengang) {
		this.studiengang = studiengang;
	}

	public String printStudentData() {
		return "Name des Studierenden: " + this.getVorname() + " " + this.getNachname() + "\n"
				+ "(angestrebter) Abschluss: " + this.getStudiengang().getAbschluss() + "\n" + "Fach: "
				+ this.getStudiengang().getName() + "\n" + "Matrikelnummer: " + this.getMatrikelnummer() + "\n"
				+ "E-Mail: " + this.getEmail() + "\n";
	}

	public String printStudentKurs() {
		return this.getVorname() + " " + this.getNachname() + "\n" + " -- Pruefungen --\n"
				+ this.getStudiengang().getData() + "\n" + "Notendurchschnitt: " + this.getDurchschnitt() + "\n";
	}

	public double getDurchschnitt() {
		double anzahl = 0;
		double note = 0;

		for (Kurs akurs : this.getStudiengang().getKurs()) {
			if (akurs.getNote() != 0) {
				//System.out.println("Note: " + akurs.getNote() + " Multi: " + akurs.getMultiplikator());
				note += (akurs.getNote() * akurs.getMultiplikator() * akurs.getCredits());
				anzahl += (akurs.getMultiplikator() * akurs.getCredits());
			}
		}
		//System.out.println("Note: " + note + " Anzahl: " + anzahl);
		return (note / anzahl);
	}

}
