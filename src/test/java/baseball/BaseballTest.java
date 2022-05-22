package baseball;

import baseball.Baseball;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballTest {
    Baseball baseball;

    @BeforeEach
    public void setUp(){
        baseball = new Baseball();
    }

    @Test
    @DisplayName("입력 숫자가 잘 저장되는지 확인하는 테스트입니다.")
    public void inputViewTest(){
        String input = "345";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        List<Integer> result = baseball.inputView();
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    public void resultViewTest(){
        List<Integer> result = Arrays.asList(3,0,0);
        baseball.resultView(result);
    }

    @Test
    @DisplayName("랜덤 숫자가 잘 생성되는지 확인하는 테스트입니다.")
    public void makeNumTest(){
        List<Integer> result = baseball.makeNum();
        assertThat(result.size()).isEqualTo(3);
        assertThat(result.stream().allMatch(v->v>=1 && v<=9)).isTrue();
        System.out.println(result);
    }

    @Test
    public void checkNumTest(){
        List<Integer> randomNum = Arrays.asList(3,1,2);
        List<Integer> userNum = Arrays.asList(2,1,3);
        assertThat(baseball.checkNum(randomNum, userNum).equals(Arrays.asList(3,0,0)));
    }
}