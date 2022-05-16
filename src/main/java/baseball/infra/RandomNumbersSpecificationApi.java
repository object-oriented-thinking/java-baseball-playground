package baseball.infra;

import baseball.domain.Number;
import baseball.domain.Numbers;
import baseball.domain.RandomNumbersSpecification;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class RandomNumbersSpecificationApi implements RandomNumbersSpecification {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    public static final int COUNT = 3;

    @Override
    public Numbers storeNumber() {
        List<Number> numberList = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, COUNT)
            .stream().map(Number::new).collect(Collectors.toList());
        return new Numbers(numberList);
    }

}
