package agh.ics.oop;

public class SimulationEngine implements IEngine{
    private final MoveDirection[] directions;
    private final IWorldMap map;
    private final Vector2d[] positions;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions) {
        this.directions = directions;
        this.map = map;
        this.positions = positions;

        for (Vector2d position : positions) {
            map.place(new Animal(map, position));
        }
    }

    public Animal getAnimal(int i) {
        return (Animal) map.objectAt(positions[i]);
    }

    public void run(){
        int i = 0;
        for(MoveDirection direction : directions){
            Animal currentAnimal = (Animal) map.objectAt(positions[i%positions.length]);
            currentAnimal.move(direction);
            positions[i%positions.length]=currentAnimal.getPosition();
            i+= 1;
        }
        System.out.println(map);
    }
}