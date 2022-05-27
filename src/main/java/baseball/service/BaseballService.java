package baseball.service;

import baseball.domain.Baseball;
import baseball.domain.BaseballStatus;

public class BaseballService {
    public boolean isStrike(int userNum, int randomNum) {
        return userNum == randomNum;
    }

    public boolean isBall(int userNum, int userIdx, Baseball randomBall) {
        if (!isStrike(userNum, randomBall.getBaseballs().get(userIdx))) {
            return randomBall.getBaseballs().contains(userNum);
        }
        return false;
    }

    public BaseballStatus compare(Baseball userBall, Baseball randomBall) {
        int strike = 0, ball = 0;
        for (int i = 0; i < userBall.getBaseballs().size(); i++) {
            if (isStrike(userBall.getBaseballs().get(i), randomBall.getBaseballs().get(i))) {
                strike++;
                continue;
            }
            if (isBall(userBall.getBaseballs().get(i), i, randomBall)) {
                ball++;
            }
        }
        BaseballStatus baseballStatus = new BaseballStatus();
        baseballStatus.setBall(ball);
        baseballStatus.setStrike(strike);
        return baseballStatus;
    }
}
