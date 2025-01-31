package emplpyeeSalary;

public class RagularEmplpyee extends Employee { 
	private int bonus;
	
	public RagularEmplpyee(String empno, String name, int pay, int bonus) {
		super();
		this.empno = empno;
		this.name = name;
		this.pay = pay;
		this.bonus = bonus;
	}
	
	public int getMoneyPay() {
		return(pay+bonus) * 12;
	}
	 
}
