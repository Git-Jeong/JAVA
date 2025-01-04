package Bulls_and_Cows;

public class Strike_Ball_Check {
    public int[] Check_Strike_ball(int[] output, int[] user_input, int[] answer) {
        int strike = 0;
        int ball = 0;
        int max = answer.length;

        // 답과 사용자의 입력 비교
        for (int i = 0; i < max; i++) {
            // 스트라이크 처리: 같은 위치에 같은 숫자가 있을 경우
            if (answer[i] == user_input[i]) {
                strike++;
            }
            // 볼 처리: 같은 숫자가 있지만 위치가 다를 경우
            for (int j = 0; j < max; j++) {
                if (i != j && answer[i] == user_input[j]) {
                    ball++;
                    break; // 같은 숫자에 대해 여러 번 카운팅 되지 않도록 break
                }
            }
        }

        output[0] = strike;
        output[1] = ball;

        return output;  // answer를 반환할 필요 없이 output만 반환
    }
}
