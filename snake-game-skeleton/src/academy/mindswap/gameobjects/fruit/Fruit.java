package academy.mindswap.gameobjects.fruit;

import academy.mindswap.field.Field;
import academy.mindswap.field.Position;

public class Fruit {

    Position position;

    public Fruit() {
        this.position = new Position(randomGenerator(1, Field.getWidth()-1),randomGenerator(1, Field.getHeight()-1));
    }

    public Position getPosition() {
        return position;
    }

    private int randomGenerator(int max, int min){
        return (int) (Math.random() * (max - min + 1) + min);

    }
}
