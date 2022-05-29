import util.GameSetting;
import view.View;

public class Main {
    public static void main(String[] args) {
        GameSetting gameSetting = new GameSetting();
        do {
            gameSetting.startGame();
            gameSetting.correctAnswer();
            if (isNotContinueGame()) {
                break;
            }
            gameSetting.reGame();
        } while(true);
    }

    private static boolean isNotContinueGame() {
        return !View.isContinue();
    }
}
