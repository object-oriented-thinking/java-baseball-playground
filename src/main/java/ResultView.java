public class ResultView {


    public static void showStrikeBallNothing(Baseball baseball) {
        if (baseball.strike > 0) {
            System.out.printf("%d스트라이크 ", baseball.strike);
        }
        if (baseball.ball > 0) {
            System.out.printf("%d볼 ",baseball.ball);
        }
        if (baseball.nothing > 0) {
            System.out.print("낫씽");
        }
        System.out.println("");
    }

    public static void resultView(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로시작하려면 1, 종료하려면 2를 입력하세요.");
    }


}
