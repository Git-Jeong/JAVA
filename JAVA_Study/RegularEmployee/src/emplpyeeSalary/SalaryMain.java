package emplpyeeSalary;

public class SalaryMain {
	public static void main(String[] args) {

		PartTimeEmployee p = new PartTimeEmployee("p4321", "JeongJIn", 1000, 30); 
		RagularEmplpyee e = new RagularEmplpyee("e1234", "JeongJIn", 1000, 30); 
		TempEmployee t = new TempEmployee("t1234", "JeongJIn", 1000); 
		
		printInfo(p);
		printInfo(e);
		printInfo(t);
	}
	
	private static void printInfo(Employee e) {
		System.out.println(e.printInfoAll());
	}
}
