import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] s = line.split(" ");
        int answer = Integer.parseInt(s[0]);

        for (int i = 0; i < s.length; i++) {
            switch (s[i]) {
                case "+":
                    answer += Integer.parseInt(s[i + 1]);
                    break;
                case "-":
                    answer -= Integer.parseInt(s[i + 1]);
                    break;
                case "*":
                    answer *= Integer.parseInt(s[i + 1]);
                    break;
                case "/":
                    answer /= Integer.parseInt(s[i + 1]);
                    break;
            }
        }

        System.out.print(answer);
    }
}
