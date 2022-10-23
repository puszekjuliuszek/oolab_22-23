package agh.ics.oop;

public class Animal {
    private MapDirections direction;
    private Vector2d position;

    public Animal() {
        this.direction = MapDirections.NORTH;
        this.position = new Vector2d(2, 2);
    }

    public Vector2d getPosition() {
        return position;
    }

    public MapDirections getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "Zwierz ma:" + "\n" +
                "    kierunek = " + direction + "\n" +
                "    położenie = " + position;
    }

    public boolean isAt(Vector2d position) {
        return position.equals(this.position);
    }

    private boolean canMoveForward() {
        return ((this.direction == MapDirections.NORTH) && (this.position.getY() < 4)) ||
                ((this.direction == MapDirections.EAST) && (this.position.getX() < 4)) ||
                ((this.direction == MapDirections.SOUTH) && (this.position.getY() > 0)) ||
                ((this.direction == MapDirections.WEST) && (this.position.getX() > 0));
    }

    private boolean canMoveBackward() {
        return ((this.direction == MapDirections.NORTH) && (this.position.getY() > 0)) ||
                ((this.direction == MapDirections.EAST) && (this.position.getX() > 0)) ||
                ((this.direction == MapDirections.SOUTH) && (this.position.getY() < 4)) ||
                ((this.direction == MapDirections.WEST) && (this.position.getX() < 4));
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case FORWARD -> {
                if (canMoveForward()) {
                    position = position.add(this.direction.toUnitVector());
                }
            }
            case BACKWARD -> {
                if (canMoveBackward()) {
                    position = position.substract(this.direction.toUnitVector());
                }
            }
            case LEFT -> this.direction = this.direction.previous();
            case RIGHT -> this.direction = this.direction.next();
            case NONE -> {}
        }
    }
}
