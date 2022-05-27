package baseball.view;

import baseball.domain.Action;
import baseball.domain.BallStatus;

public class OutputView {
    public String outputBallStatus(BallStatus ballStatus) throws Exception {
        String result = "";
        if (!ballStatus.existsBall() && !ballStatus.existsStrike() && !ballStatus.existsNothing())
            throw new Exception("결과를 반환할 수 없습니다");
        if (ballStatus.existsBall()) {
            result += ballStatus.getBall() + Action.볼.toString() + " ";
        }
        if (ballStatus.existsStrike()) {
            result += ballStatus.getStrike() + Action.스트라이크.toString();
        }
        if (ballStatus.existsNothing()) {
            return Action.낫싱.toString();
        }
        return result;
    }

    public boolean exitGame(BallStatus ballStatus) {
        if (ballStatus.exitGame()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
}