package fahrzeuge;

public class LKW extends Fahrzeug {

	private int _anzahlReifen;
	private int _ladeGewicht;

	public LKW(String kennzeichen, boolean istBenziner, Color color, int ps, int anzahlReifen, int ladeGewicht) {
		super(kennzeichen, istBenziner, color, ps);
		this._anzahlReifen = anzahlReifen;
		this._ladeGewicht = ladeGewicht;
	}

	public int get_anzahlReifen() {
		return _anzahlReifen;
	}

	public void set_anzahlReifen(int _anzahlReifen) {
		this._anzahlReifen = _anzahlReifen;
	}

	public int get_ladeGewicht() {
		return _ladeGewicht;
	}

	public void set_ladeGewicht(int _ladeGewicht) {
		this._ladeGewicht = _ladeGewicht;
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj) == false) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		LKW other = (LKW) obj;
		if (this.get_ladeGewicht() != other.get_ladeGewicht()) {
			return false;
		}
		if (this.get_anzahlReifen() != other.get_anzahlReifen()) {
			return false;
		}
		return true;
	}

}
