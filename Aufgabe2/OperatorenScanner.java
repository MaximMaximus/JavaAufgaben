import java.util.Scanner;

public class OperatorenScanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float zahl1 = 0f;
		float zahl2 = 0f;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Bitte geben Sie die erste Zahl ein: ");
		zahl1 = sc.nextFloat();
		System.out.println("Bitte geben Sie die zweite Zahl ein: ");
		zahl2 = sc.nextFloat();
		

		System.out.println("+-/*");
		System.out.println("Erste Zahl: " + zahl1);
		System.out.println("Zwiete Zahl: " + zahl2);
		System.out.println("Addition: " + zahl1 + " + " + zahl2 + " = " + (zahl1 + zahl2));
		System.out.println("Subtraktion: " + zahl1 + " - " + zahl2 + " = " + (zahl1 - zahl2));
		System.out.println("Division: " + zahl1 + " / " + zahl2 + " = " + (zahl1 / zahl2));
		System.out.println("Multiplikation: " + zahl1 + " * " + zahl2 + " = " + (zahl1 * zahl2));
		
		sc.close();
	}

}
