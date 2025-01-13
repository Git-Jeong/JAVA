package ex_01;

import java.util.Scanner;

public class Ex_03_1_main_Student {
	public static void main(String[] args) {
		int studentCount = 0; 
		Scanner scan = new Scanner(System.in);
		
		System.out.printf("학생수 : ");
		studentCount = input_number(scan);
        Ex_03_2_student[] students = new Ex_03_2_student[studentCount];
        //studentCount만큼의 배열을 만들 것
		
		for(int i=0; i < studentCount; i++) {  
            
			System.out.printf("학생 이름 : "); 
			String name = scan.nextLine();

			System.out.printf("학번 : ");
			String number = scan.nextLine();
			
			System.out.printf("나이 : ");
			int age = input_number(scan);
			
			System.out.printf("자바 점수 : ");
			int java_score = input_number(scan); 
			
			System.out.printf("웹 점수 : ");
			int web_score = input_number(scan); 
			
			System.out.printf("안드로이드 점수  : ");
			int android_score = input_number(scan); 
			
			students[i] = new Ex_03_2_student(name, number, age, java_score, web_score, android_score);  
		}
		System.out.println(); 

		for(int i = 0; i < studentCount; i++) { 
			students[i].getName();
			System.out.printf("의 새로운 이름을 지정 : ");
			String temp = scan.nextLine();
			students[i].setName(temp); 
		} 
		
		for(int i = 0; i < studentCount; i++) {
			students[i].showStudent();
			if(i != studentCount) {
				System.out.println("===============");
			}
		}
		
		scan.close();
	}
	
	private static int input_number(Scanner scan) {
		//양의 정수를 입력받아 리턴하는 클래스 
		int result = 0;
		while(true) { 
			try {
				result = Integer.parseInt(scan.nextLine());
				if(result < 0) {
					System.out.printf("재입력 : ");
					continue;
				}
				else if(result == 0) {
					System.out.printf("0명은 존재하지 않습니다. : ");
				}
				else {
					//음수가 아니면
					break;
				}
			} catch (Exception e) {
				System.out.printf("재입력 : ");
			}
		}
		return result;
	}
}
