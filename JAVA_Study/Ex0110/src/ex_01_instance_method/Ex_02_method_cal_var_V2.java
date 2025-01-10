package ex_01_instance_method;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex_02_method_cal_var_V2 {
    public static void main(String[] args) {
        // 사용자가 입력한 숫자 2개와 연산자를 활용한 계산기 코드

        ArrayList<Cal> cal_list = new ArrayList<>(); // 계산을 저장하는 가변 배열

        Scanner scan = new Scanner(System.in);
        boolean cal_service_loop = true;

        do {
            System.out.printf("첫 번째 숫자를 입력: ");
            double input_num1 = input_num(scan);

            System.out.printf("연산자를 입력: ");
            String op = input_op(scan);

            System.out.printf("두 번째 숫자를 입력: ");
            double input_num2 = input_num(scan);

            cal_list.add(new Cal(input_num1, input_num2, op));

            int index = cal_list.size() - 1;
            calPrintOneLine(cal_list, index);

            // 재시작 여부 판단
            while (true) {
                System.out.println();
                System.out.printf("재시작: 'Any Key', 종료: 'N', 과거 기록: 'H' >>> ");
                String temp = scan.nextLine();
                if (temp.equalsIgnoreCase("N")) {
                    cal_service_loop = false;
                    break;
                } else if (temp.equalsIgnoreCase("H")) {
                    // 사용자가 과거 기록을 보게 하는 코드
                    calPrintAllLine(cal_list);
                } else {
                    break;
                }
            }
        } while (cal_service_loop);

        // 시스템 종료 메시지
        if (!cal_service_loop) {
            System.out.println("시스템이 정상적으로 종료되었습니다.");
        } else {
            System.out.println("시스템에 에러가 발생했습니다.");
        }

        scan.close();
    }

    public static void calPrintAllLine(ArrayList<Cal> cal_list) {
        // 사용자가 계산한 모든 기록을 출력
        for (int index = 0; index < cal_list.size(); index++) {
            double output_num_1 = cal_list.get(index).num_1;
            double output_num_2 = cal_list.get(index).num_2;
            String output_op = cal_list.get(index).op;
            double output_result = cal_list.get(index).result;
            System.err.printf("[%3d] : ", index + 1);
            System.out.printf("%.2f %s %.2f = %.2f\n", output_num_1, output_op, output_num_2, output_result);
        }
    }

    public static void calPrintOneLine(ArrayList<Cal> cal_list, int index) {
        // 사용자가 지정한 계산 기록을 출력
        double output_num_1 = cal_list.get(index).num_1;
        double output_num_2 = cal_list.get(index).num_2;
        String output_op = cal_list.get(index).op;
        double output_result = cal_list.get(index).result;
        System.out.printf("%.2f %s %.2f = %.2f\n", output_num_1, output_op, output_num_2, output_result);
    }

    static class Cal {
        double num_1;
        double num_2;
        String op;
        double result;

        Cal(double num_1, double num_2, String op) {
            this.num_1 = num_1;
            this.num_2 = num_2;
            this.op = op;
            this.result = calculate();
        }

        private double calculate() {
            double result = 0; // 결과 초기화
            switch (op) {
                case "+":
                    result = num_1 + num_2;
                    break;
                case "-":
                    result = num_1 - num_2;
                    break;
                case "*":
                    result = num_1 * num_2;
                    break;
                case "/":
                    if (num_2 != 0) {
                        result = num_1 / num_2;
                    } else {
                        System.out.println("0으로 나눌 수 없습니다.");
                    }
                    break;
                case "%":
                    if (num_2 != 0) {
                        result = num_1 % num_2;
                    } else {
                        System.out.println("0으로 나눌 수 없습니다.");
                    }
                    break;
                default:
                    System.out.println("입력한 연산자가 유효하지 않습니다.");
                    break;
            }
            return result;
        }
    }

    public static double input_num(Scanner scan) {
        // 사용자의 숫자 입력을 위한 함수 (정수와 실수 모두 허용)
        double result = 0;
        while (true) {
            try {
                result = Double.parseDouble(scan.nextLine());
                break;
            } catch (Exception e) {
                System.out.print("숫자만 입력해 주세요: ");
            }
        }
        return result;
    }

    public static String input_op(Scanner scan) {
        // 사용자의 연산자를 입력하도록 하는 함수
        String[] op_check_list = {"+", "-", "/", "*", "%"};
        String result;

        while (true) {
            result = scan.nextLine();

            for (String op : op_check_list) {
                if (result.equals(op)) {
                    return result;
                }
            }

            System.out.printf("유효한 연산자를 입력해 주세요: ");
        }
    }
}

