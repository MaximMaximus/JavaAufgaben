package schneckenrennen;

public class Main {

	public static void main(String[] args) {
		Rennschnecke rs1 = new Rennschnecke("Nummer 1", 1, 11);
		Rennschnecke rs2 = new Rennschnecke("Nummer 2", 2, 15);
		Rennschnecke rs3 = new Rennschnecke("Nummer 3", 3, 14);
		Rennschnecke rs4 = new Rennschnecke("Nummer 4", 4, 11);
		Rennschnecke rs5 = new Rennschnecke("Nummer 5", 5, 12);
		Rennschnecke rs6 = new Rennschnecke("Nummer 6", 6, 14);
		Rennschnecke rs7 = new Rennschnecke("Nummer 7", 7, 15);
		
		Rennen r1 = new Rennen("Rennen 1", 200);
		r1.addSchnecke(rs1);
		r1.addSchnecke(rs2);
		r1.addSchnecke(rs3);
		r1.addSchnecke(rs4);
		r1.addSchnecke(rs5);
		r1.addSchnecke(rs6);
		r1.addSchnecke(rs7);
		
		Wettbuero w = new Wettbuero();
		w.addRennen(r1);
		
		Wette w1 = new Wette("Spieler 1", r1, rs1, 100);
		Wette w2 = new Wette("Spieler 2", r1, rs2, 50);
		Wette w3 = new Wette("Spieler 3", r1, rs3, 130);
		
		w.wetteAnnehmen(w1);
		w.wetteAnnehmen(w2);
		w.wetteAnnehmen(w3);
		
		w.start();
		
		w.ergebnisseErmitteln();
		
		System.out.println(r1);
		System.out.println(w);

	}

}
