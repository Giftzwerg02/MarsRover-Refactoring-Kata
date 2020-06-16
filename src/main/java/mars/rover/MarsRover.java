package mars.rover;

public class MarsRover {

    public static String move(int x, int y, char direction, String instructions) {
        if (!instructions.isEmpty()) {
            char instruction = instructions.charAt(0);
            if (instruction == 'L') {
                if (direction == 'N') {
                    return move(x, y, 'W', instructions.substring(1));
                } else if (direction == 'W') {
                    return move(x, y, 'S', instructions.substring(1));
                } else if (direction == 'S') {
                    return move(x, y, 'E', instructions.substring(1));
                } else if (direction == 'E') {
                    return move(x, y, 'N', instructions.substring(1));
                }
            } else if (instruction == 'R') {
                if (direction == 'N') {
                    return move(x, y, 'E', instructions.substring(1));
                } else if (direction == 'W') {
                    return move(x, y, 'N', instructions.substring(1));
                } else if (direction == 'S') {
                    return move(x, y, 'W', instructions.substring(1));
                } else if (direction == 'E') {
                    return move(x, y, 'S', instructions.substring(1));
                }
            } else if (instruction == 'M') {
                if (direction == 'N') {
                    return move(x, y + 1, 'N', instructions.substring(1));
                } else if (direction == 'S') {
                    return move(x, y - 1, 'S', instructions.substring(1));
                } else if (direction == 'W') {
                    return move(x - 1, y, 'W', instructions.substring(1));
                } else if (direction == 'E') {
                    return move(x + 1, y, 'E', instructions.substring(1));
                }
            }
        }
        return String.format("%d %d %s", x, y, direction);
    }
}

enum Direction {

    NORTH('N', Direction.WEST, Direction.EAST),
    EAST('E', Direction.NORTH, Direction.SOUTH),
    SOUTH('S', Direction.EAST, Direction.WEST),
    WEST('W', Direction.SOUTH, Direction.NORTH);

    public char value;
    public Direction left;
    public Direction right;
    Direction(char value, Direction left, Direction right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

}