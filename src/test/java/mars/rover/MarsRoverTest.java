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
    public void driveMultipleRoversTest() {
        /*
        * If a rover has finished moving, then the next rover should have an "independent" surrounding
        * --> when given the same call twice (aka. two rovers drive the same path) then the output should be equal
        * as well
        * */

        String roverPos1 = MarsRover.move(1, 2, 'N', "LMLMLMLMM");
        String roverPos2 = MarsRover.move(1, 2, 'N', "LMLMLMLMM");
        assertEquals(roverPos1, roverPos2);
    }

    @Test
    public void driveNorthTest() {
        String northPos = MarsRover.move(1,1, 'N', "M");
        assertEquals(northPos, "1 2 N");
    }

    @Test
    public void driveEastTest() {
        String northPos = MarsRover.move(1,1, 'E', "M");
        assertEquals(northPos, "2 1 E");
    }

    @Test
    public void driveSouthTest() {
        String northPos = MarsRover.move(1,1, 'S', "M");
        assertEquals(northPos, "1 0 S");
    }

    @Test
    public void driveWestTest() {
        String northPos = MarsRover.move(1,1, 'W', "M");
        assertEquals(northPos, "0 1 W");
    }

    // endregion

}