package pattern.strategy.origin;

public abstract class Robot {
    public abstract void display();
    public abstract void move();
    public abstract void speak(); // 메소드 추가 -> 구현 알고리즘 개수 만큼 클래스 배로 증가
}
