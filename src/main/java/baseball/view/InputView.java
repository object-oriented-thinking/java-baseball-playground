package baseball.view;

import baseball.domain.Baseball;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public Baseball inputBall() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");
        String input = scanner.next();
        List<Integer> list = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        if(list.size()!=3){
            throw new Exception("3자리 숫자여야 합니다.");
        }

        return new Baseball(list);
    }

    public boolean resumeGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = scanner.nextInt();
        return input == 1;
    }
}