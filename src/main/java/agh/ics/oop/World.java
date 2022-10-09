package agh.ics.oop;

public class World {

    public static void run(Directions[] directions) {
        //String joinedDirections = String.join(", ", directions);
        //System.out.print("\n" + joinedDirections);
        //System.out.println();

        for (Directions direction : directions) {
            String text = switch (direction) {
                case FORWARD -> "zwierzak do przodu";
                case BACKWARD -> "zwierzak do tyłu";
                case LEFT -> "zwierzak w lewo";
                case RIGHT -> "zwierzak w prawo";
            };
            System.out.println(text);
        }

    }

    public static Directions[] change(String[] args) {
        int n = args.length;
        Directions[] directions = new Directions[n];
        for (int i = 0; i < n; i++) {
            Directions move = switch (args[i]) {
                case "f" -> Directions.FORWARD;
                case "b" -> Directions.BACKWARD;
                case "l" -> Directions.LEFT;
                case "r" -> Directions.RIGHT;
                default -> null;
            };
            directions[i] = move;
        }
        return directions;
    }

//    public static Directions[] change2(String[] args) {
//        int n = args.length;
//        Directions[] directions = new Directions[n];
//        for (int i = 0; i < n; i++) {
//            Directions move = switch (args[i]) {
//                case "f" -> Directions.FORWARD;
//                case "b" -> Directions.BACKWARD;
//                case "l" -> Directions.LEFT;
//                case "r" -> Directions.RIGHT;
//                default -> null;
//            };
//            directions[i] = move;
//        }
//
//        args.stream().forEach((k) ->{
//            inCase
//        });
//        return directions;
//    }

    public static void main(String[] args) {
        System.out.println("System startuje");
        Directions[] directions = change(args);
        //Directions[] directions = change2(args);
        run(directions);
        System.out.println("System zakończył działanie");
    }
}

