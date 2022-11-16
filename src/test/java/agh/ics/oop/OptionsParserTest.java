package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static agh.ics.oop.OptionsParser.parse;
import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void parseTest() {
        String[] arguments = {"f","r","b","l","b","left","right","backward","forward","for","back","bi","ri","test"," ",""};
        MoveDirection[] moveDirections = {MoveDirection.FORWARD,MoveDirection.RIGHT,MoveDirection.BACKWARD,MoveDirection.LEFT,MoveDirection.BACKWARD,MoveDirection.LEFT,MoveDirection.RIGHT,MoveDirection.BACKWARD,MoveDirection.FORWARD};
        List<MoveDirection> goodDirections = Arrays.asList(moveDirections);
        MoveDirection[] directions = parse(arguments);
        assertEquals(goodDirections,directions);
    }
}