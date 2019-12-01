package getraenkeautomat;

import java.util.ArrayList;
import java.util.Scanner;

public class Getraenkeautomat {
	private ArrayList<Flasche> _fach1 = new ArrayList<Flasche>();
	private ArrayList<Flasche> _fach2 = new ArrayList<Flasche>();
	private ArrayList<Flasche> _fach3 = new ArrayList<Flasche>();

	private int _10Cents = 20;
	private int _20Cents = 5;
	private int _50Cents = 0;
	private int _1Euro = 0;

	Scanner sc = new Scanner(System.in);

	public Getraenkeautomat() {
		for (int i = 0; i < 3; i++) {
			this._fach1.add(new Flasche(Sorte.COLA));
			this._fach2.add(new Flasche(Sorte.WASSER));
			this._fach3.add(new Flasche(Sorte.LIMO));
		}
	}

	public void inhaltListen() {
		if (this._fach1.isEmpty() == false) {
			System.out.println(this._fach1.get(0).get_sorte().toString());
		}
		if (this._fach2.isEmpty() == false) {
			System.out.println(this._fach2.get(0).get_sorte().toString());
		}
		if (this._fach3.isEmpty() == false) {
			System.out.println(this._fach3.get(0).get_sorte().toString());
		}
	}

	public void getaenkWaehlen() {
		ArrayList wahlFach = null;
		Flasche flasche = null;

		while (true) {
			System.out.println("Getränk wählen: ");
			int wahl = this.sc.nextInt();

			if (this._fach1.isEmpty() == false) {
				flasche = this._fach1.get(0);
				if (wahl == flasche.get_sorte().get_id()) {
					wahlFach = this._fach1;
					break;
				}
			}
			if (this._fach2.isEmpty() == false) {
				flasche = this._fach2.get(0);
				if (wahl == flasche.get_sorte().get_id()) {
					wahlFach = this._fach2;
					break;
				}
			}
			if (this._fach3.isEmpty() == false) {
				flasche = this._fach3.get(0);
				if (wahl == flasche.get_sorte().get_id()) {
					wahlFach = this._fach3;
					break;
				}
			}
			if (wahlFach == null) {
				System.out.println("Ungültige Eingabe!");
				System.out.println("Neu wählen:");
			}
		}

		int preis = flasche.get_sorte().get_preis();
		System.out.println("Das gewählte Getränk kostet " + preis + " Cent");
		System.out.println("Bitte werfen Sie eine Münze ein(10=10 Cent, 20=20 Cent, 50=50 Cent, 100=1 €)");
		while (preis > 0) {
			System.out.println("Restbetrag: " + preis);
			System.out.println("Geld einwerfen:");
			int eingabe = this.sc.nextInt();
			if (eingabe == 10 || eingabe == 20 || eingabe == 50 || eingabe == 100) {
				if (eingabe == 10) {
					this._10Cents++;
				}
				if (eingabe == 20) {
					this._20Cents++;
				}
				if (eingabe == 50) {
					this._50Cents++;
				}
				if (eingabe == 100) {
					this._1Euro++;
				}
				preis -= eingabe;
			} else {
				System.out.println("Ungültige Eingabe");
			}
		}
		if (preis < 0) {
			preis *= -1;
			System.out.println("Wechselgeld: " + preis);
			while (preis >= 20 && this._20Cents > 0) {
				this._20Cents--;
				preis -= 20;
				System.out.println("20 Cent zurück");
			}
			while (preis >= 10 && this._10Cents > 0) {
				this._10Cents--;
				preis -= 10;
				System.out.println("10 Cent zurück");
			}
			if (preis > 0) {
				System.out.println("Wechselgeld von " + preis + " Cent nicht vorhanden!");
			}
		}
		wahlFach.remove(flasche);
	}

	public void bericht() {
		System.out.println("Inhalt:");
		System.out.println("Fach 1: " + this._fach1);
		System.out.println("Fach 2: " + this._fach2);
		System.out.println("Fach 3: " + this._fach3);
		System.out.println("10 Cent Münzen: " + this._10Cents);
		System.out.println("20 Cent Münzen: " + this._20Cents);
		System.out.println("50 Cent Münzen: " + this._50Cents);
		System.out.println("1 Euro Münzen: " + this._1Euro);
	}
}
