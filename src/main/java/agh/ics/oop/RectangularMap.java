package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap {

    public RectangularMap(int width, int height, int leftX, int leftY) {
        super(new Vector2d(leftX+width,leftY+height),new Vector2d(leftX,leftY));
    }

    public RectangularMap(int mapWidth, int mapHeight) {
        this(mapWidth, mapHeight, 0, 0);
    }

    @Override
    public String toString() {
        return mapVisualizer.draw(mapLowerLeft, mapUpperRight);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (mapLowerLeft.equals(mapLowerLeft.lowerLeft(position))
                && mapUpperRight.equals(mapUpperRight.upperRight(position))
                && !animalMap.containsKey(position));
    }



    @Override
    public boolean isOccupied(Vector2d position) {
        return (mapLowerLeft.equals(mapLowerLeft.lowerLeft(position))
                && mapUpperRight.equals(mapUpperRight.upperRight(position))
                && animalMap.containsKey(position));
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animalMap.get(position);
    }

    public boolean place(Animal animal) {
        if (!isOccupied(animal.getPosition())) {
            if (getKey(animal) != null) {
                animalMap.remove(getKey(animal));
            }
            animalMap.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

}
