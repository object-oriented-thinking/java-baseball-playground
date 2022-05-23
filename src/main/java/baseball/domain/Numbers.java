package baseball.domain;

import baseball.error.NumberDuplicateException;
import baseball.error.NumberOfInputException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Numbers {
    private static final int NUMBERS_SIZE = 3;
    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        if (!Objects.equals(numbers.size(), NUMBERS_SIZE)) {
            throw new NumberOfInputException("1 이상 9 이하의 숫자만 가능합니다.");
        }

        numbers.forEach(integer -> {
            if (Collections.frequency(numbers, integer) == 2) {
                throw new NumberDuplicateException("중복된 숫자는 들어가지 않습니다.");
            }
        });

        this.numbers = new ArrayList<>(numbers);
    }


    public List<Number> getNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }

    public Result compareTo(Numbers numbers) {
        int strike = 0;
        int ball = 0;
        for (Number inputNumber : numbers.getNumbers()) {
            if (this.getNumbers().contains(inputNumber)) {
                if (this.getNumbers().indexOf(inputNumber) == numbers.getNumbers().indexOf(inputNumber)) {
                    strike += 1;
                    continue;
                }
                ball += 1;
            }
        }
        if (strike + ball == 0) {
            return new Result(strike, ball, true);
        }
        return new Result(strike, ball, false);
    }

}
