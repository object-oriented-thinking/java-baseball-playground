package baseball.api;

import baseball.domain.Number;
import baseball.domain.Numbers;
import baseball.infra.FakeBaseballInputClientImpl;
import baseball.infra.FakeRandomNumbersSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class GameServiceTest {

    private BaseballService baseballService = new BaseballService(new FakeRandomNumbersSpecification(), new FakeBaseballInputClientImpl());

    @Test
    @DisplayName("임의로 숫자를 저장한다.")
    void test1() {
        //when & then
        assertDoesNotThrow(
            () -> baseballService.storeRandomNumbers()
        );
    }

    @Test
    @DisplayName("숫자는 Random API를 이용해 가져와 저장한다")
    void test2() {
        //given
        Numbers numbers = baseballService.storeRandomNumbers();
        //when & then
        assertThat(numbers.getNumbers().containsAll(
            Arrays.asList(new Number(4), new Number(9), new Number(3)))
        ).isTrue();

    }

    @Test
    @DisplayName("숫자를 입력받는다.")
    void test3() {
        //given & when & then
        assertDoesNotThrow(
            () -> baseballService.inputNumbers()
        );
    }
}
