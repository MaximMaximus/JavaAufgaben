
public class Zahlensystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int zahl = 10;
		String bin = "";
		String hex = "";
		
		bin = Integer.toBinaryString(zahl);
		hex = Integer.toHexString(zahl);
		
		System.out.println("Bin: " + bin);
		System.out.println("Hex: " + hex);
		
	}

}
