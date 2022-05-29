package view;

import util.CompareAnswer;

import java.util.Scanner;

import static util.Constant.*;

/**
 * 화면출력용 클래스
 */
public class View {
    public static void printStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printResult(CompareAnswer answer) {
        if (answer.getStrikeCount()>STRIKE_BALL_MIN) {
            System.out.printf("%d스트라이크 ",answer.getStrikeCount());
        }
        if (answer.getBallCount()>STRIKE_BALL_MIN) {
            System.out.printf("%d볼 ",answer.getBallCount());
        }
        if (answer.getNothing()== NOTHING) {
            System.out.print("낫싱");
        }
        System.out.println("");
    }

    public static void printEnding() {
        System.out.println(ALL_NUMBER_CORRECT_MESSAGE);
        System.out.println(CONTINUE_GAME_QUESTION);
    }

    public static boolean isContinue() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt() == 1;
    }
}
