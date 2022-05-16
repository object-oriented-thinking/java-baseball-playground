package baseball.infra;

import baseball.domain.Number;
import baseball.domain.Numbers;
import baseball.domain.RandomNumbersSpecification;

import java.util.Arrays;

public class FakeRandomNumbersSpecification implements RandomNumbersSpecification {
    @Override
    public Numbers storeNumber() {
        return new Numbers(Arrays.asList(new Number(4), new Number(9), new Number(3)));
    }
}
