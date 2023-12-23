package Inheritance_composition;

import java.util.List;

public class Lotto {
    protected List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void addAll(List<Integer> numbers){
        numbers.forEach(this::add);
    }

    public void add(Integer number){
        this.numbers.add(number);
    }

    public long getMatchedNumberCount(Lotto lotto){
        return lotto.numbers
                .stream()
                .filter(lotto::isContain)
                .count();
    }
    public boolean isContain(Integer number){
        return this.numbers.contains(number);
    }

}
