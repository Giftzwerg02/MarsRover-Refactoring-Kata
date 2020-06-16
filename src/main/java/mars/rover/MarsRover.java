package mars.rover;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.Function;

public class MarsRover {

    public static String move(Point pos, Direction direction, Instruction... instructions) {

        LinkedList<Instruction> instructionList = new LinkedList<>(Arrays.asList(instructions));

        if (!instructionList.isEmpty()) {
            Instruction instruction = instructionList.pop();
            Direction nextDirection = instruction.getNextDirection(direction);

            if(instruction.isMove()) {
                pos.translate(direction.getVectorValue().x, direction.getVectorValue().y);
            }

            return move(pos, nextDirection, instructionList.toArray(new Instruction[]{}));
        }

        return String.format("%d %d %s", pos.x, pos.y, direction);

    }

}

enum Direction {

    N(new Point(0,1), 'W', 'E'),
    E(new Point(1,0), 'N', 'S'),
    S(new Point(0,-1), 'E', 'W'),
    W(new Point(-1, 0), 'S', 'N');

    final private Point vectorValue;
    final private char left;
    final private char right;

    Direction(Point vectorValue, char left, char right) {
        this.vectorValue = vectorValue;
        this.left = left;
        this.right = right;
    }

    // region Getters

    public char getLeft() {
        return left;
    }

    public char getRight() {
        return right;
    }

    public Point getVectorValue() {
        return vectorValue;
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