package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballTest {

    int[] answer = new int[3];
    int[] inputNumber = new int[3];
    int strike=0;
    int ball=0;
    int nothing=0;
    Map<Integer, Integer> tmpMap = new HashMap<>();


    @BeforeEach
    void setup() {
        inputNumber[0]= 3;
        inputNumber[1]= 7;
        inputNumber[2]= 3;
        answer[0] = 7;
        answer[1] = 3;
        answer[2] = 7;
    }



    @Test
    @DisplayName("3자리 난수생성한다")
    void generateNumber() {
        for (int i = 0; i < answer.length; i++) {
            answer[i] = (int) (Math.random() * 10);
        }
        assertThat(answer[0]).isLessThanOrEqualTo(9);
        assertThat(answer[1]).isLessThanOrEqualTo(9);
        assertThat(answer[2]).isLessThanOrEqualTo(9);
    }


    @Test
    @DisplayName("입력받은숫자와 난수를 비교한다")
    void testEquals() {
        check();
        assertThat(strike).isEqualTo(0);
        assertThat(ball).isEqualTo(2);
    }



    private void check() {
        for (int i = 0; i < answer.length; i++) {
            if (inputNumber[i] == answer[i]) {
                strike++;
                tmpMap.put(i,i);
            }
        }

        for (int j = 0; j < answer.length; j++) {
            if (!tmpMap.containsKey(j)) {
                for (int k = 0; k < answer.length; k++) {
                    if (!tmpMap.containsKey(j)&& !tmpMap.containsValue(k) && inputNumber[j] == answer[k]    ) {
                        ball++;
                        tmpMap.put(j,k);
                    }
                }
            }

        }

        if (ball == 0 && strike == 0) {
            nothing++;
        }
    }

}
