package vogelprogramm;

public abstract class Vogel implements HasName {
	
	private String _name;
	
	public Vogel(String name) {
		this._name = name;
	}

	public abstract void singen();

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}
	
	@Override
	public String getName() {
		return HasName.sayHello + " " + this.getClass().getSimpleName() + " " + this.get_name();
	}

}
