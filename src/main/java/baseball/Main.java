package baseball;

import baseball.util.CheckScore;
import baseball.view.ResultView;

import static baseball.util.CheckScore.checkScore;
import static baseball.util.ReadyForGame.*;

public class Main {

    public static void main(String[] args) {

        int checkContinue=1;
        int[] answer = generateNumber();
        Baseball baseball = new Baseball(answer);

       do {
           int[] inputNumber = InputAndSplit();

           CheckScore cs = new CheckScore(baseball, inputNumber);
           checkScore(cs);

           ResultView.printStrikeBallNothing(baseball);

            if (correctAnswer(baseball)) {
                checkContinue = showResultAndCheckContinue();
                baseball.answer = newAnswer(baseball);
            }

            initVar(baseball);
        }while (checkContinue==1);
    }

}
