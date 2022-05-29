package util;

import java.util.ArrayList;

/**
 * 정답숫자와 인풋숫자를 비교하여 점수를 카운팅하는 클래스
 */
public class CompareAnswer {
    private final ArrayList<Integer> inputNum;
    private final ArrayList<Integer> answerNum;
    private int strikeCount=0;
    private int ballCount=0;
    private int nothing=0;

    public CompareAnswer(ArrayList<Integer> inputNum, ArrayList<Integer> answerNum) {
        this.inputNum = inputNum;
        this.answerNum = answerNum;
    }

    public void ballScoreCount() {
        for (int i = 0; i < 3; i++) {
            ballCounting(i);
        }
    }

    public void ballCounting(int position) {
        if (isStrike(position)) {
            this.strikeCount++;
            return;
        }
        if (isBall(position)) {
            this.ballCount++;
            return;
        }
        this.nothing++;
    }

    private boolean isStrike(int position) {
        return this.inputNum.get(position).equals(this.answerNum.get(position));
    }

    private boolean isBall(int position) {
        return this.answerNum.contains(this.inputNum.get(position));
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getNothing() {
        return nothing;
    }
}
