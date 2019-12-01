package fahrzeuge;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// LKW(String kennzeichen, boolean istBenziner, Color color, int ps, int
		// anzahlReifen, int ladeGewicht)
		PKW pkw1 = new PKW("Auto1", false, Color.RED, 20, 20, 20);
		PKW pkw2 = new PKW("Auto2", false, Color.RED, 20, 20, 20);
		PKW pkw3 = new PKW("Auto3", false, Color.RED, 22, 20, 20);

		if (pkw1.equals(pkw2)) {
			System.out.println(
					"Die Autos " + pkw1.get_kennzeichen() + " und " + pkw2.get_kennzeichen() + " sind gleich.");
		} else {
			System.out.println(
					"Die Autos " + pkw1.get_kennzeichen() + " und " + pkw2.get_kennzeichen() + " sind nicht gleich.");
		}
		
		if (pkw1.equals(pkw3)) {
			System.out.println(
					"Die Autos " + pkw1.get_kennzeichen() + " und " + pkw3.get_kennzeichen() + " sind gleich.");
		} else {
			System.out.println(
					"Die Autos " + pkw1.get_kennzeichen() + " und " + pkw3.get_kennzeichen() + " sind nicht gleich.");
		}
		
		List<LKW> lkws = new ArrayList<LKW> ();
		//public LKW(String kennzeichen, boolean istBenziner, Color color, int ps, int anzahlReifen, int ladeGewicht)
		LKW lkw1 = new LKW("LKW1", true, Color.RED, 20, 20, 20);
		lkws.add(lkw1);
		LKW lkw2 = new LKW("LKW2", true, Color.RED, 22, 20, 20);
		lkws.add(lkw2);
		LKW lkw3 = new LKW("LKW3", true, Color.RED, 20, 20, 20);
		
		if(lkws.contains(lkw3)) {
			System.out.println(lkw3.get_kennzeichen() + " gibt es schon");
		}
		
		System.out.println("Auto suche");
		List<Fahrzeug> gestohlen = new ArrayList<Fahrzeug>();
		gestohlen.add(pkw1);
		gestohlen.add(lkw1);
		
		PKW pkwgesucht = new PKW("Auto1", false, Color.RED, 20, 20, 20);
		LKW lkwgesucht = new LKW("LKW1", true, Color.RED, 20, 20, 20);
		
		if(gestohlen.contains(pkwgesucht)) {
			System.out.println(pkwgesucht.get_kennzeichen() + " als gestohlen gemeldet");
		}
		if(gestohlen.contains(lkwgesucht)) {
			System.out.println(lkwgesucht.get_kennzeichen() + " als gestohlen gemeldet");
		}
		
	}

}
