package emplpyeeSalary;

public class TempEmployee extends Employee {   
	   public TempEmployee(String empno, String name, int pay) {
	      super();
	      this.empno = empno;
	      this.name = name;
	      this.pay = pay;
	   } 
	   
	   public int getMoneyPay() {
	      return pay / 12;
	   } 
}
