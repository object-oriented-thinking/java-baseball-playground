package baseball.domain;

import java.util.List;

public class Baseball {
    List<Integer> baseballs;

    public Baseball(List<Integer> balls) {
        this.baseballs = balls;
    }

    public List<Integer> getBaseballs() {
        return baseballs;
    }
}