package ex_01_array;

public class Ex_00_array {
	public static void main(String[] args) {
		int arr_1[] = {1, 2, 3, 4, 5, 6, 0 ,7 ,8, 9};
		int arr_2[] = null; 
		
		 
        try {
            for(int temp : arr_1) {
                System.out.printf("%d ", temp);
            }
        } catch (NullPointerException e) {
            System.out.println("에러 : " + e.getMessage());
            //배열이 존재하지 않은 상태이므로 에러가 나올 것
        }
		
        
        System.out.println();
        try {
            for(int temp : arr_2) {
                System.out.printf("%d ", temp);
            }
        } catch (NullPointerException e) {
            System.out.println("에러 : " + e.getMessage());
            //배열이 존재하지 않은 상태이므로 에러가 나올 것
        }
		System.out.println();
		
		
		
	}
}
 
