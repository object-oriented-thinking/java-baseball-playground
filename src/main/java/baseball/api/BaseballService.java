package baseball.api;

import baseball.domain.BaseballInputClient;
import baseball.domain.Number;
import baseball.domain.Numbers;
import baseball.domain.RandomNumbersSpecification;
import baseball.error.NumberDuplicateException;
import baseball.error.NumberOfInputException;
import baseball.result.Result;

import java.util.List;

public class BaseballService {

    private final RandomNumbersSpecification randomNumbersSpecification;

    private final BaseballInputClient baseballInputClient;

    public BaseballService(RandomNumbersSpecification randomNumbersSpecification, BaseballInputClient baseballInputClient) {
        this.randomNumbersSpecification = randomNumbersSpecification;
        this.baseballInputClient = baseballInputClient;
    }

    public void startBaseball() {
        Numbers storeNumbers = storeRandomNumbers();
        while (true) {
            try {
                Numbers inputNumbers = inputNumbers();
                Result result = inputNumbers.compareTo(storeNumbers);
                if (result.isThreeStrikes()) {
                    break;
                }
                System.out.println(result.hint());
            } catch (IllegalArgumentException e) {
                break;
            }
        }
    }

    public Numbers storeRandomNumbers() {
        try {
            return randomNumbersSpecification.storeNumber();
        } catch (NumberDuplicateException e) {
            return storeRandomNumbers();
        }
    }

    public Numbers inputNumbers() {
        List<Number> request = baseballInputClient.inputNumbers();
        try {
            return new Numbers(request);
        } catch (NumberOfInputException e) {
            System.out.println(e.getMessage());
            return inputNumbers();
        } catch (NumberDuplicateException e) {
            System.out.println(e.getMessage());
            return inputNumbers();
        }
    }
}
