package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap {

    private Vector2d mapLowerLeft;
    private Vector2d mapUpperRight;

    public RectangularMap(int width, int height, int leftX, int leftY) {
        super();
        this.mapLowerLeft = new Vector2d(leftX, leftY);
        this.mapUpperRight = new Vector2d(leftX + width, leftY + height);

    }

    public RectangularMap(int mapWidth, int mapHeight) {
        this(mapWidth, mapHeight, 0, 0);
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
                && super.isOccupied(position));
    }


    protected Vector2d getMapLowerLeft() {
        return this.mapLowerLeft;
    }

    protected Vector2d getMapUpperRight() {
        return this.mapUpperRight;
    }
}
