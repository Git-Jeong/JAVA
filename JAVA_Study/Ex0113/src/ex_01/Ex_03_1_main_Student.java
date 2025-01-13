package ex_01;

import java.util.Scanner;

public class Ex_03_1_main_Student {
	public static void main(String[] args) {
		int studentCount = 0; 
		Scanner scan = new Scanner(System.in);
		
		System.out.printf("학생수 : ");
		studentCount = input_number(scan);
        Ex_03_2_student[] students = new Ex_03_2_student[studentCount];
		
		for(int i=0; i < studentCount; i++) {
            students[i] = new Ex_03_2_student();  
            
			System.out.printf("학생 이름 : ");
			students[i].name = scan.nextLine();

			System.out.printf("학번 : ");
			students[i].number = scan.nextLine();
			
			System.out.printf("나이 : ");
			students[i].age = input_number(scan);
			
			System.out.printf("자바 점수 : ");
			students[i].java_score = input_number(scan); 
			
			System.out.printf("웹 점수 : ");
			students[i].web_score = input_number(scan); 
			
			System.out.printf("안드로이드 점수  : ");
			students[i].android_score = input_number(scan); 
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
				else {
					break;
				}
			} catch (Exception e) {
				System.out.printf("재입력 : ");
			}
		}
		return result;
	}
}
