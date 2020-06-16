package mars.rover;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.Function;

public class MarsRover {

    private final Point pos;
    private final Point drivingRange;
    private Direction direction;

    public MarsRover(int posX, int posY, int rangeX, int rangeY, Direction direction) {
        this.direction = direction;
        this.pos = new Point(posX, posY);
        this.drivingRange = new Point(rangeX, rangeY);
    }

    public MarsRover(Point pos, Point range, Direction direction) {
        this.pos = pos;
        this.drivingRange = range;
        this.direction = direction;
    }

    public String move(Instruction... instructions) {

        LinkedList<Instruction> instructionList = new LinkedList<>(Arrays.asList(instructions));

        if(instructionList.isEmpty()) return String.format("%d %d %s", this.pos.x, this.pos.y, direction);

        Instruction instruction = instructionList.pop();
        this.direction = instruction.getNextDirection(direction);

        if(instruction.isMove()) this.pos.translate(direction.getVectorValue().x, direction.getVectorValue().y);

        return move(instructionList.toArray(new Instruction[]{}));

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