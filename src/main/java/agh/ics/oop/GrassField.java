package agh.ics.oop;

import java.lang.Math;
import java.util.HashMap;
import java.util.Map;

public class GrassField extends AbstractWorldMap {
    private final Map<Vector2d, Grass> grassMap = new HashMap<>();

    public GrassField(int amountOfGrass) {
        super(new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE),new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE));
        placeGrass(amountOfGrass);
        updateMapSize();
    }

    private void placeGrass(int amount){
        Vector2d grassPosition = getRandomVector2d(0, (int) Math.sqrt(10*amount));
        for(int i=0;i<amount;++i){
            while(!placeGrassOnCoordinates(grassPosition)){
                grassPosition=getRandomVector2d(0, (int) Math.sqrt(10*amount));
            }
        }
    }

    public boolean placeGrassOnCoordinates(Vector2d grassPosition){
        if(!isOccupiedByGrass(grassPosition)){
            grassMap.put(grassPosition,new Grass(grassPosition));
            return true;
        }
        return false;
    }

    private void updateMapSize(){
        for (Vector2d position : grassMap.keySet()) {
            mapLowerLeft = mapLowerLeft.lowerLeft(position);
            mapUpperRight = mapUpperRight.upperRight(position);
        }
        for (Vector2d position : animalMap.keySet()) {
            mapLowerLeft = mapLowerLeft.lowerLeft(position);
            mapUpperRight = mapUpperRight.upperRight(position);
        }
    }

    private int getRandomInt(int min, int max) {
        return (min + (int) (Math.random() * ((max - min) + 1)));
    }

    private Vector2d getRandomVector2d(int min, int max) {
        return new Vector2d(getRandomInt(min, max), getRandomInt(min, max));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !animalMap.containsKey(position);
    }

    @Override
    public String toString() {
        return mapVisualizer.draw(mapLowerLeft, mapUpperRight);
    }

    public boolean place(Animal animal) {
        if (!isOccupiedByAnimal(animal.getPosition())) {
            if (getKey(animal) != null) {
                animalMap.remove(getKey(animal));
            }
            animalMap.put(animal.getPosition(), animal);
            updateMapSize();
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position){
        return (isOccupiedByGrass(position)  || isOccupiedByAnimal(position));
    }

    public boolean isOccupiedByGrass(Vector2d position) {
        return (grassMap.containsKey(position));
    }

    public boolean isOccupiedByAnimal(Vector2d position) {
        return (animalMap.containsKey(position));
    }

    @Override
    public Object objectAt(Vector2d position) {
        if(animalMap.get(position)==null){
            return grassMap.get(position);
        }
        return animalMap.get(position);
    }
    public boolean isGrass(Vector2d position){
        return grassMap.containsKey(position);
    }
    public void eatGrass(Vector2d position){
        grassMap.remove(position);
        placeGrass(1);
    }
}
