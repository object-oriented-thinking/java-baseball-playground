package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BaseballMain {
    public static void main(String[] args) {
        Baseball baseball = new Baseball();

        while (true) {
            List<Integer> randomNum = baseball.makeNum();

            List<Integer> check = Arrays.asList(0, 0, 0);

            while (check.get(1) != 3) { //3스트라이크 전까지
                System.out.println(randomNum);
                List<Integer> userNum = baseball.inputView();

                check = baseball.checkNum(randomNum, userNum);
                baseball.resultView(check);
            }
            System.out.println("새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            Scanner scanner = new Scanner(System.in);
            int resume = scanner.nextInt();
            if (resume == 2) {
                break;
            }
        }
    }
}
