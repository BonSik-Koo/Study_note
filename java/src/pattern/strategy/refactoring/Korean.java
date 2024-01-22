package pattern.strategy.refactoring;

public class Korean implements SpeakStrategy{
    @Override
    public void speak() {
        System.out.println("한국어로 얘기합니다.");
    }
}
