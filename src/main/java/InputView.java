import java.util.Scanner;

public class InputView {

    public int[] InputAndSplit() {
        String inputNumber = getInputNumber();
        return split(inputNumber);
    }

    private String getInputNumber() {
        System.out.print("숫자를 입력해주세요: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private int[] split(String inputNumber) {
        String[] split = inputNumber.split("");
        int[] splitedInputNumber = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            splitedInputNumber[i] = Integer.parseInt(split[i]);
        }

        return splitedInputNumber;
    }
}
