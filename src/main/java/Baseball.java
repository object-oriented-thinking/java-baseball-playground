import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Baseball {

    int strike=0;
    int ball=0;
    int nothing=0;
    Map<Integer, Integer> tmpMap = new HashMap<>();

    public static void main(String[] args) {
        int checkContinue=1;
        Baseball baseball = new Baseball();
        int[] answer = generateNumber();


       do {
           int[] inputNumber = InputNumberAndSplit();

           checkStrike(baseball, answer, inputNumber);
           checkBall(baseball, answer, inputNumber);
           checkNothing(baseball);

            ResultView.showStrikeBallNothing(baseball);

            if (correctAnswer(baseball)) {
                checkContinue = showResultAndCheckContinue();
                answer = newAnswer(baseball);
            }
            initVar(baseball);
        }while (checkContinue==1);
    }


    private static void checkBall(Baseball baseball, int[] answer, int[] inputNumber) {
        for (int j = 0; j < answer.length; j++) {
            if (notDuplicate(baseball, j)) {
                searchBall(baseball, answer, inputNumber, j);
            }
        }
    }

    private static boolean notDuplicate(Baseball baseball, int j) {
        return !baseball.tmpMap.containsKey(j);
    }

    private static void searchBall(Baseball baseball, int[] answer, int[] inputNumber, int j) {
        for (int k = 0; k < answer.length; k++) {
            if (detectBall(baseball, answer, inputNumber, j, k)) {
                ballFlag(baseball, j, k);
            }
        }
    }

    private static void ballFlag(Baseball baseball, int j, int k) {
        baseball.ball++;
        baseball.tmpMap.put(j, k);
    }

    private static boolean detectBall(Baseball baseball, int[] answer, int[] inputNumber, int j, int k) {
        return !baseball.tmpMap.containsKey(j)&& !baseball.tmpMap.containsValue(k) && inputNumber[j] == answer[k];
    }




    private static void checkStrike(Baseball baseball, int[] answer, int[] inputNumber) {
        for (int i = 0; i < answer.length; i++) {
            if (detectedStrike(answer, inputNumber, i)) {
                StrikeFlag(baseball, inputNumber, i);
            }
        }
    }

    private static void StrikeFlag(Baseball baseball, int[] inputNumber, int i) {
        baseball.strike++;
        baseball.tmpMap.put(i, i);
    }

    private static boolean detectedStrike(int[] answer, int[] inputNumber, int i) {
        return inputNumber[i] == answer[i];
    }


    public static int[] generateNumber() {
        int[] answer =new int[3];
        for (int i = 0; i < answer.length; i++) {
            answer[i]= (int) (Math.random() * 10);
        }
        return answer;
    }


    public static int[] InputNumberAndSplit() {
        InputView inputView = new InputView();
        return inputView.InputAndSplit();
    }

    public static int showResultAndCheckContinue() {
        ResultView.resultView();
        return getCheckContinue();
    }

    private static int getCheckContinue() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static boolean correctAnswer(Baseball baseball) {
        return baseball.strike == 3;
    }

    public static void checkNothing(Baseball baseball) {
        if (baseball.ball == 0 && baseball.strike==0) {
            baseball.nothing++;
        }
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
