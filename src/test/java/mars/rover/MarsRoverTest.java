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
        MarsRover rover = new MarsRover(1, 2, 10, 10, N);
        String newPosition = rover.move(L, M, L, M, L, M, L, M, M);
        assertEquals("1 3 N", newPosition);
    }

    @Test
    public void
    acceptance_test_2() {
        MarsRover rover = new MarsRover(3, 3, 10, 10, E);
        String newPosition = rover.move(M, M, R, M, M, R, M, R, R, M);
        assertEquals("5 1 E", newPosition);
    }

    // region Toni-Tests

    // endregion

    // region Paul-Tests

    @Test
    public void north_border() {
        MarsRover test = new MarsRover(5,5,5, 5, N);
        String pos = test.move(M);
        assertEquals("5 5 N", pos);
    }

    @Test
    public void east_border() {
        MarsRover test = new MarsRover(5, 5,5, 5, E);
        String pos = test.move(M);
        assertEquals("5 5 E", pos);
    }

    @Test
    public void south_border() {
        MarsRover test = new MarsRover(0,0, 5, 5, S);
        String pos = test.move(M);
        assertEquals("0 0 S", pos);
    }

    @Test
    public void west_border() {
        MarsRover test = new MarsRover(0,0, 5, 5, W);
        String pos = test.move(M);
        assertEquals("0 0 W", pos);
    }

    @Test
    public void drive_right() {
        MarsRover test = new MarsRover(2,2,8, 8, N);
        String pos = test.move(R, M);
        assertEquals("3 2 E", pos);
    }

    @Test
    public void drive_right2() {
        MarsRover test = new MarsRover(2,2,8, 8, N);
        String pos = test.move(R, R, M);
        assertEquals("2 1 S", pos);
    }

    @Test
    public void drive_right3() {
        MarsRover test = new MarsRover(2,2,8, 8, N);
        String pos = test.move(R, R, R, M);
        assertEquals("1 2 W", pos);
    }

    @Test
    public void drive_right4() {
        MarsRover test = new MarsRover(2,2,8, 8, N);
        String pos = test.move(R, R, R, R, M);
        assertEquals("2 3 N", pos);
    }

    @Test
    public void direction_North() {
        MarsRover test = new MarsRover(2,2,10, 10, N);
        String pos = test.move(R, R, R, L, L, L);
        assertEquals("2 2 N", pos);
    }

    @Test
    public void directions_East() {
        MarsRover test = new MarsRover(2,2,10, 10, N);
        String pos = test.move(R, R, L);
        assertEquals("2 2 E", pos);

    }

    @Test
    public void directions_South() {
        MarsRover test = new MarsRover(2,2,10, 10, N);
        String pos = test.move(L, L, R, R, R, R);
        assertEquals("2 2 S", pos);

    }

    @Test
    public void directions_West() {
        MarsRover test = new MarsRover(2,2,10, 10, N);
        String pos = test.move(L, R, R, L, L);
        assertEquals("2 2 W", pos);

    }

    // endregion

    // region Patrick-Tests
    @Test
    public void driveDirection() {
        /*
         * If the rover is given the command 'MarsRover.move(3,2, 'E', "M");' it
         * should end up on "4 2 E"
         * */
        MarsRover rover = new MarsRover(3,2,10,10, E);
        String roverPos = rover.move(M);
        assertEquals(roverPos, "4 2 E");
    }

    @Test
    public void turnLeft() {
        /*
         * If the rover is given the command 'MarsRover.move(0, 0, 'N', "L");' it should turn to the left (West)
         * */
        MarsRover rover1 = new MarsRover(0,0,10,10, N);
        String roverPos1 = rover1.move(L);
        assertEquals(roverPos1, "0 0 W");

        MarsRover rover2 = new MarsRover(0,0,10,10, W);
        String roverPos2 = rover2.move(L);
        assertEquals(roverPos2, "0 0 S");

        MarsRover rover3 = new MarsRover(0,0,10,10, S);
        String roverPos3 = rover3.move(L);
        assertEquals(roverPos3, "0 0 E");

        MarsRover rover4 = new MarsRover(0,0,10,10, E);
        String roverPos4 = rover4.move(L);
        assertEquals(roverPos4, "0 0 N");

    }

    @Test
    public void driveWidth() {
        /*
         * If the rover is given the command MarsRover.move(0, 0, 'E', "MMMM"); it should move 4 squares to the east
         * and thus end up on '4 0 E'
         * */
        MarsRover rover1 = new MarsRover(0,0, 10, 10, E);
        String roverPos1 = rover1.move(M, M, M, M);
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
        MarsRover rover1 = new MarsRover(1,2, 10, 10, N);
        String roverPos1 = rover1.move(L, M, L, M, L, M, M);

        MarsRover rover2 = new MarsRover(1,2, 10, 10, N);
        String roverPos2 = rover2.move(L, M, L, M, L, M, M);
        assertEquals(roverPos1, roverPos2);
    }

    @Test
    public void driveNorthTest() {
        MarsRover rover = new MarsRover(1,1, 10, 10, N);
        String northPos = rover.move(M);
        assertEquals(northPos, "1 2 N");
    }

    @Test
    public void driveEastTest() {
        MarsRover rover = new MarsRover(1,1, 10, 10, E);
        String northPos = rover.move(M);
        assertEquals(northPos, "2 1 E");
    }

    @Test
    public void driveSouthTest() {
        MarsRover rover = new MarsRover(1,1, 10, 10, S);
        String northPos = rover.move(M);
        assertEquals(northPos, "1 0 S");
    }

    @Test
    public void driveWestTest() {
        MarsRover rover = new MarsRover(1,1, 10, 10, W);
        String northPos = rover.move(M);
        assertEquals(northPos, "0 1 W");
    }

    @Test
    public void positionOutputStyleTest() {
        Pattern outputPattern = Pattern.compile("\\d \\d [NESW]");

        MarsRover rover = new MarsRover(1,2, 10, 10, N);
        String roverPosition = rover.move(L, M, L, M, L, M, L, M, M);
        Matcher positionMatcher = outputPattern.matcher(roverPosition);
        assertTrue(positionMatcher.matches());
    }

    // endregion

    @Test
    public void roverCreateTest() {
        String move = new MarsRover(2, 2, 10, 10, N).move(M, M);
        assertEquals("2 4 N", move);
    }

    @Test
    public void createFieldTest() {
        MarsRover rover = new MarsRover(0, 0, 10, 10, E);
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                rover.move(M);
            }
            if (j%2 == 0) {
                rover.move(L, M, L);
            } else {
                rover.move(R, M, R);
            }
        }
        for (int i = 0; i < 9; i++) {
            rover.move(M);
        }
        assertEquals("10 10 E", rover.move(M));
    }
}