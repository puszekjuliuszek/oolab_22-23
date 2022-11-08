package agh.ics.oop;


import java.util.Arrays;
import java.util.Objects;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args) {
        return Arrays.stream(args)
                .map(instruction -> switch (instruction) {
                    case "forward", "f" -> MoveDirection.FORWARD;
                    case "backward", "b" -> MoveDirection.BACKWARD;
                    case "right", "r" -> MoveDirection.RIGHT;
                    case "left", "l" -> MoveDirection.LEFT;
                    default -> null;
                })
                .filter(Objects::nonNull)
                .toArray(MoveDirection[]::new);
    }
}
