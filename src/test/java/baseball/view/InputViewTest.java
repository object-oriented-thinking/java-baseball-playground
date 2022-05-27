package baseball.view;

import baseball.domain.Baseball;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    InputView inputView;
    Baseball baseball;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
        String input = "349";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    void countTest() throws Exception {
        baseball = inputView.inputBall();
        assertThat(baseball.getBaseballs().size()).isEqualTo(3);
    }

    @Test
    void rangeTest() throws Exception {
        baseball = inputView.inputBall();
        assertThat(baseball.getBaseballs().stream().filter(b -> b < 10 && b > 0).count()).isEqualTo(3);
    }

    @Test
    void resumeTest() {
        String data = "1";
        InputStream in = new ByteArrayInputStream(data.getBytes());
        System.setIn(in);
        assertThat(inputView.resumeGame()).isTrue();
    }
}
