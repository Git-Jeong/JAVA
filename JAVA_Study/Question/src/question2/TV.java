package question2; 

public class TV {	 
	private String brand;
	private int year;
	private int inch;

	 
	public TV(String brand, int year, int inch) {
		super();
		this.brand = brand;
		this.year = year;
		this.inch = inch; 
	}
	
	public void show() { 
		System.out.printf("%s에서 만든 %d년형 %d인치 TV\n", brand, year, inch);
	}
}
