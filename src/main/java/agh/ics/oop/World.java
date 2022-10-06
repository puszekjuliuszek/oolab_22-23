package agh.ics.oop;

public class World {
    public static void run(String[] directions) {
        System.out.println("Zwierz idzie do prozdu");
        String joinedDirections = String.join(", ", directions);
        System.out.print("\n" + joinedDirections);
        System.out.println();

        for (String direction: directions){
            String text = switch (direction){
                case "f" -> "zwierzak do przodu";
                case "b" -> "zwierzak do tyłu";
                case "l" -> "zwierzak w lewo";
                case "r" -> "zwierzak w prawo";
                default -> null;
            };
            System.out.println(text);
        }

    }

    public static void main(String[] args) {
        System.out.println("System startuje");
        run(args);
        System.out.println("\n" + "System zakończył działanie");
    }
}

