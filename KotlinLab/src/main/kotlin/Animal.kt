package ooplab

import java.util.*

class Animal (var position: Vector2d, var direction: MapDirections, private var map: IWorldMap) {



    override fun toString(): String = when (direction) {
        MapDirections.EAST -> "E"
        MapDirections.WEST -> "W"
        MapDirections.NORTH -> "N"
        MapDirections.SOUTH -> "S"
        else -> ""
    }



    fun isAt(position: Vector2d?): Boolean {
        return position == position
    }

    fun move(direction: MoveDirection) {
        when (direction) {
            MoveDirection.RIGHT -> this.direction = this.direction.next()
            MoveDirection.LEFT -> this.direction = this.direction.previous()
            else -> {
                var directionVector: Vector2d = this.direction.toUnitVector()
                if (direction === MoveDirection.BACKWARD) {
                    directionVector = directionVector.opposite()
                }
                val newLocation: Vector2d = position.add(directionVector)
                if (map.canMoveTo(newLocation)) {
                    position = newLocation
                }
            }
        }
    }


}