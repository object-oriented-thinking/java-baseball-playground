package calculaotor;

import java.util.*;

public class StringCalculator {
    private static final String REGEX = " ";
    private static final String DELIMITER = "*-+/";

    private final Number result;

    public StringCalculator(String expression) {
        this.result = calculate(expression);
    }

    private Number calculate(String expression) {
        String[] expressionSplit = expression.split(REGEX);

        Deque<Delimiter> delimiter = new ArrayDeque<>();
        Deque<Number> numbers = new ArrayDeque<>();

        Arrays.stream(expressionSplit).forEach(s -> {
            if (!DELIMITER.contains(s)) {
                numbers.addLast(new Number(s));
            } else {
                delimiter.addLast(Delimiter.findDelimiter(s));
            }
        });

        Number number = numbers.stream()
            .reduce((number1, number2) -> number1.calculate(delimiter.pollFirst(), number2))
            .orElseThrow(RuntimeException::new);

        return number;
    }

    public void printResult() {
        System.out.println("result is " + this.result.getNumber());
    }
}
