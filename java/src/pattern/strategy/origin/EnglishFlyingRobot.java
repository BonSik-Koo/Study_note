package pattern.strategy.origin;

public class EnglishFlyingRobot extends Robot{
    @Override
    public void display() {
        System.out.println("나는 로봇입니다.");
    }

    @Override
    public void move() {
        System.out.println("날아서 움직이는 로봇입니다.");
    }

    @Override
    public void speak() {
        System.out.println("영어로 얘기합니다.");
    }

}
