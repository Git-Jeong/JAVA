package emplpyeeSalary;

public class PartTimeEmployee extends Employee { 
	private int worktime;
	
	public PartTimeEmployee(String empno, String name, int pay, int worktime) {
	    super();
		this.empno = empno;
		this.name = name;
		this.pay = pay;
		this.worktime = worktime;
	}
	
	public int getMoneyPay() {
		return(pay+worktime)/12;
	} 
}
