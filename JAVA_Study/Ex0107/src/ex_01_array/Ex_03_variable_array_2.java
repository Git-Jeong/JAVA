package ex_01_array;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex_03_variable_array_2 {
	public static void main(String[] args) {
		//가변으로 문자열 배열을 하나 만들고 거기에 사용자의 입력을 넣는 것
		//ctrl + shift + f로 import문 자동으로 추가 가능
		Scanner scan = new Scanner(System.in); 
		
		ArrayList<String> var_array = new ArrayList<>(); // 홀수를 담을 가변 배열

		while(true) {
			System.out.print("아무 문장이나 입력하세요(종료 : 'Y') : ");
			String temp = scan.nextLine();
			if(temp.equalsIgnoreCase("Y")) {
				break;
			}
			else {				
				var_array.add(temp); 
			}
		}
	
		for(String temp : var_array) {
			System.out.printf("%s \n", temp);
		}
	}
}
