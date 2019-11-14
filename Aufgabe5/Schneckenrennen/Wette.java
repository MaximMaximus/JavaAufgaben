package schneckenrennen;

public class Wette {

	private String spieler;
	private Rennen rennen;
	private Rennschnecke schnecke;
	private int einsatz;
	private boolean gewonnen;
	private int gewinn;

	public Wette(String spieler, Rennen rennen, Rennschnecke schnecke, int einsatz) {
		this.spieler = spieler;
		this.rennen = rennen;
		this.schnecke = schnecke;
		this.einsatz = einsatz;
		this.gewonnen = false;
		this.gewinn = 0;
	}

	public String getSpieler() {
		return spieler;
	}

	public void setSpieler(String spieler) {
		this.spieler = spieler;
	}

	public Rennen getRennen() {
		return rennen;
	}

	public void setRennen(Rennen rennen) {
		this.rennen = rennen;
	}

	public Rennschnecke getSchnecke() {
		return schnecke;
	}

	public void setSchnecke(Rennschnecke schnecke) {
		this.schnecke = schnecke;
	}

	public int getEinsatz() {
		return einsatz;
	}

	public void setEinsatz(int einsatz) {
		this.einsatz = einsatz;
	}

	public void setErgebnis() {
		this.gewonnen = this.rennen.getSchnecken().get(0).equals(this.schnecke);
		if (this.gewonnen) {
			this.gewinn = this.einsatz * Wettbuero.getQuote();
		}
	}

	public boolean isGewonnen() {
		return this.gewonnen;
	}

	@Override
	public String toString() {
		if (this.rennen.getStatus() == Status.Beendet) {
			return String.format("Wette von Spieler %s für Rennen %s auf Rennschnecke #%d, Gewonnen %s, Gewinn: %d",
					this.spieler, this.rennen.getName(), this.schnecke.getStartnummer(),
					(this.gewonnen ? "ja" : "nein"), this.gewinn);
		} else {
			return String.format("Wette von Spieler %s, Rennen %s ist noch nicht beendet", this.spieler,
					this.rennen.getName());
		}
	}
}
