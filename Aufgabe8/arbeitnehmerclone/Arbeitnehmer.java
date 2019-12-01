package arbeitnehmerclone;

public class Arbeitnehmer implements Cloneable {
	private int _employeeId;
	private String _employeeName;
	private Department _department;
	
	public Arbeitnehmer(int id, String name, Department de) {
		this._employeeId = id;
		this._employeeName = name;
		this._department = de;
	}
	
	public int get_employeeId() {
		return _employeeId;
	}
	public void set_employeeId(int _employeeId) {
		this._employeeId = _employeeId;
	}
	public String get_employeeName() {
		return _employeeName;
	}
	public void set_employeeName(String employeeName) {
		this._employeeName = employeeName;
	}
	public Department get_department() {
		return _department;
	}
	public void set_department(Department _department) {
		this._department = _department;
	}
	
	public Arbeitnehmer clone() {
		try {
			Arbeitnehmer copy = (Arbeitnehmer) super.clone();
			copy._department = (Department) copy._department.clone();
			return copy;
		} catch (CloneNotSupportedException e) {
			
		}
		return null;
	}
	
	/*
	 * @Override public String toString() { return "Arbeitnehmer Id: " +
	 * this.get_employeeId() + "\nArbeitnehmer Name: " + this.get_employeeName() +
	 * "\nDepartment: " + this.get_department().toString(); }
	 */
}
