package util;

import java.util.ArrayList;

import static util.Constant.ANSWER_MAX_SIZE;
import static util.Constant.ANSWER_NUMBER_RANGE;

/**
 * 정답 넘버 중복없는 3자리 생성하는 클래스
 */
public class Answer{
    private final ArrayList<Integer> answerNum= new ArrayList<>();

    public ArrayList<Integer> generateNumber() {
        while (answerNum.size() < ANSWER_MAX_SIZE) {
            int element = (int) (Math.random() * ANSWER_NUMBER_RANGE);
            if(isNotContainsNumber(element)){
                answerNum.add(element);
            }
        }
        return this.answerNum;
    }

    private boolean isNotContainsNumber(int element) {
        return !answerNum.contains(element);
    }
}
