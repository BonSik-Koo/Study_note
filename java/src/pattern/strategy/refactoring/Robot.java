package pattern.strategy.refactoring;

public class Robot implements SpeakStrategy {
    private MoveStrategy moveStrategy; // 인터페이스 의존성(DIP), 다형성, 로직 캡슐화
    private SpeakStrategy speakStrategy;
    private TemperatureStrategy temperatureStrategy; // 단순히 추가하면 됨(OCP)

    public Robot(MoveStrategy moveStrategy, SpeakStrategy speakStrategy) {
        this.moveStrategy = moveStrategy;
        this.speakStrategy = speakStrategy;
    }

    public void move() {
        moveStrategy.move();
    }가
    public void speak() {
        speakStrategy.speak();
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void setSpeakStrategy(SpeakStrategy speakStrategy) {
        this.speakStrategy = speakStrategy;
    }

}
