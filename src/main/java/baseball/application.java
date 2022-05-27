package baseball;

import baseball.domain.Baseball;
import baseball.domain.BaseballStatus;
import baseball.service.BaseballService;
import baseball.service.RandomNumGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Arrays;

public class application {
    public static void main(String[] args) throws Exception {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RandomNumGenerator randomNumGenerator = new RandomNumGenerator();
        BaseballService baseballService = new BaseballService();

        while(true){
            //Baseball randomBaseball = new Baseball(randomNumGenerator.makeNum());
            Baseball randomBaseball = new Baseball(Arrays.asList(4,2,5));
            BaseballStatus baseballStatus = new BaseballStatus();

            while(!outputView.exitGame(baseballStatus)){
                Baseball userBaseball = inputView.inputBall();
                baseballStatus = baseballService.compare(userBaseball, randomBaseball);
                outputView.printBaseballStatus(baseballStatus);
            }
            if(!inputView.resumeGame()){
                break;
            }
        }
    }
}
