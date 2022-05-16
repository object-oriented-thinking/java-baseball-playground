package baseball.infra;

import baseball.constant.GameStatus;
import baseball.domain.BaseballInputClient;
import baseball.domain.Number;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BaseballInputClientImpl implements BaseballInputClient {

    private static final String SEPARATION_UNIT = " ";
    private final static Scanner scanner = new Scanner(System.in);
    private static final int STOP_NUMBER = -1;

    @Override
    public List<Number> inputNumbers() {
        return Arrays.stream(scanner.nextLine().split(SEPARATION_UNIT))
            .map(Number::new).collect(Collectors.toList());
    }

    @Override
    public GameStatus command() {
        System.out.println("게임을 종료하고 싶으시면 " + STOP_NUMBER + "나 문자를 눌려주세요");
        System.out.println("진행을 계속해서 원하시면 1에서 9사이 숫자를 입력해주세요.");

        String response = scanner.next();
        if (!response.chars().allMatch(Character::isDigit)) {
            System.out.println("게임을 종료합니다.");
            return GameStatus.STOP;
        }

        int integer = Integer.parseInt(response);
        if (integer == STOP_NUMBER) {
            System.out.println("게임을 종료합니다.");
            return GameStatus.STOP;
        }

        System.out.println("게임을 계속해서 진행합니다.");
        return GameStatus.GO;
    }
}
