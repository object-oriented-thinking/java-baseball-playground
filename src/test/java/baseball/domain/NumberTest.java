package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @Test
    @DisplayName("Number는 1 이상 9 이하의 자연수이다.")
    void test1() {
        //given
        int request = 4;
        //when & then
        Assertions.assertDoesNotThrow(
            () -> new Number(request)
        );
    }


    @Test
    @DisplayName("Number는 1 이상 9 이하의 자연수 아니면 IllegalArgumentException 예외를 발생한다.")
    void test2() {
        //given
        int request = -1;
        //when & then
        assertThatThrownBy(
            () -> new Number(request)
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
