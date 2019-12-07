package enumeinfach;

public class Arbeitnehmer {

	private String _name;
	private String _vorname;
	private Aufgabe _aufgabe;
	
	public Arbeitnehmer(String name, String vorname, Aufgabe aufgabe) {
		this._name = name;
		this._vorname = vorname;
		this._aufgabe = aufgabe;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public String get_vorname() {
		return _vorname;
	}

	public void set_vorname(String _vorname) {
		this._vorname = _vorname;
	}

	public Aufgabe get_aufgabe() {
		return _aufgabe;
	}

	public void set_aufgabe(Aufgabe _aufgabe) {
		this._aufgabe = _aufgabe;
	}

	@Override
	public String toString() {
		return "Arbeitnehmer [_name=" + _name + ", _vorname=" + _vorname + ", _aufgabe=" + _aufgabe + "]";
	}
	
	
}
