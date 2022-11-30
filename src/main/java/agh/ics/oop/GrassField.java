package agh.ics.oop;

import java.lang.Math;
import java.util.*;




public class GrassField extends AbstractWorldMap {
    private final Map<Vector2d, Grass> grassMap = new HashMap<>();

    public GrassField(int amountOfGrass) {
        super();
        placeInitGrass(amountOfGrass);
    }

    private void placeInitGrass(int amount) {
        ArrayList<Vector2d> grassPositions = new ArrayList<>();
        int bound = (int) Math.sqrt(10 * amount);
        for (int i = 0; i < bound; i++) {
            for (int j = 0; j < bound; j++) {
                grassPositions.add(new Vector2d(i, j));
            }
        }

        Random random = new Random();
        for (int i = 0; i < amount; ++i) {
            int randomIndex = random.nextInt(grassPositions.size() - 0) + 0;
            Vector2d grassPosition = grassPositions.get(randomIndex);
            grassMap.put(grassPosition, new Grass(grassPosition));
            grassPositions.remove(grassPosition);
        }

    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        return !animalMap.containsKey(position);
    }


    @Override
    public boolean isOccupied(Vector2d position) {
        return (isOccupiedByGrass(position) || super.isOccupied(position));
    }

    public boolean isOccupiedByGrass(Vector2d position) {
        return (grassMap.containsKey(position));
    }


    @Override
    public Object objectAt(Vector2d position) {
        if (super.objectAt(position) == null) {
            return grassMap.get(position);
        }
        return super.objectAt(position);
    }

    protected Vector2d getMapLowerLeft() {
        Vector2d mapLowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (Vector2d position : grassMap.keySet()) {
            mapLowerLeft = mapLowerLeft.lowerLeft(position);
        }
        for (Vector2d position : animalMap.keySet()) {
            mapLowerLeft = mapLowerLeft.lowerLeft(position);
        }
        return mapLowerLeft;
    }

    protected Vector2d getMapUpperRight() {
        Vector2d mapUpperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for (Vector2d position : grassMap.keySet()) {
            mapUpperRight = mapUpperRight.upperRight(position);
        }
        for (Vector2d position : animalMap.keySet()) {
            mapUpperRight = mapUpperRight.upperRight(position);
        }
        return mapUpperRight;
    }

    public boolean isGrass(Vector2d position) {
        return grassMap.containsKey(position);
    }

    public void eatGrass(Vector2d position) {
        grassMap.remove(position);
        placeInitGrass(1);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        super.positionChanged(oldPosition,newPosition);
        if(isGrass(newPosition)){
            eatGrass(newPosition);
        }
    }
}
