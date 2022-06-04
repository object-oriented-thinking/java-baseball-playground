package baseball.service;

import baseball.domain.Ball;
import baseball.domain.Baseball;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballServiceTest {
    BaseballService baseballService;

    @BeforeEach
    void setUp(){
        baseballService= new BaseballService();
    }

    @Test
    void isStrikeTest(){
        Baseball userBall = new Baseball(Arrays.asList(new Ball(1),new Ball(2),new Ball(3)));
        Baseball randomBall = new Baseball(Arrays.asList(new Ball(1),new Ball(2),new Ball(3)));
        for(int i=0;i<3;i++){
            assertThat(baseballService.isStrike(userBall.getBaseballs().get(i), randomBall.getBaseballs().get(i))).isTrue();
        }
    }

    @Test
    void isBallTest(){
        Baseball userBall = new Baseball(Arrays.asList(new Ball(1),new Ball(3),new Ball(2)));
        Baseball randomBall = new Baseball(Arrays.asList(new Ball(2),new Ball(1),new Ball(3)));
        for(int i=0;i<3;i++){
            assertThat(baseballService.isBall(userBall.getBaseballs().get(i), randomBall)).isTrue();
        }
    }

    @ParameterizedTest
    @CsvSource({"1,2,6,1,9,2,1,1", "3,7,5,7,3,9,2,0", "1,2,3,4,5,6,0,0", "3,4,8,3,4,2,0,2"})
    void compareTest(int u1,int u2,int u3,int r1,int r2,int r3, int e1, int e2) throws Exception {
        Baseball userBall = new Baseball(Arrays.asList(new Ball(u1),new Ball(u2),new Ball(u3)));
        Baseball randomBall = new Baseball(Arrays.asList(new Ball(r1),new Ball(r2),new Ball(r3)));

        assertThat(new int[]{baseballService.compare(userBall, randomBall).getBall(), baseballService.compare(userBall, randomBall).getStrike()}).isEqualTo(new int[]{e1, e2});
    }
}
