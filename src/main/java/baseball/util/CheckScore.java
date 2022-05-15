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
        for (int i = 0; i < baseball.answer.length; i++) {
            if (detectedStrike(baseball.answer, inputNumber, i)) {
                StrikeFlag(baseball, i);
            }
        }
    }

    private void StrikeFlag(Baseball baseball, int i) {
        baseball.strike++;
        baseball.tmpMap.put(i, i);
    }

    private boolean detectedStrike(int[] answer, int[] inputNumber, int i) {
        return inputNumber[i] == answer[i];
    }


    public void checkBall() {
        for (int j = 0; j < baseball.answer.length; j++) {
            if (notDuplicate(baseball, j)) {
                searchBall(baseball, baseball.answer, inputNumber, j);
            }
        }
    }

    private boolean notDuplicate(Baseball baseball, int j) {
        return !baseball.tmpMap.containsKey(j);
    }

    private void searchBall(Baseball baseball, int[] answer, int[] inputNumber, int j) {
        for (int k = 0; k < answer.length; k++) {
            if (detectBall(baseball, answer, inputNumber, j, k)) {
                ballFlag(baseball, j, k);
            }
        }
    }

    private void ballFlag(Baseball baseball, int j, int k) {
        baseball.ball++;
        baseball.tmpMap.put(j, k);
    }

    private boolean detectBall(Baseball baseball, int[] answer, int[] inputNumber, int j, int k) {
        return !baseball.tmpMap.containsKey(j)&& !baseball.tmpMap.containsValue(k) && inputNumber[j] == answer[k];
    }

    public void checkNothing() {
        if (baseball.ball == 0 && baseball.strike==0) {
            baseball.nothing++;
        }
    }

    public static void checkScore(CheckScore chkScore) {
        chkScore.checkStrike();
        chkScore.checkBall();
        chkScore.checkNothing();
    }



}
