package agh.ics.oop;

import java.util.Objects;

public class Animal {
    private MapDirections direction;
    private Vector2d position;
    static IWorldMap map;

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.direction = MapDirections.NORTH;
        this.position = initialPosition;
        this.map = map;
    }
    public Animal(IWorldMap map){
        new Animal(map,new Vector2d(2,2));
    }

    public Vector2d getPosition() {
        return position;
    }

    public MapDirections getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return Character.toString(direction.name().charAt(0));
    }

    public boolean isAt(Vector2d position) {return Objects.equals(this.position, position);}

    public void move(MoveDirection direction) {
        Vector2d newPosition = position;
        switch (direction) {
            case FORWARD -> newPosition = position.add(this.direction.toUnitVector());
            case BACKWARD -> newPosition = position.substract(this.direction.toUnitVector());
            case LEFT -> this.direction = this.direction.previous();
            case RIGHT -> this.direction = this.direction.next();
            case NONE -> {}
        }
        if(map.canMoveTo(newPosition)){
            position = newPosition;
            map.place(this);
        }


    }
}
