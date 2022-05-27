package baseball.service;

import java.util.*;

public class RandomNumGenerator {
    public List<Integer> makeNum(){
        Random random = new Random();
        Set<Integer> set = new HashSet<>();

        while(set.size()<3){
            int num = random.nextInt(9)+1;
            set.add(num);
        }
        return new ArrayList<>(set);
    }
}