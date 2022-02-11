package academy.mindswap.gameobjects.snake;

import academy.mindswap.field.Position;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Snake {

    private final static int SNAKE_INITIAL_SIZE = 3;
    private Direction direction;
    private boolean alive;
    private LinkedList<Position> fullSnake;

    public Snake() {
        this.direction = Direction.UP;
        this.alive = true;
        this.fullSnake = new LinkedList<>();
        fullSnake.add(new Position(50,12));
        fullSnake.add(new Position(50,13));
        fullSnake.add(new Position(50,14));
    }

    public void increaseSize() {

        int rowResult = fullSnake.get(fullSnake.size()-2).getRow() - getTail().getRow();
        int colResult = fullSnake.get(fullSnake.size()-2).getCol() - getTail().getCol();

        Position newPosition = new Position(getTail().getCol()+colResult,getTail().getRow()+rowResult);
        this.fullSnake.add(newPosition);

    }

    public void move(Direction direction) {
        this.direction=direction;

        fullSnake.addFirst(new Position(getHead().getCol()+direction.getCol(), getHead().getRow()+ direction.getRow()));
        fullSnake.removeLast();

    }

    public void move(){
        move(direction);
    }

    public void die() {
        alive = false;
    }

    public boolean isAlive() {
        return alive;
    }

    public Position getHead() {
        return fullSnake.get(0);
    }

    public Position getTail() {
        return fullSnake.get(fullSnake.size()-1);
    }

    public LinkedList<Position> getFullSnake(){
        return this.fullSnake;
    }

    public int getSnakeSize() {
        return fullSnake.size();
    }

    public Direction getDirection() {
        return direction;
    }
}

