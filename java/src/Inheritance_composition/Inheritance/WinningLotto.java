package Inheritance_composition.Inheritance;

import Inheritance_composition.BonusBall;
import Inheritance_composition.Lotto;
import java.util.List;

public class WinningLotto extends Lotto {
    private BonusBall bonusBall;
    private int ballCount;

    public WinningLotto(List<Integer> numbers, BonusBall bonusBall) {
        super(numbers);
        this.bonusBall = bonusBall;
        this.ballCount = 0;
    }

    @Override
    public void addAll(List<Integer> numbers) {
        this.ballCount += numbers.size();
        super.addAll(numbers);
    }

    @Override
    public void add(Integer number) {
        this.ballCount ++;
        super.add(number);
    }

    public long getMatchedNumberCount(Lotto lotto){
        return numbers.stream()
                .filter(lotto::isContain)
                .count();
    }

    public int getBallCount(){
        return ballCount;
    }
}
