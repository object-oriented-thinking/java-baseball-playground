package baseball.domain;

public class BaseballStatus {
    int ball;
    int strike;

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    @Override
    public String toString() {
        return "BaseballStatus{" +
                "ball=" + ball +
                ", strike=" + strike +
                '}';
    }

    public boolean nothing() {
        return strike == 0 && ball == 0;
    }

    public boolean existsBall() {
        return ball > 0;
    }

    public boolean existsStrike() {
        return strike > 0;
    }

    public boolean exitGame() {
        return getStrike() == 3;
    }
}
