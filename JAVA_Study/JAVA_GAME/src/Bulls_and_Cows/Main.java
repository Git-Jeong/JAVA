package Bulls_and_Cows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int GAME_SIZE = 3;
        boolean game_start = true;

        while (game_start) {
            Game_Start(GAME_SIZE);
            System.out.print("재시작 : 'Y', 종료 : 'N' 를 입력해 주세요 : ");
            while (true) {
                char restart_end = scan.next().charAt(0);
                if (restart_end == 'Y' || restart_end == 'y') {
                    System.out.printf("\n\n\n\n\n");
                    break;
                }
                else if (restart_end == 'N' || restart_end == 'n') {
                    System.out.println("게임을 종료합니다. ");
                    game_start = false;
                    break;
                }
                else {
                    System.out.print("옳바른 키를 입력해 주세요. : ");
                }
            }
        }
        scan.close();
    }


    public static void Game_Start(int GAME_SIZE) {

        int[] game_answer = new int[GAME_SIZE]; // 배열 선언 (크기 3)
        int[] user_input = new int[GAME_SIZE];
        int[] strike_ball = new int[2]; //strike, ball 의 수
        boolean game_input = true;

        Game_answer game_answer_create = new Game_answer(); // Num_goal 객체 생성
        Strike_Ball_Check s_b_check = new Strike_Ball_Check();
        User_Input_Num userInputNum = new User_Input_Num();
        game_answer = game_answer_create.RandomNumbers(game_answer); // 배열에 숫자 채우기

        System.out.println("게임을 시작합니다!! " + GAME_SIZE + "자리의 정수를 적으세요");
        boolean test_mode = false;
        if(test_mode){
            System.out.println("----게임 테스트 모드----");
            System.out.print("정답은 : ");
            for (int i = 0; i < GAME_SIZE; i++) {
                System.out.print(game_answer[i]);
            }
            System.out.println();
        }
        while (game_input) {
            user_input = userInputNum.Check_Num(user_input);
            strike_ball = s_b_check.Check_Strike_ball(strike_ball, user_input, game_answer);
            if(strike_ball[0] == GAME_SIZE){
                System.out.printf("-----%d스트라이크!!-----\n\n", strike_ball[0]);
                game_input = false;
            }
            else {
                if (strike_ball[0] != 0) {
                    System.out.printf("%d스트라이크\t", strike_ball[0]);
                }
                if (strike_ball[1] != 0) {
                    System.out.printf("%d볼", strike_ball[1]);
                }
                if (strike_ball[0] == 0 && strike_ball[1] == 0) {
                    System.out.print("X");
                }
                System.out.println();
            }
        }

    }
}
