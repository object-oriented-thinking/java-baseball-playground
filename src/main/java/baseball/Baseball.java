package baseball;

import java.util.HashMap;
import java.util.Map;

public class Baseball {

    private int strike=0;
    private int ball=0;
    private int nothing=0;
    private int[] answer;
    private final Map<Integer, Integer> tmpMap = new HashMap<>();

    public Baseball(int[] answer) {
        this.answer = answer;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getNothing() {
        return nothing;
    }

    public void setNothing(int nothing) {
        this.nothing = nothing;
    }

    public int[] getAnswer() {
        return answer;
    }

    public void setAnswer(int[] answer) {
        this.answer = answer;
    }

    public Map<Integer, Integer> getTmpMap() {
        return tmpMap;
    }


    public void plusNothing() {
        this.nothing++;
    }

    public void plusBall() {
        this.ball++;
    }
    public void plusStrike() {
        this.strike++;
    }

}
