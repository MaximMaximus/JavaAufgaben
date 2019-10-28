
public class RomanNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// i v x L c d m
		// 1 5 10 50 100 500 1000
		int[] roman = { 1, 5, 10, 50, 100, 500, 1000 };
		String[] romanStr = { "I", "V", "X", "L", "C", "D", "M" };
		int zahl = 900;
		String ausgabe = "";

		for (int i = roman.length - 1; i >= 0; i--) {
			if (zahl == roman[i]) {
				ausgabe += romanStr[i];
				ausgabe += " ";
				zahl -= roman[i];
				i = roman.length;
			} else if (zahl > roman[i] && zahl >= (roman[i] + 1)) {
				ausgabe += romanStr[i];
				ausgabe += " ";
				zahl -= roman[i];
				i = roman.length;
			} else if (zahl == roman[i] - 1 && zahl != 0) {
				ausgabe += romanStr[0];
				ausgabe += " ";
				ausgabe += romanStr[i];
				ausgabe += " ";
				zahl += roman[0];
				zahl -= roman[i];
				i = roman.length;
			}
		}
		System.out.println(zahl);
		System.out.println(ausgabe);
	}

}
