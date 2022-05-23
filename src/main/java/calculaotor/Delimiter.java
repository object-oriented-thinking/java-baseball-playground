package calculaotor;

import java.util.Objects;

public enum Delimiter {
    PLUS("+"),
    MINUS("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private final String delimiter;

    Delimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public static Delimiter findDelimiter(String delimiter) {
        if (Objects.equals(delimiter, PLUS.delimiter)) {
            return Delimiter.PLUS;
        } else if (Objects.equals(delimiter, MINUS.delimiter)) {
            return Delimiter.MINUS;
        } else if (Objects.equals(delimiter, MULTIPLICATION.delimiter)) {
            return Delimiter.MULTIPLICATION;
        } else if (Objects.equals(delimiter, DIVISION.delimiter)) {
            return Delimiter.DIVISION;
        } else {
            throw new RuntimeException();
        }
    }
}
