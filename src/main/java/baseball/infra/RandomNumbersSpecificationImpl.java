package baseball.infra;

import baseball.domain.Number;
import baseball.domain.Numbers;
import baseball.domain.RandomNumbersSpecification;

import java.util.*;

public class RandomNumbersSpecificationImpl implements RandomNumbersSpecification {
    private final static Random random = new Random();
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    @Override
    public Numbers storeNumber() {
        Set<Number> numbers = new HashSet<>();
        do {
            numbers.add(new Number(getNumberOne()));
        } while (numbers.size() != 3);
        List<Number> numberList =new ArrayList<>(numbers);
        return new Numbers(numberList);
    }

    private int getNumberOne() {
        return random.nextInt(MAX_NUMBER) + MIN_NUMBER;
    }
}
