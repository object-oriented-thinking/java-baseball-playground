package baseball;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Baseball {
    public List<Integer> inputView() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("숫자를 입력해 주세요 : ");
        String value = scanner.nextLine();

        return Stream.of(value.split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }

    public void resultView(List<Integer> arr) {
        if (arr.stream().mapToInt(i -> i).sum() > 3) {
            throw new ArrayIndexOutOfBoundsException("결과의 전체 합이 3 이하여야 합니다");
        }
        List<String> action = Arrays.asList("볼", "스트라이크", "낫싱");
        if (arr.get(2).equals(3)) {
            System.out.println(action.get(2)); //낫싱
            return;
        }
        if (arr.get(1).equals(3)) {
            System.out.println(arr.get(1) + action.get(1));
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }
        for (int i = 0; i < 2; i++) {
            if (arr.get(i) > 0) {
                System.out.print(arr.get(i) + action.get(i) + " ");
            }
        }
        System.out.println();
    }

    public List<Integer> makeNum() {
        Random random = new Random();
        List<Integer> lst = new ArrayList<>();
        while (lst.size() < 3) {
            int value = random.nextInt(9) + 1;
            if (!lst.contains(value)) {
                lst.add(value);
            }
        }
        return lst;
    }

    public List<Integer> checkNum(List<Integer> randomNum, List<Integer> userNum) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            temp.add(check(i, randomNum, userNum));
        }
        List<Integer> result = new ArrayList<>();

        result.add((int) temp.stream().filter(str -> "볼".equals(str)).count());
        result.add((int) temp.stream().filter(str -> "스트라이크".equals(str)).count());
        result.add((int) temp.stream().filter(str -> "낫싱".equals(str)).count());

        return result;
    }

    public String check(int i, List<Integer> randomNum, List<Integer> userNum) {
        if (randomNum.get(i).equals(userNum.get(i))) {
            return "스트라이크";
        } else if (randomNum.contains(userNum.get(i))) {
            return "볼";
        }
        return "낫싱";
    }
}