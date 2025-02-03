package view.User;

import view.util.ScannerUtil;
import java.util.Scanner;

public class Input {  
	 
	
	public static String inputStrig()  { 
		Scanner scan = ScannerUtil.getScanner();
		String result = null;
		while(true) {
			try {
				result = scan.nextLine();
				break;
			} catch (Exception e) {
				System.out.print("문자열 재입력 : ");
			}
		}  
		return result;
	}
	
	
	public static int inputNumber() {
		Scanner scan = ScannerUtil.getScanner();
		int result = 0;
		while(true) {
			try {
				result = Integer.parseInt(scan.nextLine());
				if(result >= 0) {					
					break;
				}
				else {
					System.out.print("'0' 이상을 입력");
				}
			} catch (Exception e) { 
				System.out.print("정수만 입력해 주세요 : ");
			} 
		}
		return result;
	}
}
