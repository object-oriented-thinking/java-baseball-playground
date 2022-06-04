package baseball.view;

import baseball.domain.Ball;
import baseball.domain.Baseball;

import java.util.*;
import java.util.stream.Collectors;


public class InputView {
    static int MAX_SIZE = 3;

    private void isValidInput(List<Ball> ballList) throws RuntimeException{
        if(ballList.size()!=MAX_SIZE){
            throw new RuntimeException("3자리 숫자여야 합니다.");
        }
        if(!ballList.stream().allMatch(ball -> ball.getNumber()>0 && ball.getNumber()<=9)){
            throw new RuntimeException("범위를 벗어납니다.");
        }
    }

    public Baseball inputBall() throws RuntimeException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");
        String input = scanner.next();
        List<Ball> list = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).mapToObj(Ball::new).collect(Collectors.toList());
        isValidInput(list);
        return new Baseball(list);
    }

    public boolean resumeGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = scanner.nextInt();
        return input == 1;
    }


}
