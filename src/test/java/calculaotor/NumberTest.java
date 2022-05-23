package calculaotor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculaotor.Delimiter.*;
import static org.assertj.core.api.Assertions.assertThat;


class NumberTest {

    @Test
    @DisplayName("숫자 형식인 문자를 받아와 숫자로 변환한다.")
    void test1() {
        //given
        Number expected = new Number(1L);
        //when & then
        Assertions.assertAll(
            () -> Assertions.assertDoesNotThrow(() -> new Number("1")),
            () -> assertThat(new Number("1")).isEqualTo(expected)
        );
    }

    @Test
    @DisplayName("자신의 숫자에서 입력받은 숫자를 더한다.")
    void test2() {
        //given
        Number actual = new Number("2");
        Number expected = new Number("5");
        //when
        Number addNumber = new Number("3");
        //then
        assertThat(actual.calculate(PLUS, addNumber)).isEqualTo(expected);
    }

    @Test
    @DisplayName("자신의 숫자에서 입력받은 숫자를 뺀다.")
    void test3() {
        //given
        Number actual = new Number("4");
        Number expected = new Number("3");
        //when
        Number minusNumber = new Number("1");
        //then
        assertThat(actual.calculate(MINUS, minusNumber)).isEqualTo(expected);
    }

    @Test
    @DisplayName("자신의 숫자에서 입력받은 숫자를 곱한다.")
    void test4() {
        //given
        Number actual = new Number("2");
        Number expected = new Number("6");
        //when
        Number addNumber = new Number("3");
        //then
        assertThat(actual.calculate(MULTIPLICATION, addNumber)).isEqualTo(expected);
    }

    @Test
    @DisplayName("자신의 숫자에서 입력받은 숫자를 나눈다.")
    void test5() {
        //given
        Number actual = new Number("10");
        Number expected = new Number("5");
        //when
        Number addNumber = new Number("2");
        //then
        assertThat(actual.calculate(DIVISION, addNumber)).isEqualTo(expected);
    }
}
