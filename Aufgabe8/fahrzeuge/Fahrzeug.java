package fahrzeuge;

public abstract class Fahrzeug {
	private String _kennzeichen;
	private boolean _istBenziner;
	private Color _color;
	private int _ps;
	
	public Fahrzeug(String kennzeichen, boolean istBenziner, Color color, int ps) {
		this._kennzeichen = kennzeichen;
		this._istBenziner = istBenziner;
		this._color = color;
		this._ps = ps;
	}

	public String get_kennzeichen() {
		return _kennzeichen;
	}

	public void set_kennzeichen(String _kennzeichen) {
		this._kennzeichen = _kennzeichen;
	}

	public boolean is_istBenziner() {
		return _istBenziner;
	}

	public void set_istBenziner(boolean _istBenziner) {
		this._istBenziner = _istBenziner;
	}

	public Color get_color() {
		return _color;
	}

	public void set_color(Color _color) {
		this._color = _color;
	}

	public int get_ps() {
		return _ps;
	}

	public void set_ps(int _ps) {
		this._ps = _ps;
	}
	
	@Override 
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(this.getClass() != obj.getClass()) {
			return false;
		}
		
		Fahrzeug other = (Fahrzeug) obj;
		
		if(this._kennzeichen != other._kennzeichen) {
			return false;
		}
		if(this._istBenziner != other._istBenziner) {
			return false;
		}
		if(this._color != other._color) {
			return false;
		}
		if(this._ps != other._ps) {
			return false;
		}
		return true;
	}

}
