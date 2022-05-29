package util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class CompareAnswerTest {
    ArrayList<Integer> inputNum= new ArrayList<>();
    ArrayList<Integer> answerNum= new ArrayList<>();

    @BeforeEach
    void setup() {
        answerNum.add(3);
        answerNum.add(4);
        answerNum.add(6);
    }

    @Test
    @DisplayName("0스트라이크 1볼")
    void ballCountingTest() {
        inputNum.add(1);
        inputNum.add(2);
        inputNum.add(3);
        CompareAnswer compareAnswer = new CompareAnswer(inputNum,answerNum);
        ballCounting(compareAnswer);
        assertThat(compareAnswer.getStrikeCount()).isEqualTo(0);
        assertThat(compareAnswer.getBallCount()).isEqualTo(1);
        assertThat(compareAnswer.getNothing()).isNotEqualTo(3);
        System.out.println(compareAnswer.getNothing());
    }

    @Test
    @DisplayName("2스트라이크")
    void ballCountingTest2() {
        inputNum.add(3);
        inputNum.add(5);
        inputNum.add(6);
        CompareAnswer compareAnswer = new CompareAnswer(inputNum,answerNum);
        ballCounting(compareAnswer);
        assertThat(compareAnswer.getStrikeCount()).isEqualTo(2);
        assertThat(compareAnswer.getBallCount()).isEqualTo(0);
        assertThat(compareAnswer.getNothing()).isNotEqualTo(3);
    }

    @Test
    @DisplayName("낫싱")
    void ballCountingTest3() {
        inputNum.add(1);
        inputNum.add(2);
        inputNum.add(5);
        CompareAnswer compareAnswer = new CompareAnswer(inputNum,answerNum);
        ballCounting(compareAnswer);
        assertThat(compareAnswer.getStrikeCount()).isEqualTo(0);
        assertThat(compareAnswer.getBallCount()).isEqualTo(0);
        assertThat(compareAnswer.getNothing()).isEqualTo(3);
    }

    @Test
    @DisplayName("3볼")
    void ballCountingTest4() {
        inputNum.add(6);
        inputNum.add(3);
        inputNum.add(4);
        CompareAnswer compareAnswer = new CompareAnswer(inputNum,answerNum);
        ballCounting(compareAnswer);
        assertThat(compareAnswer.getStrikeCount()).isEqualTo(0);
        assertThat(compareAnswer.getBallCount()).isEqualTo(3);
        assertThat(compareAnswer.getNothing()).isNotEqualTo(3);
    }

    private void ballCounting(CompareAnswer compareAnswer) {
        compareAnswer.ballCounting(0);
        compareAnswer.ballCounting(1);
        compareAnswer.ballCounting(2);
    }
}