package calculator;

import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();

        System.out.println(calculator.calculate(value));
    }
}
