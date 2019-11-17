package konstruktorvarianten;

public class Person {
	private String _firstName;
	private String _lastName;
	
	public Person() {
		System.out.println("Created Person");
	}
	
	public Person(String firstName) {
		this._firstName = firstName;
		System.out.println("Created Person " + this.get_firstName());
	}
	
	public Person(String firstName, String lastName) {
		this._firstName = firstName;
		this._lastName = lastName;
		System.out.println("Created Person " + this.get_firstName() + " " + this.get_lastName());
	}

	public String get_firstName() {
		return _firstName;
	}

	public void set_firstName(String _firstName) {
		this._firstName = _firstName;
	}

	public String get_lastName() {
		return _lastName;
	}

	public void set_lastName(String _lastName) {
		this._lastName = _lastName;
	}
	
}
