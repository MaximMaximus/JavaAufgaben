package Studentenverwaltung;

public class Kurs {

	private String name;
	private double note;
	private double multiplikator;
	private int credits;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public double getMultiplikator() {
		return multiplikator;
	}

	public void setMultiplikator(double multiplikator) {
		this.multiplikator = multiplikator;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getKursData() {
		return "Name: " + this.getName() + "\n" + "Credit: " + this.getCredits() + "\n" + "Multiplikator: "
				+ this.getMultiplikator() + "\n" + "Note: " + this.getNote();
	}

}
