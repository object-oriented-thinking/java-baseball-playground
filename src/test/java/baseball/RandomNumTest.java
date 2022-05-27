package baseball;

import baseball.domain.Ball;
import baseball.service.RandomNumGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumTest {
    private Ball randomNum;
    RandomNumGenerator randomNumGenerator;
    @BeforeEach
    public void setUp(){
        randomNumGenerator = new RandomNumGenerator();
    }

    @Test
    public void makeNumTest(){
        Set<Integer> set = randomNumGenerator.makeNum();
        assertThat(set.size()).isEqualTo(3);
        System.out.println(set);
    }


}
