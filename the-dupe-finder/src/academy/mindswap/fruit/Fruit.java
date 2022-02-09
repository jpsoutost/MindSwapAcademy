package academy.mindswap.fruit;

import academy.mindswap.util.Messages;

import java.util.Objects;

public abstract class Fruit {
    int acidity;

    public Fruit(int acidity) {
        this.acidity = acidity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fruit)) return false;
        Fruit fruit = (Fruit) o;
        return (getClass().equals(fruit.getClass()) && acidity == fruit.acidity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass(),acidity);
    }

    @Override
    public String toString(){
        return this.getClass().toString().substring(29).toUpperCase() + Messages.ACIDITY + this.acidity;
    }
}

