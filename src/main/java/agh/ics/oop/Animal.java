package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Animal extends AbstractWorldMapElement {
    private MapDirections direction;
    private IWorldMap map;
    private List<IPositionChangeObserver> observers = new ArrayList<>();

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.direction = MapDirections.NORTH;
        this.position = initialPosition;
        this.map = map;
    }
    public Animal(IWorldMap map){
        new Animal(map,new Vector2d(2,2));
    }


    public MapDirections getDirection() {
        return direction;
    }


    @Override
    public String toString() {
        return Character.toString(direction.name().charAt(0));
    }
    public String getImagePath(){
        return toString();
    }
    public String getDesc(){
        return "Z " + position.toString();
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
            positionChanged(position, newPosition);
            position = newPosition;
        }


    }

    public void removeObserver(IPositionChangeObserver observer) {
        observers.remove(observer);
    }
    public void addObserver(IPositionChangeObserver observer) {
        observers.add(observer);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver observer : observers){
            observer.positionChanged(oldPosition, newPosition);
        }
    }
}
