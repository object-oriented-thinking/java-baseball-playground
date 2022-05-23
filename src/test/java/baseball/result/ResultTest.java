package baseball.result;

import baseball.domain.Result;
import baseball.error.CalculationFailureException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultTest {

    @Test
    @DisplayName("스트라이크의 개수, 볼의 개수, 낫싱의 유무 정보를 가지고 있다.")
    void test1() {
        //given
        int strike = 1;
        int ball = 2;
        boolean nothing = false;
        //when & then
        Assertions.assertDoesNotThrow(
                () -> new Result(strike, ball, nothing)
        );
    }


    @Test
    @DisplayName("스트라이크 개수와 볼의 개수의 합은 3이 아니면 CalculationFailureException 예외 발생")
    void test2() {
        //given
        int strike = 1;
        int ball = 3;
        boolean nothing = false;
        //when & then
        assertThatThrownBy(
                () -> new Result(strike, ball, nothing)
        ).isInstanceOf(CalculationFailureException.class);
    }

    @Test
    @DisplayName("비교 결과가 낫싱일 때, 스트라이크와 볼의 갯수가 있으면 CalculationFailureException 예외가 발생 한다.")
    void test3() {
        //given
        int strike = 1;
        int ball = 1;
        boolean nothing = true;
        //when & then
        assertThatThrownBy(
                () -> new Result(strike, ball, nothing)
        ).isInstanceOf(CalculationFailureException.class);
    }

}
