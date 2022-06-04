package baseball.service;

import baseball.domain.Ball;
import baseball.domain.Baseball;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomBallTest {
    RandomBallGenerator randomBallGenerator;

    @BeforeEach
    public void setUp() {
        randomBallGenerator = new RandomBallGenerator();
    }

    @Test
    @DisplayName("3개의 서로다른 숫자가 생성되는지 확인하는 테스트입니다.")
    public void makeNumTest() {
        List<Ball> list = randomBallGenerator.makeNum();

        Baseball randomNum = new Baseball(list);
        assertThat(randomNum.getBaseballs().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("1부터 9 사이의 값인지 확인하는 테스트입니다.")
    public void rangeTest() {
        List<Ball> list = randomBallGenerator.makeNum();

        assertThat(list.stream().filter(ball -> ball.getNumber() >= 1 && ball.getNumber() <= 9).count()).isEqualTo(3);
    }
}
