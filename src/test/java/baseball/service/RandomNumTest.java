package baseball.service;

import baseball.domain.Baseball;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumTest {
    RandomNumGenerator randomNumGenerator;

    @BeforeEach
    public void setUp() {
        randomNumGenerator = new RandomNumGenerator();
    }

    @Test
    @DisplayName("3개의 서로다른 숫자가 생성되는지 확인하는 테스트입니다.")
    public void makeNumTest() {
        List<Integer> list = randomNumGenerator.makeNum();

        Baseball randomNum = new Baseball(list);
        assertThat(randomNum.getBaseballs().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("1부터 9 사이의 값인지 확인하는 테스트입니다.")
    public void rangeTest() {
        List<Integer> list = randomNumGenerator.makeNum();

        assertThat(list.stream().filter(integer -> integer >= 1 && integer <= 9).count()).isEqualTo(3);
    }
}
