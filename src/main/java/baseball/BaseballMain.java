package baseball;

import baseball.api.BaseballService;
import baseball.constant.GameStatus;
import baseball.domain.BaseballInputClient;
import baseball.domain.RandomNumbersSpecification;
import baseball.infra.BaseballInputClientImpl;
import baseball.infra.RandomNumbersSpecificationApi;

public class BaseballMain {
    public static void main(String[] args) {
        System.out.println("게임을 시작합니다!");
        RandomNumbersSpecification randomNumbersSpecification = new RandomNumbersSpecificationApi();
        BaseballInputClient baseballInputClient = new BaseballInputClientImpl();
        do {
            BaseballService baseballService = new BaseballService(randomNumbersSpecification, baseballInputClient);
            baseballService.startBaseball();
        } while (!baseballInputClient.command().equals(GameStatus.STOP));
    }
}
