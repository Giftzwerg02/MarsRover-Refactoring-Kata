package mars.rover;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static mars.rover.Direction.*;
import static mars.rover.Instruction.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MarsRoverTest {

    @Test
    public void
    acceptance_test_1() {
        String newPosition = MarsRover.move(1, 2, N, L, M, L, M, L, M, L, M, M);
        assertEquals("1 3 N", newPosition);
    }

    @Test
    public void
    acceptance_test_2() {
        String newPosition = MarsRover.move(3, 3, E, M, M, R, M, M, R, M, R, R, M);
        assertEquals("5 1 E", newPosition);
    }

    // region Toni-Tests

    // endregion

    // region Paul-Tests

    // endregion

    // region Patrick-Tests
    //fährt der rover in die richtige richtung
    @Test
    public void driveDirection() {
        /*
         * If the rover is given the command 'MarsRover.move(3,2, 'E', "M");' it
         * should end up on "4 2 E"
         * */
        String roverPos = MarsRover.move(3,2, 'E', "M");
        assertEquals(roverPos, "4 2 E");
    }
    //kann sich der rover nach links drehen
    @Test
    public void turnLeft() {
        /*
         * If the rover is given the command 'MarsRover.move(0, 0, 'N', "L");' it should turn to the left (West)
         * */
        String roverPos1 = MarsRover.move(0, 0, 'N', "L");
        assertEquals(roverPos1, "0 0 W");
        String roverPos2 = MarsRover.move(0, 0, 'W', "L");
        assertEquals(roverPos2, "0 0 S");
        String roverPos3 = MarsRover.move(0, 0, 'S', "L");
        assertEquals(roverPos3, "0 0 E");
        String roverPos4 = MarsRover.move(0, 0, 'E', "L");
        assertEquals(roverPos4, "0 0 N");
    }
    //fährt der rover die richtige weite
    @Test
    public void driveWidth() {
        /*
         * if the rover is given the command MarsRover.move(0, 0, 'E', "MMMM"); it should move 4 squares to the east
         * and thus end up on '4 0 E'
         * */

        String roverPos1 = MarsRover.move(0, 0, 'E', "MMMM");
        assertEquals(roverPos1, "4 0 E");
    }

    // endregion

    // region Benjamin-Tests
    @Test
    public void driveMultipleRoversTest() {
        /*
        * If a rover has finished moving, then the next rover should have an "independent" surrounding
        * --> when given the same call twice (aka. two rovers drive the same path) then the output should be equal
        * as well
        * */

        String roverPos1 = MarsRover.move(1, 2, N, L, M, L, M, L, M, M);
        String roverPos2 = MarsRover.move(1, 2, N, L, M, L, M, L, M, M);
        assertEquals(roverPos1, roverPos2);
    }

    @Test
    public void driveNorthTest() {
        String northPos = MarsRover.move(1,1, N, M);
        assertEquals(northPos, "1 2 N");
    }

    @Test
    public void driveEastTest() {
        String northPos = MarsRover.move(1,1, E, M);
        assertEquals(northPos, "2 1 E");
    }

    @Test
    public void driveSouthTest() {
        String northPos = MarsRover.move(1,1, S, M);
        assertEquals(northPos, "1 0 S");
    }

    @Test
    public void driveWestTest() {
        String northPos = MarsRover.move(1,1, W, M);
        assertEquals(northPos, "0 1 W");
    }

    @Test
    public void positionOutputStyleTest() {
        Pattern outputPattern = Pattern.compile("\\d \\d [NESW]");
        String roverPosition = MarsRover.move(1, 2, N, L, M, L, M, L, M, L, M, M);
        Matcher positionMatcher = outputPattern.matcher(roverPosition);
        assertTrue(positionMatcher.matches());
    }

    // endregion

}