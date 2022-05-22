package baseball;

import java.util.*;

public class Baseball {
    public List<Integer> inputView() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> lst = new ArrayList<Integer>();

        for (int i = 0; i < 3; i++) {
            int value = scanner.nextInt();
            lst.add(value);
        }
        return lst;
    }

    public void resultView(int[] arr) {
        List<String> action = Arrays.asList("볼", "스트라이크", "낫싱");
        for (int i = 0; i < 3; i++) {
            if (arr[i] > 0) {
                System.out.print(arr[i] + action.get(i) + " ");
            }
        }
    }


}
