package agh.ics.oop;

public class SimulationEngine implements IEngine, Runnable {
    private final MoveDirection[] directions;
    private final IWorldMap map;
    private final Vector2d[] positions;
    private int moveDelay;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions) {
        this.directions = directions;
        this.map = map;
        this.positions = positions;

        for (Vector2d position : positions) {
            map.place(new Animal(map, position));
            if(map.isGrass(position)){
                ((GrassField)map).eatGrass(position);
            }
        }
    }

    public SimulationEngine(MoveDirection[] moveDirections, IWorldMap map, Vector2d[] animalsVectors, int moveDelay){
        this(moveDirections, map, animalsVectors);
        this.moveDelay = moveDelay;
    }

    public Animal getAnimal(int i) {
        return (Animal) map.objectAt(positions[i]);
    }

    @Override
    public void run() {

        System.out.println();

        int i = 0;
        int n = positions.length;
        System.out.println(map);
        for (MoveDirection direction : directions) {
            Animal currentAnimal = (Animal) map.objectAt(positions[i % n]);
            if(currentAnimal != null) {
                currentAnimal.move(direction);
                positions[i % n] = currentAnimal.getPosition();
                i += 1;
            }
            System.out.println(map);
            try{
                Thread.sleep(moveDelay);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}