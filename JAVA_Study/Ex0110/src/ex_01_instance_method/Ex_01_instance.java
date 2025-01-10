package ex_01_instance_method;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex_01_instance {
	public static void main(String[] args) {
		Ex_01_instance instance = new Ex_01_instance();
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> var_arr_num = new ArrayList<>();

		while (true) {
			try {
				String end_char = "N";
				System.out.printf("%d번째 숫자를 입력(종료 : '%s') >>> ", (var_arr_num.size() + 1), end_char);
				String temp_str = scan.nextLine();
				if (temp_str.equalsIgnoreCase(end_char)) {
					break;
				} else {
					var_arr_num.add(Integer.parseInt(temp_str));
				}
			} catch (NumberFormatException e) {
				System.out.println("옳바른 입력을 하세요. ");
			}
		}

		int plus_result = instance.add(var_arr_num);
		int minus_result = instance.minus(var_arr_num);
		int multiply_result = instance.multiply(var_arr_num);
		int divide_result = instance.divide(var_arr_num);
		int powern_result = instance.powerNumber(var_arr_num);
		int largenum = instance.largerNum(var_arr_num);

		System.out.printf("더한 결과 값 : %d\n", plus_result);
		System.out.printf("뺀 결과 값 : %d\n", minus_result);
		System.out.printf("곱한 결과 값 : %d\n", multiply_result);
		System.out.printf("n승을 한 값 : %d\n", powern_result);
		System.out.printf("나눈 결과 값 : %d\n", divide_result);
		System.out.printf("큰 값 : %d\n", largenum);

		instance = null;
		scan.close();
	}

	public int add(ArrayList<Integer> input) {
		int result = 0;
		for (int temp : input) {
			result += temp;
		}
		return result;
	}

	public int minus(ArrayList<Integer> input) {
		int result = input.get(0); // 첫 번째 값을 초기값으로 설정
		for (int i = 1; i < input.size(); i++) { // 두 번째 값부터 끝까지
			result -= input.get(i);
		}
		return result;
	}

	public int multiply(ArrayList<Integer> input) {
		int result = input.get(0); // 첫 번째 값을 초기값으로 설정
		for (int i = 1; i < input.size(); i++) { // 두 번째 값부터 끝까지
			result *= input.get(i);
		}
		return result;
	}

	public int divide(ArrayList<Integer> input) {
		int result = input.get(0); // 첫 번째 값을 초기값으로 설정
		for (int i = 1; i < input.size(); i++) { // 두 번째 값부터 끝까지
			result /= input.get(i);
		}
		return result;
	}

	public int largerNum(ArrayList<Integer> input) {
		int result = input.get(0);
		for (int i = 1; i < input.size(); i++) {
			if (result < input.get(i)) {
				result = input.get(i);
			}
		}
		return result;
	}

	public int powerNumber(ArrayList<Integer> input) {
		int sum = input.get(0); // 첫 번째 값을 초기값으로 설정
		int result = sum; // 첫 번째 값을 초기값으로 설정
		for (int i = 1; i < input.size(); i++) { // 두 번째 값부터 끝까지
			for (int j = 1; j < input.get(i); j++) {
				result *= sum;
			}
		}
		return result;
	}
}
