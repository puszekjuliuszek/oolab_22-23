package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static agh.ics.oop.OptionsParser.parse;
import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void badParseTest() {
        OptionsParser parser = new OptionsParser();
        String[] arguments = {"f", "r", "b", "l", "b", "left", "right", "backward", "forward", "for", "back", "bi", "ri", "test", " ", ""};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            parser.parse(arguments);
        });
        assertEquals("for" + " is not legal move specification", exception.getMessage());


    }

    @Test
    void goodParseTest() {
        String[] arguments = {"f", "r", "b", "l", "b", "left", "right", "backward", "forward"};
        MoveDirection[] goodDirections = {MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.FORWARD};
        MoveDirection[] directions = parse(arguments);
        assertArrayEquals(directions, goodDirections);
    }
}
