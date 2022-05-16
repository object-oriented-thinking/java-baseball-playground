package baseball.domain;

import baseball.constant.GameStatus;

import java.util.List;

public interface BaseballInputClient {
    List<Number> inputNumbers();

    GameStatus command();
}
