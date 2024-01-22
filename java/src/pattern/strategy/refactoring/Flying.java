package pattern.strategy.refactoring;

public class Flying implements MoveStrategy{
    @Override
    public void move() {
        System.out.println("날아서 움직이는 로봇입니다.");
    }
}
