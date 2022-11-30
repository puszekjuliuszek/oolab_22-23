package agh.ics.oop;

import static agh.ics.oop.OptionsParser.parse;

public class World {
    public static final Vector2d LOWER_BOUND = new Vector2d(0,0);
    public static final Vector2d UPPER_BOUND = new Vector2d(4,4);


    public static void main(String[] args) {
        MoveDirection[] directions = parse(args);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
    }
}

