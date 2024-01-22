package pattern.strategy.refactoring;

import org.junit.jupiter.api.Test;

class RobotTest {

    @Test
    void RobotByStrategy() {
        Robot robot = new Robot(new Flying(), new English());
        robot.move();
        robot.speak();

        robot.setMoveStrategy(new Walking());
        robot.move();
    }

}