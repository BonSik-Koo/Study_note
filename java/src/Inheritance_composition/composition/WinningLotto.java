package Inheritance_composition.composition;

import Inheritance_composition.BonusBall;
import Inheritance_composition.Lotto;
import java.util.List;

public class WinningLotto {
    private Lotto lotto;
    private BonusBall bonusBall;
    private int ballCount;

    public WinningLotto(Lotto lotto, BonusBall bonusBall) {
        this.lotto = lotto;
        this.bonusBall = bonusBall;
        this.ballCount = 0;
    }

    public void addAll(List<Integer> numbers) {
        this.ballCount += numbers.size();
        lotto.addAll(numbers);
    }

    public void add(Integer number) {
        this.ballCount ++;
        lotto.add(number);
    }

    public int getBallCount(){
        return ballCount;
    }

    public long getMatchedNumberCount(Lotto lotto){
        return this.lotto
                .getMatchedNumberCount(lotto);
    }

}
