package Studentenverwaltung;

import java.util.ArrayList;
import java.util.List;

public class Studiengang {
	private String name;
	private String abschluss;
	private List<Kurs> kurs = new ArrayList<Kurs>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbschluss() {
		return abschluss;
	}

	public void setAbschluss(String abschluss) {
		this.abschluss = abschluss;
	}

	public List<Kurs> getKurs() {
		return kurs;
	}

	public void setKurs(List<Kurs> kurs) {
		this.kurs = kurs;
	}

	public void addKurs(Kurs mykurs) {
		this.kurs.add(mykurs);
	}

	public String getAllKurse() {
		String data = "";
		int i = 0;
		System.out.println("Fächer Studiengang: " + this.getName() + "\n");
		for (Kurs akurs : this.kurs) {
			data += i + " " + akurs.getName() + "\nCredits: " + akurs.getCredits() + "\nMultiplikator: "
					+ akurs.getMultiplikator() + "\n---\n";
			i++;
		}
		return data;
	}

	public String getData() {
		String data = "";
		for (Kurs einkurs : this.kurs) {
			if (einkurs.getNote() != 0) {
				data += einkurs.getKursData() + "\n-- --\n";
			}
		}
		return data;
	}

	public int anzahlKurse() {
		int summe = 0;
		for (Kurs akurs : this.getKurs()) {
			summe++;
		}
		return summe;
	}

}
