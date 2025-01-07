package ex_02_for;

public class Ex_01_for_1 {
    public static void main(String[] args) {
        final int MAX_LINE = 9; // 구구단 최대 단
        final int MAX_ONE_LINE = 3; // 한 줄에 출력할 단 개수

        for (int i = 1; i <= MAX_LINE; i += MAX_ONE_LINE) { // 시작 단 설정
        	//1단 ---> 4단 ---> 7단 
            for (int j = 1; j <= MAX_LINE; j++) { // 각 단의 곱셈 반복
                for (int k = i; k < i + MAX_ONE_LINE && k <= MAX_LINE; k++) { // 한 줄에 출력할 단 
                    System.out.printf("%2d x %2d = %2d\t", k, j, k * j);
                }
                System.out.println(); // 한 줄 출력 후 줄바꿈
            }
            System.out.println(); // MAX_ONE_LINE단위로 줄바꿈  
        }
    }

}
