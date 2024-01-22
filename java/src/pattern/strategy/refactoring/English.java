package pattern.strategy.refactoring;

public class English implements SpeakStrategy{
    @Override
    public void speak() {
        System.out.println("영어로 얘기합니다.");
    }
}
