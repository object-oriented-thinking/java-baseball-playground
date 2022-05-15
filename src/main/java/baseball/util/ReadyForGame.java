package baseball.util;

import baseball.Baseball;
import baseball.view.InputView;
import baseball.view.ResultView;

import java.util.Scanner;

public class ReadyForGame {

    public static int[] generateNumber() {
        int[] answer =new int[3];
        for (int i = 0; i < answer.length; i++) {
            answer[i]= (int) (Math.random() * 10);
        }
        return answer;
    }


    public static int[] InputAndSplit() {
        InputView inputView = new InputView();
        return inputView.InputAndSplit();
    }

    public static int showResultAndCheckContinue() {
        ResultView.printResult();
        return getCheckContinue();
    }

    private static int getCheckContinue() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static boolean correctAnswer(Baseball baseball) {
        return baseball.strike == 3;
    }


    public static void initVar(Baseball baseball) {
        baseball.strike=0;
        baseball.ball=0;
        baseball.nothing=0;
        baseball.tmpMap.clear();
    }

    public static int[] newAnswer(Baseball baseball) {
        int[] answer;
        initVar(baseball);
        answer= generateNumber();
        return answer;
    }
}
