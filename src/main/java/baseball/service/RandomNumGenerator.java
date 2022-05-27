package baseball.service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumGenerator {
    public Set<Integer> makeNum(){
        Random random = new Random();
        Set<Integer> set = new HashSet<>();
        while(set.size()<3){
            int num = random.nextInt(9)+1;
            set.add(num);
        }
        return set;
    }
}