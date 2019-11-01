package Studentenverwaltung;

import java.util.ArrayList;
import java.util.List;

public class Hochschule {

	private String name;
	private List<Studiengang> studiengang = new ArrayList<Studiengang>();
	private List<Student> student = new ArrayList<Student>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Studiengang> getStudiengang() {
		return studiengang;
	}

	public void setStudiengang(List<Studiengang> studiengang) {
		this.studiengang = studiengang;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	public void addStudent(Student astudent) {
		this.student.add(astudent);
	}

	public void addStudiengang(Studiengang astudiengang) {
		this.studiengang.add(astudiengang);
	}

	public String studentenAusgeben() {
		String data = "";
		for (Student astudent : this.student) {
			data += astudent.printStudentData() + "\n-- --\n";
		}
		return data;
	}

	public String studentenKomplettAusgeben() {
		String data = "";
		for (Student astudent : this.student) {
			data += astudent.printStudentData() + astudent.printStudentKurs() + "\n-- --\n";
		}
		return data;
	}

	public String studiengaengeAusgeben() {
		String data = "";
		int i = 1;
		for (Studiengang afach : this.getStudiengang()) {
			data += Integer.toString(i) + ". " + afach.getName() + " (" + afach.getAbschluss() + ")";
			i++;
		}
		return data;
	}
	
	public int anzahlStudiengaenge() {
		int summe = 0;
		for(Studiengang gang : this.getStudiengang()) {
			summe++;
		}
		return summe;
	}
	
	public int anzahlStudenten() {
		int summe = 0;
		for(Student astudent : this.getStudent()) {
			summe++;
		}
		return summe;
	}

}
