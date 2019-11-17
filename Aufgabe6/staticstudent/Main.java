package staticstudent;

public class Main {

	public static void main(String[] args) {
		
		Student tomStudent = new Student();
		tomStudent.set_firstName("Tom");
		tomStudent.set_lastName("Teuer");
		System.out.println(tomStudent.get_firstName() + " : " + tomStudent.getId());
		
		Student reginaStudent = new Student();
		reginaStudent.set_firstName("Regina");
		reginaStudent.set_lastName("Reich");
		System.out.println(reginaStudent.get_firstName() + " : " + reginaStudent.getId());
		
		Student leaStudent = new Student();
		leaStudent.set_firstName("Lea");
		leaStudent.set_lastName("Lustig");
		System.out.println(leaStudent.get_firstName() + " : " + leaStudent.getId());

	}

}
