package agh.ics.oop;

public enum MapDirections {
    NORTH,
    SOUTH,
    WEST,
    EAST,
    NONE;

    @Override
    public String toString() {
        return switch (this){
            case NORTH -> "Północ";
            case SOUTH -> "Południe";
            case WEST -> "Zachód";
            case EAST -> "Wschód";
            default -> "Brak kieunku";
        };
    }

    public MapDirections next(){
        return switch (this){
            case NORTH -> EAST;
            case SOUTH -> WEST;
            case WEST -> NORTH;
            case EAST -> SOUTH;
            default -> NONE;
        };
    }

    public MapDirections previous(){
        return switch (this){
            case NORTH -> WEST;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
            case EAST -> NORTH;
            default -> NONE;
        };
    }
    public Vector2d toUnitVector(){
        return switch (this){
            case NORTH -> new Vector2d(0,1);
            case SOUTH -> new Vector2d(0,-1);
            case WEST -> new Vector2d(-1,0);
            case EAST -> new Vector2d(1,0);
            default -> new Vector2d(0,0);
        };
    }

}
