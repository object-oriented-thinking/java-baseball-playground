package baseball.domain;

import java.util.Set;

public class Ball {
    Set<Integer> balls;

    public Ball(Set<Integer> balls) {
        this.balls = balls;
    }

    public Set<Integer> getBalls() {
        return balls;
    }
}