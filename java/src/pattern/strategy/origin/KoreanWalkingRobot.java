package pattern.strategy.origin;

public class KoreanWalkingRobot extends Robot{
    @Override
    public void display() {
        System.out.println("걷기 로봇입니다.");
    }

    @Override
    public void move() {
        System.out.println("걸어서 움직이는 로봇입니다.");
    }

    @Override
    public void speak() {
        System.out.println("한국어로 얘기합니다.");
    }

}
