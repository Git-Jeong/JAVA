package ex_01;

import java.util.Random;
import java.util.Scanner;

public class Ex_01_Student_Info {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// import 해서 hashSet??을 쓰면 좀 더 빠를 것 같긴 한데 이거 없이 해보기

		System.out.print("학생 수 : ");
		int size = input_integer(scan);
		Student[] students = new Student[size];

		for (int i = 0; i < size; i++) {
			System.out.printf("이름 >> ");
			String name = input_str(scan);

			System.out.printf("휴대전화 >> ");
			String mobile_phone = input_str(scan);

			System.out.printf("주소 >> ");
			String address = input_str(scan);

			System.out.println();
			students[i] = new Student(name, mobile_phone, address, students, i);
		}

		/**
		 * for (int i = 0; i < size; i++) { System.out.println("이름 : " +
		 * students[i].name); System.out.println("전화번호 : " + students[i].mobile_phone);
		 * System.out.println("학번 : " + students[i].student_number);
		 * System.out.println("주소 : " + students[i].address); System.out.println("ID : "
		 * + students[i].id); System.out.println(); System.out.println(); }
		 */

		// 학번을 가지고 데이터를 추적하는 방법은?
		int search_number = 20254002;
		int find_index = 0;
		for (int i = 0; i < size; i++) {
			if (search_number == students[i].student_number) {
				find_index = i;
				System.out.printf("찾은 index : %d\n", find_index);
				System.out.printf("찾은 이름 : %s\n", students[find_index].name);
				System.out.printf("찾은 휴대번호 : %s\n", students[find_index].mobile_phone);
				System.out.printf("찾은 주소 : %s\n", students[find_index].address);
				System.out.printf("찾은 ID : %d\n", students[find_index].id);
			}
		}

	}

	private static String input_str(Scanner scan) {
		String result = scan.nextLine();
		return result;
	}

	private static int input_integer(Scanner scan) {
		int result = 0;
		while (true) {
			try {
				result = Integer.parseInt(scan.nextLine());
				break;
			} catch (Exception e) {
				System.out.print("재입력 : ");
			}
		}
		return result;
	}

	static class Student {
		String name;
		String mobile_phone;
		int student_number;
		String address;
		int id; // 중복이 안 되는 유니크

		private Student(String name, String mobile_phone, String address, Student[] students, int index) {
			this.name = name;
			this.mobile_phone = mobile_phone;
			this.student_number = index + 20254001;
			this.address = address;
			this.id = generateUniqueId(students, index);
		}

		private static int generateUniqueId(Student[] students, int index) {
			Random rd = new Random();
			int result;
			boolean isUnique;
			do {
				result = rd.nextInt(99999999) + 1; // 1부터 99999999 사이의 랜덤 값
				isUnique = true;
				// 현재까지의 학생 배열에서 중복 검사
				for (int i = 0; i < index; i++) {
					if (students[i].id == result) {
						isUnique = false;
						break;
					}
				}
			} while (!isUnique); // 중복이 없을 때까지 반복
			return result;
		}
	}
}
