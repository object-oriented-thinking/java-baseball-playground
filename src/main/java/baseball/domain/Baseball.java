package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baseball {
    private final List<Ball> baseballs;

    public Baseball(final List<Ball> ballList){
        this.baseballs= new ArrayList<>(ballList);
        isDistinct();
    }

    public List<Ball> getBaseballs() {
        return Collections.unmodifiableList(baseballs);
    }

    public void isDistinct(){
        for(int i=0;i<this.baseballs.size();i++){
            for(int j=0;j<i;j++){
                if(this.baseballs.get(i).getNumber() == this.baseballs.get(j).getNumber()){
                    throw new RuntimeException("중복된 값이 있습니다.");
                }
            }
        }
    }
}
