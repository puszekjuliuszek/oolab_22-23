package agh.ics.oop;

import java.util.List;

import static agh.ics.oop.OptionsParser.parse;

public class World {

    public static void run(MoveDirection[] directions) {

        for (MoveDirection direction : directions) {
            String text = switch (direction) {
                case FORWARD -> "zwierzak do przodu";
                case BACKWARD -> "zwierzak do tyłu";
                case LEFT -> "zwierzak w lewo";
                case RIGHT -> "zwierzak w prawo";
                case NONE -> null;
            };
            System.out.println(text);
        }
    }

    public static MoveDirection[] change(String[] args) {
        int n = args.length;
        MoveDirection[] directions = new MoveDirection[n];
        for (int i = 0; i < n; i++) {
            MoveDirection move = switch (args[i]) {
                case "f" -> MoveDirection.FORWARD;
                case "b" -> MoveDirection.BACKWARD;
                case "l" -> MoveDirection.LEFT;
                case "r" -> MoveDirection.RIGHT;
                default -> MoveDirection.NONE;
            };
            directions[i] = move;
        }
        return directions;
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println(animal.toString());
        List<MoveDirection> directions = parse(args);
        for(MoveDirection direction : directions){
            animal.move(direction);
        }
        System.out.println(animal);
    }
}

