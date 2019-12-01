package fahrzeuge;

public class PKW extends Fahrzeug {

	private int _anzahlTueren;
	private int _anzahlSitzplaetze;

	public PKW(String kennzeichen, boolean istBenziner, Color color, int ps, int anzahlTueren, int anzahlSitzplaetze) {
		super(kennzeichen, istBenziner, color, ps);
		this._anzahlTueren = anzahlTueren;
		this._anzahlSitzplaetze = anzahlSitzplaetze;
	}

	public int get_anzahlTueren() {
		return _anzahlTueren;
	}

	public void set_anzahlTueren(int _anzahlTueren) {
		this._anzahlTueren = _anzahlTueren;
	}

	public int get_anzahlSitzplaetze() {
		return _anzahlSitzplaetze;
	}

	public void set_anzahlSitzplaetze(int _anzahlSitzplaetze) {
		this._anzahlSitzplaetze = _anzahlSitzplaetze;
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj) == false) {
			return false;
		}
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PKW other = (PKW) obj;
		if (this.get_ps() != other.get_ps()) {
			return false;
		}
		if (this.get_color() != other.get_color()) {
			return false;
		}
		if (_anzahlSitzplaetze != other._anzahlSitzplaetze) {
			return false;
		}
		if (_anzahlTueren != other._anzahlTueren) {
			return false;
		}
		return true;
	}

}
