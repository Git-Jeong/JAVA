package ex_02_array_2;

public class Ex_01_two_dimensional_array {

	public static void main(String[] args) {

		int first_index = 5;
		int second_index = 5;

		int array[][] = new int[first_index][second_index];

		int index = 1;

		//가로로 값 넣기
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%3d line : ", i + 1);
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = index; 
				System.out.printf("%3d ", array[i][j]);
				index++;
			}
			System.out.println();
		}
		System.out.println();

		//-------------------------------------
		
		// 세로로 값 넣기
		index = 1;
		for (int j = 0; j < array[0].length; j++) {   
		    for (int i = 0; i < array.length; i++) {  
		        array[i][j] = index;
		        index++;
		    }
		}

		// 세로로 값 출력
		for (int i = 0; i < array.length; i++) {
		    System.out.printf("%3d line : ", i + 1);
		    for (int j = 0; j < array[i].length; j++) {
		        System.out.printf("%3d ", array[i][j]);
		    }
		    System.out.println();
		}
		System.out.println();

		//-------------------------------------
		
		// 가로로 몇 칸이 있는지 파악
		System.out.println("배열명.length : " + array.length);
		// 세로로 몇 칸이 있는지 파악
		System.out.println("배열명[i].length : " + array[1].length);

	}
}
