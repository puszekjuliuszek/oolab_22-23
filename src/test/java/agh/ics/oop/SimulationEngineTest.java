package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SimulationEngineTest {

    @Test
    void run() {
        //given
        String[][] directions = {{"f", "b"}, {"r", "l"},
                {"r", "l", "f", "f"}, {"r", "r"},
                {"r", "l", "r", "r", "f", "f"},
                {"r", "l", "r", "r", "f", "f"},
                {"r", "l", "r", "r", "f", "f"},
                {"r", "l", "r", "r", "f", "f"}};
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};

        //when
        Vector2d[] sol = {new Vector2d(2, 2), new Vector2d(3, 4),
                new Vector2d(2, 3), new Vector2d(3, 3),
                new Vector2d(2, 3), new Vector2d(3, 3),
                new Vector2d(2, 3), new Vector2d(3, 3),
                new Vector2d(2, 3), new Vector2d(3, 3),
                new Vector2d(2, 2), new Vector2d(3, 4),
                new Vector2d(2, 1), new Vector2d(3, 5),
                new Vector2d(2, 0), new Vector2d(3, 5),
                new Vector2d(2, 0), new Vector2d(3, 5)};

        Vector2d[] prog = new Vector2d[18];
        for (int i = 0; i < directions.length; i += 1) {
            SimulationEngine engine = new SimulationEngine(
                    OptionsParser.parse(directions[i]),
                    new RectangularMap(10, 5),
                    positions);
            if (i == 0) {
                prog[i] = engine.getAnimal(0).getPosition();
                prog[i + 1] = engine.getAnimal(1).getPosition();
            }
            engine.run();
            prog[2* i + 2] = engine.getAnimal(0).getPosition();
            prog[2* i + 3] = engine.getAnimal(1).getPosition();
        }

        //then
        assertTrue(Arrays.equals(prog, sol));
    }
}