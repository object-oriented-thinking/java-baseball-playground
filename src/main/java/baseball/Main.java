package baseball;

import baseball.util.CheckScore;
import baseball.view.ResultView;

import static baseball.util.CheckScore.checkScore;
import static baseball.util.ReadyForGame.*;

public class Main {

    private static int ContinueCount=1;

    public static void main(String[] args) {
        int[] answer = generateNumber();
        Baseball baseball = new Baseball(answer);

       do {
           int[] inputNumber = InputAndSplit();

           CheckScore cs = new CheckScore(baseball, inputNumber);
           checkScore(cs);

           ResultView.printStrikeBallNothing(baseball);

            if (correctAnswer(baseball)) {
                checkContinue();
                baseball.setAnswer(newAnswer(baseball));
            }

            initVar(baseball);
        }while (ContinueCount==1);
    }

    private static void checkContinue() {
        ContinueCount = showResultAndCheckContinue();
    }

}
