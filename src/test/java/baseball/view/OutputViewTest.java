package baseball.view;

import baseball.domain.BaseballStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {
    OutputView outputView;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
    }

    @ParameterizedTest
    @CsvSource({"1,2,1볼 2스트라이크", "0,0,낫싱", "0,2,2스트라이크"})
    void outputViewTest(int ball, int strike, String expected) throws Exception {
        BaseballStatus baseballStatus = new BaseballStatus(ball, strike);
        assertThat(outputView.outputBaseballStatus(baseballStatus)).isEqualTo(expected);
    }

    @Test
    @DisplayName("조건에 만족하면 게임을 끝내는 메소드 테스트")
    void exitGameTest() throws Exception {
        BaseballStatus baseballStatus = new BaseballStatus(0,3);
        assertThat(outputView.exitGame(baseballStatus)).isTrue();
    }

    @Test
    @DisplayName("조건에 만족하지 않으면 게임 계속하는 메소드 테스트")
    void exitGameFalseTest() throws Exception {
        BaseballStatus baseballStatus = new BaseballStatus(1,2);
        assertThat(outputView.exitGame(baseballStatus)).isFalse();
    }
}
