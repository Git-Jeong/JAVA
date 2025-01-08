package ex_04_multifor;

public class Ex_01_star {

	public static void main(String[] args) {
		final int MAX_LINES = 5; 
		
		for(int i = 1; i <= MAX_LINES; i++) {
			for(int j=1; j <= i; j++) {
				System.out.print("*"); 
				if(i == j) {
					System.out.println();
				}
			}
		}	
		
		System.out.println();
		for(int i = MAX_LINES; i >= 1; i--)	 {
			for(int j=1; j <= i; j++) {
				System.out.print("*"); 
				if(i == j) {
					System.out.println();
				}
			}
		}  
		
	}
	
}
