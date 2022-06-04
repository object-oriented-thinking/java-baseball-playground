package baseball.service;

import baseball.domain.Ball;

import java.util.*;

public class RandomBallGenerator {
    static int MAX_SIZE = 3;
    static int MAX_NUM = 9;

    public List<Ball> makeNum(){
        Random random = new Random();
        Set<Integer> set = new HashSet<>();

        while(set.size()<MAX_SIZE){
            int num = random.nextInt(MAX_NUM)+1;
            set.add(num);
        }

        List<Ball> balls = new ArrayList<>();
        for(int e: set){
            Ball ball = new Ball(e);
            balls.add(ball);
        }
        return balls;
    }
}
