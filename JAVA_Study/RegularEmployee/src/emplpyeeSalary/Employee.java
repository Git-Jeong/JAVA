package emplpyeeSalary;

public abstract class Employee {
	 String empno;
	 String name;
	 int pay;

	public String printInfoAll() {
	    return ("사번 : " + empno + ", 이름 : " + name + ", 연봉 : " + pay);
	} 

	public abstract int getMoneyPay();
}
