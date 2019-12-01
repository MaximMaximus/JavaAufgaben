package getraenkeautomat;

public class Flasche {
	private Sorte _sorte;
	
	public Flasche(Sorte sorte) {
		this._sorte = sorte;
	}

	public Sorte get_sorte() {
		return _sorte;
	}

	public void set_sorte(Sorte _sorte) {
		this._sorte = _sorte;
	}
	
	public String toString() {
		return this.get_sorte().get_marke();
	}

}
