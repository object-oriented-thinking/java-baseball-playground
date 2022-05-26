package baseball.domain;

public class BallStatus {
    int ball;
    int strike;

    public BallStatus(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public boolean existsNothing(){
        return ball-strike==0;
    }

    public boolean existsBall() {
        return ball>0;
    }

    public boolean existsStrike() {
        return strike>0;
    }
}
