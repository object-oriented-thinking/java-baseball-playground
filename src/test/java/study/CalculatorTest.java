package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class CalculatorTest {

    /**
     * -입력한 문자열에따라 사칙연산수행
     * - 사칙연산 입력값에따라 순서가 결정됨
     */

    @Test
    void cal() {

        String input = "3 * 6 - 2 + 0";
        String[] s = input.split(" ");
        int answer = Integer.parseInt(s[0]);

        for (int i = 0; i < s.length; i++) {
            switch (s[i]) {
                case "+":
                    answer += Integer.parseInt(s[i + 1]);
                    break;
                case "-":
                    answer -= Integer.parseInt(s[i + 1]);
                    break;
                case "*":
                    answer *= Integer.parseInt(s[i + 1]);
                    break;
                case "/":
                    answer /= Integer.parseInt(s[i + 1]);
                    break;
            }
        }
        assertThat(answer).isEqualTo(16);

    }
    }


