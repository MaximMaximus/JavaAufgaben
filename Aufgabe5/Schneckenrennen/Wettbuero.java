package schneckenrennen;

import java.util.ArrayList;
import java.util.List;

public class Wettbuero {
	private ArrayList<Wette> wetten;
	private ArrayList<Rennen> rennen;
	private static int qoute = 2;
	
	public Wettbuero() {
		this.wetten = new ArrayList<Wette>();
		this.rennen = new ArrayList<Rennen>();
	}
	
	public void wetteAnnehmen(Wette wette) {
		if(wette.getRennen().getStatus() == Status.WarteAufTeilnehmer) {
			this.wetten.add(wette);
		}
	}
	
	public void addRennen(Rennen rennen) {
		this.rennen.add(rennen);
	}
	
	public void start() {
		for(Rennen r: this.rennen) {
			if(r.getStatus() == Status.WarteAufTeilnehmer) {
				r.start();
			}
		}
	}
	
	public void ergebnisseErmitteln() {
		for(Wette w: this.wetten) {
			if(w.getRennen().getStatus() == Status.Beendet) {
				w.setErgebnis();
			}
		}
	}
	
	public static int getQuote() {
		return Wettbuero.qoute;
	}
	
	@Override
	public String toString() {
		String ret = "Wettergebnisse:\n";
		for(Wette w: this.wetten) {
			ret += w.toString() + "\n";
		}
		return ret;
	}

}
