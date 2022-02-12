package academy.mindswap;

import academy.mindswap.field.Field;
import academy.mindswap.field.Position;
import academy.mindswap.gameobjects.fruit.Fruit;
import academy.mindswap.gameobjects.snake.Direction;
import academy.mindswap.gameobjects.snake.Snake;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.LinkedList;
import java.util.List;


public class Game {

    private Snake snake;
    private Fruit fruit;
    private int delay;
    private int score;

    public Game(int cols, int rows, int delay) {
        Field.init(cols, rows);
        updateScore();
        snake = new Snake();
        this.delay = delay;
        this.score=0;
    }

    public void start() throws InterruptedException {

        generateFruit();
        Field.score(this.score);

        while (snake.isAlive()) {
            if( this.snake.getDirection().equals(Direction.DOWN)|| this.snake.getDirection().equals(Direction.UP)){
                Thread.sleep((long) (delay*2));
            }else {
                Thread.sleep(delay);
            }
            Field.clearTail(snake);
            moveSnake();
            checkCollisions();
            Field.drawSnake(snake);
        }

        while (true) {
            gameOver();
        }

    }

    private void generateFruit() {
        this.fruit = new Fruit();
        Field.drawFruit(fruit);
    }

    private void moveSnake() {

        Key k = Field.readInput();

        if (k != null) {
            switch (k.getKind()) {
                case ArrowUp:
                    if (snake.getDirection().equals(Direction.DOWN)) {
                        snake.move();
                        return;
                    }
                    snake.move(Direction.UP);
                    return;

                case ArrowDown:
                    if (snake.getDirection().equals(Direction.UP)){
                        snake.move();
                        return;
                    }
                    snake.move(Direction.DOWN);
                    return;

                case ArrowLeft:
                    if (snake.getDirection().equals(Direction.RIGHT)){
                        snake.move();
                        return;
                    }
                    snake.move(Direction.LEFT);
                    return;

                case ArrowRight:
                    if (snake.getDirection().equals(Direction.LEFT)){
                        snake.move();
                        return;
                    }
                    snake.move(Direction.RIGHT);
                    return;
            }
        }
        snake.move();
    }

    private void checkCollisions() {
        if(this.snake.getFullSnake().stream().skip(1).anyMatch(position-> position.equals(this.snake.getHead()))){
            this.snake.die();
            return;
        }
        if(snake.getHead().equals(fruit.getPosition())){
            generateFruit();
            snake.increaseSize();
            this.delay = Math.max(0, delay-1);
            updateScore();
            return;
        }
        if(snake.getHead().getCol() == 0 || snake.getHead().getCol() == Field.getWidth()-1){
            this.snake.die();
            return;
        }
        if(snake.getHead().getRow() == 0 || snake.getHead().getRow() == Field.getHeight()-1){
            this.snake.die();
        }
    }
    private void updateScore(){
        score++;
        Field.score(this.score);
    }

    private void gameOver() throws InterruptedException {
        Field.drawGameOver(Terminal.Color.BLUE);
        Thread.sleep(1000);
        Field.drawGameOver(Terminal.Color.YELLOW);
        Thread.sleep(1000);
        Field.drawGameOver(Terminal.Color.MAGENTA);
        Thread.sleep(1000);
        Field.drawGameOver(Terminal.Color.RED);
        Thread.sleep(1000);
    }

}
