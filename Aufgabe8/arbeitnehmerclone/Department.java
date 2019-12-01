package arbeitnehmerclone;

public class Department implements Cloneable {
	private int _id;
	private String _name;
	
	public Department(int id, String name) {
		this._id = id;
		this._name = name;
	}
	
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String get_name() {
		return _name;
	}
	public void set_name(String name) {
		this._name = name;
	}
	
	public Department clone() {
		try {
			return (Department) super.clone();
		} catch (CloneNotSupportedException e) {
			
		}
		return null;
	}
	
	/*
	 * @Override public String toString() { return "\nDepartment Id: " +
	 * this.get_id() + "\nDepartment Name: " + this.get_name(); }
	 */
	
}
