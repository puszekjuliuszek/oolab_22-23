package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected final Map<Vector2d, Animal> animalMap;
    protected final MapVisualizer mapVisualizer;
    protected MapBoundary mapBoundary = new MapBoundary();

    protected AbstractWorldMap() {
        animalMap = new HashMap<>();
        mapVisualizer = new MapVisualizer(this);
    }

    protected Vector2d getKey(Animal animal) {
        for (Vector2d key : animalMap.keySet()) {
            if (animalMap.get(key).equals(animal)) {
                return key;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return mapVisualizer.draw(this.getMapLowerLeft(), this.getMapUpperRight());
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = animalMap.get(oldPosition);
        mapBoundary.positionChanged(oldPosition,newPosition);
        animalMap.remove(oldPosition);
        animalMap.put(newPosition, animal);
    }

    @Override
    public IMapElement objectAt(Vector2d position) {
        return animalMap.get(position);
    }

    public abstract Vector2d getMapLowerLeft();

    public abstract Vector2d getMapUpperRight();

    public boolean isOccupied(Vector2d position) {
        return (animalMap.containsKey(position));
    }


    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())) {
            animalMap.put(animal.getPosition(), animal);
            animal.addObserver(this);
            animal.addObserver(this.mapBoundary);
            mapBoundary.updateMapBoundary(animal.getPosition());
            return true;
        }
        throw new IllegalArgumentException("You cannot place another animal on " + animal.getPosition());
    }
}
