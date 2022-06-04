package baseball.domain;

public class BaseballStatus {
    private final int ball;
    private final int strike;

    public BaseballStatus(int ball, int strike) throws Exception {
        this.ball = ball;
        this.strike = strike;
        this.isValid();
    }
    private void isValid() throws Exception{
        if (!this.existsBall() && !this.existsStrike() && !this.nothing())
            throw new Exception("결과를 반환할 수 없습니다");
    }


    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
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
