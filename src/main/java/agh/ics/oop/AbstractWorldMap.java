package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap {
    protected final Map<Vector2d, Animal> animalMap;
    protected Vector2d mapLowerLeft;
    protected Vector2d mapUpperRight;
    protected final MapVisualizer mapVisualizer;

    protected AbstractWorldMap(Vector2d rightTop,Vector2d leftBottom) {
        mapUpperRight = rightTop;
        mapLowerLeft = leftBottom;
        animalMap = new HashMap<>();
        mapVisualizer = new MapVisualizer(this);
    }

    protected Vector2d getKey(Animal animal){
        for (Vector2d key : animalMap.keySet()) {
            if(animalMap.get(key).equals(animal)){
                return key;
            }
        }
        return null;
    }

    public abstract Object objectAt(Vector2d position);
}
