package schneckenrennen;

import java.util.Random;

public class Rennschnecke implements Comparable<Rennschnecke> {

	private static Random r = new Random();

	private String name;
	private int startnummer;
	private int speed;
	private int platzierung;
	private int zeit;
	private int strecke;

	public Rennschnecke(String name, int startnummer, int speed) {
		this.name = name;
		this.startnummer = startnummer;
		this.speed = speed;
		this.platzierung = 0;
		this.strecke = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStartnummer() {
		return startnummer;
	}

	public void setStartnummer(int startnummer) {
		this.startnummer = startnummer;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getPlatzierung() {
		return platzierung;
	}

	public void setPlatzierung(int platzierung) {
		this.platzierung = platzierung;
	}

	public int getZeit() {
		return zeit;
	}

	public int getStrecke() {
		return strecke;
	}

	public void kriechen() {
		this.strecke += r.nextInt(this.speed + 1);
		this.zeit++;
	}

	public void zumZiel(int strecke) {
		while (this.strecke < strecke) {
			kriechen();
		}
	}

	@Override
	public String toString() {
		return String.format("Platz %d, Startnummer: %d, Name: %s, Geschwindigkeit: %d, benötigte Zeit: %d",
				this.platzierung, this.startnummer, this.name, this.speed, this.zeit);
	}

	@Override
	public int compareTo(Rennschnecke o) {
		return this.getZeit() - o.getZeit();
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Rennschnecke)) {
			return false;
		}
		Rennschnecke other = (Rennschnecke) o;
		if (other.getStartnummer() != this.getStartnummer()) {
			return false;
		}
		return true;
	}

}
