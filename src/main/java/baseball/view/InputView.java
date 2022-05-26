package baseball.view;

import baseball.domain.Ball;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    public Ball inputBall() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");
        String input = scanner.next();
        Set<Integer> integerSet = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toSet());

        return new Ball(integerSet);
    }

    public boolean resumeGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = scanner.nextInt();
        return input == 1;
    }
}