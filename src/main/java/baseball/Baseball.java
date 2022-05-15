package baseball;

import java.util.HashMap;
import java.util.Map;

public class Baseball {

    public int strike=0;
    public int ball=0;
    public int nothing=0;
    public int[] answer;
    public Map<Integer, Integer> tmpMap = new HashMap<>();

    public Baseball(int[] answer) {
        this.answer = answer;
    }
}
