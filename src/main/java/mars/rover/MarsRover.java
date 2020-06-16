package mars.rover;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.Function;

public class MarsRover {

    public static String move(int x, int y, Direction direction, Instruction... instructions) {

        LinkedList<Instruction> instructionList = new LinkedList<>(Arrays.asList(instructions));

        if (!instructionList.isEmpty()) {
            Instruction instruction = instructionList.pop();
            Direction nextDirection = instruction.getNextDirection(direction);

            if(instruction.isMove()) {
                if(nextDirection.isHorizontal()) {
                    x += direction.getNumericalValue();
                } else {
                    y += direction.getNumericalValue();
                }
            }

            return move(x, y, nextDirection, instructionList.toArray(new Instruction[]{}));
        }

        return String.format("%d %d %s", x, y, direction);

    }

}

enum Direction {

    N(1, 'W', 'E', false),
    E(1, 'N', 'S', true),
    S(-1, 'E', 'W', false),
    W(-1, 'S', 'N', true);

    final private int numericalValue;
    final private char left;
    final private char right;
    final private boolean horizontal;

    Direction(int numericalValue, char left, char right, boolean horizontal) {
        this.numericalValue = numericalValue;
        this.left = left;
        this.right = right;
        this.horizontal = horizontal;
    }

    // region Getters

    public char getLeft() {
        return left;
    }

    public char getRight() {
        return right;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public int getNumericalValue() {
        return numericalValue;
    }

    // endregion

}

enum Instruction {

    M(direction -> direction),
    L(direction -> Direction.valueOf(direction.getLeft() + "")),
    R(direction -> Direction.valueOf(direction.getRight() + ""));

    final Function<Direction, Direction> changeDirection;

    Instruction (Function<Direction, Direction> changeDirection) {
        this.changeDirection = changeDirection;
    }

    public Direction getNextDirection(Direction direction) {
        return this.changeDirection.apply(direction);
    }

    public boolean isMove() {
        return this.equals(M);
    }
}