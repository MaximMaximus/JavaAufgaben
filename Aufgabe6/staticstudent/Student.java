package staticstudent;

public class Student {
	private String _firstName;
	private String _lastName;
	private int id;
	
	private static int static_id = 1;
	
	public Student() {
		this._firstName = "";
		this._lastName = "";
		this.setId(Student.static_id);
		
		Student.static_id++;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
