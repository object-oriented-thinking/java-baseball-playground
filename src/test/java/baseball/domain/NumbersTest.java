package baseball.domain;

import baseball.error.NumberOfInputException;
import baseball.result.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class NumbersTest {
    @Test
    @DisplayName("Numbers 안에는 3개의 Number 를 저장할 수 있다.")
    void test1() {
        //given
        List<Number> request = Arrays.asList(new Number(1), new Number(2), new Number(3));


        //when & then
        Assertions.assertAll(
            () -> Assertions.assertDoesNotThrow(() -> new Numbers(request))
        );
    }

    @Test
    @DisplayName("Numbers 안에는 3개의 숫자를 가지고 있다")
    void test2() {
        //given
        List<Number> request = Arrays.asList(new Number(1), new Number(2), new Number(3));
        //when
        Numbers numbers = new Numbers(request);
        //then
        Assertions.assertAll(
            () -> assertThat(
                numbers.getNumbers()
                    .containsAll(
                        Arrays.asList(new Number(1), new Number(2), new Number(3))
                    )
            ).isTrue()
        );
    }

    @Test
    @DisplayName("Numbers 안에는 3개의 숫자는 순서가 보장된다.")
    void test3() {
        //given
        List<Number> request = Arrays.asList(new Number(1), new Number(2), new Number(3));

        //when
        Numbers numbers = new Numbers(request);
        //then
        Assertions.assertAll(
            () -> assertThat(request.contains(numbers.getNumbers().get(0))).isTrue(),
            () -> assertThat(request.contains(numbers.getNumbers().get(1))).isTrue(),
            () -> assertThat(request.contains(numbers.getNumbers().get(2))).isTrue()
        );
    }

    @Test
    @DisplayName("Numbers 안에는 3개의 숫자를 가지고 있지 않다면 NumberOfInputException 예외를 발생한다.")
    void test4() {
        //given
        List<Number> request = Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4));
        //when & then
        assertThatThrownBy(
            () -> new Numbers(request)
        ).isInstanceOf(NumberOfInputException.class);
    }


    @Test
    @DisplayName("임의 숫자와 입력 숫자를 비교한다.")
    void test6() {
        //given
        List<Number> request = Arrays.asList(new Number(1), new Number(2), new Number(3));
        Numbers store = new Numbers(request);
        List<Number> inputRequest = Arrays.asList(new Number(3), new Number(4), new Number(5));
        Numbers input = new Numbers(inputRequest);
        //when & then
        assertDoesNotThrow(
            () -> store.compareTo(input)
        );
    }

    @Test
    @DisplayName("스트라이크와 볼 값이 하나도 들어가 있지 않은 경우 낫싱이다")
    void test7() {
        //given
        List<Number> request = Arrays.asList(new Number(1), new Number(2), new Number(3));
        Numbers store = new Numbers(request);

        List<Number> inputRequest = Arrays.asList(new Number(6), new Number(4), new Number(5));
        Numbers input = new Numbers(inputRequest);
        //when
        Result result = store.compareTo(input);
        //then
        assertThat(result).isEqualTo(new Result(0, 0, true));
    }

    @Test
    @DisplayName("힌트를 제공한다.")
    void test8() {
        //given
        List<Number> request = Arrays.asList(new Number(1), new Number(2), new Number(3));
        Numbers store = new Numbers(request);
        List<Number> inputRequest = Arrays.asList(new Number(1), new Number(2), new Number(3));
        Numbers input = new Numbers(inputRequest);
        //when
        Result result = store.compareTo(input);
        //then
        assertThat(result.hint()).isEqualTo("3스트라이크");
    }

    @Test
    @DisplayName("힌트를 제공하고, 출력 단위는 x볼x스트라이크 이다.")
    void test9() {
        //given
        List<Number> request = Arrays.asList(new Number(1), new Number(3), new Number(6));
        Numbers store = new Numbers(request);
        List<Number> inputRequest = Arrays.asList(new Number(1), new Number(6), new Number(2));
        Numbers input = new Numbers(inputRequest);
        //when
        Result result = store.compareTo(input);
        //then
        assertThat(result.hint()).isEqualTo("1볼1스트라이크");
    }

}

