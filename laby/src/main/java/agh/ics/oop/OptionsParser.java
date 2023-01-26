package agh.ics.oop;


import java.util.Arrays;
import java.util.Objects;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args) throws IllegalArgumentException{
        return Arrays.stream(args)
                .map(instruction -> switch (instruction) {
                    case "forward", "f" -> MoveDirection.FORWARD;
                    case "backward", "b" -> MoveDirection.BACKWARD;
                    case "right", "r" -> MoveDirection.RIGHT;
                    case "left", "l" -> MoveDirection.LEFT;
                    default -> throw new IllegalArgumentException(instruction + " is not legal move specification");
                })
                .toArray(MoveDirection[]::new);

    }
}
