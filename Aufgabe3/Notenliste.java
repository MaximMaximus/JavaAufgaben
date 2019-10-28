import java.util.Arrays;
import java.util.Scanner;

public class Notenliste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] students = new String[0][2];
		int studentCounter = 0;
		boolean addAnotherStudent;
		Scanner sc = new Scanner(System.in);
		
		do {
			students = Arrays.copyOf(students, students.length + 1);
			students[studentCounter] = new String[2];
			System.out.println("Name: ");
			students[studentCounter][0] = sc.nextLine();
			System.out.println("Note: ");
			while (true) {
				int grade = sc.nextInt();
				if(grade > 0 && grade <7) {
					students[studentCounter][1] = Integer.toString(grade);
					break;
				} else {
					System.out.println("Bitte eine Note im Bereich zwischen 1 und 6 eingeben.");
				}
			}
			studentCounter++;
			System.out.println("Weiteren Kursstudenten erfassen (0/1)? ");
			addAnotherStudent = (sc.nextInt() == 1);
			sc.nextLine();
		} while(addAnotherStudent);
		
		for (int i = 0; i < students.length; i++) {
			System.out.println(String.format("%d. %s: %d", i + 1, students[i][0], Integer.parseInt(students[i][1])));
		}
		sc.close();
	}

}
