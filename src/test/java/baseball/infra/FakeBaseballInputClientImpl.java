package baseball.infra;

import baseball.constant.GameStatus;
import baseball.domain.BaseballInputClient;
import baseball.domain.Number;

import java.util.Arrays;
import java.util.List;

public class FakeBaseballInputClientImpl implements BaseballInputClient {
    @Override
    public List<Number> inputNumbers() {
        return Arrays.asList(new Number(4), new Number(9), new Number(3));
    }

    @Override
    public GameStatus command() {
        return GameStatus.STOP;
    }
}
