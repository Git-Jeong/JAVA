package ex_01_var;
import java.

public class Ex_04_Operate {
	public static void main(String[] args) { 
		int num1 = 19;
		
		
		
		int i_num1 = 10;
		int i_num2 = 7;
		System.out.println(i_num1 + " % " + i_num2 + " = " + (i_num1 % i_num2));
		System.out.println(i_num1 + " / " + i_num2 + " = " + (i_num1 / i_num2)); 
		System.out.println();
		
		// +=     -=
		int a = 1;
		a+=1;
		System.out.println("1 += 1 = " + a);
		a-=1;
		System.out.println("2 -= 1 = " + a);
		System.out.println();
		
		
		//Shift 연산 
		System.out.println("1 << 1 = " + (1 << 1));
		System.out.println("1 << 1 = " + (1 >> 1));;
		System.out.println();
		
		//XOR 연산 : 두 수의 각 자리수가 다른 경우 1로 변환
		// 3 : 0000 0011
		// 5 : 0000 0101 
		// 3^5 : 0000 0110 
		System.out.println("3^(xor)5 = " + (3^5));
		System.out.println();
		 
		boolean boolean_true_1 = true;
		boolean boolean_false_1 = false; 
		
		//and or 연산
		System.out.println(boolean_true_1 + " &(and) " + boolean_false_1 + " = "+ (boolean_true_1 & boolean_false_1));
		System.out.println(boolean_true_1 + " |(or) " + boolean_false_1 + " = "+ (boolean_true_1 | boolean_false_1)); 
		System.out.println();
		
		
		
	}
}
