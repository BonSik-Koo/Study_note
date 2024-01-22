package pattern.strategy.refactoring;

public class Walking implements MoveStrategy {
    @Override
    public void move() {
        System.out.println("걷기 로봇입니다.");
    }
}
