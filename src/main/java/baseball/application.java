package baseball;

import baseball.domain.Ball;
import baseball.domain.Baseball;
import baseball.domain.BaseballStatus;
import baseball.service.BaseballService;
import baseball.service.RandomBallGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.stream.Collectors;

public class application {
    public static void main(String[] args) throws Exception {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RandomBallGenerator randomBallGenerator = new RandomBallGenerator();
        BaseballService baseballService = new BaseballService();

        do {
            Baseball randomBaseball = new Baseball(randomBallGenerator.makeNum());
            BaseballStatus baseballStatus;
            do {
                Baseball userBaseball = inputView.inputBall();
                baseballStatus = baseballService.compare(userBaseball, randomBaseball);
                outputView.printBaseballStatus(baseballStatus);
            } while (!outputView.exitGame(baseballStatus));

        }while(inputView.resumeGame());
    }
}
