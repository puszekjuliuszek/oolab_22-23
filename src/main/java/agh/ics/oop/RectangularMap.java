package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements IWorldMap {
    private final Vector2d mapLowerLeft;
    private final Vector2d mapUpperRight;
    private final Map<Vector2d, Object> map;
    private final MapVisualizer mapVisualizer;

    public RectangularMap(int width, int height, int leftX, int leftY) {
        this.mapUpperRight = new Vector2d(width + leftX, height + leftY);
        this.mapLowerLeft = new Vector2d(leftX, leftY);
        this.map = new HashMap<>();
        this.mapVisualizer = new MapVisualizer(this);
    }

    public RectangularMap(int mapWidth, int mapHeight) {
        this(mapWidth, mapHeight, 0, 0);
    }

    @Override
    public String toString() {
        return mapVisualizer.draw(mapLowerLeft, mapUpperRight);
    }

    public boolean canMoveTo(Vector2d position) {
        return (mapLowerLeft.equals(mapLowerLeft.lowerLeft(position))
                && mapUpperRight.equals(mapUpperRight.upperRight(position))
                && !map.containsKey(position));
    }

    private Vector2d getKey(Animal animal){
        for (Vector2d key : map.keySet()) {
            if(map.get(key).equals(animal)){
                return key;
            }
        }
        return null;
    }

    public boolean place(Animal animal) {
        if (!isOccupied(animal.getPosition())) {
            if (getKey(animal) != null){
                map.remove(getKey(animal));
            }
            map.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

    public boolean isOccupied(Vector2d position) {
        return (mapLowerLeft.equals(mapLowerLeft.lowerLeft(position))
                && mapUpperRight.equals(mapUpperRight.upperRight(position))
                && map.containsKey(position));
    }

    public Object objectAt(Vector2d position) {
        return map.get(position);
    }
}
