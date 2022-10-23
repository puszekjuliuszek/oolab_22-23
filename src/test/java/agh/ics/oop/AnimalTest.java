package agh.ics.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static agh.ics.oop.OptionsParser.parse;
import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    Animal animal;

    @BeforeEach
    void setUp() {
        animal = new Animal();
    }

    @Test
    void moveTest() {
        String[] args = {"f", "r", "b", "l", "b", "left", "right", "backward", "forward", "for", "back", "bi", "ri", "test", " ", ""};
        List<MoveDirection> directions = parse(args);
        for (MoveDirection direction : directions) {
            animal.move(direction);
        }
        assertAll(
                () -> assertEquals(MapDirections.NORTH, animal.getDirection()),
                () -> assertTrue(animal.isAt(new Vector2d(1, 2)))
        );
    }

    @Test
    void goingOutMap() {
        // given
        String[] args1 = {"f", "f", "f", "f", "f", "f", "f", "f", "f"};
        String[] args2 = {"b", "b", "b", "b", "b", "b", "b", "b", "b"};
        String[] args3 = {"r", "f", "f", "f", "f", "f", "f", "f", "f"};
        String[] args4 = {"l", "f", "f", "f", "f", "f", "f", "f", "f"};
        List<MoveDirection> directions1 = parse(args1);
        List<MoveDirection> directions2 = parse(args2);
        List<MoveDirection> directions3 = parse(args3);
        List<MoveDirection> directions4 = parse(args4);
        Animal animal2 = new Animal();
        Animal animal3 = new Animal();
        Animal animal4 = new Animal();

        //when
        for (MoveDirection direction : directions1) {
            animal.move(direction);
        }
        for (MoveDirection direction : directions2) {
            animal2.move(direction);
        }
        for (MoveDirection direction : directions3) {
            animal3.move(direction);
        }
        for (MoveDirection direction : directions4) {
            animal4.move(direction);
        }
        //then
        assertAll(
                () -> assertEquals(new Vector2d(2, 4), animal.getPosition()),
                () -> assertEquals(new Vector2d(2, 0), animal2.getPosition()),
                () -> assertEquals(new Vector2d(4, 2), animal3.getPosition()),
                () -> assertEquals(new Vector2d(0, 2), animal4.getPosition())
        );

    }
    @Test
    void orientationTest(){
        List<MapDirections> orientations = new ArrayList<>();
        MapDirections[] answer = {MapDirections.NORTH,MapDirections.EAST,MapDirections.SOUTH,MapDirections.WEST,MapDirections.NORTH,MapDirections.NORTH,MapDirections.WEST,MapDirections.SOUTH,MapDirections.EAST,MapDirections.NORTH};
        for(int i=0;i<5;++i) {
            orientations.add(animal.getDirection());
            animal.move(MoveDirection.RIGHT);
        }
        for(int i=0;i<5;++i){
            animal.move(MoveDirection.LEFT);
            orientations.add(animal.getDirection());
        }
        assertEquals(Arrays.asList(answer),orientations);
    }


}