package baseball.service;

import baseball.domain.Action;
import baseball.domain.Ball;
import baseball.domain.Baseball;
import baseball.domain.BaseballStatus;

public class BaseballService {
    public boolean isStrike(Ball userBall, Ball randomBall) {
        return userBall.getNumber() == randomBall.getNumber();
    }

    public boolean isBall(Ball userBall, Baseball randomBall) {
        return randomBall.getBaseballs().stream().anyMatch(ball -> ball.getNumber()==userBall.getNumber());
    }

    public BaseballStatus compare(Baseball userBall, Baseball randomBall) throws Exception {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < userBall.getBaseballs().size(); i++) {
            if (isStrike(userBall.getBaseballs().get(i), randomBall.getBaseballs().get(i))) {
                strike++;
                continue;
            }
            if (isBall(userBall.getBaseballs().get(i), randomBall)) {
                ball++;
            }
        }
        return new BaseballStatus(ball, strike);
    }
}
