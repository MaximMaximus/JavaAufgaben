package schneckenrennen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rennen {

	private List<Rennschnecke> schnecken;
	private String name;
	private Status status;
	private int strecke;

	public Rennen(String name, int strecke) {
		this.schnecken = new ArrayList<Rennschnecke>();
		this.name = name;
		this.status = Status.WarteAufTeilnehmer;
		this.strecke = strecke;
	}

	public List<Rennschnecke> getSchnecken() {
		return schnecken;
	}

	public String getName() {
		return name;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStrecke(int strecke) {
		if (this.status == Status.WarteAufTeilnehmer) {
			this.strecke = strecke;
		}
	}

	public void addSchnecke(Rennschnecke schnecke) {
		if (this.status == Status.WarteAufTeilnehmer && !this.schnecken.contains(schnecke)) {
			this.schnecken.add(schnecke);
		}
	}

	public void removeSchnecke(Rennschnecke schnecke) {
		if (this.status == Status.WarteAufTeilnehmer) {
			this.schnecken.remove(schnecke);
		}
	}

	public void start() {
		this.status = Status.Laufend;
		boolean goOn = true;

		while (goOn) {
			goOn = false;
			for (Rennschnecke r : this.schnecken) {
				if (r.getStrecke() < this.strecke) {
					r.kriechen();
					goOn = true;
				}
			}
		}
		Collections.sort(this.schnecken);
		for (int i = 0; i < this.schnecken.size(); i++) {
			this.schnecken.get(i).setPlatzierung(i + 1);
		}
		this.status = Status.Beendet;
	}

	@Override
	public String toString() {
		String ret = String.format("Ergebnisse für Rennen %s, zurückzulegende Strecke: %d :\n--- Status: %s\n",
				this.name, this.strecke, this.status);

		for (Rennschnecke r : this.schnecken) {
			ret += r.toString() + "\n";
		}
		return ret;
	}
}
