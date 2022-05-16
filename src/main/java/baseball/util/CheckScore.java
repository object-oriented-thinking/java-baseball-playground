package baseball.util;

import baseball.Baseball;

public class CheckScore {

    private final Baseball baseball;
    private final int[] inputNumber;

    public CheckScore(Baseball baseball, int[] inputNumber) {
        this.baseball = baseball;
        this.inputNumber = inputNumber;
    }

    public void checkStrike() {
        for (int i = 0; i < baseball.getAnswer().length; i++) {
            if (detectedStrike(baseball.getAnswer(), i)) {
                strikePlus(i);
            }
        }
    }

    private void strikePlus(int i) {
        baseball.plusStrike();
        baseball.getTmpMap().put(i, i);
    }

    private boolean detectedStrike(int[] answer, int i) {
        return inputNumber[i] == answer[i];
    }


    public void checkBall() {
        for (int j = 0; j < baseball.getAnswer().length; j++) {
            if (notDuplicate(j)) {
                searchBall(baseball.getAnswer(),j);
            }
        }
    }

    private boolean notDuplicate(int j) {
        return !baseball.getTmpMap().containsKey(j);
    }

    private void searchBall(int[] answer, int j) {
        for (int k = 0; k < answer.length; k++) {
            if (detectBall(answer, j, k)) {
                ballPlus(j, k);
            }
        }
    }

    private void ballPlus(int j, int k) {
        baseball.plusBall();
        baseball.getTmpMap().put(j, k);
    }

    private boolean detectBall(int[] answer, int j, int k) {
        return !baseball.getTmpMap().containsKey(j)&& !baseball.getTmpMap().containsValue(k) && inputNumber[j] == answer[k];
    }

    public void checkNothing() {
        if (isNothing()) {
            baseball.plusNothing();
        }
    }

    private boolean isNothing() {
        return baseball.getBall() == 0 && baseball.getStrike() == 0;
    }

    public static void checkScore(CheckScore chkScore) {
        chkScore.checkStrike();
        chkScore.checkBall();
        chkScore.checkNothing();
    }

}
