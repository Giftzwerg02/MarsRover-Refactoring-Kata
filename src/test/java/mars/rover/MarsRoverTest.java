package mars.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MarsRoverTest {

    @Test
    public void
    acceptance_test_1() {
        String newPosition = MarsRover.move(1, 2, 'N', "LMLMLMLMM");
        assertEquals("1 3 N", newPosition);
    }

    @Test
    public void
    acceptance_test_2() {
        String newPosition = MarsRover.move(3, 3, 'E', "MMRMMRMRRM");
        assertEquals("5 1 E", newPosition);
    }

    // region Toni-Tests

    // endregion

    // region Paul-Tests

    // endregion

    // region Patrick-Tests

    // endregion

    // region Benjamin-Tests
    @Test
    public void generateMultipleRoversTest() {
        MarsRover mr1 = new MarsRover();
        MarsRover mr2 = new MarsRover();
        assertNotEquals(mr1, mr2);
    }

    @Test
    public void startRoverTest() {
        String newPosition = "";
        newPosition = MarsRover.move(1,2, 'N', "5 5");
        assertEquals("1 2 N", newPosition);
    }
    // endregion

}