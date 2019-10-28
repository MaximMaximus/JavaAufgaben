import java.util.Scanner;

public class Schleife {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max = 30;
		int div = 9;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Bitte geben Sie einen maximalen Wert: ");
			max = sc.nextInt();
		} while (max <= 0);

		do {
			System.out.println("Bitte geben Sie einen Teiler ein: ");
			div = sc.nextInt();
		} while (div <= 0);

		System.out.println("Die Teiler ohne Rest bis zum maximalen Wert sind: ");

		for (int i = 0; i <= max; i++) {
			if (i % div == 0) {
				System.out.println(i);
			}
		}

		sc.close();
	}

}
