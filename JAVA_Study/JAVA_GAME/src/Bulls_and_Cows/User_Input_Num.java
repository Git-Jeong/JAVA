package Bulls_and_Cows;

import java.util.Scanner;

public class User_Input_Num {
    // 사용자가 입력한 숫자를 배열에 저장하고 배열을 반환
    public int[] Check_Num(int[] user_input) {
        Scanner scan = new Scanner(System.in);
        //사용자의 입력이 성공적으로 끝나면 false 가 되는 변수
        boolean check_input = true;

        while (check_input) {
            //사용자가 입력한 숫자를 문자열로 받기
            String input_string = scan.nextLine();

            // 글자길이가 게임 규칙에 맞는지 확인
            if (input_string.length() != user_input.length) {
                System.out.println(user_input.length + "자리의 숫자를 다시 입력해 주세요.");
                continue; // 길이가 맞지 않으면 다시 입력 받기
            }

            boolean check_duplication_char = true; // 중복, 문자열 체크를 위한 변수 초기화

            // 각 문자가 숫자인지, 중복인지 확인하고 유효하지 않으면 다시 입력 받기
            for (int i = 0; i < input_string.length(); i++) {
                if (!Character.isDigit(input_string.charAt(i))) {
                    System.out.println("숫자만 입력해주세요.");
                    check_duplication_char = false; // 문자가 포함되어 있으므로 다음단계로 미진행
                    break;
                }
                for (int j = 0; j < i; j++) {
                    if (Character.getNumericValue(input_string.charAt(i)) == Character.getNumericValue(input_string.charAt(j))) {
                        System.out.println("중복되지 않은 숫자를 입력해 주세요");
                        check_duplication_char = false; // 문자가 포함되어 있으므로 다음단계로 미진행
                        break;
                    }
                }
                if (!check_duplication_char) {
                    break;
                    // 중복이 발견되면 굳이 상위 for 문이 필요 없으므로 조기종료
                }
            }

            if (check_duplication_char) {
                // 길이가 맞고, 숫자만 입력됐으며, 중복이 없는 경우
                for (int i = 0; i < input_string.length(); i++) {
                    user_input[i] = Character.getNumericValue(input_string.charAt(i)); // 문자 하나씩 숫자로 변환하여 배열에 저장
                }
                check_input = false; // 배열에 값을 넣었으니 while 문을 종료함
            }
        }

        return user_input; // 배열 반환
    }
}
