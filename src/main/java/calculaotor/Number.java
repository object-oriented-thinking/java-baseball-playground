package calculaotor;

import java.util.Objects;

import static calculaotor.Delimiter.*;

public class Number {
    private final Long number;

    public Number(final Long number) {
        this.number = number;
    }

    public Number(final String number) {
        if (number.trim().isEmpty()) {
            throw new RuntimeException();
        }
        this.number = Long.parseLong(number);
    }

    public Long getNumber() {
        return number;
    }

    public Number calculate(Delimiter delimiter, Number number) {
        if (Objects.equals(delimiter, PLUS)) {
            return new Number(this.number + number.getNumber());
        } else if (Objects.equals(delimiter, MINUS)) {
            return new Number(this.number - number.getNumber());
        } else if (Objects.equals(delimiter, MULTIPLICATION)) {
            return new Number(this.number * number.getNumber());
        } else if (Objects.equals(delimiter, DIVISION)) {
            return new Number(this.number / number.getNumber());
        } else {
            throw new RuntimeException();
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return Objects.equals(getNumber(), number1.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
}
