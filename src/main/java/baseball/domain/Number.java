package baseball.domain;

import java.util.Objects;

public class Number {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private final int number;

    public Number(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("1 이상 9 이하의 자연수가 들어가야 합니다.");
        }
        this.number = number;
    }

    public Number(String number) {
        this(Integer.parseInt(number));
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return getNumber() == number1.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
}
