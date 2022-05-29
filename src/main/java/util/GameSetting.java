package util;

import exception.DuplicateNumberException;
import exception.NotOnlyNumberException;
import view.View;

import java.util.ArrayList;

/**
 * 정답을 맞출때까지 게임을 진행하는 클래스
 */
public class GameSetting {
    public void startGame() {
        ArrayList<Integer> answerNumber = getAnswerNumber();
        View view = new View();
        int strikeCount=0;

        do {
            View.printStart();
            // 인풋숫자 받고,검증
            InputNumber inputNumber = new InputNumber();
            if (inputNumberScanAndValidation(inputNumber)) continue;
            ArrayList<Integer> inputNumberArray = getInputNumber(inputNumber);

            // 인풋숫자와 정답을 비교하고, 스코어매기기
            CompareAnswer compareAnswer = new CompareAnswer(inputNumberArray,answerNumber);
            compareAnswer.ballScoreCount();

            // 정답확인하기
            strikeCount = compareAnswer.getStrikeCount();
            view.printResult(compareAnswer);

        }while (strikeCount<3);
    }

    private ArrayList<Integer> getInputNumber(InputNumber inputNumber) {
        return inputNumber.getInputNumArray();
    }

    private boolean inputNumberScanAndValidation(InputNumber inputNumber) {
        try {
            inputNumber.inputNumberValidation(inputNumber.inputNumberScanner());
        } catch (ArrayIndexOutOfBoundsException | NotOnlyNumberException | DuplicateNumberException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    private ArrayList<Integer> getAnswerNumber() {
        Answer answer = new Answer();
        return generateAnswerNumber(answer);
    }

    public void correctAnswer() {
        View.printEnding();
    }

    private ArrayList<Integer> generateAnswerNumber(Answer answer) {
        return answer.generateNumber();
    }

    public void reGame() {
        getAnswerNumber();
    }
}