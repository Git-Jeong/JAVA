package bulls_and_Cows;

public class Game_answer {
    // 배열의 각 요소에 중복 없는 랜덤 숫자를 추가하고 반환
    public int[] RandomNumbers(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int temp = (int) (Math.random() * 9) + 1; // 1~9 사이 랜덤 숫자 생성
            boolean duplication_check = false;

            // 중복 검사
            for (int j = 0; j < i; j++) {
                if (array[j] == temp) {
                    duplication_check = true;
                    break;
                }
            }

            if (duplication_check) {
                i--; // 중복이 있다면 인덱스를 감소시키고 반복
            } else {
                array[i] = temp; // 중복이 없으면 배열에 추가
            }
        }
        return array; // 수정된 배열 반환
    }
}
