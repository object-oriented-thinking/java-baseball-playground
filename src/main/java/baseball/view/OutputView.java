package baseball.view;

import baseball.domain.Action;
import baseball.domain.BaseballStatus;

public class OutputView {
    public String outputBaseballStatus(BaseballStatus baseballStatus) throws Exception {
        String result = "";
        if (!baseballStatus.existsBall() && !baseballStatus.existsStrike() && !baseballStatus.nothing())
            throw new Exception("결과를 반환할 수 없습니다");
        if (baseballStatus.existsBall()) {
            result += baseballStatus.getBall() + Action.볼.toString() + " ";
        }
        if (baseballStatus.existsStrike()) {
            result += baseballStatus.getStrike() + Action.스트라이크.toString();
        }
        if (baseballStatus.nothing()) {
            return Action.낫싱.toString();
        }
        return result;
    }

    public void printBaseballStatus(BaseballStatus baseballStatus) throws Exception {
        System.out.println(outputBaseballStatus(baseballStatus));
    }

    public boolean exitGame(BaseballStatus ballStatus) {
        if (ballStatus.exitGame()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
}