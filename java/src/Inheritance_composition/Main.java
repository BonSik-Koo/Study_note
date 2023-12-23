package Inheritance_composition;

//import Inheritance_composition.Inheritance.WinningLotto;
import Inheritance_composition.composition.WinningLotto;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        BonusBall bonusBall = new BonusBall(10);

        // 상속 - 메서드 오버라이딩 문제
//        WinningLotto winningLotto = new WinningLotto(new ArrayList<>(), bonusBall);
//        System.out.println("초기 로또 번호 개수 = " + winningLotto.getBallCount());
//
//        winningLotto.addAll(List.of(1, 2, 3));
//        System.out.println("예상 로또 번호 개수 = 3");
//        System.out.println("실제 로또 번호 개수 = " + winningLotto.getBallCount());


        // 컴포지션 - 메서드 오버라이딩 문제 해결
        Lotto lotto = new Lotto(new ArrayList<>());
        WinningLotto winningLotto = new WinningLotto(lotto, bonusBall);
        System.out.println("초기 로또 번호 개수 = " + winningLotto.getBallCount());

        winningLotto.addAll(List.of(1, 2, 3));
        System.out.println("예상 로또 번호 개수 = 3");
        System.out.println("실제 로또 번호 개수 = " + winningLotto.getBallCount());
    }

}
